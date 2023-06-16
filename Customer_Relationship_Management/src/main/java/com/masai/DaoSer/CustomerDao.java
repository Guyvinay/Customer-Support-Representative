package com.masai.DaoSer;

import com.masai.Entities.Customer;
import com.masai.Entities.Issue;

public interface CustomerDao {

	public void addNewCustomer(Customer cus);
	public void createIssue( Issue issue);
	public void viewAllIssuesAndGiveFeed(int id );
}
