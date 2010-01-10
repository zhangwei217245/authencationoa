/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.serverCer;

import com.vv.auth.certification.CerPath;
import com.vv.auth.certification.serverInsertFileProcess;
import com.vv.auth.persist.entity.Certificatereg;
import com.vv.auth.persist.service.ICertificateregService;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;
import com.vv.auth.struts.util.Utility;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author hp
 */
public class ServerCerAction extends BaseAction {

    @Resource
    ICertificateregService certificateregService;
    @Resource
    serverInsertFileProcess serverCerCreate;
    @Resource
    CerPath cerPathBean;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();
        if (parameter.equalsIgnoreCase("initServerCerReg")) {
            forward = initServerCerReg(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("serverCerReg")) {
            forward = serverCerReg(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("showCerReg")) {
            forward = showCerReg(mapping, aform, request, response);
        }
        return forward;
    }
//////////////////////////////////

    private ActionForward initServerCerReg(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        saveToken(request);
        ServerCerForm sform = (ServerCerForm) aform;
        sform.setLocation(cerPathBean.getServerCerPath());
        return mapping.findForward(SUCCESS);
    }
////////////////////////////////////////////////

    private ActionForward serverCerReg(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServerCerForm sform = (ServerCerForm) aform;
        Certificatereg cereg = new Certificatereg();
        String errmsg = "";
        if (isTokenValid(request, true)) {

            try {
                BeanUtils.copyProperties(cereg, sform);
                //copyProperties之后，主键居然被置为0了。Hibernate要求实体类如果指定了具体的主键生成策略
                //则在实体对象被持久化之前，其ID不能为具体值，必须是NULL。否则就会抛错：detached entity passed to persist
                cereg.setKsdid(null);
                Calendar now = Calendar.getInstance();
                cereg.setDdaybeg(now.getTime());
                int nowadays = now.get(Calendar.DAY_OF_YEAR);

                int dday = sform.getDday().intValue();
                now.set(Calendar.DAY_OF_YEAR, nowadays + dday);
                cereg.setDdayover(now.getTime());
                if (certificateregService.findCertificateregByNameAndLocation(cereg.getName(), cereg.getLocation()).size() > 0) {
                    errmsg = "Such right already exists in your database";
                    throw new Exception();
                } else {
                    serverCerCreate.execute(cereg);

                    certificateregService.saveCertificatereg(cereg);
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("" + e);
                if (errmsg.isEmpty()) {
                    throw new BaseException("errors.general");
                } else {
                    throw new BaseException(errmsg);
                }
            }
        } else {
            saveToken(request);
            throw new BaseException("errors.token");
        }
        request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
        return mapping.findForward(SUCCESS);
    }
///////////////////////////////////////////

    private ActionForward showCerReg(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchname = request.getParameter("searchname");
        String showtype = request.getParameter("showtype");
        StringBuffer jpql = new StringBuffer("select distinct object(o) from Certificatereg as o where 1=1");
        if (Utility.isNotEmpty(searchname)) {
            jpql.append(" and o.name like '%").append(searchname).append("%'");
        }
        if ("expired".equals(showtype)) {
            jpql.append(" and o.ddayover<CURRENT_DATE");
        }
        if ("unexpired".equals(showtype)) {
            jpql.append(" and o.ddayover>CURRENT_DATE");
        }
        System.out.println(jpql.toString());
        List<Certificatereg> list = certificateregService.searchCertificateregs(jpql.toString(), null);
        request.setAttribute("rstlst", list);
        return mapping.findForward(SUCCESS);
    }
}
