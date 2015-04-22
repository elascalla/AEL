/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.dao.impl;

import br.com.generic.dao.IGenericDao;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;

/**
 *
 * @author ericka
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GenericDaoImpl implements IGenericDao {
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object salvar(EntityManager em, Object object) throws Exception {
        try {
            System.out.println("GRAVANDO...");
            object = em.merge(object);
            System.out.println("GRAVOU...");
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                em.getTransaction().rollback();
                return null;
            } catch (Exception e1) {
                return null;
            }
            
        }
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object update(EntityManager em, Object object) throws Exception {
 
        try {
            return em.merge(object);
        } catch (Exception e) {

            try {
                em.getTransaction().rollback();
                return null;
            } catch (Exception e1) {
                return null;
            }
            
        }
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Boolean excluir(EntityManager em, Object object) {
        try {
            em.remove(em.merge(object));

            return true;
        } catch (Exception e) {

            try {
                em.getTransaction().rollback();
            } catch (Exception e1) {
                return false;
            }

            return false;
        }
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Object buscarObjetoPorId(EntityManager em, Class clazz, Object id) {
        return em.find(clazz, id);
    }
}