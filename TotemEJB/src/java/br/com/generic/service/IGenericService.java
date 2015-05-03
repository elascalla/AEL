/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.service;

import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IGenericService {
    
    public void inclui(Object object) throws Exception;
    
    public Object altera(Object object) throws Exception;
    
    public void exclui(Class classObject, Long idObjectDelete);
    
    public Object recupera(Class classObject, Object id);
}