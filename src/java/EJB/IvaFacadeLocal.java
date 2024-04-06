/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Iva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface IvaFacadeLocal {

    void create(Iva iva);

    void edit(Iva iva);

    void remove(Iva iva);

    Iva find(Object id);

    List<Iva> findAll();

    List<Iva> findRange(int[] range);

    int count();
    
}
