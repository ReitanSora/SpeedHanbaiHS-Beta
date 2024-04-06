/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.UsuarioFacadeLocal;
import Entities.Rol;
import Entities.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Rol rol;

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public void listarImg(int id){
        String sql = "select * from persona where Id = "+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutpurStream = null;
        
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.rol = new Rol();
    }

    public void guardar() {
        Encrypt e = new Encrypt();
        try {
            this.usuario.setClave(e.encrypt(this.usuario.getClave()));
        } catch (Exception ex) {
            Logger.getLogger(usuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.rol = new Rol (1, "user");
        this.usuario.setRolIdRol(rol);

        this.usuarioFacade.create(usuario);

        this.usuario = new Usuario();
        this.rol = new Rol();
    }

    public String validar() {
        String ruta = null;
        Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            us = this.usuarioFacade.acceder(this.usuario);
            if (us != null) {
                
                ruta = "/views/adminViews/dashboard?faces-redirect=true";
                this.usuario = us;
            } else {
                this.usuario = new Usuario();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }

        return ruta;
    }

    public String cerrarSesion() {
        this.usuario = new Usuario();
        String ruta = "/views/userViews/userPanel?faces-redirect=true";

        return ruta;
    }

    public usuarioBean() {
    }

}
