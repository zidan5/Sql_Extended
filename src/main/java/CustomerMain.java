import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sqlConnectDB.CustomerJdbc;

public class CustomerMain {
//    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//    CustomerJdbc customerJdbcTemplate =
//            (CustomerJdbc)context.getBean("CustomerJdbc");

System.out.println("----Updating Record with ID = 1 -----" );
      customerJdbcTemplate.update("Lerato","Mabitso",2);
System.out.println("---Deleting Record with ID = 2 -----" );
      customerJdbcTemplate.delete(2,);
System.out.println("---Selecting a maximum amount from Payments -----" );
      customerJdbcTemplate.MaxPayment();


}