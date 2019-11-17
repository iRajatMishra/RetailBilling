package com.retailbilling.customerservice;

import java.util.List;

import com.retailbilling.customer.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomer(Long phoneNumber);
}
