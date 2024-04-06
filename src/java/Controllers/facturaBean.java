/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.FacturaFacadeLocal;
import Entities.Factura;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author stive
 */
@Named(value = "facturaBean")
@SessionScoped
public class facturaBean implements Serializable {

    private FacturaFacadeLocal facturaFacade;
    private Factura factura;
    private List<Factura> listaFactura;

    public FacturaFacadeLocal getFacturaFacade() {
        return facturaFacade;
    }

    public void setFacturaFacade(FacturaFacadeLocal facturaFacade) {
        this.facturaFacade = facturaFacade;
    }

    
    
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getListaFactura() {
        this.listaFactura = this.facturaFacade.findAll();
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }
    
    @PostConstruct
    public void init() {
        this.factura = new Factura();
    }
    
    public int contarFacturas(){
        int count = this.listaFactura.size();
        return count;
    }
    
    public facturaBean() {
    }
    
}
