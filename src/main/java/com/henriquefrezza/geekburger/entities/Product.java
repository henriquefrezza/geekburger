package com.henriquefrezza.geekburger.entities;

import java.util.ArrayList;

public class Product {
	private String productId;
	private String name;
	private String image;
	private Double price;
	private String productionArea;
	private ArrayList<Item> items;
	
	
	public Product(String productId, String name, String image, Double price, String productionArea,
			ArrayList<Item> items) {
		super();
		this.productId = productId;
		this.name = name;
		this.image = image;
		this.price = price;
		this.productionArea = productionArea;
		this.items = items;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductionArea() {
		return productionArea;
	}

	public void setProductionArea(String productionArea) {
		this.productionArea = productionArea;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", image=" + image + ", price=" + price + ", productionArea=" + productionArea + ", items=" + items + '}';
    }
        
        
}

