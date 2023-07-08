package adminhomefiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/rs";
	private String jdbcUsername = "root";
	private String jdbcPassword = "AishwaryaG!13";
	
	private static final String SELECT_COURSES_BY_EMAIL = 
			"SELECT courses.cid,courses.cname\r\n"
			+ "FROM rs.details\r\n"
			+ "JOIN rs.registration ON details.emailid = registration.email\r\n"
			+ "JOIN rs.courses ON details.courseid = courses.cid where emailid=?";
	
	private static final String SELECT_STUDENTS_FOR_CID = 
			"SELECT registration.name,registration.email\r\n"
			+ "FROM rs.details\r\n"
			+ "JOIN rs.registration ON details.emailid = registration.email\r\n"
			+ "JOIN rs.courses ON details.courseid = courses.cid where cid=?";
			
	private static final String SELECT_ALL_DETAILS=
			"SELECT registration.name,registration.email,registration.password,courses.cid,courses.cname \r\n"
			+ "FROM rs.details\r\n"
			+ "JOIN rs.registration ON details.emailid = registration.email\r\n"
			+ "JOIN rs.courses ON details.courseid = courses.cid";
	
	public OpDao() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
		
		
		//selecting Courses by email
		public List<CoursesByStudentBean> selectCourses(String email) {
			List<CoursesByStudentBean> courses = new ArrayList<>();
					try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSES_BY_EMAIL);) {
						preparedStatement.setString(1, email);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int cid = rs.getInt("cid");
					String cname = rs.getString("cname");
					courses.add(new CoursesByStudentBean(cid, cname));
				}
			} catch (SQLException e) {
				e.printStackTrace();			}
			return courses;
		}
		
		//selecting Students for cid
				public List<StudentsForCourseBean> selectStudents(int cid) {
					List<StudentsForCourseBean> students = new ArrayList<>();
							try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_FOR_CID);) {
								preparedStatement.setInt(1, cid);
						System.out.println(preparedStatement);
						ResultSet rs = preparedStatement.executeQuery();
						while (rs.next()) {
							String name = rs.getString("name");
							String email = rs.getString("email");
							students.add(new StudentsForCourseBean(name, email));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return students;
				}
				
				//selecting All details
				public List<AllDetailsBean> selectAllDetails() {
					List<AllDetailsBean> allDetails = new ArrayList<>();
							try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAILS);) {
						System.out.println(preparedStatement);
						ResultSet rs = preparedStatement.executeQuery();
						while (rs.next()) {
							String name = rs.getString("name");
							String email = rs.getString("email");
							String password = rs.getString("password");
							int cid = rs.getInt("cid");
							String cname = rs.getString("cname");
							allDetails.add(new AllDetailsBean(name,email,password,cid,cname));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return allDetails;
				}	
		
}
