/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.dao;

import ec.edu.espe.ecutravel.asohoteles.entities.Hotel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sliffer
 */
@Stateless
public class HotelFacade extends AbstractFacade<Hotel> {

    @PersistenceContext(unitName = "AsoHotelesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelFacade() {
        super(Hotel.class);
    }
    
    public List<Hotel> retrieveHotelByCiudad(String ciudad){
        return (List<Hotel>)em.createNamedQuery("Hotel.findByCiudad").setParameter("ciudad", ciudad).getResultList();
    }
    
    public List<Hotel> retrieveHotelById(Integer id) {
        return (List<Hotel>)em.createNamedQuery("Hotel.findByHotCodigo").setParameter("hotCodigo", id).getResultList();
    }
}
