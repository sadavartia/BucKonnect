import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GroupGateway {

	private Connection conn;

	public GroupGateway() throws Exception {
		Class.forName("org.h2.Driver");

		conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/BucKonnect", "sa", "bucks");
	}

	public boolean insertGroup(Group group) {
		try {
			String query = String
					.format("INSERT INTO Groups(Group_Name,Group_Info,Primary_Admin,Category) VALUES('%s','%s','%s','%s')",
							group.getGroupName(), group.getGroupInfo(),
							group.getPrimaryAdmin(), group.getCategory());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public boolean deleteGroup(Group group) {
		try {
			String query = String.format(
					"Delete From Groups Where Group_Name = '%s'",
					group.getGroupName());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public boolean updateGroup(Group group) {
		try {
			String query = String
					.format("Update Groups Set Group_Info = '%s' , Category ='%s' Where Group_Name = '%s'",
							group.getGroupInfo(), group.getCategory(),
							group.getGroupName());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public void readGroup(Group group) {
		try {
			String query = "SELECT * FROM Groups where Group_Name = '"
					+ group.getGroupName() + "'";
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			while (results.next()) {
				System.out.println("Group_Info : " + results.getString("Group_Info")
						+ ", Primary_Admin : " + results.getString("Primary_Admin")
						+ ", Category : " + results.getString("Category"));
			}
		} catch (Exception error) {
			System.out.println(error);
		}
	}

}
