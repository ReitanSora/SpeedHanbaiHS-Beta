/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "tarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetas.findAll", query = "SELECT t FROM Tarjetas t")
    , @NamedQuery(name = "Tarjetas.findByIdTarjeta", query = "SELECT t FROM Tarjetas t WHERE t.idTarjeta = :idTarjeta")
    , @NamedQuery(name = "Tarjetas.findByNumero", query = "SELECT t FROM Tarjetas t WHERE t.numero = :numero")
    , @NamedQuery(name = "Tarjetas.findByCodigoSeguridad", query = "SELECT t FROM Tarjetas t WHERE t.codigoSeguridad = :codigoSeguridad")
    , @NamedQuery(name = "Tarjetas.findByNombreTitular", query = "SELECT t FROM Tarjetas t WHERE t.nombreTitular = :nombreTitular")
    , @NamedQuery(name = "Tarjetas.findByMesVence", query = "SELECT t FROM Tarjetas t WHERE t.mesVence = :mesVence")
    , @NamedQuery(name = "Tarjetas.findByAnioVence", query = "SELECT t FROM Tarjetas t WHERE t.anioVence = :anioVence")})
public class Tarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigo_seguridad")
    private String codigoSeguridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_titular")
    private String nombreTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "mes_vence")
    private String mesVence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "anio_vence")
    private String anioVence;
    @JoinColumn(name = "clientes_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes clientesIdCliente;

    public Tarjetas() {
    }

    public Tarjetas(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Tarjetas(Integer idTarjeta, String numero, String codigoSeguridad, String nombreTitular, String mesVence, String anioVence) {
        this.idTarjeta = idTarjeta;
        this.numero = numero;
        this.codigoSeguridad = codigoSeguridad;
        this.nombreTitular = nombreTitular;
        this.mesVence = mesVence;
        this.anioVence = anioVence;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getMesVence() {
        return mesVence;
    }

    public void setMesVence(String mesVence) {
        this.mesVence = mesVence;
    }

    public String getAnioVence() {
        return anioVence;
    }

    public void setAnioVence(String anioVence) {
        this.anioVence = anioVence;
    }

    public Clientes getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Clientes clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjetas)) {
            return false;
        }
        Tarjetas other = (Tarjetas) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tarjetas[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
