/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.dao.impl;

import br.com.pessoa.dao.IPessoaDaoRemote;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IPessoaDaoRemote.class)
public class PessoaDaoImpl implements IPessoaDaoRemote {
    
}
