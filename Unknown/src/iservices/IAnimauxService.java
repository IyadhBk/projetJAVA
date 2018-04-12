/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import java.util.List;
import models.Animaux;

/**
 *
 * @author s
 */
public interface IAnimauxService {

    
     public void ajoutAnimaux(Animaux Animaux);
      public void modifierAnimaux(Animaux Animaux);
      public void modifierAnimaux1(Animaux Animaux);
     public void supprimerAnimaux(int id);
     public List <Animaux> getAnimaux1();
     public List <Animaux> getAnimaux();
     public List <Animaux> getAnimauxUser();
     public List <Animaux> getAnimaux2();
     public Animaux findById(int Id);
     public void ajoutAnimaux1(Animaux Animaux);
     
    
}
