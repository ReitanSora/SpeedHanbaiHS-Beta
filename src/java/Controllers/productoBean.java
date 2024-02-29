/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.ProductosFacadeLocal;
import Entities.Categorias;
import Entities.Productos;
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
@Named(value = "productoBean")
@SessionScoped
public class productoBean implements Serializable {

    @EJB
    private ProductosFacadeLocal productosFacade;
    private List<Productos> listaProductos;
    private Productos producto;
    private Categorias categoria;
    private Proveedores proveedor;

    public List<Productos> getListaProductos() {
        this.listaProductos = this.productosFacade.findAll();
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }
    
    public void save(){
        this.producto.setCategoriasIdCategoria(categoria);
        this.producto.setProveedoresIdProveedor(proveedor);
        this.productosFacade.create(producto);
        
        this.producto = new Productos();
        this.categoria = new Categorias();
        this.proveedor = new Proveedores();
    }
    
    public void delete(Productos prod){
        this.productosFacade.remove(prod);
    }
    
    public void edit(){
        this.producto.setCategoriasIdCategoria(categoria);
        this.producto.setProveedoresIdProveedor(proveedor);
        this.productosFacade.edit(producto);
        
        this.producto = new Productos();
        this.categoria = new Categorias();
        this.proveedor = new Proveedores();
    }
    
    public void load(Productos prod){
        this.categoria.setIdCategoria(prod.getIdProducto());
        this.proveedor.setIdProveedor(prod.getIdProducto());
        this.producto = prod;
    }
    
    public void clean(){
        this.producto = new Productos();
        this.categoria = new Categorias();
        this.proveedor = new Proveedores();
    }
    
    @PostConstruct
    public void init(){
        this.producto = new Productos();
        this.categoria = new Categorias();
        this.proveedor = new Proveedores();
    }
    
    public productoBean() {
    }
    
}
