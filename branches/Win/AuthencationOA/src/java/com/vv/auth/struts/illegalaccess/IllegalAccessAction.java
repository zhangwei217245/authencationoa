/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess;

import com.vv.auth.struts.platform.base.BaseAction;
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

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();

        if (parameter.equalsIgnoreCase("illegalAccessInit")) {
            forward = IllegalAccessInit(mapping, aform,request, response);
        } else if (parameter.equalsIgnoreCase("illegalAccessShow")) {
            forward = IllegalAccessShow(mapping, aform,request, response);
        }
        return forward;
    }

    private ActionForward IllegalAccessInit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        return mapping.findForward(SUCCESS);
    }

    private ActionForward IllegalAccessShow(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        return mapping.findForward(SUCCESS);
    }


}
