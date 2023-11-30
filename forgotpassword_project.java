package account_validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connector.Connector;

/**
 * Servlet implementation class forgotpassword_project
 */
@WebServlet("/forgotpassword_project")
public class forgotpassword_project extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con=Connector.getConnection();
		String name=req.getParameter("name");
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		
		String query="update account set un=? ,pwd=? where name=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, un);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			int i=pstmt.executeUpdate();
			resp.setContentType("text/html");
			PrintWriter w=	resp.getWriter();
			w.print("<h3>User name and Password Succesfully updated</h3>");
			w.print("<a href=\"loginpage_project.html\">click here</a>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
