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
@Table(name = "ConferenceApply")
@NamedQueries({@NamedQuery(name = "ConferenceApply.findAll", query = "SELECT c FROM ConferenceApply c"), @NamedQuery(name = "ConferenceApply.findByNumapplyid", query = "SELECT c FROM ConferenceApply c WHERE c.numapplyid = :numapplyid"), @NamedQuery(name = "ConferenceApply.findByVc2name", query = "SELECT c FROM ConferenceApply c WHERE c.vc2name = :vc2name"), @NamedQuery(name = "ConferenceApply.findByVc2desc", query = "SELECT c FROM ConferenceApply c WHERE c.vc2desc = :vc2desc"), @NamedQuery(name = "ConferenceApply.findByDatbegintime", query = "SELECT c FROM ConferenceApply c WHERE c.datbegintime = :datbegintime"), @NamedQuery(name = "ConferenceApply.findByDatendtime", query = "SELECT c FROM ConferenceApply c WHERE c.datendtime = :datendtime"), @NamedQuery(name = "ConferenceApply.findByVc2status", query = "SELECT c FROM ConferenceApply c WHERE c.vc2status = :vc2status"), @NamedQuery(name = "ConferenceApply.findByVc2txtinfo", query = "SELECT c FROM ConferenceApply c WHERE c.vc2txtinfo = :vc2txtinfo")})
public class ConferenceApply implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numapplyid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numapplyid;
    @Basic(optional = false)
    @Column(name = "vc2name", nullable = false, length = 100)
    private String vc2name;
    @Column(name = "vc2desc", length = 1000)
    private String vc2desc;
    @Basic(optional = false)
    @Column(name = "datbegintime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datbegintime;
    @Basic(optional = false)
    @Column(name = "datendtime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datendtime;
    @Basic(optional = false)
    @Column(name = "vc2status", nullable = false, length = 1)
    private String vc2status;//P:待审核,Y:审核通过未开始,N:审核未通过,B:进行时;O:已结束
    @Column(name = "vc2txtinfo", length = 500)
    private String vc2txtinfo;
    @JoinColumn(name = "tg_id", referencedColumnName = "tg_id", nullable = false)
    @ManyToOne(optional = false)
    private TGroup tgId;
    @JoinColumn(name = "numapplierid", referencedColumnName = "userid")
    @ManyToOne
    private Vcustomer numapplierid;
    @JoinColumn(name = "numverifierid", referencedColumnName = "userid")
    @ManyToOne
    private Vcustomer numverifierid;

    public ConferenceApply() {
    }

    public ConferenceApply(Integer numapplyid) {
        this.numapplyid = numapplyid;
    }

    public ConferenceApply(String vc2name, String vc2desc, Date datbegintime, Date datendtime, String vc2status) {
        this.vc2name = vc2name;
        this.vc2desc = vc2desc;
        this.datbegintime = datbegintime;
        this.datendtime = datendtime;
        this.vc2status = vc2status;
    }

    public Integer getNumapplyid() {
        return numapplyid;
    }

    public void setNumapplyid(Integer numapplyid) {
        this.numapplyid = numapplyid;
    }

    public String getVc2name() {
        return vc2name;
    }

    public void setVc2name(String vc2name) {
        this.vc2name = vc2name;
    }

    public String getVc2desc() {
        return vc2desc;
    }

    public void setVc2desc(String vc2desc) {
        this.vc2desc = vc2desc;
    }

    public Date getDatbegintime() {
        return datbegintime;
    }

    public void setDatbegintime(Date datbegintime) {
        this.datbegintime = datbegintime;
    }

    public Date getDatendtime() {
        return datendtime;
    }

    public void setDatendtime(Date datendtime) {
        this.datendtime = datendtime;
    }

    public String getVc2status() {
        return vc2status;
    }

    public void setVc2status(String vc2status) {
        this.vc2status = vc2status;
    }

    public String getVc2txtinfo() {
        return vc2txtinfo;
    }

    public void setVc2txtinfo(String vc2txtinfo) {
        this.vc2txtinfo = vc2txtinfo;
    }

    public TGroup getTgId() {
        return tgId;
    }

    public void setTgId(TGroup tgId) {
        this.tgId = tgId;
    }

    public Vcustomer getNumapplierid() {
        return numapplierid;
    }

    public void setNumapplierid(Vcustomer numapplierid) {
        this.numapplierid = numapplierid;
    }

    public Vcustomer getNumverifierid() {
        return numverifierid;
    }

    public void setNumverifierid(Vcustomer numverifierid) {
        this.numverifierid = numverifierid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numapplyid != null ? numapplyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConferenceApply)) {
            return false;
        }
        ConferenceApply other = (ConferenceApply) object;
        if ((this.numapplyid == null && other.numapplyid != null) || (this.numapplyid != null && !this.numapplyid.equals(other.numapplyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.ConferenceApply[numapplyid=" + numapplyid + "]";
    }
}
