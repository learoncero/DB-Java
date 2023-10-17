package perspro.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import perspro.broker.DepartmentBroker;
import perspro.model.Department;
import perspro.model.Person;
import perspro.model.Project;

public class Facade implements DatabaseFacade {
	private static Facade _instance;

	private Facade() {
	}
	
	public static Facade getInstance() {
		if (_instance == null) {
			_instance = new Facade();
		}
		return _instance;
	}

	public void saveObject(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void deleteObject(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Person getPersonByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	public Department getDepartmentByNo(int deptno) {
		DepartmentBroker departmentBroker = new DepartmentBroker();
		Department department = null;
		try {
			department = departmentBroker.get(deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return department;
	}

	public List<Department> getAllDepartments() {
		DepartmentBroker departmentBroker = new DepartmentBroker();
		List<Department> departments = new ArrayList<Department>();
		
		try {
			departments = departmentBroker.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	public Project getProjectByNo(int projno) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Facade f = Facade.getInstance();
		/*
		List<Department> departments = f.getAllDepartments();
		
		for (Department d: departments) {
			System.out.println(d.getDeptno());
		}
		*/
		
		Department d = f.getDepartmentByNo(8);
		System.out.println(d.getDeptname());
	}

}
