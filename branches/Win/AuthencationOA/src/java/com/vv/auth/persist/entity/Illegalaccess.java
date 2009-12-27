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
@Table(name = "illegalaccess", catalog = "dbo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Illegalaccess.findAll", query = "SELECT i FROM Illegalaccess i"),
    @NamedQuery(name = "Illegalaccess.findByNumilgacsid", query = "SELECT i FROM Illegalaccess i WHERE i.numilgacsid = :numilgacsid"),
    @NamedQuery(name = "Illegalaccess.findByDataccesstime", query = "SELECT i FROM Illegalaccess i WHERE i.dataccesstime = :dataccesstime")
})
public class Illegalaccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numilgacsid", nullable = false)
    private Integer numilgacsid;
    @Basic(optional = false)
    @Column(name = "dataccesstime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataccesstime;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Vcustomer userid;
    @JoinColumn(name = "tr_id", referencedColumnName = "tr_id")
    @ManyToOne
    private TRight trId;

    public Illegalaccess() {
    }

    public Illegalaccess(Date dataccesstime, Vcustomer userid, TRight trId) {
        this.dataccesstime = dataccesstime;
        this.userid = userid;
        this.trId = trId;
    }


    public Illegalaccess(Integer numilgacsid) {
        this.numilgacsid = numilgacsid;
    }

    public Illegalaccess(Integer numilgacsid, Date dataccesstime) {
        this.numilgacsid = numilgacsid;
        this.dataccesstime = dataccesstime;
    }

    public Integer getNumilgacsid() {
        return numilgacsid;
    }

    public void setNumilgacsid(Integer numilgacsid) {
        this.numilgacsid = numilgacsid;
    }

    public Date getDataccesstime() {
        return dataccesstime;
    }

    public void setDataccesstime(Date dataccesstime) {
        this.dataccesstime = dataccesstime;
    }

    public Vcustomer getUserid() {
        return userid;
    }

    public void setUserid(Vcustomer userid) {
        this.userid = userid;
    }

    public TRight getTrId() {
        return trId;
    }

    public void setTrId(TRight trId) {
        this.trId = trId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numilgacsid != null ? numilgacsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Illegalaccess)) {
            return false;
        }
        Illegalaccess other = (Illegalaccess) object;
        if ((this.numilgacsid == null && other.numilgacsid != null) || (this.numilgacsid != null && !this.numilgacsid.equals(other.numilgacsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Illegalaccess[numilgacsid=" + numilgacsid + "]";
    }

}
