package com.vv.auth.struts.platform.base;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.controller.VcustomerJpaController;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vv.auth.struts.util.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author joss
 */
public abstract class BaseAction extends Action {

    public static final Logger log = Logger.getLogger(BaseAction.class);
    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";
    public static final String ERROR_GENERAL = "errors.general";

    abstract public ActionForward executeAction(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionForward forwardPage = null;
        try {

            if (actionForm instanceof PageForm) {
                ((PageForm) actionForm).setPageValue(request);
            }
            if (!verifyCert(request)) {
                //return mapping.findForward("nopermission");
            }

            log.info(Utility.convertTimeStampToString(new Date(System.currentTimeMillis()), "yyyy-MM-dd hh:mm:ss") + "request url:----------" + mapping.getPath());

            //设置本地语言环境
            Locale defLocale = this.getLocale(request);
            this.setLocale(request, defLocale);

            HttpSession ses = request.getSession(false);
            ConcurrentMap user = (ConcurrentMap) ses.getAttribute("USERMAP");
            if (!mapping.getPath().equalsIgnoreCase("/Welcome") && !mapping.getPath().equalsIgnoreCase("/login") && !mapping.getPath().equalsIgnoreCase("/ClientCer/initClientCerReg") && !mapping.getPath().equalsIgnoreCase("/ClientCer/clientCerReg") && !mapping.getPath().equalsIgnoreCase("/checkEmail") && !mapping.getPath().equalsIgnoreCase("/checkLoginName") && !mapping.getPath().equalsIgnoreCase("/reset") && !mapping.getPath().equalsIgnoreCase("/findpwd")) {
                //如果Session中没有合法用户的信息，则注销会话

                if (user == null || user.get("userid") == null || user.get("name") == null) {
                    request.setAttribute("login", "Y");
                    forwardPage = new ActionForward("/reset.do");
                } else if (user != null && user.get("userPermission") != null) {
                    ConcurrentMap userPermission = (ConcurrentMap) ((ConcurrentMap) ses.getAttribute("USERMAP")).get("userPermission");
                    if (((String) user.get("validateRight")).equals("false")) {
                        forwardPage = executeAction(mapping, actionForm, request, response);
                    } else if (userPermission.get(mapping.getPath() + ".do") == null && !mapping.getPath().equals("/findpwd") && !mapping.getPath().equals("/reset")) {
                        forwardPage = mapping.findForward("nopermission");
                        return forwardPage;
                    } else {
                        forwardPage = executeAction(mapping, actionForm, request, response);
                    }
                }
            } else {
                if (user != null && user.get("userPermission") != null && (mapping.getPath().equalsIgnoreCase("/Welcome") || mapping.getPath().equalsIgnoreCase("/login"))) {
                    //ConcurrentMap userPermission = (ConcurrentMap) ((ConcurrentMap) ses.getAttribute("USERMAP")).get("userPermission");
                    List<TRight> rightlist = (List<TRight>) ((ConcurrentMap) ses.getAttribute("USERMAP")).get("userMenu");
                    if (rightlist.size() > 0) {
                        TRight right = rightlist.get(0);
                        forwardPage = new ActionForward(right.getRightPath(), true);
                    } else {
                        forwardPage = mapping.findForward("nopermission");
                    }
                    return forwardPage;
                }
//				if(user != null && user.get("userPermission") != null && !mapping.getPath().equalsIgnoreCase("/reset") && !mapping.getPath().equalsIgnoreCase("/login")){
//					ConcurrentMap userPermission = (ConcurrentMap) ((ConcurrentMap) ses.getAttribute("USERMAP")).get("userPermission");
//                    if(((String)user.get("validateRight")).equals("false")){
//                        forwardPage = executeAction(mapping, actionForm, request, response);
//                    }else if(userPermission.get(mapping.getPath() + ".do") == null && !mapping.getPath().equals("/user/changepass/info") && !mapping.getPath().equals("/user/changepass")){
//						forwardPage = mapping.findForward("nopermission");
//						return forwardPage;
//					}else{
//                        forwardPage = executeAction(mapping, actionForm, request, response);
//                    }
//				}else{
                forwardPage = executeAction(mapping, actionForm, request, response);
//                }
                //if(request.getSession().getAttribute("USERMAP") != null)
                //	log.info(Utility.convertTimeStampToString(new Date(System.currentTimeMillis()), "yyyy-MM-dd hh:mm:ss") + "-" + ((Map) request.getSession().getAttribute("USERMAP")).get("email") + "-request url:----------" + mapping.getPath());

            }

        } catch (BaseException e) {
            log.error("", e);
            e.printStackTrace();
            forwardPage = processBaseException(request, mapping, e);
        } catch (Exception e) {
            log.error("", e);
            e.printStackTrace();
            BaseException ex = new BaseException(e);
            forwardPage = processBaseException(request, mapping, ex);
        }
        if (forwardPage != null) {
            return forwardPage;
        } else {
            return mapping.findForward("nopermission");
        }

    }

