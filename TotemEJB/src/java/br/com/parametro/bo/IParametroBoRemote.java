/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.parametro.bo;

import br.com.entidade.Parametro;

/**
 *
 * @author ericka
 */
public interface IParametroBoRemote {
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception;
    
}
