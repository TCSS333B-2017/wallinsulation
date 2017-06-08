package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInPage {
	private JPanel myPanel;
	
	private JTextField myUsernameField;
	private JPasswordField myPasswordField;
	private JLabel myTitle;
	private JLabel myUsernameLabel;
	private JLabel myPasswordLabel;
	private JLabel myErrorLabel;
	private JButton mySignInButton;
	private JButton mySignUpButton;
	private String myUsername;
	private String myPassword;
	public SignInPage(JPanel thePanel){
		myPanel = thePanel;
	}
	void evokeSignIn(){
		myPanel.setBackground(Color.LIGHT_GRAY);
		setUpSignInPage();
		myPanel.setVisible(true);
	}
	private void setUpSignInPage(){
		myTitle = new JLabel("Sign-In");
		myTitle.setForeground(Color.BLACK);
		myTitle.setFont(new Font("STZhongsong", Font.BOLD, 30));
		myTitle.setBounds(380,30, 340, 119);
		myPanel.add(myTitle);
		setUpUsername();
		setUpPassword();
		setUpSignInButton();
		setUpSignUpButton();
	}
	private void setUpUsername(){
		myUsernameLabel = new JLabel("Username:");
		myUsernameLabel.setBounds(310, 197, 100, myUsernameLabel.getPreferredSize().height);
		myPanel.add(myUsernameLabel);
		myUsernameField = new JTextField();
		myUsernameField.setBounds(380, 193, 150, myUsernameField.getPreferredSize().height);
		myPanel.add(myUsernameField);
	}
	private void setUpPassword(){
		myPasswordLabel = new JLabel("Password:");
		myPasswordLabel.setBounds(310, 247, 100, myPasswordLabel.getPreferredSize().height);
		myPanel.add(myPasswordLabel);
		myPasswordField = new JPasswordField();
		myPasswordField.setBounds(380, 243, 150, myPasswordField.getPreferredSize().height);
		myPanel.add(myPasswordField);
	}
	private void setUpSignInButton(){
		mySignInButton = new JButton("Sign-In");
		mySignInButton.setBounds(304, 297, 100, mySignInButton.getPreferredSize().height);
		mySignInButton.addActionListener(new SignInListener());
		myPanel.add(mySignInButton);
	}
	private void setUpSignUpButton(){
		mySignUpButton = new JButton("Sign-Up");
		mySignUpButton.setBounds(430, 297, 100, mySignUpButton.getPreferredSize().height);
		mySignUpButton.addActionListener(new SignUpListener());
		myPanel.add(mySignUpButton);
	}
	public class SignInListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int unCount = myUsernameField.getText().length();
			int passCount = myPasswordField.getPassword().length;
 ///				myPanel.remove(myErrorLabel);
				myPanel.repaint();
				myUsername = myUsernameField.getText();
				myPassword = new String(myPasswordField.getPassword());
				///////////
				
				URL url = getClass().getResource("login.txt");
				File loginf = new File(url.getPath());
				if(loginf.exists()) {System.out.println("file exists");}
	            try{
	                Scanner read = new Scanner(loginf);
	                read.useDelimiter(",");

	                boolean login = false;
	                while(read.hasNextLine()){
	                   String user = read.next();
	                   String pass = read.next();
	                   if(myUsername.equals(user) && myPassword.equals(pass)){
	                      login = true;
	                      break;                 
	                   }
	                }
	                if(login)
		                   myPanel.setVisible(false);
	                else {
		                JOptionPane.showMessageDialog(null, "Incorrect username or password");
		                myUsernameField.setText("");
		                myPasswordField.setText("");
	                }


	                read.close();
	            }
	            catch (FileNotFoundException qwerty){
	                    JOptionPane.showMessageDialog(null, "Can't find a text file");
	            }
	       }
				
			
				
				
				
				
//				SignIn signInCheck = new SignIn();
//				if(signInCheck.checkSignIn(myUsername, myPassword))	{
//					myPanel.setVisible(false);
//					myPanel.repaint();
//				} else { System.out.println("false"); }
//			} else {
//				myErrorLabel = new JLabel ("<html>Username has to be longer than 5 char<br>"
//						+ "Password has to be longer than 5 char<html>");
//				myErrorLabel.setForeground(Color.RED);
//				myErrorLabel.setBounds(550, 210, myErrorLabel.getPreferredSize().width, myErrorLabel.getPreferredSize().height);
//				myPanel.add(myErrorLabel);
//				myPanel.repaint();
			}

	public class SignUpListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("let's Sign Up! lol");
		}
		
	}
}
