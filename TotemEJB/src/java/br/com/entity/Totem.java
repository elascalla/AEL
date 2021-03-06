/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ericka
 */
@Entity
public class Totem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "iptotem")
    private String ipTotem;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpTotem() {
        return ipTotem;
    }

    public void setIpTotem(String ipTotem) {
        this.ipTotem = ipTotem;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIpTotem() != null ? getIpTotem().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Totem)) {
            return false;
        }
        Totem other = (Totem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Totem[ id=" + id + " ]";
    }
    
}
