/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.document;

import com.vv.auth.persist.entity.Document;
import com.vv.auth.persist.entity.Documenttype;
import com.vv.auth.persist.entity.Documentverify;
import com.vv.auth.persist.entity.IEntity;
import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IEntityService;
import com.vv.auth.persist.service.IGroupService;
import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.persist.service.IUserService;
import com.vv.auth.struts.platform.base.BaseAction;


import com.vv.auth.struts.platform.base.BaseContect;
import com.vv.auth.struts.platform.base.BaseException;

import com.vv.auth.struts.util.FileUtility;
import com.vv.auth.struts.util.Pagination;
import com.vv.auth.struts.util.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

/**
 *
 * @author hp
 */
public class DocumentAction extends BaseAction {

    public static final String FORMATE_DATE = "yyyy-MM-dd HH:mm:ss";
    @Resource
    private IEntityService documentService;
    @Resource
    private IEntityService documentTypeService;
    @Resource
    private IEntityService documentPathService;
    @Resource
    private IEntityService documentVerifyService;
    @Resource
    private IUserService tuserService;
    @Resource
    private IGroupService tgroupService;
    @Resource
    private AttachmentPathBean attachmentPathBean;
    @Resource
    private IJpaDaoService jpaDaoService;


    private Pagination pagination;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward forward = null;
        String parameter = mapping.getParameter();

