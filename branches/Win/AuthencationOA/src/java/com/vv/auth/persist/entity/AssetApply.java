/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author X-Spirit
 */
@Entity
@Table(name = "AssetApply")
@NamedQueries({@NamedQuery(name = "AssetApply.findAll", query = "SELECT a FROM AssetApply a"), @NamedQuery(name = "AssetApply.findByNumapplyid", query = "SELECT a FROM AssetApply a WHERE a.numapplyid = :numapplyid"), @NamedQuery(name = "AssetApply.findByVc2assetname", query = "SELECT a FROM AssetApply a WHERE a.vc2assetname = :vc2assetname"), @NamedQuery(name = "AssetApply.findByNumstockcount", query = "SELECT a FROM AssetApply a WHERE a.numstockcount = :numstockcount"), @NamedQuery(name = "AssetApply.findByNumunitprice", query = "SELECT a FROM AssetApply a WHERE a.numunitprice = :numunitprice"), @NamedQuery(name = "AssetApply.findByNumtotalcount", query = "SELECT a FROM AssetApply a WHERE a.numtotalcount = :numtotalcount"), @NamedQuery(name = "AssetApply.findByVc2status", query = "SELECT a FROM AssetApply a WHERE a.vc2status = :vc2status"), @NamedQuery(name = "AssetApply.findByVc2txtinfo", query = "SELECT a FROM AssetApply a WHERE a.vc2txtinfo = :vc2txtinfo"), @NamedQuery(name = "AssetApply.findByNumapplierid", query = "SELECT a FROM AssetApply a WHERE a.numapplierid = :numapplierid"), @NamedQuery(name = "AssetApply.findByNumverifierid", query = "SELECT a FROM AssetApply a WHERE a.numverifierid = :numverifierid")})
public class AssetApply implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numapplyid", nullable = false)
    private Integer numapplyid;
    @Basic(optional = false)
    @Column(name = "vc2assetname", nullable = false, length = 200)
    private String vc2assetname;
    @Basic(optional = false)
    @Column(name = "numstockcount", nullable = false)
    private int numstockcount;
    @Basic(optional = false)
    @Column(name = "numunitprice", nullable = false)
    private int numunitprice;
    @Basic(optional = false)
    @Column(name = "numtotalcount", nullable = false)
    private int numtotalcount;
    @Basic(optional = false)
    @Column(name = "vc2status", nullable = false, length = 1)
    private String vc2status;
    @Column(name = "vc2txtinfo", length = 500)
    private String vc2txtinfo;
    @Column(name = "numapplierid")
    private Integer numapplierid;
    @Column(name = "numverifierid")
    private Integer numverifierid;

    public AssetApply() {
    }

    public AssetApply(Integer numapplyid) {
        this.numapplyid = numapplyid;
    }

    public AssetApply(Integer numapplyid, String vc2assetname, int numstockcount, int numunitprice, int numtotalcount, String vc2status) {
        this.numapplyid = numapplyid;
        this.vc2assetname = vc2assetname;
        this.numstockcount = numstockcount;
        this.numunitprice = numunitprice;
        this.numtotalcount = numtotalcount;
        this.vc2status = vc2status;
    }

    public Integer getNumapplyid() {
        return numapplyid;
    }

    public void setNumapplyid(Integer numapplyid) {
        this.numapplyid = numapplyid;
    }

    public String getVc2assetname() {
        return vc2assetname;
    }

    public void setVc2assetname(String vc2assetname) {
        this.vc2assetname = vc2assetname;
    }

    public int getNumstockcount() {
        return numstockcount;
    }

    public void setNumstockcount(int numstockcount) {
        this.numstockcount = numstockcount;
    }

    public int getNumunitprice() {
        return numunitprice;
    }

    public void setNumunitprice(int numunitprice) {
        this.numunitprice = numunitprice;
    }

    public int getNumtotalcount() {
        return numtotalcount;
    }

    public void setNumtotalcount(int numtotalcount) {
        this.numtotalcount = numtotalcount;
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

    public Integer getNumapplierid() {
        return numapplierid;
    }

    public void setNumapplierid(Integer numapplierid) {
        this.numapplierid = numapplierid;
    }

    public Integer getNumverifierid() {
        return numverifierid;
    }

    public void setNumverifierid(Integer numverifierid) {
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
        if (!(object instanceof AssetApply)) {
            return false;
        }
        AssetApply other = (AssetApply) object;
        if ((this.numapplyid == null && other.numapplyid != null) || (this.numapplyid != null && !this.numapplyid.equals(other.numapplyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.AssetApply[numapplyid=" + numapplyid + "]";
    }
}
