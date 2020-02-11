package haziq.mahmood.inventory;
import java.sql.SQLException;
import java.util.ArrayList;


public class Runner {
	
	
	public static void main(String[] args) throws SQLException {
//			CustomerDao dao= new CustomerDao();
//		    ArrayList<Customer> customers = dao.readAll();
//		    System.out.println(customers);
//		    for (Customer customer: customers) {
//		    	System.out.println(customer.getId() + " "+ customer.getFirstName()+" " + customer.getSurname());

//CustomerDao dao1= new CustomerDao();
//dao1.update(2, new Customer("Taiwo", "Aina-Badejo"));
		
//		CustomerDao dao2= new CustomerDao();
//		dao2.delete(3);
//		
		

	CustomerDao dao3= new CustomerDao();
	dao3.create("Ash", "Ghale");
	
		}
}



