<%@ include file="/WEB-INF/util/includeTitle.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="label.group.user"/></title>
        <script>
        var s1=new SortUtil("tguser","useroutGroup","tguser",true);
        function addopt(){
            s1.addoption("", "", "", "");
        }
        function delopt(){
            s1.deloption("", "", "", "");
        }
        function addopts(){
            s1.addallopts("", "", "", "");
        }
        function delopts(){
            s1.delallopts("", "", "", "");
        }
        function selectall(){
            var tguser = document.getElementById("tguser");
            for(var i=0;i<tguser.length;i++){
                tguser.options[i].selected=true;
            }

        }
        </script>
    </head>
    <body>
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/GroupMana/setGroupUser.do" onsubmit="selectall();">
        <h4><bean:message key="label.group.user"/></h4>
        <div class="divunderline">
            <div style="font-weight:bolder;font-size:12pt;text-align:center">
            <bean:message key="label.currentGroup"/>:<bean:write name="groupname" scope="request"/>--<bean:write name="groupdesc" scope="request"/>
            </div>
            <span><a class="abutton" href="<%=request.getContextPath()%>/GroupMana/showGroups.do"><bean:message key="button.back"/></a></span>
        </div>
        <html:hidden property="tgId"/>
            <table border="0" align="center" width="90%" height="40%">
                    <tbody>
                        <tr>
                            <td width="40%" height="80%" style="text-align:center">
                                <fieldset style="height:100%">
                                    <legend><bean:message key="label.group.userout"/></legend>
                                    <div>
                                    <select name="useroutGroup" style="width:80%" ondblclick="addopt()" size="15">
                                        <logic:iterate id="userout" name="useroutGroup" type="com.vv.auth.persist.entity.Vcustomer" scope="request" indexId="uoid">
                                            <option value="<bean:write name="userout" property="userid"/>"><bean:write name="userout" property="name"/></option>
                                        </logic:iterate>
                                    </select>
                                    </div>
                                </fieldset>
                            </td>
                            <td width="20%" height="80%" style="text-align:center;vertical-align:middle">
                                <input id="add" type="button" onclick="addopt()" value=">>" style="width:50px"/><br/>
                                <input id="del" type="button" onclick="delopt()" value="<<" style="width:50px"/><br/>
                                <input id="addall" type="button" onclick="addopts()" value=">>>" style="width:50px"/><br/>
                                <input id="delall" type="button" onclick="delopts()" value="<<<" style="width:50px"/><br/>
                            </td>
                            <td width="40%" height="80%" style="vertical-align:middle">
                                <fieldset style="height:100%;vertical-align:middle">
                                    <legend><bean:message key="label.group.userin"/></legend>
                                    <div style="text-align:center;vertical-align:middle">
                                       <select name="tguser" style="width:80%" ondblclick="delopt()" size="15" multiple>
                                        <logic:iterate id="userin" name="userinGroup" type="com.vv.auth.persist.entity.Vcustomer" scope="request" indexId="uiid">
                                            <option value="<bean:write name="userin" property="userid"/>"><bean:write name="userin" property="name"/></option>
                                        </logic:iterate>
                                        </select>
                                    </div>
                                </fieldset>
                            </td>
                        </tr>
                        <tr >
                            <td colspan="4" style="text-align:center;vertical-align:middle;padding-top:50px" height="20%">
                                <input type="submit" value="<bean:message key="button.submit"/>"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </html:form>
    </body>
</html>
