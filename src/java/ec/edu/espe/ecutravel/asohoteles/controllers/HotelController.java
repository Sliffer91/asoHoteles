/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.controllers;

import ec.edu.espe.ecutravel.asohoteles.dao.HotelFacade;
import ec.edu.espe.ecutravel.asohoteles.entities.Hotel;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sliffer
 */
@Stateless
public class HotelController {
    
    @EJB
    private HotelFacade facade;
    
    public List<Hotel> getHoteles(){
    return facade.findAll();
    }
    
    public List<Hotel> retrieveHotelByCiudad(String ciudad){
        return facade.retrieveHotelByCiudad(ciudad);
    }

    public List<Hotel> retrieveHotelById(Integer id) {
        return facade.retrieveHotelById(id);
    }
    
    
    
}
