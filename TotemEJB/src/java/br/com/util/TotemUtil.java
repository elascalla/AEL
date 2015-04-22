/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    
    public static Integer quantidadeDiasAtualNoAno() {
        return Calendar.DAY_OF_YEAR;
    }
    
    public static long quantidadeDiasAtual(Date data) {
        
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy"); 
        
        Date d1 = null;   
        Date d2 = null;
        
        try {  
                if(data != null){
                    d1 = data;
                }else{
                    d1 = df.parse ("01/01/" + Calendar.getInstance().getTime().getYear());
                }
                
                d2 = Calendar.getInstance().getTime();
                
        } catch (java.text.ParseException evt ) {
            evt.printStackTrace();
        }  
        
        long dt = (d2.getTime() - d1.getTime()) + 3600000;        
        long dias = (dt / 86400000L);
        
        return dias;
    }
}