<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <style>
            #datatable{
                text-align:center;
                vertical-align:middle;
                border:1px solid black;
            }
            #datatable thead tr th{
                border:1px solid silver;
                font-weight:bolder;
            }
            #datatable tbody tr td{
                border:1px solid silver;
            }
        </style>
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="title.serverCerReg.search"/></h4>
        <div class="divunderline"></div>
        <html:form action="/ClientCer/searchUser.do">
            <center>
            <table width="60%" align="center" style="vertical-align:middle">
    		<tr>
                    <td width="20%" style="text-align:right;"><bean:message key="label.username"/></td>
    			<td width="30%">
                        <html:text property="searchname"/>
                </td>
                <td width="20%" style="text-align:right;">
                    <bean:message key="label.cershowtype"/>
                </td>
                <td width="30%">
                    <html:select property="certype">
                        <html:option value="all" key="label.all"/>
                        <html:option value="expired" key="label.cer.showtype.expired"/>
                        <html:option value="unexpired" key="label.cer.showtype.unexpired"/>
                    </html:select>
                </td>
                
    		</tr>
            <tr>
                <td style="text-align:right;"><bean:message key="label.verifytype"/></td>
                <td>
                    <html:select property="verifystatus">
                        <html:option value="" key="label.all"/>
                        <html:option value="Y" key="label.verifytype.Y"/>
                        <html:option value="N" key="label.verifytype.N"/>
                    </html:select>
                </td>
                <td style="text-align:right;">
                    <input type="submit" value="<bean:message key="button.find"/>"/>
                </td>
                <td>&nbsp;</td>
            </tr>
    	</table>
        </center>
                    <div class="divtopline">${requestScope.pagination}</div>
        <center>
        <logic:notEmpty name="rstlst">
            <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                <thead>
                    <tr>
                        <th><bean:message key="label.username"/></th>
                        <th><bean:message key="cer.departname"/></th>
                        <th><bean:message key="cer.oname"/></th>
                        <th><bean:message key="cer.cname"/></th>
                        <th><bean:message key="cer.pname"/></th>
                        <th><bean:message key="cer.ctname"/></th>
                        <th><bean:message key="cer.dday"/></th>
                        <th><bean:message key="cer.ddaybeg"/></th>
                        <th><bean:message key="cer.ddayover"/></th>
                        <th><bean:message key="label.verifytype"/></th>
                        <th><bean:message key="label.operation"/></th>
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate id="user" name="rstlst" type="com.vv.auth.persist.entity.Vcustomer">
                        <tr>
                            <td><bean:write name="user" property="name"/>
                            <c:forEach items="${user.TGroupCollection}" var="group" varStatus="g">
                                        <c:if test="${g.index==0}">&nbsp;@&nbsp;</c:if>
                                        <c:if test="${g.index>0}">&nbsp;&amp;&nbsp</c:if>
                                        <c:out value="${group.tgDesc}"/>
                                    </c:forEach>
                            </td>
                            <td><bean:write name="user" property="departname"/></td>
                            <td><bean:write name="user" property="oname"/></td>
                            <td><bean:write name="user" property="cname"/></td>
                            <td><bean:write name="user" property="pname"/></td>
                            <td><bean:write name="user" property="ctname"/></td>
                            <td><bean:write name="user" property="dday"/></td>
                            <td><bean:write name="user" property="ddaybeg" format="yyyy-MM-dd"/></td>
                            <td><bean:write name="user" property="ddayover" format="yyyy-MM-dd"/></td>
                            <td>
                                <logic:equal value="Y" name="user" property="verifystatus">
                                    <bean:message key="label.verifytype.Y"/>
                                </logic:equal>
                                <logic:equal value="N" name="user" property="verifystatus">
                                    <bean:message key="label.verifytype.N"/>
                                </logic:equal>
                            </td>
                            <td>
                                <logic:equal value="N" name="user" property="verifystatus">
                                    <a href="<%=request.getContextPath()%>/ClientCer/verifyUser.do?userid=<bean:write name="user" property="userid"/>">
                                        <bean:message key="label.verify"/>
                                    </a>
                                </logic:equal>
                                <a href="<%=request.getContextPath()%>/ClientCer/deleteUser.do?userid=<bean:write name="user" property="userid"/>">
                                    <bean:message key="label.delete"/>
                                </a>
                            </td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>
        </logic:notEmpty>
        </center>
        <div class="divtopline">${requestScope.pagination}</div>
        </html:form>

    </body>

   </html:html>