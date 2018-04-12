/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;


import java.util.List;
import models.Association;



/**
 *
 * @author p
 */
public interface IAssociationService {
    
     public void ajouterAssociation(Association a);
    public void modifierAssociation(Association a);
    public void supprimerAssociation(int id);
    public List<Association> getAssociation();
    public  List<Association> getAssociations1();
    
    public Association findby(int id);
    
    
    public void AjouterAssociationParId(Association a);
}
