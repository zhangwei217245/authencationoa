/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
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

/**
 *
 * @author X-Spirit
 */
@Entity
@Table(name = "documentpath")
@NamedQueries({
    @NamedQuery(name = "Documentpath.findAll", query = "SELECT d FROM Documentpath d"),
    @NamedQuery(name = "Documentpath.findByNumpathid", query = "SELECT d FROM Documentpath d WHERE d.numpathid = :numpathid"),
    @NamedQuery(name = "Documentpath.findByNumstepindex", query = "SELECT d FROM Documentpath d WHERE d.numstepindex = :numstepindex"),
    @NamedQuery(name = "Documentpath.findByChverifiertype", query = "SELECT d FROM Documentpath d WHERE d.chverifiertype = :chverifiertype"),
    @NamedQuery(name = "Documentpath.findByTgIdAndDocType", query = "SELECT d FROM Documentpath d WHERE d.tgId = :tgId AND d.numdoctypeid = :numdoctypeid"),
    @NamedQuery(name = "Documentpath.findByDocType", query = "SELECT d FROM Documentpath d WHERE d.numdoctypeid = :numdoctypeid"),
    @NamedQuery(name = "Documentpath.findByVc2stepdesc", query = "SELECT d FROM Documentpath d WHERE d.vc2stepdesc = :vc2stepdesc")})
public class Documentpath implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numpathid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numpathid;
    @Basic(optional = false)
    @Column(name = "numstepindex", nullable = false)
    private int numstepindex;
    @Basic(optional = false)
    @Column(name = "chverifiertype", nullable = false)
    private char chverifiertype;
    @Column(name = "vc2stepdesc", length = 2000)
    private String vc2stepdesc;
    @JoinColumn(name = "numdoctypeid", referencedColumnName = "numtypeid", nullable = false)
    @ManyToOne(optional = false)
    private Documenttype numdoctypeid;
    @JoinColumn(name = "tg_id", referencedColumnName = "tg_id")
    @ManyToOne
    private TGroup tgId;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Vcustomer userid;

    public Documentpath() {
    }

    public Documentpath(Integer numpathid) {
        this.numpathid = numpathid;
    }

    public Documentpath(Integer numpathid, int numstepindex, char chverifiertype, String vc2stepdesc, Documenttype numdoctypeid, TGroup tgId, Vcustomer userid) {
        this.numpathid = numpathid;
        this.numstepindex = numstepindex;
        this.chverifiertype = chverifiertype;
        this.vc2stepdesc = vc2stepdesc;
        this.numdoctypeid = numdoctypeid;
        this.tgId = tgId;
        this.userid = userid;
    }

    public Integer getNumpathid() {
        return numpathid;
    }

    public void setNumpathid(Integer numpathid) {
        this.numpathid = numpathid;
    }

    public int getNumstepindex() {
        return numstepindex;
    }

    public void setNumstepindex(int numstepindex) {
        this.numstepindex = numstepindex;
    }

    public char getChverifiertype() {
        return chverifiertype;
    }

    public void setChverifiertype(char chverifiertype) {
        this.chverifiertype = chverifiertype;
    }

    public String getVc2stepdesc() {
        return vc2stepdesc;
    }

    public void setVc2stepdesc(String vc2stepdesc) {
        this.vc2stepdesc = vc2stepdesc;
    }

    public Documenttype getNumdoctypeid() {
        return numdoctypeid;
    }

    public void setNumdoctypeid(Documenttype numdoctypeid) {
        this.numdoctypeid = numdoctypeid;
    }

    public TGroup getTgId() {
        return tgId;
    }

    public void setTgId(TGroup tgId) {
        this.tgId = tgId;
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
        hash += (numpathid != null ? numpathid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentpath)) {
            return false;
        }
        Documentpath other = (Documentpath) object;
        if ((this.numpathid == null && other.numpathid != null) || (this.numpathid != null && !this.numpathid.equals(other.numpathid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Documentpath[numpathid=" + numpathid + "]";
    }
}
