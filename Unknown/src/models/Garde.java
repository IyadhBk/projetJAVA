/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author s
 */
public class Garde {

    private int id;
    private String Nom;
    private int capacité;
    private String adresse;

    public Garde(int id, String Nom, int capacité, String adresse) {
        this.id = id;
        this.Nom = Nom;
        this.capacité = capacité;
        this.adresse = adresse;
    }

    public Garde() {
                super();

    }
    
    

    public Garde(String Nom, int capacité, String adresse) {
        this.Nom = Nom;
        this.capacité = capacité;
        this.adresse = adresse;
    }

    public Garde(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Garde{" + "id=" + id + ", Nom=" + Nom + ", capacit\u00e9=" + capacité + ", adresse=" + adresse + '}';
    }
    
    
}
