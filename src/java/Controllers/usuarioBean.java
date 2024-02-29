/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.UsuarioFacadeLocal;
import Entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author stive
 */
@Named(value = "usuarioBean")
@SessionScoped
public class usuarioBean implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private List<Usuario> listaUsuario;
    private Usuario usuario;

    public List<Usuario> getListaUsuario() {
        this.listaUsuario = this.usuarioFacade.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public void guardar() {
        this.usuarioFacade.create(usuario);

        this.usuario = new Usuario();
    }

    
    public String validar(){
        String ruta = null;
        Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            us = this.usuarioFacade.acceder(this.usuario);
            if (us != null) {
                ruta = "/admin?faces-redirect=true";
            } else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales incorrectas"));   
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Error!"));
        }
        
        return ruta;
    }
    
    public usuarioBean() {
    }

}
