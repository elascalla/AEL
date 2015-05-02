/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.dao.impl;

import br.com.generic.dao.IGenericDao;
import br.com.generic.entity.EntityManagerUtil;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */
//@Stateless
//@Remote(IGenericDao.class)
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class GenericDaoImpl implements IGenericDao {
    
    @PersistenceContext(unitName = "totemPU")
    private final EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public GenericDaoImpl() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object salvar(Object object) throws Exception {
        try {
            System.out.println("GRAVANDO...");
            getEntityManager().persist(object);
            System.out.println("GRAVOU...");
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                getEntityManager().getTransaction().rollback();
                return null;
            } catch (Exception e1) {
                return null;
            }
            
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object update(Object object) throws Exception {
 
        try {
            return getEntityManager().merge(object);
        } catch (Exception e) {

            try {
                getEntityManager().getTransaction().rollback();
                return null;
            } catch (Exception e1) {
                return null;
            }
            
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Boolean excluir(Object object) {
        try {
            getEntityManager().remove(getEntityManager().merge(object));

            return true;
        } catch (Exception e) {

            try {
                getEntityManager().getTransaction().rollback();
            } catch (Exception e1) {
                return false;
            }

            return false;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object buscarObjetoPorId(Class clazz, Object id) {
        return getEntityManager().find(clazz, id);
    }

    @Override
    public Object salvar(EntityManager em, Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object update(EntityManager em, Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarObjetoPorId(EntityManager em, Class clazz, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(EntityManager em, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
