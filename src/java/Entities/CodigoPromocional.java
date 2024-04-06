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
@Table(name = "codigo_promocional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoPromocional.findAll", query = "SELECT c FROM CodigoPromocional c")
    , @NamedQuery(name = "CodigoPromocional.findByIdCodigoPromocional", query = "SELECT c FROM CodigoPromocional c WHERE c.idCodigoPromocional = :idCodigoPromocional")
    , @NamedQuery(name = "CodigoPromocional.findByCodigo", query = "SELECT c FROM CodigoPromocional c WHERE c.codigo = :codigo")})
public class CodigoPromocional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_codigo_promocional")
    private Integer idCodigoPromocional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "descuento_id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento descuentoIdDescuento;

    public CodigoPromocional() {
    }

    public CodigoPromocional(Integer idCodigoPromocional) {
        this.idCodigoPromocional = idCodigoPromocional;
    }

    public CodigoPromocional(Integer idCodigoPromocional, String codigo) {
        this.idCodigoPromocional = idCodigoPromocional;
        this.codigo = codigo;
    }

    public Integer getIdCodigoPromocional() {
        return idCodigoPromocional;
    }

    public void setIdCodigoPromocional(Integer idCodigoPromocional) {
        this.idCodigoPromocional = idCodigoPromocional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Descuento getDescuentoIdDescuento() {
        return descuentoIdDescuento;
    }

    public void setDescuentoIdDescuento(Descuento descuentoIdDescuento) {
        this.descuentoIdDescuento = descuentoIdDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodigoPromocional != null ? idCodigoPromocional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoPromocional)) {
            return false;
        }
        CodigoPromocional other = (CodigoPromocional) object;
        if ((this.idCodigoPromocional == null && other.idCodigoPromocional != null) || (this.idCodigoPromocional != null && !this.idCodigoPromocional.equals(other.idCodigoPromocional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CodigoPromocional[ idCodigoPromocional=" + idCodigoPromocional + " ]";
    }
    
}
