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
@Table(name = "direccion_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionEmpleado.findAll", query = "SELECT d FROM DireccionEmpleado d")
    , @NamedQuery(name = "DireccionEmpleado.findByPais", query = "SELECT d FROM DireccionEmpleado d WHERE d.pais = :pais")
    , @NamedQuery(name = "DireccionEmpleado.findByCiudad", query = "SELECT d FROM DireccionEmpleado d WHERE d.ciudad = :ciudad")
    , @NamedQuery(name = "DireccionEmpleado.findByCallePrincipal", query = "SELECT d FROM DireccionEmpleado d WHERE d.callePrincipal = :callePrincipal")
    , @NamedQuery(name = "DireccionEmpleado.findByCalleTransversal", query = "SELECT d FROM DireccionEmpleado d WHERE d.calleTransversal = :calleTransversal")
    , @NamedQuery(name = "DireccionEmpleado.findByEmpleadosIdEmpleado", query = "SELECT d FROM DireccionEmpleado d WHERE d.empleadosIdEmpleado = :empleadosIdEmpleado")})
public class DireccionEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle_principal")
    private String callePrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle_transversal")
    private String calleTransversal;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleados_id_empleado")
    private Integer empleadosIdEmpleado;
    @JoinColumn(name = "empleados_id_empleado", referencedColumnName = "id_empleado", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleados empleados;

    public DireccionEmpleado() {
    }

    public DireccionEmpleado(Integer empleadosIdEmpleado) {
        this.empleadosIdEmpleado = empleadosIdEmpleado;
    }

    public DireccionEmpleado(Integer empleadosIdEmpleado, String pais, String ciudad, String callePrincipal, String calleTransversal) {
        this.empleadosIdEmpleado = empleadosIdEmpleado;
        this.pais = pais;
        this.ciudad = ciudad;
        this.callePrincipal = callePrincipal;
        this.calleTransversal = calleTransversal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleTransversal() {
        return calleTransversal;
    }

    public void setCalleTransversal(String calleTransversal) {
        this.calleTransversal = calleTransversal;
    }

    public Integer getEmpleadosIdEmpleado() {
        return empleadosIdEmpleado;
    }

    public void setEmpleadosIdEmpleado(Integer empleadosIdEmpleado) {
        this.empleadosIdEmpleado = empleadosIdEmpleado;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadosIdEmpleado != null ? empleadosIdEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionEmpleado)) {
            return false;
        }
        DireccionEmpleado other = (DireccionEmpleado) object;
        if ((this.empleadosIdEmpleado == null && other.empleadosIdEmpleado != null) || (this.empleadosIdEmpleado != null && !this.empleadosIdEmpleado.equals(other.empleadosIdEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DireccionEmpleado[ empleadosIdEmpleado=" + empleadosIdEmpleado + " ]";
    }
    
}
