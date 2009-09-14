/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.group;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IGroupService;
import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.persist.service.IRightService;
import com.vv.auth.persist.service.controller.TGroupJpaController;
import com.vv.auth.persist.service.controller.TRightJpaController;
import com.vv.auth.persist.service.controller.VcustomerJpaController;
import com.vv.auth.persist.service.controller.exceptions.NonexistentEntityException;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.Pagination;
import com.vv.auth.struts.util.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
public class GroupAction extends BaseAction {

    @Resource
    private IGroupService tgroupService;
    @Resource
    private TGroupJpaController tgroupJpaControl;
    @Resource
    private VcustomerJpaController vcustomerJpaController;
    @Resource
    private TRightJpaController trightJpaControl;
    @Resource
    private IRightService trightService;
    @Resource
    private IJpaDaoService jpaDaoService;

    private Pagination pagination;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("showGroups")) {
            forward = showGroups(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("addGroupinit")) {
            saveToken(request);
            forward = mapping.findForward(SUCCESS);
        } else if (parameter.equalsIgnoreCase("addGroup")) {
            forward = addGroup(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("delGroup")) {
            forward = delGroup(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("setGroupUserinit")) {
            forward = setGroupUserinit(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("setGroupUser")) {
            forward = setGroupUser(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("setGroupRightinit")) {
            forward = setGroupRightinit(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("setGroupRight")) {
            forward = setGroupRight(mapping, aform, request, response);
        }
        return forward;
    }

    private ActionForward addGroup(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        GroupForm form = (GroupForm) aform;
        if (isTokenValid(request, true)) {
            TGroup group = new TGroup(null, form.getGroupName(), new Date(), form.getTg_desc());
            if (tgroupService.findGroupByName(group.getGroupName()).size() <= 0 && tgroupService.findGroupByDesc(group.getTgDesc()).size() <= 0) {
                //TRight right1=trightService.findRightByTypeAndPath("menu", "/ClientCer/initDownloadCer.do").get(0);
                //TRight right2=trightService.findRightByTypeAndPath("menu", "/ClientCer/initDownloadCer.do").get(0);
                tgroupService.saveGroup(group);
            } else {
                throw new BaseException("error.groupexists");
            }
        } else {
            throw new BaseException("error.duplicate.submit");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));

        return mapping.findForward(SUCCESS);
    }

    private ActionForward delGroup(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String groupid = request.getParameter("groupid");
        try {
            tgroupJpaControl.destroy(new Integer(groupid));
        } catch (NonexistentEntityException e) {
            throw new BaseException("error.groupnotexists");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward setGroupRight(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        GroupForm form = (GroupForm) aform;
        String groupid = form.getTgId();

        try {
            TGroup group = tgroupJpaControl.findTGroup(new Integer(groupid));
            group.getTRightCollection().clear();
            String[] rights = form.getTgright();
            for (String rightid : rights) {
                TRight right = trightJpaControl.findTRight(new Integer(rightid));
                //right.getTGroupCollection().clear();//保证一个用户只能属于一个组
                right.getTGroupCollection().add(group);
                group.getTRightCollection().add(right);
            }
            tgroupJpaControl.edit(group);
        } catch (Exception e) {
            log.error("", e);
            e.printStackTrace();
            throw new BaseException("errors.general");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward setGroupRightinit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String groupid = request.getParameter("groupid");
        GroupForm form = (GroupForm) aform;
        try {
            TGroup group = tgroupJpaControl.findTGroup(new Integer(groupid));
            request.setAttribute("groupname", group.getGroupName());
            request.setAttribute("groupdesc", group.getTgDesc());
            //Collection<Vcustomer> rightinGroup = group.getVcustomerCollection();
            List rightoutGroup = new ArrayList();
            List rightinGroup = new ArrayList();

            List<TRight> allrights = trightJpaControl.findTRightEntities();
            for (TRight right : allrights) {
                Collection<TGroup> rightgroup = right.getTGroupCollection();
                if (!rightgroup.contains(group)) {
                    rightoutGroup.add(right);
                } else {
                    rightinGroup.add(right);
                }
            }
            form.setTgId(groupid);
            request.setAttribute("rightinGroup", rightinGroup);
            request.setAttribute("rightoutGroup", rightoutGroup);
        } catch (Exception e) {
            log.error("", e);
            e.printStackTrace();
            throw new BaseException("errors.general");
        }
        //request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward setGroupUser(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        GroupForm form = (GroupForm) aform;
        String groupid = form.getTgId();
        try {
            TGroup group = tgroupJpaControl.findTGroup(new Integer(groupid));
            group.getVcustomerCollection().clear();
            String[] users = form.getTguser();
            for (String userid : users) {
                Vcustomer vcustomer = vcustomerJpaController.findVcustomer(new Integer(userid));
                vcustomer.getTGroupCollection().clear();//保证一个用户只能属于一个组
                vcustomer.getTGroupCollection().add(group);
                group.getVcustomerCollection().add(vcustomer);
            }
            tgroupJpaControl.edit(group);
        } catch (Exception e) {
            log.error("", e);
            e.printStackTrace();
            throw new BaseException("errors.general");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward setGroupUserinit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String groupid = request.getParameter("groupid");
        GroupForm form = (GroupForm) aform;
        try {
            TGroup group = tgroupJpaControl.findTGroup(new Integer(groupid));
            request.setAttribute("groupname", group.getGroupName());
            request.setAttribute("groupdesc", group.getTgDesc());
            //Collection<Vcustomer> userinGroup = group.getVcustomerCollection();
            List useroutGroup = new ArrayList();
            List userinGroup = new ArrayList();

            List<Vcustomer> allusers = vcustomerJpaController.findVcustomerEntities();
            for (Vcustomer user : allusers) {
                Collection<TGroup> usergroup = user.getTGroupCollection();
                if (!usergroup.contains(group)) {
                    useroutGroup.add(user);
                } else {
                    userinGroup.add(user);
                }
            }
            form.setTgId(groupid);
            request.setAttribute("userinGroup", userinGroup);
            request.setAttribute("useroutGroup", useroutGroup);
        } catch (Exception e) {
            log.error("", e);
            e.printStackTrace();
            throw new BaseException("errors.general");
        }
        //request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward showGroups(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //saveToken(request);
        StringBuffer sb = new StringBuffer(" from TGroup g");
        String jpql = sb.toString();
        pagination = new Pagination(request, response);
        int listCount = jpaDaoService.getEntityCount("select count(g) "+jpql, null).intValue();
        pagination.setRecordCount(listCount);

        List<TGroup> grouplist = jpaDaoService.findEntities("select g "+jpql, null, false, pagination.getFirstResult(), pagination.getPageSize());
        request.setAttribute("grouplist", grouplist);
        request.setAttribute("pagination", pagination.toString());

        return mapping.findForward(SUCCESS);
    }
}
