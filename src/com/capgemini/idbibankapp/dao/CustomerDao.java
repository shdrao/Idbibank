package com.capgemini.idbibankapp.dao;

import java.sql.SQLException;
import java.util.Set;

import com.capgemini.idbibankapp.model.Customer;

public interface CustomerDao {
	public Customer authenticate(Customer customer) throws SQLException;

	public Customer updateProfile(Customer customer);

	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

	
}
