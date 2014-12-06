import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

public class BucKonnectDOMParser {

	public void parseXML(String xmlLocation) {
		try {
			File fXmlFile = new File(xmlLocation);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			// All instances of domain Objects to hold XML data in memory
			ArrayList<User> users = new ArrayList<User>();
			ArrayList<Group> groups = new ArrayList<Group>();
			ArrayList<Event> events = new ArrayList<Event>();

			// Parse users
			NodeList nList = doc.getElementsByTagName("User");
			String OSU_Email_ID;
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String operation = eElement
							.getElementsByTagName("Operation").item(0)
							.getTextContent();
					switch (operation) {
					case ("CREATE"):
						System.out.println("Create user");
						OSU_Email_ID = eElement
								.getElementsByTagName("OSU_Email_ID").item(0)
								.getTextContent();
						String firstName = eElement
								.getElementsByTagName("FirstName").item(0)
								.getTextContent();
						String lastName = eElement
								.getElementsByTagName("LastName").item(0)
								.getTextContent();
						String phoneNumber = eElement
								.getElementsByTagName("PhoneNumber").item(0)
								.getTextContent();
						String dob = eElement.getElementsByTagName("dob")
								.item(0).getTextContent();
						String password = eElement
								.getElementsByTagName("Password").item(0)
								.getTextContent();
						String aboutMe = eElement
								.getElementsByTagName("AboutMe").item(0)
								.getTextContent();
						String major = eElement.getElementsByTagName("Major")
								.item(0).getTextContent();
						String interests = eElement
								.getElementsByTagName("Interests").item(0)
								.getTextContent();
						boolean isFaculty;
						if (eElement.getElementsByTagName("IsFaculty").item(0)
								.getTextContent().equals("TRUE")) {
							isFaculty = true;
						} else {
							isFaculty = false;
						}
						User user = new User(operation, OSU_Email_ID,
								firstName, lastName, phoneNumber, dob,
								isFaculty, password, aboutMe, major, interests);
						users.add(user); // User is in-memory
						break;

					case ("READ"):
						System.out.println("Read user");
						OSU_Email_ID = eElement
								.getElementsByTagName("OSU_Email_ID").item(0)
								.getTextContent();
						User readUser = new User(operation, OSU_Email_ID, "",
								"", "", "", true, "", "", "", "");
						users.add(readUser); // User is in-memory
						break;

					case ("UPDATE"):
						System.out.println("Update user");
						OSU_Email_ID = eElement
								.getElementsByTagName("OSU_Email_ID").item(0)
								.getTextContent();
						String fName = eElement
								.getElementsByTagName("FirstName").item(0)
								.getTextContent();
						String lName = eElement
								.getElementsByTagName("LastName").item(0)
								.getTextContent();
						User updateUser = new User(operation, OSU_Email_ID,
								fName, lName, "", "", true, "", "", "", "");
						users.add(updateUser); // User is in-memory object
						break;

					case ("DELETE"):
						System.out.println("Delete user");
						OSU_Email_ID = eElement
								.getElementsByTagName("OSU_Email_ID").item(0)
								.getTextContent();
						User deleteUser = new User(operation, OSU_Email_ID, "",
								"", "", "", true, "", "", "", "");
						users.add(deleteUser); // User is in-memory object
						break;

					default:
						System.out.println("Operation Not Found");
					}
				}
			}

