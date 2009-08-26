<%@ page import="java.util.*,com.vv.auth.struts.util.Utility;"%>
<div id="header" style="font-size:9pt;font-weight:bolder">
	<div id="head"> <img src="<%=request.getContextPath()%>/images/CustomIcon.png" width="128" height="128" alt="banner"/>
    	<div class="login">
	<%
	Map userMap = null;
	if(request.getSession() != null && request.getSession().getAttribute("USERMAP") != null){
		userMap = (Map)request.getSession(false).getAttribute("USERMAP");
	}
	if(userMap != null && userMap.get("userid") != null){
	%>
			<div class="login_txt" style="text-align:right">

                <bean:message key="label.username"/>
                <span id="title_greeting"></span>
                <%=userMap.get("name") + ""%>&nbsp;@&nbsp;<%=userMap.get("atGroup")+""%>|
<script>
    now = new Date(),hour = now.getHours()
    if(hour < 6){title_greeting.innerText="<bean:message key="label.greeting.bfmorning"/>"}
    else if (hour < 9){title_greeting.innerText="<bean:message key="label.greeting.morning"/>"}
    else if (hour < 12){title_greeting.innerText="<bean:message key="label.greeting.bfnoon"/>"}
    else if (hour < 14){title_greeting.innerText="<bean:message key="label.greeting.noon"/>"}
    else if (hour < 17){title_greeting.innerText="<bean:message key="label.greeting.afternoon"/>"}
    else if (hour < 19){title_greeting.innerText="<bean:message key="label.greeting.dawn"/>"}
    else if (hour < 22){title_greeting.innerText="<bean:message key="label.greeting.evening"/>"}
    else {title_greeting.innerText="<bean:message key="label.greeting.midnight"/>"}
</script>
<!--				<a href="<%=request.getContextPath()%>/mana/user/view.do?userid=<%= userMap.get("userid")+"" %>&viewer=self"></a> |-->
<a href="<%=request.getContextPath()%>/ClientCer/initDownloadCer.do?userid=<%= userMap.get("userid")+"" %>"><bean:message key="label.user.info"/></a>|
<a href="<%=request.getContextPath()%>/<%=request.getScheme().equalsIgnoreCase("https")?"secureset":"reset"%>.do"><bean:message key="label.reset"/></a>
			</div>

	<%}%>    
		</div>
  	</div>
  	
	<%if(userMap != null){%>	
        <div style="font-size:10pt;font-weight:bolder;background-color:#cccccc">
		<%=Utility.getUserMenu(request)%>
        </div>
	<%}%>
    </div>
    <div style="height:50px">

    </div>