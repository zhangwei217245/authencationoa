/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.monitor;

import com.vv.auth.persist.entity.IEntity;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.persist.entity.Moniter;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IEntityService;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.struts.util.Pagination;
import com.vv.auth.struts.util.Utility;
import java.util.Calendar;
import java.util.Date;
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
 * @author hp
 */
public class MonitorAction extends BaseAction {

    public static final String FORMATE_DATE = "yyyy-MM-dd HH:mm:ss";
    @Resource(name = "monitorService")
    private IEntityService monitorService;
    @Resource
    private IUserService tuserService;
    private Pagination pagination;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward forward = null;
        String parameter = mapping.getParameter();

        if (parameter.equalsIgnoreCase("monitorShowInit")) {
            forward = monitorShowInit(mapping,aform,request,response);
        } else if (parameter.equalsIgnoreCase("monitorShow")) {
            forward = monitorShow(mapping, aform, request, response);
        }
        return forward;
    }

    private ActionForward monitorShowInit(ActionMapping mapping, ActionForm aform, HttpServletRequest request, HttpServletResponse response) {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -1);
        Date yesterday = cal.getTime();

        Map params = new HashMap();

        String jpql = " FROM Moniter m WHERE 1=1";
        StringBuffer sb = new StringBuffer(jpql);
            sb.append(" AND m.dattime>=:from");
            sb.append(" AND m.dattime<=:to");
            params.put("from", yesterday);
            params.put("to", today);
            sb.append(" order by m.dattime desc");

        String querystr = sb.toString();

        int listCount = monitorService.getEntityCount("SELECT COUNT(distinct m) "+querystr, params);

        pagination = new Pagination(request, response);
        pagination.setRecordCount(listCount);

        List<IEntity> monitorList = monitorService.findEntities("SELECT distinct m "+querystr, params, false, pagination.getFirstResult(), pagination.getPageSize());
        request.setAttribute("monitorList", monitorList);
        request.setAttribute("pagination", pagination.toString());

        request.setAttribute("today", today);
        request.setAttribute("yesterday", yesterday);
        return mapping.findForward(SUCCESS);
    }

    private ActionForward monitorShow(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) {

        MonitorForm form = (MonitorForm) aform;
        Map params = new HashMap();

        String jpql = " FROM Moniter m WHERE 1=1";
        StringBuffer sb = new StringBuffer(jpql);

        if (Utility.isNotEmpty(form.getName())) {
            sb.append(" AND m.userid.name like '%").append(form.getName()).append("%'");
        }
        Date datfrom = null;
        if (Utility.isNotEmpty(form.getBeg())) {
            datfrom = Utility.convertStringToDate(form.getBeg(), FORMATE_DATE);
            params.put("from", datfrom);
            sb.append(" AND m.dattime>=:from");
        }
        Date datover = null;
        if (Utility.isNotEmpty(form.getOver())) {
            datover = Utility.convertStringToDate(form.getOver(), FORMATE_DATE);
            params.put("to", datover);
            sb.append(" AND m.dattime<=:to");
        }
        if (Utility.isNotEmpty(form.getVc2path())) {
            sb.append(" and m.vc2path like '%").append(form.getVc2path()).append("%'");
        }
        if (Utility.isNotEmpty(form.getVc2parameter())) {
            sb.append(" and m.vc2parameter like '%").append(form.getVc2parameter()).append("%'");
        }
        sb.append(" order by m.dattime desc");

        String querystr = sb.toString();

        int listCount = monitorService.getEntityCount("SELECT COUNT(distinct m) "+querystr, params);

        pagination = new Pagination(request, response);
        pagination.setRecordCount(listCount);

        List<IEntity> monitorList = monitorService.findEntities("SELECT distinct m "+querystr, params, false, pagination.getFirstResult(), pagination.getPageSize());
        request.setAttribute("monitorList", monitorList);
        request.setAttribute("pagination", pagination.toString());
        return mapping.findForward(SUCCESS);
    }
    /*private ActionForward monitorShow(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) {

        MonitorForm form = (MonitorForm) aform;
        Map params = new HashMap();

        String jpql = "select distinct new com.vv.auth.persist.entity.VcustomerMonitor(v.name,m.dattime,m.vc2path,m.vc2parameter,m.vc2exception) from Moniter m join m.userid v where 1=1";
        String jpqlcount = "select count(distinct m) from Moniter m join m.userid v where 1=1";
        StringBuffer sb = new StringBuffer(jpql);
        StringBuffer sb2 = new StringBuffer(jpqlcount);

        if (Utility.isNotEmpty(form.getName())) {
            sb.append(" and v.name like '%").append(form.getName()).append("%'");
            sb2.append(" and v.name like '%").append(form.getName()).append("%'");
        }
        Date datfrom = null;
        if (Utility.isNotEmpty(form.getBeg())) {
            datfrom = Utility.convertStringToDate(form.getBeg(), FORMATE_DATE);
            params.put("from", datfrom);
            sb.append(" AND m.dattime>=:from");
            sb2.append(" AND m.dattime>=:from");
        }
        Date datover = null;
        if (Utility.isNotEmpty(form.getOver())) {
            datover = Utility.convertStringToDate(form.getOver(), FORMATE_DATE);
            params.put("to", datover);
            sb.append(" AND m.dattime<=:to");
            sb2.append(" AND m.dattime<=:to");
        }
        if (Utility.isNotEmpty(form.getVc2path())) {
            sb.append(" and m.vc2path like '%").append(form.getVc2path()).append("%'");
            sb2.append(" and m.vc2path like '%").append(form.getVc2path()).append("%'");
        }
        if (Utility.isNotEmpty(form.getVc2parameter())) {
            sb.append(" and m.vc2parameter like '%").append(form.getVc2parameter()).append("%'");
            sb2.append(" and m.vc2parameter like '%").append(form.getVc2parameter()).append("%'");
        }
        sb.append(" order by m.dattime desc");

        int listCount = monitorService.getEntityCount(sb2.toString(), params);

        pagination = new Pagination(request, response);
        pagination.setRecordCount(listCount);

        List<IEntity> monitorList = monitorService.findEntities(sb.toString(), params, false, pagination.getFirstResult(), pagination.getPageSize());
        request.setAttribute("monitorList", monitorList);
        request.setAttribute("pagination", pagination.toString());
        return mapping.findForward(SUCCESS);
    }*/
}
