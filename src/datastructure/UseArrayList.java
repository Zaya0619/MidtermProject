package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import databases.ConnectToMongoDB;



public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */
		ArrayList<String> student = new ArrayList<>();
		student.add("Address");
		student.add("SSN");
		student.add("Challenges");
		student.add("Achievements");
		System.out.println("All values of array = " + student);
		for (int a=1; a<4; a++){
			System.out.println("specified from index to index = " + student.get(a));
		}
		//connect to db
		ConnectToMongoDB connect = new ConnectToMongoDB();
		connect.insertDataFromArrayListToMongoDB(student, "firstName", "lastName");

		Iterator<String> it = student.iterator();
		System.out.println(it.next());
		System.out.println(it.hasNext());
		while (it.hasNext())
			System.out.println("from while loop = " + it.next());
		for (Object x : student) {
			System.out.println(x);
		}

	}

}
