package dao;

import java.util.List;

import dto.Employe;

public interface DaoemployeInter {

	boolean addEmploye(Employe e);
	List<Employe> getEmploye();
	Employe geteachEmploye(String id);
	boolean updateEmploye(Employe e);
	boolean deleteEmploye(String id);
	
	
}
