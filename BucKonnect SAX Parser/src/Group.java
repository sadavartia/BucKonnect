public class Group {
	private String operation;
	private String groupName;
	private String groupInfo;
	private String primaryAdmin;
	private String category;

	public Group() {
	}

	public Group(String operation, String groupName, String groupInfo,
			String primaryAdmin, String category) {
		this.operation = operation;
		this.groupName = groupName;
		this.groupInfo = groupInfo;
		this.primaryAdmin = primaryAdmin;
		this.category = category;
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

	public String getPrimaryAdmin() {
		return primaryAdmin;
	}

	public void setPrimaryAdmin(String primaryAdmin) {
		this.primaryAdmin = primaryAdmin;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Group Details - ");
		sb.append("Group Name:" + getGroupName());
		sb.append(", ");
		sb.append("Group Info:" + getGroupInfo());
		sb.append(", ");
		sb.append("Primary Admin:" + getPrimaryAdmin());
		sb.append(", ");
		sb.append("Categories:" + getCategory());
		sb.append(".");
		return sb.toString();
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

}
