/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "devoluciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devoluciones.findAll", query = "SELECT d FROM Devoluciones d")
    , @NamedQuery(name = "Devoluciones.findByIdDevolucion", query = "SELECT d FROM Devoluciones d WHERE d.idDevolucion = :idDevolucion")
    , @NamedQuery(name = "Devoluciones.findByFecha", query = "SELECT d FROM Devoluciones d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "Devoluciones.findByEstado", query = "SELECT d FROM Devoluciones d WHERE d.estado = :estado")})
public class Devoluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_devolucion")
    private Integer idDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "devolucionesIdDevolucion")
    private List<DetalleDevolucion> detalleDevolucionList;
    @JoinColumn(name = "criterio_devolucion_id_criterio_devolucion", referencedColumnName = "id_criterio_devolucion")
    @ManyToOne(optional = false)
    private CriterioDevolucion criterioDevolucionIdCriterioDevolucion;
    @JoinColumn(name = "factura_id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private Factura facturaIdFactura;

    public Devoluciones() {
    }

    public Devoluciones(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Devoluciones(Integer idDevolucion, Date fecha, short estado) {
        this.idDevolucion = idDevolucion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<DetalleDevolucion> getDetalleDevolucionList() {
        return detalleDevolucionList;
    }

    public void setDetalleDevolucionList(List<DetalleDevolucion> detalleDevolucionList) {
        this.detalleDevolucionList = detalleDevolucionList;
    }

    public CriterioDevolucion getCriterioDevolucionIdCriterioDevolucion() {
        return criterioDevolucionIdCriterioDevolucion;
    }

    public void setCriterioDevolucionIdCriterioDevolucion(CriterioDevolucion criterioDevolucionIdCriterioDevolucion) {
        this.criterioDevolucionIdCriterioDevolucion = criterioDevolucionIdCriterioDevolucion;
    }

    public Factura getFacturaIdFactura() {
        return facturaIdFactura;
    }

    public void setFacturaIdFactura(Factura facturaIdFactura) {
        this.facturaIdFactura = facturaIdFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevolucion != null ? idDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devoluciones)) {
            return false;
        }
        Devoluciones other = (Devoluciones) object;
        if ((this.idDevolucion == null && other.idDevolucion != null) || (this.idDevolucion != null && !this.idDevolucion.equals(other.idDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Devoluciones[ idDevolucion=" + idDevolucion + " ]";
    }
    
}
