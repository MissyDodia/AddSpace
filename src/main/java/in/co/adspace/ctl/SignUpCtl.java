package in.co.adspace.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.adspace.bean.UserBean;
import in.co.adspace.model.UserModel;

/**
 * Servlet implementation class SignUpCtl
 */
public class SignUpCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/jsp/SignUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();

	        // Extracting form data
		System.out.println("cpass.."+request.getParameter("repeat_password"));
	        String email = request.getParameter("floating_email");
	        String password = request.getParameter("floating_password");
	        String confirmPassword = request.getParameter("repeat_password");
	        String firstName = request.getParameter("floating_first_name");
	        String lastName = request.getParameter("floating_last_name");
	        String phone = request.getParameter("floating_phone");
	        String role = request.getParameter("helper-radio"); // Assuming this is the role field

	        bean.setEmail(email);
	        bean.setPassword(password);
	        bean.setConfirm_password(confirmPassword);
	        bean.setFist_name(firstName);
	        bean.setLast_name(lastName);
	        bean.setPhone(phone);
	        bean.setRole(role);
		       System.out.println(bean.getLast_name()+" ..."+bean.getRole()+" ,,,,,,"+bean.getConfirm_password());

	        
	        if(validateFields(request)) {
	        	UserModel model = new UserModel();
	        	long pk = model.addUser(bean);
	        	if (pk==0) {
	                
	    		    request.setAttribute("error", "email Already exiss..!");
	    			}
	    			if(pk>0) {
	    			request.setAttribute("success","Added successfully......!");
	    			
	    			}
	    			request.getRequestDispatcher("/jsp/SignUp.jsp").forward(request, response);
	    		
	    	}else {
	    		request.setAttribute("error", "something went wrong");
	    		request.getRequestDispatcher("/jsp/SignUp.jsp").forward(request, response);

	    		}
	        }

	


private boolean validateFields(HttpServletRequest request) {
    boolean field = true;

    // Email validation
    String email = request.getParameter("floating_email");
    if (email == null || email.trim().isEmpty()) {
        request.setAttribute("emailError", "Email field is empty");
        field = false;
    }

    // Password validation
    String password = request.getParameter("floating_password");
    if (password == null || password.trim().isEmpty()) {
        request.setAttribute("passwordError", "Password field is empty");
        field= false;
    }

    // Confirm Password validation
    String confirmPassword = request.getParameter("repeat_password");
    if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
        request.setAttribute("confirmPasswordError", "Confirm Password field is empty");
        field = false;
    }

    // First Name validation
    String firstName = request.getParameter("floating_first_name");
    if (firstName == null || firstName.trim().isEmpty()) {
        request.setAttribute("firstNameError", "First Name field is empty");
        field = false;
    }

    // Last Name validation
    String lastName = request.getParameter("floating_last_name");
    if (lastName == null || lastName.trim().isEmpty()) {
        request.setAttribute("lastNameError", "Last Name field is empty");
        field = false;
    }

    // Phone validation
    String phone = request.getParameter("floating_phone");
    if (phone == null || phone.trim().isEmpty()) {
        request.setAttribute("phoneError", "Phone field is empty");
        field= false;
    }

    // Role validation
    String role = request.getParameter("helper-radio");
    if (role == null || role.trim().isEmpty()) {
        request.setAttribute("roleError", "Role field is empty");
        field = false;
    }

    return field;

}}