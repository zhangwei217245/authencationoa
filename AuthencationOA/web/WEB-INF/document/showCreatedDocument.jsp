<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="document.created"/></title>
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
                    <%@ include file="/WEB-INF/util/error.jsp"%>
                    <h4><bean:message key="document.created"/></h4>
                    <div class="divunderline"></div>
              <html:form action="/Document/showCreatedDocument.do" method="post">

                   <table width="90%" align="center" style="text-align:left;vertical-align:middle">
                       <tr>
                           <td><bean:message key="document.title"/></td>
                           <td><html:text property="vc2titlefq" style="width:170px"/></td>
                           <td><bean:message key="document.content" /></td>
                           <td><html:text property="vc2contentfq" style="width:170px"/></td>
                           <td><bean:message key="review.datetime.beg" /></td>
                           <td>
                               <html:text property="datbeginfq" style="width:150px" readonly="true" ondblclick="chanageTime('datbeginfq');"/>
                            <input type = "text"  id="datbeginfq_ch" style="border:1px solid #e2e2e2;width:160px;display:none" onBlur="backToInput('datbeginfq');" />
                            <IMG id="datbeginfq_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand" onClick="showCalendar('datbeginfq');" />
                            </td>
                           <td><bean:message key="review.datetime.over" /></td>
                           <td>
                            <html:text property="datendfq" style="width:150px" readonly="true" ondblclick="chanageTime('datendfq');"/>
                            <input type = "text"  id="datendfq_ch" style="border:1px solid #e2e2e2;width:160px;display:none" onBlur="backToInput('datendfq');" />
                            <IMG id="datendfq_ti" SRC="<%=request.getContextPath()%>/js/calendar/themes/calendar.gif" border="0" STYLE="cursor: hand" onClick="showCalendar('datendfq');" />
                            </td>
                       </tr>
                       <tr>
                           <td><bean:message key="document.type"/></td>
                           <td>
                               <html:select property="numtypeidfq">
                                   <html:optionsCollection name="doctypeList"/>
                               </html:select>
                           </td>
                           <td><bean:message key="document.department.result"/></td>
                           <td>
                               <html:select property="vc2resultfq">
                                   <html:optionsCollection name="resultList"/>
                               </html:select>
                           </td>
                           <td><bean:message key="document.status"/></td>
                           <td>
                               <html:select property="vc2usefq">
                                   <html:optionsCollection name="statusList"/>
                               </html:select>
                           </td>
                           <td colspan="2"><input type="submit" value="<bean:message key="button.find"/>"/></td>
                       </tr>
                   </table>

                   <div class="divtopline">${requestScope.pagination}</div>
                       <center>
                  <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                    <thead>
                      <tr>
                          <th width="12%">&nbsp;</th>
                          <th width="20%" ><bean:message key="document.title"/></th>
                          <th width="12%" ><bean:message key="document.type" /></th>
                          <th width="12%" ><bean:message key="document.createtime" /></th>
                          <th width="12%" ><bean:message key="document.department.result"/></th>
                          <th width="12%" ><bean:message key="document.status"/></th>
                          <th width="20%" ><bean:message key="label.operation"/></th>
                      </tr>
                      </thead>

                      <logic:notEmpty name="mydocs">
                          <tbody>
                              <logic:iterate id="doc" name="mydocs" indexId="idx">
                              <tr>
                                  <td>${idx+1}</td>
                              <td><bean:write name="doc" property="vc2title"/></td>
                              <td>${doc.numtypeid.vc2name}</td>
                              <td><bean:write name="doc" property="datcreatetime" format="yyyy-MM-dd HH:mm:ss"/></td>
                              <td>
                                  <bean:message key="document.department.result.${doc.vc2result}"/>
                              </td>
                              <td>
                                  <bean:message key="document.status.${doc.vc2use}"/>
                              </td>
                              <td>
                                  
                              </td>
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
            inputField        : "datbeginfq",
            button            : "datbeginfq_ti",
            ifFormat          : "%Y-%m-%d %H:%M:%S",
            daFormat          : "%Y-%m-%d %H:%M:%S"
        });
        Zapatec.Calendar.setup({
            firstDay          : 1,
            electric          : true,
            inputField        : "datendfq",
            button            : "datendfq_ti",
            ifFormat          : "%Y-%m-%d %H:%M:%S",
            daFormat          : "%Y-%m-%d %H:%M:%S"
        });
        </script>
    </body>
</html:html>