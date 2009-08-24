<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html locale="true">
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="title.serverCerReg"/></h4>
        <div class="divunderline"></div>
        <html:form action="/ServerCer/serverCerReg.do" onsubmit="return validateServerCerform(this);">
            <center>
            <table width="800" align="center" style="text-align:left;vertical-align:middle">
    		<tr>
                <td width="30%"><bean:message key="cer.name"/></td>
    			<td width="30%">
                        <html:text property="name"/>
                </td>
                <td width="40%"><html:errors property="name"/></td>
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
    			<td><bean:message key="cer.ctfname"/></td>
                <td><html:text property="ctfname"/></td>
                <td><html:errors property="ctfname"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.albyte"/></td>
    			<td>
                    <html:select property="albyte">
                        <html:option value="" key="label.please"/>
                        <html:option value="512">512</html:option>
                        <html:option value="1024">1024</html:option>
                    </html:select>
                    
                </td>
                <td>
                    <html:errors property="albyte"/>
                </td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.cpass"/></td>
                <td><html:text property="cpass"/></td>
                <td><html:errors property="cpass"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.ppass"/></td>
                <td><html:text property="ppass"/></td>
                <td><html:errors property="ppass"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.location"/></td>
                <td><html:text property="location" readonly="true"/></td>
                <!--<td><html:text property="location" value="d:\tomcat.keystore" readonly="true"/></td>-->
                <td><html:errors property="location"/></td>
    		</tr>

    		<tr>
                <td><bean:message key="cer.dday"/></td>
                <td><html:text property="dday"/></td>
                <td><html:errors property="dday"/></td>
    		</tr>

    		<tr>
                <td></td>
                <td><input type="submit" name="id" value="<bean:message key="button.submit"/>"> </td>
                <td><input type="reset" value="<bean:message key="button.reset"/>"></td>
    		</tr>


    	</table>
        </center>
        <div class="divunderline"></div>

        </html:form>
        <html:javascript formName="serverCerform"/>
    </body>

   </html:html>