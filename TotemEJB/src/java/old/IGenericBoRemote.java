/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *
 * @author ericka
 */
@Remote
public interface IGenericBoRemote {
    
    public Object salvar(EntityManager em, Object object) throws Exception;
    
    public Object buscarObjetoPorId(EntityManager em, Class clazz, Object id);
    
    public Boolean excluir(EntityManager em, Object object);
    
}
