/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.bo.impl;

import br.com.generic.service.IGenericServiceRemote;
import br.com.pessoa.bo.IPessoaBoRemote;
import br.com.pessoa.entity.Pessoa;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IPessoaBoRemote.class)
public class PessoaBoImpl implements IPessoaBoRemote{
    
    @EJB(beanName = "GenericServiceImpl")
    private IGenericServiceRemote genericService;
    
    @Override
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        return (Pessoa) genericService.salvar(pessoa);
    }
}
