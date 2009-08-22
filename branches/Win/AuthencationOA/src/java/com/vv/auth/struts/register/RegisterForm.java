/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.register;

import com.vv.auth.struts.platform.base.BaseForm;
import java.util.Date;

/**
 *
 * @author X-Spirit
 */
public class RegisterForm extends BaseForm {

    private Long tuId;
    private String loginName;
    private String password;
    private String confirmPassword;
    private String username;
    private String mobile;
    private String email;
    private Date genTime;
    private Date loginTime;
    private Date lastLoginTime;
    private long count;
    private String validcode;

    public String getValidcode() {
        return validcode;
    }

    public void setValidcode(String validcode) {
        this.validcode = validcode;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTuId() {
        return tuId;
    }

    public void setTuId(Long tuId) {
        this.tuId = tuId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
