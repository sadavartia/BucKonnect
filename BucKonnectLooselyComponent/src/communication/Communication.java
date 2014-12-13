package communication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Communication {

	private Connection conn;

	public Communication() throws Exception {
		Class.forName("org.h2.Driver");

		conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/BucKonnectDestination", "sa", "bucks");
	}

	private static String USER_NAME = "buckonnect";  // GMail user name (just the part before "@gmail.com")
	private static String PASSWORD = "gobucks!"; // GMail password
	//	private static String RECIPIENT = "+16148150762@tmomail.net";


	public static void main(String[] args) {

		try {
			Communication obj= new Communication();
			obj.readEmailID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readEmailID(){


		try{
			String query = "SELECT * FROM Users";
			Statement stmt = conn.createStatement();;

			ResultSet results = stmt.executeQuery(query);
			String from = USER_NAME;
			String pass = PASSWORD;

			String subject = "Welcome to BucKonnect!!!";
			String body;

			while (results.next()) {
				System.out.println("OSU_Email_ID : "
						+ results.getString("OSU_EMAIL_ID"));
				String phone_number= results.getString("PHONE_NUMBER");
				body = "Dear " +  results.getString("FIRST_NAME") + ", You are receiving this email/sms as you were registered as a user during BucKonnect's Demo. We thank you for being a part of BucKonnect!";
				String[] phone = { phone_number +"@tmomail.net"} ; // list of recipient email addresses
				String[] to = { results.getString("OSU_EMAIL_ID")};
				sendFromGMail(from, pass, to, subject, body);
				if(!(phone_number.isEmpty())){
					sendFromGMail(from, pass, phone, subject, body);
				}


			}
		}
		catch (Exception error) {
			System.out.println(error);
		}
	}




	private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for( int i = 0; i < to.length; i++ ) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for( int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}
		catch (AddressException ae) {
			ae.printStackTrace();
		}
		catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}

