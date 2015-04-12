/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wrapper;

/**
 *
 * @author Andre
 */
public class TotemEmailWrapper {
    
    private String titulo;
    
    private String corpo;
    
    private String adicional;

    public TotemEmailWrapper() {
    }
    
    public TotemEmailWrapper(String titulo, String corpo, String adicional) {
        this.titulo     = titulo;
        this.corpo      = corpo;
        this.adicional  = adicional;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }
}