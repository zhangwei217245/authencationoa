<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="title.document.type"/></title>

            <html:base/>
        </head>
             <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="title.document.type"/></h4>
        <div class="divunderline">
            <span><a class="abutton" href="<%=request.getContextPath()%>/Document/documentTypeinit.do"><bean:message key="button.add"/></a></span>
        </div>
        <center>
            <table border="0" cellpadding="0" cellspacing="0" class="datatable" width="80%">
                <thead>
                    <tr>
                        <th width="50%"><bean:message key="document.type.name"/></th>
                        <th width="50%"><bean:message key="label.operation"/></th>
                    </tr>
                </thead>
                <logic:notEmpty name="typelist">
                    <tbody align="center">
                        <logic:iterate id="type" name="typelist">
                            <tr>
                                <td><bean:write name="type" property="vc2name" /></td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/Document/documentTypeEditInit.do?typeid=<bean:write name="type" property="numtypeid"/>"><bean:message key="button.modify"/></a>
                                    <a href="<%=request.getContextPath()%>/Document/documentTypeDelete.do?typeid=<bean:write name="type" property="numtypeid"/>"><bean:message key="label.delete"/></a>
                                    <!--<a href="<%=request.getContextPath()%>/Document/documentPathConfigInit.do?typeid=<bean:write name="type" property="numtypeid"/>"><bean:message key="label.verifypath.config"/></a>-->
                                </td>
                            </tr>
                        </logic:iterate>
                    </tbody>
                </logic:notEmpty>
            </table>
        </center>
    </body>
</html:html>