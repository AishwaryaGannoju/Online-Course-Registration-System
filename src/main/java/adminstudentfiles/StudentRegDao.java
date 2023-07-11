package adminstudentfiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/rs";
	private String dbUname = "root";
	private String dbPassword = "password";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	public boolean insert(StudentRegBean studentRegBean)
	{
		boolean status;
		loadDriver(dbDriver);
		Connection con = getConnection();
		String sql = "insert into registration values(?,?,?)";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, studentRegBean.getName());
		ps.setString(2, studentRegBean.getEmail());
		ps.setString(3, studentRegBean.getPassword());
		ps.executeUpdate();
		status=true;
		//String result = studentRegBean.getName()+"'s Data entered successfully";
		} catch (SQLException e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}

}
