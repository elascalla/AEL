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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "TB_ACESSO")
@NamedQueries({
    @NamedQuery(name = "Acesso.recuperaAcessoPorHashAndChave", query = "SELECT a FROM Acesso a WHERE a.hash = :hash AND a.chave = :chave")
})
public class Acesso implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "HASH")
    private Integer hash;

    @Column(name = "CHAVE")
    private String chave;
    
    @Column(name = "DATA_ACESSO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAcesso;
    
    public Acesso() {
    }

    public Acesso(Integer hash, String chave, Date dataAcesso) {
        this.hash       = hash;
        this.chave      = chave;
        this.dataAcesso = dataAcesso;
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

    public Integer getHash() {
        return hash;
    }

    public void setHash(Integer hash) {
        this.hash = hash;
    }

    public Date getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Date dataAcesso) {
        this.dataAcesso = dataAcesso;
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
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.TabelaAcesso[ id=" + id + " ]";
    }
}
