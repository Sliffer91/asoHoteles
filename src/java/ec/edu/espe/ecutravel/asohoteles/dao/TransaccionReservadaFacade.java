/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.dao;

import ec.edu.espe.ecutravel.asohoteles.entities.TransaccionReservada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sliffer
 */
@Stateless
public class TransaccionReservadaFacade extends AbstractFacade<TransaccionReservada> {

    @PersistenceContext(unitName = "AsoHotelesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionReservadaFacade() {
        super(TransaccionReservada.class);
    }
    
}
