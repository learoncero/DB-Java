package perspro.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pers_proj.project")
public class Project {
	private int _projno;
	private String _projname;
	private Person _projhead;
	private Project _inProj;
	private List<Person> _personsInProject;
	private List<Project> _subProjects;
	
	@Id
	@Column(name = "projno")
	public int getProjno() {
		return _projno;
	}
	public void setProjno(int projno) {
		_projno = projno;
	}
	
	@Column(name = "projname")
	public String getProjname() {
		return _projname;
	}
	public void setProjname(String projname) {
		_projname = projname;
	}
	
	@ManyToOne
	@JoinColumn(name = "projhead")
	public Person getProjhead() {
		return _projhead;
	}
	public void setProjhead(Person projhead) {
		_projhead = projhead;
	}
	
	@ManyToOne
	@JoinColumn(name = "in_proj")
	public Project getInProj() {
		return _inProj;
	}
	public void setInProj(Project inProj) {
		_inProj = inProj;
	}
	
	@ManyToMany(mappedBy = "projects")
	public List<Person> getPersonsInProject() {
		return _personsInProject;
	}
	public void setPersonsInProject(List<Person> personsInProject) {
		_personsInProject = personsInProject;
	}
	
	@ManyToMany(mappedBy = "inProj")
	public List<Project> getSubProjects() {
		return _subProjects;
	}
	public void setSubProjects(List<Project> subProjects) {
		_subProjects = subProjects;
	}
}
