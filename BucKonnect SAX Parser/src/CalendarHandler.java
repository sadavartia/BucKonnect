

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class CalendarHandler extends DefaultHandler {

	private String temp;
	public Calendar calendarInfo;

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
		if (qName.equalsIgnoreCase("Calendar")) {
			calendarInfo = new Calendar();
		}
	}

	/*
	 * When the parser encounters the end of an element, it calls this method
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
	
		
		if (qName.equalsIgnoreCase("OSU_Email_ID")) {
			calendarInfo.setOSU_Email_ID(temp);
		} else if (qName.equalsIgnoreCase("startDateTime")) {
			calendarInfo.setStartDateTime(temp);
		} else if (qName.equalsIgnoreCase("endDateTime")) {
			calendarInfo.setEndDateTime(temp);
		} else if (qName.equalsIgnoreCase("location")) {
			calendarInfo.setLocation(temp);
		} else if (qName.equalsIgnoreCase("calendarId")) {
			calendarInfo.setCalendarId(Integer.parseInt(temp));
		} else if (qName.equalsIgnoreCase("eventName")) {
			calendarInfo.setEventName(temp);
		}  
	}

}
