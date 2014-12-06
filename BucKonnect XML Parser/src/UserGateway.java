import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserGateway {

	private Connection conn;

	public UserGateway() throws Exception {
		Class.forName("org.h2.Driver");

		conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/BucKonnect", "sa", "bucks");
	}

	public boolean insertUser(User user) {
		try {
			String query = String
					.format("INSERT INTO Users"
							+ "(OSU_Email_Id,First_Name,Last_Name ,Phone_Number ,DOB ,Is_Faculty ,Password ,About_Me ,Major, Interests)"
							+ " VALUES('%s','%s','%s','%s','%s',%s,'%s','%s','%s','%s')",
							user.getOSUID(), user.getFirstName(),
							user.getlastName(), user.getPhoneNumber(),
							user.getDate(), user.getFaculty(),
							user.getpassword(), user.getAboutMe(),
							user.getMajor(), user.getInterests());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			String query = String.format(
					"Delete From Users Where OSU_Email_Id = '%s'",
					user.getOSUID());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			String query = String
					.format("Update Users Set First_Name = '%s', Last_Name = '%s' Where OSU_Email_Id = '%s'",
							user.getFirstName(), user.getlastName(),
							user.getOSUID());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public void readUser(User user) {
		try {
			String query = "SELECT * FROM Users where OSU_Email_id = '"
					+ user.getOSUID() + "'";
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			while (results.next()) {
				System.out.println("FirstName : " + results.getString("First_Name")
						+ ", LastName : " + results.getString("Last_Name"));
			}
		} catch (Exception error) {
			System.out.println(error);
		}
	}
}
