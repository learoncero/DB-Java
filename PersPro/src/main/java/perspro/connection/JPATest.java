package perspro.connection;

import java.util.List;

import javax.persistence.*;

import perspro.model.Department;
import perspro.model.Person;

public class JPATest {

	public static void main(String[] args) {
		EntityManagerFactory fact = Persistence.createEntityManagerFactory("pers_proj");
		EntityManager entityManager = fact.createEntityManager();
		/*
		List<Person> persons = (List<Person>) entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		for (Person p : persons) {
			System.out.println(p.getFname());
		}
		*/
		
		List<Department> departments = (List<Department>) entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
		for (Department d : departments) {
			System.out.println(d.getDepthead().getFname());
		}
	}
}
