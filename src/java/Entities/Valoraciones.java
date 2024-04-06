/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "valoraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoraciones.findAll", query = "SELECT v FROM Valoraciones v")
    , @NamedQuery(name = "Valoraciones.findByValoracion", query = "SELECT v FROM Valoraciones v WHERE v.valoracion = :valoracion")
    , @NamedQuery(name = "Valoraciones.findByClientesIdCliente", query = "SELECT v FROM Valoraciones v WHERE v.valoracionesPK.clientesIdCliente = :clientesIdCliente")
    , @NamedQuery(name = "Valoraciones.findByProductosIdProducto", query = "SELECT v FROM Valoraciones v WHERE v.valoracionesPK.productosIdProducto = :productosIdProducto")})
public class Valoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValoracionesPK valoracionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "valoracion")
    private String valoracion;
    @JoinColumn(name = "clientes_id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "productos_id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public Valoraciones() {
    }

    public Valoraciones(ValoracionesPK valoracionesPK) {
        this.valoracionesPK = valoracionesPK;
    }

    public Valoraciones(ValoracionesPK valoracionesPK, String valoracion) {
        this.valoracionesPK = valoracionesPK;
        this.valoracion = valoracion;
    }

    public Valoraciones(int clientesIdCliente, int productosIdProducto) {
        this.valoracionesPK = new ValoracionesPK(clientesIdCliente, productosIdProducto);
    }

    public ValoracionesPK getValoracionesPK() {
        return valoracionesPK;
    }

    public void setValoracionesPK(ValoracionesPK valoracionesPK) {
        this.valoracionesPK = valoracionesPK;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
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
        hash += (valoracionesPK != null ? valoracionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoraciones)) {
            return false;
        }
        Valoraciones other = (Valoraciones) object;
        if ((this.valoracionesPK == null && other.valoracionesPK != null) || (this.valoracionesPK != null && !this.valoracionesPK.equals(other.valoracionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Valoraciones[ valoracionesPK=" + valoracionesPK + " ]";
    }
    
}
