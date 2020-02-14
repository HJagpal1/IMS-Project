package com.qa.project.controller;

import org.apache.log4j.Logger;

import com.qa.project.persistence.domain.Customer;
import com.qa.project.service.CrudService;
import com.qa.project.service.CustomerService;
import com.qa.project.utils.Utils;

@SuppressWarnings("unused")

public class CustomerController implements CrudController<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudService<Customer> customerService;
	
	public CustomerController (CrudService<Customer> cS) {
		this.customerService = cS;
	}
	
	public String getInput() {
		// TODO Auto-generated method stub
		return Utils.getInput();
	}
	
	/**
	 * Read All will read all the information within the customer table.
	 */
	@Override
	public void readAll() {
			for (Customer customer: customerService.readAll()) {
				LOGGER.info(customer.toString());
			}
	}
	
	
	/**
	 * Creating a customer which will appear on the database.
	 */
	@Override
	public void create() {
		LOGGER.info("Please can you enter you name");
		String name = Utils.getInput();
		customerService.create(new Customer(name));
		LOGGER.info("A new customer has been created");
	}
	
	
	/**
	 * A customers information will be updated.
	 * In this case the  information which will be edited will be 
	 */
	@Override
	public void update() {
		LOGGER.info("Please enter the id of the customer that needs updating");
		Long id = Long.valueOf (getInput());
		LOGGER.info("Please enter the customer name");
		String firstname = getInput();
		customerService.update(id, new Customer (id,firstname));
		LOGGER.info("The customers information has been updated");
	}
	
	/**
	 * Deleting customer details by entering the users id.
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the customers ID that needs to be deleted");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);
	}

}
