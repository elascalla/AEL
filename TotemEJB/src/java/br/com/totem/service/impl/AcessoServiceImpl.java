/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.service.impl;

import br.com.totem.bo.IAcessoBoRemote;
import br.com.totem.entity.Acesso;
import br.com.totem.service.IAcessoServiceRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IAcessoServiceRemote.class)
public class AcessoServiceImpl implements IAcessoServiceRemote {
    
    @EJB(beanName = "AcessoBoImpl")
    private IAcessoBoRemote iAcessoBoRemote;
    
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        return iAcessoBoRemote.recuperaAcessoPorHashAndChave(hash, chave);
    }
    
}
