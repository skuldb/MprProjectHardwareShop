import java.sql.Connection;
import java.sql.DriverManager;

import org.example.db.HsqlUnitOfWork;
import org.example.db.dao.CustomerDao;
import org.example.db.dao.HsqlCustomerDao;
import org.example.db.dao.HsqlItemDao;
import org.example.shop.Customer;
import org.example.shop.Item;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			HsqlUnitOfWork uow = new HsqlUnitOfWork();
			CustomerDao dao = new HsqlCustomerDao(uow);
			Customer c = new Customer();
			
			c.setNip("7441595385");
			c.setName("Tescik");
			c.setAdress("Testowa 34c/12");
			c.setPhoneNumber("852963741");
			c.setId(0);
			
			Customer c1 = new Customer();
			c1.setId(0);
			dao.delete(c1);
			dao.save(c);
			uow.commit();
			uow.close();
		System.out.println("koniec");
	}

}
