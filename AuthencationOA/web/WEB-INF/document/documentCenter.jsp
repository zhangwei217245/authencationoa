<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<html:html locale="true">
<%@ include file="/WEB-INF/util/title.jsp"%>
<head>
    <title><bean:message key="document.center"/></title>
<script language="javascript">
    //window.frames['tree'].setValue('', '92');
    //window.frames['tree'].fnOutPrint();
</script>

</head>
<body style="overflow:auto">
<html:form action="/Document/documentCenter.do">
<div id="main">
	<h4><bean:message key="document.center"/></h4>

	<div id="content">
		<table width="100%" border="0" height="75%" cellpadding="0" cellspacing="0" class="formtable">
			<tr>
				<td width="20%">&nbsp;&nbsp;
					
                                    <iframe style="border:none" name="tree" align="left" width="100%" height="100%" src="<%=request.getContextPath()%>/documentTree.do" frameborder="1" scrolling="auto">
					</iframe>
				</td>
				<td width="80%">
					<iframe style="border:none" name="site" align="left" width="99%" height="100%" src="<%=request.getContextPath()%>/Document/showCreatedDocument.do" frameborder="2" scrolling="auto"></iframe>
				</td>
			</tr>
		</table>
  </div>
 </div>
 </html:form>
</body>
</html:html>