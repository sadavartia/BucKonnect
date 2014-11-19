//import java.nio.file.attribute.UserPrincipalLookupService;

import java.sql.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Program {
	public static void main(String[] a) throws Exception {

		SAXParserFactory spfac = SAXParserFactory.newInstance();

		// Now use the parser factory to create a SAXParser object
		SAXParser sp = spfac.newSAXParser();

		// Create an instance of this class; it defines all the handler methods
		UserHandler uHandlerI = new UserHandler();
		UserHandler uHandlerU = new UserHandler();
		UserHandler uHandlerD = new UserHandler();
		GroupHandler gHandler = new GroupHandler();
		EventHandler eHandler = new EventHandler();
		CalendarHandler cHandler = new CalendarHandler();

		// Finally, tell the parser to parse the input and notify the handler
		sp.parse("User.xml", uHandlerI);
		sp.parse("User_U.xml", uHandlerU);
		sp.parse("User_D.xml", uHandlerD);
		
		sp.parse("group.xml", gHandler);
		sp.parse("event.xml", eHandler);
		sp.parse("calendar.xml", cHandler);

		User utemp = uHandlerI.userInfo;
		Group gtemp = gHandler.groupInfo;
		Event etemp = eHandler.eventInfo;
		Calendar ctemp = cHandler.calendarInfo;

		System.out.println(utemp.toString());
		System.out.println();
		System.out.println(gtemp.toString());
		System.out.println();
		System.out.println(etemp.toString());
		System.out.println();
		System.out.println(ctemp.toString());
		System.out.println();

		String queryString = String
				.format("INSERT INTO Users(OSU_Email_Id,First_Name,Last_Name ,Phone_Number ,DOB ,Is_Faculty ,User_Name ,Password ,About_Me ,Major) VALUES('%s','%s','%s',%s,'%s','%s','%s','%s','%s','%s')",
						utemp.getOSUID(), utemp.getFirstName(),
						utemp.getlastName(), utemp.getPhoneNumber(),
						utemp.getDate(), utemp.getFaculty(),
						utemp.getUserName(), utemp.getpassword(),
						utemp.getAboutMe(), utemp.getMajor(),
						utemp.getInterests());

		String gqueryString = String
				.format("INSERT INTO Groups(Group_Name,Group_Info,Primary_Admin,Secondary_Admin,Post,Category) VALUES('%s','%s',%s,'%s','%s','%s')",
						gtemp.getGroupName(), gtemp.getGroupInfo(),
						gtemp.getGroupId(), gtemp.getPrimaryAdmin(),
						gtemp.getSecondaryAdmin(), gtemp.getPost(),
						gtemp.getCategory());

		String equeryString = String
				.format("INSERT INTO Events(Event_Name,Event_Details,Primary_Event_Coordinator,Secondary_Event_Coordinator) VALUES('%s','%s','%s','%s')",
						etemp.getEventName(), etemp.getEventDetails(),
						etemp.getPrimaryEventCoordinator(),
						etemp.getSecondaryEventCoordinator());

		String cqueryString = String
				.format("INSERT INTO Calendars(Start_Date_Time,End_Date_Time,Location,Event_Name) VALUES('%s','%s','%s','%s')",
						ctemp.getStartDateTime(), ctemp.getEndDateTime(),
						ctemp.getLocation(), ctemp.getEventName());

		System.out.println("User " + queryString);
		System.out.println("Group " + gqueryString);
		System.out.println("Event " + equeryString);
		System.out.println("Calendar " + cqueryString);

		Connection conn = null;
		Statement stmt = null;
		Class.forName("org.h2.Driver");

		conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/BucKonnect", "sa", "bucks");
		stmt = conn.createStatement();

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		stmt.execute(queryString);

		ResultSet rs = stmt
				.executeQuery("SELECT * FROM Users WHERE OSU_Email_Id = 'pande.1@osu.edu' ORDER BY User_Id;");
		ResultSetMetaData rsmd = rs.getMetaData();
		// Loop through the result set
		System.out.println("");
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}
		utemp = uHandlerU.userInfo;
		
		if (utemp.getOperation().equals("UPDATE")) {
			queryString = String
					.format("Update Users Set First_Name = '%s', Last_Name = '%s' Where OSU_Email_Id = '%s'",
							utemp.getFirstName(), utemp.getlastName(),
							utemp.getOSUID());
		} else if (utemp.getOperation().equals("DELETE")) {
			queryString = String.format(
					"Delete From Users Where OSU_Email_Id = '%s')",
					utemp.getOSUID());
		}

		stmt.execute(queryString);
		
		utemp = uHandlerD.userInfo;
		if (utemp.getOperation().equals("UPDATE")) {
			queryString = String
					.format("Update Users Set First_Name = '%s', Last_Name = '%s' Where OSU_Email_Id = '%s'",
							utemp.getFirstName(), utemp.getlastName(),
							utemp.getOSUID());
		} else if (utemp.getOperation().equals("DELETE")) {
			queryString = String.format(
					"Delete From Users Where OSU_Email_Id = '%s'",
					utemp.getOSUID());
		}
		
		stmt.execute(queryString);

		rs = stmt
				.executeQuery("SELECT * FROM Users WHERE OSU_Email_Id = 'pande.1@osu.edu' ORDER BY User_Id;");
		rsmd = rs.getMetaData();
		// Loop through the result set
		System.out.println("");
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		stmt.execute(gqueryString);

		rs = stmt.executeQuery("SELECT * FROM Groups ORDER BY Group_Id;");
		rsmd = rs.getMetaData();
		// Loop through the result set
		System.out.println("");
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}

		stmt.execute(equeryString);

		rs = stmt.executeQuery("SELECT * FROM Events ORDER BY Event_Id;");
		rsmd = rs.getMetaData();
		// Loop through the result set
		System.out.println("");
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}

		stmt.execute(cqueryString);

		rs = stmt.executeQuery("SELECT * FROM Calendars ORDER BY Calendar_Id;");
		rsmd = rs.getMetaData();
		// Loop through the result set
		System.out.println("");
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rs.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}

		// Close the result set, statement and the connection
		rs.close();

	}
}
