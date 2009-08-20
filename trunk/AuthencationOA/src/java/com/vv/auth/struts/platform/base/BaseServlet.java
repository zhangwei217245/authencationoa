package com.vv.auth.struts.platform.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;

import com.vv.auth.struts.util.Utility;

/**
 * @author joss
 *
 */
public class BaseServlet extends ActionServlet {

    public static final String module = BaseServlet.class.getName();
    public static final Logger log = Logger.getLogger(BaseAction.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        setCharSet(request, response);
        process(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        setCharSet(request, response);
        process(request, response);
    }

    public void init() throws ServletException {
        try {
            log.info("##### Web BaseServlet #####");
            super.init();

            this.getServletContext().setAttribute("securitypermissons", Utility.getLoadconfPermisson());
            this.getServletContext().setAttribute("menus", Utility.getLoadconfMenu());
            System.out.println("joss servlet start");
        } catch (ServletException e) {
            System.out.println(e);
            throw e;
        }
    }

    private void setCharSet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String charset = getServletContext().getInitParameter("charset");
        if (charset == null || charset.length() == 0) {
            charset = request.getCharacterEncoding();
        }
        if (charset == null || charset.length() == 0) {
            charset = "UTF-8";
        }
        if (!"none".equals(charset)) {
            request.setCharacterEncoding(charset);
        }
        String contentType = "text/html";
        if (charset.length() > 0 && !"none".equals(charset)) {
            response.setContentType(contentType + "; charset=" + charset);
        } else {
            response.setContentType(contentType);
        }
    }
}
