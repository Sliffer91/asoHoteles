/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.controllers;

import ec.edu.espe.ecutravel.asohoteles.dao.TransaccionReservadaFacade;
import ec.edu.espe.ecutravel.asohoteles.entities.TransaccionReservada;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sliffer
 */
@Stateless
public class TransaccionReservadaController {
    @EJB
    private TransaccionReservadaFacade facade;
    
    public List<TransaccionReservada> getTransaccionReservada(){
        return facade.findAll();
    }
    
//    public void registrarTran(TransaccionReservada tran) {
//        try {
//            facade.create(tran);
//        } catch (Exception ex) {
//            System.out.println("Error Insertar transaccion:" + ex);
//        }
//
//    }
}
