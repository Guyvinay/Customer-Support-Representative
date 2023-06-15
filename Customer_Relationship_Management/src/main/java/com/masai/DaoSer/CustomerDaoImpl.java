package com.masai.DaoSer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.masai.Entities.Csr;
import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Entities.LoggedCustomerId;
import com.masai.Services.GetCSRCreds;
import com.masai.Services.GetCSRCredsImpl;
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
			
			GetCSRCreds getCSRCreds = new GetCSRCredsImpl();
			List<Csr> csrList = getCSRCreds.getCSRUserPass();
			
			for(Csr csr : csrList) {
//				System.out.println(csr.getCustomer());
				csr.getCustomer().add(cus);
				cus.getCsr().add(csr);			
				
			}
			
			
			et.begin();
			
			em.persist(cus);
			
			et.commit();
			
		} catch (Exception e) {
			
			et.rollback();
			e.printStackTrace();
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

	@Override
	public void viewAllIssuesAndGiveFeed(int id) {
		
		
		
		try(EntityManager em = emf.createEntityManager()){
			
            String getIssues = "SELECT c FROM Issue c WHERE c.customer_id=:id";
			
			Query createQuery = em.createQuery(getIssues);
			
			createQuery.setParameter("id", id);
			
			List<Issue> issueList = (List<Issue>) createQuery.getResultList();
			
			for(Issue is : issueList) {
				System.out.println(is);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
