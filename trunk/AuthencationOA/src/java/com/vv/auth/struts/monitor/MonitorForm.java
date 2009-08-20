/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.monitor;

import com.vv.auth.struts.platform.base.BaseForm;
import java.util.Date;

/**
 *
 * @author hp
 */
public class MonitorForm extends BaseForm {

    private String name;
    private String vc2path;
    private String vc2parameter;
    private String beg;
    private String over;
    private String vc2exception;

    public String getVc2exception() {
        return vc2exception;
    }

    public void setVc2exception(String vc2exception) {
        this.vc2exception = vc2exception;
    }

    public String getBeg() {
        return beg;
    }

    public void setBeg(String beg) {
        this.beg = beg;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getVc2path() {
        return vc2path;
    }

    public void setVc2path(String vc2path) {
        this.vc2path = vc2path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVc2parameter() {
        return vc2parameter;
    }

    public void setVc2parameter(String vc2parameter) {
        this.vc2parameter = vc2parameter;
    }
}
