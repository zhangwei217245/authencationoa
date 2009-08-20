<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="document.create"/></title>
            <html:base/>
        </head>
     <body style="background-color: white">
        <%@ include file="/WEB-INF/util/error.jsp"%>
        <h4><bean:message key="document.create"/></h4>
        
        <html:form action="/Document/saveDocument.do" onsubmit="" method="post" enctype="multipart/form-data">
                <table align="center" border="0" class="formtable" style="height:70%;margin-right:250px">
                    <tr>
                        <td><bean:message key="document.type"/><span class="required">*</span></td>
                        <td>
                            <html:select property="numtypeid">
                                <html:option value="" key="label.please"/>
                                <html:optionsCollection name="typelist"/>
                            </html:select>
                        </td>
                        <td><html:errors property="numtypeid"/></td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.title"/><span class="required">*</span></td>
                        <td><html:text property="vc2title" style="width:400px"/></td>
                        <td><html:errors property="vc2title"/></td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.content"/><span class="required">*</span></td>
                        <td><html:textarea property="vc2content" style="height:400px;width:400px"/></td>
                        <td><html:errors property="vc2content"/></td>
                    </tr>
                    <tr>
                        <td><bean:message key="document.addition"/><span class="not_required">*</span></td>
                        <td><html:file property="vc2addition" style="width:400px;"/></td>
                        <td><html:errors property="vc2addition"/></td>
                    </tr>
                    <tr>
                        <td colspan="3" style="text-align:center">
                            <input type="submit" value="<bean:message key="button.submit"/>">
                            <input type="button" value="<bean:message key="button.cancel"/>">
                        </td>
                    </tr>

                </table>
        </html:form>
    </body>
</html:html>