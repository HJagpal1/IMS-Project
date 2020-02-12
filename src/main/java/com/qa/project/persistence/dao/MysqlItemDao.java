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
import com.qa.project.controller.ItemsController;
import com.qa.project.persistence.domain.Items;

@SuppressWarnings("unused")

public class MysqlItemDao implements Dao<Items> {

	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);

	private Items itemsFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		Long itemId = resultSet.getLong("items_id");
		String itemName = resultSet.getString("items_name");
		int value = resultSet.getInt("items_value");
		return new Items(itemId, itemName, value);
	}

	@Override
	public ArrayList<Items> readAll() {
		ArrayList<Items> items = new ArrayList<Items>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://35.242.177.58:3306/LMS", "root",
				"QAConsulting69")) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from items");
			while (rs.next()) {
				Long itemId = rs.getLong("items_id");
				String itemName = rs.getString("items_name"); 
				int value = rs.getInt("items_value");
				Items item = new Items(itemId, itemName, value);
				items.add(item);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return items;
	}

	private Items readItem(Long id) {
		// TODO Auto-generated method stub
		Items cust = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM items where id = " + itemId);) {
			resultSet.next();
			cust = itemsFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return cust;
	}

	@Override
	public void create(Items items) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS")) {
			Statement statement = conn.createStatement();
			statement.executeUpdate("Insert into items(items_name) values('" + items.getItemName());
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(long id, Items t) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS")) {
			Statement statement = conn.createStatement();
			{
				statement.executeUpdate("update items set name = '" + t.getItemName() + "Where ID = " + t.getItemId());
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
			statement.executeUpdate("Delete from items where the ID = " + itemId);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}
}
