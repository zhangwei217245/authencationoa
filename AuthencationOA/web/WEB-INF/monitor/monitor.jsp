<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="review.syslog"/></title>
            <style>
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
                    <h4><bean:message key="review.syslog"/></h4>
                    <div class="divunderline"></div>
              <html:form action="/Monitor/monitorShow.do" method="post">
                  
                   <table width="800" align="center" style="text-align:left;vertical-align:middle">
                       <tr>
                           <td><bean:message key="review.username"/></td>
                           <td><html:text property="name" style="width:170px"/></td>
                           <td><bean:message key="review.path" /></td>
                           <td><html:text property="vc2path" style="width:170px"/></td>
                           <td><bean:message key="review.parameter"/></td>
                           <td><html:text property="vc2parameter" style="width:170px"/></td>
                       </tr>
                       <tr>
                           <td><bean:message key="review.datetime.beg" /></td>
                           <td>
                               <html:text property="beg" style="width:150px" readonly="true" ondblclick="chanageTime('beg');"/>
                            <input type = "text"  id="beg_ch" style="border:1px solid #e2e2e2;width:160px;display:none" onBlur="backToInput('beg');" />
                            <IMG id="beg_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand" onClick="showCalendar('beg');" />
                            </td>
                           <td><bean:message key="review.datetime.over" /></td>
                           <td>
                            <html:text property="over" style="width:150px" readonly="true" ondblclick="chanageTime('over');"/>
                            <input type = "text"  id="over_ch" style="border:1px solid #e2e2e2;width:160px;display:none" onBlur="backToInput('over');" />
                            <IMG id="over_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand" onClick="showCalendar('over');" />
                            </td>
                           <td colspan="2"><input type="submit" value="<bean:message key="button.find"/>"/></td>
                       </tr>
                   </table>
                  
                   <div class="divtopline">${requestScope.pagination}</div>
                       <center>
                  <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                    <thead>
                      <tr>
                          <th width="10%">&nbsp;</th>
                          <th width="15%" ><bean:message key="review.username"/></th>
                          <th width="15%" ><bean:message key="review.datetime" /></th>
                          <th width="20%" ><bean:message key="review.path" /></th>
                          <th width="20%" ><bean:message key="review.parameter"/></th>
                          <th width="20%" ><bean:message key="review.exception"/></th>
                      </tr>
                      </thead>

                      <logic:notEmpty name="monitorList">
                          <tbody>
                              <logic:iterate id="monitor" name="monitorList" indexId="idx">
                              <tr>
                                  <td>${idx+1}</td>
                              <td><bean:write name="monitor" property="name"/></td>
                              <td><bean:write name="monitor" property="dattime" format="yyyy-MM-dd HH:mm:ss"/></td>
                              <td><bean:write name="monitor" property="vc2path"/></td>
                              <td height="40"><div style="height:40px;overflow:auto">&nbsp;<bean:write name="monitor" property="vc2parameter"/></div></td>
                              <td height="40"><div style="height:40px;overflow:auto">&nbsp;<bean:write name="monitor" property="vc2exception"/></div></td>
                              </tr>
                          </logic:iterate>
                          </tbody>
                      </logic:notEmpty>
                  </table>
                  </center>
                  <div class="divtopline">
                      ${requestScope.pagination}
                  </div>
              </html:form>
       <script type="text/javascript">

        Zapatec.Calendar.setup({
            firstDay          : 1,
            electric          : true,
            inputField        : "beg",
            button            : "beg_ti",
            ifFormat          : "%Y-%m-%d",
            daFormat          : "%Y-%m-%d"
        });
        Zapatec.Calendar.setup({
            firstDay          : 1,
            electric          : true,
            inputField        : "over",
            button            : "over_ti",
            ifFormat          : "%Y-%m-%d",
            daFormat          : "%Y-%m-%d"
        });
        </script>
    </body>
</html:html>