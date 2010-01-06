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
            <h4><bean:message key="title.conference.edit"/></h4>
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
                        <logic:present parameter="datbegintime">
                        <input type="text" name="datbegintime" id="datbegintime" style="width:150px" ondblclick="clearCalendarInput(this);" value="${param.datbegintime}" readonly />
                        </logic:present>
                        <logic:notPresent parameter="datbegintime">
                            <input type="text" name="datbegintime" id="datbegintime" style="width:150px" ondblclick="clearCalendarInput(this);" value="<bean:write name="confapply" property="datbegintime" format="yyyy-MM-dd HH:mm:ss"/>" readonly />
                        </logic:notPresent>
                        <IMG id="datbegintime_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand"/>
                    </td>
                    <th width="25%"><bean:message key="label.conference.endtime"/></th>
                    <td width="25%">
                        <logic:present parameter="datendtime">
                        <input type="text" name="datendtime" id="datendtime" style="width:150px" ondblclick="clearCalendarInput(this);" value="${param.datendtime}" readonly/>
                        </logic:present>
                        <logic:notPresent parameter="datendtime">
                        <input type="text" name="datendtime" id="datendtime" style="width:150px" ondblclick="clearCalendarInput(this);" value="<bean:write name="confapply" property="datendtime" format="yyyy-MM-dd HH:mm:ss"/>" readonly/>
                        </logic:notPresent>
                        <IMG id="datendtime_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand"/>
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
var cal_beg  = new  Zapatec.Calendar({
        lang             : "zh",
        theme             : "system",
        showOthers        : false,
        showsTime         : true,
        step              : 1,
        singleClick       : true,
        inputField        : "datbegintime",
        button            : "datbegintime_ti",
        ifFormat          : "%Y-%m-%d %H:%M:%S",
        daFormat          : "%Y/%m/%d"
      });
var cal_over  = new  Zapatec.Calendar({
        lang             : "zh",
        theme             : "system",
        showOthers        : false,
        showsTime         : true,
        step              : 1,
        singleClick       : true,
        inputField        : "datendtime",
        button            : "datendtime_ti",
        ifFormat          : "%Y-%m-%d %H:%M:%S",
        daFormat          : "%Y/%m/%d"
      });
</script>
    </body>
</html>