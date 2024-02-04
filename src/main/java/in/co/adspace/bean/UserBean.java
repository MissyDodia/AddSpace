package in.co.adspace.bean;

public class UserBean  extends BaseBean{

	
		private String email;
		private String password;
		private String confirm_password;
		private String fist_name;
		private String last_name;
		private String phone;
		
		private String role;
	
		
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm_password() {
			return confirm_password;
		}

		public void setConfirm_password(String confirm_password) {
			this.confirm_password = confirm_password;
		}

		public String getFist_name() {
			return fist_name;
		}

		public void setFist_name(String fist_name) {
			this.fist_name = fist_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		

}
