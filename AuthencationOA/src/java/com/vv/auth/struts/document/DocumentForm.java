/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.document;

import com.vv.auth.struts.platform.base.BaseForm;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author hp
 */
public class DocumentForm extends BaseForm {

    private String numdocid;
    private String vc2title;
    private String vc2content;
    private FormFile vc2addition;
    private String vc2additionname;
    private String vc2lock;
    private String vc2result;
    private String vc2use;
    private String datcreatetime;
    private String numcurrstep;
    private String numtypeid;
    private String verifymessage;
    private String vc2titlefq;
    private String vc2contentfq;
    private String vc2resultfq;
    private String vc2usefq;
    private String datbeginfq;
    private String datendfq;
    private String numtypeidfq;
    private String[] docids;
    private String advicetag;
    private String vc2message;

    public String getAdvicetag() {
        return advicetag;
    }

    public void setAdvicetag(String advicetag) {
        this.advicetag = advicetag;
    }

    public String getVc2message() {
        return vc2message;
    }

    public void setVc2message(String vc2message) {
        this.vc2message = vc2message;
    }

    

    public String[] getDocids() {
        return docids;
    }

    public void setDocids(String[] docids) {
        this.docids = docids;
    }

    public String getDatbeginfq() {
        return datbeginfq;
    }

    public void setDatbeginfq(String datbeginfq) {
        this.datbeginfq = datbeginfq;
    }

    public String getDatendfq() {
        return datendfq;
    }

    public void setDatendfq(String datendfq) {
        this.datendfq = datendfq;
    }

    public String getNumtypeidfq() {
        return numtypeidfq;
    }

    public void setNumtypeidfq(String numtypeidfq) {
        this.numtypeidfq = numtypeidfq;
    }

    public String getVc2contentfq() {
        return vc2contentfq;
    }

    public void setVc2contentfq(String vc2contentfq) {
        this.vc2contentfq = vc2contentfq;
    }

    public String getVc2resultfq() {
        return vc2resultfq;
    }

    public void setVc2resultfq(String vc2resultfq) {
        this.vc2resultfq = vc2resultfq;
    }

    public String getVc2titlefq() {
        return vc2titlefq;
    }

    public void setVc2titlefq(String vc2titlefq) {
        this.vc2titlefq = vc2titlefq;
    }

    public String getVc2usefq() {
        return vc2usefq;
    }

    public void setVc2usefq(String vc2usefq) {
        this.vc2usefq = vc2usefq;
    }

    public String getDatcreatetime() {
        return datcreatetime;
    }

    public void setDatcreatetime(String datcreatetime) {
        this.datcreatetime = datcreatetime;
    }

    public String getNumcurrstep() {
        return numcurrstep;
    }

    public void setNumcurrstep(String numcurrstep) {
        this.numcurrstep = numcurrstep;
    }

    public String getNumdocid() {
        return numdocid;
    }

    public void setNumdocid(String numdocid) {
        this.numdocid = numdocid;
    }

    public String getNumtypeid() {
        return numtypeid;
    }

    public void setNumtypeid(String numtypeid) {
        this.numtypeid = numtypeid;
    }

    public FormFile getVc2addition() {
        return vc2addition;
    }

    public void setVc2addition(FormFile vc2addition) {
        this.vc2addition = vc2addition;
    }

    public String getVc2additionname() {
        return vc2additionname;
    }

    public void setVc2additionname(String vc2additionname) {
        this.vc2additionname = vc2additionname;
    }

    public String getVc2content() {
        return vc2content;
    }

    public void setVc2content(String vc2content) {
        this.vc2content = vc2content;
    }

    public String getVc2lock() {
        return vc2lock;
    }

    public void setVc2lock(String vc2lock) {
        this.vc2lock = vc2lock;
    }

    public String getVc2result() {
        return vc2result;
    }

    public void setVc2result(String vc2result) {
        this.vc2result = vc2result;
    }

    public String getVc2title() {
        return vc2title;
    }

    public void setVc2title(String vc2title) {
        this.vc2title = vc2title;
    }

    public String getVc2use() {
        return vc2use;
    }

    public void setVc2use(String vc2use) {
        this.vc2use = vc2use;
    }

    public String getVerifymessage() {
        return verifymessage;
    }

    public void setVerifymessage(String verifymessage) {
        this.verifymessage = verifymessage;
    }
}
