package com.capgemini.idbibankapp.service;

import com.capgemini.idbibankapp.exceptions.NegetiveBalanceException;
import com.capgemini.idbibankapp.exceptions.UserNotFoundException;

public interface BankAccountService {
	public double getBalance(long accountId) throws UserNotFoundException;

	public double withdraw(long accountId, double amount) throws UserNotFoundException, NegetiveBalanceException;

	public double deposit(long accountId, double amount) throws UserNotFoundException;

	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws NegetiveBalanceException, UserNotFoundException;

}
