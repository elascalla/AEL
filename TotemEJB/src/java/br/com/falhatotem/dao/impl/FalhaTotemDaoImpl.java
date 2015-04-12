/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.falhatotem.dao.impl;

import br.com.falhatotem.dao.IFalhaTotemDaoRemote;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author ericka
 */
@Stateless
@Remote(IFalhaTotemDaoRemote.class)
public class FalhaTotemDaoImpl implements IFalhaTotemDaoRemote {
    
}
