/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.document;

import com.vv.auth.persist.entity.Documentpath;
import com.vv.auth.persist.entity.Documenttype;
import com.vv.auth.persist.entity.IEntity;
import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.service.IEntityService;
import com.vv.auth.persist.service.IGroupService;
import com.vv.auth.struts.platform.base.BaseAction;
import com.vv.auth.struts.platform.base.BaseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author x-spirit
 */
public class DocumentTypeAction extends BaseAction {

    @Resource
    private IEntityService documentTypeService;
    @Resource
    private IEntityService documentPathService;
    @Resource
    private IGroupService tgroupService;

    @Override
    public ActionForward executeAction(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String parameter = mapping.getParameter();

        if (parameter.equalsIgnoreCase("documentTypeinit")) {
            forward = documentTypeAddInit(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("documentTypeAdd")) {
            forward = documentTypeAdd(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("documentTypeEditInit")) {
            forward = documentTypeEditInit(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("documentTypeEdit")) {
            forward = documentTypeEdit(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("documentTypeDelete")) {
            forward = documentTypeDelete(mapping, aform, request, response);
        } else if (parameter.equalsIgnoreCase("documentShowType")) {
            forward = documentShowType(mapping, aform, request, response);
        }

        return forward;
    }

    /**
     * 添加初始化
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     */
    private ActionForward documentTypeAddInit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        saveToken(request);
        try {
            List<TGroup> allgroups = tgroupService.queryGroupList();
            request.setAttribute("outGroups", allgroups);
            request.setAttribute("inGroups", new ArrayList<TGroup>());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            throw new BaseException("errors.general");
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * 添加保存
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward documentTypeAdd(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        DocumentTypeForm form = (DocumentTypeForm) aform;
        String errmsg = null;
        try {
            if (isTokenValid(request, true)) {
                Documenttype type = new Documenttype(form.getVc2name());
                Map params = new HashMap();
                params.put("vc2name", form.getVc2name());
                if (documentTypeService.findByNamedQueryAndNamedParams("Documenttype.findByVc2name", params).size() <= 0) {
                    documentTypeService.create(type);
                    processDocumentPath(request, type);
                    documentTypeService.edit(type);
                } else {
                    errmsg = "document.type.duplicated";
                }
                resetToken(request);
            } else {
                saveToken(request);
                errmsg = "error.duplicate.submit";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            errmsg = null;
            throw new BaseException("errors.general");
        } finally {
            if (errmsg != null) {
                throw new BaseException(errmsg);
            }
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * 列表展示
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward documentShowType(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<IEntity> typelist = documentTypeService.findByNamedQueryAndNamedParams("Documenttype.findAll", null);
        request.setAttribute("typelist", typelist);
        return mapping.findForward(SUCCESS);
    }

    /**
     * 进入编辑界面
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     */
    private ActionForward documentTypeEditInit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentTypeForm doctypeform = (DocumentTypeForm) aform;
        try {
            String typeid = request.getParameter("typeid");
            doctypeform.setNumtypeid(typeid);
            Documenttype doctype = (Documenttype) documentTypeService.findOneEntityById(typeid);
            doctypeform.setVc2name(doctype.getVc2name());
            String jpql = "SELECT dpath FROM Documentpath dpath JOIN dpath.tgId tg WHERE dpath.numdoctypeid =:numdoctypeid ORDER BY dpath.numstepindex";
            Map params = new HashMap();
            params.put("numdoctypeid", doctype);
            List<IEntity> dpathList = documentPathService.findEntities(jpql, params, true, -1, -1);

            List<TGroup> allTgList = tgroupService.queryGroupList();
            List<TGroup> inTgList = new ArrayList<TGroup>();
            for (IEntity entity : dpathList) {
                Documentpath dpath = (Documentpath) entity;
                inTgList.add(dpath.getTgId());
                if (allTgList.contains(dpath.getTgId())) {
                    allTgList.remove(dpath.getTgId());
                }
            }

            request.setAttribute("outGroups", allTgList);
            request.setAttribute("inGroups", inTgList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            throw new BaseException("errors.general");
        }
        return mapping.findForward(SUCCESS);
    }

    /**
     * 保存编辑后的文档类型
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     */
    private ActionForward documentTypeEdit(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentTypeForm form = (DocumentTypeForm) aform;
        String errmsg = null;
        try {
            Map params = new HashMap();
            params.put("vc2name", form.getVc2name());
            if (documentTypeService.findByNamedQueryAndNamedParams("Documenttype.findByVc2name", params).size() <= 1) {
                Documenttype type = (Documenttype) documentTypeService.findOneEntityById(form.getNumtypeid());
                processDocumentPath(request, type);
                type.setVc2name(form.getVc2name());
                documentTypeService.edit(type);
            } else {
                errmsg = "document.type.duplicated";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            errmsg = null;
            throw new BaseException("errors.general");
        } finally {
            if (errmsg != null) {
                throw new BaseException(errmsg, "/Document/documentTypeEditInit.do?typeid=" + form.getNumtypeid());
            }
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * 删除文档类型
     * @param mapping
     * @param aform
     * @param request
     * @param response
     * @return
     */
    private ActionForward documentTypeDelete(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String typeid = request.getParameter("typeid");
        String errmsg = null;
        try {
            Documenttype type = (Documenttype) documentTypeService.findOneEntityById(typeid);
            if (type != null) {
                if (type.getDocumentCollection() != null && type.getDocumentCollection().size() > 0) {
                    errmsg = "document.type.inuse";
                } else {
                    documentTypeService.destroy(type.getNumtypeid());
                }
            } else {
                errmsg = "document.type.notexists";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            errmsg = null;
            throw new BaseException("errors.general");
        } finally {
            if (errmsg != null) {
                throw new BaseException(errmsg);
            }
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * 根据文档类型和提交的参数处理生成并适配对应的文档审核路径
     * @param request
     * @param type
     */
    private void processDocumentPath(HttpServletRequest request, Documenttype type) {
        if (type.getDocumentpathCollection() != null && type.getDocumentpathCollection().size() > 0) {
            type.getDocumentpathCollection().clear();
            Map params = new HashMap();
            params.put("numdoctypeid", type);
            documentPathService.executeUpdate("DELETE FROM Documentpath dp WHERE dp.numdoctypeid =:numdoctypeid", params);
        }
        String[] groupsin = request.getParameterValues("groupsin");
        if (groupsin != null && groupsin.length > 0) {
            for (int i = 0; i < groupsin.length; i++) {
                TGroup group = tgroupService.findGroupById(Integer.parseInt(groupsin[i]));
                Documentpath docpath;

                docpath = new Documentpath(null, i + 1, 'G', type.getVc2name() + "的第" + (i + 1) + "步", type, group, null);
                documentPathService.create(docpath);
                type.getDocumentpathCollection().add(docpath);
            }

        }
    }
}
