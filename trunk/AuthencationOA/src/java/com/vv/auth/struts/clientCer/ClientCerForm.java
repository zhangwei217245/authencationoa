/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.clientCer;

import com.vv.auth.struts.platform.base.BaseForm;
import java.util.Date;

/**
 *
 * @author X-Spirit
 */
public class ClientCerForm extends BaseForm {

    private Long userid;
    private String name;
    private String departname;
    private String oname;
    private String cname;
    private String pname;
    private String ctname;
    private String dday;
    private Date ddaybeg;
    private Date ddayover;
    private String password;
    private String confirmPassword;
    private String verifystatus;
    private String validcode;
    private String searchname;
    private String certype;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getDday() {
        return dday;
    }

    public void setDday(String dday) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getVerifystatus() {
        return verifystatus;
    }

    public void setVerifystatus(String verifystatus) {
        this.verifystatus = verifystatus;
    }

    public String getValidcode() {
        return validcode;
    }

    public void setValidcode(String validcode) {
        this.validcode = validcode;
    }

    public String getCertype() {
        return certype;
    }

    public void setCertype(String certype) {
        this.certype = certype;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }
}
