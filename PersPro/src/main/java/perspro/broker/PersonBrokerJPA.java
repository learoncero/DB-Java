package perspro.broker;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.*;

import perspro.model.Person;

public class PersonBrokerJPA extends BrokerBaseJPA<Person> {

	@Override
	public void save(Person value) throws SQLException {
		EntityManager entityManager = getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(value);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(Person value) throws SQLException {
		EntityManager entityManager = getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(value);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	public Person get(int persno) throws SQLException {
		EntityManager entityManager = getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Query jpqlQuery = entityManager.createQuery("SELECT p FROM Person p WHERE p.persno=:id");
			jpqlQuery.setParameter("id", persno);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
		} finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}
		return (Person) jpqlQuery.getSingleResult();
	}
	
	public List<Person> getAll() throws SQLException {
		EntityManager entityManager = getEntityManager();
		
		List<Person> persons = (List<Person>) entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		
		entityManager.close();
		
		return persons;
	}
	
	public static void main(String[] args) {
		PersonBrokerJPA pbJPA = new PersonBrokerJPA();
		Person p = pbJPA.get(1);
		System.out.println(p.getFname());
	}
	
}
