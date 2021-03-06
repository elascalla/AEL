/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.service;

import br.com.entity.Acesso;
import br.com.entity.Parametro;
import br.com.wrapper.FalhaWrapper;
import javax.ejb.Remote;

/**
 *
 * @author ericka
 */
@Remote
public interface ITotemService {
    
    public void inclui(Object object) throws Exception;
    
    public Object altera(Object object) throws Exception;
    
    public void exclui(Class classObject, Long idObjectDelete);
    
    public Object recupera(Class classObject, Object id);
    
    public Parametro recuperaParametroPorNome(String nome) throws Exception;
    
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception;
    
    public void registrarFalha(FalhaWrapper falhaWrapper);
}
