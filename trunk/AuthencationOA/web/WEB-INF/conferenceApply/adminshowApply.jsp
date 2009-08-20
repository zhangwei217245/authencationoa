<%@ include file="/WEB-INF/util/includeTitle.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
            <title><bean:message key="welcome.title"/></title>
        <script>
            function changeStatus(obj){
                if(obj.value==''){
                    document.getElementById('submitButton').disabled=true;
                }else{
                    document.getElementById('submitButton').disabled=false;
                }
            }
            function checkForm(obj){
                if(obj.vc2status.value=='N'&&obj.vc2txtinfo.value==''){
                    alert('<bean:message key="label.conference.txtinfo.null"/>');
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/ConferenceMana/adminVerifyConference.do" onsubmit="return checkForm(this)">
            <h4><bean:message key="title.conference.view"/></h4>
            <div class="divunderline">
        <span><a class="abutton" href="<%=request.getContextPath()%>/ConferenceMana/adminSearchConference.do"><bean:message key="button.back"/></a></span>
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
                <logic:equal value="P" name="confapply" property="vc2status">
                <tr>
                    <th scope="row"><bean:message key="label.conference.status"/></th>
                    <td>
                        <html:select property="vc2status" onchange="changeStatus(this)">
                            <html:option value="" key="label.please"/>
                            <html:option value="Y" key="label.conference.status.Y"/>
                            <html:option value="N" key="label.conference.status.N"/>
                        </html:select>
                    </td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <th scope="row"><bean:message key="label.conference.txtinfo"/></th>
                    <td>
                        <html:textarea style="height:100px" property="vc2txtinfo"/>
                    </td>
                    <td colspan="2"></td>
                </tr>
                </logic:equal>
            </tbody>
        </table>

    </center>
    <div class="divtopline"><input id="submitButton" type="submit" disabled value="<bean:message key="button.submit"/>"/></div>
    </html:form>

    </body>
</html>