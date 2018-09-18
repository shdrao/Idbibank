package com.capgemini.idbibankapp.service;

import java.sql.SQLException;

import com.capgemini.idbibankapp.exceptions.UserNotFoundException;
import com.capgemini.idbibankapp.model.Customer;

public interface CustomerService {
	public Customer authenticate(Customer customer)  throws UserNotFoundException, SQLException;
 
	public Customer updateProfile(Customer customer);

	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

}
