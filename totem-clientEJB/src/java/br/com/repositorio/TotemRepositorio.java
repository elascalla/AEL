/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andre
 */
public class TotemRepositorio {
    
    private static final String DATASOURCE = "totemPU";
    
    private static EntityManagerFactory entityManagerFactory; 
    
    /**
     * 
     * @return EntityManagerFactory
     */
    private static EntityManagerFactory getEntityManagerFactory() {
        
        if(entityManagerFactory == null || !entityManagerFactory.isOpen()){
            entityManagerFactory = Persistence.createEntityManagerFactory(DATASOURCE);
        }
        
        return entityManagerFactory;
    }

    /**
     * 
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}