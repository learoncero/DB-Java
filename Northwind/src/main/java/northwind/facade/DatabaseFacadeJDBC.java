package northwind.facade;

import java.util.List;

import northwind.exception.NortwindPersistenceException;
import northwind.model.Customer;

public interface DatabaseFacadeJDBC {

	// INSERT
	public void insertObject(Object object) throws NortwindPersistenceException;
	
	// UPDATE
	public void updateObject(Object object) throws NortwindPersistenceException;
	
	// DELETE
	public void deleteObject(Object object) throws NortwindPersistenceException;
	
	// READ
	public Customer getCustomerByID(int customerID) throws NortwindPersistenceException;
	public List<Customer> getAllCustomers() throws NortwindPersistenceException;
}
