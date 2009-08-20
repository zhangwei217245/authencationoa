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
        <html:form action="/ServerCer/showCerReg.do">

            <table width="800" align="center" style="text-align:center;vertical-align:middle">
    		<tr>
                <td width="20%"><bean:message key="cer.name"/></td>
    			<td width="20%">
                        <html:text property="searchname"/>
                </td>
                <td width="20%">
                    <bean:message key="label.cershowtype"/>
                </td>
                <td width="20%">
                    <html:select property="showtype">
                        <html:option value="all" key="label.all"/>
                        <html:option value="expired" key="label.cer.showtype.expired"/>
                        <html:option value="unexpired" key="label.cer.showtype.unexpired"/>
                    </html:select>
                </td>
                <td>
                    <input type="submit" value="<bean:message key="button.find"/>"/>
                </td>
    		</tr>
    	</table>
        <div class="divunderline"></div>
        <logic:notEmpty name="rstlst">
            <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                <thead>
                    <tr>
                        <th><bean:message key="cer.name"/></th>
                        <th><bean:message key="cer.departname"/></th>
                        <th><bean:message key="cer.oname"/></th>
                        <th><bean:message key="cer.cname"/></th>
                        <th><bean:message key="cer.pname"/></th>
                        <th><bean:message key="cer.ctname"/></th>
                        <th><bean:message key="cer.ctfname"/></th>
                        <th><bean:message key="cer.albyte"/></th>
                        <th><bean:message key="cer.cpass"/></th>
                        <th><bean:message key="cer.ppass"/></th>
                        <th><bean:message key="cer.location"/></th>
                        <th><bean:message key="cer.dday"/></th>
                        <th><bean:message key="cer.ddaybeg"/></th>
                        <th><bean:message key="cer.ddayover"/></th>
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate id="cereg" name="rstlst" type="com.vv.auth.persist.entity.Certificatereg">
                        <tr>
                            <td><bean:write name="cereg" property="name"/></td>
                            <td><bean:write name="cereg" property="departname"/></td>
                            <td><bean:write name="cereg" property="oname"/></td>
                            <td><bean:write name="cereg" property="cname"/></td>
                            <td><bean:write name="cereg" property="pname"/></td>
                            <td><bean:write name="cereg" property="ctname"/></td>
                            <td><bean:write name="cereg" property="ctfname"/></td>
                            <td><bean:write name="cereg" property="albyte"/></td>
                            <td><bean:write name="cereg" property="cpass"/></td>
                            <td><bean:write name="cereg" property="ppass"/></td>
                            <td><bean:write name="cereg" property="location"/></td>
                            <td><bean:write name="cereg" property="dday"/></td>
                            <td><bean:write name="cereg" property="ddaybeg" format="yyyy-MM-dd"/></td>
                            <td><bean:write name="cereg" property="ddayover" format="yyyy-MM-dd"/></td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>
        </logic:notEmpty>


        </html:form>
        
    </body>

   </html:html>