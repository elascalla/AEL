/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.falhatotem.bo;

import br.com.falhatotem.entity.FalhaTotem;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IFalhaTotemBoRemote {
    
    public FalhaTotem salvar(FalhaTotem falha) throws Exception;
    
}
