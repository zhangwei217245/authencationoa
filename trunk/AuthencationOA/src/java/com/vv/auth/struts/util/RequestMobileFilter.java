package com.vv.auth.struts.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestMobileFilter implements Filter {

    private static Logger log = Logger.getLogger(RequestMobileFilter.class);

    public void destroy() {
        // TODO 自动生成方法存根
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO 自动生成方法存根
        HttpServletRequest hr = (HttpServletRequest) request;
        if (isVisitError(hr, "www")) {
            String result = "http://wap.datou.com";
            HttpServletResponse rs = (HttpServletResponse) response;
            rs.sendRedirect(result);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO 自动生成方法存根
    }

    /**
     * 用户错位访问
     * @param request
     * @param application 应用类型(www|wap)
     * @return 是否错位
     */
    public boolean isVisitError(HttpServletRequest request, String application) {
        boolean result = false;
        // 是否为手机用户
        boolean mobile = false; // 默认不是手机用户
        if (Utility.isEmpty(application)) {
            application = "www";
        }
        // 非 opera 浏览器
//    	String[] browsers = {"MSIE","Firefox","Safari","Camino","Gecko"};

        // user-agent，包含浏览器信息 如：NEC-N700/1.0 UP.Browser/6.2.2.4.d.1.102 (GUI) MMP/1.0
        String ua = request.getHeader("user-agent");
        //log.info("isVisitError ua: " + ua);
        // via，包含所经过的网关信息 如：WTP/1.1 WAPGW-6.wh.monternet.com (Nokia WAP Gateway 3.1/ECD9/3.1.53), HTTP/1.1
        String via = request.getHeader("via");
        //log.info("isVisitError via: " + via);
        // x-source-id，连接模式 如：GGSNGZ05 或 211.139.172.70
        String x_source_id = request.getHeader("x-source-id");
        //log.info("isVisitError x-source-id: " + x_source_id);
        // x-up-bear-type 标示业务承载的网络类型 如：GPRS网用户填为GPRS,CDMA用户填CDMA
        String x_up_bear_type = request.getHeader("x-up-bear-type");
        //log.info("isVisitError x-up-bear-type: " + x_up_bear_type);
        // x-wap-profile 用户代理配置文件
        String x_wap_profile = request.getHeader("x-wap-profile");
        //log.info("isVisitError x-wap-profile: " + x_wap_profile);

        String uaType[] = {"ARIMA", "CECT", "COMPAL", "LG", "NEC", "TCL", "TDG", "ALCATEL", "ERICSSON", "BIRD",
            "DAXIAN", "DBTEL", "EASTCOM", "PANTECH", "DOPOD", "PHILIPS", "HAIER", "KONKA", "KEJIAN", "LENOVO",
            "BENQ", "MOT", "SOUTEC", "NOKIA", "SAGEM", "SEC", "SAMSUNG", "SCH", "SED", "CAPITEL",
            "PANASONIC", "SONYERICSSON", "SIE", "SHARP", "AMOI", "EMOL", "PANDA", "INNO", "ZTE"};
        if (Utility.isNotEmpty(ua)) {
            for (int i = 0; i < uaType.length; i++) {
                String module = uaType[i];
                if (ua.toUpperCase().startsWith(module)) {
                    mobile = true;
                    break;
                }
            }
        }

        if (mobile || Utility.isNotEmpty(via) || Utility.isNotEmpty(x_up_bear_type) || Utility.isNotEmpty(x_source_id) || Utility.isNotEmpty(x_wap_profile) || (Utility.isNotEmpty(ua) && ua.toLowerCase().indexOf("opera") != -1)) {
            mobile = true;
        }
        // 判断是否是浏览器错位访问
        if (("wap".equalsIgnoreCase(application) && !mobile) || ("www".equalsIgnoreCase(application) && mobile)) {
            result = true;
        }

        return result;
    }
}
