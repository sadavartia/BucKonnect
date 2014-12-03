public class Event {
	private String eventName;
	private String eventInfo;
	private String eventDetails;
	private String primaryEventCoordinator;
	private String eventLocation;
	private String eventDateTime;
	private String eventDuration;

	public Event() {
	}

	public Event(String eventName, String eventInfo, String eventDetails,
			String primaryEventCoordinator, String eventLocation,
			String eventDateTime, String eventDuration) {
		this.eventName = eventName;
		this.eventInfo = eventInfo;
		this.eventDetails = eventDetails;
		this.primaryEventCoordinator = primaryEventCoordinator;
		this.eventLocation = eventLocation;
		this.eventDateTime = eventDateTime;
		this.eventDuration = eventDuration;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}

	public String getPrimaryEventCoordinator() {
		return primaryEventCoordinator;
	}

	public void setPrimaryEventCoordinator(String primaryEventCoordinator) {
		this.primaryEventCoordinator = primaryEventCoordinator;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Event Details - ");
		sb.append("Event Name:" + getEventName());
		sb.append(", ");
		sb.append("Event Info:" + getEventInfo());
		sb.append(", ");
		sb.append("Event Details:" + getEventDetails());
		sb.append(", ");
		sb.append("Primary EC:" + getPrimaryEventCoordinator());
		sb.append(", ");
		sb.append("Event Location:" + getEventLocation());
		sb.append(", ");
		sb.append("Event DateTime:" + getEventDateTime());
		sb.append(", ");
		sb.append("Event Duration:" + getEventDuration());
		sb.append(".");
		return sb.toString();
	}

	/**
	 * @return the eventInfo
	 */
	public String getEventInfo() {
		return eventInfo;
	}

	/**
	 * @param eventInfo
	 *            the eventInfo to set
	 */
	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}

	/**
	 * @return the eventLocation
	 */
	public String getEventLocation() {
		return eventLocation;
	}

	/**
	 * @param eventLocation
	 *            the eventLocation to set
	 */
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	/**
	 * @return the eventDateTime
	 */
	public String getEventDateTime() {
		return eventDateTime;
	}

	/**
	 * @param eventDateTime
	 *            the eventDateTime to set
	 */
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	/**
	 * @return the eventDuration
	 */
	public String getEventDuration() {
		return eventDuration;
	}

	/**
	 * @param eventDuration
	 *            the eventDuration to set
	 */
	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}

}
