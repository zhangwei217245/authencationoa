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
@Table(name = "TUser")
@NamedQueries({@NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t"), @NamedQuery(name = "TUser.findByTuId", query = "SELECT t FROM TUser t WHERE t.tuId = :tuId"), @NamedQuery(name = "TUser.findByName", query = "SELECT t FROM TUser t WHERE t.name = :name"), @NamedQuery(name = "TUser.findByEmail", query = "SELECT t FROM TUser t WHERE t.email = :email"), @NamedQuery(name = "TUser.findByPassword", query = "SELECT t FROM TUser t WHERE t.password = :password"), @NamedQuery(name = "TUser.findByGenTime", query = "SELECT t FROM TUser t WHERE t.genTime = :genTime"), @NamedQuery(name = "TUser.findByLoginTime", query = "SELECT t FROM TUser t WHERE t.loginTime = :loginTime"), @NamedQuery(name = "TUser.findByLastLoginTime", query = "SELECT t FROM TUser t WHERE t.lastLoginTime = :lastLoginTime"), @NamedQuery(name = "TUser.findByCount", query = "SELECT t FROM TUser t WHERE t.count = :count")})
public class TUser implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tuId;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 500)
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Basic(optional = false)
    @Column(name = "gen_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date genTime;
    @Column(name = "login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;
    @Column(name = "last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;
    @Basic(optional = false)
    @Column(name = "count", nullable = false)
    private int count;

    public TUser() {
    }

    public TUser(Integer tuId) {
        this.tuId = tuId;
    }

    public TUser(Integer tuId, String name, String email, String password, Date genTime, int count) {
        this.tuId = tuId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.genTime = genTime;
        this.count = count;
    }

    public Integer getTuId() {
        return tuId;
    }

    public void setTuId(Integer tuId) {
        this.tuId = tuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tuId != null ? tuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.tuId == null && other.tuId != null) || (this.tuId != null && !this.tuId.equals(other.tuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.TUser[tuId=" + tuId + "]";
    }
}
