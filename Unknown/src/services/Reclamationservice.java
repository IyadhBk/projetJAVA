/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import iservices.InterfaceReclamation;
import models.reclamation;
import models.User;
import technique.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author jihen
 */

    public class Reclamationservice implements InterfaceReclamation {
    private Connection connection;
    private PreparedStatement ps;
    
    public Reclamationservice() {
         connection = DataSource.getInstance().getConnection();
    }
    
    @Override
      
    public void add(reclamation e) {
        String req = "insert into reclamation (user_id,description,animalConcerné,action,image) values (?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, e.getUser_id());
            ps.setString(2, e.getDescription());
            ps.setString(3, e.getAnimalConcerné());
            ps.setInt(4, e.getAction());
             ps.setString(5, e.getImage());
             
            
            
            ps.executeUpdate();
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String req = "delete from reclamation where id =?";
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(reclamation e) {
        String req="UPDATE reclamation SET user_id='"+e.getUser_id()+"',description='"+e.getDescription()+"',animalConcerné='"+e.getAnimalConcerné()+"',action='"+e.getAction()+"'WHERE id="+e.getId();
         
        
        try {
            ps = connection.prepareStatement(req);
           
            ps.executeUpdate();
        } catch (Exception ex) {
    
            ex.printStackTrace();
        }
    }
    public List<Integer> listUser() throws SQLException
    {
        List <Integer> list = new ArrayList<>() ;
        ResultSet rs; 
        String req = "SELECT id FROM user ";
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
                             
                list.add(rs.getInt("id"));
            }
            return list;
        
            
        } 
    
    
    
    
     public List<String> listerUser() throws ParseException, SQLException {

        List <String> list = new ArrayList<>() ;
        ResultSet rs; 
        String req = "SELECT * FROM user";
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               
               
                list.add(rs.getString("username"));
            }
            return list;
            
     }
        public int GetUserIDByName(String nom) throws ParseException, SQLException {

        
        ResultSet rs; 
        String req = "SELECT * FROM user WHERE username='"+nom+"'";
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            int id = 0;
            
            while (rs.next()) {
               
               
               id= rs.getInt("id");
            }
            return id;
            
            
        }  
            
            
            
            
            
            
            
            
            
    

    
    
  

    
    public ObservableList<reclamation> listerReclamation(int action) throws ParseException {

        ObservableList <reclamation> list = FXCollections.observableArrayList();
        ResultSet rs; 
        String req = "SELECT * FROM reclamation WHERE action= "+action;
        try {
            ps = connection.prepareStatement(req);
            
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               reclamation e = 
                       new reclamation(rs.getInt("id"), rs.getInt("user_id"), rs.getString("description"),rs.getString("animalConcerné"), rs.getInt("action"));
                        
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Reclamationservice.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    

}
    
    public ObservableList<reclamation> listerReclamation1(int action) throws ParseException {

        ObservableList <reclamation> list = FXCollections.observableArrayList();
        ResultSet rs; 
        String req = "SELECT * FROM reclamation WHERE action= "+action;
        try {
            ps = connection.prepareStatement(req);
            
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               reclamation e = 
   new reclamation(rs.getInt("id"), rs.getInt("user_id"), rs.getString("description"),rs.getString("animalConcerné"), rs.getInt("action"));                        
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Reclamationservice.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    

}
    
    public void accepter(int id) {
        
        String req="UPDATE reclamation SET action='"+1+"'WHERE id="+id;
      
         
        
        try {
            ps = connection.prepareStatement(req);
           ps.executeUpdate();
          
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
  /*  public void sendMail(String userMail,String pass,String sujet,String contenu) throws MessagingException{
    
        
        String to = "ali.nemri@esprit.tn";
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put( "mail.smtp.host", host );
        prop.put("mail.smtp.user", userMail);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userMail));
         
        InternetAddress toAdresse = new InternetAddress(to);
                
        msg.setRecipient(Message.RecipientType.TO, toAdresse);
        msg.setSubject(sujet);
        msg.setContent(contenu,"text/html; charset=utf-8");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, userMail, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    
          
        
        
    }
    
    public int GetCountTableCommentaire(int id)
    {
         ResultSet rs; 
         int Total=0;
        String req = "SELECT COUNT(*) AS total FROM commentaire_service WHERE service_id="+id; 
         try {
            ps = connection.prepareStatement(req);
            
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
                Total = rs.getInt("total");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
            
         return Total;
    }
    
    public void addCment(String comment, int serviceId, int idUser) {
        String req = "insert into commentaire_service (user_id,service_id,contenu) values (?,?,?)";
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idUser);
            
            ps.setInt(2, serviceId);
            ps.setString(3, comment);
            
            
            
            
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<String> listerComment(int id) throws ParseException, SQLException {

        List <String> list = new ArrayList<>() ;
        ResultSet rs; 
        String req = "SELECT * FROM commentaire_service WHERE service_id="+id;
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               
               
                list.add(rs.getString("contenu"));
            }
            return list;
        
    

}
    
    public List<String> listerCommentUser(int id) throws ParseException, SQLException {

        List <String> list = new ArrayList<>() ;
        ResultSet rs; 
        String req = "SELECT * FROM commentaire_service WHERE service_id="+id;
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            ServiceService ss = new ServiceService();
            
            while (rs.next()) {
               
               
                list.add(ss.GetUserNameById(rs.getInt("user_id")));
            }
            return list;
        
    

    
}
    
    
    
    
    
    
    
    
    

    
    
    */
     public String GetUserNameById(int id) throws ParseException, SQLException {

        
        ResultSet rs; 
        String req = "SELECT * FROM user WHERE id="+id;
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            String nom="";
            
            while (rs.next()) {
               
               
               nom= rs.getString("username");
            }
            return nom;
        
    

}
    public String GetReclamationByID(int id) throws ParseException, SQLException {

        
        ResultSet rs; 
        String req = "SELECT * FROM reclamation WHERE id="+id;;
        
            ps = connection.prepareStatement(req);
            rs = ps.executeQuery(req);
            String comm="";
            
            while (rs.next()) {
               
               
               comm= rs.getString("description");
            }
            return comm;
        
    

    }
    public void sendMail(String userMail,String pass,String sujet,String contenu) throws MessagingException{
    
        
        String to = "jihene.yahyaoui@esprit.tn";
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put( "mail.smtp.host", host );
        prop.put("mail.smtp.user", userMail);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       Session session = Session.getDefaultInstance(prop, null);  

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userMail));
         
        InternetAddress toAdresse = new InternetAddress(to);
                
        msg.setRecipient(Message.RecipientType.TO, toAdresse);
        msg.setSubject(sujet);
        msg.setContent(contenu,"text/html; charset=utf-8");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, userMail, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    
          
        
        
    }
     
   
    public void adevent(reclamation r) throws SQLException, FileNotFoundException {
        String s = "/home/jihen/kk.jpg";
    
        
        PreparedStatement p = connection.prepareStatement("insert into reclamation (user_id,description, AnimalConcerné,action,path,img) values(?,?,?,?,?,?)");
       
        p.setInt(1, r.getUser_id());
            p.setString(2, r.getDescription());
            p.setString(3, r.getAnimalConcerné());
             p.setInt(4, r.getAction());
              p.setString(5, r.getPath());
       // p.setString(8,current_timestamp );
        File file = new File(s);
        FileInputStream fis = new FileInputStream(file);
        p.setBinaryStream(6, fis, (int) file.length());
        
        p.executeUpdate();
        System.out.println("ajout ok");
    
    }
     public ObservableList<XYChart.Series<String, Integer>> getChartData(String stats) {
     

        String query = "SELECT count(id),animalConcerné FROM reclamation GROUP BY animalConcerné ORDER BY animalConcerné ASC ";
       
     
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList<XYChart.Series<String, Integer>> data = FXCollections.observableArrayList();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
     


        switch (stats) {
            case "animalConcerné":
                try {
                    if (statement != null) {
                        rs = statement.executeQuery(query);
                    }
                 
                    while (rs.next()) {
                     Reclamationservice bch = new Reclamationservice();
                        reclamation b= new reclamation();
                        b.setAnimalConcerné(rs.getString("animalConcerné"));
                        series.getData().add(new XYChart.Data<>(b.getAnimalConcerné(), rs.getInt(1)));
                      //  series.getData().add(new XYChart.Data<>("", rs.getInt(1)));
                   
                      
                        b.setAnimalConcerné(rs.getString(2));
                        
                        System.out.println(b.getAnimalConcerné());
                    } 
                    data.add(series);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
          
          
            default:
                data = null;
        }

        return data;
    }
      
    public ObservableList<reclamation> lister() throws ParseException {

        ObservableList <reclamation> list = FXCollections.observableArrayList();
        ResultSet rs; 
        String req = "SELECT * FROM reclamation ";
        try {
            ps = connection.prepareStatement(req);
            
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               reclamation e = 
                       new reclamation( rs.getInt("user_id"), rs.getString("description"),rs.getString("animalConcerné"), rs.getString("image"));
                        
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Reclamationservice.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    }
        public ObservableList<reclamation> lister1() throws ParseException {

        ObservableList <reclamation> list = FXCollections.observableArrayList();
        ResultSet rs; 
        String req = "SELECT * FROM reclamation ";
        try {
            ps = connection.prepareStatement(req);
            
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               reclamation e = 
                       new reclamation( rs.getString("animalConcerné"));
                        
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Reclamationservice.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    

}
    }
    
    
    


    

