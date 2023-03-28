package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class CustomerDao 
{
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction();

public void save(Customer customer)
{
	transaction.begin();
	manager.persist(customer);
	transaction.commit();
}

public List<Customer> find(long mobile)
{
	return manager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mobile).getResultList();
}

public List<Customer> find(String email)
{
	return manager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
}
}
