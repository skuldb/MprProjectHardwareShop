package org.example.db.dao;

import org.example.db.Dao;
import org.example.shop.Customer;

public interface CustomerDao extends Dao<Customer>{
        
        
        public void setOrders(Customer c);
}