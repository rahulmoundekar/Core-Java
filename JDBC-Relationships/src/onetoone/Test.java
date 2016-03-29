package onetoone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {

		User user = new User();

		user.setUser_id(101);
		user.setUser_name("RahulMoundear");

		Person person = new Person();
		person.setPerson_id(1);
		person.setPerson_name("Rahul Moundekar");
		person.setAddr("wadgaonsheri");

		person.setUser(user);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/databaserelationships",
					"root", "root");

			Statement statement = connection.createStatement();

			String usersql = "insert into user values(" + user.getUser_id()
					+ ",'" + user.getUser_name() + "')";

			String personsql = "insert into person values("
					+ person.getPerson_id() + ",'" + person.getPerson_name()
					+ "','" + person.getAddr() + "','"
					+ person.getUser().getUser_id() + "')";

			statement.execute(usersql);
			statement.execute(personsql);

			System.out.println("Data Save Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

	}

}
