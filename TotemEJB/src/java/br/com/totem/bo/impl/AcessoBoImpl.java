/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.bo.impl;

import br.com.totem.bo.IAcessoBoRemote;
import br.com.totem.dao.IAcessoDaoRemote;
import br.com.totem.entity.Acesso;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IAcessoBoRemote.class)
public class AcessoBoImpl implements IAcessoBoRemote {
    
    @EJB(beanName = "AcessoDaoImpl")
    private IAcessoDaoRemote iAcessoDaoRemote;
    
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        return iAcessoDaoRemote.recuperaAcessoPorHashAndChave(hash, chave);
    }
}
