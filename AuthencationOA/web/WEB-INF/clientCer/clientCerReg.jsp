<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <script>
            function changeValidateImg(){
                document.getElementById("validimg").innerHTML="<img src=\"<%=request.getContextPath()%>/validimg.do\"/>";
            }
        </script>
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="title.userReg"/></h4>
        <div class="divunderline"></div>
        <html:form action="/ClientCer/clientCerReg.do" onsubmit="return validateClientCerform(this);">

            <table width="800" align="center" style="text-align:left;vertical-align:middle;margin-top:50px">
    		<tr>
                <td width="30%"><bean:message key="label.username"/></td>
    			<td width="30%">
                        <html:text property="name"/>
                </td>
                <td width="40%"><html:errors property="name"/></td>
    		</tr>
            <tr>
                <td width="30%"><bean:message key="label.password"/></td>
    			<td width="30%">
                        <html:password property="password"/>
                </td>
                <td width="40%"><html:errors property="password"/></td>
    		</tr>
            <tr>
                <td width="30%"><bean:message key="label.confirmPassword"/></td>
    			<td width="30%">
                        <html:password property="confirmPassword"/>
                </td>
                <td width="40%"><html:errors property="confirmPassword"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.departname"/></td>
                <td><html:text property="departname"/></td>
                <td><html:errors property="departname"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.oname"/></td>
                <td><html:text property="oname"/></td>
                <td><html:errors property="oname"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.cname"/></td>
                <td><html:text property="cname"/></td>
                <td><html:errors property="cname"/></td>
    		</tr>

    		<tr>
    			<td><bean:message key="cer.pname"/></td>
                <td><html:text property="pname"/></td>
                <td><html:errors property="pname"/></td>
    		</tr>

    		<tr>
    			<td><bean:message key="cer.ctname"/></td>
                <td><html:text property="ctname"/></td>
                <td><html:errors property="ctname"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.dday"/></td>
                <td><html:text property="dday"/></td>
                <td><html:errors property="dday"/></td>
    		</tr>
            <tr>
                <td rowspan="2"><bean:message key="label.validimg"/></td>
                <td><html:text property="validcode" style="width:50%"/>
                                &nbsp;&nbsp;
                    <span id="validimg">
                        <img alt="imgCode" src="<%=request.getContextPath()%>/validimg.do"/>
                    </span>
                </td>
                <td><html:errors property="validcode"/></td>
    		</tr>
            <tr>
                <td>
                    <a href="javascript:changeValidateImg()">
                        <bean:message key="validimg.notclear"/>
                    </a>
                </td>
                <td></td>
            </tr>
    		<tr>
                <td></td>
                <td><input type="submit" name="id" value="<bean:message key="button.submit"/>"> </td>
                <td><input type="reset" value="<bean:message key="button.reset"/>"></td>
    		</tr>


    	</table>

        <div class="divunderline"></div>

        </html:form>
        <html:javascript formName="clientCerform"/>
    </body>

   </html:html>