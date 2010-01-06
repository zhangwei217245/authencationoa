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
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="access.illegal"/></h4>
        <div class="divunderline"></div>
        <html:form action="/IllegalAccess/illegalAccessShow.do" method="post" target="rstFrame">
            <center>
                <table width="800" border="0" align="center" style="text-align:center;vertical-align:middle">
                    <tr>
                        <td width="10%" style="text-align:left;">
                            <bean:message key="access.illegal.criteria.cata"/>
                        </td>
                        <td width="90%">&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            <label><html:checkbox property="criterias" value="userid"/><bean:message key="access.illegal.criteria.cata.user"/></label>
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
                                        <select id="allusers" name="allusers" style="width:80%" ondblclick="adduser()" size="5">
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
                                        <input type="button" value=">>" onclick="adduser()"/><br/>
                                        <input type="button" value="<<" onclick="deluser()"/>
                                    </td>
                                    <td width="40%">
                                        <select id="userids" name="userids" style="width:80%" ondblclick="deluser()" size="5" multiple>

                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input style="width:100px" type="button" onclick="upUserToFirst()" value="<bean:message key="option.upfirst"/>" style="width:50px"/><br/>
                                        <input style="width:100px" type="button" onclick="moveUserUp()" value="<bean:message key="option.up"/>" style="width:50px"/><br/>
                                        <input style="width:100px" type="button" onclick="moveUserDown()" value="<bean:message key="option.down"/>" style="width:50px"/><br/>
                                        <input style="width:100px" type="button" onclick="downUserToLast()" value="<bean:message key="option.downlast"/>" style="width:50px"/><br/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><html:checkbox property="criterias" value="trId"/><bean:message key="access.illegal.criteria.cata.right"/></label>
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
                                        <select id="allrights" name="allrights" style="width:80%" ondblclick="addright()" size="5">
                                            <logic:notEmpty name="allrights" scope="request">
                                                <logic:iterate id="right" name="allrights" type="com.vv.auth.persist.entity.TRight" scope="request" indexId="roid">
                                                    <option value="<bean:write name="right" property="trId"/>"><bean:write name="right" property="rightName"/>-<bean:write name="right" property="rightDesc"/></option>
                                                </logic:iterate>
                                            </logic:notEmpty>
                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input type="button" value=">>" onclick="addright()"/><br/>
                                        <input type="button" value="<<" onclick="delright()"/>
                                    </td>
                                    <td width="40%">
                                        <select id="rightids" name="rightids" style="width:80%" ondblclick="delright()" size="5" multiple>

                                        </select>
                                    </td>
                                    <td width="10%">
                                        <input style="width:100px" type="button" onclick="upRightToFirst()" value="<bean:message key="option.upfirst"/>" style="width:50px"/><br/>
                                        <input style="width:100px" type="button" onclick="moveRightUp()" value="<bean:message key="option.up"/>" style="width:50px"/><br/>
                                        <input style="width:100px" type="button" onclick="moveRightDown()" value="<bean:message key="option.down"/>" style="width:50px"/><br/>
                                        <input style="width:100px" type="button" onclick="downRightToLast()" value="<bean:message key="option.downlast"/>" style="width:50px"/><br/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
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
                        <td>&nbsp;</td>
                        <td style="text-align:right;"><input type="submit" value="<bean:message key="button.chart"/>"/></td>
                    </tr>
                </table>
            </center>
        </html:form>
        <script type="text/javascript">//<![CDATA[
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
            //]]></script>

    </body>
</html:html>