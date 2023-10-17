package northwind.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.employee")
public class Employee {
	private int _employeeID;
	private String _lastName;
	private String _firstName;
	private String _title;
	private String _titleOfCourtesy;
	private LocalDate _birthdate;
	private LocalDate _hireDate;
	private Address _address;
	private String _homePhoneNumber;
	private String _internalPhoneExtension;
	private String _photo;
	private String _notes;
	private Employee _reportsTo;
	private List<Order> _orders;
	private List<Employee> _subordinates;
	
	@Id
	@NotNull
	@Column(name = "employee_id")
	public int getEmployeeID() {
		return _employeeID;
	}
	public void setEmployeeID(int employeeID) {
		_employeeID = employeeID;
	}
	
	@NotNull
	@Column(name = "lastname")
	public String getLastName() {
		return _lastName;
	}
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@NotNull
	@Column(name = "firstname")
	public String getFirstName() {
		return _firstName;
	}
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Column(name = "title")
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		_title = title;
	}

	@Column(name = "title_of_courtesy")
	public String getTitleOfCourtesy() {
		return _titleOfCourtesy;
	}
	public void setTitleOfCourtesy(String titleOfCourtesy) {
		_titleOfCourtesy = titleOfCourtesy;
	}

	@Column(name = "birthdate")
	public LocalDate getBirthdate() {
		return _birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		_birthdate = birthdate;
	}

	@Column(name = "hiredate")
	public LocalDate getHireDate() {
		return _hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		_hireDate = hireDate;
	}

	@Embedded
    @AttributeOverrides({
    	@AttributeOverride(name = "street", column = @Column(name = "address")),
    	@AttributeOverride(name = "city", column = @Column(name = "city")),
    	@AttributeOverride(name = "region", column = @Column(name = "region")),
    	@AttributeOverride(name = "postalCode", column = @Column(name = "postal_code")),
    	@AttributeOverride(name = "country", column = @Column(name = "country"))
    })
	public Address getAddress() {
		return _address;
	}
	public void setAddress(Address address) {
		_address = address;
	}

	@Column(name = "home_phone")
	public String getHomePhoneNumber() {
		return _homePhoneNumber;
	}
	public void setHomePhoneNumber(String homePhoneNumber) {
		_homePhoneNumber = homePhoneNumber;
	}

	@Column(name = "extension")
	public String getInternalPhoneExtension() {
		return _internalPhoneExtension;
	}
	public void setInternalPhoneExtension(String internalPhoneExtension) {
		_internalPhoneExtension = internalPhoneExtension;
	}

	@Column(name = "photo")
	public String getPhoto() {
		return _photo;
	}
	public void setPhoto(String photo) {
		_photo = photo;
	}

	@Column(name = "notes")
	public String getNotes() {
		return _notes;
	}
	public void setNotes(String notes) {
		_notes = notes;
	}

	@ManyToOne
	@JoinColumn(name = "reports_to")
	public Employee getReportsTo() {
		return _reportsTo;
	}
	public void setReportsTo(Employee reportsTo) {
		_reportsTo = reportsTo;
	}

	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	public List<Order> getOrders() {
		return _orders;
	}
	public void setOrders(List<Order> orders) {
		_orders = orders;
	}

	@OneToMany(mappedBy = "reportsTo", fetch = FetchType.EAGER)
	public List<Employee> getSubordinates() {
		return _subordinates;
	}
	public void setSubordinates(List<Employee> subordinates) {
		_subordinates = subordinates;
	}
}
