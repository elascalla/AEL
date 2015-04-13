/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totemclientejb;

import br.com.generic.service.IGenericServiceRemote;
import br.com.totem.entity.Acesso;
import br.com.ws.ObjectFactory;
import br.com.ws.TotemServidor_Service;
import br.com.ws.TotemWrapperOut;
import br.com.ws.TotemWrapperIn;
import br.com.ws.Usuario;
import java.util.Calendar;
import javax.ejb.EJB;

/**
 *
 * @author ericka
 */
public class Main {
    
//    @EJB(lookup = "ejb/IGenericServiceRemote", name = "IGenericServiceRemote")
//    private static IGenericServiceRemote service;
    @EJB
    private static IGenericServiceRemote service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
//        Properties props = new Properties();
//        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
//        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
//        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

//        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
//        props.setProperty("org.omg.CORBA.ORBInitialHost", "186.250.124.24");
//        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        
//        InitialContext ic = new InitialContext(props);
        
//        iTotemService = (ITotemService) ic.lookup("java:global/TotemEJB/TotemService");
        System.out.println("TESTE EJB OK !");
        service.msg();
        
        try{
            
            Usuario usuario = new ObjectFactory().createUsuario();
            usuario.setNome("ERICK");
            
            TotemWrapperIn usuarioWrapper = new ObjectFactory().createTotemWrapperIn();
            usuarioWrapper.setNomePesquisa("TOTEM");
            usuarioWrapper.setDataNascimentoPesquisa("28/03/2015");
            usuarioWrapper.setUsuario(usuario);
            
            Acesso tabelaAcesso = new Acesso();
            tabelaAcesso.setHash(usuarioWrapper.hashCode());
            tabelaAcesso.setChave("TOTEM_SERVIDOR_1");
            tabelaAcesso.setDataAcesso(Calendar.getInstance().getTime());
            
            service.salvar(tabelaAcesso);
            
            TotemWrapperOut totemOut = new TotemServidor_Service().getTotemServidorPort().totemUsuarioObj(usuarioWrapper);
            
        } catch(Exception ex){
            ex.printStackTrace();
//            log.error("Obj -> Ocorreu um erro inesperado. ", ex);
        }
        
    }
}
