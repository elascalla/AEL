/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ws.cliente;

import br.com.generic.service.IGenericService;
import br.com.ws.servidor.Acesso;
import br.com.ws.servidor.ObjectFactory;
import br.com.ws.servidor.TotemServidor_Service;
import br.com.ws.servidor.TotemWrapperIn;
import br.com.ws.servidor.TotemWrapperOut;
import br.com.ws.servidor.Usuario;
import javax.ejb.EJB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 /**
 *
 * Cliente Responsável por integrar ( produzir ) integração entre Totem Desktop -> Totem Servidor
 * 
 * @author totem-servidor
 */
public class TotemDesktop {

    private static final Logger log = LogManager.getLogger(TotemDesktop.class.getName());
    
    @EJB
    private static IGenericService iGenericService;
    
    private String parametroWS;

    public TotemDesktop() {
    }
    
    public TotemDesktop(String parametroWS) {
        this.parametroWS = parametroWS;
    }

    public String getParametroWS() {
        return parametroWS;
    }

    public void setParametroWS(String parametroWS) {
        this.parametroWS = parametroWS;
    }

    public static void main(String[] args) {
        
        log.info("Executa Integração Web Service -> Totem Servidor");
        
        TotemDesktop totemDesktop = new TotemDesktop("Teste -> Totem Desktop");
        
        for (int i = 0; i < 1; i++) {
            System.out.println("Obj -> Resposta WS: indice: " + i + totemDesktop.totemUsuarioObj(totemDesktop, i).getUsuario().getNome());
        }
    }

    /**
     * 
     * Método responsável por integrar e receber uma resposta.
     * 
     * @param totemDesktop
     * @return 
     */
    private TotemWrapperOut totemUsuarioObj(TotemDesktop totemDesktop, Integer i) {
        
        try{
            
            Usuario usuario = new ObjectFactory().createUsuario();
            usuario.setNome("ANDRE -> indice: " + i);
            
            TotemWrapperIn usuarioWrapper = new ObjectFactory().createTotemWrapperIn();
            usuarioWrapper.setNomePesquisa("TOTEM");
            usuarioWrapper.setDataNascimentoPesquisa("28/03/2015");
            
            usuarioWrapper.setUsuario(usuario);
            
            Acesso acesso = new ObjectFactory().createAcesso();
            acesso.setHash(usuarioWrapper.hashCode());
            acesso.setChave("TOTEM_SERVIDOR_1");
            iGenericService.inclui(acesso);
            
            usuarioWrapper.setAcesso(acesso);
            
            return new TotemServidor_Service().getTotemServidorPort().integraTotem(usuarioWrapper);
            
        } catch(Exception ex){
            log.error("Obj -> Ocorreu um erro inesperado. ", ex);
        }
        
        return null;
    }
}