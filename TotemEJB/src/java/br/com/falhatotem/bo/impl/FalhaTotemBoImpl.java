/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.falhatotem.bo.impl;

import br.com.falhatotem.bo.IFalhaTotemBoRemote;
import br.com.falhatotem.dao.IFalhaTotemDaoRemote;
import br.com.falhatotem.entity.FalhaTotem;
import br.com.generic.service.IGenericServiceRemote;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IFalhaTotemBoRemote.class)
public class FalhaTotemBoImpl implements IFalhaTotemBoRemote{

    @EJB(beanName = "FalhaTotemDaoImpl")
    private IFalhaTotemDaoRemote iFalhaDaoRemote;

    @EJB(beanName = "GenericServiceImpl")
    private IGenericServiceRemote genericService;
    
    @Override
    public FalhaTotem salvar(FalhaTotem falha) throws Exception {
        return (FalhaTotem) genericService.salvar(falha);
    }
    
}
