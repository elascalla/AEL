/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.parametro.service.impl;

import br.com.entidade.Parametro;
import br.com.parametro.bo.IParametroBoRemote;
import br.com.parametro.service.IParametroServiceRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IParametroServiceRemote.class)
public class ParametroServiceImpl implements IParametroServiceRemote {
    
    @EJB(beanName = "ParametroBoImpl")
    private IParametroBoRemote iParametroBoRemote;
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception{
        return iParametroBoRemote.recuperaParametroPorNome(nome);
    }
    
}
