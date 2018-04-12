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
public class Evaluation {
    
    private int iduser ; 
    private  int idevnement ; 
    private float note ; 

    public Evaluation(int iduser, int idevnement, float note) {
        this.iduser = iduser;
        this.idevnement = idevnement;
        this.note = note;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdevnement() {
        return idevnement;
    }

    public void setIdevnement(int idevnement) {
        this.idevnement = idevnement;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "iduser=" + iduser + ", idevnement=" + idevnement + ", note=" + note + '}';
    }
    
    
    
}
