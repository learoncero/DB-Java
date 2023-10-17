package northwind.broker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import northwind.model.Order;


public class OrderBrokerJPA extends BrokerBaseJPA<Order> {

	@Override
	public Order get(int value) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT o FROM Order o WHERE orderID =: orderID");
		query.setParameter("orderID", value);
		Order order = (Order) query.getSingleResult();
		entityManager.close();
		
		return order;
	}

	@Override
	public List<Order> getAll() {
		EntityManager entityManager = getEntityManager();
		List<Order> orders = (List<Order>) entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
		entityManager.close();
		
		return orders;
	}

}
