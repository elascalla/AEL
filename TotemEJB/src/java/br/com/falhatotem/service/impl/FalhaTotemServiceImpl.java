/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.falhatotem.service.impl;

import br.com.falhatotem.bo.IFalhaTotemBoRemote;
import br.com.falhatotem.entity.FalhaTotem;
import br.com.falhatotem.service.IFalhaTotemServiceRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IFalhaTotemServiceRemote.class)
public class FalhaTotemServiceImpl implements IFalhaTotemServiceRemote{
    
    @EJB(beanName = "FalhaTotemBoImpl")
    private IFalhaTotemBoRemote iFalhaTotemBoRemote;
    
    @Override
    public FalhaTotem salvar (FalhaTotem falha) throws Exception {
        return iFalhaTotemBoRemote.salvar(falha);
    }
}
