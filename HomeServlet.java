package employe_crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoemployeImpl;
import dto.Employe;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter w=resp.getWriter();
		String name=req.getParameter("name");
		int salary=Integer.parseInt(req.getParameter("salary"));
		String dept=req.getParameter("dept");
		UUID uuid=UUID.randomUUID();
		String uu=uuid.toString();
		Employe e=new Employe(uu,name,salary,dept);
		DaoemployeImpl de=new DaoemployeImpl();
		boolean f= de.addEmploye(e);
		if(f) {
			System.out.println("succesfully added");
			w.println("<h3>succesfully added</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("addEmploye_project.jsp");
			rd.include(req, resp);
		}
		else {
			System.out.println("succesfully not added");
			
		}
		
		
	}

}
