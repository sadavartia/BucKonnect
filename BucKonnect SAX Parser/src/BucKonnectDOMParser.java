import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class BucKonnectDOMParser {

	public void parseXML(String xmlLocation) {
		try {
			File fXmlFile = new File(xmlLocation);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			UserGateway uGateway = new UserGateway();
			// Parse user
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
						User user = new User(OSU_Email_ID, firstName, lastName,
								phoneNumber, dob, isFaculty, password, aboutMe,
								major, interests);
						uGateway.insertUser(user); // User is in-memory
						break;

					case ("READ"):
						System.out.println("Read user");
						OSU_Email_ID = eElement
								.getElementsByTagName("OSU_Email_ID").item(0)
								.getTextContent();
						User readUser = new User(OSU_Email_ID, "", "", "", "",
								true, "", "", "", "");
						uGateway.readUser(readUser); // readUser is in-memory
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
						User updateUser = new User(OSU_Email_ID, fName, lName,
								"", "", true, "", "", "", "");
						uGateway.updateUser(updateUser); // updateUser is
															// in-memory object
						break;

					case ("DELETE"):
						System.out.println("Delete user");
						OSU_Email_ID = eElement
								.getElementsByTagName("OSU_Email_ID").item(0)
								.getTextContent();
						User deleteUser = new User(OSU_Email_ID, "", "", "",
								"", true, "", "", "", "");
						uGateway.deleteUser(deleteUser); // //deleteUser is
															// in-memory object
						break;

					default:
						System.out.println("Operation Not Found");
					}
				}
			}

			GroupGateway gGateway = new GroupGateway();
			// Parse Group
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

						Group group = new Group(groupName, groupInfo,
								primaryAdmin, category);
						gGateway.insertGroup(group);
						break;

					case ("READ"):
						System.out.println("Read Group");
						groupName = eElement.getElementsByTagName("GroupName")
								.item(0).getTextContent();
						Group read = new Group(groupName, "", "", "");
						gGateway.readGroup(read);
						break;

					case ("UPDATE"):
						System.out.println("Update Group");
						groupName = eElement.getElementsByTagName("GroupName")
								.item(0).getTextContent();
						groupInfo = eElement.getElementsByTagName("GroupInfo")
								.item(0).getTextContent();
						category = eElement.getElementsByTagName("Category")
								.item(0).getTextContent();
						Group update = new Group(groupName, groupInfo, "",
								category);
						gGateway.updateGroup(update);
						break;

					case ("DELETE"):
						System.out.println("Delete Group");
						groupName = eElement.getElementsByTagName("GroupName")
								.item(0).getTextContent();
						Group delete = new Group(groupName, "", "", "");
						gGateway.deleteGroup(delete);
						break;

					default:
						System.out.println("Operation Not Found");
					}
				}
			}

			EventGateway eGateway = new EventGateway();
			// Parse Event
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
						Event event = new Event(eventName, eventInfo,
								eventDetails, primaryEventCoordinator,
								eventLocation, eventDateTime, eventDuration);
						eGateway.insertEvent(event);
						break;
					case ("READ"):
						System.out.println("Read Event");
						eventName = eElement.getElementsByTagName("EventName")
								.item(0).getTextContent();
						Event read = new Event(eventName, "", "", "", "", "",
								"");
						eGateway.readEvent(read);
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

						Event update = new Event(eventName, eventInfo,
								eventDetails, "", "", "", "");
						eGateway.updateEvent(update);
						break;
						
					case ("DELETE"):
						System.out.println("Delete Event");
						eventName = eElement.getElementsByTagName("EventName")
								.item(0).getTextContent();
						Event delete = new Event(eventName, "", "", "", "", "",
								"");
						eGateway.deleteEvent(delete);
						break;

					default:
						System.out.println("Operation Not Found");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
