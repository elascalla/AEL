/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao.impl;

import br.com.generic.entity.EntityManagerUtil;
import br.com.totem.dao.IAcessoDao;
import br.com.totem.entity.Acesso;
import br.com.util.TotemUtil;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */
public class AcessoDaoImpl implements IAcessoDao{
    
    @PersistenceContext(unitName = "totemPU")
    private final EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public AcessoDaoImpl() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    /**
     * 
     * @param hash
     * @param chave
     * @return 
     * @throws java.lang.Exception 
     */
    @Override
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        
        if(hash == null || TotemUtil.ehBrancoOrNulo(chave)){
            throw new Exception("Parâmetro inválidos.");
        }
        
        return (Acesso) getEntityManager()
                    .createNamedQuery("Acesso.recuperaAcessoPorHashAndChave", Acesso.class)
                        .setParameter("hash", hash)
                        .setParameter("chave", chave)
                    .getSingleResult();
    }
    
}
