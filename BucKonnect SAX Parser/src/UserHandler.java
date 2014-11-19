import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {

	private String temp;
	public User userInfo;

	/*
	 * When the parser encounters plain text (not XML elements), it calls(this
	 * method, which accumulates them in a string buffer
	 */
	public void characters(char[] buffer, int start, int length) {
		temp = new String(buffer, start, length);
	}

	/*
	 * Every time the parser encounters the beginning of a new element, it calls
	 * this method, which resets the string buffer
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		temp = "";
		if (qName.equalsIgnoreCase("User")) {
			userInfo = new User();
		}
	}

	/*
	 * When the parser encounters the end of an element, it calls this method
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (qName.equalsIgnoreCase("Operation")) {
			userInfo.setOperation(temp);
		} else if (qName.equalsIgnoreCase("OSU_Email_ID")) {
			userInfo.setOSUID(temp);
		} else if (qName.equalsIgnoreCase("firstName")) {
			userInfo.setFirstName(temp);
		} else if (qName.equalsIgnoreCase("lastName")) {
			userInfo.setLastName(temp);
		} else if (qName.equalsIgnoreCase("phoneNumber")) {
			userInfo.setPhoneNumber(Integer.parseInt(temp));
		} else if (qName.equalsIgnoreCase("dob")) {
			userInfo.setDate(temp);
		} else if (qName.equalsIgnoreCase("username")) {
			userInfo.setUserName(temp);
		} else if (qName.equalsIgnoreCase("password")) {
			userInfo.setpassword(temp);
		} else if (qName.equalsIgnoreCase("isFaculty")) {
			userInfo.setFaculty(Boolean.parseBoolean(temp));
		} else if (qName.equalsIgnoreCase("aboutMe")) {
			userInfo.setAboutMe(temp);
		} else if (qName.equalsIgnoreCase("interests")) {
			userInfo.setInterests(temp);
		} else if (qName.equalsIgnoreCase("major")) {
			userInfo.setMajor(temp);
		}
	}

}
