package admincoursefiles;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminhomefiles.OpDao;
import adminhomefiles.CoursesByStudentBean;
import adminhomefiles.StudentsForCourseBean;
import adminhomefiles.AllDetailsBean;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CourseDao cDAO;
	private OpDao opDAO;
    
	public void init() {
		cDAO = new CourseDao();
		opDAO = new OpDao();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCourse(request, response);
				break;
			case "/delete":
				deleteCourse(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCourse(request, response);
				break;
			case "/list":
				listCourse(request, response);
				break;
			case "/courses":
				listCourses(request, response);
				break;
			case "/students":
				listStudents(request, response);
				break;
			case "/details":
				listAllDetails(request, response);
				break;
			case "/studentform":
				showStudentForm(request, response);
				break;
			case "/courseform":
				showCourseForm(request, response);
				break;
				
			case "/enroll":
				showEnrollForm(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("courseForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertCourse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cname = request.getParameter("cname");
		CourseBean newCourse = new CourseBean(cid,cname);
		cDAO.insertCourse(newCourse);
		response.sendRedirect("list");
	}
	
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		cDAO.deleteCourse(cid);
		response.sendRedirect("list");

	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		CourseBean existingCourse = cDAO.selectCourse(cid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("courseForm.jsp");
		request.setAttribute("course", existingCourse);
		dispatcher.forward(request, response);

	}
	private void updateCourse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cname = request.getParameter("cname");

		CourseBean course = new CourseBean(cid, cname);
		cDAO.updateCourse(course);
		response.sendRedirect("list");
	}
	private void listCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<CourseBean> listCourse = cDAO.selectAllCourses();
		request.setAttribute("listCourse", listCourse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("courseListAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	//to display new student form for list of courses
	private void showStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("coursesByStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	//to display new course form for list of students
	private void showCourseForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentsForCourse.jsp");
		dispatcher.forward(request, response);
	}
	
	//listing courses for email
		private void listCourses (HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			String email = request.getParameter("email");
			List<CoursesByStudentBean> listCourses = opDAO.selectCourses(email);
			request.setAttribute("listCourses", listCourses);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listOfCourses.jsp");
			dispatcher.forward(request, response);
		}
		
		//listing students for cid
			private void listStudents(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int cid = Integer.parseInt(request.getParameter("cid"));
				List<StudentsForCourseBean> listStudents = opDAO.selectStudents(cid);
				request.setAttribute("listStudents", listStudents);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listOfStudents.jsp");
				dispatcher.forward(request, response);
			}
			
			//listing all the details
			private void listAllDetails(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				List<AllDetailsBean> listOfAllDetails = opDAO.selectAllDetails();
				request.setAttribute("listOfAllDetails", listOfAllDetails);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listOfAllDetails.jsp");
				dispatcher.forward(request, response);
			}
			//student enroll form display 
			private void showEnrollForm(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("enrollForm.jsp");
				dispatcher.forward(request, response);
			}
	

}
