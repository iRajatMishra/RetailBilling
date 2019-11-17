package com.retailbilling.customerservice;

import java.util.ArrayList;
import java.util.List;

import com.retailbilling.customer.Customer;

public class CustomerServiceImpl implements CustomerService {

	private static List<Customer> custList = null;
	private static CustomerServiceImpl customerServiceImpl = null;

	private CustomerServiceImpl() {
	}

	public static CustomerServiceImpl getProductServiceImplInstance() {
		if (customerServiceImpl == null)
			customerServiceImpl = new CustomerServiceImpl();
		return customerServiceImpl;
	}

	@Override
	public void addCustomer(Customer customer) {
		if (custList == null)
			custList = new ArrayList<Customer>();
		custList.add(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custList;
	}

	@Override
	public Customer getCustomer(Long phoneNumber) {
		return custList.stream().filter(t -> t.getCustPhone().equals(phoneNumber)).findFirst().get();
	}

}
