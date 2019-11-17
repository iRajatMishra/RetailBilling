package com.retailbilling.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.retailbilling.bill.Bill;
import com.retailbilling.billservice.BillServiceImpl;
import com.retailbilling.customer.Customer;
import com.retailbilling.customerservice.CustomerServiceImpl;
import com.retailbilling.product.Product;
import com.retailbilling.productservice.ProductServiceImpl;

class TestRetailBilling {
	
	void setup() {
		
	}

	@Test
	void test1() {

		Customer c1 = new Customer();
		c1.setCustName("Bob");
		c1.setCustPhone(9392939292L);
		c1.setCustType("Other");
		c1.setJoinDate("11/11/2007");

		Product p1 = new Product();
		p1.setProdId(1);
		p1.setProdPrice(1000);
		p1.setProdQuant(2);
		p1.setProdType("non grocery");
		p1.setProdName("Table");

		Product p2 = new Product();
		p2.setProdId(2);
		p2.setProdPrice(200);
		p2.setProdQuant(3);
		p2.setProdType("non grocery");
		p2.setProdName("Chair");
		
		ProductServiceImpl productServiceImpl = ProductServiceImpl.getProductServiceImplInstance();
		CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getProductServiceImplInstance();
		
		productServiceImpl.addProduct(p1);
		productServiceImpl.addProduct(p2);
		
		customerServiceImpl.addCustomer(c1);
		
		List<Integer> prodIds = new ArrayList<Integer>();
		prodIds.add(1);
		prodIds.add(2);

		BillServiceImpl billing = new BillServiceImpl();
		Bill bill = billing.getBill(prodIds, 9392939292L);

		assertEquals(2340, bill.getDiscountedAmount());
	}

	@Test
	void test2() {

		Customer c1 = new Customer();
		c1.setCustName("Bob");
		c1.setCustPhone(9392939293L);
		c1.setCustType("Other");
		c1.setJoinDate("11/11/2007");

		Product p1 = new Product();
		p1.setProdId(3);
		p1.setProdPrice(100);
		p1.setProdQuant(2);
		p1.setProdType("grocery");
		p1.setProdName("Salt");

		Product p2 = new Product();
		p2.setProdId(4);
		p2.setProdPrice(200);
		p2.setProdQuant(3);
		p2.setProdType("non grocery");
		p2.setProdName("Sugar");

		ProductServiceImpl productServiceImpl = ProductServiceImpl.getProductServiceImplInstance();
		CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getProductServiceImplInstance();
		
		productServiceImpl.addProduct(p1);
		productServiceImpl.addProduct(p2);
		
		customerServiceImpl.addCustomer(c1);
		
		List<Integer> prodIds = new ArrayList<Integer>();
		prodIds.add(3);
		prodIds.add(4);

		BillServiceImpl billing = new BillServiceImpl();
		Bill bill = billing.getBill(prodIds, 9392939293L);

		assertEquals(725, bill.getDiscountedAmount());
	}
	
	@Test
	void test3() {

		Customer c1 = new Customer();
		c1.setCustName("Bob");
		c1.setCustPhone(9392939294L);
		c1.setCustType("Other");
		c1.setJoinDate("11/11/2019");

		Product p1 = new Product();
		p1.setProdId(5);
		p1.setProdPrice(100);
		p1.setProdQuant(2);
		p1.setProdType("grocery");
		p1.setProdName("Salt");

		Product p2 = new Product();
		p2.setProdId(6);
		p2.setProdPrice(200);
		p2.setProdQuant(3);
		p2.setProdType("non grocery");
		p2.setProdName("Sugar");

		ProductServiceImpl productServiceImpl = ProductServiceImpl.getProductServiceImplInstance();
		CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getProductServiceImplInstance();
		
		productServiceImpl.addProduct(p1);
		productServiceImpl.addProduct(p2);
		
		customerServiceImpl.addCustomer(c1);
		
		List<Integer> prodIds = new ArrayList<Integer>();
		prodIds.add(5);
		prodIds.add(6);

		BillServiceImpl billing = new BillServiceImpl();
		Bill bill = billing.getBill(prodIds, 9392939294L);

		assertEquals(760, bill.getDiscountedAmount());
	}
	
	@Test
	void test4() {

		Customer c1 = new Customer();
		c1.setCustName("Bob");
		c1.setCustPhone(9392939295L);
		c1.setCustType("Employee");
		c1.setJoinDate("11/11/2007");

		Product p1 = new Product();
		p1.setProdId(7);
		p1.setProdPrice(100);
		p1.setProdQuant(2);
		p1.setProdType("non grocery");
		p1.setProdName("Paper");

		Product p2 = new Product();
		p2.setProdId(8);
		p2.setProdPrice(200);
		p2.setProdQuant(3);
		p2.setProdType("non grocery");
		p2.setProdName("Scissor");

		ProductServiceImpl productServiceImpl = ProductServiceImpl.getProductServiceImplInstance();
		CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getProductServiceImplInstance();
		
		productServiceImpl.addProduct(p1);
		productServiceImpl.addProduct(p2);
		
		customerServiceImpl.addCustomer(c1);
		
		List<Integer> prodIds = new ArrayList<Integer>();
		prodIds.add(7);
		prodIds.add(8);

		BillServiceImpl billing = new BillServiceImpl();
		Bill bill = billing.getBill(prodIds, 9392939295L);

		assertEquals(520, bill.getDiscountedAmount());
	}
	
	@Test
	void test5() {

		Customer c1 = new Customer();
		c1.setCustName("Bob");
		c1.setCustPhone(9392939296L);
		c1.setCustType("Affiliate");
		c1.setJoinDate("11/11/2007");

		Product p1 = new Product();
		p1.setProdId(9);
		p1.setProdPrice(100);
		p1.setProdQuant(2);
		p1.setProdType("grocery");
		p1.setProdName("Salt");

		Product p2 = new Product();
		p2.setProdId(10);
		p2.setProdPrice(200);
		p2.setProdQuant(3);
		p2.setProdType("non grocery");
		p2.setProdName("Door Handle");

		ProductServiceImpl productServiceImpl = ProductServiceImpl.getProductServiceImplInstance();
		CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getProductServiceImplInstance();
		
		productServiceImpl.addProduct(p1);
		productServiceImpl.addProduct(p2);
		
		customerServiceImpl.addCustomer(c1);
		
		List<Integer> prodIds = new ArrayList<Integer>();
		prodIds.add(9);
		prodIds.add(10);

		BillServiceImpl billing = new BillServiceImpl();
		Bill bill = billing.getBill(prodIds, 9392939296L);
		assertEquals(690, bill.getDiscountedAmount());
	}

}
