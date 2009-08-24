/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.login;

import com.vv.auth.struts.util.PortConfig;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author X-Spirit
 */
public class ResetAction extends Action {

    @Resource
    private PortConfig portConfig;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("reset")) {
            forward = reset(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("secureset")) {
            secureset(mapping, aform, request, response);
        }
        return forward;
    }

    private void secureset(ActionMapping mapping, ActionForm aform, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getSession(false).getAttribute("USERMAP") != null) {
                request.getSession(false).setAttribute("USERMAP", null);
            }
            //RequestDispatcher dispatcher = request.getRequestDispatcher("http://" + request.getServerName() + ":8080" + request.getContextPath());
            //dispatcher.forward(request, response);
            System.out.println(portConfig.getHttpPort());
            response.sendRedirect("http://" + request.getServerName() + ":" + portConfig.getHttpPort() + request.getContextPath());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private ActionForward reset(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession(false).getAttribute("USERMAP") != null) {
            request.getSession(false).setAttribute("USERMAP", null);
        }

        return mapping.findForward("success");
    }
}
