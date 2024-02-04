package in.co.adspace.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import in.co.adspace.bean.BookingBean;
import in.co.adspace.bean.UserBean;
import in.co.adspace.model.BookingModel;
import in.co.adspace.model.Model;

/**
 * Servlet implementation class ViewBookingCtl
 */
public class ViewBookingCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookingCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession();
        
        UserBean userbean = (UserBean) session.getAttribute("userbean");

        if (userbean != null && userbean.getEmail() != null) {
            String email = userbean.getEmail();

            BookingModel model = new BookingModel();
            List<BookingBean> bookings = model.getBookingsByEmail(email);

            request.setAttribute("bookings", bookings);
        } else {
            request.setAttribute("err", "no recode found");
        }
        request.getRequestDispatcher("/jsp/ViewBooking.jsp").forward(request, response);

    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
