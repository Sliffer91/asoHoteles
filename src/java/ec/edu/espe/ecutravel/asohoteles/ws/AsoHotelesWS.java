/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.ws;

import ec.edu.espe.ecutravel.asohoteles.controllers.HotelController;
import ec.edu.espe.ecutravel.asohoteles.controllers.TransaccionReservadaController;
import ec.edu.espe.ecutravel.asohoteles.entities.Hotel;
import ec.edu.espe.ecutravel.asohoteles.entities.TransaccionReservada;
import hotel1consumer.Habitacion;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sliffer
 */
@WebService(serviceName = "AsoHotelesWS")
public class AsoHotelesWS {
    
     @EJB
     HotelController controller;
     

    @WebMethod(operationName = "retrieveHotelByCiudad")
    public List<Hotel> retrieveHotelByCiudad(@WebParam(name = "ciudad") String ciudad) {
        System.out.println("retrieveHotelByCiudad "+ciudad);
        return controller.retrieveHotelByCiudad(ciudad);
    }
    
    @WebMethod(operationName = "retrieveHotelById")
    public List<Hotel> retrieveHotelById(@WebParam(name = "id") Integer id) {
        System.out.println(id);
        return controller.retrieveHotelById(id);
    }
    
    @WebMethod(operationName = "retrieveHabitaciones")
    public List<Habitacion> retrieveHabitaciones(
            @WebParam(name = "idHotel") Integer idHotel, 
            @WebParam(name = "fechaInicio") String fechaInicio, 
            @WebParam(name = "fechaFinal") String fechaFinal) {
        
        List<Habitacion> temp = null;
        switch (idHotel){
            case 1:
               temp = hotel1consumer.Hotel1WSConsumer.buscarHabitacionesEnFechas(fechaInicio, fechaFinal);                       
                break;
            case 2:
                temp = hotel2consumer.Hotel2WSConsumer.buscarHabitacionesEnFechas(fechaInicio, fechaFinal);
                break;
            case 3:
                temp = hotel3consumer.Hotel3WSConsumer.buscarHabitacionesEnFechas(fechaInicio, fechaFinal);
                break;
            default: temp = null;
                break;
        }
        return temp;
    }
    
    @EJB
    private TransaccionReservadaController ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getTransaccionReservada")
    public List<TransaccionReservada> getTransaccionReservada() {
        return ejbRef.getTransaccionReservada();
    }
}
