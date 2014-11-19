

public class Group {
	private String OSU_Email_ID;
    private String groupName;
    private String groupInfo;
    private int groupId;
    private String primaryAdmin;
   // private boolean isFaculty;
    private String secondaryAdmin;
    private String post;
    private String category;
    //private String major;
    //private String interests;
    
    
   public Group() {
    }

    public Group(String OSU_Email_ID,String groupName,String groupInfo,int groupId,String primaryAdmin,String secondaryAdmin,String post,String category) {
           this.OSU_Email_ID = OSU_Email_ID;
           this.groupName = groupName;
           this.groupInfo = groupInfo;
           this.groupId = groupId;
           this.primaryAdmin = primaryAdmin;
           this.secondaryAdmin = secondaryAdmin;
           this.post = post;
           this.category = category;
          
           
    }

    public String getOSU_Email_ID() {
           return OSU_Email_ID;
    }

    public void setOSU_Email_ID(String OSU_Email_ID) {
        this.OSU_Email_ID = OSU_Email_ID;
    }
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    public int getGroupId() {
           return groupId;
    }

    public void setGroupId(int groupId) {
           this.groupId = groupId;
    }

    public String getPrimaryAdmin() {
           return primaryAdmin;
    }

    public void setPrimaryAdmin(String primaryAdmin) {
           this.primaryAdmin =  primaryAdmin;
    }

    public String getSecondaryAdmin() {
           return secondaryAdmin;
    }

    public void setSecondaryAdmin(String secondaryAdmin) {
           this.secondaryAdmin = secondaryAdmin;
    }
    
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
        
    public String toString() {
           StringBuffer sb = new StringBuffer();
           sb.append("User Details - ");
           sb.append("OSU Email ID:" + getOSU_Email_ID() );
           sb.append(", ");
           sb.append("Group Name:" + getGroupName());
           sb.append(", ");
           sb.append("Group Info:" + getGroupInfo() );
           sb.append(", ");
           sb.append("Group Id:" + getGroupId());
           sb.append(", ");
           sb.append("Primary Admin:" + getPrimaryAdmin());
           sb.append(", ");
           sb.append("Secondary Admin:" + getSecondaryAdmin() );
           sb.append(", ");
           sb.append("Post:" + getPost());
           sb.append(", ");
           sb.append("Categories:" + getCategory());
           sb.append(".");
           return sb.toString();
    }

}
