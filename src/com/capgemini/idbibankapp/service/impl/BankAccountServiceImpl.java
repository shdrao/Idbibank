package com.capgemini.idbibankapp.service.impl;

import com.capgemini.idbibankapp.dao.BankAccountDao;
import com.capgemini.idbibankapp.dao.impl.BankAccountDaoImpl;
import com.capgemini.idbibankapp.exceptions.NegetiveBalanceException;
import com.capgemini.idbibankapp.exceptions.UserNotFoundException;
import com.capgemini.idbibankapp.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {
	private BankAccountDao bankAccountDao;

	public BankAccountServiceImpl() {
		super();
		bankAccountDao = new BankAccountDaoImpl();
	}

	@Override
	public double getBalance(long accountId) throws UserNotFoundException {
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws NegetiveBalanceException, UserNotFoundException {
		double balance = bankAccountDao.getBalance(accountId);
		if (balance >= amount) {
			return bankAccountDao.updateBalance(accountId, balance - amount);
		} else {
			throw new NegetiveBalanceException("Insufficient Balance");
		}

	}

	@Override
	public double deposit(long accountId, double amount) throws UserNotFoundException {
		return bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId) + amount);
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)
			throws NegetiveBalanceException, UserNotFoundException {
		if (amount < 0) {
			throw new NegetiveBalanceException("Entered balance is negetive");
		}
		withdraw(fromAcc, amount);
		deposit(toAcc, amount);
		return true;

//		return false;

	}
}
