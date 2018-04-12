/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import models.Event;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEvent {
   
    public void insererEvent();
    public void DeleteEvent(int id);
    public void updateEvent(Event e, int id);
    public List<Event> SelectAllEvents ();
    public void decrEtChangementDetat(int nbr,int idev) ; 
}
