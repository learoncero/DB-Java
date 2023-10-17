package northwind.model;

import java.util.List;
import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.supplier")
public class Supplier {
	private int _supplierID;
	private String _companyName;
	private String _contactName;
	private String _contactTitle;
	private Address _address;
	private String _phoneNumber;
	private String _faxNumber;
	private String _homePage;
	private List<Product> _products;

	@Id
	@NotNull
	@Column(name = "supplier_id")
	public int getSupplierID() {
		return _supplierID;
	}
	public void setSupplierID(int supplierID) {
		_supplierID = supplierID;
	}

	@NotNull
	@Column(name = "company_name")
	public String getCompanyName() {
		return _companyName;
	}
	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	@Column(name = "contact_name")
	public String getContactName() {
		return _contactName;
	}
	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	@Column(name = "contact_title")
	public String getContactTitle() {
		return _contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		_contactTitle = contactTitle;
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

	@Column(name = "phone")
	public String getPhoneNumber() {
		return _phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@Column(name = "fax")
	public String getFaxNumber() {
		return _faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;
	}

	@Column(name = "home_page")
	public String getHomePage() {
		return _homePage;
	}
	public void setHomePage(String homePage) {
		_homePage = homePage;
	}

	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
	public List<Product> getProducts() {
		return _products;
	}
	public void setProducts(List<Product> products) {
		_products = products;
	}
}