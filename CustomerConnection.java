package com.jspider.jdbc_prepared_statement_crud_project_architecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CustomerConnection {
	public static Connection getCustomerConnection() {
		try {
			Driver drive = new Driver();
			DriverManager.registerDriver(drive);
			String url = "jdbc:mysql://localhost:3306/jdbc-e4";
			String user = "root";
			String password = "Vinityadav@123";
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
