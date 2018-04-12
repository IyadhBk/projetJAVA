/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.User;

/**
 *
 * @author didid
 */
public class rdv {
    private int idRdv;
    private int idUser;
    private int idVet;
    private String  date;
    private User vet;

    public rdv(int idUser, int idVet, String date) {
        this.idUser = idUser;
        this.idVet = idVet;
        this.date = date;
    }

    public User getVet() {
        return vet;
    }

    public void setVet(User vet) {
        this.vet = vet;
    }

    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdVet() {
        return idVet;
    }

    public void setIdVet(int idVet) {
        this.idVet = idVet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "rdv{" + "idRdv=" + idRdv + ", idUser=" + idUser + ", idVet=" + idVet + ", date=" + date + '}';
    }
    
    
    



    
}
