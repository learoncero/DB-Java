package northwind.facade;

import java.sql.SQLException;
import java.util.List;

import northwind.broker.CustomerBrokerJDBC;
import northwind.exception.NortwindPersistenceException;
import northwind.model.Customer;

public class FacadeJDBC implements DatabaseFacadeJDBC {
	private static FacadeJDBC _instance;

	private FacadeJDBC() {
	}
	
	public static FacadeJDBC getInstance() {
		if (_instance == null) {
			_instance = new FacadeJDBC();
		}
		return _instance;
	}
	
	public void insertObject(Object object) throws NortwindPersistenceException {
		if (object instanceof Customer) {
			CustomerBrokerJDBC customerBroker = new CustomerBrokerJDBC();
			try {
				customerBroker.insert((Customer) object);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NortwindPersistenceException("Kunde konnte nicht in die Datenbank gespeichert werden.");
			}
		}
	}
	
	@Override
	public void updateObject(Object object) throws NortwindPersistenceException {
		if (object instanceof Customer) {
			CustomerBrokerJDBC customerBroker = new CustomerBrokerJDBC();
			try {
				customerBroker.update((Customer) object);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NortwindPersistenceException("Kunde konnte nicht in der Datenbank aktualisiert werden.");
			}
		}
	}

	public void deleteObject(Object object) throws NortwindPersistenceException {
		if (object instanceof Customer) {
			CustomerBrokerJDBC customerBroker = new CustomerBrokerJDBC();
			try {
				customerBroker.delete((Customer) object);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NortwindPersistenceException("Kunde konnte nicht aus der Datenbank gelöscht werden.");
			}
		}
	}

	public Customer getCustomerByID(int customerID) throws NortwindPersistenceException {
		CustomerBrokerJDBC customerBroker = new CustomerBrokerJDBC();
		Customer customer = null;
		try {
			customer = customerBroker.get(customerID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NortwindPersistenceException("Kunde konnte nicht aus der Datenbank geladen werden.");
		}
		
		return customer;
	}

	public List<Customer> getAllCustomers() throws NortwindPersistenceException {
		CustomerBrokerJDBC customerBroker = new CustomerBrokerJDBC();
		List<Customer> customers = null;
		try {
			customers = customerBroker.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NortwindPersistenceException("Kunden konnten nicht aus der Datenbank geladen werden.");
		}
		
		return customers;
	}
}
