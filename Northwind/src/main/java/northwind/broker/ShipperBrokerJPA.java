package northwind.broker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import northwind.model.Shipper;

public class ShipperBrokerJPA extends BrokerBaseJPA<Shipper> {

	@Override
	public Shipper get(int value) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Shipper s WHERE shipperID =: shipperID");
		query.setParameter("shipperID", value);
		Shipper shipper = (Shipper) query.getSingleResult();
		entityManager.close();
		
		return shipper;
	}

	@Override
	public List<Shipper> getAll() {
		EntityManager entityManager = getEntityManager();
		List<Shipper> shippers = (List<Shipper>) entityManager.createQuery("SELECT s FROM Shipper s", Shipper.class).getResultList();
		entityManager.close();
		
		return shippers;
	}
	
}
