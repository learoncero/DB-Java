package perspro.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pers_proj.department")
public class Department {
	private int _deptno;
	private String _deptname;
	private Person _depthead;
	private BigDecimal _budget;
	private Department _inDept;
	private LocalDate _founded;
	private List<Person> _personsInDepartment;
	private List<Department> _subDepartments;
	
	@Id
	@Column(name = "deptno")
	public int getDeptno() {
		return _deptno;
	}
	public void setDeptno(int deptno) {
		_deptno = deptno;
	}
	
	@Column(name = "deptname")
	public String getDeptname() {
		return _deptname;
	}
	public void setDeptname(String deptname) {
		_deptname = deptname;
	}
	
	@ManyToOne
	@JoinColumn(name = "depthead")
	public Person getDepthead() {
		return _depthead;
	}
	public void setDepthead(Person depthead) {
		_depthead = depthead;
	}
	
	@Column(name = "budget")
	public BigDecimal getBudget() {
		return _budget;
	}
	public void setBudget(BigDecimal budget) {
		_budget = budget;
	}
	
	@ManyToOne
	@JoinColumn(name = "in_dept")
	public Department getInDept() {
		return _inDept;
	}
	public void setInDept(Department inDept) {
		_inDept = inDept;
	}
	
	@Column(name = "founded")
	public LocalDate getFounded() {
		return _founded;
	}
	public void setFounded(LocalDate founded) {
		_founded = founded;
	}
	
	@OneToMany(mappedBy = "department")
	public List<Person> getPersonsInDepartment() {
		return _personsInDepartment;
	}
	public void setPersonsInDepartment(List<Person> personsInDepartment) {
		_personsInDepartment = personsInDepartment;
	}
	
	@OneToMany(mappedBy = "inDept")
	public List<Department> getSubDepartments() {
		return _subDepartments;
	}
	public void setSubDepartments(List<Department> subDepartments) {
		_subDepartments = subDepartments;
	}
	
}
