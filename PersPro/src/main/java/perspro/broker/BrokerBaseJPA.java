package perspro.broker;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BrokerBaseJPA<T> {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory fact = Persistence.createEntityManagerFactory("pers_proj");
		EntityManager entityManager = fact.createEntityManager();
		
		return entityManager;
	}
	
	public abstract void save(T value) throws SQLException;
	
	public abstract void delete(T value) throws SQLException;
	
	public abstract T get(int value) throws SQLException;
	
	public abstract List<T> getAll() throws SQLException;
}
