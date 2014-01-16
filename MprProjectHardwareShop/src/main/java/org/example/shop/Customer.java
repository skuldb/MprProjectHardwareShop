package org.example.shop;

import java.util.List;

import org.example.db.EntityBase;

public class Customer extends EntityBase{

	
	public Customer(String name, String nip, String adress, String phoneNumber,
			List<Order> order) {
		super();
		this.name = name;
		this.nip = nip;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.order = order;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	private String name;
	private String nip;
	private String adress;
	private String phoneNumber;
	
	
	//relacje
	private List<Order> order;
	
	
	
	//getters, setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
