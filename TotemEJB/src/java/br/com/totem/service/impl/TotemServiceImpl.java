/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.service.impl;

import br.com.totem.dao.IAcessoDao;
import br.com.totem.dao.IParametroDao;
import br.com.totem.dao.impl.AcessoDaoImpl;
import br.com.totem.dao.impl.ParametroDaoImpl;
import br.com.totem.entity.Acesso;
import br.com.totem.entity.Parametro;
import br.com.totem.service.ITotemServiceRemote;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(ITotemServiceRemote.class)
public class TotemServiceImpl implements ITotemServiceRemote {
    
    private final IAcessoDao iAcessoDao = new AcessoDaoImpl();
    
    private final IParametroDao iParametroDao = new ParametroDaoImpl();
    
    @Override
    public Acesso recuperaAcessoPorHashAndChave(Integer hash, String chave) throws Exception {
        return iAcessoDao.recuperaAcessoPorHashAndChave(hash, chave);
    }

    @Override
    public Parametro recuperaParametroPorNome(String nome) throws Exception {
        return iParametroDao.recuperaParametroPorNome(nome);
    }
    
}
