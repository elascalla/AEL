/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "TB_FALHA")
public class Falha implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CHAVE")
    private String chave;

    @Column(name = "MENSAGEM")
    private String mensagem;
    
    @Column(name = "STACK_TRACE")
    private String stackTrace;
    
    @Column(name = "DATA_FALHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFalha;
    
    public Falha() {
    }

    public Falha(String chave, String mensagem, String stackTrace, Date dataFalha) {
        this.chave      = chave;
        this.mensagem   = mensagem;
        this.stackTrace = stackTrace;
        this.dataFalha  = dataFalha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Date getDataFalha() {
        return dataFalha;
    }

    public void setDataFalha(Date dataFalha) {
        this.dataFalha = dataFalha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Falha)) {
            return false;
        }
        Falha other = (Falha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Falha[ id=" + id + " ]";
    }
}