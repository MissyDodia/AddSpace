package in.co.adspace.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.BookingBean;
import in.co.adspace.model.BookingModel;

/**
 * Servlet implementation class ViewAllBooking
 */
public class ViewAllBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
BookingModel model = new BookingModel();
try {
	List<BookingBean> list = model.listbook();
	
	
	if (list !=null && !list.isEmpty()) {
		
		request.setAttribute("list", list);
	}else {
		request.setAttribute("err", "booking not found..!");

	}
} catch (Exception e) {
	// TODO: handle exception
}
	request.getRequestDispatcher("/jsp/ViewAllBooking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
