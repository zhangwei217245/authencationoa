/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.group;

import com.vv.auth.struts.platform.base.BaseForm;

/**
 *
 * @author X-Spirit
 */
public class GroupForm extends BaseForm {

    private String tgId;
    private String groupName;
    private String tg_desc;
    private String[] tguser;
    private String[] tgright;

    public String[] getTgright() {
        return tgright;
    }

    public void setTgright(String[] tgright) {
        this.tgright = tgright;
    }

    public String[] getTguser() {
        return tguser;
    }

    public void setTguser(String[] tguser) {
        this.tguser = tguser;
    }

    public String getTgId() {
        return tgId;
    }

    public void setTgId(String tgId) {
        this.tgId = tgId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTg_desc() {
        return tg_desc;
    }

    public void setTg_desc(String tg_desc) {
        this.tg_desc = tg_desc;
    }
}
