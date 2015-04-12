/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.service.impl;

import br.com.generic.bo.IGenericBoRemote;
import br.com.generic.service.IGenericServiceRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */

@Stateless
@Remote(IGenericServiceRemote.class)
public class GenericServiceImpl implements IGenericServiceRemote {
    
    @EJB(beanName = "GenericBoImpl")
    private IGenericBoRemote genericBo;

    @Override
    public Object salvar(Object object) throws Exception {
        try {
            return genericBo.salvar(object);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object buscarObjetoPorId(Class clazz, Object id) {
        return genericBo.buscarObjetoPorId(clazz, id);
    }

    @Override
    public Boolean excluir(Object object) {
        return genericBo.excluir(object);
    }

    @Override
    public String msg() {
        return "EJB";
    }
    
}
