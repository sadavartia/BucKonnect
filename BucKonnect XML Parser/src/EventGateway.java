import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EventGateway {

	private Connection conn;

	public EventGateway() throws Exception {
		Class.forName("org.h2.Driver");

		conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/BucKonnect", "sa", "bucks");
	}

	public boolean insertEvent(Event event) {
		try {
			String query = String
					.format("INSERT INTO Events(Event_Name,Event_Info,Event_Details,Primary_Event_Coordinator,Event_Location,Event_Date_Time,Event_Duration) VALUES('%s','%s','%s','%s','%s','%s','%s')",
							event.getEventName(), event.getEventInfo(),
							event.getEventDetails(),
							event.getPrimaryEventCoordinator(),
							event.getEventLocation(), event.getEventDateTime(),
							event.getEventDuration());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public boolean deleteEvent(Event event) {
		try {
			String query = String.format(
					"Delete From Events Where Event_Name = '%s'",
					event.getEventName());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public boolean updateEvent(Event event) {
		try {
			String query = String
					.format("Update Events Set Event_Info = '%s', Event_Details = '%s' Where Event_Name = '%s'",
							event.getEventInfo(), event.getEventDetails(),
							event.getEventName());
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	public void readEvent(Event event) {
		try {
			String query = "SELECT * FROM Events where Event_Name = '"
					+ event.getEventName() + "'";
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			while (results.next()) {
				System.out.println("Event_Details : "
						+ results.getString("Event_Details")
						+ ", Primary_Event_Coordinator : "
						+ results.getString("Primary_Event_Coordinator")
						+ ", Event_Info : " + results.getString("Event_Info"));
			}
		} catch (Exception error) {
			System.out.println(error);
		}
	}

}
