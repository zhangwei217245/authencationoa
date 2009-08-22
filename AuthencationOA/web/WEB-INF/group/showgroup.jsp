<%@ include file="/WEB-INF/util/includeTitle.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.showGroup"/></title>
    </head>
    <body>
    <%@ include file="/WEB-INF/util/title.jsp"%>
    <%@ include file="/WEB-INF/util/error.jsp"%>
    <h4><bean:message key="title.showGroup"/></h4>
    <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/GroupMana/addGroupinit.do"><bean:message key="button.add"/></a></span>
    </div>
    



    <center>

        <table border="0" cellpadding="0" cellspacing="0" class="datatable" width="80%">
            <thead>
                <tr>
                    <th width="20%"><bean:message key="label.groupName"/></th>
                    <th width="20%"><bean:message key="label.groupDesc"/></th>
                    <th width="20%"><bean:message key="label.createDate"/></th>
                    <th width="40%"><bean:message key="label.operation"/></th>
                </tr>
            </thead>
            <logic:notEmpty name="grouplist">
                <tbody align="center">
                <logic:iterate id="group" indexId="listindex" name="grouplist" type="com.vv.auth.persist.entity.TGroup">
                    <tr>
                        <td><bean:write name="group" property="groupName"/></td>
                        <td><bean:write name="group" property="tgDesc"/></td>
                        <td><bean:write name="group" property="genTime" format="yyyy-MM-dd hh:mm:ss"/></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/GroupMana/setGroupUserinit.do?groupid=<bean:write name="group" property="tgId"/>"><bean:message key="label.group.user"/></a>
                            <a href="<%=request.getContextPath()%>/GroupMana/setGroupRightinit.do?groupid=<bean:write name="group" property="tgId"/>"><bean:message key="label.group.right"/></a>
                            <logic:equal name="group" property="groupName" value="SuperAdmin">
                                <span style="text-decoration:underline;color:gray"><bean:message key="label.group.delete"/></span>
                            </logic:equal>
                            <logic:equal name="group" property="groupName" value="Innocent">
                                <span style="text-decoration:underline;color:gray"><bean:message key="label.group.delete"/></span>
                            </logic:equal>
                            <logic:notEqual name="group" property="groupName" value="Innocent">
                                <logic:notEqual name="group" property="groupName" value="SuperAdmin">
                                    <a href="<%=request.getContextPath()%>/GroupMana/delGroup.do?groupid=<bean:write name="group" property="tgId"/>"><bean:message key="label.group.delete"/></a>
                                </logic:notEqual>
                            </logic:notEqual>
                        </td>
                    </tr>
                </logic:iterate>
                </tbody>
            </logic:notEmpty>
            <logic:empty name="grouplist">
                <tr>
                    <td><bean:message key="warning.data.notexists"/></td>
                </tr>
            </logic:empty>
        </table>
    </center>
    
    
    
    </body>
</html>
