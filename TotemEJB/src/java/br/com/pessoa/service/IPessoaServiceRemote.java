/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.service;

import br.com.pessoa.entity.Pessoa;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IPessoaServiceRemote {
    
    public Pessoa salvar(Pessoa pessoa) throws Exception ;
    
}
