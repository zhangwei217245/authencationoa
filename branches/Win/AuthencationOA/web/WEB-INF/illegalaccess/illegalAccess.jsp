<%-- 
    Document   : illegalAccess
    Created on : 2009-12-31, 16:11:15
    Author     : x-spirit
--%>

<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html:html locale="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="access.illegal"/></title>
        <style type="text/css">
            #datatable{
                text-align:center;
                vertical-align:middle;
                border:1px solid black;
            }
            #datatable thead tr th{
                border:1px solid silver;
                font-weight:bolder;
            }
            #datatable tbody tr td{
                border:1px solid silver;
            }
        </style>
        <script type="text/javascript">
            
            var s1=new SortUtil("userids","allusers","userids",true);
            var s2=new SortUtil("rightids","allrights","rightids",true);
            
            function adduser(){
                if(document.getElementById("userids").options.length>=5){
                    alert("<bean:message key="access.illegal.criteria.cata.user.most"/>");return;
                }
                s1.addoption("", "", "", "");
            }

            function deluser(){
                s1.deloption("", "", "", "");
            }

            function moveUserUp(){
                s1.optionUp();
            }

            function moveUserDown(){
                s1.optionDown();
            }

            function upUserToFirst(){
                s1.optionUpFirst();
            }

            function downUserToLast(){
                s1.optionDownLast();
            }

            //#####

            function addright(){
                if(document.getElementById("rightids").options.length>=5){
                    alert("<bean:message key="access.illegal.criteria.cata.right.most"/>");return;
                }
                s2.addoption("", "", "", "");
            }

            function delright(){
                s2.deloption("", "", "", "");
            }

            function moveRightUp(){
                s2.optionUp();
            }

            function moveRightDown(){
                s2.optionDown();
            }

            function upRightToFirst(){
                s2.optionUpFirst();
            }

            function downRightToLast(){
                s2.optionDownLast();
            }

            //###
            function enableUser(obj){
                var bool = !obj.checked;
                document.getElementById("allusers").disabled=bool;
                document.getElementById("addauser").disabled=bool;
                document.getElementById("delauser").disabled=bool;
                document.getElementById("userids").disabled=bool;
                document.getElementById("upuserfirst").disabled=bool;
                document.getElementById("upuser").disabled=bool;
                document.getElementById("downuser").disabled=bool;
                document.getElementById("downuserlast").disabled=bool;
            }
            function enableRight(obj){
                var bool = !obj.checked;
                document.getElementById("allrights").disabled=bool;
                document.getElementById("addaright").disabled=bool;
                document.getElementById("delaright").disabled=bool;
                document.getElementById("rightids").disabled=bool;
                document.getElementById("uprightfirst").disabled=bool;
                document.getElementById("upright").disabled=bool;
                document.getElementById("downright").disabled=bool;
                document.getElementById("downrightlast").disabled=bool;
            }

            function selectAllList(){
                if(document.getElementsByName("criterias")[0].checked==false&&document.getElementsByName("criterias")[1].checked==false){
                    alert("<bean:message key="access.illegal.criteria.cata.atleastOne"/>");
                    return false;
                }
                var userids = document.getElementById("userids");
                for(var i=0;i<userids.length;i++){
                    userids.options[i].selected=true;
                }
                var rightids = document.getElementById("rightids");
                for(var i=0;i<rightids.length;i++){
                    rightids.options[i].selected=true;
                }
            }
        </script>
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="access.illegal"/></h4>
        <div class="divunderline"></div>
        <html:form action="/IllegalAccess/illegalAccessShowCata.do" method="post" onsubmit="return selectAllList()" target="rstFrame">
            <center>
                <table width="800" border="0" align="center" style="text-align:center;vertical-align:middle">
                    <tr>
                        <td colspan="2">
                            <fieldset>
                                <legend><bean:message key="access.illegal.range.time"/></legend>
                                <bean:message key="access.illegal.datetime.beg" />&nbsp;&nbsp;
                                <logic:notEmpty name="yesterday">
                                    <input type = "text" name="beg" id="beg" style="width:150px" readonly="true" ondblclick="clearCalendarInput(this);" value="<bean:write name="yesterday" format="yyyy-MM-dd HH:mm:ss"/>"/>
                                </logic:notEmpty>
                                <logic:empty name="yesterday">
                                    <input type = "text" name="beg" id="beg" style="width:150px" readonly="true" ondblclick="clearCalendarInput(this);" value="${param.beg}"/>
                                </logic:empty>
                                <IMG id="beg_ti" alt="beg_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor:pointer" onClick="showCalendar('beg');" />
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <bean:message key="access.illegal.datetime.over" />&nbsp;&nbsp;
                                <logic:notEmpty name="today">
                                    <input type = "text" name="over" id="over" style="width:150px" readonly="true" ondblclick="clearCalendarInput(this);" value="<bean:write name="today" format="yyyy-MM-dd HH:mm:ss"/>"/>
                                </logic:notEmpty>
                                <logic:empty name="today">
                                    <input type = "text" name="over" id="over" style="width:150px" readonly="true" ondblclick="clearCalendarInput(this);" value="${param.over}"/>
                                </logic:empty>
                                <IMG id="over_ti" alt="over_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor:pointer" onClick="showCalendar('over');" />

                            </fieldset>
                        </td>
                    </tr>
                    <tr>
                        <td width="10%" style="text-align:left;">
                            <bean:message key="access.illegal.criteria.cata"/>
                        </td>
                        <td width="90%">&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            <label><html:checkbox property="criterias" value="userid" onclick="enableUser(this)"/><bean:message key="access.illegal.criteria.cata.user"/></label>
                        </td>
                        <td>
                            <table width="100%" border="0" align="center" style="text-align:center;">

                                <tr>
                                    <td width="40%"><bean:message key="access.illegal.criteria.cata.all"/></td>
                                    <td width="10%">&nbsp;</td>
                                    <td width="40%"><bean:message key="access.illegal.criteria.cata.select"/></td>
                                    <td width="10%">&nbsp;</td>
                                </tr>

                                <tr>
                                    <td width="40%">
                                        <select id="allusers" name="allusers" style="width:80%" ondblclick="adduser()" disabled="true" size="5">
                                            <option value="null"><bean:message key="user.noname"/></option>
                                            <logic:notEmpty name="allusers" scope="request">
                                                <logic:iterate id="user" name="allusers" type="com.vv.auth.persist.entity.Vcustomer" scope="request" indexId="uoid">
                                                    <option value="<bean:write name="user" property="userid"/>">
                                                        ${user.name}
                                                        <c:forEach items="${user.TGroupCollection}" var="group" varStatus="g">
                                                            <c:if test="${g.index==0}">&nbsp;@&nbsp;</c:if>
                                                            <c:if test="${g.index>0}">&nbsp;&amp;&nbsp</c:if>
                                                            <c:out value="${group.tgDesc}"/>
                                                        </c:forEach>
                                                    </option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input id="addauser" type="button" value=">>" onclick="adduser()" disabled="true"/><br/>
                                        <input id="delauser" type="button" value="<<" onclick="deluser()" disabled="true"/>
                                    </td>
                                    <td width="40%">
                                        <select id="userids" name="userids" style="width:80%" ondblclick="deluser()" disabled="true" size="5" multiple>

                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input id="upuserfirst" style="width:100px" type="button" onclick="upUserToFirst()" disabled="true" value="<bean:message key="option.upfirst"/>" style="width:50px"/><br/>
                                        <input id="upuser" style="width:100px" type="button" onclick="moveUserUp()" disabled="true" value="<bean:message key="option.up"/>" style="width:50px"/><br/>
                                        <input id="downuser" style="width:100px" type="button" onclick="moveUserDown()" disabled="true" value="<bean:message key="option.down"/>" style="width:50px"/><br/>
                                        <input id="downuserlast" style="width:100px" type="button" onclick="downUserToLast()" disabled="true" value="<bean:message key="option.downlast"/>" style="width:50px"/><br/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><html:checkbox property="criterias" value="trId" onclick="enableRight(this)"/><bean:message key="access.illegal.criteria.cata.right"/></label>
                        </td>
                        <td>
                            <table width="100%" border="0" align="center" style="text-align:center;">
                                <!--
                                <tr>
                                    <td width="40%">&nbsp;</td>
                                    <td width="10%">&nbsp;</td>
                                    <td width="40%">&nbsp;</td>
                                    <td width="10%">&nbsp;</td>
                                </tr>
                                -->
                                <tr>
                                    <td width="40%">
                                        <select id="allrights" name="allrights" style="width:80%" ondblclick="addright()" disabled="true" size="5">
                                            <logic:notEmpty name="allrights" scope="request">
                                                <logic:iterate id="right" name="allrights" type="com.vv.auth.persist.entity.TRight" scope="request" indexId="roid">
                                                    <option value="<bean:write name="right" property="trId"/>"><bean:write name="right" property="rightName"/>-<bean:write name="right" property="rightDesc"/></option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input id="addaright" type="button" value=">>" onclick="addright()" disabled="true"/><br/>
                                        <input id="delaright" type="button" value="<<" onclick="delright()" disabled="true"/>
                                    </td>
                                    <td width="40%">
                                        <select id="rightids" name="rightids" style="width:80%" ondblclick="delright()" disabled="true" size="5" multiple>

                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input id="uprightfirst" style="width:100px" type="button" onclick="upRightToFirst()" disabled="true" value="<bean:message key="option.upfirst"/>" style="width:50px"/><br/>
                                        <input id="upright" style="width:100px" type="button" onclick="moveRightUp()" disabled="true" value="<bean:message key="option.up"/>" style="width:50px"/><br/>
                                        <input id="downright" style="width:100px" type="button" onclick="moveRightDown()" disabled="true" value="<bean:message key="option.down"/>" style="width:50px"/><br/>
                                        <input id="downrightlast" style="width:100px" type="button" onclick="downRightToLast()" disabled="true" value="<bean:message key="option.downlast"/>" style="width:50px"/><br/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                </table>
                <div class="divtopline" style="text-align:center">
                    <center>
                        <div style="width:800px;text-align:right">
                            <input type="submit" value="<bean:message key="button.chart"/>"/>
                        </div>
                    </center>
                </div>

            </center>
            <script type="text/javascript">
                //<![CDATA[
                var cal_beg  = new  Zapatec.Calendar({
                    lang             : "zh",
                    theme             : "system",
                    showOthers        : false,
                    showsTime         : true,
                    step              : 1,
                    singleClick       : true,
                    inputField        : "beg",
                    button            : "beg_ti",
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
                    inputField        : "over",
                    button            : "over_ti",
                    ifFormat          : "%Y-%m-%d %H:%M:%S",
                    daFormat          : "%Y/%m/%d"
                });
                //]]>
            </script>
        </html:form>
        <div class="divtopline"></div>
        <h4><bean:message key="access.illegal.chart.area"/></h4>

        <center>

            <iframe id="rstFrame" name="rstFrame" scrolling="no" width="810" height="610" frameborder="0"/>
            <noframes>
                <body><bean:message key="frames.not.support"/></body>
            </noframes>
        </center>


    </body>
</html:html>