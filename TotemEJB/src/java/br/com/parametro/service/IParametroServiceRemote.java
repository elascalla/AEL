/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.parametro.service;

import br.com.entidade.Parametro;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface IParametroServiceRemote {
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception;
    
}
