/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.ClientesFacadeLocal;
import Entities.Clientes;
import Entities.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author stive
 */
@Named(value = "clienteBean")
@RequestScoped
public class clienteBean {

    @EJB
    private ClientesFacadeLocal clientesFacade;
    private List<Clientes> listaCliente;
    private Clientes cliente;
    private Usuario usuario;

    public List<Clientes> getListaCliente() {
        this.listaCliente = this.clientesFacade.findAll();
        return listaCliente;
    }

    public void setListaCliente(List<Clientes> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.cliente = new Clientes();
        this.usuario = new Usuario();
    }
    
    
    public clienteBean() {
    }
    
}
