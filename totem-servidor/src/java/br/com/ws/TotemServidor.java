/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ws;

import br.com.generic.service.IGenericServiceRemote;
import br.com.totem.entity.Pessoa;
import br.com.totem.entity.Totem;
import br.com.totem.wrapper.TotemWrapperIn;
import br.com.totem.wrapper.TotemWrapperOut;
import br.gov.datasus.cobdn.cadsus.municipal.componente.webService.Rsp;
import br.gov.datasus.cobdn.cadsus.municipal.componente.webService.RspConsultaUsuario;
import br.gov.datasus.cobdn.cadsus.municipal.componente.webService.ServidorWsCadsusCobdn;
import br.gov.datasus.cobdn.cadsus.municipal.componente.webService.ServidorWsCadsusCobdn_Service;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * WebService responsavel por receber uma requisicao do cliente ( Totem Desktop
 * ).
 *
 * Duas situações de responsabilidade: 1 - Comsumir requisicao e gerenciar a
 * producao de dados para integracao entre totem-servidor -> CadSus 2 - Produzir
 * a integracao de retorno para o Totem Desktop.
 *
 *
 * @author totem-servidor
 */
@WebService(serviceName = "TotemServidor")
public class TotemServidor {

    private static final Logger log = LogManager.getLogger(TotemServidor.class.getName());

    @EJB
    private IGenericServiceRemote iGenericServiceRemote;

    /**
     * http://localhost:8080/totem-servidor/TotemServidor?WSDL *
     */
    /**
     * Netbeans fornece um test para o WSDL, clicar no WS e 'Test Web Service' *
     */
    /**
     *
     * @param wrapper
     * @return
     */
    @WebMethod(operationName = "totemUsuarioObj")
    public TotemWrapperOut totemUsuarioObj(@WebParam(name = "parameterObj") TotemWrapperIn wrapper) {

        try {

            if (wrapper != null) {

                if (valida(wrapper)) {

                    log.info("Parâmetro entrada: " + wrapper.getNomePesquisa());

                    ServidorWsCadsusCobdn_Service service = new ServidorWsCadsusCobdn_Service();
                    ServidorWsCadsusCobdn port = service.getServidorWsCadsusCobdnPort();

                    RspConsultaUsuario result = null;
                    
                    if(wrapper.getSistema() != null 
                            && wrapper.getUsuario() != null 
                            && wrapper.getOperador() != null){
                        
                        result = port.consultar(wrapper.getSistema().getUsuario(),
                            wrapper.getSistema().getSenha(),
                            wrapper.getSistema().getCodigo(),
                            wrapper.getSistema().getBanco(),
                            wrapper.getSistema().getIbge(),
                            wrapper.getUsuario().getNome(),
                            wrapper.getUsuario().getSenha(),
                            wrapper.getOperador().getCns(),
                            wrapper.getOperador().getSenha(),
                            wrapper.getNomePesquisa(),
                            wrapper.getNomeMaePesquisa(),
                            wrapper.getNomePaiPesquisa(),
                            wrapper.getDataNascimentoPesquisa(),
                            wrapper.getCpfPesquisa(),
                            wrapper.getCnsPesquisa(),
                            wrapper.getModoConsulta().getCodigo(),
                            wrapper.getNumeroElementos());
                    }

                    Pessoa pessoa = null;

                    if (result != null
                            && result.getPessoas() != null
                            && !result.getPessoas().isEmpty()) {
                        pessoa = new Pessoa();
                        pessoa.setNome(result.getPessoas().get(0).getNome());
                        pessoa.setNomeSocial(result.getPessoas().get(0).getNomeSocial());
                        pessoa.setNumeroCns(result.getPessoas().get(0).getNumeroCns());
                        pessoa.setNomeMae(result.getPessoas().get(0).getNomeMae());
                        pessoa.setDataNascimento(result.getPessoas().get(0).getDataNascimento());
                        pessoa.setSexo(result.getPessoas().get(0).getSexo());
                    }

                    if(pessoa != null){
                        
                        try {
                            iGenericServiceRemote.salvar(pessoa);
                        } catch (Exception e) {

                            log.error("Falha capturada.", e);
                        }

                        return new TotemWrapperOut(pessoa);
                    }
                }
            }

        } catch (Exception ex) {
            log.error("Falha capturada.", ex);
        } finally {
            if(wrapper.getTotem() != null && wrapper.getTotem().getId() != null){
                iGenericServiceRemote.excluir(wrapper.getTotem().getId());
            }
        }

        return null;
    }

    @WebMethod(operationName = "testaConexaoWS")
    public Boolean testaConexaoWS(@WebParam(name = "parameterObj") TotemWrapperIn wrapper) {

        try {

            ServidorWsCadsusCobdn_Service service = new ServidorWsCadsusCobdn_Service();
            ServidorWsCadsusCobdn port = service.getServidorWsCadsusCobdnPort();

            if (wrapper != null) {
                Rsp resp = port.testaConexao(wrapper.getSistema().getUsuario(),
                        wrapper.getSistema().getSenha(),
                        wrapper.getSistema().getCodigo(),
                        wrapper.getSistema().getBanco(),
                        wrapper.getSistema().getIbge(),
                        wrapper.getUsuario().getNome(),
                        wrapper.getUsuario().getSenha(),
                        wrapper.getOperador().getCns(),
                        wrapper.getOperador().getSenha());

                if (resp != null && resp.getStatus() == 1) {
                    return Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            log.error("Falha capturada.", e);
        }

        return Boolean.FALSE;
    }

    private Boolean valida(TotemWrapperIn wrapper) {

        if (wrapper != null) {

            Object obj = null;
            
            if(wrapper.getTotem() != null 
                    && wrapper.getTotem().getId() != null){
                obj = iGenericServiceRemote.buscarObjetoPorId(Totem.class, wrapper.getTotem().getId());
            }else{
                return Boolean.TRUE;
            }
            
            if (obj != null) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
}