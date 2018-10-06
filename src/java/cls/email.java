/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cls;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Zee
 */
public class email {
    
      private static String USER_NAME = "playwithmetoyz";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "19940617@Zee"; // GMail password
    private static String RECIPIENT ;
    
    public static void getbody(String ebody,String temail){
        try {
         
            System.out.println(ebody);
            System.out.println(temail);
             
                RECIPIENT = temail;
//                 String un =r.getString("user_Name");
//                   String pw  =r.getString("password");
                 
                  
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "PlayWithMe.lk... Verify your account";
        String body = ebody;

        sendFromGMail(from, pass, to, subject, body);
            
        } catch (Exception e) {
        e.printStackTrace();}
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
        System.out.println("Wade hari");
            
//           JOptionPane.showMessageDialog(null, "Email SENT Sucessfull");
        }
        catch (AddressException ae) {
//             JOptionPane.showMessageDialog(null, "Please Contact Developers");
            System.out.println("Please Address");
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            
//              JOptionPane.showMessageDialog(null, "Please Connect To Internet");
System.out.println("Please Connect To Internet");
           
        }
    }
}
