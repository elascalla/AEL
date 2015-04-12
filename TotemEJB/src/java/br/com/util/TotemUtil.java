/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Andre
 */
public class TotemUtil {
    
    private static final Logger log = LogManager.getLogger(TotemUtil.class.getName());
    
    public static Boolean ehBrancoOrNulo(String valorStr){
        
        log.info("Entrou -> Método: ehBrancoOrNulo");
        
        return valorStr == null || valorStr.length() <= 0;
    }
}