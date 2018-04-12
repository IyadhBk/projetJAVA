/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.logging.Logger;
import models.User;

/**
 *
 * @author p
 */
public class Association {
    
    private int id;
    private String nom_association;
    private double latitude;
    private double longititude;
    private String adresse;
    private String email;
    private int num_tel;
    private String image; 
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    public Association(String nom_association, String adresse, String email, int num_tel, String image, User user) {
        this.nom_association = nom_association;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
        this.user = user;
    }
    
    
    
    

    public Association(String nom_association, String adresse, String email, int num_tel, String image) {
        this.nom_association = nom_association;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
    }

    public Association(int id, String nom_association, String adresse, String email, int num_tel, String image) {
        this.id = id;
        this.nom_association = nom_association;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
    }
    private static final Logger LOG = Logger.getLogger(Association.class.getName());

    public Association(String nom_association, String adresse, String email, String image) {
        this.nom_association = nom_association;
        this.adresse = adresse;
        this.email = email;
        this.image = image;
    }




    
    
    
    
    
    

    public Association(int id, String nom_association, double latitude, double longititude, String adresse, String email, int num_tel, String image) {
        this.id = id;
        this.nom_association = nom_association;
        this.latitude = latitude;
        this.longititude = longititude;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
    }

   

    public String getImage() {
        return image;
    }

    

    
    
    public Association( String nom_association, double latitude, double longititude, String adresse, String email, int num_tel, String image) {
        
        this.nom_association = nom_association;
        this.latitude = latitude;
        this.longititude = longititude;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
    }
    

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public String getNom_association() {
        return nom_association;
    }

    public void setNom_association(String nom_association) {
        this.nom_association = nom_association;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongititude() {
        return longititude;
    }

    public void setLongititude(double longititude) {
        this.longititude = longititude;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

  
    
    
    

    public Association() {
    }

    public Association(int id, String nom_association, double latitude, double longititude, String adresse, String email, int num_tel) {
        this.id = id;
        this.nom_association = nom_association;
        this.latitude = latitude;
        this.longititude = longititude;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
    }

    public Association(String nom_association, double latitude, double longititude, String adresse, String email, int num_tel) {
        this.nom_association = nom_association;
        this.latitude = latitude;
        this.longititude = longititude;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
     
    }

    public Association(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Association{" + "id=" + id + ", nom_association=" + nom_association + ", latitude=" + latitude + ", longititude=" + longititude + ", adresse=" + adresse + ", email=" + email + ", num_tel=" + num_tel + ", image=" + image + '}';
    }
    

    

    public int getAssociationId() {
        return id;
    }

    public Association(int id, String nom_association) {
        this.id = id;
        this.nom_association = nom_association;
    }
    
    
    
}
