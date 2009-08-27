<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*,com.vv.auth.struts.util.Utility,com.vv.auth.struts.platform.base.*"%>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/func.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/dtree.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/utility.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/util/calendar/calendar.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/nav.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/date.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/style.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/drag.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/func2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/selectSortUtil_1.jsp"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/SortTable.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/copytoclipboard.jsp"></script>

<!--<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/calendar/utils.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/calendar/calendar.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/calendar/calendar-setup.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/calendar/calendar-zh.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/calendar/themes/aqua.css" />-->
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/Zapatec/zapatec.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/Zapatec/zpdate.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/Zapatec/zpdict.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/Zapatec/calendar.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/js/Zapatec/calendar-zh.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/Zapatec/themes/system.css" />
<a href="http://www.zapatec.com/" style="display:none">a</a>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%> 
<% if(request.getAttribute(BaseContect.FORWARD_SUCCESS) != null) {%>
	<script language="JavaScript" type="text/javascript">
		alert('<%=request.getAttribute(BaseContect.FORWARD_SUCCESS)%>');
	</script>
<%
	}
	//request.removeAttribute(BaseContect.FORWARD_SUCCESS);

%>
<%

	if(request.getAttribute("login") != null){

	%>
<script languge="JavaScript">
	if(window.parent != null){
		window.parent.location = "<%=request.getContextPath()%>/reset.do";
	}else{
		window.location = "<%=request.getContextPath()%>/reset.do";
	}
</script>
<%}%> 