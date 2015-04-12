/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao.impl;

import br.com.totem.dao.IAcessoDaoRemote;
import br.com.totem.entity.Acesso;
import br.com.util.TotemUtil;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IAcessoDaoRemote.class)
public class AcessoDaoImpl implements IAcessoDaoRemote {
    
    @PersistenceContext(unitName = "totemPU")
    private EntityManager entityManager;
    
    /**
     * 
     * @param hash
     * @param chave
     * @return 
     * @throws java.lang.Exception 
     */
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        
        if(hash == null || TotemUtil.ehBrancoOrNulo(chave)){
            throw new Exception("Parâmetro inválidos.");
        }
        
        return (Acesso) entityManager
                    .createNamedQuery("Acesso.recuperaAcessoPorHashAndChave", Acesso.class)
                        .setParameter("hash", hash)
                        .setParameter("chave", chave)
                    .getSingleResult();
    }
}
