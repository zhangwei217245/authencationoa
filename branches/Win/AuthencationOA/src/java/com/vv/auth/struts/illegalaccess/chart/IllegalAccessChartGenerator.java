/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

/**
 * 生成条状图或者饼状图。
 * @author x-spirit
 */
public class IllegalAccessChartGenerator {
    /**
     * 是否展示给出用于展示详细记录的MAP链接
     */
    private boolean showDetailRecord;


    private String showDetailForms;

    public String getShowDetailForms() {
        return showDetailForms;
    }

    public void setShowDetailForms(String showDetailForms) {
        this.showDetailForms = showDetailForms;
    }

    public boolean isShowDetailRecord() {
        return showDetailRecord;
    }

    public void setShowDetailRecord(boolean showDetailRecord) {
        this.showDetailRecord = showDetailRecord;
    }

    
    
}
