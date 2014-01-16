package org.example.shop;

import java.util.List;

import org.example.db.EntityBase;

public class Manufacturer extends EntityBase {

	
	public Manufacturer(String name, String supportcontact, List<Item> item) {
		super();
		this.name = name;
		this.supportcontact = supportcontact;
		this.item = item;
	}
	private String name;
	private String supportcontact;
	
	
	
	//relacje
	public List<Item> item;
	
	
	
	//getters, setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupportcontact() {
		return supportcontact;
	}
	public void setSupportcontact(String supportcontact) {
		this.supportcontact = supportcontact;
	}
	
	
}
