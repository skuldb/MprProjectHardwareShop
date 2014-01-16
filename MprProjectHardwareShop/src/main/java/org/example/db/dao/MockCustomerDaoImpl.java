package org.example.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.example.db.EntityBase;
import org.example.db.MockDb;
import org.example.shop.Customer;

public class MockCustomerDaoImpl /*implements CustomerDao*/{

	private MockDb db;
	
	
	
	public MockCustomerDaoImpl(MockDb db) {
	
		this.db = db;
	}

	public void save(Customer ent) {
		db.save(ent); 
		
	}

	public void delete(Customer ent) {
		db.getItems().remove(ent);
		
	}

	public List<Customer> getAll() {
		List<Customer> result = new ArrayList<Customer>();
		for(EntityBase ent: db.getItems())
		{
			if(ent instanceof Customer)
				result.add((Customer)ent);
		}
		
		return result;
	}

	public Customer get(int id) {
		for(Customer c: getAll())
		{
			if(c.getId()==id)
			{
				Customer c1 = new Customer();
				c1.setId(c.getId());
				c1.setNip(c.getNip());
				c1.setPhoneNumber(c.getPhoneNumber());
				c1.setAdress(c.getAdress());
				c1.setName(c.getName());
				return c1;
			}
		}
		return null;
	}

	public void setAddresses(Customer c) {
		
		
	}

	public void setOrders(Customer c) {
		
		
	}

	public void update(Customer ent) {
		// TODO Auto-generated method stub
		
	}

}
