package in.co.adspace.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.BookingBean;
import in.co.adspace.bean.SpaceBean;
import in.co.adspace.model.BookingModel;
import in.co.adspace.model.SpaceModel;


/**
 * Servlet implementation class BookSpaceCtl
 */
public class BookSpaceCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSpaceCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            SpaceModel model = new SpaceModel();
	            System.out.println("SpaceBean.."+request.getParameter("spaceId"));

	            long id = Long.parseLong(request.getParameter("spaceId"));
	            System.out.println("SpaceBean..");
	            if (id > 0) {
	                SpaceBean sbean = model.findById(id);
	               
	                    request.setAttribute("sbean", sbean);
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        request.getRequestDispatcher("/jsp/Booking.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookingBean bookbean = new BookingBean();
		
		bookbean.setSpacename(request.getParameter("spacename"));
		bookbean.setLocation(request.getParameter("location"));
		bookbean.setType(request.getParameter("type"));
		bookbean.setEmail(request.getParameter("email"));
		bookbean.setContactno(request.getParameter("phone"));
		bookbean.setCompany(request.getParameter("company"));
		System.out.println("company SPACE ID is --"+request.getParameter("spaceid"));
		
		// Retrieve "from" and "to" dates from request parameters
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");

        // Concatenate dates into a single variable
        String concatenatedDates = fromDate + " to " + toDate;

        // Set values in BookingBean
        bookbean.setDuration(concatenatedDates);
		bookbean.setPrice(request.getParameter("price"));
		bookbean.setStatus("processing");
		bookbean.setPayment("pay");

		String spaceIdParam = request.getParameter("spaceid");
		long id = 0;

		if (spaceIdParam != null && !spaceIdParam.isEmpty()) {
		    try {
		        id = Long.parseLong(spaceIdParam);
		        System.out.println("Parsed ID: " + id);
		        bookbean.setSpaceid(id);
		   } catch (NumberFormatException e) {
		        // Handle the case where the parameter is not a valid long
		        e.printStackTrace(); // or log the error
		    }
		} else {
		    // Handle the case where the parameter is null or empty
		}

 
BookingModel model = new BookingModel();
long book = model.booking(bookbean);
System.out.println("after model..");

if(book>0) {
request.setAttribute("book","your space booking is submitted wait for conformation..!");
}else {
	request.setAttribute("err","space is not booked");

}


request.getRequestDispatcher("/jsp/Booking.jsp").forward(request, response);

	}

}
