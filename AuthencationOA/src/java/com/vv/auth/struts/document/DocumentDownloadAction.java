/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.document;

import com.vv.auth.persist.entity.Document;
import com.vv.auth.persist.entity.Documentpath;
import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.struts.util.Utility;
import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
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
        Integer creatorid = document.getUserid().getUserid();
        Set<Documentpath> docpaths = document.getNumtypeid().getDocumentpathCollection();
        ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
        String contentType = "application/octet-stream";
        if (usermap == null) {
            String fileName = mapping.getParameter();

            response.setHeader("Content-disposition",
                    "attachment; filename=errorFile.html");// 设置文件名
            ServletContext application = servlet.getServletContext();
            return new ResourceStreamInfo(contentType, application, fileName);

        } else {
            String viewerid = usermap.get("userid") + "";
            if(!hasViewerInPath(viewerid, docpaths)){
                if(!viewerid.equals(creatorid.toString())){
                    String fileName = mapping.getParameter();

                    response.setHeader("Content-disposition",
                            "attachment; filename=errorFile.html");// 设置文件名
                    ServletContext application = servlet.getServletContext();
                    return new ResourceStreamInfo(contentType, application, fileName);
                }
            }
        }
        String vc2additionname = document.getVc2additionname();
        String vc2addition = document.getVc2addition();
        File fileLoad = new File(attachmentPathBean.getAttachmentPath() + File.separator + vc2addition);
        response.setHeader("Content-disposition",
                "attachment; filename=" + new String((vc2additionname).getBytes("gbk"), "iso8859_1"));// 设置文件名
        return new FileStreamInfo(contentType, fileLoad);
    }

    private boolean hasViewerInPath(String viewerid,Set<Documentpath> docpaths){
        if(Utility.isEmpty(viewerid)||Utility.isEmpty(docpaths)){
            return false;
        }
        for(Documentpath path:docpaths){
            if(path.getUserid()==null){
                return false;
            }

            if(viewerid.equals(path.getUserid().getUserid().toString())){
                return true;
            }
        }
        return false;
    }
}
