package com.qa.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.project.controller.CustomerController;
import com.qa.project.persistence.domain.Customer;
import com.qa.project.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
		
		/**
		 *  The thing I want to fake functionlity for
		 */
		@Mock
		private CustomerService customerServices;
		
		/**
		 * Spy is used because i want to mock some methods inside the item I'm testing
		 * InjectMocks uses dependency injection to insert the mock into the customer controller
		 */
		@Spy
		@InjectMocks
		private CustomerController customerController;

		@Test
		public void readAllTest() {
			CustomerController customerController = new CustomerController(customerServices);
			List<Customer> customers = new ArrayList<>();
			customers.add(new Customer("Chris Perrins"));
			customers.add(new Customer("Jeevan Jagpal"));
			customers.add(new Customer("Fred Berry"));
			Mockito.when(customerServices.readAll()).thenReturn(customers);
			customerController.readAll();
			Mockito.verify(customerController, Mockito.times(1)).readAll();
		}

		@Test
		public void createTest() {
			String firstName = "Chris Perrins";
			Mockito.doReturn(firstName).when(customerController).getInput();
			Customer customer = new Customer(firstName);
			Customer savedCustomer = new Customer(1L, "Chris Perrins");
			//customerController.create();
			Mockito.verify(customerController, Mockito.times(1)).create();
		}

		/**
		 * 
		 */
		@Test
		public void updateTest() {
			String id = "1";
			String firstName = "Rhys Thompson";
			Mockito.doReturn(id, firstName).when(customerController).getInput();
			Customer customer = new Customer(1L, firstName);
			//Mockito.when(customerServices.update(0L, customer)).thenReturn(customer);
			customerController.update();
			Mockito.verify(customerController, Mockito.times(1)).update();
		}
		

		/**
		 * Delete doesn't return anything, so we can just verify that it calls the delete method
		 */
		@Test
		public void deleteTest() {
			String id = "1";
			Mockito.doReturn(id).when(customerController).getInput();
			customerController.delete();
			Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
		}
		
	}