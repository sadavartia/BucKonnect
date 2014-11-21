package backingBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

/**
 * 
 */

/**
 * @author Nandkumar
 *
 */
public class RegisterBean {
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

	public String register_User() {
		if ((name.isEmpty() != true) && (password.isEmpty() != true)) {
			UserEntity user = new UserEntity();
			user.setOSU_Email_Id(getName());
			user.setPassword(getPassword());
			String ret = userService.register_User(user);
			if (!ret.equalsIgnoreCase("success"))
				return "true";
			else
				return "Error";
		}
		else
			return "Error";
	}
}
