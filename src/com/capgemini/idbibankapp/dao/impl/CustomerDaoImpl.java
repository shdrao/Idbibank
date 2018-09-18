package com.capgemini.idbibankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.capgemini.idbibankapp.dao.CustomerDao;
import com.capgemini.idbibankapp.dummy.DbUtil;
import com.capgemini.idbibankapp.model.BankAccount;
import com.capgemini.idbibankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public CustomerDaoImpl() {
		super();

	}

	@Override
	public Customer authenticate(Customer customer) {
		String query = "SELECT * FROM customers where customerId=?";
		String quer = "SELECT * FROM accounts where customerId=?";
		Customer customer1;
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);

				PreparedStatement statement2 = connection.prepareStatement(quer)) {
			statement.setInt(1, (int) customer.getCustomerId());
			ResultSet result = statement.executeQuery();
			statement2.setInt(1, (int) customer.getCustomerId());
			ResultSet result2 = statement2.executeQuery();
			while (result.next()) {

				customer1 = new Customer(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getDate(6), null);

				while (result2.next()) {
					BankAccount account1 = new BankAccount(result2.getLong(2), result2.getString(3),
							result2.getDouble(4));
					customer1.setAccount(account1);
					return customer1;
				}

			}
			return customer;
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer updateProfile(Customer customer) {
		String query = "SELECT * FROM customers where customerId=?";
		String quer = "SELECT * FROM accounts where customerId=?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);

				PreparedStatement statement2 = connection.prepareStatement(quer)) {
			statement.setInt(1, (int) customer.getCustomerId());
			ResultSet result = statement.executeQuery();
			statement2.setInt(1, (int) customer.getCustomerId());
			ResultSet result2 = statement2.executeQuery();
			while (result.next()) {

				Customer customer1 = new Customer(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), (result.getDate(6)), null);

				customer1.setAddress(customer.getAddress());
				customer1.setCustomerName(customer.getCustomerName());
				customer1.setEmail(customer.getEmail());

				String query1 = "update customers set customerName = ?,address=?,emailId=? where customerId = ?";
				PreparedStatement preparedStmt = connection.prepareStatement(query1);
				preparedStmt.setString(1, customer1.getCustomerName());

				preparedStmt.setString(2, customer1.getAddress());
				preparedStmt.setString(3, customer1.getEmail());
				preparedStmt.setInt(4, (int) customer1.getCustomerId());

				preparedStmt.executeUpdate();
				while (result2.next()) {
					BankAccount account1 = new BankAccount(result2.getLong(2), result2.getString(3),
							result2.getDouble(4));

					customer1.setAccount(account1);
					return customer1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		String query = "SELECT * FROM customers where customerId=?";
		String quer = "SELECT * FROM accounts where customerId=?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);

				PreparedStatement statement2 = connection.prepareStatement(quer)) {
			statement.setInt(1, (int) customer.getCustomerId());
			ResultSet result = statement.executeQuery();
			statement2.setInt(1, (int) customer.getCustomerId());
			ResultSet result2 = statement2.executeQuery();
			while (result.next()) {

				Customer customer1 = new Customer(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), (result.getDate(6)), null);

//				if (customer1.getCustomerId() == customer.getCustomerId()) {
				if (customer1.getPassword().equals(oldPassword)) {
					customer1.setPassword(newPassword);

					String query1 = "update customers set password = ? where customerId = ?";
					PreparedStatement preparedStmt = connection.prepareStatement(query1);
					preparedStmt.setString(1, customer1.getPassword());

					preparedStmt.setInt(2, (int) customer1.getCustomerId());

					preparedStmt.executeUpdate();

					while (result2.next()) {

						BankAccount account1 = new BankAccount(result2.getLong(2), result2.getString(3),
								result2.getDouble(4));
						customer1.setAccount(account1);
						return true;
					}

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
