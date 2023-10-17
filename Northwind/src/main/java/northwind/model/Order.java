package northwind.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.orders")
public class Order {
    private int _orderID;
    private Customer _customer;
    private Employee _employee;
    private LocalDate _orderDate;
    private LocalDate _requiredDate;
    private LocalDate _shippedDate;
    private Shipper _shipper;
    private BigDecimal _freightNumber;
    private String _shipName;
    private Address _address;
    private List<OrderDetail> _orderDetails;

	@Id
	@NotNull
	@Column(name = "order_id")
    public int getOrderID() {
        return _orderID;
    }
    public void setOrderID(int orderID) {
        _orderID = orderID;
    }

    @NotNull
    @ManyToOne
	@JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return _customer;
    }
    public void setCustomer(Customer customer) {
        _customer = customer;
    }

    @NotNull
    @ManyToOne
	@JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return _employee;
    }
    public void setEmployee(Employee employee) {
        _employee = employee;
    }

    @NotNull
    @Column(name = "order_date")
    public LocalDate getOrderDate() {
        return _orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        _orderDate = orderDate;
    }

    @Column(name = "required_date")
    public LocalDate getRequiredDate() {
        return _requiredDate;
    }
    public void setRequiredDate(LocalDate requiredDate) {
        _requiredDate = requiredDate;
    }

    @Column(name = "shipped_date")
    public LocalDate getShippedDate() {
        return _shippedDate;
    }
    public void setShippedDate(LocalDate shippedDate) {
        _shippedDate = shippedDate;
    }

    @ManyToOne
	@JoinColumn(name = "ship_via")
    public Shipper getShipper() {
        return _shipper;
    }
    public void setShipper(Shipper shipper) {
        _shipper = shipper;
    }

    @Column(name = "freight")
    public BigDecimal getFreightNumber() {
        return _freightNumber;
    }
    public void setFreightNumber(BigDecimal freightNumber) {
        _freightNumber = freightNumber;
    }

    @Column(name = "ship_name")
    public String getShipName() {
        return _shipName;
    }
    public void setShipName(String shipName) {
        _shipName = shipName;
    }

    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name = "street", column = @Column(name = "ship_address")),
    	@AttributeOverride(name = "city", column = @Column(name = "ship_city")),
    	@AttributeOverride(name = "region", column = @Column(name = "ship_region")),
    	@AttributeOverride(name = "postalCode", column = @Column(name = "ship_postal_code")),
    	@AttributeOverride(name = "country", column = @Column(name = "ship_country"))
    })
    public Address getAddress() {
        return _address;
    }
    public void setAddress(Address address) {
        _address = address;
    }

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	public List<OrderDetail> getOrderDetails() {
		return _orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		_orderDetails = orderDetails;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + _orderID + ", Customer: " + _customer.getCompanyName() + ", Order Date: " + _orderDate + "\n";
	}
}
