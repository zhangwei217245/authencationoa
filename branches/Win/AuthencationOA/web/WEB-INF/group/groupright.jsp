<%@ include file="/WEB-INF/util/includeTitle.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="label.group.right"/></title>
        <script>
        var s1=new SortUtil("tgright","rightoutGroup","tgright",true);
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
            var tgright = document.getElementById("tgright");
            for(var i=0;i<tgright.length;i++){
                tgright.options[i].selected=true;
            }

        }
        </script>
    </head>
    <body>
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/GroupMana/setGroupRight.do" onsubmit="selectall();">
        <h4><bean:message key="label.group.right"/></h4>
        <div class="divunderline">
            <div style="font-weight:bolder;font-size:12pt;text-align:center">
            <bean:message key="label.currentGroup"/>:<bean:write name="groupname" scope="request"/>--<bean:write name="groupdesc" scope="request"/>
            </div>
            <span><a class="abutton" href="<%=request.getContextPath()%>/GroupMana/showGroups.do"><bean:message key="button.back"/></a></span>
        </div>
        <html:hidden property="tgId"/>
        <center>
            <table border="0" align="center" width="90%" height="40%">
                    <tbody>
                        <tr>
                            <td width="40%" height="80%" style="text-align:center">
                                <fieldset style="height:100%">
                                    <legend><bean:message key="label.group.rightout"/></legend>
                                    <div>
                                        <select id="rightoutGroup" name="rightoutGroup" style="width:90%" ondblclick="addopt()" size="15">
                                        <logic:iterate id="rightout" name="rightoutGroup" type="com.vv.auth.persist.entity.TRight" scope="request" indexId="roid">
                                            <option value="<bean:write name="rightout" property="trId"/>"><bean:write name="rightout" property="rightName"/>
                                            --&nbsp;<bean:write name="rightout" property="rightDesc"/>&nbsp;--&nbsp;
                                            <logic:equal name="rightout" property="rightType" value="menu">
                                                <bean:message key="label.right.type.menu"/>
                                            </logic:equal>
                                            <logic:equal name="rightout" property="rightType" value="path">
                                                <bean:message key="label.right.type.path"/>
                                            </logic:equal>
                                            </option>
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
                                    <legend><bean:message key="label.group.rightin"/></legend>
                                    <div style="text-align:center;vertical-align:middle">
                                        <select id="tgright" name="tgright" style="width:90%" ondblclick="delopt()" size="15" multiple>
                                        <logic:iterate id="rightin" name="rightinGroup" type="com.vv.auth.persist.entity.TRight" scope="request" indexId="riid">
                                            <option value="<bean:write name="rightin" property="trId"/>">
                                                <bean:write name="rightin" property="rightName"/>
                                                --&nbsp;<bean:write name="rightin" property="rightDesc"/>&nbsp;--&nbsp;
                                            <logic:equal name="rightin" property="rightType" value="menu">
                                                <bean:message key="label.right.type.menu"/>
                                            </logic:equal>
                                            <logic:equal name="rightin" property="rightType" value="path">
                                                <bean:message key="label.right.type.path"/>
                                            </logic:equal>
                                            </option>
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
                            </center>
        </html:form>
    </body>
</html>
