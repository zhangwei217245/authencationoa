<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <script>
            function changeValidateImg(){
                //document.getElementById("validimg").innerHTML="<img src=\"<%=request.getContextPath()%>/validimg.do\"/>";
                document.getElementById("validimgview").src="<%=request.getContextPath()%>/validimg.do?"+Math.random();
            }
        </script>
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <html:form action="/execRegister" onsubmit="return validateUserRegister(this);">
            <center>
            <table width="800" align="center" style="text-align:center;vertical-align:middle;margin-top:100px">
                <tr>
                    <td align="center" width="80%">
                        <h3 align="center">AuthencationOA</h3>
                        <p align="center"><bean:message key="label.register"/></p>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <table align="center" width="80%">
                            <tr>
                                <td width="20%"><bean:message key="label.email"/></td>
                                <td width="40%"><html:text property="email" style="width:100%"/></td>
                                <td width="40%"><html:errors property="email"/>
                                </td>
                            </tr>
                            <tr>
                                <td><bean:message key="label.password"/></td>
                                <td><html:password property="password" style="width:100%"/></td>
                                <td width="40%"><html:errors property="password"/>
                                </td>
                            </tr>
                            <tr>
                                <td><bean:message key="label.validimg"/></td>
                                <td><html:text property="validcode" style="width:50%"/>
                                &nbsp;&nbsp;<span id="validimg">
                                    <img alt="imgCode" src="<%=request.getContextPath()%>/validimg.do"/>
                                </span></td>
                                <td width="40%">
                                    <html:errors property="validcode"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3"><a href="javascript:changeValidateImg()">
                                    <bean:message key="validimg.notclear"/>
                                </a></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center"><input type="submit" value="<bean:message key="button.login"/>">&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="<%=request.getContextPath()%>/initRegister.do"><bean:message key="a.register"/></a>
                                    &nbsp;
                                    &nbsp;
<!--                                    <a href="javascript:"><bean:message key="label.getpwd"/></a>-->
                                    </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            </center>


        </html:form>
        <html:javascript formName="userRegister"/>
    </body>
       
   </html:html>