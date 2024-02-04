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
		long pk =0;
        try {
           
           con = Model.getCon();

            String sql = "  insert into space (spacename, location, area, type, company, duration, price,admine_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, spaceBean.getSpacename());
            preparedStatement.setString(2, spaceBean.getLocation());
            preparedStatement.setString(3, spaceBean.getArea());
            preparedStatement.setString(4, spaceBean.getType());
            preparedStatement.setString(5, spaceBean.getCompany());
            preparedStatement.setString(6, spaceBean.getDuration());
            preparedStatement.setString(7, spaceBean.getPrice());
            preparedStatement.setLong(8, spaceBean.getAdmine_id());

            pk = preparedStatement.executeUpdate();

           

            
        } catch (Exception e) {
	        e.printStackTrace(); // Handle the exception properly
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
	        ps = con.prepareStatement("Select * from space where id not in (SELECT s.id\r\n"
	        		+ "FROM space s\r\n"
	        		+ "inner JOIN booking b ON s.id = b.spaceid\r\n"
	        		+ "WHERE b.status in ('Confirmed'));");
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            SpaceBean spacebean = new SpaceBean();
	            spacebean.setId(rs.getLong(1));
	            spacebean.setSpacename(rs.getString(2));
	            spacebean.setLocation(rs.getString(3));
	            spacebean.setArea(rs.getString(4));
	            spacebean.setType(rs.getString(5));
	            spacebean.setCompany(rs.getString(6));
	            spacebean.setDuration(rs.getString(7));
	            spacebean.setPrice(rs.getString(8));
	            spacebean.setAdmine_id(rs.getLong(9));
	            list.add(spacebean);
	        }
	    } finally {
	        // Close resources in the finally block
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
       

        SpaceBean spaceBean= new SpaceBean();
		
			spaceBean = findById((long) 2);
	

      
           
            System.out.println("Space ID: " + spaceBean.getId());
            System.out.println("Space Name: " + spaceBean.getSpacename());
            System.out.println("Location: " + spaceBean.getLocation());
            System.out.println("Area: " + spaceBean.getArea());
            System.out.println("Type: " + spaceBean.getType());
            System.out.println("Company: " + spaceBean.getCompany());
            System.out.println("Duration: " + spaceBean.getDuration());
            System.out.println("Price: " + spaceBean.getPrice());
            System.out.println("Admin ID: " + spaceBean.getAdmine_id());
     
	}
}
