/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess;

import com.vv.auth.struts.platform.base.BaseForm;

/**
 *
 * @author x-spirit
 */
public class IllegalAccessForm extends BaseForm{
    private String[] criterias;
    private String[] userids;
    private String[] rightids;
    private String datebegin;
    private String dateend;

    public String[] getCriterias() {
        return criterias;
    }

    public void setCriterias(String[] criterias) {
        this.criterias = criterias;
    }

    public String getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(String datebegin) {
        this.datebegin = datebegin;
    }

    public String getDateend() {
        return dateend;
    }

    public void setDateend(String dateend) {
        this.dateend = dateend;
    }

    public String[] getRightids() {
        return rightids;
    }

    public void setRightids(String[] rightids) {
        this.rightids = rightids;
    }

    public String[] getUserids() {
        return userids;
    }

    public void setUserids(String[] userids) {
        this.userids = userids;
    }

    
}
