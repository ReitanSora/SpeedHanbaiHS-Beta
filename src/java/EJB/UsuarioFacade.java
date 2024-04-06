/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Controllers.Encrypt;
import Entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author stive
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SpeedHanbaiHSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario acceder(Usuario us) {
        
        Usuario usuario = null;
        Encrypt enc = new Encrypt();
        
        String consulta;
        
        try {
            consulta = "FROM Usuario u WHERE u.nombreUsuario =?1 AND u.clave = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getNombreUsuario());
            
            query.setParameter(2, enc.encrypt(us.getClave()));
            List<Usuario> lista = query.getResultList();

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
        }
        
        return usuario;
    }
}
