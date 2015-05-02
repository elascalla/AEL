/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.service.impl;

import br.com.email.TotemEmail;
import br.com.generic.service.impl.GenericServiceImpl;
import br.com.totem.dao.AcessoDao;
import br.com.totem.dao.FalhaDao;
import br.com.totem.dao.ParametroDao;
import br.com.totem.entity.Acesso;
import br.com.totem.entity.Parametro;
import br.com.totem.service.ITotemService;
import br.com.totem.wrapper.FalhaWrapper;
import br.com.wrapper.TotemEmailWrapper;
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
@Remote(ITotemService.class)
public class TotemServiceImpl implements ITotemService {
    
    private static final Logger log = LogManager.getLogger(GenericServiceImpl.class);
    
    @PersistenceContext(unitName = "totemPU")
    private EntityManager em;
    
    /**
     * 
     * @param hash
     * @param chave
     * @return
     * @throws Exception 
     */
    @Override
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        
        log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "recuperaAcessoPorHashAndChave");
        
        Acesso acesso = new AcessoDao().recuperaAcessoPorHashAndChave(em, hash, chave);
        
        log.debug("Fim classe: {0} método: {1}", TotemServiceImpl.class.getName(), "recuperaAcessoPorHashAndChave");
        
        return acesso;
    }

    /**
     * 
     * @param nome
     * @return
     * @throws Exception 
     */
    @Override
    public Parametro recuperaParametroPorNome(String nome) throws Exception {
        
        log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "recuperaParametroPorNome");
        
        Parametro parametro = new ParametroDao().recuperaParametroPorNome(em, nome);
        
        log.debug("Fim classe: {0} método: {1}", TotemServiceImpl.class.getName(), "recuperaParametroPorNome");
        
        return parametro;
    }
    
    @Override
    public void registrarFalha(FalhaWrapper falhaWrapper) {
        
        /** Falha **/
        new FalhaDao().registrarFalha(em, falhaWrapper);
        
        /** Email **/
        TotemEmail.enviaEmail(new TotemEmailWrapper("Falha Capturada", falhaWrapper.getMensagem(), falhaWrapper.getStackTrace()));
    }   
}