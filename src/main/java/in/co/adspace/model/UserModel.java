package in.co.adspace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.adspace.bean.UserBean;

public class UserModel {
	public static long addUser(UserBean user) {
	    Connection con = null;
	    PreparedStatement statement = null;
	    long pk = 0;

	    try {
	        con = Model.getCon(); // Make sure to define this method
	        statement = con.prepareStatement("SELECT email FROM user WHERE email=?");
	        statement.setString(1, user.getEmail());
	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            // Email already exists, set pk to 0 or handle accordingly
	            pk = 0;
	        } else {
	        	con = null;
	        	con = Model.getCon();
	        	System.out.println("Con: "+con);
	            // Email doesn't exist, proceed with the insert
	        	String sqlS = "insert into user(email,password,cpassword,firstname,lastname,phone,role) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        	statement = con.prepareStatement(sqlS);

	            statement.setString(1, user.getEmail());
	            statement.setString(2, user.getPassword());
	            statement.setString(3, user.getConfirm_password());
	            statement.setString(4, user.getFist_name());
	            statement.setString(5, user.getLast_name());
	            statement.setString(6, user.getPhone());
	            statement.setString(7, user.getRole());

	            pk = statement.executeUpdate();
	           
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle the exception properly
	    } 

	    return pk;
	}
	
	public UserBean login(UserBean ub) {
		Connection con = null;
		ResultSet rs = null;
		UserBean userbean = null;
		try {
			con = Model.getCon();
			PreparedStatement stmt = con.prepareStatement("select * from user where email =? and password=?");
			stmt.setString(1, ub.getEmail());
			stmt.setString(2, ub.getPassword());
			rs = stmt.executeQuery();
			System.out.println("in model");
			while (rs.next()) {
				userbean = new UserBean();
				userbean.setId(rs.getLong(1));
				userbean.setEmail(rs.getString(2));
				userbean.setPassword(rs.getString(3));
				userbean.setConfirm_password(rs.getString(4));
				
				userbean.setFist_name(rs.getString(5));
				userbean.setLast_name(rs.getString(6));
				userbean.setPhone(rs.getString(7));
				userbean.setRole(rs.getString(8));
				 System.out.println(userbean.getRole()+"role model");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return userbean;

	}


}
