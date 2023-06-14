package com.masai.CSR_OPS;

import java.util.List;
import java.util.Scanner;

import com.masai.Entities.Csr;
import com.masai.Entities.Customer;
import com.masai.Services.CSRServices;
import com.masai.Services.CSRServicesImple;
import com.masai.Services.GetCSRCreds;
import com.masai.Services.GetCSRCredsImpl;
import com.masai.Services.GetCustomerCredImpl;
import com.masai.Services.GetCustomerCreds;

public class CSROperation {

	public  void csrLogin(Scanner sc) {
		
		System.out.println("Enter Admin UseName ");
		
		String userName = sc.next();
		
		System.out.println("Enter Admin PassWord ");
		
		String passWord = sc.next();
		
		GetCSRCreds getCSRCreds = new GetCSRCredsImpl();
		
		List<Csr> csrUserPass = getCSRCreds.getCSRUserPass();
		
		csrUserPass.forEach( c -> {
			if(c.getUserName().equals(userName)&&c.getPassWord().equals(passWord)) {	
				System.out.println("Welcome CSR:- "+c.getName());
				adminFieldsExc(sc);
			  }
		});
			
		
//		for(Csr csr : csrUserPass) {
//			
//			if(userName.equals(csr.getUserName()) && passWord.equals(csr.getPassWord())) {
//				System.out.println("Welcome CSR:- "+csr.getName());
//				adminFieldsExc(sc);
//			}
//			else {
//				System.out.println("Entered Wrong Credential");
//				System.out.println();
//			}
//			
//		}


	}
	
	public  void csrRegistratiion(Scanner sc) {
		
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
		
		Csr csr = new Csr(userName, passWord, name, email, address);
		
		CSRServices csrSer = new CSRServicesImple();
		
		csrSer.addNewCSR(csr);
		
	}
		
public static void adminFieldsExc(Scanner sc) {
		
		int opt;
		
		do {
			displayAdminFields();
			System.out.println("Enter Your Preference...");
			opt = sc.nextInt();
			
			switch(opt) {
			
			case 1 -> viewAllIssues();
			case 2 -> viewAllCustomers();
			case 3 -> replyToCusIssue();
			case 4-> closeCustomerIssue();
			case 5 -> viewFeedBackByCustomers();
			
			}
			
		}while(opt!=0);
		
		
	}
	

private static void viewAllIssues() {
	 
	
	 
}

private static void viewAllCustomers() {
	 
GetCustomerCreds getCustomerCreds = new GetCustomerCredImpl();
	
	List<Customer> customerList = getCustomerCreds.getCustomerList();
	
	
	customerList.forEach(System.out::println);
	
	
}

private static void replyToCusIssue() {
	 
	 
}

private static void closeCustomerIssue() {
	 
	 
}

private static void viewFeedBackByCustomers() {
	 
	 
}

public static void displayAdminFields() {
	
	System.out.println(
			
		  "1. View All Issues of Customers"
	                  + "\n" +
	      "2. View All Customers"
	                  + "\n" +	  
	      "3. Reply to customer issues"
	                  + "\n" +
		  "4. Close the customer issues"
	                  + "\n" +
	      "5. View feedback given by customers on closed issues"
	                  + "\n" +
		  "0. Log out from the customer support representative account"
			
			);
	
}

	
	
}
