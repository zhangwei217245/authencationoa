/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.conferenceMana;

import com.vv.auth.persist.entity.ConferenceApply;
import com.vv.auth.persist.entity.IEntity;
import com.vv.auth.persist.service.IEntityService;
import com.vv.auth.persist.service.IGroupService;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.Utility;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author X-Spirit
 */
public class ConferenceAction extends BaseAction {

    @Resource
    IEntityService conferenceApplyService;
    @Resource
    IGroupService tgroupService;
    @Resource
    IUserService tuserService;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("searchConference")) {
            forward = searchConference(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("initApply")) {
            forward = initApply(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("submitApply")) {
            forward = submitApply(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("viewApply")) {
            forward = viewApply(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("initEditApply")) {
            forward = initEditApply(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("editApply")) {
            forward = editApply(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("adminSearchConference")) {
            forward = adminSearchConference(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("adminviewApply")) {
            forward = adminviewApply(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("adminVerifyConference")) {
            forward = adminVerifyConference(mapping, aform, request, response);
        }
        return forward;
    }

    private ActionForward adminSearchConference(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jpql = "select distinct object(o) from ConferenceApply as o where 1=1";
        StringBuffer sb = new StringBuffer(jpql);
        ConferenceForm form = (ConferenceForm) aform;
        if (Utility.isNotEmpty(form.getVc2namefq())) {
            sb.append(" and o.vc2name like '%").append(form.getVc2namefq()).append("%'");
        }
        if (Utility.isNotEmpty(form.getVc2statusfq())) {
            sb.append(" and o.vc2status = '").append(form.getVc2statusfq()).append("'");
        }
        List<IEntity> rstlst = conferenceApplyService.findEntities(sb.toString(), null, true, -1, -1);
        request.setAttribute("rstlst", rstlst);
        return mapping.findForward(SUCCESS);
    }

    private ActionForward adminviewApply(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String applyid = request.getParameter("numapplyid");
        ConferenceForm form = (ConferenceForm) aform;
        if (Utility.isNotEmpty(applyid)) {
            ConferenceApply confapply = (ConferenceApply) conferenceApplyService.findOneEntityById(Integer.parseInt(applyid.trim()));
            request.setAttribute("confapply", confapply);
        } else {
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }

    private ActionForward adminVerifyConference(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String applyid = request.getParameter("numapplyid");
        ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
        String groupid = usermap.get("groupid") + "";
        String userid = usermap.get("userid") + "";
        ConferenceForm form = (ConferenceForm) aform;
        if (Utility.isNotEmpty(applyid)) {
            ConferenceApply confapply = (ConferenceApply) conferenceApplyService.findOneEntityById(Integer.parseInt(applyid.trim()));
            confapply.setVc2status(form.getVc2status());
            confapply.setNumverifierid(tuserService.findUserById(Integer.parseInt(userid)));
            if (Utility.isNotEmpty(form.getVc2txtinfo())) {
                confapply.setVc2txtinfo(form.getVc2txtinfo());
            }
            conferenceApplyService.edit(confapply);
            request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        } else {
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }

    private ActionForward searchConference(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
        String groupid = usermap.get("groupid") + "";
        String jpql = "select distinct object(o) from ConferenceApply as o where 1=1";
        StringBuffer sb = new StringBuffer(jpql);
        ConferenceForm form = (ConferenceForm) aform;
        if (Utility.isNotEmpty(form.getVc2namefq())) {
            sb.append(" and o.vc2name like '%").append(form.getVc2namefq()).append("%'");
        }
        if (Utility.isNotEmpty(form.getVc2statusfq())) {
            sb.append(" and o.vc2status = '").append(form.getVc2statusfq()).append("'");
        }
        sb.append(" and o.tgId.tgId = ").append(groupid);
        List<IEntity> rstlst = conferenceApplyService.findEntities(sb.toString(), null, true, -1, -1);
        request.setAttribute("rstlst", rstlst);
        return mapping.findForward(SUCCESS);

    }

    private ActionForward initApply(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(SUCCESS);
    }

    private ActionForward submitApply(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
        String groupid = usermap.get("groupid") + "";
        String userid = usermap.get("userid") + "";
        ConferenceForm form = (ConferenceForm) aform;
        try {
            ConferenceApply confapply = new ConferenceApply(form.getVc2name(), form.getVc2desc(),
                    Utility.convertStringToDate(form.getDatbegintime(), "yyyy-MM-dd HH:mm:ss"),
                    Utility.convertStringToDate(form.getDatendtime(), "yyyy-MM-dd HH:mm:ss"), "P");
            confapply.setNumapplierid(tuserService.findUserById(Integer.parseInt(userid)));
            confapply.setTgId(tgroupService.findGroupById(Integer.parseInt(groupid)));

            conferenceApplyService.create(confapply);
            request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e);
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }

    private ActionForward viewApply(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String applyid = request.getParameter("numapplyid");
        ConferenceForm form = (ConferenceForm) aform;
        if (Utility.isNotEmpty(applyid)) {
            ConferenceApply confapply = (ConferenceApply) conferenceApplyService.findOneEntityById(Integer.parseInt(applyid.trim()));

            request.setAttribute("confapply", confapply);
        } else {
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }

    private ActionForward initEditApply(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String applyid = request.getParameter("numapplyid");
        ConferenceForm form = (ConferenceForm) aform;
        if (Utility.isNotEmpty(applyid)) {
            ConferenceApply confapply = (ConferenceApply) conferenceApplyService.findOneEntityById(Integer.parseInt(applyid.trim()));
            form.setNumapplyid(confapply.getNumapplyid().toString());
            form.setDatbegintime(Utility.convertDateToString(confapply.getDatbegintime(), "yyyy-MM-dd HH:mm:ss"));
            form.setDatendtime(Utility.convertDateToString(confapply.getDatendtime(), "yyyy-MM-dd HH:mm:ss"));
            form.setVc2name(confapply.getVc2name());
            form.setVc2desc(confapply.getVc2desc());
            form.setVc2status(confapply.getVc2status());
            request.setAttribute("confapply", confapply);
        } else {
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }

    private ActionForward editApply(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
        String groupid = usermap.get("groupid") + "";
        String userid = usermap.get("userid") + "";
        ConferenceForm form = (ConferenceForm) aform;

        try {
            ConferenceApply confapply = (ConferenceApply) conferenceApplyService.findOneEntityById(Integer.parseInt(form.getNumapplyid()));
            confapply.setNumapplierid(tuserService.findUserById(Integer.parseInt(userid)));
            confapply.setTgId(tgroupService.findGroupById(Integer.parseInt(groupid)));
            if (Utility.isNotEmpty(form.getVc2name())) {
                confapply.setVc2name(form.getVc2name());
            }
            if (Utility.isNotEmpty(form.getVc2desc())) {
                confapply.setVc2desc(form.getVc2desc());
            }
            if (Utility.isNotEmpty(form.getDatbegintime())) {
                confapply.setDatbegintime(Utility.convertStringToDate(form.getDatbegintime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (Utility.isNotEmpty(form.getDatendtime())) {
                confapply.setDatendtime(Utility.convertStringToDate(form.getDatendtime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (Utility.isNotEmpty(form.getVc2status())) {
                confapply.setVc2status(form.getVc2status());
            }
            conferenceApplyService.edit(confapply);
            request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e);
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }
}
