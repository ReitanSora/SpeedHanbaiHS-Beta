/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.ProveedoresFacadeLocal;
import Entities.Proveedores;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author stive
 */
@Named(value = "proveedorBean")
@SessionScoped
public class proveedorBean implements Serializable {

    @EJB
    private ProveedoresFacadeLocal proveedoresFacade;
    private List<Proveedores> listaProveedores;
    private Proveedores proveedor;

    public List<Proveedores> getListaProveedores() {
        this.listaProveedores = this.proveedoresFacade.findAll();
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }
    
    @PostConstruct
    public void init(){
        this.proveedor = new Proveedores();
    }
    
    public proveedorBean() {
    }
    
}
