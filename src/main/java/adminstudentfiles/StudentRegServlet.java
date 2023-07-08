package adminstudentfiles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentRegServlet
 */
@WebServlet("/StudentRegServlet")
public class StudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        StudentRegBean studentRegBean = new StudentRegBean(name, email, password);
        
        StudentRegDao studentRegDao = new StudentRegDao();
        if (studentRegDao.insert(studentRegBean)) {
            response.sendRedirect("studentRegSuccess.jsp");    
        } else {
            response.sendRedirect("studentRegError.jsp");    
        }
		
	}

}
