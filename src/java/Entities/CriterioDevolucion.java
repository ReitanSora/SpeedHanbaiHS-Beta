/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author stive
 */
@Entity
@Table(name = "criterio_devolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioDevolucion.findAll", query = "SELECT c FROM CriterioDevolucion c")
    , @NamedQuery(name = "CriterioDevolucion.findByIdCriterioDevolucion", query = "SELECT c FROM CriterioDevolucion c WHERE c.idCriterioDevolucion = :idCriterioDevolucion")
    , @NamedQuery(name = "CriterioDevolucion.findByNombre", query = "SELECT c FROM CriterioDevolucion c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CriterioDevolucion.findByDescripcion", query = "SELECT c FROM CriterioDevolucion c WHERE c.descripcion = :descripcion")})
public class CriterioDevolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_devolucion")
    private Integer idCriterioDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterioDevolucionIdCriterioDevolucion")
    private List<Devoluciones> devolucionesList;

    public CriterioDevolucion() {
    }

    public CriterioDevolucion(Integer idCriterioDevolucion) {
        this.idCriterioDevolucion = idCriterioDevolucion;
    }

    public CriterioDevolucion(Integer idCriterioDevolucion, String nombre) {
        this.idCriterioDevolucion = idCriterioDevolucion;
        this.nombre = nombre;
    }

    public Integer getIdCriterioDevolucion() {
        return idCriterioDevolucion;
    }

    public void setIdCriterioDevolucion(Integer idCriterioDevolucion) {
        this.idCriterioDevolucion = idCriterioDevolucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Devoluciones> getDevolucionesList() {
        return devolucionesList;
    }

    public void setDevolucionesList(List<Devoluciones> devolucionesList) {
        this.devolucionesList = devolucionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioDevolucion != null ? idCriterioDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioDevolucion)) {
            return false;
        }
        CriterioDevolucion other = (CriterioDevolucion) object;
        if ((this.idCriterioDevolucion == null && other.idCriterioDevolucion != null) || (this.idCriterioDevolucion != null && !this.idCriterioDevolucion.equals(other.idCriterioDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CriterioDevolucion[ idCriterioDevolucion=" + idCriterioDevolucion + " ]";
    }
    
}
