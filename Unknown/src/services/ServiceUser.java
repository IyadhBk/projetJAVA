/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import technique.DataSource;
import models.User;
import Controlleur.NewFXMain1;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class ServiceUser {
     Connection conn;
    Statement statement;
    ResultSet rs;
     public ServiceUser(){
        conn=(Connection) DataSource.getInstance().getConnection();
    }
    
    public String authenticateUser(User user){
        
       String username = user.getUsername();
 String password = user.getPassword(); 
 String roles=user.getRoles();
 
 
    
 String userNameDB = "";
 String passwordDB = "";
 String roleDB = "";


 String req= ("SELECT `username`, `password`, `roles` FROM `user`");
   try
 { 
 statement=conn.createStatement();
            rs=statement.executeQuery(req);

            while(rs.next())
 {
 userNameDB = rs.getString("username");
 passwordDB = rs.getString("password");
 roleDB = rs.getString("roles");
 if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("a:2:{i:0;s:16:\"ROLE_UTILISATEUR\";i:1;s:10:\"ROLE_ADMIN\";}"))
 return "Admin";
 
 else if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("a:1:{i:0;s:16:\"ROLE_UTILISATEUR\";}"))
 return "Utilisateur";
 else if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("a:1:{i:0;s:12:\"ROLE_VENDEUR\";}"))
 return "Vendeur";
  else if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("a:1:{i:0;s:16:\"ROLE_VETERINAIRE\";}"))
 return "Veterinaire";
 }
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials";
}
    
     public  User recupererUtilisateur (String username) throws SQLException{
        User us = new User();
        Statement ste = statement.getConnection().createStatement();
         NewFXMain1 main = new NewFXMain1();
        String req="SELECT * FROM user Where username= '"+username+ "'";
         rs = ste.executeQuery(req);
         
		
        while(rs.next()){
             us= new User();
             us.setId(rs.getInt("id"));
             us.setUsername(rs.getString("username"));
             us.setRoles(rs.getString("roles"));
          
             
      
        
        }
        return us ;
    }
    }
    
    

