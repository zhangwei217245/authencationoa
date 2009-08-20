/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.register;

import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.MD5Text;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author X-Spirit
 */
public class RegisterAction extends BaseAction {

    @Resource
    private IUserService tuserService;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("initRegister")) {
            return mapping.findForward(SUCCESS);
        } else if (parameter.equalsIgnoreCase("execRegister")) {
            forward = execRegister(mapping, aform, request, response);
        }
        return forward;
    }

    private ActionForward execRegister(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        RegisterForm regform = (RegisterForm) aform;
        Vcustomer user = new Vcustomer();
        BeanUtils.copyProperties(user, regform);
        user.setPassword(new MD5Text().MD5Encode(user.getPassword()));
        try {
            tuserService.saveUser(user);
            forward = mapping.findForward(SUCCESS);
        } catch (PreexistingEntityException pe) {
            pe.printStackTrace();
            log.error("", pe);
            throw new BaseException("error.register.preexist");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            throw new BaseException(ERROR_GENERAL);
        }
        return forward;
    }
}
