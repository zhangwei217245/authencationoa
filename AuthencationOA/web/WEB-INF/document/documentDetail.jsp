<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="document.viewdetail"/></title>
            <script type="text/javascript">
                function setAdvicetag(obj){
                    document.getElementsByName("advicetag")[0].value = obj.value;
                }
            </script>
            <html:base/>
        </head>
     <body style="background-color: white">
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="document.viewdetail"/></h4>

        
            <center>
                <table align="center" border="0" class="formtable">
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
                            <logic:notEmpty name="docDetail" property="vc2addition">
                            ${requestScope.docDetail.vc2additionname}&nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/Document/documentDownload.do?numdocid=${requestScope.docDetail.numdocid}" target="_blank">
                                <bean:message key="label.download"/>
                            </a>
                            </logic:notEmpty>
                            <logic:empty name="docDetail" property="vc2addition">
                                (<bean:message key="document.attachment.none"/>)
                            </logic:empty>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                              <logic:equal name="docDetail" property="vc2result" value="N">
                                  <logic:equal name="docDetail" property="vc2use" value="R">
                                  <a href="<%=request.getContextPath()%>/Document/modifyDocument.do?numdocid=<bean:write name="docDetail" property="numdocid"/>" style="visibility:${requestScope.showModifyLink}"><bean:message key="button.modify"/></a>
                                  </logic:equal>
                              </logic:equal>
                        </td>
                    </tr>
                </table>
             </center>
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
                        <c:forEach items="${verify.userid.TGroupCollection}" var="group" varStatus="g">
                            <c:if test="${g.index==0}">&nbsp;@&nbsp;</c:if>
                            <c:if test="${g.index>0}">&nbsp;&amp;&nbsp</c:if>
                            <c:out value="${group.tgDesc}"/>
                        </c:forEach>
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
                        <div style="visibility:${requestScope.showVerifyForm}">
                            <div class="divtopline"></div>
        <html:form action="/Document/auditDocument.do" onsubmit="return validateDocumentForm(this)" method="post" enctype="multipart/form-data">
            <html:hidden property="numdocid" value="${requestScope.docDetail.numdocid}"/>
            <html:hidden property="advicetag"/>
            <center>
                <table width="90%" align="center" border="0" cellpadding="0" cellspacing="0" class="formtable">
                    <tr>
                        <th style="text-align:left;height:50px"><h3><bean:message key="docuemnt.advice"/></h3></th>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="radio" name="advice" onclick="setAdvicetag(this)" value="Y"/><bean:message key="docuemnt.advice.Y"/></label><br/>
                            <label><input type="radio" name="advice" onclick="setAdvicetag(this)" value="N"/><bean:message key="docuemnt.advice.N"/></label><br/>
                            <label><input type="radio" name="advice" onclick="setAdvicetag(this)" value="R"/><bean:message key="docuemnt.advice.R"/></label><br/>
                            <label><input type="radio" name="advice" onclick="setAdvicetag(this)" value="T"/><bean:message key="docuemnt.advice.T"/></label>
                                <html:errors property="advicetag"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="height:200px;vertical-align:middle">
                            <span style="height:100%;vertical-align:top"><bean:message key="document.advice.message"/></span>&nbsp;&nbsp;&nbsp;&nbsp;
                            <html:textarea property="vc2message" style="height:150px;width:300px"/>
                            <div><html:errors property="vc2message"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="<bean:message key="button.ok"/>"/>
                        </td>
                    </tr>
                </table>
            </center>
                        <html:javascript formName="documentForm"/>
        </html:form>
        </div>
    </body>
</html:html>