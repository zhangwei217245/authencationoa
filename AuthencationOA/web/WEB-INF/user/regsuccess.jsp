<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html:html locale="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <script>
            function countDown(secs,surl){
                document.getElementById("jumpTo").innerText=secs;
                if(--secs>0){
                    setTimeout("countDown("+secs+",'"+surl+"')",1000);
                }else{
                    location.href=surl;
                }
            }
        </script>
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/error.jsp"%>

        

            <table width="800" align="center" style="text-align:left;vertical-align:middle;margin-top:50px">
                <thead>
                    <tr>
                        <th align="center">
                            <h1><bean:message key="user.regsuccess"/></h1>
                        </th>
                    </tr>
                </thead>
                <tr>
                    <td align="center">
                        <a href="<%=request.getContextPath()%>/Welcome.do" target="_top" style="color:#ff3333;font-weight:bold;">
                            <span id="jumpTo"></span><bean:message key="user.reg.back2login"/>
                        </a>
                    </td>
                </tr>
            </table>



        
    </body>
<script>
    countDown(5,'<%=request.getContextPath()%>/Welcome.do')
</script>
</html:html>