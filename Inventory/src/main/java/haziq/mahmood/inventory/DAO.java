package haziq.mahmood.inventory;
import java.util.ArrayList;
//import java.util.List;

public interface DAO<T> {

	
	
	
		//R
		public ArrayList<T> readAll(); // read all the vehicles in the list
		
		public void create(T t); // create a vehicle

		//U
		public void update (long id, T t);// updates the amount of vehicles
		//D
		public void delete (long id); //delete things from vehicles.
	}


