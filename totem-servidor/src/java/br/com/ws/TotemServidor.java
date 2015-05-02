/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ws;

import br.com.generic.service.IGenericService;
import br.com.totem.entity.Acesso;
import br.com.totem.service.ITotemService;
import br.com.totem.wrapper.FalhaWrapper;
import br.com.totem.wrapper.TotemWrapperIn;
import br.com.totem.wrapper.TotemWrapperOut;
import br.com.totem.wrapper.Usuario;
import br.com.util.TotemUtil;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * WebService responsavel por receber uma requisicao do cliente ( Totem Desktop ).
 * 
 * Duas situações de responsabilidade:
 *  1 - Comsumir requisicao e gerenciar a producao de dados para integracao entre totem-servidor -> CadSus
 *  2 - Produzir a integracao de retorno para o Totem Desktop.
 * 
 * 
 * @author totem-servidor
 */
@WebService(serviceName = "TotemServidor")
public class TotemServidor {
    
    private static final Logger log = LogManager.getLogger(TotemServidor.class.getName());

    @EJB
    private IGenericService iGenericService;
    
    @EJB
    private ITotemService iTotemService;
    
    /** http://localhost:8080/totem-servidor/TotemServidor?WSDL **/
    
    /** Netbeans fornece um test para o WSDL, clicar no WS e 'Test Web Service' **/
    
    /**
     * 
     * Método WS -> Consumidor de integração TOTEM.
     * 
     * @param wrapperIn
     * @return 
     */
    @WebMethod(operationName = "integraTotem")
    public TotemWrapperOut integraTotem(@WebParam(name = "totem") TotemWrapperIn wrapperIn) {
        
        log.info("Início WS - integraTotem.");
        
        TotemWrapperOut wrapperOut = null;
        
        try{
            
            log.info("Cliente {0}:", wrapperIn.getUsuario().getNome());
            
            System.out.println("Cliente " + wrapperIn.getUsuario().getNome());

            /** Segurança Acesso **/
            checaAcessoSeguranca(wrapperIn);
            
            /** Restrição **/
            validaTotemWrapperIn(wrapperIn);
                
            /** 
             * 
             * 1 -> Integra CadSus 4.5 
             * 2 -> Gera instância resposta WS
             * 
             **/
            wrapperOut = geraRespostaParaTotem(wrapperIn, invocaIntegracaoCadSus(wrapperIn));
                
        }catch(Exception ex){
            
            log.error("Falha capturada.", ex);
            iTotemService.registrarFalha(new FalhaWrapper(wrapperIn, wrapperOut, "FALHA EXECUÇÃO", "FALHA CAPTURADA", ex));
        } finally {
            
            /** Remove Acesso **/
            removeAcessoPorHashAndChave(wrapperIn.getAcesso());
        }
        
        log.info("Fim WS - integraTotem.");
        
        return wrapperOut;
    }

    /**
     * 
     * @param wrapperIn
     * @throws Exception 
     */
    private void checaAcessoSeguranca(TotemWrapperIn wrapperIn) throws Exception {
        
        if(wrapperIn == null){
            throw new Exception("Falha ao tentar consultar cadastro.");
        }
        
        /** Valida Dados Acesso | Segurança **/
        if(wrapperIn.getAcesso() == null || TotemUtil.ehBrancoOrNulo(wrapperIn.getAcesso().getChave()) || wrapperIn.getAcesso().getHash() == null){
            throw new Exception("Acesso inválido. Informações obrigatórias.");
        }
        
        /** Recupera Acesso para Hash | Chave recebidos **/
        Acesso acesso = recuperaAcessoPorHashAndChave(wrapperIn.getAcesso().getHash(), wrapperIn.getAcesso().getChave());
        
        if(acesso == null){
            throw new Exception("Acesso inválido.");
        }
        
        wrapperIn.setAcesso(acesso);
    }

    /**
     * 
     * @param wrapperIn
     * @return 
     */
    private Object invocaIntegracaoCadSus(TotemWrapperIn wrapperIn) {
        return new Object();
    }

    /**
     * 
     * @param outCadSus
     * @return
     * @throws Exception 
     */
    private TotemWrapperOut geraRespostaParaTotem(TotemWrapperIn wrapperIn, Object outCadSus) throws Exception {
        
        validaIntegracaoCadSus(outCadSus);
        
        return new TotemWrapperOut(new Usuario(wrapperIn.getNomePesquisa() + " - " + wrapperIn.getUsuario().getNome()));
    }

    /**
     * 
     * Responsável por validar informações recebidas para integração.
     * 
     * @param wrapperIn
     * @throws Exception 
     */
    private void validaTotemWrapperIn(TotemWrapperIn wrapperIn) throws Exception {
        
        if(wrapperIn == null){
            throw new Exception("Falha ao tentar consultar cadastro.");
        }
        
        if(TotemUtil.ehBrancoOrNulo(wrapperIn.getNomePesquisa())){
            throw new Exception("Obrigatório informar Nome.");
        }
        
        if(TotemUtil.ehBrancoOrNulo(wrapperIn.getDataNascimentoPesquisa())){
            throw new Exception("Obrigatório informar Data Nascimento.");
        }
    }
    
    /**
     * 
     * @param hash
     * @param chave
     * @return 
     */
    private Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        return iTotemService.recuperaAcessoPorHashAndChave(hash, chave);
    }

    /**
     * 
     * @param acesso 
     */
    private void removeAcessoPorHashAndChave(Acesso acesso) {
        iGenericService.exclui(acesso.getClass(), acesso.getId());
    }

    /**
     * 
     * @param outCadSus
     * @throws Exception 
     */
    private void validaIntegracaoCadSus(Object outCadSus) throws Exception {
        
        if(outCadSus == null){
            throw new Exception("Falha inesperada. CadSus falhou.");
        }
    }
}