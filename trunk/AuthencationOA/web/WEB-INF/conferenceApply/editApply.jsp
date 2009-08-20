<%@ include file="/WEB-INF/util/includeTitle.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="welcome.title"/></title>
    </head>
    <body>
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/ConferenceMana/editApply.do">
            <h4><bean:message key="title.conference.add"/></h4>
            <div class="divunderline">
                <span><a class="abutton" href="<%=request.getContextPath()%>/ConferenceMana/viewApply.do?numapplyid=<bean:write name="confapply" property="numapplyid"/>">
            <bean:message key="button.back"/></a></span>
    </div>
            <center>
                <html:hidden property="numapplyid"/>
        <table border="0" class="formtable">
            <tbody>
                <tr>
                    <th scope="row"><bean:message key="label.conference.name"/></th>
                    <td><html:text property="vc2name"/></td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <th width="25%"><bean:message key="label.conference.begintime"/></th>
                    <td width="25%">
                        <html:text property="datbegintime" style="width:150px" ondblclick="chanageTime('datbegintime');" readonly="true" />
                        <input type = "text"  id="datbegintime_ch" style="border:1px solid #e2e2e2;width:160px;display:none" onBlur="backToInput('datbegintime');" />
                        <IMG id="datbegintime_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand" onClick="showCalendar('datbegintime');"/>
                    </td>
                    <th width="25%"><bean:message key="label.conference.endtime"/></th>
                    <td width="25%">
                        <html:text property="datendtime" style="width:150px" ondblclick="chanageTime('datendtime');" readonly="true" />
                        <input type = "text"  id="datendtime_ch" style="border:1px solid #e2e2e2;width:160px;display:none" onBlur="backToInput('datendtime');" />
                        <IMG id="datendtime_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand" onClick="showCalendar('datendtime');"/>
                        
                    </td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.conference.desc"/></th>
                    <td><html:textarea style="height:100px" property="vc2desc"/></td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.conference.status"/></th>
                    <td>
                        <html:select property="vc2status">
                            <html:option value="${confapply.vc2status}" key="label.conference.status.${confapply.vc2status}"/>
                            <logic:equal value="Y" name="confapply" property="vc2status">
                                <html:option value="B" key="label.conference.status.B"/>
                            </logic:equal>
                            <logic:equal value="B" name="confapply" property="vc2status">
                                <html:option value="O" key="label.conference.status.O"/>
                            </logic:equal>
                        </html:select>
                    </td>
                    <td colspan="2"></td>
                </tr>
            </tbody>
        </table>

    </center>
    <div class="divtopline">
        <input type="submit" value="<bean:message key="button.submit"/>"/>&nbsp;&nbsp;
        <input type="reset" value="<bean:message key="button.reset"/>"/>
    </div>
    </html:form>
<script type="text/javascript">
	Zapatec.Calendar.setup({
			firstDay          : 1,
			electric          : true,
			inputField        : "datbegintime",
			button            : "datbegintime_ti",
			ifFormat          : "%Y-%m-%d %H:%M:%S",
			daFormat          : "%Y-%m-%d %H:%M:%S"
		  });
	Zapatec.Calendar.setup({
			firstDay          : 1,
			electric          : true,
			inputField        : "datendtime",
			button            : "datendtime_ti",
			ifFormat          : "%Y-%m-%d %H:%M:%S",
			daFormat          : "%Y-%m-%d %H:%M:%S"
		  });
</script>
    </body>
</html>