			// Parse Groups
			nList = doc.getElementsByTagName("Group");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String operation = eElement
							.getElementsByTagName("Operation").item(0)
							.getTextContent();
					switch (operation) {
					case ("CREATE"):
						System.out.println("Create Group");
						String groupName = eElement
								.getElementsByTagName("GroupName").item(0)
								.getTextContent();
						String groupInfo = eElement
								.getElementsByTagName("GroupInfo").item(0)
								.getTextContent();
						String primaryAdmin = eElement
								.getElementsByTagName("PrimaryAdmin").item(0)
								.getTextContent();
						String category = eElement
								.getElementsByTagName("Category").item(0)
								.getTextContent();

						Group group = new Group(operation, groupName,
								groupInfo, primaryAdmin, category);
						groups.add(group); // Group is stored in memory

						break;

					case ("READ"):
						System.out.println("Read Group");
						groupName = eElement.getElementsByTagName("GroupName")
								.item(0).getTextContent();
						Group read = new Group(operation, groupName, "", "", "");
						groups.add(read); // Group is stored in memory

						break;

					case ("UPDATE"):
						System.out.println("Update Group");
						groupName = eElement.getElementsByTagName("GroupName")
								.item(0).getTextContent();
						groupInfo = eElement.getElementsByTagName("GroupInfo")
								.item(0).getTextContent();
						category = eElement.getElementsByTagName("Category")
								.item(0).getTextContent();
						Group update = new Group(operation, groupName,
								groupInfo, "", category);
						groups.add(update); // Group is stored in memory

						break;

					case ("DELETE"):
						System.out.println("Delete Group");
						groupName = eElement.getElementsByTagName("GroupName")
								.item(0).getTextContent();
						Group delete = new Group(operation, groupName, "", "",
								"");
						groups.add(delete); // Group is stored in memory

						break;

					default:
						System.out.println("Operation Not Found");
					}
				}
			}

			// Parse Events
			nList = doc.getElementsByTagName("Event");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String operation = eElement
							.getElementsByTagName("Operation").item(0)
							.getTextContent();
					switch (operation) {
					case ("CREATE"):
						System.out.println("Create Event");
						String eventName = eElement
								.getElementsByTagName("EventName").item(0)
								.getTextContent();
						String eventInfo = eElement
								.getElementsByTagName("EventInfo").item(0)
								.getTextContent();
						String eventDetails = eElement
								.getElementsByTagName("EventDetails").item(0)
								.getTextContent();
						String primaryEventCoordinator = eElement
								.getElementsByTagName("PrimaryEventCoordinator")
								.item(0).getTextContent();
						String eventLocation = eElement
								.getElementsByTagName("EventLocation").item(0)
								.getTextContent();
						String eventDateTime = eElement
								.getElementsByTagName("EventDateTime").item(0)
								.getTextContent();
						String eventDuration = eElement
								.getElementsByTagName("EventDuration").item(0)
								.getTextContent();
						Event event = new Event(operation, eventName,
								eventInfo, eventDetails,
								primaryEventCoordinator, eventLocation,
								eventDateTime, eventDuration);
						events.add(event); // Event is stored in memory

						break;
					case ("READ"):
						System.out.println("Read Event");
						eventName = eElement.getElementsByTagName("EventName")
								.item(0).getTextContent();
						Event read = new Event(operation, eventName, "", "",
								"", "", "", "");
						events.add(read); // Event is stored in memory

						break;

					case ("UPDATE"):
						System.out.println("Update Event");
						eventName = eElement.getElementsByTagName("EventName")
								.item(0).getTextContent();
						eventInfo = eElement.getElementsByTagName("EventInfo")
								.item(0).getTextContent();
						eventDetails = eElement
								.getElementsByTagName("EventDetails").item(0)
								.getTextContent();

						Event update = new Event(operation, eventName,
								eventInfo, eventDetails, "", "", "", "");
						events.add(update); // Event is stored in memory

						break;

					case ("DELETE"):
						System.out.println("Delete Event");
						eventName = eElement.getElementsByTagName("EventName")
								.item(0).getTextContent();
						Event delete = new Event(operation, eventName, "", "",
								"", "", "", "");
						events.add(delete); // Event is stored in memory

						break;

					default:
						System.out.println("Operation Not Found");
					}
				}
			}

			// Persist all domain objects in the database using below gateways
			UserGateway uGateway = new UserGateway();
			GroupGateway gGateway = new GroupGateway();
			EventGateway eGateway = new EventGateway();

			for (User user : users) {
				String operation = user.getOperation();
				switch (operation) {
				case ("CREATE"):
					uGateway.insertUser(user);
					System.out.println(operation + " Operation successful for "
							+ user);
					break;

				case ("READ"):
					uGateway.readUser(user);
					System.out.println(operation + " Operation successful for "
							+ user);
					break;

				case ("UPDATE"):
					uGateway.updateUser(user);
					System.out.println(operation + " Operation successful for "
							+ user);
					break;

				case ("DELETE"):
					uGateway.deleteUser(user);
					System.out.println(operation + " Operation successful for "
							+ user);
					break;

				default:
					break;
				}
			}
			for (Group group : groups) {
				String operation = group.getOperation();
				switch (operation) {
				case ("CREATE"):
					gGateway.insertGroup(group);
					System.out.println(operation + " Operation successful for "
							+ group);
					break;

				case ("READ"):
					gGateway.readGroup(group);
					System.out.println(operation + " Operation successful for "
							+ group);
					break;

				case ("UPDATE"):
					gGateway.updateGroup(group);
					System.out.println(operation + " Operation successful for "
							+ group);
					break;

				case ("DELETE"):
					gGateway.deleteGroup(group);
					System.out.println(operation + " Operation successful for "
							+ group);
					break;

				default:
					break;
				}
			}
			for (Event event : events) {
				String operation = event.getOperation();
				switch (operation) {
				case ("CREATE"):
					eGateway.insertEvent(event);
					System.out.println(operation + " Operation successful for "
							+ event);
					break;

				case ("READ"):
					eGateway.readEvent(event);
					System.out.println(operation + " Operation successful for "
							+ event);
					break;

				case ("UPDATE"):
					eGateway.updateEvent(event);
					System.out.println(operation + " Operation successful for "
							+ event);
					break;

				case ("DELETE"):
					eGateway.deleteEvent(event);
					System.out.println(operation + " Operation successful for "
							+ event);
					break;

				default:
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
