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
        
        this.rol = new Rol (2, "user");
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
                if (us.getRolIdRol().getIdRol()== 1) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin", us);
                    ruta = "/views/adminViews/dashboard?faces-redirect=true";
                }else{
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", us);
                    ruta = "/views/userViews/userPanel?faces-redirect=true";
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        this.usuario = new Usuario();

        return ruta;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        String ruta = "/views/userViews/userPanel?faces-redirect=true";

        return ruta;
    }
    
    public boolean verificarSesionActiva(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        boolean resultado = false;
        
        if (us != null) {
            resultado = true;
        }
        
        return resultado;
    }
    
    public Usuario obtenerSesionActivaA(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("admin");
        return us;
    }
    
    public Usuario obtenerSesionActivaC(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        return us;
    }

    public usuarioBean() {
    }

}
