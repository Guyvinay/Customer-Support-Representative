package com.masai.Services;

import com.masai.DaoSer.CustomerDao;
import com.masai.DaoSer.CustomerDaoImpl;
import com.masai.Entities.Customer;
import com.masai.Entities.Issue;

public class CustomerSerImpl implements CustomerService{

	@Override
	public void addNewCustomer(Customer cus) {
		
		CustomerDao cusDao = new CustomerDaoImpl();
		
		cusDao.addNewCustomer(cus);
		
	}

	@Override
	public void createIssue(Issue issue) {
		

		CustomerDao cusDao = new CustomerDaoImpl();
		
		cusDao.createIssue(issue);
	}

	@Override
	public void viewAllIssuesAndGiveFeed(int id) {
	
		CustomerDao cusDao = new CustomerDaoImpl();
		cusDao.viewAllIssuesAndGiveFeed(id);
	}

}
