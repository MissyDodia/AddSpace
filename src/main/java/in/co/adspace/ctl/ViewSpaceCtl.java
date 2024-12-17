package in.co.adspace.ctl;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.adspace.bean.SpaceBean;
import in.co.adspace.model.Model;
import in.co.adspace.model.SpaceModel;

public class ViewSpaceCtl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewSpaceCtl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("fetchImage".equals(action)) {
            fetchImage(request, response); // Fetch the image logic
        } else {
            listSpaces(request, response); // List all spaces
        }
    }

    private void listSpaces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpaceModel model = new SpaceModel();

        try {
            List<SpaceBean> list = model.list();

            if (list != null && !list.isEmpty()) {
                request.setAttribute("list", list);
            } else {
                request.setAttribute("err", "No records found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("err", "Error retrieving records: " + e.getMessage());
        }

        request.getRequestDispatcher("/jsp/ViewSpace.jsp").forward(request, response);
    }

    private void fetchImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long spaceId = Long.parseLong(request.getParameter("spaceId"));
        String imageName = request.getParameter("imageName");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Model.getCon();
            ps = con.prepareStatement("SELECT " + imageName + " FROM space WHERE id = ?");
            ps.setLong(1, spaceId);
            rs = ps.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob(imageName);
                if (blob != null) {
                    byte[] imageData = blob.getBytes(1, (int) blob.length());

                    response.setContentType("image/jpeg");
                    OutputStream out = response.getOutputStream();
                    out.write(imageData);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
