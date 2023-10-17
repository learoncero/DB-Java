package northwind.facade;

import java.util.List;

import northwind.model.Customer;
import northwind.model.Order;
import northwind.model.Shipper;

public interface DatabaseFacadeJPA {
	// INSERT + UPDATE
	public void saveObject(Object object);
	
	// DELETE
	public void deleteObject(Object object);
	
	// READ
	public Customer getCustomerByID(int customerID);
	public List<Customer> getAllCustomers();
	public Order getOrderByID(int orderID);
	public List<Order> getAllOrders();
	public Shipper getShipperByID(int shipperID);
	public List<Shipper> getAllShippers();
}
