package foo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.db.MysqlUnitOfWork;
import org.example.db.MockDb;
import org.example.db.dao.CustomerDao;
import org.example.db.dao.MysqlCustomerDao;
import org.example.shop.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerDaoTest {

	CustomerDao dao;

	Connection connection = null;
	private Statement drop;
	
	@BeforeClass
	public static void initialize()
	{}
	
	@Before
	public void setUp()
	{

		Customer c = new Customer();
		c.setNip("7441595385");
		c.setName("Tescik");
		c.setAdress("Testowa 34c");
		c.setPhoneNumber("852963741");
		try {

			MysqlUnitOfWork uow = new MysqlUnitOfWork();
			dao = new MysqlCustomerDao(uow);
			dao.save(c);
			uow.commit();
			drop = uow.getConnection().createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@After
	public void teardown()
	{
		try{
			if(connection!=null && !connection.isClosed())
			{	
				drop.executeUpdate("Drop table Client");
				connection.close();
				connection = null;
			}}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
	@Test
	public void testGet() {
		
		Customer c1 = dao.get(0);
		Customer c2 = dao.get(2);
		Customer c3 = dao.get(0);
		
		assertNotNull("zwrocono null mimo ze obiekt jest w bazie",c1);
		assertNull("zwrocono wartosc mimo, ze nie ma takiego obiektu w bazie",c2);
		assertTrue(c1.getNip().equals("7441595385"));
		
		assertEquals(c1.getName(),"Tescik");
		assertEquals(c1.getAdress(), "Testowa 34c/12");
		assertEquals(c1.getPhoneNumber(),"852963741");
		
		assertNotSame(c1,c3);
		
	}

}