/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Blob;
import java.util.logging.Logger;

/**
 *
 * @author jihen
 */
public class reclamation {
    
    private  int id;
    private int user_id;
    private  String description ;
    private String animalConcerné ;
    private int action;
    private  String image ;
    
    private String path ;
 

    public reclamation(int id, int user_id, String description, String animalConcerné,int action) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.animalConcerné = animalConcerné;
        this.action = action;
    }

    public reclamation(int user_id,  String description,String animalConcerné, int action,String image) {
        this.user_id = user_id;
        this.description = description;
        this.animalConcerné=animalConcerné;
        this.action = action;
        this.image= image ;
    }

    public reclamation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public reclamation(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public reclamation(int id, int user_id, String description, String animalConcerné, int action, String image, String path) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.animalConcerné = animalConcerné;
        this.action = action;
        this.image = image;
        this.path = path;
    }
    private static final Logger LOG = Logger.getLogger(reclamation.class.getName());

   
    
    

  
   

    @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", user_id=" + user_id + ", description=" + description + ", animalConcern\u00e9=" + animalConcerné + ", action=" + action + '}';
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

   

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

   

    public String getDescription() {
        return description;
    }

    public int getAction() {
        return action;
    }

    public String getAnimalConcerné() {
        return animalConcerné;
    }

    public void setAnimalConcerné(String animalConcerné) {
        this.animalConcerné = animalConcerné;
    }

    public reclamation(int id, int user_id, String description, int action) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.action = action;
    }

    public reclamation(int user_id, String description, int action) {
        this.user_id = user_id;
        this.description = description;
        this.action = action;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public reclamation(int user_id, String description, String animalConcerné, String image) {
        this.user_id = user_id;
        this.description = description;
        this.animalConcerné = animalConcerné;
        this.image = image;
    }

   
    
    
    
    
    
    
    
    
    
}
