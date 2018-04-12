/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.List;
import models.Association;
import models.Garde;
import models.User;

/**
 *
 * @author s
 */
public class Animaux {

    public static boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int AnimauxId;
    private String Nom;
    private String type;
    private String coleur;
    private String age;
    private String sexe;
    private Date dateAdoption;
    private Garde garde ;
    private User user ;
    private String Brochure ;
    private Association association ;

    public Animaux( String Nom, String type, String coleur, String age, String sexe, Garde garde, Association association) {
        
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.association = association;
    }

    public Animaux(String Nom, String type, String coleur, String age, String sexe, String Brochure, Association association) {
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.Brochure = Brochure;
        this.association = association;
    }

    public Animaux(int AnimauxId, String Nom, String type, String coleur, String age, String sexe, Garde garde, String Brochure, Association association) {
        this.AnimauxId = AnimauxId;
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.Brochure = Brochure;
        this.association = association;
    }
    
    

    public Animaux(String Nom, String age, String sexe, Garde garde, Association association) {
        this.Nom = Nom;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.association = association;
    }

    public Animaux(String Nom, String type, String age, String sexe, Garde garde, Association association) {
        this.Nom = Nom;
        this.type = type;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.association = association;
    }

    public Animaux(String Nom, String age, String sexe, Garde garde, String Brochure, Association association) {
        this.Nom = Nom;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.Brochure = Brochure;
        this.association = association;
    }

    public Animaux(int AnimauxId, String Nom, String type, String coleur, String age, String sexe, Garde garde, Association association) {
        this.AnimauxId = AnimauxId;
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.association = association;
    }
    

    public Animaux(int AnimauxId, String Nom, String type, String coleur, String sexe, Garde garde, String Brochure, Association association) {
        this.AnimauxId = AnimauxId;
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.sexe = sexe;
        this.garde = garde;
        this.Brochure = Brochure;
        this.association = association;
    }

    public Animaux(int AnimauxId, String Nom, String age, String sexe, Garde garde, String Brochure, Association association) {
        this.AnimauxId = AnimauxId;
        this.Nom = Nom;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.Brochure = Brochure;
        this.association = association;
    }
    
    
    
    

    public Animaux(int AnimauxId, String Nom, String type, String coleur, String age, String sexe, Date dateAdoption, Garde garde, User user, String Brochure, Association association) {
        this.AnimauxId = AnimauxId;
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.dateAdoption = dateAdoption;
        this.garde = garde;
        this.user = user;
        this.Brochure = Brochure;
        this.association = association;
    }

    public Animaux(String Nom, String type, String coleur, String age, String sexe, Date dateAdoption, Garde garde, User user, String Brochure, Association association) {
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.dateAdoption = dateAdoption;
        this.garde = garde;
        this.user = user;
        this.Brochure = Brochure;
        this.association = association;
    }

    public Animaux(String Nom, String type, String coleur, String age, String sexe, Garde garde, String Brochure, Association association) {
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.Brochure = Brochure;
        this.association = association;
    }

    public Animaux(String Nom, String type, String coleur, String age, String sexe, Garde garde, User user, String Brochure, Association association) {
        this.Nom = Nom;
        this.type = type;
        this.coleur = coleur;
        this.age = age;
        this.sexe = sexe;
        this.garde = garde;
        this.user = user;
        this.Brochure = Brochure;
        this.association = association;
    }
    
    

   

    public Animaux() {
    }

    public Animaux(int AnimauxId) {
        this.AnimauxId = AnimauxId;
    }
    

    public int getAnimauxId() {
        return AnimauxId;
    }

    public void setAnimauxId(int AnimauxId) {
        this.AnimauxId = AnimauxId;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColeur() {
        return coleur;
    }

    public void setColeur(String coleur) {
        this.coleur = coleur;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateAdoption() {
        return dateAdoption;
    }

    public void setDateAdoption(Date dateAdoption) {
        this.dateAdoption = dateAdoption;
    }

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBrochure() {
        return Brochure;
    }

    public void setBrochure(String Brochure) {
        this.Brochure = Brochure;
    }

    @Override
    public String toString() {
        return "Animaux{" + "AnimauxId=" + AnimauxId + ", Nom=" + Nom + ", type=" + type + ", coleur=" + coleur + ", age=" + age + ", sexe=" + sexe + ", dateAdoption=" + dateAdoption + ", garde=" + garde + ", user=" + user + ", Brochure=" + Brochure + ", association=" + association + '}';
    }

   
    
   
    
 
    
}
