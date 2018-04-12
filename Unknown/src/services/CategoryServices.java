/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;
import java.sql.PreparedStatement;
/**
 *
 * @author HP
 */
public class CategoryServices {
    
    Connection con;
    Statement st;
    ResultSet rs;
    
    public CategoryServices(){
        con=DataSource.getInstance().getConnection();
    }
     public void insertCategorie(Category c)
     {
        String req="INSERT INTO `categorie`"+"( `type`)" 
                +"VALUES (?)";
        try {
            PreparedStatement ste = con.prepareStatement(req);
            ste.setString(1, c.getType());
           
            ste.executeUpdate();
            System.out.println("insertion effectuée avec succée");
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
