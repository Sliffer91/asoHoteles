/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asohoteles.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sliffer
 */
@Entity
@Table(name = "hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findByHotCodigo", query = "SELECT h FROM Hotel h WHERE h.hotCodigo = :hotCodigo"),
    @NamedQuery(name = "Hotel.findByNombre", query = "SELECT h FROM Hotel h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hotel.findByDireccion", query = "SELECT h FROM Hotel h WHERE h.direccion = :direccion"),
    @NamedQuery(name = "Hotel.findByEncargado", query = "SELECT h FROM Hotel h WHERE h.encargado = :encargado"),
    @NamedQuery(name = "Hotel.findByTelefono", query = "SELECT h FROM Hotel h WHERE h.telefono = :telefono"),
    @NamedQuery(name = "Hotel.findByDescripcion", query = "SELECT h FROM Hotel h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Hotel.findByCiudad", query = "SELECT h FROM Hotel h WHERE h.ciudad = :ciudad")})
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hot_codigo")
    private BigDecimal hotCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "encargado")
    private String encargado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private BigInteger telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(mappedBy = "hotCodigo")
    private List<TransaccionReservada> transaccionReservadaList;

    public Hotel() {
    }

    public Hotel(BigDecimal hotCodigo) {
        this.hotCodigo = hotCodigo;
    }

    public Hotel(BigDecimal hotCodigo, String nombre, String direccion, String encargado, BigInteger telefono, String descripcion) {
        this.hotCodigo = hotCodigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.encargado = encargado;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public BigDecimal getHotCodigo() {
        return hotCodigo;
    }

    public void setHotCodigo(BigDecimal hotCodigo) {
        this.hotCodigo = hotCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<TransaccionReservada> getTransaccionReservadaList() {
        return transaccionReservadaList;
    }

    public void setTransaccionReservadaList(List<TransaccionReservada> transaccionReservadaList) {
        this.transaccionReservadaList = transaccionReservadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotCodigo != null ? hotCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotCodigo == null && other.hotCodigo != null) || (this.hotCodigo != null && !this.hotCodigo.equals(other.hotCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.asohoteles.entities.Hotel[ hotCodigo=" + hotCodigo + " ]";
    }
    
}
