package org.example.db.dao;

import java.util.List;

import org.example.db.Dao;
import org.example.shop.Order;

public interface OrderDao extends Dao<Order> {

	public List<Order> getAddressByClientId(int id);
}
