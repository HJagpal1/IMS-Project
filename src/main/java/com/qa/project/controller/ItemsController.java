package com.qa.project.controller;

import org.apache.log4j.Logger;

import com.qa.project.persistence.domain.Items;
import com.qa.project.service.CrudService;
import com.qa.project.service.CustomerService;
import com.qa.project.utils.Utils;

@SuppressWarnings("unused")

public class ItemsController implements CrudController<Items> {
	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);
	
	private CrudService<Items> itemsService;
	
	public ItemsController (CrudService<Items> iS) {
		this.itemsService = iS;
	}
	
	private String getInput() {
		// TODO Auto-generated method stub
		return Utils.getInput();
	}
	
	/**
	 * Read All will read all the information within the customer table.
	 */
	@Override
	public void readAll() {
			for (Items item: itemsService.readAll()) {
				LOGGER.info(item.toString());
			}
	}
	
	
	/**
	 * Creating a customer which will appear on the database.
	 */
	@Override
	public void create() {
		LOGGER.info("Please can you enter you name");
		String itemsName = Utils.getInput();
		itemsService.create(new Items(itemsName, 0L));
		LOGGER.info("A new customer has been created");
	}
	
	
	/**
	 * A customers information will be updated.
	 * In this case the  information which will be edited will be 
	 */
	@Override
	public void update() {
		LOGGER.info("Please enter the id of the customer that needs updating");
		Long itemsId = Long.valueOf (getInput());
		LOGGER.info("Please enter the customer name");
		String itemsName = getInput();
		LOGGER.info("Enter new costing");
		Long value = Long.parseLong(getInput());
		itemsService.update(itemsId, new Items (itemsId,itemsName,value));
		LOGGER.info("The customers information has been updated");
	}
	
	
	/**
	 * Deleting customer details by entering the users id.
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the customers ID that needs to be deleted");
		Long itemsId = Long.valueOf(getInput());
		itemsService.delete(itemsId);
	}

}
