/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao;

import br.com.totem.entity.Acesso;

/**
 *
 * @author ericka
 */
public interface IAcessoDao {
    
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception;
}