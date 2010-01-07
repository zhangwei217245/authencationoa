<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html:html locale="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="access.illegal"/></title>
        <style type="text/css">
            #datatable{
                text-align:center;
                vertical-align:middle;
                border:1px solid black;
            }
            #datatable thead tr th{
                border:1px solid silver;
                font-weight:bolder;
            }
            #datatable tbody tr td{
                border:1px solid silver;
            }
        </style>
        
        <html:base/>
    </head>
    <body style="background-color: white">
        
        <%@ include file="/WEB-INF/util/error.jsp"%>
        


    </body>
</html:html>