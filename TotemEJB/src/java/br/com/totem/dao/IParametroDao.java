/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao;

import br.com.totem.entity.Parametro;

/**
 *
 * @author ericka
 */
public interface IParametroDao {
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception;
}
