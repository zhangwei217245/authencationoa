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
    private String beg;
    private String over;

    public boolean isUserSelected(){
        if(userids!=null&&userids.length>0){
            return true;
        }
        return false;
    }
    public boolean isRightSelected(){
        if(rightids!=null&&rightids.length>0){
            return true;
        }
        return false;
    }
    public boolean isCheckedNone(){
        if(criterias==null||criterias.length==0){
            return true;
        }
        return false;
    }
    public boolean isUserCheckedOnly(){
        if(criterias!=null&&criterias.length==1&&criterias[0].equals("userid")){
            return true;
        }
        return false;
    }
    public boolean isRightCheckedOnly(){
        if(criterias!=null&&criterias.length==1&&criterias[0].equals("trId")){
            return true;
        }
        return false;
    }
    public boolean isCheckedBoth(){
        if(criterias!=null&&criterias.length==2){
            return true;
        }
        return false;
    }

    public String[] getCriterias() {
        return criterias;
    }

    public void setCriterias(String[] criterias) {
        this.criterias = criterias;
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

    public String getCriteriaString(){
        if(isRightCheckedOnly()){
            return "trId";
        }
        if(isUserCheckedOnly()){
            return "userid";
        }
        return null;
    }
    
}
