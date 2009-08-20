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
public class DocumentTypeForm extends BaseForm {

    private String numtypeid;
    private String vc2name;

    public String getNumtypeid() {
        return numtypeid;
    }

    public void setNumtypeid(String numtypeid) {
        this.numtypeid = numtypeid;
    }

    public String getVc2name() {
        return vc2name;
    }

    public void setVc2name(String vc2name) {
        this.vc2name = vc2name;
    }
}
