/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.bo;

import br.com.totem.entity.Acesso;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IAcessoBoRemote {
 
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception;
}
