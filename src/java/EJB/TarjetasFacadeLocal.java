/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Tarjetas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface TarjetasFacadeLocal {

    void create(Tarjetas tarjetas);

    void edit(Tarjetas tarjetas);

    void remove(Tarjetas tarjetas);

    Tarjetas find(Object id);

    List<Tarjetas> findAll();

    List<Tarjetas> findRange(int[] range);

    int count();
    
}
