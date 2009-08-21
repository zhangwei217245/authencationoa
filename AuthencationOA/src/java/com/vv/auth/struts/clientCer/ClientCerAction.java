/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.clientCer;

import com.vv.auth.certification.CerPath;
import com.vv.auth.certification.customerDelFileProcess;
import com.vv.auth.certification.customerInsertFileProcess;
import com.vv.auth.persist.entity.Certificatereg;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.ICertificateregService;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author X-Spirit
 */
public class ClientCerAction extends BaseAction {

    @Resource
    IUserService tuserService;
    @Resource
    customerInsertFileProcess customerCerCreate;
    @Resource
    CerPath cerPathBean;
    @Resource
    customerDelFileProcess customerCerDestroy;
    @Resource
    ICertificateregService certificateregService;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("initClientCerReg")) {
            forward = initClientCerReg(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("clientCerReg")) {
            forward = clientCerReg(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("searchUser")) {
            forward = searchUser(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("verifyUser")) {
            forward = verifyUser(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("deleteUser")) {
            forward = deleteUser(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("initDownloadCer")) {
            forward = initDownloadCer(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("DownloadCer")) {
            DownloadCer(mapping, aform, request, response);
        }
        return forward;
    }

    private void DownloadCer(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userid = request.getParameter("userid");
        Vcustomer user = tuserService.findUserById(new Integer(userid));
        OutputStream o = response.getOutputStream();
        byte b[] = new byte[1024];
        //String name=request.getParameter("uname");
        String name = user.getName();
        File fileLoad = new File(cerPathBean.getClientCerPath() + "/" + name + "/" + name + ".p12");
        response.setHeader("Content-disposition", "attachment;filename=" + name + ".p12");
        response.setContentType("application/x-tar");
        long fileLength = fileLoad.length();
        String length = String.valueOf(fileLength);
        response.setHeader("Content_Length", length);
        FileInputStream in = new FileInputStream(fileLoad);
        int n = 0;
        while ((n = in.read(b)) != -1) {
            o.write(b, 0, n);
        }
        o.close();
    }

    private ActionForward clientCerReg(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ClientCerForm ccf = (ClientCerForm) aform;
        Vcustomer vc = new Vcustomer();
        if (isTokenValid(request, true)) {
            try {
                BeanUtils.copyProperties(vc, ccf);
                Calendar now = Calendar.getInstance();
                vc.setDdaybeg(now.getTime());
                int nowadays = now.get(Calendar.DAY_OF_YEAR);

                int dday = Integer.parseInt(ccf.getDday());
                now.set(Calendar.DAY_OF_YEAR, nowadays + dday);
                vc.setDdayover(now.getTime());
                vc.setVerifystatus("N");

                tuserService.saveUser(vc);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("" + e);
                throw new BaseException("errors.general");
            }

        } else {
            saveToken(request);
            throw new BaseException("errors.token");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }

    private ActionForward deleteUser(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String userid = request.getParameter("userid");
            Vcustomer user = tuserService.findUserById(Integer.parseInt(userid));
            List<Certificatereg> rstlst = certificateregService.findCertificateRegNotExpire();
            Certificatereg cereg = rstlst.get(0);
            if ("Y".equalsIgnoreCase(user.getVerifystatus())) {
                customerCerDestroy.execute(user.getName(), cereg.getLocation(), cereg.getCpass(), cerPathBean.getClientCerPath() + File.separator + user.getName());
            }
            tuserService.deleteUser(Integer.parseInt(userid));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e);
            throw new BaseException("errors.general");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);

    }

    private ActionForward initClientCerReg(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        saveToken(request);
        return mapping.findForward(SUCCESS);
    }

    private ActionForward initDownloadCer(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userid = request.getParameter("userid");
        if (Utility.isEmpty(userid)) {
            ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
            if (usermap != null) {
                userid = usermap.get("userid") + "";
            }
        }
        try {
            Vcustomer vcustomer = (Vcustomer) tuserService.findUserById(Integer.parseInt(userid));
            request.setAttribute("curruser", vcustomer);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            throw new BaseException("error.general");
        }

        return mapping.findForward(SUCCESS);

    }

    private ActionForward searchUser(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ClientCerForm ccf = (ClientCerForm) aform;
        String searchname = ccf.getSearchname();
        String certype = ccf.getCertype();
        String verifystatus = ccf.getVerifystatus();
        StringBuffer jpql = new StringBuffer("select distinct object(o) from Vcustomer as o where 1=1");
        if (Utility.isNotEmpty(searchname)) {
            jpql.append(" and o.name like '%").append(searchname).append("%'");
        }
        if ("expired".equals(certype)) {
            jpql.append(" and o.ddayover<CURRENT_DATE");
        }
        if ("unexpired".equals(certype)) {
            jpql.append(" and o.ddayover>CURRENT_DATE");
        }
        if (Utility.isNotEmpty(verifystatus)) {
            jpql.append(" and o.verifystatus='").append(verifystatus).append("'");
        }

        System.out.println(jpql.toString());
        List<Vcustomer> list = tuserService.searchVcustomer(jpql.toString(), null);
        request.setAttribute("rstlst", list);
        return mapping.findForward(SUCCESS);
    }

    private ActionForward verifyUser(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String errmsg=null;
        try {
            String userid = request.getParameter("userid");
            Vcustomer user = tuserService.findUserById(Integer.parseInt(userid));
            List<Certificatereg> rstlst = certificateregService.findCertificateRegNotExpire();
            if(Utility.isEmpty(rstlst)){
                errmsg="error.certification.expired";
                throw new BaseException("");
            }
            Certificatereg cereg = rstlst.get(0);
            customerCerCreate.execute(user, cereg);
            user.setVerifystatus("Y");
            tuserService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e);
            if (Utility.isNotEmpty(errmsg)){
                throw new BaseException(errmsg);
            }else{
                throw new BaseException("errors.general");
            }
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }
}
