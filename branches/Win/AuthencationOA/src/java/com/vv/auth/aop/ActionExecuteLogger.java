/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.aop;

import com.vv.auth.persist.entity.Moniter;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IEntityService;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.struts.util.Utility;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction.StreamInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author X-Spirit
 */
@Aspect
public class ActionExecuteLogger {

    @Resource
    private IEntityService monitorService;
    @Resource
    private IUserService tuserService;

    @Pointcut("execution(* com.vv.auth.struts.platform.base.BaseAction.execute(..)) && args(mapping,..,request,response)")
    private void anyActionExecute(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
    }

    @Pointcut("execution(* com.vv.auth.struts..getStreamInfo(..))&& args(mapping,..,request,response)")
    private void anyGetStreamInfo(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
    }

    @Around("anyActionExecute(mapping,request,response)")
    public Object recordMalForward(ProceedingJoinPoint pjp,ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws Throwable{
        // Before Execution
        String targetForward = mapping.getPath();
        System.out.println(targetForward);
	Object retVal = pjp.proceed();
	// After Execution
        System.out.println(retVal);
        System.out.println(((ActionForward)retVal).getName());
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
            curruser = tuserService.findUserById(userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, "");
            monitorService.create(monitor);
        }
//        String path = mapping.getPath();
//        String reqParamStr = Utility.getRequestParameterAsString(request);
//        if(curruser==null){
//            curruser = new Vcustomer(-1);
//        }



    }

    @AfterThrowing(pointcut = "anyActionExecute(mapping,request,response)", throwing = "ex")
    public void writeLogAfterThrowing(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response, Throwable ex) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = tuserService.findUserById(userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, ex.getLocalizedMessage());
            monitorService.create(monitor);
        }
    }

    @AfterReturning("anyGetStreamInfo(mapping,request,response)")
    public void writeLogAfterReturningStreamInfo(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = tuserService.findUserById(userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, "");
            monitorService.create(monitor);
        }
    }

    @AfterThrowing(pointcut = "anyGetStreamInfo(mapping,request,response)", throwing = "ex")
    public void writeLogAfterStreamInfoThrowing(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response, Throwable ex) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = tuserService.findUserById(userid);
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);
            Moniter monitor = new Moniter(null, curruser, new Date(), path, reqParamStr, ex.getLocalizedMessage());
            monitorService.create(monitor);
        }
    }
}
