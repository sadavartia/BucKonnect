


public class Event {
	private String eventId;
    private String eventName;
    private String eventDetails;
  //  private int groupId;
    private String primaryEventCoordinator;
   // private boolean isFaculty;
    private String secondaryEventCoordinator;
 //   private String post;
 //   private String category;
    //private String major;
    //private String interests;

    
    
   public Event() {
    }

    public Event(String eventId,String eventName,String eventDetails, String primaryEventCoordinator,String secondaryEventCoordinator) {
           this.eventId = eventId;
           this.eventName = eventName;
           this.eventDetails = eventDetails;
           this.primaryEventCoordinator = primaryEventCoordinator;
           this.secondaryEventCoordinator = secondaryEventCoordinator;
          
           
    }

    public String getEventId() {
           return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getSecondaryEventCoordinator() {
           return secondaryEventCoordinator;
    }

    public void setSecondaryEventCoordinator(String secondaryEventCoordinator) {
           this.secondaryEventCoordinator =  secondaryEventCoordinator;
    }

    public String toString() {
           StringBuffer sb = new StringBuffer();
           sb.append("Event Details - ");
           sb.append("Event ID:" + getEventId());
           sb.append(", ");
           sb.append("Event Name:" + getEventName() );
           sb.append(", ");
           sb.append("Event Details:" + getEventDetails());
           sb.append(", ");
           sb.append("Primary EC:" + getPrimaryEventCoordinator());
           sb.append(", ");
           sb.append("Secondary EC:" + getSecondaryEventCoordinator() );
           sb.append(".");
           return sb.toString();
    }

}
