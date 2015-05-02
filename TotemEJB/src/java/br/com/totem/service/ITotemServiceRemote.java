/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.service;

import br.com.totem.entity.Acesso;
import br.com.totem.entity.Parametro;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface ITotemServiceRemote {
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception;
    
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception;
}
