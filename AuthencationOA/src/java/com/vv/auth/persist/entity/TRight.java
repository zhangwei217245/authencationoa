/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author X-Spirit
 */
@Entity
@Table(name = "TRight")
@NamedQueries({@NamedQuery(name = "TRight.findAll", query = "SELECT t FROM TRight t"),
    @NamedQuery(name = "TRight.findByTrId", query = "SELECT t FROM TRight t WHERE t.trId = :trId"),
    @NamedQuery(name = "TRight.findByParentTrId", query = "SELECT t FROM TRight t WHERE t.parentTrId = :parentTrId"),
    @NamedQuery(name = "TRight.findByRightName", query = "SELECT t FROM TRight t WHERE t.rightName = :rightName"),
    @NamedQuery(name = "TRight.findByRightDesc", query = "SELECT t FROM TRight t WHERE t.rightDesc = :rightDesc"),
    @NamedQuery(name = "TRight.findByRightType", query = "SELECT t FROM TRight t WHERE t.rightType = :rightType"),
    @NamedQuery(name = "TRight.findByRightPath", query = "SELECT t FROM TRight t WHERE t.rightPath = :rightPath"),
    @NamedQuery(name = "TRight.findByRightTypeAndRightPath", query = "SELECT t FROM TRight t WHERE t.rightType = :rightType AND t.rightPath = :rightPath")})
public class TRight implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trId;
    @Column(name = "parent_tr_id")
    private Integer parentTrId;
    @Basic(optional = false)
    @Column(name = "right_name", nullable = false, length = 64)
    private String rightName;
    @Column(name = "right_desc", length = 200)
    private String rightDesc;
    @Basic(optional = false)
    @Column(name = "right_type", nullable = false, length = 45)
    private String rightType;
    @Basic(optional = false)
    @Column(name = "right_path", nullable = false, length = 1000)
    private String rightPath;
    @ManyToMany(mappedBy = "tRightCollection",cascade=CascadeType.ALL)
    private Collection<TGroup> tGroupCollection = new ArrayList<TGroup>();

    ;

    public TRight() {
    }

    public TRight(Integer trId) {
        this.trId = trId;
    }

    public TRight(Integer trId, String rightName, String rightType, String rightPath) {
        this.trId = trId;
        this.rightName = rightName;
        this.rightType = rightType;
        this.rightPath = rightPath;
    }

    public TRight(Integer trId, String rightName, String rightType, String rightPath, String rightDesc) {
        this.trId = trId;
        this.rightName = rightName;
        this.rightType = rightType;
        this.rightPath = rightPath;
        this.rightDesc = rightDesc;
    }

    public Integer getTrId() {
        return trId;
    }

    public void setTrId(Integer trId) {
        this.trId = trId;
    }

    public Integer getParentTrId() {
        return parentTrId;
    }

    public void setParentTrId(Integer parentTrId) {
        this.parentTrId = parentTrId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getRightDesc() {
        return rightDesc;
    }

    public void setRightDesc(String rightDesc) {
        this.rightDesc = rightDesc;
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType;
    }

    public String getRightPath() {
        return rightPath;
    }

    public void setRightPath(String rightPath) {
        this.rightPath = rightPath;
    }

    public Collection<TGroup> getTGroupCollection() {
        return tGroupCollection;
    }

    public void setTGroupCollection(Collection<TGroup> tGroupCollection) {
        this.tGroupCollection = tGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trId != null ? trId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRight)) {
            return false;
        }
        TRight other = (TRight) object;
        if ((this.trId == null && other.trId != null) || (this.trId != null && !this.trId.equals(other.trId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.TRight[trId=" + trId + "]";
    }
}
