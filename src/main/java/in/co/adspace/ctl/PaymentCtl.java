package in.co.adspace.ctl;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.adspace.bean.BookingBean;
import in.co.adspace.bean.PaymentBean;
import in.co.adspace.bean.UserBean;
import in.co.adspace.model.BookingModel;
import in.co.adspace.model.PaymentModel;

/**
 * Servlet implementation class PaymentCtl
 */
public class PaymentCtl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	    long id = Long.parseLong(request.getParameter("bookingid"));
   BookingModel model = new BookingModel();
   if(id>0) {
    BookingBean bookbean = (BookingBean) model.getBookingsById(id);
    request.setAttribute("bookbean", bookbean);
   }
    	
    	
    	request.getRequestDispatcher("/jsp/Payment.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean bean = (UserBean) session.getAttribute("userbean");

        if (bean != null) {
            String email = bean.getEmail();
            long userId = bean.getId();

            String cardNumber = request.getParameter("card-number");
            String expirationDate = request.getParameter("expiration-date");
            String cvv = request.getParameter("cvv");
            String cardholderName = request.getParameter("cardholder-name");

            PaymentBean paymentBean = new PaymentBean();
            paymentBean.setCardNumber(cardNumber);
            paymentBean.setExpirationDate(expirationDate);
            paymentBean.setCvv(cvv);
            paymentBean.setCardholderName(cardholderName);
            paymentBean.setEmail(email);
            paymentBean.setUserId(userId);
            paymentBean.setPrice(request.getParameter("price"));
            paymentBean.setSpacename(request.getParameter("spacename"));

            PaymentModel paymentModel = new PaymentModel();
            long pk = paymentModel.addPayment(paymentBean);

            if (pk > 0) {
            	updateBookingPaymentStatus(request);

                request.setAttribute("success", "Payment is Done..!");
            } else {
                request.setAttribute("err", "Payment is failed");
            }
        } else {
            request.setAttribute("err", "User session not found. Please login.");
        }

        request.getRequestDispatcher("/jsp/Payment.jsp").forward(request, response);
    }

    private void updateBookingPaymentStatus(HttpServletRequest request) {
        try {
            long bookingId = Long.parseLong(request.getParameter("bookingid"));

            BookingModel bookingModel = new BookingModel();
            BookingBean bookbean = (BookingBean) bookingModel.getBookingsById(bookingId);

            if (bookbean != null) {
                bookbean.setPayment("Paid");

                boolean updated = bookingModel.updatePaymentStatus(bookingId, "Paid");

                if (updated) {
                    request.setAttribute("success", "Payment status updated successfully.");
                } else {
                    request.setAttribute("err", "Failed to update payment status.");
                }
            } else {
                request.setAttribute("err", "Booking information not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("err", "Error updating payment status: " + e.getMessage());
        }
    }

}
