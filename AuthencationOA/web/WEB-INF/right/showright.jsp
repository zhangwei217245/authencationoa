<%@ include file="/WEB-INF/util/includeTitle.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.showRight"/></title>
        
    </head>
    <body>
    <%@ include file="/WEB-INF/util/title.jsp"%>
    <%@ include file="/WEB-INF/util/error.jsp"%>
    <h4><bean:message key="title.showRight"/></h4>
    <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/RightMana/addRightinit.do"><bean:message key="button.add"/></a></span>
    </div>
    


<div class="divunderline">${requestScope.pagination}</div>
    <center>

        <table border="0" cellpadding="0" cellspacing="0" class="datatable" width="80%">
            <thead>
                <tr>
                    <th width="20%"><bean:message key="label.rightName"/></th>
                    <th width="20%"><bean:message key="label.rightDesc"/></th>
                    <th width="10%"><bean:message key="label.rightType"/></th>
                    <th width="20%"><bean:message key="label.rightPath"/></th>
                    <th width="30%"><bean:message key="label.operation"/></th>
                </tr>
            </thead>
            <logic:notEmpty name="rightlist">
                <tbody align="center">
                <logic:iterate id="right" indexId="listindex" name="rightlist" type="com.vv.auth.persist.entity.TRight">
                    <tr>
                        <td><bean:write name="right" property="rightName"/></td>
                        <td>&nbsp;<bean:write name="right" property="rightDesc"/>&nbsp;</td>
                        <td>
                            <logic:equal name="right" property="rightType" value="menu">
                                <bean:message key="label.right.type.menu"/>
                            </logic:equal>
                            <logic:equal name="right" property="rightType" value="path">
                                <bean:message key="label.right.type.path"/>
                            </logic:equal>
                        </td>
                        <td>
                            <bean:write name="right" property="rightPath"/>
                        </td>
                        <td>
                           <a href="<%=request.getContextPath()%>/RightMana/delRight.do?rightid=<bean:write name="right" property="trId"/>"><bean:message key="label.right.delete"/></a>
                        </td>
                    </tr>
                </logic:iterate>
                </tbody>
            </logic:notEmpty>
            <logic:empty name="rightlist">
                <tr>
                    <td><bean:message key="warning.data.notexists"/></td>
                </tr>
            </logic:empty>
        </table>
    </center>
    <div class="divtopline">${requestScope.pagination}</div>
    
    
    </body>
</html>
