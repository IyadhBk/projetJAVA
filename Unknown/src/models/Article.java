/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.User;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author didid
 */
public class Article {
     private int id;
     private String titre;
     private String  contenu;
     private String date;
     private String  image;
     private User vet;
     private int note;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public User getVet() {
        return vet;
    }

    public void setVet(User vet) {
        this.vet = vet;
    }

    public Article(int id, String titre, String contenu, String date,String image) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.image=image;
    }

    public Article(String titre, String contenu, String date, String image ) {
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.image=image;
    }

    public Article(int id, String titre, String contenu, String date, String image, User vet) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.image = image;
        this.vet = vet;
    }

    

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + ", image=" + image + '}';
    }



   
   


   

   
    
    

    
     
     
     
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

     
     

     
     

     
    
}
