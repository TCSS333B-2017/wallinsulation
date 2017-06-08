package gui;

public class SignIn {

	private String user;
	private String pass;
	
	public boolean checkSignIn(String theUser, String thePass) {
		user = theUser;
		pass = thePass;
		System.out.println(user + " " + pass);
		if(user.equals("admin") && pass.equals("password")) {
			return true;
		}	else {
			return false;
		}
	}
}
