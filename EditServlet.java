package employe_crud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoemployeImpl;
import dto.Employe;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		int salary=Integer.parseInt(req.getParameter("salary"));
		String dept=req.getParameter("dept");
		Employe e=new Employe(id,name,salary,dept);
		DaoemployeImpl de=new DaoemployeImpl();
		System.out.println(id+" "+name+" "+salary+" "+dept);
		boolean f=de.updateEmploye(e);
		if(f) {
			RequestDispatcher rd=req.getRequestDispatcher("home_project.jsp");
			rd.forward(req, resp);
		}
		else {
			
		}
		
	}
}
