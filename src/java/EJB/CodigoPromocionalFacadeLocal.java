/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entities.CodigoPromocional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stive
 */
@Local
public interface CodigoPromocionalFacadeLocal {

    void create(CodigoPromocional codigoPromocional);

    void edit(CodigoPromocional codigoPromocional);

    void remove(CodigoPromocional codigoPromocional);

    CodigoPromocional find(Object id);

    List<CodigoPromocional> findAll();

    List<CodigoPromocional> findRange(int[] range);

    int count();
    
}
