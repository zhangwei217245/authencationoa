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
        <html:form action="/ConferenceMana/initEditApply.do">
            <h4><bean:message key="title.conference.view"/></h4>
            <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/ConferenceMana/searchConference.do"><bean:message key="button.back"/></a></span>
    </div>
            <center>
                <html:hidden property="numapplyid" value="${confapply.numapplyid}"/>
        <table border="0" class="formtable">
            <tbody>
                <tr>
                    <th scope="row"><bean:message key="label.conference.name"/></th>
                    <td><bean:write name="confapply" property="vc2name"/></td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <th width="25%"><bean:message key="label.conference.begintime"/></th>
                    <td width="25%">
                        <bean:write name="confapply" property="datbegintime" format="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <th width="25%"><bean:message key="label.conference.endtime"/></th>
                    <td width="25%">
                        <bean:write name="confapply" property="datendtime" format="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.conference.desc"/></th>
                    <td><div><bean:write name="confapply" property="vc2desc"/></div></td>
                    <td colspan="2"></td>
                </tr>
                <logic:notEmpty name="confapply" property="vc2txtinfo">
                    <tr>
                        <th scope="row"><bean:message key="label.conference.txtinfo"/></th>
                        <td><div><bean:write name="confapply" property="vc2txtinfo"/></div></td>
                        <td colspan="2"></td>
                    </tr>
                </logic:notEmpty>
            </tbody>
        </table>

    </center>
    <div class="divtopline"><input type="submit" value="<bean:message key="button.modify"/>"/></div>
    </html:form>

    </body>
</html>