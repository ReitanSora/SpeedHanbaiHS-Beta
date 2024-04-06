/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c")
    , @NamedQuery(name = "Calificaciones.findByCalificacion", query = "SELECT c FROM Calificaciones c WHERE c.calificacion = :calificacion")
    , @NamedQuery(name = "Calificaciones.findByClientesIdCliente", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.clientesIdCliente = :clientesIdCliente")
    , @NamedQuery(name = "Calificaciones.findByProductosIdProducto", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.productosIdProducto = :productosIdProducto")})
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionesPK calificacionesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private BigDecimal calificacion;
    @JoinColumn(name = "clientes_id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "productos_id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public Calificaciones() {
    }

    public Calificaciones(CalificacionesPK calificacionesPK) {
        this.calificacionesPK = calificacionesPK;
    }

    public Calificaciones(CalificacionesPK calificacionesPK, BigDecimal calificacion) {
        this.calificacionesPK = calificacionesPK;
        this.calificacion = calificacion;
    }

    public Calificaciones(int clientesIdCliente, int productosIdProducto) {
        this.calificacionesPK = new CalificacionesPK(clientesIdCliente, productosIdProducto);
    }

    public CalificacionesPK getCalificacionesPK() {
        return calificacionesPK;
    }

    public void setCalificacionesPK(CalificacionesPK calificacionesPK) {
        this.calificacionesPK = calificacionesPK;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionesPK != null ? calificacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.calificacionesPK == null && other.calificacionesPK != null) || (this.calificacionesPK != null && !this.calificacionesPK.equals(other.calificacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Calificaciones[ calificacionesPK=" + calificacionesPK + " ]";
    }
    
}
