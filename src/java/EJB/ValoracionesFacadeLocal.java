/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Valoraciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface ValoracionesFacadeLocal {

    void create(Valoraciones valoraciones);

    void edit(Valoraciones valoraciones);

    void remove(Valoraciones valoraciones);

    Valoraciones find(Object id);

    List<Valoraciones> findAll();

    List<Valoraciones> findRange(int[] range);

    int count();
    
}
