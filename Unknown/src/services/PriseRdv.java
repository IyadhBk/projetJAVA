/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Article;
import models.UserDoha;
import models.rdv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author didid
 */
public class PriseRdv {
    
    
     Connection con;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    
    
    
   public PriseRdv()
   {      con=DataSource.getInstance().getConnection();
   }
   
   public List<UserDoha> rechercheDate(String date)
   {
       
       
    String req="SELECT id_User,nom , prenom , adresse , email FROM rdv,test_user "
            + "WHERE test_user.id_user=rdv.idVet AND test_user.roles LIKE '%ROLE_VETERINAIRE%' AND DATE_FORMAT(date,'%Y-%m-%d') != ?" ;

      List<UserDoha> listrdv = new ArrayList<>();
        try {
           preparedStatement  = con.prepareStatement(req);
           preparedStatement.setString(1, date);
           rs= preparedStatement.executeQuery();
            System.out.println(req);
            while(rs.next())
            {
                //System.out.println(rs.getString("nom"));
                UserDoha vet = new UserDoha(rs.getInt("id_User"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("email"));
            
            //rdv Rdv=new rdv(rs.getInt("idUser"),rs.getInt("idVet"),rs.getString("date"));
               
            listrdv.add(vet);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listrdv;
       
        }
   
     public List<UserDoha> rechercheListVet()
             
   {  String req1="SELECT id_User,nom , prenom , adresse , email,numTel FROM test_user WHERE roles LIKE '%ROLE_VETERINAIRE%'";
   
      List<UserDoha> list1 = new ArrayList<>();
      
         try {
            preparedStatement  = con.prepareStatement(req1);
                rs=preparedStatement.executeQuery(req1);
            while(rs.next())
            {
               
            UserDoha user1=new UserDoha(rs.getInt("id_User"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("numTel"));
               
            list1.add(user1);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list1;
        
        
}
     
     
      public void insertRDV(rdv RDV) throws SQLException
    {
        
        String req="INSERT INTO `rdv`"+"(`date`, `idUser`,`idVet`)"+ "VALUES (?,?,?)";
         try{
        PreparedStatement ste = con.prepareStatement(req);
        ste.setString(1,RDV.getDate());
        ste.setInt(2,RDV.getIdUser());
        ste.setInt(3,RDV.getIdVet());
        

        ste.executeUpdate();
         }
         catch (SQLException ex)
         {            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

             }

                
                
                }
      
      
     
}
    

