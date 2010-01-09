/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author X-Spirit
 */
public interface IllegalChartGenerator {
    String FORMATE_DATE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 通过判断两个数组的情况和checkBox勾选的情况来自动适配数据，并生成相应的图表。
     * @param request
     * @param userids
     * @param rightids
     * @param begs
     * @param overs
     * @param criteria
     */
    void generateCataChartForAny(HttpServletRequest request, String[] userids, String[] rightids, String begs, String overs, String[] criterias) throws Exception;

    void generatePieChartForAny(HttpServletRequest request, String username, String rightname, String begs, String overs) throws Exception;

}
