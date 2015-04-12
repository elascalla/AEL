/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.service.impl;

import br.com.pessoa.bo.IPessoaBoRemote;
import br.com.pessoa.entity.Pessoa;
import br.com.pessoa.service.IPessoaServiceRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IPessoaServiceRemote.class)
public class PessoaServiceImpl  implements IPessoaServiceRemote{

    @EJB(beanName = "PessoaBoImpl")
    private IPessoaBoRemote iPessoaBoRemote;
    
    @Override
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        return iPessoaBoRemote.salvar(pessoa);
    }
}
