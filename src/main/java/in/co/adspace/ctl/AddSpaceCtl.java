package in.co.adspace.ctl;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.co.adspace.bean.BaseBean;
import in.co.adspace.bean.SpaceBean;
import in.co.adspace.bean.UserBean;
import in.co.adspace.model.SpaceModel;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 15    // 15 MB
)
public class AddSpaceCtl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddSpaceCtl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/AddSpace.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SpaceBean spaceBean = new SpaceBean();
        // Handle regular form inputs
        spaceBean.setSpacename(request.getParameter("spacename"));
        spaceBean.setLocation(request.getParameter("location"));
        spaceBean.setArea(request.getParameter("area"));
        spaceBean.setType(request.getParameter("type"));
        spaceBean.setCompany(request.getParameter("company"));
        spaceBean.setDuration(request.getParameter("duration"));
        spaceBean.setPrice(request.getParameter("price"));
        BaseBean userbean = (UserBean) request.getSession().getAttribute("userbean");
        spaceBean.setAdmine_id(userbean.getId());

        // Handle file uploads
        Part image1Part = request.getPart("image1");
        Part image2Part = request.getPart("image2");
        Part image3Part = request.getPart("image3");

        // Save the image data as InputStreams in SpaceBean
        spaceBean.setImage1(image1Part.getInputStream());
        spaceBean.setImage2(image2Part.getInputStream());
        spaceBean.setImage3(image3Part.getInputStream());

        // Save space to the database
        SpaceModel spaceModel = new SpaceModel();
        long success = spaceModel.addSpace(spaceBean);

        // Send response
        if (success > 0) {
            request.setAttribute("success", "Space is added..!");
        } else {
            request.setAttribute("err", "Space is not added..!");
        }
        request.getRequestDispatcher("/jsp/AddSpace.jsp").forward(request, response);
    }
}
