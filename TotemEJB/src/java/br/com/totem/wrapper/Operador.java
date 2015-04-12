/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.wrapper;

import br.com.totem.entity.*;
import java.io.Serializable;

/**
 *
 * @author totem-servidor
 */
public class Operador implements Serializable {
    
    private String cns;
    
    private String senha;

    public Operador() {
    }

    public Operador(String cns, String senha) {
        this.cns = cns;
        this.senha = senha;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
