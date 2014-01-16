package org.example.shop;
import java.util.List;

import org.example.db.EntityBase;

public class Order extends EntityBase{

	
	public Order(String date, String dateComplited, Customer customer,
			List<Item> item) {
		super();
		this.date = date;
		this.dateComplited = dateComplited;
		this.customer = customer;
		this.item = item;
	}
	private String date;
	private String dateComplited;
	
	
	//relacje
	private Customer customer;
	private List<Item> item;
	
	
	
	//getter, setters
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateComplited() {
		return dateComplited;
	}
	public void setDateComplited(String dateComplited) {
		this.dateComplited = dateComplited;
	}
	
}
