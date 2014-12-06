package backingBeans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Sessions.*;

public class LoginBean {
	@EJB
	private UserService userService;
	private String name;
	private String password;
	
	public static final String SALT = "my-salt-text";

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
		
		String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
		this.password = hashedPassword;
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
				return "Error";
		}
		else
			return "Error";
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
