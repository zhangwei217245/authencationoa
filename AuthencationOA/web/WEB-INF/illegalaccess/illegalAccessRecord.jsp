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
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <html:form action="/IllegalAccess/illegalAccessShowDetail.do">
            <input type="hidden" name="username" value="${param.username}"/>
            <input type="hidden" name="rightname" value="${param.rightname}"/>
            <input type="hidden" name="datbeg" value="${param.datbeg}"/>
            <input type="hidden" name="datover" value="${param.datover}"/>

            <div class="divtopline">${requestScope.pagination}</div>
                       <center>
                  <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                    <thead>
                      <tr>
                          <th width="10%">&nbsp;</th>
                          <th width="30%" ><bean:message key="access.illegal.criteria.cata.user"/></th>
                          <th width="30%" ><bean:message key="access.illegal.criteria.cata.right" /></th>
                          <th width="30%" ><bean:message key="review.datetime" /></th>
                      </tr>
                      </thead>

                      <logic:notEmpty name="rstlst">
                          <tbody>
                              <logic:iterate id="rst" name="rstlst" indexId="idx">
                              <tr>
                                  <td>${idx+1}</td>
                              <td>
                                  <c:if scope="request" test="${empty rst.userid}" var="rst">
                                      <bean:message key="user.noname"/>
                                  </c:if>
                                  ${rst.userid.name}
                                  <c:forEach items="${rst.userid.TGroupCollection}" var="group" varStatus="g">
                                        <c:if test="${g.index==0}">&nbsp;@&nbsp;</c:if>
                                        <c:if test="${g.index>0}">&nbsp;&amp;&nbsp</c:if>
                                        <c:out value="${group.tgDesc}"/>
                                    </c:forEach>
                              </td>
                              <td>${rst.trId.rightName}-${rst.trId.rightDesc}</td>
                              <td><bean:write name="rst" property="dataccesstime" format="yyyy-MM-dd HH:mm:ss"/></td>
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
    </body>
</html:html>