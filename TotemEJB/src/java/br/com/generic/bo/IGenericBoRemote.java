/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.bo;

import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IGenericBoRemote {
    
    public Object salvar(Object object) throws Exception;
    
    public Object buscarObjetoPorId(Class clazz, Object id);
    
    public Boolean excluir(Object object);
    
}
