/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import java.util.List;
import models.Garde;

/**
 *
 * @author s
 */
public interface IGardeService {
    public void ajoutGarde(Garde Garde);
     public List <Garde> getGarde();
public Garde findById(int idgarde);
    /**
     *
     * @return
     */
  
}
