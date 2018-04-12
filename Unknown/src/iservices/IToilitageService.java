/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import java.util.List;
import models.Toilitages;

/**
 *
 * @author p
 */
public interface IToilitageService {
    public void ajouterToilitage(Toilitages toilitage);
    public void modifierToilitage(Toilitages toilitage);
    public void supprimerToilitage(Toilitages toilitage);
    public List<Toilitages> getToilitages();
    public  List<Toilitages> getToilitage1();
    public  List<Toilitages> getToilitage();
    public void reserverToilitage(int toilId);
    public void dereserverToilitage(int toilId) ;
    
    public Toilitages  findby (int id);
}
