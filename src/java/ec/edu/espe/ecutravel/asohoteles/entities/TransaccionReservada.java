/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sliffer
 */
@Entity
@Table(name = "transaccion_reservada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionReservada.findAll", query = "SELECT t FROM TransaccionReservada t"),
    @NamedQuery(name = "TransaccionReservada.findByTraCodigo", query = "SELECT t FROM TransaccionReservada t WHERE t.traCodigo = :traCodigo"),
    @NamedQuery(name = "TransaccionReservada.findByFechaInicio", query = "SELECT t FROM TransaccionReservada t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TransaccionReservada.findByFechaFin", query = "SELECT t FROM TransaccionReservada t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TransaccionReservada.findByHabitacion", query = "SELECT t FROM TransaccionReservada t WHERE t.habitacion = :habitacion"),
    @NamedQuery(name = "TransaccionReservada.findByPersona", query = "SELECT t FROM TransaccionReservada t WHERE t.persona = :persona"),
    @NamedQuery(name = "TransaccionReservada.findByPaquete", query = "SELECT t FROM TransaccionReservada t WHERE t.paquete = :paquete")})
public class TransaccionReservada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "tranIncre", sequenceName = "TRANSACCIONSQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tranIncre")
    @Basic(optional = false)
    @NotNull
    @Column(name = "tra_codigo")
    private BigDecimal traCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habitacion")
    private BigInteger habitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona")
    private BigInteger persona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paquete")
    private BigInteger paquete;
    @JoinColumn(name = "hot_codigo", referencedColumnName = "hot_codigo")
    @ManyToOne
    private Hotel hotCodigo;

    public TransaccionReservada() {
    }

    public TransaccionReservada(BigDecimal traCodigo) {
        this.traCodigo = traCodigo;
    }

    public TransaccionReservada(BigDecimal traCodigo, Date fechaInicio, Date fechaFin, BigInteger habitacion, BigInteger persona, BigInteger paquete) {
        this.traCodigo = traCodigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
        this.persona = persona;
        this.paquete = paquete;
    }

    public BigDecimal getTraCodigo() {
        return traCodigo;
    }

    public void setTraCodigo(BigDecimal traCodigo) {
        this.traCodigo = traCodigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigInteger getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(BigInteger habitacion) {
        this.habitacion = habitacion;
    }

    public BigInteger getPersona() {
        return persona;
    }

    public void setPersona(BigInteger persona) {
        this.persona = persona;
    }

    public BigInteger getPaquete() {
        return paquete;
    }

    public void setPaquete(BigInteger paquete) {
        this.paquete = paquete;
    }

    public Hotel getHotCodigo() {
        return hotCodigo;
    }

    public void setHotCodigo(Hotel hotCodigo) {
        this.hotCodigo = hotCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traCodigo != null ? traCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionReservada)) {
            return false;
        }
        TransaccionReservada other = (TransaccionReservada) object;
        if ((this.traCodigo == null && other.traCodigo != null) || (this.traCodigo != null && !this.traCodigo.equals(other.traCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.asohoteles.entities.TransaccionReservada[ traCodigo=" + traCodigo + " ]";
    }
    
}
