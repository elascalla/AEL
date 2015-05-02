/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao;

import br.com.totem.entity.Falha;
import br.com.totem.wrapper.FalhaWrapper;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Andre
 */
public class FalhaDao {
    
    public void registrarFalha(EntityManager em, FalhaWrapper falhaWrapper){
        
        Falha falha = new Falha();
        
        falha.setChave(falhaWrapper.getChaveIn() + falhaWrapper.getChaveOut());
        falha.setDataFalha(Calendar.getInstance().getTime());
        falha.setMensagem(falhaWrapper.getMensagem());
        falha.setStackTrace(falhaWrapper.getException().toString());
        
        em.persist(falha);
    }
}