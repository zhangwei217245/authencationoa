<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="document.create"/></title>
            <script type="text/javascript">
                function changeKeepAttach(obj){
                    document.getElementsByName("vc2addition")[0].disabled = obj.checked;
                }
            </script>
            <html:base/>
        </head>
     <body style="background-color: white">
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="document.create"/></h4>

        <html:form action="/Document/updateDocument.do" onsubmit="" method="post" enctype="multipart/form-data">
            <center>
                <table align="center" border="0" class="formtable" style="height:70%">
                    <tr>
                        <td><bean:message key="document.type"/><span class="required">*</span></td>
                        <td>
                            <html:select property="numtypeid" value="${requestScope.docDetail.numtypeid.numtypeid}">
                                <html:optionsCollection name="typelist"/>
                            </html:select>
                        </td>
                        <td><html:errors property="numtypeid"/></td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.title"/><span class="required">*</span></td>
                        <td><html:text property="vc2title" value="${requestScope.docDetail.vc2title}" style="width:400px"/></td>
                        <td><html:errors property="vc2title"/></td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.content"/><span class="required">*</span></td>
                        <td><html:textarea property="vc2content" value="${requestScope.docDetail.vc2content}" style="height:400px;width:400px"/></td>
                        <td><html:errors property="vc2content"/></td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.addition"/><span class="not_required">*</span></td>
                        <td>
                            
                            <logic:notEmpty name="docDetail" property="vc2addition">
                            ${requestScope.docDetail.vc2additionname}&nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/Document/documentDownload.do?numdocid=${requestScope.docDetail.numdocid}" target="_blank">
                                <bean:message key="label.download"/>
                            </a>
                            <html:file property="vc2addition" style="width:400px;" disabled="true"/><br/>
                            <label>
                                <input type="checkbox" checked name="isKeepAttach" value="Y" onclick="changeKeepAttach(this)"/>
                                <bean:message key="document.isKeepAttach"/>
                            </label>

                            </logic:notEmpty>
                            <logic:empty name="docDetail" property="vc2addition">
                                <html:file property="vc2addition" style="width:400px;" disabled="false"/>
                            </logic:empty>
                            
                        </td>
                        <td><html:errors property="vc2addition"/></td>
                    </tr>
                    <tr>
                        <td colspan="3" style="text-align:center">
                            <input type="submit" value="<bean:message key="button.submit"/>">
                            <input type="button" value="<bean:message key="button.cancel"/>">
                        </td>
                    </tr>

                </table>
                        </center>
        </html:form>
        <div class="divtopline">&nbsp;</div>
        <center>
        <table width="90%" align="center" cellpadding="0" cellspacing="0" class="verifytable">
            <thead>
                <tr>
                    <th colspan="3" style="text-align:left">
                        <h3><bean:message key="document.verifydetail"/></h3>
                    </th>
                </tr>
            </thead>
            <logic:notEmpty name="docVerifies" scope="request">
            <logic:iterate id="verify" name="docVerifies" indexId="idx" type="com.vv.auth.persist.entity.Documentverify">
                <tbody>
                <tr>
                    <th width="40%" style="text-align:left" height="20px;">
                        ${verify.userid.name}
                    </th>
                    <th width="30%" style="text-align:center" height="20px;">
                        <bean:message key="document.department.result.${verify.chresult}"/>
                    </th>
                    <th width="40%" style="text-align:right" height="20px;">
                        <bean:write name="verify" property="dattime" format="yyyy-MM-dd HH:mm:ss"/>
                    </th>
                </tr>
                <tr>
                    <td colspan="3" height="80px;" style="overflow:auto;table-layout:fixed;word-break:break-all">
                        <bean:write name="verify" property="vc2message"/>
                    </td>
                </tr>
                </tbody>
            </logic:iterate>
            </logic:notEmpty>
            <logic:empty name="docVerifies">

                <tr>
                    <td colspan="3" style="text-align:center"><bean:message key="document.verifydetail.notfound"/></td>
                </tr>

            </logic:empty>
        </table>
        </center>
    </body>
</html:html>