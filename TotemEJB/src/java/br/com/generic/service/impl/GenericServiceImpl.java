/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.service.impl;

import br.com.generic.bo.IGenericBoRemote;
import br.com.generic.bo.impl.GenericBoImpl;
import br.com.generic.entity.EntityManagerUtil;
import br.com.generic.service.IGenericServiceRemote;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */

@Stateless
@Remote(IGenericServiceRemote.class)
public class GenericServiceImpl implements IGenericServiceRemote {
    
    private final IGenericBoRemote genericBo = new GenericBoImpl();
    
    @PersistenceContext(unitName = "totemPU")
    private final EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public GenericServiceImpl() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    @Override
    public Object salvar(Object object) throws Exception {
        try {
            return genericBo.salvar(em, object);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object buscarObjetoPorId(Class clazz, Object id) {
        return genericBo.buscarObjetoPorId(em, clazz, id);
    }

    @Override
    public Boolean excluir(Object object) {
        return genericBo.excluir(em, object);
    }

    @Override
    public String msg() {
        return "EJB";
    }
    
}
