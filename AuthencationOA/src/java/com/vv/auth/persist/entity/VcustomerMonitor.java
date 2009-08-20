/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

import java.util.Date;

/**
 *
 * @author hp
 */
public class VcustomerMonitor {

    private String name;
    private Date dattime;
    private String vc2path;
    private String vc2parameter;
    private String vc2exception;

    public VcustomerMonitor(String username, Date dattime, String vc2path, String vc2parameter, String vc2exception) {
        this.name = username;
        this.dattime = dattime;
        this.vc2path = vc2path;
        this.vc2parameter = vc2parameter;
        this.vc2exception = vc2exception;
    }

    public Date getDattime() {
        return dattime;
    }

    public void setDattime(Date dattime) {
        this.dattime = dattime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVc2exception() {
        return vc2exception;
    }

    public void setVc2exception(String vc2exception) {
        this.vc2exception = vc2exception;
    }

    public String getVc2parameter() {
        return vc2parameter;
    }

    public void setVc2parameter(String vc2parameter) {
        this.vc2parameter = vc2parameter;
    }

    public String getVc2path() {
        return vc2path;
    }

    public void setVc2path(String vc2path) {
        this.vc2path = vc2path;
    }
}
