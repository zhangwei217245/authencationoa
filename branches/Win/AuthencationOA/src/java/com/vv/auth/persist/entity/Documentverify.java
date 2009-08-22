/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author X-Spirit
 */
@Entity
@Table(name = "documentverify")
@NamedQueries({@NamedQuery(name = "Documentverify.findAll", query = "SELECT d FROM Documentverify d"), @NamedQuery(name = "Documentverify.findByNumverifyid", query = "SELECT d FROM Documentverify d WHERE d.numverifyid = :numverifyid"), @NamedQuery(name = "Documentverify.findByChresult", query = "SELECT d FROM Documentverify d WHERE d.chresult = :chresult"), @NamedQuery(name = "Documentverify.findByVc2message", query = "SELECT d FROM Documentverify d WHERE d.vc2message = :vc2message"), @NamedQuery(name = "Documentverify.findByDattime", query = "SELECT d FROM Documentverify d WHERE d.dattime = :dattime"), @NamedQuery(name = "Documentverify.findByNumstepindex", query = "SELECT d FROM Documentverify d WHERE d.numstepindex = :numstepindex")})
public class Documentverify implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numverifyid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numverifyid;
    @Column(name = "chresult")
    private Character chresult;
    @Column(name = "vc2message", length = 2000)
    private String vc2message;
    @Column(name = "dattime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dattime;
    @Column(name = "numstepindex")
    private Integer numstepindex;
    @JoinColumn(name = "numdocid", referencedColumnName = "numdocid")
    @ManyToOne
    private Document numdocid;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Vcustomer userid;

    public Documentverify() {
    }

    public Documentverify(Integer numverifyid) {
        this.numverifyid = numverifyid;
    }

    public Integer getNumverifyid() {
        return numverifyid;
    }

    public void setNumverifyid(Integer numverifyid) {
        this.numverifyid = numverifyid;
    }

    public Character getChresult() {
        return chresult;
    }

    public void setChresult(Character chresult) {
        this.chresult = chresult;
    }

    public String getVc2message() {
        return vc2message;
    }

    public void setVc2message(String vc2message) {
        this.vc2message = vc2message;
    }

    public Date getDattime() {
        return dattime;
    }

    public void setDattime(Date dattime) {
        this.dattime = dattime;
    }

    public Integer getNumstepindex() {
        return numstepindex;
    }

    public void setNumstepindex(Integer numstepindex) {
        this.numstepindex = numstepindex;
    }

    public Document getNumdocid() {
        return numdocid;
    }

    public void setNumdocid(Document numdocid) {
        this.numdocid = numdocid;
    }

    public Vcustomer getUserid() {
        return userid;
    }

    public void setUserid(Vcustomer userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numverifyid != null ? numverifyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentverify)) {
            return false;
        }
        Documentverify other = (Documentverify) object;
        if ((this.numverifyid == null && other.numverifyid != null) || (this.numverifyid != null && !this.numverifyid.equals(other.numverifyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Documentverify[numverifyid=" + numverifyid + "]";
    }
}
