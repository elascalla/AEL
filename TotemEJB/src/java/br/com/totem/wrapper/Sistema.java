/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.wrapper;

import java.io.Serializable;

/**
 *
 * @author totem-servidor
 */
public class Sistema implements Serializable {
    
    private String usuario;
    
    private String senha;
    
    private String codigo;
    
    private String banco;
    
    private String ibge;

    public Sistema() {
    }

    public Sistema(String usuario, String senha, String codigo, String banco, String ibge) {
        this.usuario    = usuario;
        this.senha      = senha;
        this.codigo     = codigo;
        this.banco      = banco;
        this.ibge       = ibge;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
}