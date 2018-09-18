package com.capgemini.idbibankapp.dummy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CustomerDatabase {
	public static void main(String[] args) {

		String query = "INSERT INTO customers VALUES(?,?,?,?,?,?)";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, 123456);
			statement.setString(2, "Sharath D Rao");
			statement.setString(3, "34");
			statement.setString(4, "sharathdrao@gmail.com");
			statement.setString(5, "CKP, Mumbai, Airoli");
			statement.setDate(6, Date.valueOf(LocalDate.of(1996, 03, 21)));
			if (statement.executeUpdate() != 0)
				System.out.println("Record inserted successfully");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
