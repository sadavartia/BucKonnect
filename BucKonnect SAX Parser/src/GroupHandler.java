

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class GroupHandler extends DefaultHandler {

	private String temp;
	public Group groupInfo;

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
		if (qName.equalsIgnoreCase("Group")) {
			groupInfo = new Group();
		}
	}

	/*
	 * When the parser encounters the end of an element, it calls this method
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if (qName.equalsIgnoreCase("OSU_Email_ID")) {
			groupInfo.setOSU_Email_ID(temp);
		} else if (qName.equalsIgnoreCase("groupName")) {
			groupInfo.setGroupName(temp);
		} else if (qName.equalsIgnoreCase("groupInfo")) {
			groupInfo.setGroupInfo(temp);
		} else if (qName.equalsIgnoreCase("groupId")) {
			groupInfo.setGroupId(Integer.parseInt(temp));
		} else if (qName.equalsIgnoreCase("primaryAdmin")) {
			groupInfo.setPrimaryAdmin(temp);
		} else if (qName.equalsIgnoreCase("secondaryAdmin")) {
			groupInfo.setSecondaryAdmin(temp);
		} else if (qName.equalsIgnoreCase("post")) {
			groupInfo.setPost(temp);
		} else if (qName.equalsIgnoreCase("category")) {
			groupInfo.setCategory(temp);
		} 
	}

}
