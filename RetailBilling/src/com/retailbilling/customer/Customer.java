package com.retailbilling.customer;

public class Customer {
	private String custName;
	private Long custPhone;
	private String custType;
	private String joinDate;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(Long custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
