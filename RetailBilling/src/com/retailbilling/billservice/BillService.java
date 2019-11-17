package com.retailbilling.billservice;

import java.util.List;

import com.retailbilling.bill.Bill;

public interface BillService {
	public Bill getBill(List<Integer> prodIds, Long custPhone);
	public List<Bill> getAllBills();
}
