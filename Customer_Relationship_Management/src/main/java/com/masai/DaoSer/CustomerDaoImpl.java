package com.masai.DaoSer;

import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Entities.LoggedCustomerId;
import com.masai.Utility.GetEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerDaoImpl implements CustomerDao{

	static EntityManagerFactory emf = GetEntityManagerFactory.getEntityManagerFactory();
	
	@Override
	public void addNewCustomer(Customer cus) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			em.persist(cus);
			
			et.commit();
			
		} catch (Exception e) {
			
			et.rollback();
			
			System.out.println(e.getMessage());
			
		}finally {
			
			em.close();
			
		}
	}

	@Override
	public void createIssue(Issue issue) {
	
		EntityManager em = null;
		EntityTransaction et = null;
		
        try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			Query q = em.createQuery("SELECT c FROM Customer c WHERE c.id = :id");
			q.setParameter("id", LoggedCustomerId.loggedCustomerId);
			Customer cus = (Customer)q.getSingleResult();

			issue.setCustomer(cus);
			cus.getIssues().add(issue);
			et.begin();
			em.persist(issue);
			et.commit();
			
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			em.close();	
		}	
	}

}
