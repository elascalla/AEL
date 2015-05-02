/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.bo.impl;

import br.com.generic.bo.IGenericBoRemote;
import br.com.generic.dao.IGenericDaoRemote;
import br.com.generic.dao.impl.GenericDaoImpl;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IGenericBoRemote.class)
public class GenericBoImpl implements IGenericBoRemote {
    
    private final IGenericDaoRemote genericDao = new GenericDaoImpl();

    @Override
    public Object salvar(Object object) {
        try {
            return genericDao.salvar(object);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object buscarObjetoPorId(Class clazz, Object id) {
        return genericDao.buscarObjetoPorId(clazz, id);
    }

    @Override
    public Boolean excluir(Object object) {
        return genericDao.excluir(object);
    }
    
}
