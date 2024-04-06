/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.DetalleDevolucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface DetalleDevolucionFacadeLocal {

    void create(DetalleDevolucion detalleDevolucion);

    void edit(DetalleDevolucion detalleDevolucion);

    void remove(DetalleDevolucion detalleDevolucion);

    DetalleDevolucion find(Object id);

    List<DetalleDevolucion> findAll();

    List<DetalleDevolucion> findRange(int[] range);

    int count();
    
}
