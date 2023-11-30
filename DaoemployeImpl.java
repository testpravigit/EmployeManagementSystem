package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import connector.Connector;
import dto.Employe;

public class DaoemployeImpl implements DaoemployeInter{

	@Override
	public boolean addEmploye(Employe e) {
		// TODO Auto-generated method stub
		String query="insert into employe values(?,?,?,?)";
		Connection con=Connector.getConnection();
		boolean f=false;
//		Employee=new Employe();
		int i=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, e.getId());
			pstmt.setString(2,e.getName());
			pstmt.setInt(3, e.getSalary());
			pstmt.setString(4,e.getDept());
			 i=pstmt.executeUpdate();
			 if(i>0) {
				 f=true;
			 }
			System.out.println(i);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Employe> getEmploye() {
		List<Employe> l=new ArrayList<Employe>();
		Employe e=null;
		String query="select * from employe";
		Connection con=Connector.getConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			while(rst.next()) {
				e=new Employe();
				e.setId(rst.getString(1));
				e.setName(rst.getString(2));
				e.setSalary(rst.getInt(3));
				e.setDept(rst.getString(4));
				l.add(e);
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		return l;
	}
	public Employe geteachEmploye(String id) {
		String query="select * from employe where id=?";
		Connection con=Connector.getConnection();
		Employe e=null;
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				e=new Employe();
				e.setId(rst.getString(1));
				e.setName(rst.getString(2));
				e.setSalary(rst.getInt(3));
				e.setDept(rst.getString(4));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return e;
		
		
	}
	public boolean updateEmploye(Employe e) {
		String query="update employe set name=?,salary=?,dept=? where id=?";
		Connection con=Connector.getConnection();
		boolean f=false;
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			System.out.println(e.getName()+" "+ e.getSalary()+" "+e.getDept()+" "+e.getId());
			pstmt.setString(1, e.getName());
			pstmt.setInt(2, e.getSalary());
			pstmt.setString(3, e.getDept());
			pstmt.setString(4, e.getId());
			int i=pstmt.executeUpdate();
			System.out.println(i);
			if(i>0) {
				f=true;
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return f;
		
		
		
	}
	public boolean deleteEmploye(String id){
		String query="delete from employe where id=?";
		Connection con=Connector.getConnection();
		System.out.println(id);
		boolean f=false;
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			int i=pstmt.executeUpdate();
			if(i>0) {
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
		
	}
	
		
	}



		

	


