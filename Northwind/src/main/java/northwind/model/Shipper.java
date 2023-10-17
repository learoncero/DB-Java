package northwind.model;

import java.util.List;
import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.shipper")
public class Shipper {
    private int _shipperID;
    private String _companyName;
    private String _phoneNumber;
    private List<Order> _orders;

    @Id
    @NotNull
	@Column(name = "shipper_id")
    public int getShipperID() {
        return _shipperID;
    }
    public void setShipperID(int shipperID) {
        _shipperID = shipperID;
    }
    
    @NotNull
    @Column(name = "company_name")
    public String getCompanyName() {
        return _companyName;
    }
    public void setCompanyName(String companyName) {
        _companyName = companyName;
    }

    @Column(name = "phone")
    public String getPhoneNumber() {
        return _phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "shipper", fetch = FetchType.EAGER)
	public List<Order> getOrders() {
		return _orders;
	}
	public void setOrders(List<Order> orders) {
		_orders = orders;
	}
	
	@Override
	public String toString() {
		return "Shipper ID: " + _shipperID + ", Company Name: " + _companyName + ", Phone Number: " + _phoneNumber + "\n";
	}
}
