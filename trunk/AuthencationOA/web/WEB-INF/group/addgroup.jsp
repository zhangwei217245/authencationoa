<%@ include file="/WEB-INF/util/includeTitle.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="title.addgroup"/></title>
    </head>
    <body>
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/GroupMana/addGroup.do" onsubmit="return validateGroupform(this)">
            <h4><bean:message key="title.addgroup"/></h4>
            <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/GroupMana/showGroups.do"><bean:message key="button.back"/></a></span>
    </div>
            <center>
        <table border="0" class="formtable">
            <tbody>
                <tr>
                    <th scope="row"><bean:message key="label.groupName"/></th>
                    <td><html:text property="groupName"/></td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.groupDesc"/></th>
                    <td><html:text property="tg_desc"/></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
            
    </center>
    <div class="divtopline"><input type="submit" value="<bean:message key="button.submit"/>"/></div>
    </html:form>
    <html:javascript formName="groupform"/>
    </body>
</html>
