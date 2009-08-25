/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author X-Spirit
 */
@Entity
@Table(name = "document")
@NamedQueries({@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"), @NamedQuery(name = "Document.findByNumdocid", query = "SELECT d FROM Document d WHERE d.numdocid = :numdocid"), @NamedQuery(name = "Document.findByVc2title", query = "SELECT d FROM Document d WHERE d.vc2title = :vc2title"), @NamedQuery(name = "Document.findByVc2content", query = "SELECT d FROM Document d WHERE d.vc2content = :vc2content"), @NamedQuery(name = "Document.findByVc2addition", query = "SELECT d FROM Document d WHERE d.vc2addition = :vc2addition"), @NamedQuery(name = "Document.findByVc2additionname", query = "SELECT d FROM Document d WHERE d.vc2additionname = :vc2additionname"), @NamedQuery(name = "Document.findByVc2lock", query = "SELECT d FROM Document d WHERE d.vc2lock = :vc2lock"), @NamedQuery(name = "Document.findByVc2result", query = "SELECT d FROM Document d WHERE d.vc2result = :vc2result"), @NamedQuery(name = "Document.findByVc2use", query = "SELECT d FROM Document d WHERE d.vc2use = :vc2use"), @NamedQuery(name = "Document.findByDatcreatetime", query = "SELECT d FROM Document d WHERE d.datcreatetime = :datcreatetime"), @NamedQuery(name = "Document.findByNumcurrstep", query = "SELECT d FROM Document d WHERE d.numcurrstep = :numcurrstep")})
public class Document implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numdocid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numdocid;
    @Column(name = "vc2title", length = 50)
    private String vc2title;
    @Column(name = "vc2content", length = 2000)
    private String vc2content;
    @Column(name = "vc2addition", length = 50)
    private String vc2addition;
    @Column(name = "vc2additionname", length = 200)
    private String vc2additionname;
    @Column(name = "vc2lock")
    private Character vc2lock;
    @Column(name = "vc2result")
    private Character vc2result;
    @Column(name = "vc2use")
    private Character vc2use;
    @Column(name = "datcreatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datcreatetime;
    @Column(name = "numcurrstep")
    private Integer numcurrstep;
    @Column(name = "lockuserid")
    private Integer lockuserid;
    @JoinColumn(name = "numtypeid", referencedColumnName = "numtypeid")
    @ManyToOne
    private Documenttype numtypeid;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Vcustomer userid;
    @OneToMany(mappedBy = "numdocid",fetch=FetchType.LAZY)
    private Collection<Documentverify> documentverifyCollection;

    public Document() {
    }

    public Document(Integer numdocid) {
        this.numdocid = numdocid;
    }

    public Document(Integer numdocid, Documenttype numtypeid, String vc2title, String vc2content, String vc2addition, String vc2additionname, Vcustomer userid) {
        this.numdocid = numdocid;
        this.numtypeid = numtypeid;
        this.vc2title = vc2title;
        this.vc2content = vc2content;
        this.vc2addition = vc2addition;
        this.vc2additionname = vc2additionname;
        this.userid = userid;
        this.datcreatetime = new Date();
        this.vc2lock = 'N';
        this.vc2result = 'N';
        this.vc2use = 'Y';
        this.numcurrstep = 1;
    }

    public Integer getLockuserid() {
        return lockuserid;
    }

    public void setLockuserid(Integer lockuserid) {
        this.lockuserid = lockuserid;
    }

    public Integer getNumdocid() {
        return numdocid;
    }

    public void setNumdocid(Integer numdocid) {
        this.numdocid = numdocid;
    }

    public String getVc2title() {
        return vc2title;
    }

    public void setVc2title(String vc2title) {
        this.vc2title = vc2title;
    }

    public String getVc2content() {
        return vc2content;
    }

    public void setVc2content(String vc2content) {
        this.vc2content = vc2content;
    }

    public String getVc2addition() {
        return vc2addition;
    }

    public void setVc2addition(String vc2addition) {
        this.vc2addition = vc2addition;
    }

    public String getVc2additionname() {
        return vc2additionname;
    }

    public void setVc2additionname(String vc2additionname) {
        this.vc2additionname = vc2additionname;
    }

    public Character getVc2lock() {
        return vc2lock;
    }

    public void setVc2lock(Character vc2lock) {
        this.vc2lock = vc2lock;
    }

    public Character getVc2result() {
        return vc2result;
    }

    public void setVc2result(Character vc2result) {
        this.vc2result = vc2result;
    }

    public Character getVc2use() {
        return vc2use;
    }

    public void setVc2use(Character vc2use) {
        this.vc2use = vc2use;
    }

    public Date getDatcreatetime() {
        return datcreatetime;
    }

    public void setDatcreatetime(Date datcreatetime) {
        this.datcreatetime = datcreatetime;
    }

    public Integer getNumcurrstep() {
        return numcurrstep;
    }

    public void setNumcurrstep(Integer numcurrstep) {
        this.numcurrstep = numcurrstep;
    }

    public Documenttype getNumtypeid() {
        return numtypeid;
    }

    public void setNumtypeid(Documenttype numtypeid) {
        this.numtypeid = numtypeid;
    }

    public Vcustomer getUserid() {
        return userid;
    }

    public void setUserid(Vcustomer userid) {
        this.userid = userid;
    }

    public Collection<Documentverify> getDocumentverifyCollection() {
        return documentverifyCollection;
    }

    public void setDocumentverifyCollection(Collection<Documentverify> documentverifyCollection) {
        this.documentverifyCollection = documentverifyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numdocid != null ? numdocid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.numdocid == null && other.numdocid != null) || (this.numdocid != null && !this.numdocid.equals(other.numdocid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vv.auth.persist.entity.Document[numdocid=" + numdocid + "]";
    }
}
