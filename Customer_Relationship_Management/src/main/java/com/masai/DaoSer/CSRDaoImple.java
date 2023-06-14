package com.masai.DaoSer;

import com.masai.Entities.Csr;
import com.masai.Utility.GetEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class CSRDaoImple implements CSRDao {

	
static EntityManagerFactory emf = GetEntityManagerFactory.getEntityManagerFactory();
	
	@Override
	public void addNewCSR(Csr csr) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			em.persist(csr);
			
			et.commit();
			
		} catch (Exception e) {
			
			et.rollback();
			
			System.out.println(e.getMessage());
			
		}finally {
			
			em.close();
			
		}
		
		
	}

}
