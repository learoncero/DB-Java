package northwind.broker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BrokerBaseJPA<T> {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory fact = Persistence.createEntityManagerFactory("northwind");
		EntityManager entityManager = fact.createEntityManager();
		
		return entityManager;
	}
	
	public void save(T value) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(value);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public  void delete(T value) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(value) ? value : entityManager.merge(value));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public abstract T get(int value);
	
	public abstract List<T> getAll();
}
