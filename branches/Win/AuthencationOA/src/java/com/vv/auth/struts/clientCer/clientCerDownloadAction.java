/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.clientCer;

import com.vv.auth.certification.CerPath;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IUserService;
import java.io.File;
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
 * @author X-Spirit
 */
public class clientCerDownloadAction extends DownloadAction {

    @Resource
    IUserService tuserService;
    @Resource
    CerPath cerPathBean;

    @Override
    protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String taruserid = request.getParameter("userid");
        File fileLoad = null;
        String contentType = "application/octet-stream";
        ConcurrentMap usermap = (ConcurrentMap) request.getSession(false).getAttribute("USERMAP");
        if (usermap == null) {
            String fileName = mapping.getParameter();

            response.setHeader("Content-disposition",
                    "attachment; filename=errorFile.html");// 设置文件名
            ServletContext application = servlet.getServletContext();
            return new ResourceStreamInfo(contentType, application, fileName);

        } else {
            String curuserid = usermap.get("userid") + "";

            if (taruserid != null && !taruserid.equals(curuserid)) {
                String fileName = mapping.getParameter();

                response.setHeader("Content-disposition",
                        "attachment; filename=errorFile.html");// 设置文件名
                ServletContext application = servlet.getServletContext();
                return new ResourceStreamInfo(contentType, application, fileName);
            } else {
                Vcustomer user = tuserService.findUserById(new Integer(taruserid));
                String name = user.getName();
                fileLoad = new File(cerPathBean.getClientCerPath() + "/" + name + "/" + name + ".p12");
                // Set the content disposition
                response.setHeader("Content-disposition",
                        "attachment; filename=" + new String((name + ".p12").getBytes("gbk"), "iso8859_1"));// 设置文件名
            }
        }


        // Download a "pdf" file - gets the file name from the
        // Action Mapping's parameter

        return new FileStreamInfo(contentType, fileLoad);

    }
}
