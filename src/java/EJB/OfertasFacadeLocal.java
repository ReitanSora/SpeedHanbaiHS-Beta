/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Ofertas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface OfertasFacadeLocal {

    void create(Ofertas ofertas);

    void edit(Ofertas ofertas);

    void remove(Ofertas ofertas);

    Ofertas find(Object id);

    List<Ofertas> findAll();

    List<Ofertas> findRange(int[] range);

    int count();
    
}
