<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>权限不足</title>
    </head>
    <body>
        <center>
    <h1>权限不足</h1>
    <table align="center" width="100%" height="100%">
        <tr>
            <td width="100%" height="100%">
                <!--<div style="font-weight:bolder;width:100%;height:100%">系统将于<span id="counter">5</span>秒钟后跳转登录前页面。</div>-->
                没有权限，点击<a href="https://<%=request.getLocalName()%>:8443<%=request.getContextPath()%>/">此处</a>，并使用证书登录
            </td>
        </tr>
    </table>
    </center>
    
<script>
//var i = 5;
//function cou(){
//	if(i >= 0){
//        document.getElementById("counter").innerHTML = i;
//		i--;
//		setTimeout("cou()",1000);
//	}else{
//		window.location.assign("<%=request.getContextPath()%>/reset.do");
//	}
//}
//setTimeout("cou()",1000);
</script>
    </body>
</html>
