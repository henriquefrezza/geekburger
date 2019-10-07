package com.henriquefrezza.geekburger.entities;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String orderName;
    private Double orderPrice;
    private ArrayList<Product> orderProducts;

    public Order() {
    }

    public Order(String orderID, String orderName, Double orderPrice, ArrayList<Product> orderProducts) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderProducts = orderProducts;
	}

	public Double getOrderPrice() {
    	return orderPrice;
    }

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}


	public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public ArrayList<Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(ArrayList<Product> orderProducts) {
        this.orderProducts = orderProducts;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderName=" + orderName + ", orderProducts=" + orderProducts + '}';
    }
    
}			