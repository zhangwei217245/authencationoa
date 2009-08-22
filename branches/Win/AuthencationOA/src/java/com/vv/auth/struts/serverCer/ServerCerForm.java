/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.serverCer;

import com.vv.auth.struts.platform.base.BaseForm;
import java.util.Date;

/**
 *
 * @author hp
 */
public class ServerCerForm extends BaseForm {

    private Long ksdid;
    private String name;
    private String departname;
    private String oname;
    private String cname;
    private String pname;
    private String ctname;
    private String ctfname;
    private Long albyte;
    private String cpass;
    private String ppass;
    private String location;
    private Long dday;
    private Date ddaybeg;
    private Date ddayover;
    private String searchname;
    private String showtype;

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }

    public String getShowtype() {
        return showtype;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    public Long getAlbyte() {
        return albyte;
    }

    public void setAlbyte(Long albyte) {
        this.albyte = albyte;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public String getCtfname() {
        return ctfname;
    }

    public void setCtfname(String ctfname) {
        this.ctfname = ctfname;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public Long getDday() {
        return dday;
    }

    public void setDday(Long dday) {
        this.dday = dday;
    }

    public Date getDdaybeg() {
        return ddaybeg;
    }

    public void setDdaybeg(Date ddaybeg) {
        this.ddaybeg = ddaybeg;
    }

    public Date getDdayover() {
        return ddayover;
    }

    public void setDdayover(Date ddayover) {
        this.ddayover = ddayover;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public Long getKsdid() {
        return ksdid;
    }

    public void setKsdid(Long ksdid) {
        this.ksdid = ksdid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPpass() {
        return ppass;
    }

    public void setPpass(String ppass) {
        this.ppass = ppass;
    }
}
