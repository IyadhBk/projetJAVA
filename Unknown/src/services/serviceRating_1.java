/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Article;
import models.rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author didid
 */
public class serviceRating_1 {
    
     Connection con;
    Statement st;
    ResultSet rs;
    
    
    
    
    
    public serviceRating_1()
    {
     con=DataSource.getInstance().getConnection();}
    
    
    
     public void insertNote(rating rate) throws SQLException
    {
        
        String req="INSERT INTO `ratingarticle`"+"(`note`, `idArticle`)"+ "VALUES (?,?)";
         try{
        PreparedStatement ste = con.prepareStatement(req);
        ste.setDouble(1,rate.getNote());
        ste.setInt(2,rate.getIdArticle());
        ste.executeUpdate();
         }
         catch (SQLException ex)
         {            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

             }

                
                
                }
      public Map<String,Double> StatArticle()
    { String req="SELECT AVG(ratingarticle.note) as note, article_j.titre as titre from ratingarticle,article_j "
            + "WHERE article_j.id=ratingarticle.idArticle GROUP BY(ratingarticle.idArticle)";
      Map<String,Double> map = new HashMap<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
                
            map.put(rs.getString("titre"),rs.getDouble("note"));

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return map;
       
        }
    
}
