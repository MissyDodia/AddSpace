package in.co.adspace.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.BaseBean;
import in.co.adspace.bean.SpaceBean;
import in.co.adspace.bean.UserBean;
import in.co.adspace.model.SpaceModel;

/**
 * Servlet implementation class AddSpaceCtl
 */
public class AddSpaceCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpaceCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/jsp/AddSpace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SpaceBean spaceBean = new SpaceBean();
        spaceBean.setSpacename(request.getParameter("spacename"));
        spaceBean.setLocation(request.getParameter("location"));
        spaceBean.setArea(request.getParameter("area"));
        spaceBean.setType(request.getParameter("type"));
        spaceBean.setCompany(request.getParameter("company"));
        spaceBean.setDuration(request.getParameter("duration"));
        spaceBean.setPrice(request.getParameter("price"));

        BaseBean userbean = (UserBean)request.getSession().getAttribute("userbean");
        spaceBean.setAdmine_id(userbean.getId());
        
        SpaceModel spaceModel = new SpaceModel();
        long success = spaceModel.addSpace(spaceBean);

        if (success>0) {
        	request.setAttribute("success", "space is added..!");
        } else {
        	request.setAttribute("err", "space is not added..!");
        }
        request.getRequestDispatcher("/jsp/AddSpace.jsp").forward(request, response);
    }

}
