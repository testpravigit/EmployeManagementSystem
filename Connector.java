package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	static String url="jdbc:mysql://localhost:3306/tap";
	static String uname="root";
	static String pwd="4321";
	static Connection con=null;
			
	public static Connection getConnection() {
		try 
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 con=DriverManager.getConnection(url,uname,pwd);
			System.out.println("done");
			
		}
		catch ( SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
