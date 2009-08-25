/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.document;

import com.vv.auth.persist.entity.Document;
import com.vv.auth.persist.service.IEntityService;
import com.vv.auth.persist.service.IJpaDaoService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

/**
 *
 * @author hp
 */
public class DocumentDownloadAction extends DownloadAction {

    @Resource
    private IJpaDaoService jpaDaoService;
    @Resource
    AttachmentPathBean attachmentPathBean;

    @Override
    protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm aform,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        String docid = request.getParameter("numdocid");
        Document document = jpaDaoService.findOneEntityById(Document.class, docid);

        String contentType = "application/octet-stream";
        String vc2additionname = document.getVc2additionname();
        String vc2addition = document.getVc2addition();
        File fileLoad = new File(attachmentPathBean.getAttachmentPath() + File.separator + vc2addition);
        response.setHeader("Content-disposition",
                "attachment; filename=" + new String((vc2additionname).getBytes("gbk"), "iso8859_1"));// 设置文件名
        return new FileStreamInfo(contentType, fileLoad);
    }
}
