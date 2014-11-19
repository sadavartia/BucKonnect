
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class EventHandler extends DefaultHandler {

	private String temp;
	public Event eventInfo;

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
		if (qName.equalsIgnoreCase("event")) {
			eventInfo = new Event();
		}
	}
	
	/*
	 * When the parser encounters the end of an element, it calls this method
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if (qName.equalsIgnoreCase("eventId")) {
			eventInfo.setEventId(temp);
		} else if (qName.equalsIgnoreCase("eventName")) {
			eventInfo.setEventName(temp);
		} else if (qName.equalsIgnoreCase("eventDetails")) {
			eventInfo.setEventDetails(temp);
		} else if (qName.equalsIgnoreCase("primaryEventCoordinator")) {
			eventInfo.setPrimaryEventCoordinator(temp);
		} else if (qName.equalsIgnoreCase("secondaryEventCoordinator")) {
			eventInfo.setSecondaryEventCoordinator(temp);
		} 
	}

}
