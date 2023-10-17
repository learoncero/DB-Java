package northwind.facade;

import java.util.List;

import northwind.broker.CustomerBrokerJPA;
import northwind.broker.OrderBrokerJPA;
import northwind.broker.ShipperBrokerJPA;
import northwind.model.Customer;
import northwind.model.Order;
import northwind.model.Shipper;

public class FacadeJPA implements DatabaseFacadeJPA {
	private static FacadeJPA _instance;
	
	private FacadeJPA() {}
	
	public static FacadeJPA getInstance() {
		if (_instance == null) {
			_instance = new FacadeJPA();
		}
		return _instance;
	}

	@Override
	public void saveObject(Object object) {
		if (object instanceof Customer) {
			CustomerBrokerJPA customerBroker = new CustomerBrokerJPA();
			customerBroker.save((Customer) object);
		}
		else if (object instanceof Shipper) {
			ShipperBrokerJPA shipperBroker = new ShipperBrokerJPA();
			shipperBroker.save((Shipper) object);
		}
		else if (object instanceof Order) {
			OrderBrokerJPA orderBroker = new OrderBrokerJPA();
			orderBroker.save((Order) object);
		}
	}

	@Override
	public void deleteObject(Object object) {
		if (object instanceof Customer) {
			CustomerBrokerJPA customerBroker = new CustomerBrokerJPA();
			customerBroker.delete((Customer) object);
		}
		else if (object instanceof Shipper) {
			ShipperBrokerJPA shipperBroker = new ShipperBrokerJPA();
			shipperBroker.delete((Shipper) object);
		}
		else if (object instanceof Order) {
			OrderBrokerJPA orderBroker = new OrderBrokerJPA();
			orderBroker.delete((Order) object);
		}
	}

	@Override
	public Customer getCustomerByID(int customerID) {
		CustomerBrokerJPA customerBroker = new CustomerBrokerJPA();
		Customer customer = customerBroker.get(customerID);
		
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		CustomerBrokerJPA customerBroker = new CustomerBrokerJPA();
		List<Customer> customers = customerBroker.getAll();
		
		return customers;
	}

	@Override
	public Order getOrderByID(int orderID) {
		OrderBrokerJPA orderBroker = new OrderBrokerJPA();
		Order order = orderBroker.get(orderID);
		
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		OrderBrokerJPA orderBroker = new OrderBrokerJPA();
		List<Order> orders = orderBroker.getAll();
		
		return orders;
	}

	@Override
	public Shipper getShipperByID(int shipperID) {
		ShipperBrokerJPA shipperBroker = new ShipperBrokerJPA();
		Shipper shipper = shipperBroker.get(shipperID);
		
		return shipper;
	}

	@Override
	public List<Shipper> getAllShippers() {
		ShipperBrokerJPA shipperBroker = new ShipperBrokerJPA();
		List<Shipper> shippers = shipperBroker.getAll();
		
		return shippers;
	}
}
