/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.dao.impl;

import br.com.totem.dao.ITotemDao;
import br.com.totem.entity.Pessoa;
import br.com.util.TotemUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author ericka
 */
public class TotemDaoImpl implements ITotemDao {
    
    @Override
    public Boolean validaPeriodoImpressaoTotem(EntityManager em, String cpfCnpj, Integer quantidade) throws Exception {
        
        if(em != null 
                && !TotemUtil.ehBrancoOrNulo(cpfCnpj)
                && quantidade != null){
            
            Pessoa pessoa = (Pessoa) em.find(Pessoa.class, cpfCnpj);
            
            if(pessoa != null){
//                Long dias = TotemUtil.quantidadeDiasAtual(pessoa.getDataImpressao());
//                if(dias <= 360){
//                    return Boolean.FALSE;
//                }else{
//                    return Boolean.TRUE;
//                }
            }
        }
        
        return Boolean.FALSE;
    }
}
