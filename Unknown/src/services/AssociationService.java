/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import iservices.IAssociationService;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Association;
import technique.DataSource;

/**
 *
 * @author p
 */
public class AssociationService implements IAssociationService {
    private final Connection connection;
    private PreparedStatement pst;

    public AssociationService() {
        connection = DataSource.getInstance().getConnection();
    }
    
    

    
    

   
     
         
     
       
    
    
    
    @Override
    public void ajouterAssociation(Association a) {
       String req="INSERT INTO `association`(`Nom_association`, `email`, `Num_telephone`, `addresse`, `latitude`, `longititude`,`image`) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1,a.getNom_association());
            pst.setString(2,a.getEmail());
            pst.setInt(3,a.getNum_tel());
            pst.setString(4,a.getAdresse());
            pst.setDouble(5, a.getLatitude());
            pst.setDouble(6, a.getLongititude());
            pst.setString(7, a.getImage());

            
          //  pst.setInt(4, circuit.getEvenementCircuit().getEvenementId());
            pst.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }

    @Override
    public void modifierAssociation(Association a) {
        try {
                String req =" UPDATE `association` SET `Nom_association`=?,`email`=?,`Num_telephone`=?,`addresse`=?,`image`=?" + " WHERE id = ?" ;
                
                
                pst = connection.prepareStatement(req);
                pst.setString(1,a.getNom_association());
                pst.setString(2,a.getEmail());
                pst.setInt(3,a.getId());
                pst.setString(4,a.getAdresse());
                pst.setString(5,a.getImage());
                
                
                pst.setInt(6, a.getId());
                pst.execute();
                
            } catch (SQLException e) {
               e.printStackTrace();
            }
    }

    @Override
    public void supprimerAssociation(int id) {
       try {
           
            String req="DELETE FROM `association` WHERE id =?";
            
            
            
            pst = connection.prepareStatement(req);
           
            pst.setInt(1,id);
            
            pst.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }


     
    public List<Association> getAssociation1() {
        List<Association> Associations = new ArrayList<Association>();
       String req = "SELECT * FROM `association`";
      
     
           try {
               
               pst = connection.prepareStatement(req);
               
               ResultSet resultSet =pst.executeQuery();
               while (resultSet.next()){
                   Association a = new Association(resultSet.getInt("id"), resultSet.getString("nom_association"),resultSet.getDouble("latitude"),resultSet.getDouble("longitude"),resultSet.getString("addresse"),resultSet.getString("email"),resultSet.getInt("num_tel"),resultSet.getString("image"));
                  // System.out.println(resultSet.getString("nom_association"));
                   Associations.add(a);
               
               }
               
               
           } catch (SQLException e) {
                e.printStackTrace();
           }
           
     return Associations;
      
}
    
    public List<Association> getAssociation() {
         String req = "select * from Association";
        List<Association> assocaitions = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
            
                Association asso = new Association(resultSet.getInt("id"),resultSet.getString("Nom_association"));
                assocaitions.add(asso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return assocaitions;
    }

    @Override
    public List<Association> getAssociations1() {
        List<Association>Association1 = new ArrayList<Association>();
        String req = "SELECT * FROM `association`";
    
    try {
               
               pst = connection.prepareStatement(req);
               
               ResultSet resultSet =pst.executeQuery();
               while (resultSet.next()){
                   Association a = new Association(resultSet.getInt("id"), resultSet.getString("nom_association"), resultSet.getString("addresse"),resultSet.getString("email"),resultSet.getInt("num_telephone"),resultSet.getString("image"));
                  // System.out.println(resultSet.getString("nom_association"));
                   Association1.add(a);
               
               }
               
               
           } catch (SQLException e) {
                e.printStackTrace();
           }
           
     return Association1;
      
    }

    @Override
    public Association findby(int id) {
        
          String req = "select * from association where id = ?";
        Association a = null;
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                a= new Association(resultSet.getString("nom_association"),resultSet.getString("addresse"),resultSet.getString("email"),resultSet.getInt("Num_telephone"),resultSet.getString("image")); // new User(resultSet.getInt(3))
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
        
    }

    @Override
    public void AjouterAssociationParId(Association a) {
        
         String req="INSERT INTO `association`(`user_id` `Nom_association`, `email`, `Num_telephone`, `addresse`, `latitude`, `longititude`,`image`   ) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1,a.getUser().getId()+"");
            pst.setString(1,a.getNom_association());
            pst.setString(2,a.getEmail());
            pst.setInt(3,a.getNum_tel());
            pst.setString(4,a.getAdresse());
            pst.setDouble(5, a.getLatitude());
            pst.setDouble(6, a.getLongititude());
            pst.setString(7, a.getImage());

            
          //  pst.setInt(4, circuit.getEvenementCircuit().getEvenementId());
            pst.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
        
    }
    
    public Association findById(int idAssociation) {
        String req = "select * from Association where id = ?";
        Association A = null;
        try {
             pst = connection.prepareStatement(req);
            pst.setInt(1, idAssociation);
            ResultSet resultSet =  pst.executeQuery();
            if (resultSet.next()) {
               A= new Association(resultSet.getInt("id"),resultSet.getString("Nom_association"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return A;
    }
    
}
