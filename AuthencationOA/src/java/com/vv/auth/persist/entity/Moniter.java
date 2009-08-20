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
@Table(name = "moniter")
@NamedQueries({@NamedQuery(name = "Moniter.findAll", query = "SELECT m FROM Moniter m"),
    @NamedQuery(name = "Moniter.findByNummoniterid", query = "SELECT m FROM Moniter m WHERE m.nummoniterid = :nummoniterid"),
    @NamedQuery(name = "Moniter.findByDattime", query = "SELECT m FROM Moniter m WHERE m.dattime = :dattime"),
    @NamedQuery(name = "Moniter.findByVc2path", query = "SELECT m FROM Moniter m WHERE m.vc2path = :vc2path"),
    @NamedQuery(name = "Moniter.findByVc2parameter", query = "SELECT m FROM Moniter m WHERE m.vc2parameter = :vc2parameter"),
    @NamedQuery(name = "Moniter.findByVc2exception", query = "SELECT m FROM Moniter m WHERE m.vc2exception = :vc2exception")})
public class Moniter implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nummoniterid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nummoniterid;
    @Basic(optional = false)
    @Column(name = "dattime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dattime;
    @Basic(optional = false)
    @Column(name = "vc2path", nullable = false, length = 200)
    private String vc2path;
    @Basic(optional = false)
    @Column(name = "vc2parameter", nullable = false, length = 2000)
    private String vc2parameter;
    @Column(name = "vc2exception", length = 2000)
    private String vc2exception;
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private Vcustomer userid;

    public Moniter() {
    }

    public Moniter(Integer nummoniterid) {
        this.nummoniterid = nummoniterid;
    }

    public Moniter(Integer nummoniterid, Vcustomer userid, Date dattime, String vc2path, String vc2parameter, String vc2exception) {
        this.nummoniterid = nummoniterid;
        this.userid = userid;
        this.dattime = dattime;
        this.vc2path = vc2path;
        this.vc2parameter = vc2parameter;
        this.vc2exception = vc2exception;
    }

    public Integer getNummoniterid() {
        return nummoniterid;
    }

    public void setNummoniterid(Integer nummoniterid) {
        this.nummoniterid = nummoniterid;
    }

    public Date getDattime() {
        return dattime;
    }

    public void setDattime(Date dattime) {
        this.dattime = dattime;
    }

    public String getVc2path() {
        return vc2path;
    }

    public void setVc2path(String vc2path) {
        this.vc2path = vc2path;
    }

    public String getVc2parameter() {
        return vc2parameter;
    }

    public void setVc2parameter(String vc2parameter) {
        this.vc2parameter = vc2parameter;
    }

    public String getVc2exception() {
        return vc2exception;
    }

    public void setVc2exception(String vc2exception) {
        this.vc2exception = vc2exception;
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
        hash += (nummoniterid != null ? nummoniterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moniter)) {
            return false;
        }
        Moniter other = (Moniter) object;
        if ((this.nummoniterid == null && other.nummoniterid != null) || (this.nummoniterid != null && !this.nummoniterid.equals(other.nummoniterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Moniter[nummoniterid=" + nummoniterid + "]";
    }
}
