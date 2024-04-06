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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaIdFactura")
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "clientes_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes clientesIdCliente;
    @JoinColumn(name = "descuento_id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento descuentoIdDescuento;
    @JoinColumn(name = "entrega_id_entrega", referencedColumnName = "id_entrega")
    @ManyToOne(optional = false)
    private Entrega entregaIdEntrega;
    @JoinColumn(name = "estado_pedido_id_estado_pedido", referencedColumnName = "id_estado_pedido")
    @ManyToOne(optional = false)
    private EstadoPedido estadoPedidoIdEstadoPedido;
    @JoinColumn(name = "iva_id_iva", referencedColumnName = "id_iva")
    @ManyToOne(optional = false)
    private Iva ivaIdIva;
    @JoinColumn(name = "metodo_pago_id_pago", referencedColumnName = "id_pago")
    @ManyToOne(optional = false)
    private MetodoPago metodoPagoIdPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaIdFactura")
    private List<Devoluciones> devolucionesList;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, Date fecha) {
        this.idFactura = idFactura;
        this.fecha = fecha;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Clientes getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Clientes clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public Descuento getDescuentoIdDescuento() {
        return descuentoIdDescuento;
    }

    public void setDescuentoIdDescuento(Descuento descuentoIdDescuento) {
        this.descuentoIdDescuento = descuentoIdDescuento;
    }

    public Entrega getEntregaIdEntrega() {
        return entregaIdEntrega;
    }

    public void setEntregaIdEntrega(Entrega entregaIdEntrega) {
        this.entregaIdEntrega = entregaIdEntrega;
    }

    public EstadoPedido getEstadoPedidoIdEstadoPedido() {
        return estadoPedidoIdEstadoPedido;
    }

    public void setEstadoPedidoIdEstadoPedido(EstadoPedido estadoPedidoIdEstadoPedido) {
        this.estadoPedidoIdEstadoPedido = estadoPedidoIdEstadoPedido;
    }

    public Iva getIvaIdIva() {
        return ivaIdIva;
    }

    public void setIvaIdIva(Iva ivaIdIva) {
        this.ivaIdIva = ivaIdIva;
    }

    public MetodoPago getMetodoPagoIdPago() {
        return metodoPagoIdPago;
    }

    public void setMetodoPagoIdPago(MetodoPago metodoPagoIdPago) {
        this.metodoPagoIdPago = metodoPagoIdPago;
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
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
