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
@Table(name = "rcustomer")
@NamedQueries({@NamedQuery(name = "Rcustomer.findAll", query = "SELECT r FROM Rcustomer r"), @NamedQuery(name = "Rcustomer.findByUserid", query = "SELECT r FROM Rcustomer r WHERE r.userid = :userid"), @NamedQuery(name = "Rcustomer.findByName", query = "SELECT r FROM Rcustomer r WHERE r.name = :name"), @NamedQuery(name = "Rcustomer.findByDepartname", query = "SELECT r FROM Rcustomer r WHERE r.departname = :departname"), @NamedQuery(name = "Rcustomer.findByOname", query = "SELECT r FROM Rcustomer r WHERE r.oname = :oname"), @NamedQuery(name = "Rcustomer.findByCname", query = "SELECT r FROM Rcustomer r WHERE r.cname = :cname"), @NamedQuery(name = "Rcustomer.findByPname", query = "SELECT r FROM Rcustomer r WHERE r.pname = :pname"), @NamedQuery(name = "Rcustomer.findByCtname", query = "SELECT r FROM Rcustomer r WHERE r.ctname = :ctname"), @NamedQuery(name = "Rcustomer.findByDday", query = "SELECT r FROM Rcustomer r WHERE r.dday = :dday"), @NamedQuery(name = "Rcustomer.findByDdaybeg", query = "SELECT r FROM Rcustomer r WHERE r.ddaybeg = :ddaybeg"), @NamedQuery(name = "Rcustomer.findByDdayover", query = "SELECT r FROM Rcustomer r WHERE r.ddayover = :ddayover"), @NamedQuery(name = "Rcustomer.findByPassword", query = "SELECT r FROM Rcustomer r WHERE r.password = :password")})
public class Rcustomer implements Serializable, IEntity {

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

    public Rcustomer() {
    }

    public Rcustomer(Integer userid) {
        this.userid = userid;
    }

    public Rcustomer(Integer userid, String name, String departname, String oname, String cname, String pname, String ctname, String dday, Date ddaybeg, Date ddayover, String password) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rcustomer)) {
            return false;
        }
        Rcustomer other = (Rcustomer) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Rcustomer[userid=" + userid + "]";
    }
}
