package com.masai.CustomerOPS;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Entities.LoggedCustomerId;
import com.masai.Enum.Category;
import com.masai.Enum.Feedback;
import com.masai.Enum.IssueStatus;
import com.masai.Services.CustomerSerImpl;
import com.masai.Services.CustomerService;

import com.masai.Services.GetCustomerCredImpl;
import com.masai.Services.GetCustomerCreds;

public class CustomerOperation {

	public void customerRegistration(Scanner sc) {
		
		System.out.println("Enter User_Name");
		String userName = sc.next();
		System.out.println("Enter PassWord");
		String passWord = sc.next();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Email");
		String email = sc.next();
		System.out.println("Enter Address");
		String address = sc.next();
		
		Customer cus = new Customer(userName, passWord, name, email, address , new HashSet<>() , new HashSet<>());
		
		CustomerService cusSer = new CustomerSerImpl();
		
		cusSer.addNewCustomer(cus);
		
	}
	
    public  void customerLogin(Scanner sc) {
		
		    System.out.println("Enter Admin UseName ");
		
		    String userName = sc.next();
		
		    System.out.println("Enter Admin PassWord ");
		
		    String passWord = sc.next();
		
		    GetCustomerCreds getCustomerCreds = new GetCustomerCredImpl();
		
		    List<Customer> customerUserPass = getCustomerCreds.getCustomerList();
		
		    customerUserPass.forEach( c -> {
			    if(c.getUserName().equals(userName)&&c.getPassWord().equals(passWord)) {	
				    System.out.println("Welcome Customer:- "+c.getName());
				    LoggedCustomerId.loggedCustomerId = c.getId();
//				    System.out.println(LoggedCustomerId.loggedCustomerId);
				    customerFieldsExc(sc);
			      }
		    });
			
	  }

      public static void customerFieldsExc(Scanner sc) {
	
	      int opt;
	
	      do {
	    	  System.out.println("Enter Your Preference...");
	    	  System.out.println();
		      displayCustomerFields();
		      opt = sc.nextInt();
		
		      switch(opt) {
		
		      case 1 -> raiseIssue(sc);
		      case 2 -> viewAllIssuesRaiseByMeAndGiveFeed();
		      case 3 -> viewStatusOfRaisedIssue();
		      case 0 -> System.out.println("Logged Out From Customer");
		
		      }
		
	      }while(opt!=0);
	
	
      }

      private static  void raiseIssue(Scanner sc) {
	          Category cate = null;
    	      int opt ;
    		  System.out.println("Select Issue Category"
    				      +"\n"+
    				      "1. PRODUCT ,"
    				      +"\n"+
    				      "2. SERVICE ,"
    				      +"\n"+
    				      "3. REFERRAL ,"
    				      +"\n"+
    				      "4. SUPPORT ,"
    				      +"\n"+
    				      "5. LEAVE ,"
    				      +"\n"+
    				      "Press Any. SUBMISSION ,"
    				      +"\n"
    				  );
    		  System.out.println();
        	  opt = sc.nextInt();
        	
    		  if(opt==1) cate = Category.PRODUCT;
    		  else if(opt==2) cate = Category.SERVICE;
    		  else if(opt==3) cate = Category.REFERRAL;
    		  else if(opt==4) cate = Category.SUPPORT;
    		  else if(opt==5) cate = Category.LEAVE;
    		  else cate = Category.SUBMISSION;
    		 
    	  Issue issue = new Issue(cate , LocalDate.now() , IssueStatus.OPEN , Feedback.YET_TO_BE_CLOSED , null);
    		  
    	  CustomerService cusSer = new CustomerSerImpl();
    	  
    	  cusSer.createIssue(issue);
    	 
	 
      }

      private static void  viewAllIssuesRaiseByMeAndGiveFeed() {
	  
    	  CustomerService cusSer = new CustomerSerImpl();
	 
    	  cusSer.viewAllIssuesAndGiveFeed(LoggedCustomerId.loggedCustomerId);
    	  
      }

      private static  void viewStatusOfRaisedIssue() {
	  
    	  CustomerService cusSer = new CustomerSerImpl();
    	  
    	  cusSer.viewAllIssuesAndGiveFeed(0);
	 
      }

      public static void displayCustomerFields() {
	
    	  System.out.println();
	      System.out.println(
			
		               "1. Raise an Issue"
	                           + "\n" +
	                   "2. View All Issues Raise By Me And Impart Feedback on"
	                           + "\n" +	  
	                   "3. View Status Of Raised Issue"
	                           + "\n" +
		               "0. Log out from the customer support representative account"
			             );
	      System.out.println();
      }
}
