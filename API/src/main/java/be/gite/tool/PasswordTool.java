package be.gite.tool;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordTool {
	
	String hashed;
	String password;
	String candidate;
	
	public String encodePassword(String password) {
		//Hash a password for the first time
		hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		
		return hashed;
	}

	public boolean checkPassword(String candidate, String hashed) {
		//Check that an unencrypted password matches one that has
		//previously been hashed
		if (BCrypt.checkpw(candidate, hashed)) {
			return true;
		} else {
			return false;
		}
	}
}



