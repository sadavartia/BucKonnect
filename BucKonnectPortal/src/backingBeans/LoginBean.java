package backingBeans;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Sessions.*;

/**
 * @author Nandkumar
 *
 */
public class LoginBean {
	@EJB
	private UserService userService;
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	
	public String login_User() {
		if (!name.isEmpty() && !password.isEmpty()) {
			UserEntity user = new UserEntity();
			user.setOSU_Email_Id(getName());
			user.setPassword(getPassword());
			String ret = userService.login_User(user);
			if (ret.equalsIgnoreCase("success"))
				return "success";
			else
				return "failure";
		}
		else
			return "Error";
	}
}
