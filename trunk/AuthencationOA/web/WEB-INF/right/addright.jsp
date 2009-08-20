<%@ include file="/WEB-INF/util/includeTitle.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="title.addright"/></title>
    </head>
    <body>
        
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/RightMana/addRight.do" onsubmit="return validateRightform(this);">
            <h4><bean:message key="title.addright"/></h4>
            <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/RightMana/showRights.do"><bean:message key="button.back"/></a></span>
    </div>
            <center>
        <table border="0" class="formtable">
            <tbody>
                <tr>
                    <th scope="row"><bean:message key="label.rightName"/></th>
                    <td><html:text property="rightName"/></td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.rightType"/></th>
                    <td>
                        <html:select property="rightType">
                            <html:option value="" key="label.please"/>
                            <html:option value="menu" key="label.right.type.menu"/>
                            <html:option value="path" key="label.right.type.path"/>
                        </html:select>
<!--<html:radio property="rightType" value="menu"><bean:message key="label.right.type.menu"/></html:radio>-->
<!--<html:radio property="rightType" value="path"><bean:message key="label.right.type.path"/></html:radio>-->

                    </td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.rightPath"/></th>
                    <td><html:text property="rightPath"/></td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.rightDesc"/></th>
                    <td><html:text property="rightDesc"/></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
            
    </center>
    <div class="divtopline"><input type="submit" value="<bean:message key="button.submit"/>"/></div>
    </html:form>
    <html:javascript formName="rightform"/>
    </body>
</html>
