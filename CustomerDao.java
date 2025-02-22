package com.jspider.jdbc_prepared_statement_crud_project_architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.connection.CustomerConnection;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;
import com.jspider.jdbc_simple_crud_opration_prepared_statement.entity.Product;

/**
 * 
 * @author Vinityadav
 *
 */
public class CustomerDao {
	Connection connection = CustomerConnection.getCustomerConnection();
	final String INSERT_CUSTOMER_QUERY = "insert into customer (id,name,email,phone) values(?,?,?,?)";
	final String DISPLAY_CUSTOMER_BY_ID = "select * from customer where id=?";
	final String UPDATE_CUSTOMER_BY_ID = "update  customer set name=? where id=?";
	final String DELETE_CUSTOMER_BY_ID = "delete from customer where id=?";
	final String DISPLAY_ALLCUSTOMER_BY_ID = "select * from customer ";

	public int saveCustomerDao(Customer customer) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER_QUERY);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Customer displayCustomerbyId(int id) {
		// String displayCustomerbyIdQuery = "select * from customer where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAY_CUSTOMER_BY_ID);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				int id1 = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");

				Customer customer = new Customer();
				customer.setId(id1);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				return customer;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// return null;
	}

	public int updateCustomerDao(int id, String name) {
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);

			ps.setString(1, name);
			ps.setInt(2, id);

			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean deleteCustomerbyId(int id) {
		// String displayCustomerbyIdQuery = "select * from customer where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			if (result != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// return null;
	}

	public List<Customer> displayAllCustomerbyId(int id) {
		// String displayCustomerbyIdQuery = "select * from customer where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAY_ALLCUSTOMER_BY_ID);

			ResultSet set = ps.executeQuery();
			List<Customer> customers = new ArrayList<>();
			while (set.next()) {
				int id1 = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");

				Customer customer = new Customer();
				customer.setId(id1);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				customers.add(customer);

			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// return null;

	}
}
