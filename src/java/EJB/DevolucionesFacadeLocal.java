/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Devoluciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface DevolucionesFacadeLocal {

    void create(Devoluciones devoluciones);

    void edit(Devoluciones devoluciones);

    void remove(Devoluciones devoluciones);

    Devoluciones find(Object id);

    List<Devoluciones> findAll();

    List<Devoluciones> findRange(int[] range);

    int count();
    
}
