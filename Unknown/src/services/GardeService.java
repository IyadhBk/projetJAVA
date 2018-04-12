/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import iservices.IGardeService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Garde;
import technique.DataSource;
/**
 *
 * @author s
 */
public class GardeService implements IGardeService{
    
    private Connection connection;
    private PreparedStatement pst;
 public GardeService(){
      connection = DataSource.getInstance().getConnection();
    
}

    @Override
    public void ajoutGarde(Garde Garde) {
        String req="INSERT INTO Garde(Nom,Capacite,adresse) VALUES(?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1,Garde.getNom());
            pst.setInt(2,Garde.getCapacité());
            pst.setString(3,Garde.getAdresse());
           
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Garde> getGarde() {
         String req = "select * from garde";
        List<Garde> Gardes = new ArrayList<>();
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
            
                Garde garde = new Garde(resultSet.getInt("id"),resultSet.getString("Nom"), resultSet.getInt("Capacite"),resultSet.getString("adresse"));
                Gardes.add(garde);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Gardes;
    }
    @Override
    public Garde findById(int idGarde) {
        String req = "select * from Garde where id = ?";
        Garde G = null;
        try {
             pst = connection.prepareStatement(req);
            pst.setInt(1, idGarde);
            ResultSet resultSet =  pst.executeQuery();
            if (resultSet.next()) {
               G = new Garde(resultSet.getInt("id"),resultSet.getString("Nom"), resultSet.getInt("Capacite"),resultSet.getString("adresse")) ; // new User(resultSet.getInt(3))
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return G;
    }
    

    
    
}
