

public class Calendar {
	private String OSU_Email_ID;
	private String startDateTime;
	private String endDateTime;
	private int calendarId;
	private String location;
	private String eventName;

	public Calendar() {
	}

	public Calendar(String OSU_Email_ID, String startDateTime, String endDateTime,
			int calendarId, String location, String eventName) {
		this.OSU_Email_ID = OSU_Email_ID;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location;
		this.calendarId = calendarId;
		this.eventName = eventName;

	}

	public String getOSU_Email_ID() {
		return OSU_Email_ID;
	}

	public void setOSU_Email_ID(String OSU_Email_ID) {
		this.OSU_Email_ID = OSU_Email_ID;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("User Details - ");
		sb.append("OSU Email ID:" + getOSU_Email_ID());
		sb.append(", ");
		sb.append("Calendar_Start_Time:" + getStartDateTime());
		sb.append(", ");
		sb.append("Calendar_End_Time:" + getEndDateTime());
		sb.append(", ");
		sb.append("Location:" + getLocation());
		sb.append(", ");
		sb.append("Calendar ID:" + getCalendarId());
		sb.append(", ");
		sb.append("Event Name:" + getEventName());
		sb.append(".");

	
		return sb.toString();
	}

}
