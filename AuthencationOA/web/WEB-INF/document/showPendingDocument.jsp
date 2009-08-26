<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<%@page import="com.vv.auth.persist.entity.Document" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="document.pending"/></title>
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
                .lockbyother{
                    color:#cc0000;
                    font-weight:bolder;
                }
                .lockbyme{
                    color:#007c00;
                    font-weight:bolder;
                }
            </style>
            <html:base/>
        </head>
             <body style="background-color: white">
                    <%@ include file="/WEB-INF/util/error.jsp"%>
                    <h4><bean:message key="document.pending"/></h4>
                    <div class="divunderline"></div>
              <html:form action="/Document/showPendingDocument.do" method="post">

                    <table class="formtable" width="90%" align="center" style="text-align:left;vertical-align:middle">
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
                            <td><bean:message key="document.type"/></td>
                            <td>
                               <html:select property="numtypeidfq">
                                   <html:optionsCollection name="doctypeList"/>
                               </html:select>
                            </td>
                       </tr>
                       <tr>
                           
                           
                           <td colspan="10" style="text-align:right"><input type="submit" value="<bean:message key="button.find"/>"/></td>
                       </tr>
                   </table>
                   </html:form>
               <html:form action="/Document/batchAuditDocument.do" method="post">
                   <div class="divtopline">${requestScope.pagination}</div>
                       <center>
                  <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                    <thead>
                      <tr>
                          <th width="6%">&nbsp;</th>
                          <th width="20%" ><bean:message key="document.title"/></th>
                          <th width="12%" ><bean:message key="document.type" /></th>
                          <th width="12%" ><bean:message key="document.createtime" /></th>
                          <th width="6%" ><bean:message key="document.department.result"/></th>
                          <th width="8%" ><bean:message key="document.status"/></th>
                          <th width="16%" ><bean:message key="document.lock"/></th>
                          <th width="20%" ><bean:message key="label.operation"/></th>
                      </tr>
                      </thead>

                      <logic:notEmpty name="rstlst">
                          <tbody>
                              <logic:iterate id="doc" name="rstlst" indexId="idx">
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
                                  <logic:equal value="N" name="doc" property="vc2lock">
                                      <bean:message key="document.lock.${doc.vc2lock}"/>
                                  </logic:equal>
                                  <logic:equal value="Y" name="doc" property="vc2lock">
                                      <logic:equal name="doc" property="lockuserid" value="${requestScope.myuid}">
                                          <span class="lockbyme">
                                      </logic:equal>
                                      <logic:notEqual name="doc" property="lockuserid" value="${requestScope.myuid}">
                                          <span class="lockbyother">
                                      </logic:notEqual>
                                          <%=Utility.getLockUserName(request.getSession().getServletContext(),((Document)doc).getLockuserid())%>
                                      </span>
                                  </logic:equal>
                              </td>
                              <td>
                                      <logic:equal name="doc" property="vc2lock" value="N">
                                        <a href="<%=request.getContextPath()%>/Document/viewDocDetail.do?numdocid=<bean:write name="doc" property="numdocid"/>&entertype=pending"><bean:message key="label.document.verify"/></a>
                                      </logic:equal>
                                      <logic:equal name="doc" property="vc2lock" value="Y">
                                          <logic:equal name="doc" property="lockuserid" value="${requestScope.myuid}">
                                              <a href="<%=request.getContextPath()%>/Document/viewDocDetail.do?numdocid=<bean:write name="doc" property="numdocid"/>&entertype=pending"><bean:message key="label.document.verify"/></a>
                                          </logic:equal>
                                          <logic:notEqual name="doc" property="lockuserid" value="${requestScope.myuid}">
                                              <span style="text-decoration:underline;color:gray"><bean:message key="label.document.verify"/></span>
                                          </logic:notEqual>
                                      </logic:equal>

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