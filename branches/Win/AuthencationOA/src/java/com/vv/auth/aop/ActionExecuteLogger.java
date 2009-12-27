/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.aop;

import com.vv.auth.persist.entity.Moniter;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.entity.Illegalaccess;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.struts.util.Utility;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author X-Spirit
 */
@Aspect
public class ActionExecuteLogger {
    
    @Resource
    private IJpaDaoService jpaDaoService;

    @Pointcut("execution(* com.vv.auth.struts.platform.base.BaseAction.execute(..)) && args(mapping,..,request,response)")
    private void anyActionExecute(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
    }

    @Pointcut("execution(* com.vv.auth.struts..getStreamInfo(..))&& args(mapping,..,request,response)")
    private void anyGetStreamInfo(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
    }

    private void recordMalForward(HttpServletRequest request,String requestPath) throws Throwable{
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer user = null;
        if(userid!=null){
            user = jpaDaoService.findOneEntityById(Vcustomer.class, userid);
        }
        Map params = new HashMap();
        params.put("rightType", "path");
        params.put("rightPath", requestPath+".do");
        List rstlst = jpaDaoService.findByNamedQueryAndNamedParams("TRight.findByRightTypeAndRightPath", params);
        if(Utility.isNotEmpty(rstlst)){
            TRight right = (TRight)rstlst.get(0);
            jpaDaoService.create(new Illegalaccess(new Date(), user, right));
        }
    }

    @Around("anyActionExecute(mapping,request,response)")
    public Object recordMalForward(ProceedingJoinPoint pjp,ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws Throwable{
        // Before Execution
        String requestPath = mapping.getPath();
        ActionForward targetForward = mapping.findForward("success");

        if(requestPath.equals("/Welcome")){
            targetForward = mapping.findForward("authened");
        }
        System.out.println(targetForward);
	Object retVal = pjp.proceed();
	// After Execution
        System.out.println(retVal);
        System.out.println(retVal.equals(targetForward));
        try {
            if(!retVal.equals(targetForward)){
                recordMalForward(request,requestPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	return retVal;
    }
    
    @Around("anyGetStreamInfo(mapping,request,response)")
    public Object recordMalDownload(ProceedingJoinPoint pjp,ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws Throwable{
        // Before Execution
        String targetForward = mapping.getPath();
        System.out.println(targetForward);
	Object retVal = pjp.proceed();
	// After Execution
        System.out.println(retVal);
	return retVal;
    }

    @AfterReturning("anyActionExecute(mapping,request,response)")
    public void writeLogAfterReturning(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = jpaDaoService.findOneEntityById(Vcustomer.class, userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, "");
            jpaDaoService.create(monitor);
        }

    }

    @AfterThrowing(pointcut = "anyActionExecute(mapping,request,response)", throwing = "ex")
    public void writeLogAfterThrowing(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response, Throwable ex) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = jpaDaoService.findOneEntityById(Vcustomer.class, userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, ex.getLocalizedMessage());
            jpaDaoService.create(monitor);
        }
    }

    @AfterReturning("anyGetStreamInfo(mapping,request,response)")
    public void writeLogAfterReturningStreamInfo(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = jpaDaoService.findOneEntityById(Vcustomer.class, userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, "");
            jpaDaoService.create(monitor);
        }
    }

    @AfterThrowing(pointcut = "anyGetStreamInfo(mapping,request,response)", throwing = "ex")
    public void writeLogAfterStreamInfoThrowing(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response, Throwable ex) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = jpaDaoService.findOneEntityById(Vcustomer.class, userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, ex.getLocalizedMessage());
            jpaDaoService.create(monitor);
        }
    }
}
