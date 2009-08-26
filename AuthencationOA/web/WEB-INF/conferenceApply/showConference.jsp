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
        <h4><bean:message key="title.conference.list"/></h4>
        <div class="divunderline">
            <span><a class="abutton" href="<%=request.getContextPath()%>/ConferenceMana/initApply.do"><bean:message key="button.add"/></a></span>
        </div>
        <html:form action="/ConferenceMana/searchConference.do">
            <center>
            <table width="800" align="center" style="text-align:center;vertical-align:middle">
    		<tr>
                <td width="25%"><bean:message key="label.conference.name"/></td>
    			<td width="25%">
                        <html:text property="vc2namefq"/>
                </td>
                <td width="25%">
                    <bean:message key="label.conference.status"/>
                </td>
                <td width="25%">
                    <html:select property="vc2statusfq">
                        <html:option value="" key="label.all"/>
                        <html:option value="P" key="label.conference.status.P"/>
                        <html:option value="Y" key="label.conference.status.Y"/>
                        <html:option value="N" key="label.conference.status.N"/>
                        <html:option value="B" key="label.conference.status.B"/>
                        <html:option value="O" key="label.conference.status.O"/>
                    </html:select>
                </td>

    		</tr>
            <tr>
                <td colspan="4" align="right">
                    <input type="submit" value="<bean:message key="button.find"/>"/>
                </td>
            </tr>
    	</table>
                </center>
        <div class="divunderline"></div>
        <logic:notEmpty name="rstlst">
            <center>
            <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                <thead>
                    <tr>
                        <th><bean:message key="label.conference.name"/></th>
                        <th><bean:message key="label.conference.begintime"/></th>
                        <th><bean:message key="label.conference.endtime"/></th>
                        <th><bean:message key="label.conference.group"/></th>
                        <th><bean:message key="label.conference.applier"/></th>
                        <th><bean:message key="label.conference.verifier"/></th>
                        <th><bean:message key="label.conference.status"/></th>
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate id="confapply" name="rstlst" type="com.vv.auth.persist.entity.ConferenceApply">
                        <tr>
                            <td>
                                <a href="<%=request.getContextPath()%>/ConferenceMana/viewApply.do?numapplyid=<bean:write name="confapply" property="numapplyid"/>">
                                    <bean:write name="confapply" property="vc2name"/>
                                </a>
                            </td>
                            <td><bean:write name="confapply" property="datbegintime" format="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><bean:write name="confapply" property="datendtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${confapply.tgId.groupName}</td>
                            <td>${confapply.numapplierid.name}</td>
                            <td>${confapply.numverifierid.name}</td>
                            <td><bean:message key="label.conference.status.${confapply.vc2status}"/></td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>
                    </center>
        </logic:notEmpty>


        </html:form>

    </body>

   </html:html>