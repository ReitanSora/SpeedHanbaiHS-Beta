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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "ofertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o")
    , @NamedQuery(name = "Ofertas.findByCategoriasIdCategoria", query = "SELECT o FROM Ofertas o WHERE o.categoriasIdCategoria = :categoriasIdCategoria")
    , @NamedQuery(name = "Ofertas.findByDescripcion", query = "SELECT o FROM Ofertas o WHERE o.descripcion = :descripcion")})
public class Ofertas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "categorias_id_categoria")
    private Integer categoriasIdCategoria;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "categorias_id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Categorias categorias;
    @JoinColumn(name = "descuento_id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento descuentoIdDescuento;

    public Ofertas() {
    }

    public Ofertas(Integer categoriasIdCategoria) {
        this.categoriasIdCategoria = categoriasIdCategoria;
    }

    public Integer getCategoriasIdCategoria() {
        return categoriasIdCategoria;
    }

    public void setCategoriasIdCategoria(Integer categoriasIdCategoria) {
        this.categoriasIdCategoria = categoriasIdCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
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
        hash += (categoriasIdCategoria != null ? categoriasIdCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertas)) {
            return false;
        }
        Ofertas other = (Ofertas) object;
        if ((this.categoriasIdCategoria == null && other.categoriasIdCategoria != null) || (this.categoriasIdCategoria != null && !this.categoriasIdCategoria.equals(other.categoriasIdCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Ofertas[ categoriasIdCategoria=" + categoriasIdCategoria + " ]";
    }
    
}
