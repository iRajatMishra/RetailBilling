package com.retailbilling.billservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.retailbilling.bill.Bill;
import com.retailbilling.customer.Customer;
import com.retailbilling.customerservice.CustomerServiceImpl;
import com.retailbilling.product.Product;
import com.retailbilling.productservice.ProductServiceImpl;

public class BillServiceImpl implements BillService {

	private static int billId;
	@Override
	public Bill getBill(List<Integer> prodIds, Long custPhone) {
		
		ProductServiceImpl productServiceImpl = ProductServiceImpl.getProductServiceImplInstance();
		CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getProductServiceImplInstance();
		Customer cust = customerServiceImpl.getCustomer(custPhone);
		List<Product> prodList = new ArrayList<Product>();
		
		for(int id:prodIds) {
			prodList.add(productServiceImpl.getProduct(id));
		}
		
		
		Bill bill = new Bill();
		double amount = 0;
		double groceriesAmount = 0;
		for (Product prod : prodList) {
			amount += (prod.getProdPrice() * prod.getProdQuant());
			if (prod.getProdType().equalsIgnoreCase("grocery"))
				groceriesAmount += prod.getProdPrice();
		}

		bill.setAmount(amount);
		bill.setDiscount(getDiscount(amount, groceriesAmount, cust));
		bill.setDiscountedAmount(bill.getAmount()-bill.getDiscount());
		bill.setBillId(billId);
		billId++;
		bill.setCustomer(cust);
		bill.setProducts(prodList);
		return bill;
	}

	private double getDiscount(double amount, double groceriesAmount, Customer cust) {
		double discountPercentage = 0;
		if (cust.getCustType().equalsIgnoreCase("employee"))
			discountPercentage = 30;
		else if (cust.getCustType().equalsIgnoreCase("affiliate"))
			discountPercentage = 10;
		else if (getDiffYears(cust.getJoinDate()) >= 2)
			discountPercentage = 5;

		int specialDiscount = ((int) amount / 100) * 5;

		return (((amount - groceriesAmount) / 100) * discountPercentage) + specialDiscount;

	}

	private int getDiffYears(String joinDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date joining = null;
		try {
			joining = formatter.parse(joinDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date today = new Date();
		Calendar a = getCalendar(joining);
		Calendar b = getCalendar(today);
		int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
				|| (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
			diff--;
		}

		return diff;

	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}

	@Override
	public List<Bill> getAllBills() {

		return null;
	}

}
