package in.co.adspace.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.PaymentBean;
import in.co.adspace.model.PaymentModel;

/**
 * Servlet implementation class ViewPaymentCtl
 */
public class ViewPaymentCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPaymentCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 PaymentModel paymodel = new PaymentModel();
 try {
	List<PaymentBean> paylist = paymodel.payemntList();
	if(paylist !=null && !paylist.isEmpty()) {
		request.setAttribute("paylist", paylist);
	}else {
		request.setAttribute("err", "payment list not found");
	}
} catch (Exception e) {
	// TODO: handle exception
}
 request.getRequestDispatcher("/jsp/ViewPayment.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
