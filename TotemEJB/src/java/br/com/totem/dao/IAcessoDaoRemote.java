/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao;

import br.com.totem.entity.Acesso;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IAcessoDaoRemote {
    
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception;
}
