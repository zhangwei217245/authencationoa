package com.vv.auth.struts.platform.base;

import javax.servlet.http.HttpServletRequest;


import com.vv.auth.struts.util.Utility;

public class PageForm extends BaseForm {

    private String currentPage;
    private String currentPage2;
    private String totalPage;
    private String totalPage2;
    private String togo;
    private String togo2;
    private String orderbyname;
    private String orderbynamestr;
    private String orderType;
    private String toPage;
    private String writeStr;
    private String searchUrl;
    private String contextPath;
    private String orderIndex;
    private String defaultOrderby;

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex;
    }

    public void setPageOrderby(HttpServletRequest request, PageForm form) {

        String orderbyname = request.getParameter("orderbyname");
        if (orderbyname == null || (orderbyname != null && orderbyname.length() < 0)) {
            orderbyname = form.getOrderbyname();
        }

        if (orderbyname != null && orderbyname.length() > 0) {
            if (orderbyname.startsWith("-")) {
                form.setOrderbynamestr(orderbyname.substring(1));
                form.setOrderType("desc");
                form.setOrderIndex("1");
            } else {
                form.setOrderbynamestr(orderbyname);
                form.setOrderType("asc");
                form.setOrderIndex("0");
            }
        } else {
            form.setOrderbynamestr(defaultOrderby);
            form.setOrderType("desc");
            form.setOrderIndex("1");
        }
        form.setOrderbyname(orderbyname);

    }

    public void setDefaultOrderby(String defaultOrderby) {
        this.defaultOrderby = defaultOrderby;
    }

    public void setPageValue(HttpServletRequest request) {
        //��ǰҳ
        if (request.getParameter("page") != null) {
            setCurrentPage(request.getParameter("page"));
        }
        if (request.getParameter("togo") != null) {
            setCurrentPage(request.getParameter("togo"));
        }
        if (request.getParameter("togo2") != null) {
            setCurrentPage2(request.getParameter("togo2"));
        }
        contextPath = request.getContextPath();
    }

    public String getOrderbyname() {
        return orderbyname;
    }

    public void setOrderbyname(String orderbyname) {
        this.orderbyname = orderbyname;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getCurrentPage() {

        if (currentPage != null && currentPage.length() > 0) {
            try {
                int i = Integer.valueOf(currentPage);
                if (i <= 0) {
                    currentPage = "1";
                }
            } catch (NumberFormatException e) {
                currentPage = "1";
            }
        } else {
            currentPage = "1";
        }


        return currentPage;
    }

    public String getCurrentPage2() {

        if (currentPage2 != null && currentPage2.length() > 0) {
            try {
                int i = Integer.valueOf(currentPage2);
                if (i <= 0) {
                    currentPage2 = "1";
                }
            } catch (NumberFormatException e) {
                currentPage2 = "1";
            }
        } else {
            currentPage2 = "1";
        }


        return currentPage2;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public void setCurrentPage2(String currentPage) {
        this.currentPage2 = currentPage;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTogo() {
        return togo;
    }

    public void setTogo(String togo) {
        this.togo = togo;
    }

    //ҳ����ʾ
    public String getToPage() {

        String page = Utility.getMessage("button.page");
        String tpage = Utility.getMessage("button.total");
        return getCurrentPage() + page + " / " + tpage + (Utility.isNotEmpty(getTotalPage()) ? getTotalPage() : "1") + page;
    }

    public void setToPage(String toPage) {
        this.toPage = toPage;
    }

    //��
    public boolean isNext() {

        if (currentPage != null && totalPage != null) {
            int cp = 1;
            int tp = 1;
            try {
                cp = Integer.valueOf(currentPage);
                tp = Integer.valueOf(totalPage);
            } catch (NumberFormatException e) {
            }

            if (cp != tp && cp < tp) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public String getNext() {

        int cp = 1;
        if (currentPage != null && totalPage != null) {
            try {
                cp = Integer.valueOf(currentPage);
            } catch (NumberFormatException e) {
            }
        }

        StringBuffer sb = new StringBuffer();
        if (isNext()) {
            //sb.append("<a href=\"" + contextPath + getSearchUrl() + "?page=" + (cp + 1) + "\">");
            sb.append("<img style=\"cursor:hand\" onClick=\"pagetogo(" + (cp + 1) + ")\" src=\"" + contextPath + "/images/next.gif\"/>");
            //sb.append("</a>");
        } else {
            sb.append("<img style=\"cursor:hand\" src=\"" + contextPath + "/images/next.gif\"/>");
        }

        return sb.toString();

    }

    //��һҳ
    public boolean isPre() {

        if (currentPage != null && totalPage != null) {
            int cp = 1;
            int tp = 1;
            try {
                cp = Integer.valueOf(currentPage);
                tp = Integer.valueOf(totalPage);
            } catch (NumberFormatException e) {
            }

            if (cp > 1) {
                return true;
            } else {
                return false;
            }
        }



        return true;
    }

    public String getPrev() {

        int cp = 1;
        if (currentPage != null) {
            try {
                cp = Integer.valueOf(currentPage);
            } catch (NumberFormatException e) {
            }
        }

        StringBuffer sb = new StringBuffer();
        if (isPre()) {
            //sb.append("<a href=\"" + contextPath + getSearchUrl() + "?page=" + (cp - 1) + "\">");
            sb.append("<img style=\"cursor:hand\" onClick=\"pagetogo(" + (cp - 1) + ")\"  src=\"" + contextPath + "/images/prev.gif\"/>");
            //sb.append("</a>");
        } else {
            sb.append("<img style=\"cursor:hand\" src=\"" + contextPath + "/images/prev.gif\"/>");
        }

        return sb.toString();
    }

//	public String getWriteStr(String cor) {
//		StringBuffer sb = new StringBuffer();
//		
//		sb.append("<tr>");
//		sb.append("<td colspan=\"" + cor + "\" class=\"foot\">").append(getToPage()).append("&nbsp;&nbsp;&nbsp;").append(getPrev()).append(getNext());
//		sb.append("&nbsp;<input size=\"2\" maxlength=\"4\" name=\"togo\"/>");
//		sb.append("<a href=\"" + contextPath + getSearchUrl() + "\">");
//		sb.append("<input type=\"button\" name=\"go\" onClick=\"pagetogo(document.forms[0].togo.value)\" value=\"go\"/></a></div>");
//		sb.append("</td></tr>");
//		
//		sb.append("<script language=\"javascript\">");
//		sb.append("function pagetogo(togo){");
//		sb.append("document.forms[0].action = \"" + contextPath + getSearchUrl() + "?togo=\" + togo;");
//		sb.append("document.forms[0].submit();");
//		sb.append("}");
//		sb.append("</script>");
//		
//		return sb.toString();
//	}
    public String getWriteStr(String cor) {
        StringBuffer sb = new StringBuffer();
        int cp = 1;
        int tp = 1;
        try {
            cp = Integer.parseInt(getCurrentPage());
            tp = Integer.parseInt(this.getTotalPage());
        } catch (NumberFormatException e) {
            cp = 1;
            tp = 1;
        }
        int first = 1;
        int last = 10;
        sb.append("<tr>\r\n");
        sb.append("<td colspan=\"").append(cor).append("\" class=\"foot\">\r\n");
        if (tp == 1) {
            sb.append(Utility.getMessage("datuu.wap.perpage.total")).append("&nbsp;" + tp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
        } else if (tp > 1) {
            sb.append(Utility.getMessage("datuu.wap.perpage.total")).append("&nbsp;" + tp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
            sb.append(Utility.getMessage("datuu.wap.perpage.the")).append("&nbsp;" + cp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
            if (cp >= 10) {
                first = (cp - (cp % 10)) + 1;
                last = (cp - (cp % 10)) + 10;
                if ((tp - cp) >= 0 && (tp - cp) < 10) {
                    last = tp;
                    first = last - 9;
                }
                if (cp % 10 == 0) {
                    first = cp - 9;
                    last = cp;
                }
            }
            if (tp < 10) {
                last = tp;
            }
            if (cp > 10 && tp > 10) {
                int m = first - 1;
                sb.append("[<a href=\"#\" onclick=\"pagetogo(").append(1).append(")\" >").append(Utility.getMessage("datuu.wap.perpage.first")).append("</a>]&nbsp;\r\n");
                sb.append("<a href=\"#\" onclick=\"pagetogo(").append(m).append(")\" >").append("&lt;&lt;</a>&nbsp;\r\n");
            }
            for (int i = first; i <= last; i++) {
                if (i == cp) {
                    sb.append("[<strong><font color=\"red\">").append(i).append("</font></strong>]&nbsp;\r\n");
                }
                if (i != cp) {
                    sb.append("[<a href=\"#\" onclick=\"pagetogo(").append(i).append(")\" >").append("<strong>").append(i).append("</strong></a>]&nbsp;\r\n");
                }
            }
            if ((tp - last) >= 1 && (tp - last) < 10) {
                sb.append("<a href=\"#\" onclick=\"pagetogo(").append(tp).append(")\" >&gt;&gt;</a>&nbsp;\r\n");
            }
            if ((tp - last) >= 10) {
                sb.append("<a href=\"#\" onclick=\"pagetogo(").append(last + 1).append(")\" >&gt;&gt;</a>&nbsp;\r\n");
            }
            if (last < tp) {
                sb.append("[<a href=\"#\" onclick=\"pagetogo(").append(tp).append(")\" >").append(Utility.getMessage("datuu.wap.perpage.last")).append("</a>]\r\n");
            }

            //sb.append("<input name=\"txtgo\" id=\"txtgo\" type=\"text\" maxlength=\"4\" style=\"width:20px;\" onfocus=\"spreadgoto(this)\" onblur=\"shrinkgoto(this,'blur')\" onkeydown=\"txtgoto(event,this)\"/>\r\n");
            sb.append("<input name=\"txtgo\" id=\"txtgo\" type=\"text\" style=\"width:50px;\" onkeydown=\"txtgoto(event,this)\"/>\r\n");
            sb.append("[<a id=\"btngo\" href=\"#\" onclick=\"btntogo(this,'btn')\">GO</a>]\r\n");
        }
        sb.append("</td>\r\n");
        sb.append("</tr>\r\n");

        sb.append("<script language=\"javascript\">\r\n");
        sb.append("function pagetogo(togo){\r\n");
        sb.append("\tdocument.forms[0].target = \"_self\";\r\n");
        sb.append("\tdocument.forms[0].action = \"" + contextPath + getSearchUrl() + "?togo=\" + togo;\r\n");
        sb.append("\tdocument.forms[0].submit();\r\n");
        sb.append("\tLoading.show();\r\n");
        sb.append("}\r\n");

        sb.append("var tar=40;\r\n");
        sb.append("var maxtar=50;\r\n");
        sb.append("var mintar=20;\r\n");

        sb.append("function spreadgoto(obj){\r\n");
        sb.append("\tvar str=obj.style.width;\r\n");
        sb.append("\tstr=str.replace(/px/,'');\r\n");
        sb.append("\tvar i=parseInt(str,10);\r\n");
        sb.append("\tif(i<maxtar){\r\n");
        sb.append("\t\ti=i+10;\r\n");
        sb.append("\t\tobj.style.width=i+\"px\";\r\n");
        sb.append("\t\tvar t=window.setTimeout(spreadgoto,10,obj);\r\n");
        sb.append("\t}else{\r\n");
        sb.append("\t\tclearTimeout(t);\r\n");
        sb.append("\t\tshrinkgoto(obj,'auto');\r\n");
        sb.append("\t}\r\n");
        sb.append("}\r\n");

        sb.append("function shrinkgoto(obj,type){\r\n");
        sb.append("\tvar str=obj.style.width;\r\n");
        sb.append("\tstr=str.replace(/px/,'');\r\n");
        sb.append("\tvar i=parseInt(str,10);\r\n");
        sb.append("\tvar finalsize=tar;\r\n");
        sb.append("\tif(type=='blur'){\r\n");
        sb.append("\t\tfinalsize=mintar;\r\n");
        sb.append("\t}\r\n");
        sb.append("\tif(i>finalsize){\r\n");
        sb.append("\t\ti=i-1;\r\n");
        sb.append("\t\tobj.style.width=i+\"px\";\r\n");
        sb.append("\t\tvar t=window.setTimeout(shrinkgoto,40,obj,type);\r\n");
        sb.append("\t}else{\r\n");
        sb.append("\t\tclearTimeout(t);\r\n");
        sb.append("\t\treturn;\r\n");
        sb.append("\t}\r\n");
        sb.append("}\r\n");

        sb.append("function txtgoto(event,obj){\r\n");
        sb.append("\tif (event.keyCode==13){btntogo(obj,'txt');}\r\n");
        sb.append("}\r\n");
        sb.append("function btntogo(obj,objtype){\r\n");
        sb.append("\tvar togo=1;\r\n");
        sb.append("\tvar valnode=document.getElementById('txtgo');\r\n");
        sb.append("\tif(objtype=='txt'){\r\n");
        sb.append("\t\tvalnode=obj;\r\n");
        sb.append("\t\ttogo=obj.value;\r\n");
        sb.append("\t}else if(objtype=='btn'){\r\n");
        sb.append("\t\tvalnode=obj.parentNode.getElementsByTagName('input')[0]\r\n");
        sb.append("\t\ttogo=obj.parentNode.getElementsByTagName('input')[0].value\r\n");
        sb.append("\t}\r\n");
        sb.append("\tif (togo!=''&&isNum(togo)){\r\n" +
                "\t\tpagetogo(parseInt(togo,10))\r\n" +
                "\t}else{\r\n" +
                "\t\tvalnode.value='';\r\n\t\treturn;\r\n" +
                "\t}\r\n");
        sb.append("}\r\n");
        sb.append("</script>\r\n");
        return sb.toString();
    }

    public String getWriteStr2(String cor) {
        StringBuffer sb = new StringBuffer();
        int cp = 1;
        int tp = 1;
        try {
            cp = Integer.parseInt(getCurrentPage2());
            tp = Integer.parseInt(this.getTotalPage2());
        } catch (NumberFormatException e) {
            cp = 1;
            tp = 1;
        }
        int first = 1;
        int last = 10;
        sb.append("<tr>\r\n");
        sb.append("<td colspan=\"").append(cor).append("\" class=\"foot\">\r\n");
        if (tp == 1) {
            sb.append(Utility.getMessage("datuu.wap.perpage.total")).append("&nbsp;" + tp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
        } else if (tp > 1) {
            sb.append(Utility.getMessage("datuu.wap.perpage.total")).append("&nbsp;" + tp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
            sb.append(Utility.getMessage("datuu.wap.perpage.the")).append("&nbsp;" + cp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
            if (cp >= 10) {
                first = (cp - (cp % 10)) + 1;
                last = (cp - (cp % 10)) + 10;
                if ((tp - cp) >= 0 && (tp - cp) < 10) {
                    last = tp;
                    first = last - 9;
                }
                if (cp % 10 == 0) {
                    first = cp - 9;
                    last = cp;
                }
            }
            if (tp < 10) {
                last = tp;
            }
            if (cp > 10 && tp > 10) {
                int m = first - 1;
                sb.append("[<a href=\"#\" onclick=\"pagetogo2(").append(1).append(")\" >").append(Utility.getMessage("datuu.wap.perpage.first")).append("</a>]&nbsp;\r\n");
                sb.append("<a href=\"#\" onclick=\"pagetogo2(").append(m).append(")\" >").append("&lt;&lt;</a>&nbsp;\r\n");
            }
            for (int i = first; i <= last; i++) {
                if (i == cp) {
                    sb.append("[<strong><font color=\"red\">").append(i).append("</font></strong>]&nbsp;\r\n");
                }
                if (i != cp) {
                    sb.append("[<a href=\"#\" onclick=\"pagetogo2(").append(i).append(")\" >").append("<strong>").append(i).append("</strong></a>]&nbsp;\r\n");
                }
            }
            if ((tp - last) >= 1 && (tp - last) < 10) {
                sb.append("<a href=\"#\" onclick=\"pagetogo2(").append(tp).append(")\" >&gt;&gt;</a>&nbsp;\r\n");
            }
            if ((tp - last) >= 10) {
                sb.append("<a href=\"#\" onclick=\"pagetogo2(").append(last + 1).append(")\" >&gt;&gt;</a>&nbsp;\r\n");
            }
            if (last < tp) {
                sb.append("[<a href=\"#\" onclick=\"pagetogo2(").append(tp).append(")\" >").append(Utility.getMessage("datuu.wap.perpage.last")).append("</a>]\r\n");
            }
            //sb.append("<input name=\"txtgo\" id=\"txtgo\" type=\"text\" maxlength=\"4\" style=\"width:20px;\" onfocus=\"spreadgoto(this)\" onblur=\"shrinkgoto(this,'blur')\" onkeydown=\"txtgoto(event,this)\"/>\r\n");
            sb.append("<input name=\"txtgo\" id=\"txtgo2\" type=\"text\" style=\"width:50px;\" onkeydown=\"txtgoto2(event,this)\"/>\r\n");
            sb.append("[<a id=\"btngo2\" href=\"#\" onclick=\"btntogo2(this,'btn')\">GO</a>]\r\n");
        }
        sb.append("</td>\r\n");
        sb.append("</tr>\r\n");

        sb.append("<script language=\"javascript\">\r\n");
        sb.append("function pagetogo2(togo){\r\n");
        sb.append("\tdocument.forms[0].target = \"_self\";\r\n");
        sb.append("\tdocument.forms[0].action = \"" + contextPath + getSearchUrl() + "?togo2=\" + togo;\r\n");
        sb.append("\tdocument.forms[0].submit();\r\n");
        sb.append("\tLoading.show();\r\n");
        sb.append("}\r\n");

        sb.append("var tar2=40;\r\n");
        sb.append("var maxtar2=50;\r\n");
        sb.append("var mintar2=20;\r\n");

        sb.append("function spreadgoto2(obj){\r\n");
        sb.append("\tvar str=obj.style.width;\r\n");
        sb.append("\tstr=str.replace(/px/,'');\r\n");
        sb.append("\tvar i=parseInt(str,10);\r\n");
        sb.append("\tif(i<maxtar2){\r\n");
        sb.append("\t\ti=i+10;\r\n");
        sb.append("\t\tobj.style.width=i+\"px\";\r\n");
        sb.append("\t\tvar t2=window.setTimeout(spreadgoto2,10,obj);\r\n");
        sb.append("\t}else{\r\n");
        sb.append("\t\tclearTimeout(t2);\r\n");
        sb.append("\t\tshrinkgoto2(obj,'auto');\r\n");
        sb.append("\t}\r\n");
        sb.append("}\r\n");

        sb.append("function shrinkgoto2(obj,type){\r\n");
        sb.append("\tvar str=obj.style.width;\r\n");
        sb.append("\tstr=str.replace(/px/,'');\r\n");
        sb.append("\tvar i=parseInt(str,10);\r\n");
        sb.append("\tvar finalsize=tar2;\r\n");
        sb.append("\tif(type=='blur'){\r\n");
        sb.append("\t\tfinalsize=mintar2;\r\n");
        sb.append("\t}\r\n");
        sb.append("\tif(i>finalsize){\r\n");
        sb.append("\t\ti=i-1;\r\n");
        sb.append("\t\tobj.style.width=i+\"px\";\r\n");
        sb.append("\t\tvar t2=window.setTimeout(shrinkgoto2,40,obj,type);\r\n");
        sb.append("\t}else{\r\n");
        sb.append("\t\tclearTimeout(t2);\r\n");
        sb.append("\t\treturn;\r\n");
        sb.append("\t}\r\n");
        sb.append("}\r\n");

        sb.append("function txtgoto2(event,obj){\r\n");
        sb.append("\tif (event.keyCode==13){btntogo2(obj,'txt');}\r\n");
        sb.append("}\r\n");
        sb.append("function btntogo2(obj,objtype){\r\n");
        sb.append("\tvar togo2=1;\r\n");
        sb.append("\tvar valnode=document.getElementById('txtgo2');\r\n");
        sb.append("\tif(objtype=='txt'){\r\n");
        sb.append("\t\tvalnode=obj;\r\n");
        sb.append("\t\ttogo2=obj.value;\r\n");
        sb.append("\t}else if(objtype=='btn'){\r\n");
        sb.append("\t\tvalnode=obj.parentNode.getElementsByTagName('input')[0]\r\n");
        sb.append("\t\ttogo2=obj.parentNode.getElementsByTagName('input')[0].value\r\n");
        sb.append("\t}\r\n");
        sb.append("\tif (togo2!=''&&isNum(togo2)){\r\n" +
                "\t\tpagetogo2(parseInt(togo2,10))\r\n" +
                "\t}else{\r\n" +
                "\t\tvalnode.value='';\r\n\t\treturn;\r\n" +
                "\t}\r\n");
        sb.append("}\r\n");
        sb.append("</script>\r\n");
        return sb.toString();
    }

    public String getWriteStrWithParam(String cor) {
        StringBuffer sb = new StringBuffer();
        int cp = 1;
        int tp = 1;
        try {
            cp = Integer.parseInt(getCurrentPage());
            tp = Integer.parseInt(this.getTotalPage());
        } catch (NumberFormatException e) {
            cp = 1;
            tp = 1;
        }
        int first = 1;
        int last = 10;
        sb.append("<tr>\r\n");
        sb.append("<td colspan=\"").append(cor).append("\" class=\"foot\" style=\"text-align:center\">\r\n");
        if (tp == 1) {
            sb.append(Utility.getMessage("datuu.wap.perpage.total")).append("&nbsp;" + tp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
        } else if (tp > 1) {
            sb.append(Utility.getMessage("datuu.wap.perpage.total")).append("&nbsp;" + tp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
            sb.append(Utility.getMessage("datuu.wap.perpage.the")).append("&nbsp;" + cp + "&nbsp;").append(Utility.getMessage("datuu.wap.perpage.page")).append("&nbsp;\r\n");
            if (cp >= 10) {
                first = (cp - (cp % 10)) + 1;
                last = (cp - (cp % 10)) + 10;
                if ((tp - cp) >= 0 && (tp - cp) < 10) {
                    last = tp;
                    first = last - 9;
                }
                if (cp % 10 == 0) {
                    first = cp - 9;
                    last = cp;
                }
            }
            if (tp < 10) {
                last = tp;
            }
            if (cp > 10 && tp > 10) {
                int m = first - 1;
                sb.append("[<a href=\"#\" onclick=\"pagetogo(").append(1).append(")\" >").append(Utility.getMessage("datuu.wap.perpage.first")).append("</a>]&nbsp;\r\n");
                sb.append("<a href=\"#\" onclick=\"pagetogo(").append(m).append(")\" >").append("&lt;&lt;</a>&nbsp;\r\n");
            }
            for (int i = first; i <= last; i++) {
                if (i == cp) {
                    sb.append("[<strong><font color=\"red\">").append(i).append("</font></strong>]&nbsp;\r\n");
                }
                if (i != cp) {
                    sb.append("[<a href=\"#\" onclick=\"pagetogo(").append(i).append(")\" >").append("<strong>").append(i).append("</strong></a>]&nbsp;\r\n");
                }
            }
            if ((tp - last) >= 1 && (tp - last) < 10) {
                sb.append("<a href=\"#\" onclick=\"pagetogo(").append(tp).append(")\" >&gt;&gt;</a>&nbsp;\r\n");
            }
            if ((tp - last) >= 10) {
                sb.append("<a href=\"#\" onclick=\"pagetogo(").append(last + 1).append(")\" >&gt;&gt;</a>&nbsp;\r\n");
            }
            if (last < tp) {
                sb.append("[<a href=\"#\" onclick=\"pagetogo(").append(tp).append(")\" >").append(Utility.getMessage("datuu.wap.perpage.last")).append("</a>]\r\n");
            }

            //sb.append("<input name=\"txtgo\" id=\"txtgo\" type=\"text\" maxlength=\"4\" style=\"width:20px;\" onfocus=\"spreadgoto(this)\" onblur=\"shrinkgoto(this,'blur')\" onkeydown=\"txtgoto(event,this)\"/>\r\n");
            sb.append("<input name=\"txtgo\" id=\"txtgo\" type=\"text\" style=\"width:50px;\" onkeydown=\"txtgoto(event,this)\"/>\r\n");
            sb.append("[<a id=\"btngo\" href=\"#\" onclick=\"btntogo(this,'btn')\">GO</a>]\r\n");
        }
        sb.append("</td>\r\n");
        sb.append("</tr>\r\n");

        sb.append("<script language=\"javascript\">\r\n");
        sb.append("function pagetogo(togo){\r\n");
        sb.append("\tdocument.forms[0].target = \"_self\";\r\n");
        sb.append("\tdocument.forms[0].action = \"" + contextPath + getSearchUrl() + "&togo=\" + togo;\r\n");
        sb.append("\tdocument.forms[0].submit();\r\n");
        sb.append("\tLoading.show();\r\n");
        sb.append("}\r\n");

        sb.append("var tar=40;\r\n");
        sb.append("var maxtar=50;\r\n");
        sb.append("var mintar=20;\r\n");

        sb.append("function spreadgoto(obj){\r\n");
        sb.append("\tvar str=obj.style.width;\r\n");
        sb.append("\tstr=str.replace(/px/,'');\r\n");
        sb.append("\tvar i=parseInt(str,10);\r\n");
        sb.append("\tif(i<maxtar){\r\n");
        sb.append("\t\ti=i+10;\r\n");
        sb.append("\t\tobj.style.width=i+\"px\";\r\n");
        sb.append("\t\tvar t=window.setTimeout(spreadgoto,10,obj);\r\n");
        sb.append("\t}else{\r\n");
        sb.append("\t\tclearTimeout(t);\r\n");
        sb.append("\t\tshrinkgoto(obj,'auto');\r\n");
        sb.append("\t}\r\n");
        sb.append("}\r\n");

        sb.append("function shrinkgoto(obj,type){\r\n");
        sb.append("\tvar str=obj.style.width;\r\n");
        sb.append("\tstr=str.replace(/px/,'');\r\n");
        sb.append("\tvar i=parseInt(str,10);\r\n");
        sb.append("\tvar finalsize=tar;\r\n");
        sb.append("\tif(type=='blur'){\r\n");
        sb.append("\t\tfinalsize=mintar;\r\n");
        sb.append("\t}\r\n");
        sb.append("\tif(i>finalsize){\r\n");
        sb.append("\t\ti=i-1;\r\n");
        sb.append("\t\tobj.style.width=i+\"px\";\r\n");
        sb.append("\t\tvar t=window.setTimeout(shrinkgoto,40,obj,type);\r\n");
        sb.append("\t}else{\r\n");
        sb.append("\t\tclearTimeout(t);\r\n");
        sb.append("\t\treturn;\r\n");
        sb.append("\t}\r\n");
        sb.append("}\r\n");

        sb.append("function txtgoto(event,obj){\r\n");
        sb.append("\tif (event.keyCode==13){btntogo(obj,'txt');}\r\n");
        sb.append("}\r\n");
        sb.append("function btntogo(obj,objtype){\r\n");
        sb.append("\tvar togo=1;\r\n");
        sb.append("\tvar valnode=document.getElementById('txtgo');\r\n");
        sb.append("\tif(objtype=='txt'){\r\n");
        sb.append("\t\tvalnode=obj;\r\n");
        sb.append("\t\ttogo=obj.value;\r\n");
        sb.append("\t}else if(objtype=='btn'){\r\n");
        sb.append("\t\tvalnode=obj.parentNode.getElementsByTagName('input')[0]\r\n");
        sb.append("\t\ttogo=obj.parentNode.getElementsByTagName('input')[0].value\r\n");
        sb.append("\t}\r\n");
        sb.append("\tif (togo!=''&&isNum(togo)){\r\n" +
                "\t\tpagetogo(parseInt(togo,10))\r\n" +
                "\t}else{\r\n" +
                "\t\tvalnode.value='';\r\n\t\treturn;\r\n" +
                "\t}\r\n");
        sb.append("}\r\n");
        sb.append("</script>\r\n");
        return sb.toString();
    }

    public String getOrderbynamestr() {
        return orderbynamestr;
    }

    public void setOrderbynamestr(String orderbynamestr) {
        this.orderbynamestr = orderbynamestr;
    }

    public String getTotalPage2() {
        return totalPage2;
    }

    public void setTotalPage2(String totalPage2) {
        this.totalPage2 = totalPage2;
    }

    public String getTogo2() {
        return togo2;
    }

    public void setTogo2(String togo2) {
        this.togo2 = togo2;
    }
}
