package account_validation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connector.Connector;

/**
 * Servlet implementation class Createaccount_project
 */
@WebServlet("/Createaccount_project")
public class Createaccount_project extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection con=Connector.getConnection();
	String name=req.getParameter("name");
	String un=req.getParameter("un");
	String pwd=req.getParameter("pwd");
	String query="insert into account values(?,?,?)";
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, un);
		pstmt.setString(3, pwd);
		int i=pstmt.executeUpdate();
		RequestDispatcher rd=req.getRequestDispatcher("createaccount1_project.html");
		rd.include(req, resp);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
