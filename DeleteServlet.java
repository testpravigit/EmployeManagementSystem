package employe_crud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoemployeImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		DaoemployeImpl de=new DaoemployeImpl();
		boolean f=de.deleteEmploye(id);
		if(f) {
			RequestDispatcher rd=req.getRequestDispatcher("home_project.jsp");
			rd.forward(req, resp);
		}
		
	}
	
}
