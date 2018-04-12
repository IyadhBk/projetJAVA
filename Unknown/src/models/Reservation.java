/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import models.User;

/**
 *
 * @author p
 */
public class Reservation {
    
    private User user_Reserve;
    private Toilitage toilitage_reseve;
    private Date date_reservation;

    public User getUser_Reserve() {
        return user_Reserve;
    }

    public void setUser_Reserve(User user_Reserve) {
        this.user_Reserve = user_Reserve;
    }

    public Toilitage getToilitage_reseve() {
        return toilitage_reseve;
    }

    public void setToilitage_reseve(Toilitage toilitage_reseve) {
        this.toilitage_reseve = toilitage_reseve;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    @Override
    public String toString() {
        return "Reservation{" + "user_Reserve=" + user_Reserve + ", toilitage_reseve=" + toilitage_reseve + ", date_reservation=" + date_reservation + '}';
    }

    public Reservation() {
    }

    public Reservation(User user_Reserve, Toilitage toilitage_reseve, Date date_reservation) {
        this.user_Reserve = user_Reserve;
        this.toilitage_reseve = toilitage_reseve;
        this.date_reservation = date_reservation;
    }

    private static class Toilitage {

        public Toilitage() {
        }
    }
}
