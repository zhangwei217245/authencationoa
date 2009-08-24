<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html:html locale="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <script type="text/javascript">
            var secnum=5;
            function countDown(){
                document.getElementById("jumpTo").innerHTML=secnum;
                if(--secnum>0){
                    t=setTimeout("countDown()",1000);
                }else{
                    window.location.assign("<%=request.getContextPath()%>/Welcome.do");
                }
            }
        </script>
        <html:base/>
    </head>
    <body style="background-color: white" onload="countDown()">
        <%@ include file="/WEB-INF/util/error.jsp"%>

        <center>

            <table width="80%" align="center" style="text-align:center;vertical-align:middle;height:100%">
                <thead>
                    <tr>
                        <th style="height:30%">&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td align="center">
                        <h1><bean:message key="user.regsuccess"/></h1>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <a href="<%=request.getContextPath()%>/Welcome.do" target="_top" style="color:#ff3333;font-weight:bold;">
                            <span id="jumpTo"></span><bean:message key="user.reg.back2login"/>
                        </a>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td style="height:30%">&nbsp;</td>
                    </tr>
                </tfoot>
            </table>
</center>


        
    </body>

</html:html>