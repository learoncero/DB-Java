package northwind.broker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import northwind.model.Customer;

public class CustomerBrokerJPA extends BrokerBaseJPA<Customer> {

	@Override
	public Customer get(int value) {
	    EntityManager entityManager = getEntityManager();
	    Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE customerID =: customerID");
	    query.setParameter("customerID", value);
	    Customer customer = (Customer)query.getSingleResult();
	    entityManager.close();
	    
	    return customer;
	}

	@Override
	public List<Customer> getAll() {
		EntityManager entityManager = getEntityManager();
		List<Customer> customers = (List<Customer>) entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
		entityManager.close();
		
		return customers;
	}
}
