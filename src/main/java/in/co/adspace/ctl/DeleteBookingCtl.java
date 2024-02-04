package in.co.adspace.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.BookingBean;
import in.co.adspace.bean.SpaceBean;
import in.co.adspace.model.BookingModel;
import in.co.adspace.model.SpaceModel;

/**
 * Servlet implementation class DeleteBookingCtl
 */
public class DeleteBookingCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    long id = Long.parseLong(request.getParameter("bookingid"));

		    BookingModel model = new BookingModel();

		    boolean isDeleted = model.deletespace(id);

		    if (isDeleted) {
		        request.setAttribute("success", "Booking is deleted Successfully..!");

		        List<BookingBean> list = model.listbook();

		        if (list != null && !list.isEmpty()) {
		            request.setAttribute("list", list);
		        } else {
		            request.setAttribute("err", "booking not found..!");
		        }
		    } else {
		        request.setAttribute("error", "Booking deletion failed.");
		    }
		} catch (Exception e) {
		    // Handle exception
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
