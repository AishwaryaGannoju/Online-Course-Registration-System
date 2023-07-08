package admincoursefiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CourseDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/rs";
	private String jdbcUsername = "root";
	private String jdbcPassword = "AishwaryaG!13";
	
	private static final String INSERT_COURSES_SQL = "INSERT INTO courses (cid,cname) VALUES (?,?)";

	private static final String SELECT_COURSE_BY_ID = "select cid,cname from courses where cid =?";
	private static final String SELECT_ALL_COURSES = "select * from courses";
	private static final String DELETE_COURSES_SQL = "delete from courses where cid = ?";
	private static final String UPDATE_COURSES_SQL = "update courses set cname = ? where cid = ?";
	
	public CourseDao() {
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
	
	
	//inserting course 
	public void insertCourse(CourseBean course) throws SQLException {
		System.out.println(INSERT_COURSES_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSES_SQL)) {
			preparedStatement.setInt(1, course.getCid());
			preparedStatement.setString(2, course.getCname());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	//selecting course by cid
	public CourseBean selectCourse(int cid) {
		CourseBean course = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_ID);) {
			preparedStatement.setInt(1, cid);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String cname = rs.getString("cname");
				course = new CourseBean(cid, cname);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return course;
	}
	
	
	//selecting all the courses
	public List<CourseBean> selectAllCourses() {
		List<CourseBean> courses = new ArrayList<>();
				try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				courses.add(new CourseBean(cid, cname));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return courses;
	}
	
	
	//to delete the a course
	public boolean deleteCourse(int cid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COURSES_SQL);) {
			statement.setInt(1, cid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	
	//to update a course
	public boolean updateCourse(CourseBean course) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COURSES_SQL);) {
			System.out.println("updated Course: "+statement);
			statement.setInt(1, course.getCid());
			statement.setString(2, course.getCname());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	//to handle exceptions
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