        if (parameter.equalsIgnoreCase("documentCenter")) {
            forward = documentCenter(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("documentTree")) {
            forward = documentTree(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("createDocument")) {
            forward = createDocument(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("saveDocument")) {
            forward = saveDocument(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("showCreatedDocument")) {
            forward = showCreatedDocument(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("viewDocDetail")) {
            forward = viewDocDetail(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("showPendingDocument")) {
            forward = showPendingDocument(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("auditDocument")) {
            forward = auditDocument(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("showAuditedDocument")) {
            forward = showAuditedDocument(mapping, aform, request, response);
        }

        return forward;
    }

    /**
     * 公文流转主页面
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward documentCenter(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(SUCCESS);
    }

    /**
     * 左侧树状菜单
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward documentTree(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(SUCCESS);
    }

    /**
     * 进入新建文档页面
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward createDocument(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        saveToken(request);
        List<LabelValueBean> typelist = getDocTypeOptions("label.please");
        request.setAttribute("typelist", typelist);
        return mapping.findForward(SUCCESS);
    }

    /**
     * 保存新建文档
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward saveDocument(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentForm form = (DocumentForm) aform;
        String errmsg = null;
        try {
            if (isTokenValid(request, true)) {
                String oriFilename = "";
                String filename = "";
                if (form.getVc2addition() != null) {
                    oriFilename = form.getVc2addition().getFileName();
                    filename = System.currentTimeMillis() + ".ath";
                    try {
                        FileUtility.uploadFile(form.getVc2addition(), filename, attachmentPathBean.getAttachmentPath() + File.separator);
                    } catch (Exception e) {
                        errmsg = "error.attachment";
                        throw e;
                    }
                }

                Integer userid = Utility.getCurrSessionUserid(request);
                Documenttype doctype = (Documenttype) documentTypeService.findOneEntityById(form.getNumtypeid());
                Vcustomer curruser = (Vcustomer) tuserService.findUserById(userid);

                Document doc = new Document(null, doctype, form.getVc2title(), form.getVc2content(), filename, oriFilename, curruser);
                documentService.create(doc);
                request.setAttribute(BaseContect.FORWARD_SUCCESS, Utility.getMessage("info.success"));
            } else {
                saveToken(request);
                errmsg = "error.duplicate.submit";
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            if (errmsg != null) {
                throw new BaseException(errmsg);
            } else {
                throw new BaseException("errors.general");
            }

        }
        return mapping.findForward(SUCCESS);
    }

    /**
     * 显示我创建的文档
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward showCreatedDocument(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String errmsg = null;
        DocumentForm form = (DocumentForm) aform;
        Map params = new HashMap();
        setOptionList(request,"label.all");
        try {
            Integer myuid = Utility.getCurrSessionUserid(request);
            request.setAttribute("myuid", myuid);
            Vcustomer me = tuserService.findUserById(myuid);
            String jpql = "FROM Document d WHERE d.userid =:userid ";
            StringBuffer sb = new StringBuffer(jpql);
            if (Utility.isNotEmpty(form.getVc2titlefq())) {
                sb.append(" AND d.vc2title LIKE '%").append(form.getVc2titlefq()).append("%' ");
            }
            if (Utility.isNotEmpty(form.getVc2contentfq())) {
                sb.append(" AND d.vc2content LIKE '%").append(form.getVc2contentfq()).append("%' ");
            }
            if (Utility.isNotEmpty(form.getVc2resultfq())) {
                sb.append(" AND d.vc2result = '").append(form.getVc2resultfq()).append("' ");
            }
            if (Utility.isNotEmpty(form.getVc2usefq())) {
                sb.append(" AND d.vc2use = '").append(form.getVc2usefq()).append("' ");
            }
            if (Utility.isNotEmpty(form.getDatbeginfq())) {
                Date from = Utility.convertStringToDate(form.getDatbeginfq(), FORMATE_DATE);
                params.put("from", from);
                sb.append(" AND d.datcreatetime >=:from");
            }
            if (Utility.isNotEmpty(form.getDatendfq())) {
                Date to = Utility.convertStringToDate(form.getDatendfq(), FORMATE_DATE);
                params.put("to", to);
                sb.append(" AND d.datcreatetime <=:to");
            }
            if (Utility.isNotEmpty(form.getNumtypeidfq())) {
                Documenttype doctype = (Documenttype) documentTypeService.findOneEntityById(form.getNumtypeidfq());
                params.put("doctype", doctype);
                sb.append(" AND d.numtypeid =:doctype ");
            }
            params.put("userid", me);
            int listCount = documentService.getEntityCount("SELECT count(d) "+sb.toString(), params);
            pagination = new Pagination(request, response);
            pagination.setRecordCount(listCount);
            List<IEntity> mydocs = documentService.findEntities("SELECT d "+sb.toString(), params, false, pagination.getFirstResult(), pagination.getPageSize());
            request.setAttribute("mydocs", mydocs);
            request.setAttribute("pagination", pagination.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            if (errmsg != null) {
                throw new BaseException(errmsg);
            } else {
                throw new BaseException("errors.general");
            }
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * 显示文档详情
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward viewDocDetail(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        String numdocid = request.getParameter("numdocid");
        Integer myuid = Utility.getCurrSessionUserid(request);
        Document doc = jpaDaoService.findOneEntityById(Document.class, numdocid);
        String entertype = request.getParameter("entertype");
        if(Utility.isNotEmpty(entertype)){
            if(entertype.equals("created")){
                request.setAttribute("showVerifyForm", "hidden");
            }else if(entertype.equals("pending")){//如果是从审核页面进入，先检查文档是否被他人锁定，若未锁定，需要锁定文档
                if(doc.getVc2lock().toString().equals("Y")&&(!doc.getLockuserid().equals(myuid))){
                    throw new BaseException("error.document.locked", "/Document/showPendingDocument.do");
                }
                doc.setVc2lock('Y');
                doc.setLockuserid(myuid);
                doc = jpaDaoService.edit(doc);
                request.setAttribute("showVerifyForm", "visible");
            }
        }else{
            request.setAttribute("isVerifyPage", "hidden");
        }
        Map params = new HashMap();
        params.put("numdocid", doc);
        List docvrf = jpaDaoService.findEntities("select v from Documentverify v where v.numdocid =:numdocid order by v.numstepindex asc", params, true, -1, -1);
        request.setAttribute("docDetail", doc);
        request.setAttribute("docVerifies", docvrf);

        return mapping.findForward(SUCCESS);
    }
    /**
     * 列出待审核文件
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward showPendingDocument(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response)throws Exception {

        Integer myuid = Utility.getCurrSessionUserid(request);
        request.setAttribute("myuid", myuid);
        //Vcustomer me = jpaDaoService.findOneEntityById(Vcustomer.class, myuid);
        setOptionList(request,"label.all");
        DocumentForm form = (DocumentForm) aform;
        String jpql = " FROM Document d WHERE d.vc2use = 'Y' AND d.vc2result = 'N' AND d.numcurrstep " +
                " = ANY(SELECT p.numstepindex FROM Documentpath p JOIN p.tgId g JOIN g.vcustomerCollection v WHERE v.userid = :userid AND p.numdoctypeid = d.numtypeid)";
                

        StringBuffer sb = new StringBuffer(jpql);
        Map params = new HashMap();
        if (Utility.isNotEmpty(form.getVc2titlefq())) {
                sb.append(" AND d.vc2title LIKE '%").append(form.getVc2titlefq()).append("%' ");
            }
            if (Utility.isNotEmpty(form.getVc2contentfq())) {
                sb.append(" AND d.vc2content LIKE '%").append(form.getVc2contentfq()).append("%' ");
            }
            /*if (Utility.isNotEmpty(form.getVc2resultfq())) {
                sb.append(" AND d.vc2result = '").append(form.getVc2resultfq()).append("' ");
            }*/
            /*if (Utility.isNotEmpty(form.getVc2usefq())) {
                sb.append(" AND d.vc2use = '").append(form.getVc2usefq()).append("' ");
            }*/
            if (Utility.isNotEmpty(form.getDatbeginfq())) {
                Date from = Utility.convertStringToDate(form.getDatbeginfq(), FORMATE_DATE);
                params.put("from", from);
                sb.append(" AND d.datcreatetime >=:from");
            }
            if (Utility.isNotEmpty(form.getDatendfq())) {
                Date to = Utility.convertStringToDate(form.getDatendfq(), FORMATE_DATE);
                params.put("to", to);
                sb.append(" AND d.datcreatetime <=:to");
            }
            if (Utility.isNotEmpty(form.getNumtypeidfq())) {
                Documenttype doctype = (Documenttype) documentTypeService.findOneEntityById(form.getNumtypeidfq());
                params.put("doctype", doctype);
                sb.append(" AND d.numtypeid =:doctype ");
            }
            params.put("userid", myuid);

            String ql = sb.toString();
            try {
                int listCount = jpaDaoService.getEntityCount("SELECT COUNT(d) "+ql, params);
                pagination = new Pagination(request, response);
                pagination.setRecordCount(listCount);

                List rstlst = jpaDaoService.findEntities("SELECT d "+ql, params, false, pagination.getFirstResult(), pagination.getPageSize());

                request.setAttribute("rstlst", rstlst);
                request.setAttribute("pagination", pagination.toString());
            } catch (Exception e) {
                e.printStackTrace();
                log.error(""+e);
                throw new BaseException("errors.general");
            }
            

        return mapping.findForward(SUCCESS);
    }

    /**
     * 审核文档
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward auditDocument(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        DocumentAuditForm form = (DocumentAuditForm)aform;
        Integer myuid = Utility.getCurrSessionUserid(request);
        String numdocid = form.getNumdocid();
        String advicetag = form.getAdvicetag();
        String vc2message = form.getVc2message();
        String errmsg=null;
        try {
            Vcustomer me = jpaDaoService.findOneEntityById(Vcustomer.class, myuid);
            Document doc = jpaDaoService.findOneEntityById(Document.class, numdocid);
            Character c = 'Y';
            if(!advicetag.equals("Y")){
                c = 'N';
            }
            try {
                Documentverify dv = new Documentverify(c, vc2message, new Date(), doc.getNumcurrstep(), doc, me);
                jpaDaoService.create(dv);
            } catch (Exception e) {
                errmsg="error.document.recordAudit";
                throw e;
            }
            
            try {
                if(advicetag.equals("Y")){
                    doc.setNumcurrstep(doc.getNumcurrstep()+1);
                    doc.setVc2result('Y');
                }else if(advicetag.equals("N")){
                    doc.setNumcurrstep(doc.getNumcurrstep()-1);
                    if(doc.getNumcurrstep()==0){
                        doc.setVc2use('R');
                    }
                    doc.setVc2result('N');
                }else if(advicetag.equals("R")){
                    doc.setNumcurrstep(0);
                    doc.setVc2use('R');
                    doc.setVc2result('N');
                }else if(advicetag.equals("T")){
                    doc.setNumcurrstep(0);
                    doc.setVc2use('N');
                    doc.setVc2result('N');
                }
                
                doc.setVc2lock('N');
                jpaDaoService.edit(doc);
            } catch (Exception e) {
                errmsg= "error.document.update";
                throw e;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            log.error(""+e);
            if(Utility.isEmpty(errmsg)){
                errmsg = "errors.general";
            }
            throw new BaseException(errmsg, "/Document/viewDocDetail.do?numdocid="+numdocid+"+&entertype=pending");
        }
        return mapping.findForward(SUCCESS);
    }
    /**
     * 显示我审核过的文档
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward showAuditedDocument(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response)throws Exception {
        String errmsg = null;
        DocumentForm form = (DocumentForm) aform;
        Map params = new HashMap();
        setOptionList(request,"label.all");
        try {
            Integer myuid = Utility.getCurrSessionUserid(request);
            request.setAttribute("myuid", myuid);
            Vcustomer me = tuserService.findUserById(myuid);
            String jpql = "FROM Document d JOIN d.documentverifyCollection dv WHERE dv.userid =:userid ";
            StringBuffer sb = new StringBuffer(jpql);
            if (Utility.isNotEmpty(form.getVc2titlefq())) {
                sb.append(" AND d.vc2title LIKE '%").append(form.getVc2titlefq()).append("%' ");
            }
            if (Utility.isNotEmpty(form.getVc2contentfq())) {
                sb.append(" AND d.vc2content LIKE '%").append(form.getVc2contentfq()).append("%' ");
            }
            if (Utility.isNotEmpty(form.getVc2resultfq())) {
                sb.append(" AND d.vc2result = '").append(form.getVc2resultfq()).append("' ");
            }
            if (Utility.isNotEmpty(form.getVc2usefq())) {
                sb.append(" AND d.vc2use = '").append(form.getVc2usefq()).append("' ");
            }
            if (Utility.isNotEmpty(form.getDatbeginfq())) {
                Date from = Utility.convertStringToDate(form.getDatbeginfq(), FORMATE_DATE);
                params.put("from", from);
                sb.append(" AND d.datcreatetime >=:from");
            }
            if (Utility.isNotEmpty(form.getDatendfq())) {
                Date to = Utility.convertStringToDate(form.getDatendfq(), FORMATE_DATE);
                params.put("to", to);
                sb.append(" AND d.datcreatetime <=:to");
            }
            if (Utility.isNotEmpty(form.getNumtypeidfq())) {
                Documenttype doctype = (Documenttype) documentTypeService.findOneEntityById(form.getNumtypeidfq());
                params.put("doctype", doctype);
                sb.append(" AND d.numtypeid =:doctype ");
            }
            params.put("userid", me);
            int listCount = documentService.getEntityCount("SELECT count(distinct d) "+sb.toString(), params);
            pagination = new Pagination(request, response);
            pagination.setRecordCount(listCount);
            List<IEntity> mydocs = documentService.findEntities("SELECT distinct d "+sb.toString(), params, false, pagination.getFirstResult(), pagination.getPageSize());
            request.setAttribute("mydocs", mydocs);
            request.setAttribute("pagination", pagination.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            if (errmsg != null) {
                throw new BaseException(errmsg);
            } else {
                throw new BaseException("errors.general");
            }
        }
        return mapping.findForward(SUCCESS);
    }

    private void setOptionList(HttpServletRequest request,String emptyItemKey) throws Exception {
        request.setAttribute("doctypeList", getDocTypeOptions(emptyItemKey));
        request.setAttribute("resultList", getResultList(emptyItemKey));
        request.setAttribute("statusList", getStatusList(emptyItemKey));
    }

    private List<LabelValueBean> getResultList(String emptyItemKey) throws Exception {
        List<LabelValueBean> optlist = new ArrayList<LabelValueBean>();
        if(Utility.isNotEmpty(emptyItemKey)){
            optlist.add(new LabelValueBean(Utility.getMessage(emptyItemKey), ""));
        }
        
        optlist.add(new LabelValueBean(Utility.getMessage("document.department.result.Y"), "Y"));
        optlist.add(new LabelValueBean(Utility.getMessage("document.department.result.N"), "N"));
        return optlist;
    }

    private List<LabelValueBean> getStatusList(String emptyItemKey) throws Exception {
        List<LabelValueBean> optlist = new ArrayList<LabelValueBean>();
        if(Utility.isNotEmpty(emptyItemKey)){
            optlist.add(new LabelValueBean(Utility.getMessage(emptyItemKey), ""));
        }
        optlist.add(new LabelValueBean(Utility.getMessage("document.status.Y"), "Y"));
        optlist.add(new LabelValueBean(Utility.getMessage("document.status.N"), "N"));
        optlist.add(new LabelValueBean(Utility.getMessage("document.status.R"), "R"));
        return optlist;
    }

    private List<LabelValueBean> getDocTypeOptions(String emptyItemKey) throws Exception {
        List<LabelValueBean> optlist = new ArrayList<LabelValueBean>();
        List<IEntity> docTypes = documentTypeService.findByNamedQueryAndNamedParams("Documenttype.findAll", null);
        if(Utility.isNotEmpty(emptyItemKey)){
            optlist.add(new LabelValueBean(Utility.getMessage(emptyItemKey), ""));
        }
        for (IEntity e : docTypes) {
            Documenttype doctype = (Documenttype) e;
            optlist.add(new LabelValueBean(doctype.getVc2name(), doctype.getNumtypeid().toString()));
        }
        return optlist;
    }



    
}

