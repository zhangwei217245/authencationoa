/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.util;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericTypeValidator;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.UrlValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.RequestUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.struts.validator.Resources;

/**
 *
 * @author X-Spirit
 */
public class AuthValidator implements Serializable {

    /**
     * Commons Logging instance.
     */
    private static final Log log = LogFactory.getLog(AuthValidator.class);
    /**
     * The message resources for this package.
     */
    private static MessageResources sysmsgs =
            MessageResources.getMessageResources(
            "org.apache.struts.validator.LocalStrings");
    public static final String FIELD_TEST_NULL = "NULL";
    public static final String FIELD_TEST_NOTNULL = "NOTNULL";
    public static final String FIELD_TEST_EQUAL = "EQUAL";

    public static boolean validatePosIntRange(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {
        String value = null;
        value = evaluateBean(bean, field);
        int val = Integer.parseInt(value);
        if (!GenericValidator.isBlankOrNull(value) && !(val > 0 && val < Integer.MAX_VALUE)) {
            errors.add(field.getKey(),
                    Resources.getActionMessage(validator, request, va, field));

            return false;
        } else {
            return true;
        }
    }

    /**
     * test whether comfirmPassword equals password
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @param validator
     * @param request
     * @return
     */
    public static boolean validateConfirmPwd(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {
        String value = null;
        String targetPwd = request.getParameter("password");
        value = evaluateBean(bean, field);


        if (!GenericValidator.isBlankOrNull(value) && !targetPwd.equals(value)) {
            errors.add(field.getKey(),
                    Resources.getActionMessage(validator, request, va, field));

            return false;
        } else {
            return true;
        }
    }

    /**
     * validate imgcode from session scope
     *
     * @param bean      The bean validation is being performed on.
     * @param va        The <code>ValidatorAction</code> that is currently
     *                  being performed.
     * @param field     The <code>Field</code> object associated with the
     *                  current field being validated.
     * @param errors    The <code>ActionMessages</code> object to add errors
     *                  to if any validation errors occur.
     * @param validator The <code>Validator</code> instance, used to access
     *                  other field values.
     * @param request   Current request object.
     * @return True if valid, false otherwise.
     */
    public static boolean validateImgCode(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {
        String value = null;

        value = evaluateBean(bean, field);

        if (!GenericValidator.isBlankOrNull(value) && !equalsImgCode(request, value)) {
            errors.add(field.getKey(),
                    Resources.getActionMessage(validator, request, va, field));

            return false;
        } else {
            return true;
        }
    }

    /**
     * validate imgcode from session scope
     * @param request
     * @param value
     * @return
     */
    public static boolean equalsImgCode(HttpServletRequest request, String value) {
        boolean result = false;
        String imgcode = request.getSession(false).getAttribute("sRand") + "";
        if (imgcode.equals(value)) {
            result = true;
        }
        return result;
    }

    /**
     * @param bean
     * @param field
     * @return
     */
    private static String evaluateBean(Object bean, Field field) {
        String value;

        if (isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        }

        return value;
    }

    /**
     * Return <code>true</code> if the specified object is a String or a
     * <code>null</code> value.
     *
     * @param o Object to be tested
     * @return The string value
     */
    protected static boolean isString(Object o) {
        return (o == null) ? true : String.class.isInstance(o);
    }
}
