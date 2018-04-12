/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author p
 */
public class Toilitages {
    
     private int toilitage_id;
    private String nom;
    private String description;
    private int num_tel_toilitage;
    private String adresse;
    private Double lat;
    private Double longi;
    private Date dateReservation;

    public Date getDateReservation() {
        return dateReservation;
    }
    
    
    
    

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }
    
    private String image;
    
    private int reserve ;

    public int getReserve() {
        return reserve;
    }

    public Toilitages(int toilitage_id, String nom, String description, String image) {
        this.toilitage_id = toilitage_id;
        this.nom = nom;
        this.description = description;
        this.image = image;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public Toilitages(String nom, String description, String image) {
        this.nom = nom;
        this.description = description;
        this.image = image;
    }
    
    
    
    

    public String getImage() {
        return image;
    }

    public Toilitages(String nom, String description, int num_tel_toilitage, String adresse, String image) {
        this.nom = nom;
        this.description = description;
        this.num_tel_toilitage = num_tel_toilitage;
        this.adresse = adresse;
        
        this.image = image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Toilitages(String nom, String description, int num_tel_toilitage, String adresse, Double lat, Double longi, int capacite, String image) {
        this.nom = nom;
        this.description = description;
        this.num_tel_toilitage = num_tel_toilitage;
        this.adresse = adresse;
        this.lat = lat;
        this.longi = longi;
        
        this.image = image;
        this.reserve = 0;
    }
    
    
    

    

    public int getToilitage_id() {
        return toilitage_id;
    }

    public void setToilitage_id(int toilitage_id) {
        this.toilitage_id = toilitage_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNum_tel_toilitage() {
        return num_tel_toilitage;
    }

    public void setNum_tel_toilitage(int num_tel_toilitage) {
        this.num_tel_toilitage = num_tel_toilitage;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    @Override
    public String toString() {
        return "Toilitages{" + "toilitage_id=" + toilitage_id + ", nom=" + nom + ", description=" + description + ", num_tel_toilitage=" + num_tel_toilitage + ", adresse=" + adresse + ", lat=" + lat + ", longi=" + longi + ", image=" + image + ", reserve=" + reserve + '}';
    }

    
    
  

    public Toilitages() {
    }

    public Toilitages(int toilitage_id, String nom, String description, int num_tel_toilitage, String adresse, String image) {
        this.toilitage_id = toilitage_id;
        this.nom = nom;
        this.description = description;
        this.num_tel_toilitage = num_tel_toilitage;
        this.adresse = adresse;
        this.image = image;
    }

    public Toilitages(String nom, String description, int num_tel_toilitage, String adresse, Double lat, Double longi, String image) {
        this.nom = nom;
        this.description = description;
        this.num_tel_toilitage = num_tel_toilitage;
        this.adresse = adresse;
        this.lat = lat;
        this.longi = longi;
        this.image = image;
    }
    
    

    public Toilitages(String nom, String description, int num_tel_toilitage, String adresse, Double lat, Double longi) {
        this.nom = nom;
        this.description = description;
        this.num_tel_toilitage = num_tel_toilitage;
        this.adresse = adresse;
        this.lat = lat;
        this.longi = longi;
        
    }

  

    public Toilitages(int toilitage_id, String nom, String description, int num_tel_toilitage, String adresse, Double lat, Double longi) {
        this.toilitage_id = toilitage_id;
        this.nom = nom;
        this.description = description;
        this.num_tel_toilitage = num_tel_toilitage;
        this.adresse = adresse;
        this.lat = lat;
        this.longi = longi;
        
    }
    
}