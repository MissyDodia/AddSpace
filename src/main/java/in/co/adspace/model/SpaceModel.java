package in.co.adspace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.adspace.bean.SpaceBean;

public class SpaceModel {
	
	
	
	
	public static SpaceBean findById(Long id) throws SQLException {
	    System.out.println("Searching for SpaceBean with ID: " + id);
	    
	    ResultSet rs = null;
	    SpaceBean spacebean = null;
	    Connection conn = null;

	    try {
	        conn = Model.getCon();
	        PreparedStatement ps = conn.prepareStatement("select * from space where id=?");
	        ps.setLong(1, id);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            spacebean = new SpaceBean();
	            spacebean.setId(rs.getLong(1));
	            spacebean.setSpacename(rs.getString(2));
	            spacebean.setLocation(rs.getString(3));
	            spacebean.setArea(rs.getString(4));
	            spacebean.setType(rs.getString(5));
	            spacebean.setCompany(rs.getString(6));
	            spacebean.setDuration(rs.getString(7));
	            spacebean.setPrice(rs.getString(8));
	            spacebean.setAdmine_id(rs.getLong(9));
	        }
	    } finally {
	        // Close the resources in a finally block
	        if (rs != null) {
	            rs.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }

	    System.out.println("Found SpaceBean: " + spacebean);
	    return spacebean;
	}
	 public long addSpace(SpaceBean spaceBean) {
	        Connection con = null;
	        long pk = 0;
	        try {
	            con = Model.getCon();
	            String sql = "INSERT INTO space (spacename, location, area, type, company, duration, price, admine_id, image1, image2, image3) "
	                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = con.prepareStatement(sql);

	            preparedStatement.setString(1, spaceBean.getSpacename());
	            preparedStatement.setString(2, spaceBean.getLocation());
	            preparedStatement.setString(3, spaceBean.getArea());
	            preparedStatement.setString(4, spaceBean.getType());
	            preparedStatement.setString(5, spaceBean.getCompany());
	            preparedStatement.setString(6, spaceBean.getDuration());
	            preparedStatement.setString(7, spaceBean.getPrice());
	            preparedStatement.setLong(8, spaceBean.getAdmine_id());

	            preparedStatement.setBlob(9, spaceBean.getImage1());
	            preparedStatement.setBlob(10, spaceBean.getImage2());
	            preparedStatement.setBlob(11, spaceBean.getImage3());

	            pk = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return pk;
	    }
	 public List<SpaceBean> list() throws SQLException {
		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    List<SpaceBean> list = new ArrayList<>();

		    try {
		        con = Model.getCon();
		        ps = con.prepareStatement(
		            "SELECT id, spacename, location, area, type, company, duration, price, admine_id, image1, image2, image3 " +
		            "FROM space WHERE id NOT IN (" +
		            "SELECT s.id FROM space s " +
		            "INNER JOIN booking b ON s.id = b.spaceid " +
		            "WHERE b.status IN ('Confirmed')" +
		            ");"
		        );
		        rs = ps.executeQuery();

		        while (rs.next()) {
		            SpaceBean spacebean = new SpaceBean();
		            spacebean.setId(rs.getLong("id"));
		            spacebean.setSpacename(rs.getString("spacename"));
		            spacebean.setLocation(rs.getString("location"));
		            spacebean.setArea(rs.getString("area"));
		            spacebean.setType(rs.getString("type"));
		            spacebean.setCompany(rs.getString("company"));
		            spacebean.setDuration(rs.getString("duration"));
		            spacebean.setPrice(rs.getString("price"));
		            spacebean.setAdmine_id(rs.getLong("admine_id"));
		            
		            spacebean.setPhoto1(rs.getBlob("image1"));
		            spacebean.setPhoto2(rs.getBlob("image2"));
		            spacebean.setPhoto3(rs.getBlob("image3"));

		            list.add(spacebean);
		        }
		    } finally {
		        if (rs != null) {
		            rs.close();
		        }
		        if (ps != null) {
		            ps.close();
		        }
		        if (con != null) {
		            con.close();
		        }
		    }

		    System.out.println("list" + list);
		    return list;
		}

	
	public boolean deletespace(long id) {
		Connection con = Model.getCon();
		boolean pass = false;
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from space where id=?");
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
	
	public static void main(String[] args) throws SQLException {
       

			

            
     
	}
}
