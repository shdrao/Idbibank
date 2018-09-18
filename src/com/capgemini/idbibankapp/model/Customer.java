package com.capgemini.idbibankapp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Customer {

	private long customerId;
	private String customerName;
	private String password;
	private String email;
	private String address;
	private Date dateOfBirth;
	private BankAccount account;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String password, String email, String address, Date dateOfBirth,
			BankAccount account) {
		super();
		Random rand = new Random();
		this.customerId = 500000 + rand.nextInt(9000);
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.account = account;
	}
	
	public Customer(long customerId, String customerName, String password, String email, String address, Date dateOfBirth,
			BankAccount account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.account = account;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
