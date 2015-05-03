/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wrapper;

/**
 *
 * @author totem-servidor
 */
public enum ModoConsultaEnum {
    
    _001("001")
    ;
    
    private final String codigo;
    
    ModoConsultaEnum(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
