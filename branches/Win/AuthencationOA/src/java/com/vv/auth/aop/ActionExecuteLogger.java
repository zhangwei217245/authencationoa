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
import org.apache.struts.actions.DownloadAction.FileStreamInfo;
import org.apache.struts.actions.DownloadAction.ResourceStreamInfo;
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
@Aspect //切面的声明，因为要做横切的操作
public class ActionExecuteLogger {
    
    @Resource
    private IJpaDaoService jpaDaoService;

    @Pointcut("execution(* com.vv.auth.struts.platform.base.BaseAction.execute(..)) && args(mapping,..,request,response)")//功能执行的时点
    private void anyActionExecute(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
    }

    @Pointcut("execution(* com.vv.auth.struts..*.*Action.getStreamInfo(..))&& args(mapping,..,request,response)")//针对下载的切点
    private void anyGetStreamInfo(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
    }

    private void persistMalForward(HttpServletRequest request,String requestPath) throws Throwable{
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer user = null;
        //仅当SESSION中的用户ID存在的时候，对错误访问进行记录。即不记录未注册用户的错误访问状况。
        if(userid!=null){
            user = jpaDaoService.findOneEntityById(Vcustomer.class, userid);
            Map params = new HashMap();
            params.put("rightType", "path");
            params.put("rightPath", requestPath+".do");
            List rstlst = jpaDaoService.findByNamedQueryAndNamedParams("TRight.findByRightTypeAndRightPath", params);
            if(Utility.isNotEmpty(rstlst)){
                TRight right = (TRight)rstlst.get(0);
                jpaDaoService.create(new Illegalaccess(new Date(), user, right));
            }
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
                persistMalForward(request,requestPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	return retVal;
    }
    
    @Around("anyGetStreamInfo(mapping,request,response)")
    public Object recordMalDownload(ProceedingJoinPoint pjp,ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws Throwable{
        // Before Execution
        String requestPath = mapping.getPath();
        System.out.println(requestPath);
	Object retVal = pjp.proceed();
        String typeName = retVal.getClass().getCanonicalName();
        if(Utility.isNotEmpty(typeName)&&typeName.contains("ResourceStreamInfo")){
            persistMalForward(request, requestPath);
        }
	// After Execution
        System.out.println(retVal);
	return retVal;
    }

    @AfterReturning("anyActionExecute(mapping,request,response)")
    public void writeLogAfterReturning(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        Integer userid = Utility.getCurrSessionUserid(request);
        Vcustomer curruser = null;
        if (userid != null) {
            curruser = jpaDaoService.findOneEntityById(Vcustomer.class, userid);//第四代
            String path = mapping.getPath();
            String reqParamStr = Utility.getRequestParameterAsString(request);//请求参数
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

    //针对下载
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
