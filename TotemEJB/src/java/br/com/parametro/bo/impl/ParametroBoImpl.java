/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.parametro.bo.impl;

import br.com.entidade.Parametro;
import br.com.parametro.bo.IParametroBoRemote;
import br.com.parametro.dao.IParametroDaoRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IParametroBoRemote.class)
public class ParametroBoImpl implements IParametroBoRemote {
    
    @EJB(beanName = "ParametroDaoImpl")
    private IParametroDaoRemote iParametroDaoRemote;
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception {
        return iParametroDaoRemote.recuperaParametroPorNome(nome);
    }
}
