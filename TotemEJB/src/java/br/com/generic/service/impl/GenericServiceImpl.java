/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.generic.service.impl;

import br.com.generic.service.IGenericService;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IGenericService.class)
public class GenericServiceImpl implements IGenericService {
    
    private static final Logger log = LogManager.getLogger(GenericServiceImpl.class);
    
    @PersistenceContext(unitName = "totemPU")
    private EntityManager em;

    /**
     * 
     * @param object
     * @throws Exception 
     */
    @Override
    public void inclui(Object object) throws Exception {
        
//        try{
        
            log.debug("Início classe: {0} método: {1}", GenericServiceImpl.class.getName(), "inclui");

            em.persist(object);

            log.debug("Fim classe: {0} método: {1}", GenericServiceImpl.class.getName(), "inclui");
            
//        } catch(Exception ex){
//            
//            log.error("Falha capturada.", ex);
//            
//            new TotemRepositorio().registrarFalha(em, falhaWrapper);
//        }
    }
    
    /**
     * 
     * @param object
     * @return
     * @throws Exception 
     */
    @Override
    public Object altera(Object object) throws Exception {
        
        log.debug("Início classe: {0} método: {1}", GenericServiceImpl.class.getName(), "altera");
        
        Object alterado = em.merge(object);
        
        log.debug("Fim classe: {0} método: {1}", GenericServiceImpl.class.getName(), "altera");
        
        return alterado;
    }

    /**
     * 
     * @param classObject
     * @param idObjectDelete 
     */
    @Override
    public void exclui(Class classObject, Long idObjectDelete) {
        
        log.debug("Início classe: {0} método: {1}", GenericServiceImpl.class.getName(), "exclui");
        
        em.remove(em.find(classObject, idObjectDelete));
        
        log.debug("Fim classe: {0} método: {1}", GenericServiceImpl.class.getName(), "exclui");
    }
    
    /**
     * 
     * @param classObject
     * @param id
     * @return 
     */
    @Override
    public Object recupera(Class classObject, Object id) {
        
        log.debug("Início classe: {0} método: {1}", GenericServiceImpl.class.getName(), "recupera");
        
        Object pesquisado = em.find(classObject, id);
        
        log.debug("Início classe: {0} método: {1}", GenericServiceImpl.class.getName(), "recupera");
        
        return pesquisado;
    }
}