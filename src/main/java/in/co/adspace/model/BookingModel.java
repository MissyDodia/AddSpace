package in.co.adspace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.adspace.bean.BookingBean;

public class BookingModel {
	public long booking(BookingBean bookbean) {
	    Connection con = null;
	    long book = 0;

	    try {
	        System.out.println("in start model");

	        con = Model.getCon();
	        String guery = "INSERT INTO booking (spacename, location, type, email, contactno, company, duration, price, status, payment, spaceid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement smtp = con.prepareStatement(guery);
	        smtp.setString(1, bookbean.getSpacename());
	        smtp.setString(2, bookbean.getLocation());
	        smtp.setString(3, bookbean.getType());
	        smtp.setString(4, bookbean.getEmail());
	        smtp.setString(5, bookbean.getContactno());
	        smtp.setString(6, bookbean.getCompany());
	        smtp.setString(7, bookbean.getDuration());
	        smtp.setString(8, bookbean.getPrice());
	        smtp.setString(9, bookbean.getStatus());
	        smtp.setString(10, bookbean.getPayment());
	        smtp.setLong(11, bookbean.getSpaceid());

	        book = smtp.executeUpdate();
	        System.out.println("space id is .."+bookbean.getSpaceid());
	    } catch (Exception e) {
	        // Handle the exception properly, e.g., log it
	        e.printStackTrace();
	    } finally {
	        // Close resources (Connection, PreparedStatement, etc.) in a finally block
	        // to ensure they are always closed, even if an exception occurs.
	        // Close the 'con' and 'smtp' resources here.
	        // Example:
	        // try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
	        // try { if (smtp != null) smtp.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }

	    return book;
	}
	
	public List<BookingBean> getBookingsByEmail(String email) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<BookingBean> bookings = new ArrayList<>();

        try {
            con = Model.getCon();
            String query = "select * from booking WHERE email=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BookingBean booking = new BookingBean();
              booking.setId(rs.getLong(1));
                booking.setSpacename(rs.getString(2));
             booking.setLocation(rs.getString(3));
             booking.setType(rs.getString(4));
             booking.setEmail(rs.getString(5));
             booking.setContactno(rs.getString(6));
             booking.setCompany(rs.getString(7));
             booking.setDuration(rs.getString(8));

             booking.setPrice(rs.getString(9));
             booking.setStatus(rs.getString(10));
             booking.setPayment(rs.getString(11));
             booking.setSpaceid(rs.getLong(12));


                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log it, or throw a custom exception if needed
        } 

        return bookings;
    }

	public List<BookingBean> listbook() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<BookingBean> list = new ArrayList<>();

        try {
            con = Model.getCon();
            String query = "select * from booking";
            pstmt = con.prepareStatement(query);
          
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BookingBean booking = new BookingBean();
              booking.setId(rs.getLong(1));
                booking.setSpacename(rs.getString(2));
             booking.setLocation(rs.getString(3));
             booking.setType(rs.getString(4));
             booking.setEmail(rs.getString(5));
             booking.setContactno(rs.getString(6));
             booking.setCompany(rs.getString(7));
             booking.setDuration(rs.getString(8));

             booking.setPrice(rs.getString(9));
             booking.setStatus(rs.getString(10));
             booking.setPayment(rs.getString(11));
             booking.setSpaceid(rs.getLong(12));


                list.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log it, or throw a custom exception if needed
        } 

        return list;
    }
	
	public List<BookingBean> confirmlistbook() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<BookingBean> list = new ArrayList<>();

        try {
            con = Model.getCon();
            String query = "SELECT * FROM booking where status='Confirmed'";
            pstmt = con.prepareStatement(query);
          
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BookingBean booking = new BookingBean();
              booking.setId(rs.getLong(1));
                booking.setSpacename(rs.getString(2));
             booking.setLocation(rs.getString(3));
             booking.setType(rs.getString(4));
             booking.setEmail(rs.getString(5));
             booking.setContactno(rs.getString(6));
             booking.setCompany(rs.getString(7));
             booking.setDuration(rs.getString(8));

             booking.setPrice(rs.getString(9));
             booking.setStatus(rs.getString(10));
             booking.setPayment(rs.getString(11));
             booking.setSpaceid(rs.getLong(12));


                list.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log it, or throw a custom exception if needed
        } 

        return list;
    }
	
	public BookingBean getBookingsById(long id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
      BookingBean booking =null;

        try {
            con = Model.getCon();
            String query = "select * from booking WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setLong(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                booking = new BookingBean();
              booking.setId(rs.getLong(1));
                booking.setSpacename(rs.getString(2));
             booking.setLocation(rs.getString(3));
             booking.setType(rs.getString(4));
             booking.setEmail(rs.getString(5));
             booking.setContactno(rs.getString(6));
             booking.setCompany(rs.getString(7));
             booking.setDuration(rs.getString(8));

             booking.setPrice(rs.getString(9));
             booking.setStatus(rs.getString(10));
             booking.setPayment(rs.getString(11));
             booking.setSpaceid(rs.getLong(12));


                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log it, or throw a custom exception if needed
        } 

        return booking;
    }

	public boolean deletespace(long id) {
		Connection con = Model.getCon();
		boolean pass = false;
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from booking where id=?");
			stmt.setLong(1, id);
			int row = stmt.executeUpdate();
			if (row > 0) {
				pass = true;
			} else {
				pass = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return pass;

	}
	
	
	
	
	
	public boolean updateBookingStatus(long bookingId, String newStatus) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Model.getCon();
            String query = "UPDATE booking SET status=? WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newStatus);
            pstmt.setLong(2, bookingId);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	
	public boolean updatePaymentStatus(long bookingId, String newStatus) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Model.getCon();
            String query = "UPDATE booking SET payment=? WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newStatus);
            pstmt.setLong(2, bookingId);

            int rowsUpdated = pstmt.executeUpdate();
              System.out.println("payemt paid..");
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	public static void main(String[] args) throws SQLException {
		BookingModel md = new BookingModel();
		md.updatePaymentStatus(2, "paid");
	}
}
