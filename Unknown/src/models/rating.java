/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author didid
 */
public class rating {
    int idRating;
    Double note ;
    int idArticle;

    public rating(int idRating, Double note, int idArticle) {
        this.idRating = idRating;
        this.note = note;
        this.idArticle = idArticle;
    }

    public rating(Double note, int idArticle) {
        this.note = note;
        this.idArticle = idArticle;
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

   

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public String toString() {
        return "rating{" + "note=" + note + ", idArticle=" + idArticle + '}';
    }
    
    
    
    
}
