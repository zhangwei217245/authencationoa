/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.illegalaccess;

import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.struts.illegalaccess.chart.IllegalAccessChartGenerator;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.util.Utility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author x-spirit
 */
public class IllegalAccessAction extends BaseAction {

    @Resource
    private IJpaDaoService jpaDaoService;
    @Resource
    private IllegalAccessChartGenerator illegalAccessChartGenerator;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();

        if (parameter.equalsIgnoreCase("illegalAccessInit")) {
            forward = IllegalAccessInit(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("illegalAccessShowCata")) {
            forward = IllegalAccessShowCata(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("illegalAccessShowPie")) {
            forward = IllegalAccessShowPie(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("illegalAccessShowDetail")) {
            forward = IllegalAccessShowDetail(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("ChartView")) {
            ChartView(mapping, aform, request, response);
        }
        return forward;
    }

    /**
     * 初始化查询界面
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward IllegalAccessInit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List allusers = jpaDaoService.findByNamedQueryAndNamedParams("Vcustomer.findAll", null);
            Map param = new HashMap();
            param.put("rightType", "path");
            List allrights = jpaDaoService.findByNamedQueryAndNamedParams("TRight.findByRightType", param);
            request.setAttribute("allusers", allusers);
            request.setAttribute("allrights", allrights);
        } catch (Exception e) {
            log.error(e + "");
            e.printStackTrace();
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * 根据不同的查询条件，生成不同的图表
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward IllegalAccessShowCata(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        IllegalAccessForm form = (IllegalAccessForm) aform;
        String[] criterias = form.getCriterias();
        String[] userids = form.getUserids();
        String[] rightids = form.getRightids();
        try {
            illegalAccessChartGenerator.generateCataChartForAny(request, userids, rightids, form.getBeg(), form.getOver(), form.getCriterias());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e + "");
        }

        return mapping.findForward(SUCCESS);
    }

    private ActionForward IllegalAccessShowPie(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String rightname = request.getParameter("rightname");
        String datbeg = request.getParameter("datbeg");
        String datover = request.getParameter("datover");
        try {
            illegalAccessChartGenerator.generatePieChartForAny(request, username, rightname, datbeg, datover);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e+"");
        }

        return mapping.findForward(SUCCESS);
    }

    private ActionForward IllegalAccessShowDetail(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String rightname = request.getParameter("rightname");
        String datbeg = request.getParameter("datbeg");
        String datover = request.getParameter("datover");
        
        return mapping.findForward(SUCCESS);
    }

    private void ChartView(ActionMapping mapping, ActionForm aform, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    }
}
