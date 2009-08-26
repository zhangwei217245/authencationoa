/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.login;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.MD5Text;
import com.vv.auth.struts.util.PortConfig;
import com.vv.auth.struts.util.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author X-Spirit
 */
public class LoginAction extends BaseAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    @Resource
    private IUserService tuserService;
    @Resource
    private PortConfig portConfig;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("initlogin")) {
            forward = initLogin(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("userlogin")) {
            forward = userLogin(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("reset")) {
            forward = reset(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("secureset")) {
            secureset(mapping, aform, request, response);
        }
        return forward;
    }

    private ActionForward initLogin(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        request.setAttribute("httpsPort", portConfig.getHttpsPort());
        request.setAttribute("httpPort", portConfig.getHttpPort());
        //if(verifyCert(request)){
        //forward=mapping.findForward("welcome");

        //}else{
        forward = mapping.findForward("authened");
        //}
        return forward;

    }

    private void secureset(ActionMapping mapping, ActionForm aform, HttpServletRequest request, HttpServletResponse response) {
        request.getRequestDispatcher("http://" + request.getServerName() + ":8080" + request.getContextPath());
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

    private ActionForward reset(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession(false).getAttribute("USERMAP") != null) {
            request.getSession(false).setAttribute("USERMAP", null);
        }

        return mapping.findForward(SUCCESS);
    }

    private ActionForward userLogin(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        LoginForm form = (LoginForm) aform;

        String username = form.getUsername();
        String password = form.getPassword();

        List<Vcustomer> userList = tuserService.findUserByName(username);

        if (Utility.isEmpty(userList)) {
            throw new BaseException("user.not.exists");
        } else {
            Vcustomer user = userList.get(0);
            if(user.getEnable().equals("N")){
                throw new BaseException("user.not.exists");
            }
            //if(new MD5Text().MD5Encode(password).equals(user.getPassword())){
            if (password.equals(user.getPassword().trim())) {
                //System.out.println(password);
                //System.out.println(user.getPassword());
                forward = setUserMap(request, user);
                //修改用户登陆次数和上次登录时间，首次登录时间，然后合并到数据库
                //updateUserInfo(user);
                //
            } else {
                throw new BaseException("user.pwd.invalid");
            }
        }
        return forward;
    }
//    private void updateUserInfo(Vcustomer user){
//        Date date = new Date();
//        user.setCount(user.getCount()+1L);
//        user.setLastLoginTime(date);
//        if(user.getLoginTime()==null){
//            user.setLoginTime(date);
//        }
//        tuserService.updateUser(user);
//    }

    /**
     * 根据用户实体得到用户Map并存入Session
     * @param request
     * @param user
     */
    private void setUserMap(HttpServletRequest request, String username) throws Exception {
        List<Vcustomer> userList = tuserService.findUserByName(username);
        Vcustomer user = userList.get(0);
        ConcurrentMap usermap = new ConcurrentHashMap();
        usermap.put("name", user.getName());
        //usermap.put("email", user.getEmail());
        usermap.put("userid", user.getUserid());

        Collection<TGroup> groupcol = user.getTGroupCollection();

        ConcurrentMap<String, TRight> userPermission = new ConcurrentHashMap<String, TRight>();
        ArrayList<TRight> userMenu = new ArrayList<TRight>();
        StringBuffer tgsb = new StringBuffer();
        for (TGroup group : groupcol) {
            usermap.put("groupid", group.getTgId());
            tgsb.append(group.getTgDesc());
            tgsb.append(" & ");
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
        tgsb = tgsb.delete(tgsb.length()-3,tgsb.length());
        usermap.put("atGroup", tgsb.toString());
        usermap.put("userPermission", userPermission);
        usermap.put("userMenu", userMenu);
        request.getSession(true).setAttribute("USERMAP", usermap);
    }

    /**
     * 根据用户实体得到用户Map并存入Session
     * @param request
     * @param user
     */
    private ActionForward setUserMap(HttpServletRequest request, Vcustomer user) {
        ActionForward forward = null;
        ConcurrentMap usermap = new ConcurrentHashMap();
        usermap.put("name", user.getName());
        //usermap.put("email", user.getEmail());
        usermap.put("userid", user.getUserid());

        Collection<TGroup> groupcol = user.getTGroupCollection();

        ConcurrentMap<String, TRight> userPermission = new ConcurrentHashMap<String, TRight>();
        ArrayList<TRight> userMenu = new ArrayList<TRight>();
        StringBuffer tgsb = new StringBuffer();
        for (TGroup group : groupcol) {
            usermap.put("groupid", group.getTgId());
            tgsb.append(group.getTgDesc());
            tgsb.append(" & ");
            if ("SuperAdmin".equalsIgnoreCase(group.getGroupName()) || "developer".equalsIgnoreCase(group.getGroupName())) {
                usermap.put("validateRight", "false");
            } else {
                usermap.put("validateRight", "true");
            }
            //TRight[] rightarr=null;
            //rightarr=group.getTRightCollection().toArray(rightarr);
            int menunum = 0;
            for (TRight right : group.getTRightCollection()) {

                if (right.getRightType().equals(BaseContect.RIGHT_TYPE_MENU)) {
                    if (!userMenu.contains(right)) {
                        userMenu.add(right);
                    }
                    menunum++;
                    if (menunum == 1) {
                        forward = new ActionForward(right.getRightPath(), true);
                    }
                }
                if (right.getRightType().equals(BaseContect.RIGHT_TYPE_PATH)) {
                    userPermission.put(right.getRightPath(), right);
                }
            }
//            for (int i=0;i<rightarr.length;i++){
//                TRight right = rightarr[i];
//                int menunum=0;
//                if(right.getRightType().equals(BaseContect.RIGHT_TYPE_MENU)){
//                    userMenu.add(right);
//                    menunum++;
//                    if(menunum==1){
//                        forward = new ActionForward(right.getRightPath(), true);
//                    }
//                }
//                if(right.getRightType().equals(BaseContect.RIGHT_TYPE_PATH)){
//                    userPermission.put(right.getRightPath(), right);
//                }
//            }
        }
        tgsb = tgsb.delete(tgsb.length()-3,tgsb.length());
        usermap.put("atGroup", tgsb.toString());
        usermap.put("userPermission", userPermission);
        usermap.put("userMenu", userMenu);
        request.getSession(true).setAttribute("USERMAP", usermap);
        return forward;
    }
}
