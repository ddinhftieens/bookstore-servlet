/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Properties;
import java.util.Random;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Dell
 */
public class SendEmailConfim {

    public static int send(String emailFrom, String passEmailFrom, String emailTo) throws MessagingException {
        Random rd = new Random();
        int code = 100000 + rd.nextInt(1000000);
        System.out.println(code);

        //step 1
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.port", "465");
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(true);

        //step 2
        Message message = new MimeMessage(session);
        message.setSubject("Forgot Pass");
        message.setText("Code: " + code);

        //setp 3
        Address addressFrom = new InternetAddress(emailFrom);
        message.setFrom(addressFrom);
        Address addressTo = new InternetAddress(emailTo);
        message.setRecipient(Message.RecipientType.TO, addressTo);

        //step 4
        Transport transport = session.getTransport();
        transport.connect(emailFrom, passEmailFrom);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        
        return code;
    }
}
