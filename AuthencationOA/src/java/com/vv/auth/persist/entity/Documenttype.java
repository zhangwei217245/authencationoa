/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author X-Spirit
 */
@Entity
@Table(name = "documenttype")
@NamedQueries({@NamedQuery(name = "Documenttype.findAll", query = "SELECT d FROM Documenttype d"), @NamedQuery(name = "Documenttype.findByNumtypeid", query = "SELECT d FROM Documenttype d WHERE d.numtypeid = :numtypeid"), @NamedQuery(name = "Documenttype.findByVc2name", query = "SELECT d FROM Documenttype d WHERE d.vc2name = :vc2name")})
public class Documenttype implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numtypeid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numtypeid;
    @Column(name = "vc2name", length = 50)
    private String vc2name;
    @OneToMany(mappedBy = "numtypeid",fetch=FetchType.EAGER)
    private Set<Document> documentCollection = new HashSet<Document>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numdoctypeid",fetch=FetchType.EAGER)
    private Set<Documentpath> documentpathCollection = new HashSet<Documentpath>();

    public Documenttype() {
    }

    public Documenttype(Integer numtypeid) {
        this.numtypeid = numtypeid;
    }

    public Documenttype(String vc2name) {
        this.vc2name = vc2name;
    }

    public Integer getNumtypeid() {
        return numtypeid;
    }

    public void setNumtypeid(Integer numtypeid) {
        this.numtypeid = numtypeid;
    }

    public String getVc2name() {
        return vc2name;
    }

    public void setVc2name(String vc2name) {
        this.vc2name = vc2name;
    }

    public Set<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Set<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    public Set<Documentpath> getDocumentpathCollection() {
        return documentpathCollection;
    }

    public void setDocumentpathCollection(Set<Documentpath> documentpathCollection) {
        this.documentpathCollection = documentpathCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numtypeid != null ? numtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documenttype)) {
            return false;
        }
        Documenttype other = (Documenttype) object;
        if ((this.numtypeid == null && other.numtypeid != null) || (this.numtypeid != null && !this.numtypeid.equals(other.numtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Documenttype[numtypeid=" + numtypeid + "]";
    }
}
