package com.capgemini.idbibankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.capgemini.idbibankapp.dao.BankAccountDao;
import com.capgemini.idbibankapp.dummy.DbUtil;
import com.capgemini.idbibankapp.exceptions.UserNotFoundException;
import com.capgemini.idbibankapp.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {

	public BankAccountDaoImpl() {
		super();

	}

	@Override
	public double getBalance(long accountId) throws UserNotFoundException {
		String query = "SELECT * FROM accounts where accountId=?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)){
			
			statement.setLong(1, accountId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				
				return result.getDouble(4);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new UserNotFoundException("No Account found");
	}

	@Override
	public double updateBalance(long accountId, double newBalance) {
		
		
		String query = "update accounts set balance = ? where accountId = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {


			
			statement.setDouble(1, newBalance);
			statement.setInt(2, (int) accountId);
			statement.executeUpdate();
			
			
			
			
			return newBalance;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
