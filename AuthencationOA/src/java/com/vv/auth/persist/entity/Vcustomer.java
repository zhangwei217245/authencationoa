/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.ManyToMany;
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
@Table(name = "vcustomer")
@NamedQueries({@NamedQuery(name = "Vcustomer.findAll", query = "SELECT v FROM Vcustomer v"),
    @NamedQuery(name = "Vcustomer.findByUserid", query = "SELECT v FROM Vcustomer v WHERE v.userid = :userid"),
    @NamedQuery(name = "Vcustomer.findByName", query = "SELECT v FROM Vcustomer v WHERE v.name = :name"),
    @NamedQuery(name = "Vcustomer.findEnableByName", query = "SELECT v FROM Vcustomer v WHERE v.name = :name AND v.enable='Y'"),
    @NamedQuery(name = "Vcustomer.findByDepartname", query = "SELECT v FROM Vcustomer v WHERE v.departname = :departname"),
    @NamedQuery(name = "Vcustomer.findByOname", query = "SELECT v FROM Vcustomer v WHERE v.oname = :oname"),
    @NamedQuery(name = "Vcustomer.findByCname", query = "SELECT v FROM Vcustomer v WHERE v.cname = :cname"),
    @NamedQuery(name = "Vcustomer.findByPname", query = "SELECT v FROM Vcustomer v WHERE v.pname = :pname"),
    @NamedQuery(name = "Vcustomer.findByCtname", query = "SELECT v FROM Vcustomer v WHERE v.ctname = :ctname"),
    @NamedQuery(name = "Vcustomer.findByDday", query = "SELECT v FROM Vcustomer v WHERE v.dday = :dday"),
    @NamedQuery(name = "Vcustomer.findByDdaybeg", query = "SELECT v FROM Vcustomer v WHERE v.ddaybeg = :ddaybeg"),
    @NamedQuery(name = "Vcustomer.findByDdayover", query = "SELECT v FROM Vcustomer v WHERE v.ddayover = :ddayover"),
    @NamedQuery(name = "Vcustomer.findByPassword", query = "SELECT v FROM Vcustomer v WHERE v.password = :password")})
public class Vcustomer implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Basic(optional = false)
    @Column(name = "departname", nullable = false, length = 64)
    private String departname;
    @Basic(optional = false)
    @Column(name = "oname", nullable = false, length = 64)
    private String oname;
    @Basic(optional = false)
    @Column(name = "cname", nullable = false, length = 64)
    private String cname;
    @Basic(optional = false)
    @Column(name = "pname", nullable = false, length = 64)
    private String pname;
    @Basic(optional = false)
    @Column(name = "ctname", nullable = false, length = 64)
    private String ctname;
    @Basic(optional = false)
    @Column(name = "dday", nullable = false, length = 64)
    private String dday;
    @Basic(optional = false)
    @Column(name = "ddaybeg", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ddaybeg;
    @Basic(optional = false)
    @Column(name = "ddayover", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ddayover;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Basic(optional = false)
    @Column(name = "verifystatus", nullable = false, length = 1)
    private String verifystatus;
    @Basic(optional = false)
    @Column(name = "enable", nullable = false, length = 1)
    private String enable;
    @ManyToMany(mappedBy = "vcustomerCollection", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<TGroup> tGroupCollection = new HashSet<TGroup>();

    public Vcustomer() {
    }

    public Vcustomer(Integer userid) {
        this.userid = userid;
    }

    public Vcustomer(Integer userid, String name, String departname, String oname, String cname, String pname, String ctname, String dday, Date ddaybeg, Date ddayover, String password, String verifystatus) {
        this.userid = userid;
        this.name = name;
        this.departname = departname;
        this.oname = oname;
        this.cname = cname;
        this.pname = pname;
        this.ctname = ctname;
        this.dday = dday;
        this.ddaybeg = ddaybeg;
        this.ddayover = ddayover;
        this.password = password;
        this.verifystatus = verifystatus;
        this.enable = "Y";
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getDday() {
        return dday;
    }

    public void setDday(String dday) {
        this.dday = dday;
    }

    public Date getDdaybeg() {
        return ddaybeg;
    }

    public void setDdaybeg(Date ddaybeg) {
        this.ddaybeg = ddaybeg;
    }

    public Date getDdayover() {
        return ddayover;
    }

    public void setDdayover(Date ddayover) {
        this.ddayover = ddayover;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifystatus() {
        return verifystatus;
    }

    public void setVerifystatus(String verifystatus) {
        this.verifystatus = verifystatus;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    
    public Set<TGroup> getTGroupCollection() {
        return tGroupCollection;
    }

    public void setTGroupCollection(Set<TGroup> tGroupCollection) {
        this.tGroupCollection = tGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vcustomer)) {
            return false;
        }
        Vcustomer other = (Vcustomer) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Vcustomer[userid=" + userid + "]";
    }
}
