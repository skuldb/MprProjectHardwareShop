package org.example.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.db.Dao;
import org.example.db.DaoBase;
import org.example.db.EntityBase;
import org.example.db.MysqlUnitOfWork;
import org.example.shop.Customer;
import org.example.shop.Item;

public class MysqlItemDao extends DaoBase<Item>  implements Dao<Item>{

	
	private Statement stmt;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getById;
	private PreparedStatement getAll;
	
	
	public MysqlItemDao(MysqlUnitOfWork uow)
	{
		super(uow);
		try {
			Connection connection = uow.getConnection();
			stmt = connection.createStatement();
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			boolean exists = false;
			while(rs.next())
			{
				if("product".equalsIgnoreCase(rs.getString("TABLE_NAME")))
				{
					exists = true;
					break;
				}
			}
			
			insert = connection.prepareStatement(""
					+ "INSERT INTO Item(fullname,sellPrice,netPrice,description)"
					+ " VALUES(?,?,?,?)");
			
			getById = connection.prepareStatement(""
					+ "SELECT * FROM Item WHERE id=?");
			
			delete = connection.prepareStatement("DELETE FROM Item WHERE id=?");
			
			getAll = connection.prepareStatement("SELECT * FROM Item");
			
			update = connection.prepareStatement(""
					+ "update Item set"
					+ " fullname=(?),sellPrica=(?),netPrice=(?),description=(?) "
					+ "where id=?");
			
			if(!exists)
			{
				stmt.executeUpdate(""
						+ "CREATE TABLE Item("
						+ "id bigint AUTO_INCREMENT primary key,"
						+ "fullname varchar(128),"
						+ "sellPrice DECIMAL(10,2)"
						+ "netPrice DECIMAL(10,2)"
						+ "description TEXT,"
						+ ")");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistAdd(EntityBase entity) {
		
		Item ent = (Item)entity;
		try {
			insert.setString(1, ent.getFullName());
			insert.setString(2, ent.getDescription());
			insert.setFloat(3, ent.getSellPrice());
			insert.setFloat(3, ent.getNetPrice());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistDelete(EntityBase entity) {
		Item ent = (Item) entity;
		try 
		{
			delete.setInt(1, ent.getId());
			delete.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Item> getAll() {
			List<Item> customers = new ArrayList<Item>();
		
		try
		{
			ResultSet rs = getAll.executeQuery();
			while(rs.next()){
				
				Item p = new Item();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setSellPrice(rs.getFloat("Sellprice"));
				p.setNetPrice(rs.getFloat("Netprice"));
				p.setFullName(rs.getString("Fullname"));
				customers.add(p);
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public Item get(int id) {
		Item p = null;
		try {
			getById.setInt(1, id);
			ResultSet rs = getById.executeQuery();
			while(rs.next())
			{
				p = new Item();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setSellPrice(rs.getFloat("Sellprice"));
				p.setFullName(rs.getString("Fullname"));
				p.setNetPrice(rs.getFloat("Netprice"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void persistUpdate(EntityBase entity) {
		Item ent = (Item) entity;
		try
		{
			update.setString(1, ent.getFullName());
			update.setString(2, ent.getDescription());
			update.setDouble(3, ent.getSellPrice());
			update.setDouble(3, ent.getNetPrice());
			update.setInt(5, ent.getId());
			update.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}


	
	
}