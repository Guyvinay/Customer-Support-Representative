package com.masai.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_Support_Representatives")
public class Csr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CSR_User_Name" , nullable = false)
	private String userName;
	
	@Column(name = "CSR_User_Pass" , nullable = false)
	private String passWord;
	
	@Column(name = "CSR_Name")
	private String name;
	
	@Column(name = "CSR_eMail")
	private String eMail;
	

	@Column(name = "CSR_Address")
	private String address;
	
	public Csr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Csr(String userName, String passWord, String name, String eMail, String address) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.eMail = eMail;
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Csr [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", name=" + name + ", eMail="
				+ eMail + ", address=" + address + "]";
	}

	
}
