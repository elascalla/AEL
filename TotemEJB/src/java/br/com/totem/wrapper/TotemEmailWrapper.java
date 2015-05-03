/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.wrapper;

import br.com.totem.util.TotemUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andre
 */
public class TotemEmailWrapper {
    
    private String username;
    
    private String password;
    
    private String from;
    
    private List<String> listaTo;
    
    private String to;
    
    private String cc;
    
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

    public TotemEmailWrapper(String username, String password, String from, List<String> listaTo, String titulo, String corpo, String adicional) {
        
        this(titulo, corpo, adicional);
        
        this.username   = username;
        this.password   = password;
        this.from       = from;
        this.listaTo    = listaTo;
    }

    public TotemEmailWrapper(String username, String password, String from, String to, String titulo, String corpo, String adicional) {
        
        this(titulo, corpo, adicional);
        
        this.username   = username;
        this.password   = password;
        this.from       = from;
        this.to         = to;
    }

    public TotemEmailWrapper(String username, String password, String from, String to, String cc, String titulo, String corpo, String adicional) {
        
        this(username, password, from, to, titulo, corpo, adicional);
        
        this.cc = cc;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getListaTo() {
        return listaTo;
    }

    public void setListaTo(List<String> listaTo) {
        this.listaTo = listaTo;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    public static List<String> adequaListaTo(String to){
        
        List<String> lTo = new ArrayList<>();
        
        if(!TotemUtil.ehBrancoOrNulo(to)){
            lTo = Arrays.asList(to.split(","));
        }
        
        return lTo;
    }
}