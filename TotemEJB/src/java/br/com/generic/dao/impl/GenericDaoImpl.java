/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.dao.impl;

import br.com.generic.dao.IGenericDaoRemote;
import br.com.generic.entity.EntityManagerUtil;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IGenericDaoRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GenericDaoImpl implements IGenericDaoRemote {
    
    @PersistenceContext(unitName = "totemPU")
    private final EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public GenericDaoImpl() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object buscarObjetoPorId(Class clazz, Object id) {
        return getEntityManager().find(clazz, id);
    }
}
