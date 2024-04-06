/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stive
 */
@Embeddable
public class ValoracionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "clientes_id_cliente")
    private int clientesIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productos_id_producto")
    private int productosIdProducto;

    public ValoracionesPK() {
    }

    public ValoracionesPK(int clientesIdCliente, int productosIdProducto) {
        this.clientesIdCliente = clientesIdCliente;
        this.productosIdProducto = productosIdProducto;
    }

    public int getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(int clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public int getProductosIdProducto() {
        return productosIdProducto;
    }

    public void setProductosIdProducto(int productosIdProducto) {
        this.productosIdProducto = productosIdProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clientesIdCliente;
        hash += (int) productosIdProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionesPK)) {
            return false;
        }
        ValoracionesPK other = (ValoracionesPK) object;
        if (this.clientesIdCliente != other.clientesIdCliente) {
            return false;
        }
        if (this.productosIdProducto != other.productosIdProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ValoracionesPK[ clientesIdCliente=" + clientesIdCliente + ", productosIdProducto=" + productosIdProducto + " ]";
    }
    
}
