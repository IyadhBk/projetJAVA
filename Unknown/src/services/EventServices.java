/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author HP
 */
public class EventServices {
    
    
    
     Connection con;
    Statement st;
    ResultSet rs;
    
    
       public EventServices(){
        con=DataSource.getInstance().getConnection();
    }
   
       public void insertEvent(Event e) 
    {
        
        String req="INSERT INTO `event`"+"(`nom`, `description`,`dateDebut`,`image`,`lieu`,`categorie_id`,`nbParticipe`,`nombrePlaces`)"+ "VALUES (?,?,?,?,?,?,?,?)";
         try{
        PreparedStatement ste = con.prepareStatement(req);
        ste.setString(1,e.getNom());
        ste.setString(2,e.getDescription());
        ste.setString(3, e.getDateDebut());
         ste.setString(4,e.getImage());
        ste.setString(5,e.getLieu());
        ste.setInt(6,e.getCategorie_id());
        ste.setInt(7,e.getNbParticipe());
        ste.setInt(8,e.getNombrePlaces());
        

        ste.executeUpdate();
         System.out.println("insertion effectuée avec succée");
         }
         
         catch (SQLException ex)
         {            Logger.getLogger(EventServices.class.getName()).log(Level.SEVERE, null, ex);

             }

                
                
                }
      
    
    
           public List<Event> SelectAllEvents()
    { 
        String req="Select * from event";
      List<Event> list = new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
            Event e=new Event(rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getString("dateDebut"), rs.getString("image"), rs.getString("lieu"),rs.getInt("Categorie_id"),rs.getInt("NbParticipe"),rs.getInt("nombrePlaces"));
               
            list.add(e);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
       
        }
       
       
         public void deleteEvent ( int id) 
       {
           String req =" DELETE FROM event WHERE id=?";
           try{
           PreparedStatement ste = con.prepareStatement(req);
           ste.setInt(1,id);
           
           int rowsDeleted = ste.executeUpdate();
            if (rowsDeleted > 0) {
                 System.out.println("an event was deleted");
           } 
           }
           
        catch (SQLException ex)
         {            Logger.getLogger(EventServices.class.getName()).log(Level.SEVERE, null, ex);

             }           
           

}
   
         
         
          public void updateEvent (Event e , int id) 
       {
           String sql ="UPDATE event SET nom=?,description=?,dateDebut=?,image=?,lieu=?,Categorie_id=?,NbParticipe=? WHERE id=?";
           try{
           PreparedStatement ste = con.prepareStatement(sql);
            ste.setString(1,e.getNom());
        ste.setString(2,e.getDescription());
        ste.setString(3, e.getDateDebut());
         ste.setString(4,e.getImage());
        ste.setString(5,e.getLieu());
        ste.setInt(6,e.getCategorie_id());
        ste.setInt(7,e.getNbParticipe());
           ste.setInt(8,id);
           int rowsUpdated = ste.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An event was updated ");
			}
           
           
          }
           catch (SQLException ex)
         {            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

             }
       }
          
          
    public void decrEtChangementDetat(int nbr,int idev) {
         try{
        String req = "UPDATE `event` SET `nombrePlaces`=(?) WHERE `id`=(?)";
        PreparedStatement pstmt = con.prepareStatement(req);
        pstmt.setInt(1,nbr);
       
        pstmt.setInt(2,idev);
        

         pstmt.executeUpdate();
            System.out.println("decrementation nbr place et etat effectué ");
        } catch (SQLException ex) {
            Logger.getLogger(EventServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

  
         
         
         
         
}
