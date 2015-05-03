/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.service;

import br.com.totem.util.TotemEmail;
import br.com.totem.dao.AcessoDao;
import br.com.totem.dao.FalhaDao;
import br.com.totem.dao.ParametroDao;
import br.com.totem.entity.Acesso;
import br.com.totem.entity.Parametro;
import br.com.totem.wrapper.FalhaWrapper;
import br.com.totem.wrapper.TotemEmailWrapper;
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
    
    private static final Logger log = LogManager.getLogger(TotemServiceImpl.class);
    
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
        
            log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "inclui");

            em.persist(object);

            log.debug("Fim classe: {0} método: {1}", TotemServiceImpl.class.getName(), "inclui");
            
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
        
        log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "altera");
        
        Object alterado = em.merge(object);
        
        log.debug("Fim classe: {0} método: {1}", TotemServiceImpl.class.getName(), "altera");
        
        return alterado;
    }

    /**
     * 
     * @param classObject
     * @param idObjectDelete 
     */
    @Override
    public void exclui(Class classObject, Long idObjectDelete) {
        
        log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "exclui");
        
        em.remove(em.find(classObject, idObjectDelete));
        
        log.debug("Fim classe: {0} método: {1}", TotemServiceImpl.class.getName(), "exclui");
    }
    
    /**
     * 
     * @param classObject
     * @param id
     * @return 
     */
    @Override
    public Object recupera(Class classObject, Object id) {
        
        log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "recupera");
        
        Object pesquisado = em.find(classObject, id);
        
        log.debug("Início classe: {0} método: {1}", TotemServiceImpl.class.getName(), "recupera");
        
        return pesquisado;
    }
    
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
        try{
            
            TotemEmailWrapper wrapper = new TotemEmailWrapper("Falha Capturada", falhaWrapper.getMensagem(), falhaWrapper.getStackTrace());

            ParametroDao parametroDao = new ParametroDao();

            wrapper.setUsername(parametroDao.recuperaParametroPorNome(em, "EMAIL_USERNAME").getValor());
            wrapper.setPassword(parametroDao.recuperaParametroPorNome(em, "EMAIL_PASSWORD").getValor());
            wrapper.setFrom(parametroDao.recuperaParametroPorNome(em, "EMAIL_FROM").getValor());
            wrapper.setTo(parametroDao.recuperaParametroPorNome(em, "EMAIL_TO").getValor());
            wrapper.setCc(parametroDao.recuperaParametroPorNome(em, "EMAIL_CC").getValor());

            TotemEmail.envia(wrapper);
        
        } catch(Exception e) {
            log.error("Falha ao enviar email.", e);
        }
    }   
}