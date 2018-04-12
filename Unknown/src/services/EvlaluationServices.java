/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Evaluation;
import models.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author HP
 */
public class EvlaluationServices {
     
     Connection con;
    Statement st;
    ResultSet rs;

    public EvlaluationServices() {
                con=DataSource.getInstance().getConnection();

    }
      public void insertEvent(Evaluation e) 
    {
        
        String req="INSERT INTO `evaluation`"+"(`iduser`, `idevenement`,`note`)"+ "VALUES (?,?,?)";
         try{
        PreparedStatement ste = con.prepareStatement(req);
        ste.setInt(1,e.getIduser());
        ste.setInt(2,e.getIdevnement());
        ste.setFloat(3, e.getNote());
         
        

        ste.executeUpdate();
         System.out.println("insertion effectuée avec succée");
         }
         
         catch (SQLException ex)
         {            Logger.getLogger(EventServices.class.getName()).log(Level.SEVERE, null, ex);

             }

                
                
                }
    
    
     
   
    
}
