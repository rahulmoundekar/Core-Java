package onetomany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static Person setAllData() {
		Address address1 = new Address();
		address1.setAddr_id(101);
		address1.setStreet("pune");

		Address address2 = new Address();
		address2.setAddr_id(102);
		address2.setStreet("mumbai");

		List<Address> list = new ArrayList<Address>();

		list.add(address1);
		list.add(address2);

		Person person = new Person();
		person.setPerson_id(1);
		person.setPerson_name("Rahul Moundekar");
		person.setAddresses(list);

		return person;
	}

	public static void main(String[] args) {

		Person person = setAllData();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/databaserelationships",
					"root", "root");

			Statement statement = connection.createStatement();

			List<Address> addresses = person.getAddresses();
			Iterator<Address> it = addresses.iterator();
			while (it.hasNext()) {
				Address address = (Address) it.next();
				String addresssql = "insert into address values("
						+ address.getAddr_id() + ",'" + address.getStreet()
						+ "'," + person.getPerson_id() + ")";
				statement.execute(addresssql);

			}

			String personsql = "insert into person1 values("
					+ person.getPerson_id() + ",'" + person.getPerson_name()
					+ "')";

			statement.execute(personsql);

			System.out.println("Data Save Successfully");

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

	}

}
