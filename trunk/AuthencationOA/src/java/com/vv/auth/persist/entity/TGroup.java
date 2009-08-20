/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "TGroup")
@NamedQueries({@NamedQuery(name = "TGroup.findAll", query = "SELECT t FROM TGroup t"),
    @NamedQuery(name = "TGroup.findByTgId", query = "SELECT t FROM TGroup t WHERE t.tgId = :tgId"),
    @NamedQuery(name = "TGroup.findByGroupName", query = "SELECT t FROM TGroup t WHERE t.groupName = :groupName"),
    @NamedQuery(name = "TGroup.findByGroupNameAndDesc", query = "SELECT t FROM TGroup t WHERE t.groupName = :groupName AND t.tgDesc LIKE :tgDesc"),
    @NamedQuery(name = "TGroup.findByParentTgId", query = "SELECT t FROM TGroup t WHERE t.parentTgId = :parentTgId"),
    @NamedQuery(name = "TGroup.findByGenTime", query = "SELECT t FROM TGroup t WHERE t.genTime = :genTime"),
    @NamedQuery(name = "TGroup.findByTgDesc", query = "SELECT t FROM TGroup t WHERE t.tgDesc LIKE :tgDesc")})
public class TGroup implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tg_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tgId;
    @Basic(optional = false)
    @Column(name = "group_name", nullable = false, length = 64)
    private String groupName;
    @Column(name = "parent_tg_id")
    private Integer parentTgId;
    @Basic(optional = false)
    @Column(name = "gen_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date genTime;
    @Column(name = "tg_desc", length = 200)
    private String tgDesc;
    @JoinTable(name = "TGroupRightRelation", joinColumns = {@JoinColumn(name = "tg_id", referencedColumnName = "tg_id")}, inverseJoinColumns = {@JoinColumn(name = "tr_id", referencedColumnName = "tr_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<TRight> tRightCollection = new ArrayList<TRight>();
    @JoinTable(name = "TUserGroupRelation", joinColumns = {@JoinColumn(name = "tg_id", referencedColumnName = "tg_id")}, inverseJoinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")})
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Vcustomer> vcustomerCollection = new ArrayList<Vcustomer>();

    public TGroup() {
    }

    public TGroup(Integer tgId) {
        this.tgId = tgId;
    }

    public TGroup(Integer tgId, String groupName, Date genTime) {
        this.tgId = tgId;
        this.groupName = groupName;
        this.genTime = genTime;
    }

    public TGroup(Integer tgId, String groupName, Date genTime, String tgDesc) {
        this.tgId = tgId;
        this.groupName = groupName;
        this.genTime = genTime;
        this.tgDesc = tgDesc;
    }

    public Integer getTgId() {
        return tgId;
    }

    public void setTgId(Integer tgId) {
        this.tgId = tgId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getParentTgId() {
        return parentTgId;
    }

    public void setParentTgId(Integer parentTgId) {
        this.parentTgId = parentTgId;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public String getTgDesc() {
        return tgDesc;
    }

    public void setTgDesc(String tgDesc) {
        this.tgDesc = tgDesc;
    }

    public Collection<TRight> getTRightCollection() {
        return tRightCollection;
    }

    public void setTRightCollection(Collection<TRight> tRightCollection) {
        this.tRightCollection = tRightCollection;
    }

    public Collection<Vcustomer> getVcustomerCollection() {
        return vcustomerCollection;
    }

    public void setVcustomerCollection(Collection<Vcustomer> vcustomerCollection) {
        this.vcustomerCollection = vcustomerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tgId != null ? tgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TGroup)) {
            return false;
        }
        TGroup other = (TGroup) object;
        if ((this.tgId == null && other.tgId != null) || (this.tgId != null && !this.tgId.equals(other.tgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.TGroup[tgId=" + tgId + "]";
    }
}
