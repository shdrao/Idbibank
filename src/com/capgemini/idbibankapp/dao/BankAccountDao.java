package com.capgemini.idbibankapp.dao;

import com.capgemini.idbibankapp.exceptions.UserNotFoundException;

public interface BankAccountDao {
	public double getBalance(long accountId) throws UserNotFoundException;

	public double updateBalance(long accountId, double newBalance);


}