    /**
     * 如果错误BaseException返回input地址
     */
    protected ActionForward processBaseException(HttpServletRequest request,
            ActionMapping mapping, BaseException ex) {
        ActionErrors errors = new ActionErrors();
        ActionForward forward = null;

        if (mapping.findForward(BaseContect.FORWARD_FAILURE) != null) {
            forward = mapping.findForward(BaseContect.FORWARD_FAILURE);
        } else if (mapping.getInput() != null) {
            forward = new ActionForward(mapping.getInput());
        } else if (ex.getInputurl() != null) {
            forward = new ActionForward(ex.getInputurl());
        }

        processBaseException(errors, ex);
        List exceptionList = ex.getExcepionsList();
        if (exceptionList != null && !exceptionList.isEmpty()) {
            for (int i = 0; i < exceptionList.size(); i++) {
                BaseException subException = (BaseException) exceptionList.get(i);
                processBaseException(errors, subException);
            }
        }

        saveErrors(request, errors);

        return forward;
    }

    protected void processBaseException(ActionErrors errors, BaseException ex) {
        String lsErrMsg = ex.getErrorMessage();
        if (lsErrMsg != null && lsErrMsg.length() > 0) {
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(lsErrMsg.replace("\"", "")));
        }
    }

    protected ActionMessages getMessages(String key) {
        ActionMessages messages = new ActionMessages();
        ActionMessage am = new ActionMessage(key);
        messages.add(key, am);
        return messages;
    }

    private boolean verifyCert(HttpServletRequest request) {
        String certSubject = null;
        java.security.cert.X509Certificate[] certChain = (java.security.cert.X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        if (null != certChain) {
            int len = certChain.length;
            if (len > 0) {

                try {
                    java.security.cert.X509Certificate cert = (java.security.cert.X509Certificate) certChain[0];
                    java.security.Principal pSubject = cert.getSubjectDN();
                    certSubject = pSubject.getName();
                    String certCN = certSubject.split(",")[0].trim().split("=")[1];
                    if (Utility.isNotEmpty(certCN)) {
                        setUserMap(request, certCN);
                        return true;
                    } else {
                        return false;
                    }

                } catch (Exception e) {
                    log.error("", e);
                    e.printStackTrace();
                    return false;
                }


            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 根据用户实体得到用户Map并存入Session
     * @param request
     * @param user
     */
    private void setUserMap(HttpServletRequest request, String username) throws Exception {
        VcustomerJpaController vcustomerJpaController = new VcustomerJpaController();
        List<Vcustomer> userList = vcustomerJpaController.findVcustomerByName(username);
        Vcustomer user = userList.get(0);
        ConcurrentMap usermap = new ConcurrentHashMap();
        usermap.put("name", user.getName());
        //usermap.put("email", user.getEmail());
        usermap.put("userid", user.getUserid());

        Collection<TGroup> groupcol = user.getTGroupCollection();

        ConcurrentMap<String, TRight> userPermission = new ConcurrentHashMap<String, TRight>();
        ArrayList<TRight> userMenu = new ArrayList<TRight>();
        for (TGroup group : groupcol) {
            usermap.put("groupid", group.getTgId());
            if ("SuperAdmin".equalsIgnoreCase(group.getGroupName()) || "developer".equalsIgnoreCase(group.getGroupName())) {
                usermap.put("validateRight", "false");
            } else {
                usermap.put("validateRight", "true");
            }
            //TRight[] rightarr=null;
            //rightarr=group.getTRightCollection().toArray(rightarr);
            //int menunum=0;
            for (TRight right : group.getTRightCollection()) {

                if (right.getRightType().equals(BaseContect.RIGHT_TYPE_MENU)) {
                    if (!userMenu.contains(right)) {
                        userMenu.add(right);
                    }
                    //menunum++;
                    //if(menunum==1){
                    //    forward = new ActionForward(right.getRightPath(), true);
                    //}
                }
                if (right.getRightType().equals(BaseContect.RIGHT_TYPE_PATH)) {
                    userPermission.put(right.getRightPath(), right);
                }
            }
        }
        usermap.put("userPermission", userPermission);
        usermap.put("userMenu", userMenu);
        request.getSession(true).setAttribute("USERMAP", usermap);
    }
}
