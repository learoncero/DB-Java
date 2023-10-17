package perspro.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import perspro.model.Department;
import perspro.model.Person;

public class DepartmentBroker {
	Connection _connection;
	
	private void openConnection() {
		try {
			_connection = DriverManager.getConnection("jdbc:postgresql://elmo.hostingcenter.uclv.net:5432/itb_inf_2022_lro3572", "itb_inf_2022_lro3572", "PW_ROLe");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void closeConnection() {
		try {
			_connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Department department) {
		
	}
	
	public void delete(Department department) {
		
	}
	
	public void update(Department department) {
		
	}
	
	public Department get(int deptNumber) throws SQLException {
		openConnection();
		
		PreparedStatement stmt = _connection.prepareStatement("SELECT * FROM pers_proj.department WHERE deptno = ?");
		stmt.setInt(1, deptNumber);
		ResultSet rs = stmt.executeQuery();
		
		Department department = null;
		
		while (rs.next()) {
			department = mapDepartment(rs);
		}
		
		closeConnection();
		
		return department;
	}
	
	public List<Department> getAll() throws SQLException {
		openConnection();
		Statement stmt = _connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM pers_proj.department");
		
		List<Department> departments = new ArrayList<Department>();

		while(rs.next()) {
			Department department = mapDepartment(rs);
			departments.add(department);
		}
		
		closeConnection();
		
		return departments;
	}
	
	private Department mapDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		
		department.setDeptno(rs.getInt("deptno"));
		department.setDeptname(rs.getString("deptname"));
		Person p = new Person();
		p.setPersno(rs.getInt("depthead"));
		department.setDepthead(p);
		department.setSubDepartments(null);
		department.setFounded(rs.getDate("founded").toLocalDate());
		
		return department;
	}
}
