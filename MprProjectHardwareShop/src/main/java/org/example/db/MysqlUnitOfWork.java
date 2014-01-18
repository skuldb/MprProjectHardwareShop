package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MysqlUnitOfWork implements UnitOfWork{

	private Map<EntityBase, UnitOfWorkDao> added;
	
	Connection connection;
	
	public MysqlUnitOfWork()
	{
		added = new HashMap<EntityBase, UnitOfWorkDao>();
		connection = getConnection();
	}
	
	public Connection getConnection()
	{
		try
		{
			if(connection==null||connection.isClosed())
				connection = 
				DriverManager.getConnection("jdbc:mysql://localhost/workdb?user=root&password=");
			connection.setAutoCommit(false);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return connection;
	}
	
	public void markNew(EntityBase ent, UnitOfWorkDao dao) {
		ent.setOperation(EntityOperation.insert);
		added.put(ent, dao);
		
	}

	public void markDeleted(EntityBase ent, UnitOfWorkDao dao) {
		ent.setOperation(EntityOperation.delete);
		added.put(ent, dao);
		
	}

	public void markUpdated(EntityBase ent, UnitOfWorkDao dao) {
		ent.setOperation(EntityOperation.update);
		added.put(ent, dao);
		
	}

	public void commit() {
	
		Connection conn = getConnection();
		try{
			conn.setAutoCommit(false);
			
			for(EntityBase ent : added.keySet() )
			{
				switch(ent.getOperation())
				{
					case insert:
					{
						added.get(ent).persistAdd(ent);
					}
					case delete:
					{
						added.get(ent).persistDelete(ent);
					}
					case update:
					{
						added.get(ent).persistUpdate(ent);
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}

	public void close() {
		
		try{
			if(connection!=null && !connection.isClosed())
				{
					connection.close();
					connection=null;
				}
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		
		
	}

}