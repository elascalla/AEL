/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.bo.impl;

import br.com.generic.bo.IGenericBoRemote;
import br.com.generic.dao.IGenericDao;
import br.com.generic.dao.impl.GenericDaoImpl;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IGenericBoRemote.class)
public class GenericBoImpl implements IGenericBoRemote {
    
    private final IGenericDao genericDao = new GenericDaoImpl();

    @Override
    public Object salvar(EntityManager em, Object object) {
        try {
            return genericDao.salvar(em, object);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object buscarObjetoPorId(EntityManager em, Class clazz, Object id) {
        return genericDao.buscarObjetoPorId(em, clazz, id);
    }

    @Override
    public Boolean excluir(EntityManager em, Object object) {
        return genericDao.excluir(em, object);
    }
    
}
