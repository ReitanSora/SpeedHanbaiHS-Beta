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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "detalle_devolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDevolucion.findAll", query = "SELECT d FROM DetalleDevolucion d")
    , @NamedQuery(name = "DetalleDevolucion.findByIdDetalleDevolucion", query = "SELECT d FROM DetalleDevolucion d WHERE d.idDetalleDevolucion = :idDetalleDevolucion")
    , @NamedQuery(name = "DetalleDevolucion.findByCantidad", query = "SELECT d FROM DetalleDevolucion d WHERE d.cantidad = :cantidad")})
public class DetalleDevolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_devolucion")
    private Integer idDetalleDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "devoluciones_id_devolucion", referencedColumnName = "id_devolucion")
    @ManyToOne(optional = false)
    private Devoluciones devolucionesIdDevolucion;
    @JoinColumn(name = "productos_id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Productos productosIdProducto;

    public DetalleDevolucion() {
    }

    public DetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public DetalleDevolucion(Integer idDetalleDevolucion, int cantidad) {
        this.idDetalleDevolucion = idDetalleDevolucion;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Devoluciones getDevolucionesIdDevolucion() {
        return devolucionesIdDevolucion;
    }

    public void setDevolucionesIdDevolucion(Devoluciones devolucionesIdDevolucion) {
        this.devolucionesIdDevolucion = devolucionesIdDevolucion;
    }

    public Productos getProductosIdProducto() {
        return productosIdProducto;
    }

    public void setProductosIdProducto(Productos productosIdProducto) {
        this.productosIdProducto = productosIdProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDevolucion != null ? idDetalleDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDevolucion)) {
            return false;
        }
        DetalleDevolucion other = (DetalleDevolucion) object;
        if ((this.idDetalleDevolucion == null && other.idDetalleDevolucion != null) || (this.idDetalleDevolucion != null && !this.idDetalleDevolucion.equals(other.idDetalleDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DetalleDevolucion[ idDetalleDevolucion=" + idDetalleDevolucion + " ]";
    }
    
}
