package in.co.adspace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.adspace.bean.BookingBean;
import in.co.adspace.bean.PaymentBean;

public class PaymentModel {
	public long addPayment(PaymentBean paymentBean) {
        Connection con = null;
        long pk = 0;

        try {
            con = Model.getCon();
            String query = "INSERT INTO payments (card_number, expiration_date,   cvv,  cardholder_name, email, userid ,spacename, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, paymentBean.getCardNumber());
            pstmt.setString(2, paymentBean.getExpirationDate());
            pstmt.setString(3, paymentBean.getCvv());
            pstmt.setString(4, paymentBean.getCardholderName());
            pstmt.setString(5, paymentBean.getEmail());
            pstmt.setLong(6, paymentBean.getUserId());
            pstmt.setString(7, paymentBean.getSpacename());

            pstmt.setString(8, paymentBean.getPrice());

           pk = pstmt.executeUpdate();

           
            
        } catch (Exception e) {
            e.printStackTrace();
        } 

        return pk;
    }
	
	public List<PaymentBean> payemntList(){
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		List<PaymentBean> list = new  ArrayList<>();
		try {
			con = Model.getCon();
			String query = "select * from payments ";
			stmt= con.prepareStatement(query);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				PaymentBean paybean = new PaymentBean();
				paybean.setId(rs.getLong(1));
				paybean.setCardNumber(rs.getString(2));
				paybean.setExpirationDate(rs.getString(3));
				paybean.setCvv(rs.getString(4));
				paybean.setCardholderName(rs.getString(5));
				paybean.setEmail(rs.getString(6));
				paybean.setUserId(rs.getLong(7));
				paybean.setSpacename(rs.getString(8));
				paybean.setPrice(rs.getString(9));
				
				list.add(paybean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
		
	}
	
}
