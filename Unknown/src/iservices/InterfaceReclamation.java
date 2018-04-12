/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import models.reclamation;

/**
 *
 * @author Ourabi
 */
public interface InterfaceReclamation {
    
    void add(reclamation e);
    void delete(int id);
    void edit(reclamation e);
}
