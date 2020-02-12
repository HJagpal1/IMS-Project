package com.qa.project.persistence.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.project.controller.CustomerController;
import com.qa.project.persistence.domain.Customer;

@SuppressWarnings("unused")

public class MysqlCustomerDao implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		Long id = resultSet.getLong("id");
		String firstname = resultSet.getString("customer_name");
		return new Customer(id, firstname);
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://35.242.177.58:3306/LMS", "root",
				"QAConsulting69")) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from customers");
			while (rs.next()) {
				Long id = rs.getLong("customer_id");
				String name = rs.getString("customer_name");
				Customer customer = new Customer(id, name);
				customers.add(customer);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customers;
	}

	private Customer readCust(Long id) {
		// TODO Auto-generated method stub
		Customer cust = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM customers where id = " + id);) {
			resultSet.next();
			cust = customerFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return cust;
	}

	@Override
	public void create(Customer customer) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS")) {
			Statement statement = conn.createStatement();
			statement.executeUpdate("Insert into customers(customer_name) values('" + customer.getFirstname());
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(long id, Customer t) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS")) {
			Statement statement = conn.createStatement();
			{
				statement.executeUpdate("update customers set name = '" + t.getFirstname() + "Where ID = " + t.getId());
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS")) {
			Statement statement = conn.createStatement();
			statement.executeUpdate("Delete from customer where the ID = " + id);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}
}
