/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao.impl;

import br.com.generic.entity.EntityManagerUtil;
import br.com.totem.dao.IParametroDao;
import br.com.totem.entity.Parametro;
import br.com.util.TotemUtil;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ericka
 */
public class ParametroDaoImpl implements IParametroDao {
    
    @PersistenceContext(unitName = "totemPU")
    private final EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public ParametroDaoImpl() {
        this.em = EntityManagerUtil.getEntityManager();
    }
    
    @Override
    public Parametro recuperaParametroPorNome(String nome) throws Exception {
        
        if(TotemUtil.ehBrancoOrNulo(nome)){
            throw new Exception("Parâmetro inválidos.");
        }
        
        return (Parametro) getEntityManager()
                    .createNamedQuery("Parametro.recuperaParametroPorNome", Parametro.class)
                        .setParameter("nome", nome)
                    .getSingleResult();
    }
    
}
