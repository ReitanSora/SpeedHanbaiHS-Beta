/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author stive
 */
@Named(value = "navigationBean")
@SessionScoped
public class navigationBean implements Serializable {

    private List<String> paginas;

    public List<String> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<String> paginas) {
        this.paginas = paginas;
    }
    
    
    public String navigationTarjetaVideo(){
        return ("/categorias/tarjetaVideo.xhtml?faces-redirect=true");
    }
    
    public navigationBean() {
    }
    
}
