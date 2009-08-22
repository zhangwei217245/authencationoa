package com.vv.auth.struts.platform.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author joss
 */
public class BaseForm extends ValidatorForm {

    public static final String ADD = "ADD";
    public static final String UPDATE = "UPDATE";
    public static final String QUERY = "QUERY";
    public static final String OTHER = "OTHER";
    public static final String DELETE = "DELETE";
    public static final Logger log = Logger.getLogger(BaseAction.class);

    public BaseForm() {
        super();
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }
}
