/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.CategoriasFacadeLocal;
import Entities.Categorias;
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
@Named(value = "categoriaBean")
@SessionScoped
public class categoriaBean implements Serializable {

    @EJB
    private CategoriasFacadeLocal categoriasFacade;
    private List<Categorias> listaCategorias;
    private Categorias categoria;

    public List<Categorias> getListaCategorias() {
        this.listaCategorias = this.categoriasFacade.findAll();
        return listaCategorias;
    }

    public void setListaCategorias(List<Categorias> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    @PostConstruct
    public void init(){
        this.categoria = new Categorias();
    }
    
    public categoriaBean() {
    }
    
}
