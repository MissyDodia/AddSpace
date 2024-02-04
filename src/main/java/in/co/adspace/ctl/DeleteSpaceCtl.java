package in.co.adspace.ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.SpaceBean;
import in.co.adspace.model.BookingModel;
import in.co.adspace.model.SpaceModel;


/**
 * Servlet implementation class DeleteSpaceCtl
 */
public class DeleteSpaceCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSpaceCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(" space id is"+request.getParameter("spaceId"));
		    long id = Long.parseLong(request.getParameter("spaceId"));

		    SpaceModel model = new SpaceModel();

		    boolean isDeleted = model.deletespace(id);

		    if (isDeleted) {
		        request.setAttribute("success", "Space is deleted Successfully..!");

		        List<SpaceBean> list = model.list();

		        if (list != null && !list.isEmpty()) {
		            request.setAttribute("list", list);
		        } else {
		            request.setAttribute("err", "No records found");
		        }
		    } else {
		        request.setAttribute("error", "Space deletion failed.");
		    }
		} catch (Exception e) {
		    // Handle exception
		}

		request.getRequestDispatcher("/jsp/ViewSpace.jsp").forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
