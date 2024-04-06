/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.CriterioDevolucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface CriterioDevolucionFacadeLocal {

    void create(CriterioDevolucion criterioDevolucion);

    void edit(CriterioDevolucion criterioDevolucion);

    void remove(CriterioDevolucion criterioDevolucion);

    CriterioDevolucion find(Object id);

    List<CriterioDevolucion> findAll();

    List<CriterioDevolucion> findRange(int[] range);

    int count();
    
}
