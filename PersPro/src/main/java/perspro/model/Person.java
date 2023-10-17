package perspro.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pers_proj.person")
public class Person {
	private int _persno;
	private String _fname;
	private String _lname;
	private Department _department;
	private BigDecimal _salary;
	private LocalDate _fdate;
	private LocalDate _ldate;
	private char _gender;
	private List<Project> _projects;
	
	@Id
	@Column(name = "persno")
	public int getPersno() {
		return _persno;
	}
	public void setPersno(int persno) {
		_persno = persno;
	}
	
	@Column(name = "fname")
	public String getFname() {
		return _fname;
	}
	public void setFname(String fname) {
		_fname = fname;
	}
	
	@Column(name = "lname")
	public String getLname() {
		return _lname;
	}
	public void setLname(String lname) {
		_lname = lname;
	}
	
	@ManyToOne
	@JoinColumn(name = "department")
	public Department getDepartment() {
		return _department;
	}
	public void setDepartment(Department department) {
		_department = department;
	}
	
	@Column(name = "salary")
	public BigDecimal getSalary() {
		return _salary;
	}
	public void setSalary(BigDecimal salary) {
		_salary = salary;
	}
	
	@Column(name = "fdate")
	public LocalDate getFdate() {
		return _fdate;
	}
	public void setFdate(LocalDate fdate) {
		_fdate = fdate;
	}
	
	@Column(name = "ldate")
	public LocalDate getLdate() {
		return _ldate;
	}
	public void setLdate(LocalDate ldate) {
		_ldate = ldate;
	}
	
	@Column(name = "gender")
	public char getGender() {
		return _gender;
	}
	public void setGender(char gender) {
		_gender = gender;
	}
	
	@ManyToMany
	@JoinTable(
			name = "pers_proj.pers_proj",
			joinColumns = { @JoinColumn(name = "persno")},
			inverseJoinColumns = { @JoinColumn(name = "projno")}
			)
	public List<Project> getProjects() {
		return _projects;
	}
	public void setProjects(List<Project> projects) {
		_projects = projects;
	}
}
