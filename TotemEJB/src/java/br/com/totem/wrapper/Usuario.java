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
 * Entidade responsável por encapsular dados do usuário para integração Web Service.
 * 
 * @author totem-servidor
 */
public class Usuario implements Serializable {
    
    private String nome;
    
    private String senha;
    
    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, String senha) {
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