/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.dao.impl;

import br.com.generic.dao.IGenericDaoRemote;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */

@Stateless
@Remote(IGenericDaoRemote.class)
public class GenericDaoImpl implements IGenericDaoRemote {
    
    @PersistenceContext(unitName = "totemPU")
    private EntityManager entityManager;
    
    @Override
    public Object salvar(Object object) throws Exception {
        try {
            object = entityManager.merge(object);

            return object;
        } catch (Exception e) {

            try {
                entityManager.getTransaction().rollback();
                return null;
            } catch (Exception e1) {
                return null;
            }
        }
    }
    
    @Override
    public Object buscarObjetoPorId(Class clazz, Object id) {
        return entityManager.find(clazz, id);
    }
    
    @Override
    public Boolean excluir(Object object) {
        try {
            entityManager.remove(entityManager.merge(object));

            return true;
        } catch (Exception e) {

            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e1) {
                return false;
            }

            return false;
        }
    }
}
