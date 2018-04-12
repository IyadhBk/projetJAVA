/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import java.sql.Date;
import java.util.List;
import models.Toilitages;

/**
 *
 * @author p
 */
public interface IReservationService {
    
    
    void reserver(int idToil, int idUser, Date resDate);
    List<Toilitages> afficherReservations();
}
