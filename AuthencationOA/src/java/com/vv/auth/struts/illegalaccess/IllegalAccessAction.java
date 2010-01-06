/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess;

import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.struts.platform.base.BaseAction;
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
public class IllegalAccessAction extends BaseAction{

    @Resource
    private IJpaDaoService jpaDaoService;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();

        if (parameter.equalsIgnoreCase("illegalAccessInit")) {
            forward = IllegalAccessInit(mapping, aform,request, response);
        } else if (parameter.equalsIgnoreCase("illegalAccessShow")) {
            forward = IllegalAccessShow(mapping, aform,request, response);
        } else if (parameter.equalsIgnoreCase("iACataChart")) {
            IACataChart(mapping, aform,request, response);
        } else if (parameter.equalsIgnoreCase("iAPieChart")) {
            IAPieChart(mapping, aform,request, response);
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
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            List allusers = jpaDaoService.findByNamedQueryAndNamedParams("Vcustomer.findAll", null);
            Map param = new HashMap();
            param.put("rightType", "path");
            List allrights = jpaDaoService.findByNamedQueryAndNamedParams("TRight.findByRightType", param);
            request.setAttribute("allusers", allusers);
            request.setAttribute("allrights", allrights);
        } catch (Exception e) {
            log.error(e+"");
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
    private ActionForward IllegalAccessShow(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        IllegalAccessForm form = (IllegalAccessForm)aform;
        String[] criterias=form.getCriterias();
        String[] userids=form.getUserids();
        String[] rightids=form.getRightids();
        if(form.isCheckedNone()){

        }
        if(form.isCheckedBoth()){

        }
        if(form.isRightCheckedOnly()){

        }
        if(form.isUserCheckedOnly()){
            
        }
        for(String s:criterias){
            System.out.println(s);
        }
        for(String s:userids){
            System.out.println(s);
        }
        for(String s:rightids){
            System.out.println(s);
        }
        return mapping.findForward(SUCCESS);
    }

    /**
     * 用于生成柱状图
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private void IACataChart(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
    }

    /**
     * 用于生成饼状图
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private void IAPieChart(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
    }


}
