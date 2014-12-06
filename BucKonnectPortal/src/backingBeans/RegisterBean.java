package backingBeans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.*;
import bucKonnect.EJB.Sessions.*;

public class RegisterBean {
	@EJB
	private UserService userService;
	private String name;
	private String password;
	private String valid;
	
	 public static final String SALT = "my-salt-text";

	public String getName() {
		return name;
	}

	public void setName(final String name) {

		UserEntity user = new UserEntity();
		System.out.println("HI My name is " + name);
		user.setOSU_Email_Id(name);
		System.out.println(user.getOSU_Email_Id());

		List<List<String>> lsUsers = new ArrayList<List<String>>();

		lsUsers = userService.search_Users(user);
		System.out.println("Outside check size" + lsUsers.size());
		if (lsUsers.size() > 0) {
			setValid("Not a Valid User Name");
		} else
			setValid("Valid User Name");

		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
		this.password = hashedPassword;
	}

	public String register_User() {
		if ((name.isEmpty() != true) && (password.isEmpty() != true)) {
			UserEntity user = new UserEntity();
			user.setOSU_Email_Id(getName());
			user.setPassword(getPassword());
			String ret = userService.register_User(user);
			if (ret.equalsIgnoreCase("success"))
				return "success";
			else
				return "Error";
		} else
			return "Error";
	}

	/**
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}
	
	 public static String generateHash(String input) {
	        StringBuilder hash = new StringBuilder();

	        try {
	            MessageDigest sha = MessageDigest.getInstance("SHA-1");
	            byte[] hashedBytes = sha.digest(input.getBytes());
	            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	                    'a', 'b', 'c', 'd', 'e', 'f' };
	            for (int idx = 0; idx < hashedBytes.length;++idx) {
	                byte b = hashedBytes[idx];
	                hash.append(digits[(b & 0xf0) >> 4]);
	                hash.append(digits[b & 0x0f]);
	            }
	        } catch (NoSuchAlgorithmException e) {
	            // handle error here.
	        }

	        return hash.toString();
	    }
}
