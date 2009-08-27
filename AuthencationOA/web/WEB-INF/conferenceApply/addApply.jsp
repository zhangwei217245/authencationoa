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
        <html:form action="/ConferenceMana/submitApply.do">
            <h4><bean:message key="title.conference.add"/></h4>
            <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/ConferenceMana/searchConference.do"><bean:message key="button.back"/></a></span>
    </div>
            <center>
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
                        <input type="text" name="datbegintime" id="datbegintime" style="width:150px" ondblclick="clearCalendarInput(this);" value="${param.datbegintime}" readonly />
                        <IMG id="datbegintime_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand"/>
                    </td>
                    <th width="25%"><bean:message key="label.conference.endtime"/></th>
                    <td width="25%">
                        <input type="text" name="datendtime" id="datendtime" style="width:150px" ondblclick="clearCalendarInput(this);" value="${param.datendtime}" readonly/>
                        <IMG id="datendtime_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand"/>
                        
                    </td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.conference.desc"/></th>
                    <td><html:textarea property="vc2desc" style="height:100px"/></td>
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