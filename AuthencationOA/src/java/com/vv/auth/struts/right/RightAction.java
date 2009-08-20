/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.right;

import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.service.IRightService;
import com.vv.auth.persist.service.JpaDaoService;
import com.vv.auth.persist.service.controller.TRightJpaController;
import com.vv.auth.persist.service.controller.exceptions.NonexistentEntityException;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.Pagination;
import com.vv.auth.struts.util.Utility;
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
public class RightAction extends BaseAction {

    @Resource
    private IRightService trightService;
    /*@Resource
    private TRightJpaController trightJpaControl;*/
    @Resource
    private JpaDaoService jpaDaoService;

    private Pagination pagination;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("showRights")) {
            forward = showRights(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("addRightinit")) {
            saveToken(request);
            forward = mapping.findForward(SUCCESS);
        } else if (parameter.equalsIgnoreCase("addRight")) {
            forward = addRight(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("delRight")) {
            forward = delRight(mapping, aform, request, response);
        }
        return forward;
    }

    private ActionForward addRight(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        RightForm form = (RightForm) aform;
        if (isTokenValid(request, true)) {
            TRight right = new TRight(null, form.getRightName(), form.getRightType(), form.getRightPath(), form.getRightDesc());
            if (trightService.findRightByTypeAndPath(right.getRightType(), right.getRightPath()).size() <= 0) {
                trightService.saveRight(right);
            } else {
                throw new BaseException("error.rightexists");
            }
        } else {
            throw new BaseException("error.duplicate.submit");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward delRight(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rightid = request.getParameter("rightid");
        try {
            jpaDaoService.destroy(TRight.class, rightid);
        } catch (Exception e) {
            throw new BaseException("errors.general");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward showRights(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //saveToken(request);
        //List<TRight> rightlist = trightJpaControl.findTRightEntities();
        String jpql = " FROM TRight t";
        pagination = new Pagination(request, response);

        pagination.setRecordCount(jpaDaoService.getEntityCount("SELECT count(t) "+jpql, null));
        List rightlist=jpaDaoService.findEntities("SELECT t "+jpql, null, false,  pagination.getFirstResult(), pagination.getPageSize());

        request.setAttribute("rightlist", rightlist);
        request.setAttribute("pagination", pagination.toString());

        return mapping.findForward(SUCCESS);
    }
}
