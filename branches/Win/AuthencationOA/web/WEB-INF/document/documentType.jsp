<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="title.document.type.add"/></title>
            <script>
            var s1=new SortUtil("groupsin","groupsout","groupsin",true);
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
                var groupsin = document.getElementById("groupsin");
                for(var i=0;i<groupsin.length;i++){
                    groupsin.options[i].selected=true;
                }
            }
            function moveUp(){
                s1.optionUp();
            }
            function moveDown(){
                s1.optionDown();
            }
            function upToFirst(){
                s1.optionUpFirst();
            }
            function downToLast(){
                s1.optionDownLast();
            }
        </script>
            <html:base/>
        </head>
     <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="title.document.type.add"/></h4>
        <div class="divunderline">
            <span><a class="abutton" href="<%=request.getContextPath()%>/Document/documentShowType.do"><bean:message key="button.back"/></a></span>
        </div>
        <html:form action="/Document/documentTypeAdd.do" onsubmit="selectall();" method="post">
            <center>
                <table border="0" class="formtable">
                    <tr>
                        <td><bean:message key="document.type.name"/></td>
                        <td><html:text property="vc2name"/></td>
                        <td><html:errors property="vc2name"/></td>
                    </tr>
                     
                </table>
            </center>
                        <div class="divtopline" style="text-align:left"><h4><bean:message key="label.documenttype.path"/></h4></div>
                        <center>
                <table border="0" align="center" width="90%" height="40%">
                    <tbody>
                        <tr>
                            <td width="30%" height="80%" style="text-align:center">
                                <fieldset style="height:100%">
                                    <legend><bean:message key="label.documenttype.path.groupout"/></legend>
                                    <div>
                                        <select id="groupsout" name="groupsout" style="width:80%" ondblclick="addopt()" size="15">
                                        <logic:iterate id="outgroup" name="outGroups" type="com.vv.auth.persist.entity.TGroup" scope="request" indexId="goid">
                                            <option value="<bean:write name="outgroup" property="tgId"/>"><bean:write name="outgroup" property="groupName"/></option>
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
                            <td width="30%" height="80%" style="vertical-align:middle">
                                <fieldset style="height:100%;vertical-align:middle">
                                    <legend><bean:message key="label.documenttype.path.groupin"/></legend>
                                    <div style="text-align:center;vertical-align:middle">
                                        <select id="groupsin" name="groupsin" style="width:80%" ondblclick="delopt()" size="15" multiple>
                                        <logic:iterate id="ingroup" name="inGroups" type="com.vv.auth.persist.entity.TGroup" scope="request" indexId="giid">
                                            <option value="<bean:write name="ingroup" property="tgId"/>"><bean:write name="ingroup" property="groupName"/></option>
                                        </logic:iterate>
                                        </select>
                                    </div>
                                </fieldset>
                            </td>
                            <td width="20%" height="80%" style="text-align:center;vertical-align:middle">
                                <input id="btn_upfirst" style="width:100px" type="button" onclick="upToFirst()" value="<bean:message key="option.upfirst"/>" style="width:50px"/><br/>
                                <input id="btn_up" style="width:100px" type="button" onclick="moveUp()" value="<bean:message key="option.up"/>" style="width:50px"/><br/>
                                <input id="btn_down" style="width:100px" type="button" onclick="moveDown()" value="<bean:message key="option.down"/>" style="width:50px"/><br/>
                                <input id="btn_downlast" style="width:100px" type="button" onclick="downToLast()" value="<bean:message key="option.downlast"/>" style="width:50px"/><br/>
                            </td>
                        </tr>
                        <tr >
                            <td colspan="4" style="text-align:center;vertical-align:middle;padding-top:50px" height="20%">
                                 <input type="submit" value="<bean:message key="button.submit"/>" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                            </center>
        </html:form>
    </body>
</html:html>