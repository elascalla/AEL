/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wrapper;

import java.io.Serializable;

/**
 *
 * Entidade responsável por encapsular dados do usuário para integração Web Service.
 * 
 * @author totem-servidor
 */
public class UsuarioWrapper implements Serializable {
    
    private String nome;
    
    private String senha;
    
    public UsuarioWrapper() {
    }

    public UsuarioWrapper(String nome) {
        this.nome = nome;
    }

    public UsuarioWrapper(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}