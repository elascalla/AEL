/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.wrapper;

import br.com.totem.entity.Acesso;
import java.io.Serializable;

/**
 *
 * Wrapper responsável por receber dados para integração.
 * 
 * @author totem-servidor
 */
public class TotemWrapperIn implements Serializable{
    
    private Acesso acesso;
    
    private Sistema sistema;
    
    private Operador operador;
    
    private Usuario usuario;
    
    private String nomePesquisa; /** Nome Usuário **/
    
    private String nomeMaePesquisa; /** Mãe Usuário **/
    
    private String nomePaiPesquisa; /** Pai Usuário **/
    
    private String dataNascimentoPesquisa; /** Data Nascimento Usuário **/
    
    private String cpfPesquisa; /** CPF Usuário **/
    
    private String cnsPesquisa; /** CNS Usuário **/
    
    private ModoConsultaEnum modoConsulta; 
    
    private Integer numeroElementos;

    public TotemWrapperIn() {
    }

    public TotemWrapperIn(Usuario usuario) {
        this.usuario = usuario;
    }

    public TotemWrapperIn(Acesso acesso, Sistema sistema, Operador operador, Usuario usuario, String nomePesquisa, 
        String nomeMaePesquisa, String nomePaiPesquisa, String dataNascimentoPesquisa, String cpfPesquisa, 
        String cnsPesquisa, ModoConsultaEnum modoConsulta, Integer numeroElementos) {
        
        this.acesso                 = acesso;
        this.sistema                = sistema;
        this.operador               = operador;
        this.usuario                = usuario;
        this.nomePesquisa           = nomePesquisa;
        this.nomeMaePesquisa        = nomeMaePesquisa;
        this.nomePaiPesquisa        = nomePaiPesquisa;
        this.dataNascimentoPesquisa = dataNascimentoPesquisa;
        this.cpfPesquisa            = cpfPesquisa;
        this.cnsPesquisa            = cnsPesquisa;
        this.modoConsulta           = modoConsulta;
        this.numeroElementos        = numeroElementos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    public String getNomeMaePesquisa() {
        return nomeMaePesquisa;
    }

    public void setNomeMaePesquisa(String nomeMaePesquisa) {
        this.nomeMaePesquisa = nomeMaePesquisa;
    }

    public String getNomePaiPesquisa() {
        return nomePaiPesquisa;
    }

    public void setNomePaiPesquisa(String nomePaiPesquisa) {
        this.nomePaiPesquisa = nomePaiPesquisa;
    }

    public String getDataNascimentoPesquisa() {
        return dataNascimentoPesquisa;
    }

    public void setDataNascimentoPesquisa(String dataNascimentoPesquisa) {
        this.dataNascimentoPesquisa = dataNascimentoPesquisa;
    }

    public String getCpfPesquisa() {
        return cpfPesquisa;
    }

    public void setCpfPesquisa(String cpfPesquisa) {
        this.cpfPesquisa = cpfPesquisa;
    }

    public String getCnsPesquisa() {
        return cnsPesquisa;
    }

    public void setCnsPesquisa(String cnsPesquisa) {
        this.cnsPesquisa = cnsPesquisa;
    }

    public ModoConsultaEnum getModoConsulta() {
        return modoConsulta;
    }

    public void setModoConsulta(ModoConsultaEnum modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    public Integer getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(Integer numeroElementos) {
        this.numeroElementos = numeroElementos;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }
}