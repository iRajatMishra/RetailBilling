package com.retailbilling.product;

public class Product {
	private int prodId;
	private String prodName;
	private String prodType;
	private double prodPrice;
	private int prodQuant;

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQuant() {
		return prodQuant;
	}

	public void setProdQuant(int prodQuant) {
		this.prodQuant = prodQuant;
	}

}
