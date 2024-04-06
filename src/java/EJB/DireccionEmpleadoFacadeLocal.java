/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.DireccionEmpleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface DireccionEmpleadoFacadeLocal {

    void create(DireccionEmpleado direccionEmpleado);

    void edit(DireccionEmpleado direccionEmpleado);

    void remove(DireccionEmpleado direccionEmpleado);

    DireccionEmpleado find(Object id);

    List<DireccionEmpleado> findAll();

    List<DireccionEmpleado> findRange(int[] range);

    int count();
    
}
