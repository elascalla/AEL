/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.parametro.dao.impl;

import br.com.entidade.Parametro;
import br.com.parametro.dao.IParametroDaoRemote;
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
@Remote(IParametroDaoRemote.class)
public class ParametroDaoImpl implements IParametroDaoRemote {
    
    @PersistenceContext(unitName = "totemPU")
    private EntityManager entityManager;
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception {
        
        if(TotemUtil.ehBrancoOrNulo(nome)){
            throw new Exception("Parâmetro inválidos.");
        }
        
        return (Parametro) entityManager
                    .createNamedQuery("Parametro.recuperaParametroPorNome", Parametro.class)
                        .setParameter("nome", nome)
                    .getSingleResult();
    }
    
}
