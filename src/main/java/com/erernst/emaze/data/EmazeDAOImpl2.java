package com.erernst.emaze.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class EmazeDAOImpl2 implements EmazeDAO {
	private static String url = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String pass = "student";
	
	private ArrayList<Emaze> emazes = new ArrayList<>();
	private ServletContext context;

	@Autowired
	private WebApplicationContext wac;

	public EmazeDAOImpl2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	


	@Override
	public Emaze getEmazeById(int id) {
		Emaze emaze = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT e.id, e.name, e.course, l.city, l.state"
					+ " FROM emaze e join location l ON e.location_id=l.id WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int emazeId = rs.getInt(1);
				String name = rs.getString(2);
				String course = rs.getString(3);
				String city = rs.getString(4);
				String state = rs.getString(5);
				
				emaze = new Emaze(id, name, course, city, state);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emaze;
	}
	

	@Override
	public void addEmaze(Emaze emaze) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			
			String sql = "INSERT INTO location (city, state) "
					+ " VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, emaze.getCity());
			stmt.setString(2, emaze.getState());
			
			String sql2 = "INSERT INTO emaze (name, course,location_id) "
					+ " VALUES (?,?,?,?)";
			stmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, emaze.getName());
			stmt.setString(2, emaze.getName());
			stmt.setString(3, emaze.getCourse());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newEmazeId = keys.getInt(1);
					emaze.setId(newEmazeId);
				} else {
					emaze = null;
				}
			} else {
				emaze = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting maze " + emaze);
		}
		return;
	}
	@Override
	public boolean removeEmaze(int id) {
		Connection conn = null;
		boolean b = false;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql2 = "DELETE FROM location l JOIN emaze e ON l.id=e.location_id WHERE e.id=?";
			String sql = "DELETE FROM emaze WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt = conn.prepareStatement(sql2);
			stmt.setInt(1, id);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				b = true;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle2) {
				System.err.println("Error trying to rollback");
			}
		}
		return b;
	}
	
	

	@Override
	public List<Emaze> getEmazes() {
		List<Emaze> emazes = new ArrayList<Emaze>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT e.id, e.name, e.course, l.city, l.state "
					+ " FROM emaze e join location l ON e.location_id=l.id";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Emaze emaze = null;
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String course = rs.getString(3);
				String city = rs.getString(4);
				String state = rs.getString(5);
				

				emaze = new Emaze(id, name, course, city, state);
				emazes.add(emaze);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return emazes;
	}

	@Override
	public void setEmazes(List emazeTemp) {
		emazes = (ArrayList<Emaze>) emazeTemp;
	}


}
