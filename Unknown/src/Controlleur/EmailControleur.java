/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author s
 */
public class EmailControleur {
    
    String reciever;
    String subj;
    String con;
    final String username;
    final String password;
    String from;
    String host;
    String put_auth;
    String put_ttls;
    String put_host;
    String put_port;

   

    public EmailControleur(String reciever, String subj, String con) {
        username = "zanimaux.pi@gmail.com";
        password = "zanimaux123456";
        from = "meher.hkimi@esprit.tn";
        host = "smtp.gmail.com";
        put_auth = "mail.smtp.auth";
        put_ttls = "mail.smtp.starttls.enable";
        put_host = "mail.smtp.host";
        put_port = "mail.smtp.port";
        this.reciever = reciever;
        this.subj = subj;
        this.con = con;
    }

   public EmailControleur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//   public  Email() {
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   }

    public void send() {

        Properties props = new Properties();
        props.put(put_auth, "true");
        props.put(put_ttls, "true");
        props.put(put_host, host);
        props.put(put_port, "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever));
            message.setSubject(subj);
            message.setText(con);
            Transport.send(message);
//            JOptionPane.showMessageDialog(null, "Done, check mailbox !");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }}
    

