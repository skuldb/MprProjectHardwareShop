package org.example.shop;

import java.util.List;

import org.example.db.EntityBase;

public class Item extends EntityBase {

	
	
/*	public Item(String fullname, float sellPrice, float netPrice,
			String description, Manufacturer manufacturer, List<Order> order) {
		super();
		this.fullname = fullname;
		this.sellPrice = sellPrice;
		this.netPrice = netPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.order = order;
	}*/
	
	private String fullname;
	private float sellPrice;
	private float netPrice;
	private String description;
	
	//relacje
	private Manufacturer manufacturer;
	private List<Order> order;
	
	
	//getters, setters
	public String getFullName() {
		return fullname;
	}
	public void setFullName(String fullname) {
		this.fullname = fullname;
	}
	public float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public float getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	
	
}
