/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP
 */
public class Event {
     private int id;
   private String nom;
  private String description;
  private String dateDebut;
  private String image;
  private String lieu;
  private int categorie_id;
  private int nbParticipe;
  private int nombrePlaces ; 

    public Event(String nom, String description, String dateDebut, String image, String lieu, int categorie_id, int nbParticipe, int nombrePlaces) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.image = image;
        this.lieu = lieu;
        this.categorie_id = categorie_id;
        this.nbParticipe = nbParticipe;
        this.nombrePlaces = nombrePlaces;
    }
  
  

    public Event(int id, String nom, String description, String dateDebut, String image, String lieu, int categorie_id, int nbParticipe, int nombrePlaces) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.image = image;
        this.lieu = lieu;
        this.categorie_id = categorie_id;
        this.nbParticipe = nbParticipe;
        this.nombrePlaces = nombrePlaces;
    }

    public Event(String nom, String description, String dateDebut, String image, String lieu, int categorie_id) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.image = image;
        this.lieu = lieu;
        this.categorie_id = categorie_id;
    }

    public Event(int id, String nom, String description, String dateDebut, String image, String lieu, int categorie_id, int nbParticipe) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.image = image;
        this.lieu = lieu;
        this.categorie_id = categorie_id;
        this.nbParticipe = nbParticipe;
    }

    public Event(String nom, String description, String dateDebut, String image, String lieu, int categorie_id, int nbParticipe) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.image = image;
        this.lieu = lieu;
        this.categorie_id = categorie_id;
        this.nbParticipe = nbParticipe;
    }

    public Event(String nom, String description, String image, String lieu, int categorie_id, int nbParticipe) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.lieu = lieu;
        this.categorie_id = categorie_id;
        this.nbParticipe = nbParticipe;
    }

    public Event(String nom, String description,String date ,String image, String lieu) {
        this.nom = nom;
        this.description = description;
        this.dateDebut=date;
        this.image = image;
        this.lieu = lieu;
        
       
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getNbParticipe() {
        return nbParticipe;
    }

    public void setNbParticipe(int nbParticipe) {
        this.nbParticipe = nbParticipe;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
    

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", dateDebut=" + dateDebut + ", image=" + image + ", lieu=" + lieu + ", categorie_id=" + categorie_id + ", nbParticipe=" + nbParticipe + '}';
    }

  
  
  
  
  
  
}
