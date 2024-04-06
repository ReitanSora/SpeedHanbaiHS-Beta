/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Negocio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface NegocioFacadeLocal {

    void create(Negocio negocio);

    void edit(Negocio negocio);

    void remove(Negocio negocio);

    Negocio find(Object id);

    List<Negocio> findAll();

    List<Negocio> findRange(int[] range);

    int count();
    
}
