package account_validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connector.Connector;

/**
 * Servlet implementation class Validation_project
 */
@WebServlet("/Validation_project")
public class Validation_project extends HttpServlet {
//	Connection con=null;
//	
//	public void init() throws ServletException {
//		
//		
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=Connector.getConnection();
		resp.setContentType("text/html");
	PrintWriter w=	resp.getWriter();
	
		
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		String query="select name from account where un=? and pwd=?";
		try {
			PreparedStatement pstmt =con.prepareStatement(query);
			pstmt.setString(1, un);
			pstmt.setString(2, pwd);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next()) {
				String a=rst.getString(1);
				System.out.println(rst.getString(1));
				w.print("<h3>Welcome "+ a +" </h3>");
				RequestDispatcher rd=req.getRequestDispatcher("home_project.jsp");
				rd.include(req, resp);
				
			}
			
			else 
			{
				w.print("<h3>Login failed.Try again</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("loginpage_project.html");
				rd.include(req, resp);
				
				
			}
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
