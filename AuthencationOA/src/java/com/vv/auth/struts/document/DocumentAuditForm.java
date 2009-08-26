/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.document;

import com.vv.auth.struts.platform.base.BaseForm;

/**
 *
 * @author x-spirit
 */
public class DocumentAuditForm extends BaseForm{
    private String numdocid;
    private String advicetag;
    private String vc2message;

    public String getNumdocid() {
        return numdocid;
    }

    public void setNumdocid(String numdocid) {
        this.numdocid = numdocid;
    }

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

    
}
