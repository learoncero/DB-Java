package northwind.model;

import java.util.List;
import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.customer")
public class Customer {
    private int _customerID;
    private String _customerCode;
    private String _companyName;
    private String _contactName;
    private String _contactTitle;
    private Address _address;
    private String _phoneNumber;
    private String _faxNumber;
    private List<Order> _orders;
    
    public Customer() {
    	
    }
    
    public Customer(int customerID, String customerCode, String companyName, String contactName, String contactTitle, Address address, String phone, String fax) {
    	_customerID = customerID;
    	_customerCode = customerCode;
    	_companyName = companyName; 
    	_contactName = contactName; 
    	_contactTitle = contactTitle;
    	_address = address;
    	_phoneNumber = phone;
    	_faxNumber = fax;
    }
    
    @Id
    @NotNull
    @Column(name = "customer_id")
    public int getCustomerID() {
        return _customerID;
    }
    public void setCustomerID(int customerID) {
        _customerID = customerID;
    }

    @NotNull
    @Column(name = "customer_code")
    public String getCustomerCode() {
        return _customerCode;
    }
    public void setCustomerCode(String customerCode) {
        _customerCode = customerCode;
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

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	public List<Order> getOrders() {
		return _orders;
	}
	public void setOrders(List<Order> orders) {
		_orders = orders;
	}
	
	@Override
	public String toString() {
		return "Customer ID: " + _customerID + ", Customer Code: " + _customerCode + ", Company Name: " + _companyName + ", Country: " + _address.getCountry() + "\n";
	}
}
