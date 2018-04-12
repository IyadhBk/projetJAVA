/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import iservices.IAnimauxService;
import iservices.IGardeService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Animaux;
import models.Association;
import models.Garde;
import models.User;
import services.GardeService;
import technique.DataSource;

/**
 *
 * @author s
 */
 
public class AnimauxService implements IAnimauxService{
  
    private Connection connection;
    private PreparedStatement pst;
    IGardeService serviceGarde =new GardeService();
    AssociationService associationservice = new AssociationService();
     public AnimauxService(){
      connection = DataSource.getInstance().getConnection();
    
}
     
    @Override
    public void ajoutAnimaux(Animaux Animaux) {
           String req="INSERT INTO Animaux(nom,type,coleur,age,sexe,Garde_id,User_id,brochure,Association_id) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1,Animaux.getNom());
            pst.setString(2,Animaux.getType());
            pst.setString(3,Animaux.getColeur());
            pst.setString(4,Animaux.getAge());
            pst.setString(5,Animaux.getSexe());
           // pst.setDate(6,Animaux.getDateAdoption());
            pst.setInt(6,Animaux.getGarde().getId());
            pst.setInt(7, Animaux.getUser().getId());
            pst.setString(8,Animaux.getBrochure());
            pst.setInt(9,Animaux.getAssociation().getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void ajoutAnimaux1(Animaux Animaux) {
           String req="INSERT INTO Animaux(nom,type,coleur,age,sexe,Garde_id,brochure,Association_id) VALUES(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1,Animaux.getNom());
            pst.setString(2,Animaux.getType());
            pst.setString(3,Animaux.getColeur());
            pst.setString(4,Animaux.getAge());
            pst.setString(5,Animaux.getSexe());
//            pst.setDate(6,Animaux.getDateAdoption());
            pst.setInt(6,Animaux.getGarde().getId());
//            pst.setInt(8, Animaux.getUser().getId_user());
           pst.setString(7,Animaux.getBrochure());
            pst.setInt(8,Animaux.getAssociation().getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierAnimaux(Animaux Animaux) {
         try {
            String req="UPDATE Animaux SET nom=?,type=?,coleur=?,age=?,sexe=?,Garde_id=?,brochure=?,Association_id=?"
                    + " WHERE Id=?";
            pst = connection.prepareStatement(req);
            pst.setString(1,Animaux.getNom());
            pst.setString(2,Animaux.getType());
            pst.setString(3,Animaux.getColeur());
            pst.setString(4,Animaux.getAge());
            pst.setString(5,Animaux.getSexe());
           
            pst.setInt(6,Animaux.getGarde().getId());
            
            pst.setString(7,Animaux.getBrochure());
            pst.setInt(8,Animaux.getAssociation().getId());
            pst.setInt(9,Animaux.getAnimauxId());
            pst.executeUpdate();
             } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void modifierAnimaux1(Animaux Animaux) {
         try {
            String req="UPDATE Animaux SET date_adoption=?,User_id=?"
                    + " WHERE Id=?";
            pst = connection.prepareStatement(req);
             DateFormat dg=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now=new Date();
            pst.setString(1,dg.format(now));
            pst.setString(2,"1");
            pst.setInt(3,Animaux.getAnimauxId());
            
             System.err.println("animal modifié");
           
            pst.executeUpdate();
             } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerAnimaux(int id) {
       try {
           
            String req="DELETE FROM `Animaux` WHERE id =?";
            
            
            pst = connection.prepareStatement(req);
           
            pst.setInt(1,id);
            
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Animaux> getAnimaux() {
       String req = "select * from Animaux";
        List<Animaux>A = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
            
    Animaux Animaux = new Animaux(resultSet.getInt("id"),resultSet.getString("Nom"), resultSet.getString("type"),resultSet.getString("coleur"),resultSet.getString("age"),resultSet.getString("sexe"),resultSet.getDate("date_adoption"),new Garde (resultSet.getInt("Garde_id")),new User(resultSet.getInt("User_id")),resultSet.getString("brochure"),new Association(resultSet.getInt("Association_id")));
          A.add(Animaux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return A;
    }
     @Override
    public List<Animaux> getAnimaux1() {
       String req = "select * from Animaux";
        List<Animaux>A = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                
            int id= resultSet.getInt("Garde_id");
            int id1=resultSet.getInt("Association_id");
                System.out.println(id1);
            Garde ga = serviceGarde.findById(id);
            Association As = associationservice.findById(id1);
            
               // System.out.println(As.toString());
    Animaux Animaux = new Animaux(resultSet.getInt("id"),resultSet.getString("Nom"),resultSet.getString("age"),resultSet.getString("sexe"),ga,resultSet.getString("brochure"),As);
          A.add(Animaux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return A;
    }
      @Override
    public List<Animaux> getAnimauxUser() {
       String req = "SELECT * FROM Animaux WHERE User_id is null";
        List<Animaux>A = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                
            int id= resultSet.getInt("Garde_id");
            int id1=resultSet.getInt("Association_id");
                System.out.println(id1);
            Garde ga = serviceGarde.findById(id);
            Association As = associationservice.findById(id1);
            
               // System.out.println(As.toString());
    Animaux Animaux = new Animaux(resultSet.getInt("id"),resultSet.getString("Nom"),resultSet.getString("age"),resultSet.getString("sexe"),ga,resultSet.getString("brochure"),As);
          A.add(Animaux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return A;
    }
    
    
         @Override
    public List<Animaux> getAnimaux2() {
       String req = "SELECT * FROM Animaux WHERE User_id=25";
        List<Animaux>A = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                
            int id= resultSet.getInt("Garde_id");
            int id1=resultSet.getInt("Association_id");
                System.out.println(id1);
            Garde ga = serviceGarde.findById(id);
            Association As = associationservice.findById(id1);
            
               // System.out.println(As.toString());
    Animaux Animaux = new Animaux(resultSet.getString("Nom"),resultSet.getString("age"),resultSet.getString("sexe"),ga,resultSet.getString("brochure"),As);
          A.add(Animaux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return A;
    }
    
    
    
    
@Override
    public Animaux findById(int Id) {
         String req = "select * from Animaux where id = ?";
        Animaux Anix = null;
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,Id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Anix= new Animaux(resultSet.getString("Nom"), resultSet.getString("type"),resultSet.getString("coleur"),resultSet.getString("age"),resultSet.getString("sexe"),new Garde (resultSet.getInt("Garde_id")),resultSet.getString("brochure"),new Association(resultSet.getInt("Association_id"))); // new User(resultSet.getInt(3))
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Anix;
    }
    public static int Id;
    
    }
    

