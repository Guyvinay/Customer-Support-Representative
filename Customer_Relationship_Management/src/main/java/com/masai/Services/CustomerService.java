package com.masai.Services;

import com.masai.Entities.Customer;
import com.masai.Entities.Issue;

public interface CustomerService {

	public void addNewCustomer(Customer cus);
	public void createIssue(Issue issue);
}
