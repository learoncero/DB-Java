package perspro.facade;

import java.util.List;

import perspro.model.Department;
import perspro.model.Person;
import perspro.model.Project;

public interface DatabaseFacade {
	
	// INSERT + UPDATE
	public void saveObject(Object object);
	
	// DELETE
	public void deleteObject(Object object);
	
	// READ
	public Person getPersonByID(int id);
	public List<Person> getAllPersons();
	
	public Department getDepartmentByNo(int deptno);
	public List<Department> getAllDepartments();
	
	public Project getProjectByNo(int projno);
	public List<Project> getAllProjects();
	
}
