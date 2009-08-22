/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.functionC;

import com.vv.auth.struts.platform.base.BaseAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author hp
 */
public class FunctionC extends BaseAction {

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(SUCCESS);
    }
}
