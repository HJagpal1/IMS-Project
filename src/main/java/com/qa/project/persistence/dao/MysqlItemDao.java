package com.qa.project.persistence.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.project.controller.CustomerController;
import com.qa.project.controller.ItemsController;
import com.qa.project.persistence.domain.Items;

@SuppressWarnings("unused")

public class MysqlItemDao implements Dao<Items> {

	public static final Logger LOGGER = Logger.getLogger(MysqlItemDao.class);

	
	private Items itemsFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		Long itemId = resultSet.getLong("items_id");
		String itemName = resultSet.getString("items_name");
		Long value = resultSet.getLong("items_value");
		return new Items(itemId, itemName, value);
	}

	
	/**
	 * readAll which show the user all items within the items table
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://35.242.177.58:3306/LMS", "root",
				"QAConsulting69")) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				Items item = itemsFromResultSet(resultSet);
				items.add(item);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return items;
	}
	
	
	
 /**
  * readItem will look for a certain item by searching for items id.
  * @param itemId
  * @return
  */
	private Items readItem(Long itemId) {
		// TODO Auto-generated method stub
		Items cust = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://35.242.177.58:3306/LMS");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM items where itemId = " + itemId);) {
			resultSet.next();
			cust = itemsFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return cust;
	}

	
	
	
	/**
	 * Will create a new item with in the table. 
	 */
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
	
	
	
	/**
	 * An item may need to be updated. 
	 */
	@Override
	public void update(long itemId, Items t) {
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
	
	
	
	/**
	 * Delete an item by searching for the name
	 */
	@Override
	public void delete(long itemId) {
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
