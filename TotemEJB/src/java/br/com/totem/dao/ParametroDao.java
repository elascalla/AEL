/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao;

import br.com.totem.entity.Parametro;
import br.com.totem.util.TotemUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author ericka
 */
public class ParametroDao {
    
    public Parametro recuperaParametroPorNome(EntityManager em, String nome) throws Exception {
        
        if(TotemUtil.ehBrancoOrNulo(nome)){
            throw new Exception("Parâmetro inválidos.");
        }
        
        return (Parametro) em
            .createNamedQuery("Parametro.recuperaParametroPorNome", Parametro.class)
                .setParameter("nome", nome)
            .getSingleResult();
    }
}