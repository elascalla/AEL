/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.totem.wrapper;

import br.com.totem.entity.Pessoa;
import java.util.Date;

/**
 *
 * Wrapper responsável por enviar dados para integração.
 * 
 * @author totem-servidor
 */
public class TotemWrapperOut {
    
    private Pessoa pessoa;
    
    private Sistema sistema;
    
    private Operador operador;
    
    private Usuario usuario;
    
    private String nomePesquisa; /** Nome Usuário **/
    
    private String nomeMaePesquisa; /** Mãe Usuário **/
    
    private String nomePaiPesquisa; /** Pai Usuário **/
    
    private Date dataNascimentoPesquisa; /** Data Nascimento Usuário **/
    
    private String cpfPesquisa; /** CPF Usuário **/
    
    private String cnsPesquisa; /** CNS Usuário **/
    
    private ModoConsultaEnum modoConsulta; 
    
    private Integer numeroElementos;

    public TotemWrapperOut() {
    }

    public TotemWrapperOut(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public TotemWrapperOut(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TotemWrapperOut(Pessoa pessoa, Sistema sistema, Operador operador, Usuario usuario, String nomePesquisa, String nomeMaePesquisa, String nomePaiPesquisa, Date dataNascimentoPesquisa, String cpfPesquisa, String cnsPesquisa, ModoConsultaEnum modoConsulta, Integer numeroElementos) {
        this.pessoa = pessoa;
        this.sistema = sistema;
        this.operador = operador;
        this.usuario = usuario;
        this.nomePesquisa = nomePesquisa;
        this.nomeMaePesquisa = nomeMaePesquisa;
        this.nomePaiPesquisa = nomePaiPesquisa;
        this.dataNascimentoPesquisa = dataNascimentoPesquisa;
        this.cpfPesquisa = cpfPesquisa;
        this.cnsPesquisa = cnsPesquisa;
        this.modoConsulta = modoConsulta;
        this.numeroElementos = numeroElementos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public Date getDataNascimentoPesquisa() {
        return dataNascimentoPesquisa;
    }

    public void setDataNascimentoPesquisa(Date dataNascimentoPesquisa) {
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
}
