package adminloginfiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminLoginDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/rs";
	private String dbUname = "root";
	private String dbPassword = "AishwaryaG!13";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
	public boolean validate(AdminLoginBean adminLoginBean)
	{
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from admintable where email = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, adminLoginBean.getEmail());
		ps.setString(2, adminLoginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	}
