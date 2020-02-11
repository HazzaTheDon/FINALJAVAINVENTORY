package haziq.mahmood.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.List;

public class CustomerDao implements DAO<Customer> {
	private Connection connection;

public CustomerDao() throws SQLException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter Username: ");
scanner.nextLine();
	System.out.println("Enter password: ");
	String password= Utils.input();
	this.connection = DriverManager.getConnection("jdbc:mysql://35.189.117.62:3306/IMS", "Username", password);
//     
}



	public ArrayList<Customer> readAll() {

		
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");
			while (resultSet.next()) {
				Long id = resultSet.getLong("customer_ID");
				String firstName = resultSet.getString("customer_firstName");
				String surname = resultSet.getString("customer_surname");
				Customer customer = new Customer(id, firstName, surname);
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
	

	public void create(Customer t) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(customer_firstName, customer_surname) values('" + t.getFirstName()
					+ "','" + t.getSurname() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



		public void update(long id,Customer t) {
			String sql = "UPDATE customer set customer_firstName = ?,customer_surname= ? where customer_ID = ?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, t.getFirstName());
				stmt.setString(2, t.getSurname());
				stmt.setLong(3, id);
				stmt.execute();
				System.out.println("Update complete");
			} catch (Exception e) {
			//	logger.info(e);
			}
		}
		


		public void delete(long id) {
			String sql = "DELETE FROM customer WHERE customer_ID = ?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, id);
				stmt.execute();
				System.out.println("Delete complete ");
				connection.close();
			} catch (Exception e) {
//				logger.info(e);
			}
		}



	
			
			
		}



			
		
		
		
	

