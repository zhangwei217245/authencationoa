<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="document.viewdetail"/></title>
            <html:base/>
        </head>
     <body style="background-color: white">
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="document.viewdetail"/></h4>

        <html:form action="/Document/saveDocument.do" onsubmit="" method="post" enctype="multipart/form-data">
            <center>
                <table align="center" border="0" class="formtable" style="margin-right:250px">
                    <tr>
                        <td><bean:message key="document.type"/><span class="not_required">*</span></td>
                        <td>
                            ${requestScope.docDetail.numtypeid.vc2name}
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.title"/><span class="not_required">*</span></td>
                        <td>${requestScope.docDetail.vc2title}</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.content"/><span class="not_required">*</span></td>
                        <td style="height:100px;overflow:auto;table-layout:fixed;word-break:break-all">${requestScope.docDetail.vc2content}</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.addition"/><span class="not_required">*</span></td>
                        <td>
                            ${requestScope.docDetail.vc2additionname}&nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/Document/documentDownload.do?numdocid=${requestScope.docDetail.numdocid}" target="_blank">
                                <bean:message key="label.download"/>
                            </a>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
                     </center>
                            <div class="divtopline">&nbsp;</div>
                            <center>
                            <table width="90%" align="center" cellpadding="0" cellspacing="0" border="0" class="verifytable" style="margin-right:250px">
                                <thead>
                                    <tr>
                                        <th colspan="3" style="text-align:left">
                                            <h3><bean:message key="document.verifydetail"/></h3>
                                        </th>
                                    </tr>
                                </thead>
                                <logic:notEmpty name="docVerifies" scope="request">
                                <logic:iterate id="verify" name="docVerifies" indexId="idx" type="com.vv.auth.persist.entity.Documentverify">
                                    <tr>
                                        <td width="40%" style="text-align:left" height="20px;">
                                            ${verify.userid.name}
                                        </td>
                                        <td width="30%" style="text-align:center" height="20px;">
                                            <bean:message key="document.department.result.${verify.chresult}"/>
                                        </td>
                                        <td width="40%" style="text-align:right" height="20px;">
                                            <bean:write name="verify" property="dattime" format="yyyy-MM-dd HH:mm:ss"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" height="80px;" style="overflow:auto;table-layout:fixed;word-break:break-all">
                                            <bean:write name="verify" property="vc2message"/>
                                        </td>
                                    </tr>
                                </logic:iterate>
                                </logic:notEmpty>
                                <logic:empty name="docVerifies">
                                    <tr>
                                        <td colspan="3" style="text-align:center"><bean:message key="document.verifydetail.notfound"/></td>
                                    </tr>
                                </logic:empty>
                            </table>
                            </center>
                            
        </html:form>
    </body>
</html:html>