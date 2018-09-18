package com.capgemini.idbibankapp.dummy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDatabase {
	public static void main(String[] args) {

		String query = "INSERT INTO accounts VALUES(?,?,?,?)";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setLong(1, 123456);
			statement.setLong(2,221701);
			statement.setString(3, "SAVINGS");
			statement.setDouble(4,  1000);
			
			if (statement.executeUpdate() != 0)
				System.out.println("Record inserted successfully");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
