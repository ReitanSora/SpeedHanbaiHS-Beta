/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.Calificaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface CalificacionesFacadeLocal {

    void create(Calificaciones calificaciones);

    void edit(Calificaciones calificaciones);

    void remove(Calificaciones calificaciones);

    Calificaciones find(Object id);

    List<Calificaciones> findAll();

    List<Calificaciones> findRange(int[] range);

    int count();
    
}
