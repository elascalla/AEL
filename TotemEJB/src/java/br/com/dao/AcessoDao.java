/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.entity.Acesso;
import br.com.util.TotemUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author ericka
 */
public class AcessoDao{
    
    /**
     * 
     * @param em
     * @param hash
     * @param chave
     * @return 
     * @throws java.lang.Exception 
     */
    public Acesso recuperaAcessoPorHashAndChave(EntityManager em, Integer hash, String chave) throws Exception {
        
        if(hash == null || TotemUtil.ehBrancoOrNulo(chave)){
            throw new Exception("Parâmetro inválidos.");
        }
        
        return 
            (Acesso) em
                .createNamedQuery("Acesso.recuperaAcessoPorHashAndChave", Acesso.class)
                    .setParameter("hash", hash)
                    .setParameter("chave", chave)
                .getSingleResult();
    }
}