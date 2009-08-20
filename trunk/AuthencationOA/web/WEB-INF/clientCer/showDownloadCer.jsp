<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html:html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <style>
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
        <script>
            function downloadCer(userid){
                var baseurl="<%=request.getContextPath()%>/ClientCer/DownloadCer.do";
                var fileurl=baseurl+"?userid="+userid;
                document.frames[0].location.href=fileurl;
            }
        </script>
        <html:base/>
    </head>
    <body style="background-color: white">
        <%@ include file="/WEB-INF/util/title.jsp"%>
        <%@ include file="/WEB-INF/util/error.jsp"%>

        <h4><bean:message key="title.showuserinfo"/></h4>
<div class="divunderline"></div>
        <table id="datatable" width="85%" align="center" cellpadding="0" cellspacing="0">
                <thead>
                    <tr>
                        <th><bean:message key="cer.name"/></th>
                        <th><bean:message key="cer.departname"/></th>
                        <th><bean:message key="cer.oname"/></th>
                        <th><bean:message key="cer.cname"/></th>
                        <th><bean:message key="cer.pname"/></th>
                        <th><bean:message key="cer.ctname"/></th>
                        <th><bean:message key="cer.dday"/></th>
                        <th><bean:message key="cer.ddaybeg"/></th>
                        <th><bean:message key="cer.ddayover"/></th>
                        <logic:equal value="Y" name="curruser" property="verifystatus">
                            <th><bean:message key="cer.verifystatus"/></th>
                        </logic:equal>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><bean:write name="curruser" property="name"/></td>
                            <td><bean:write name="curruser" property="departname"/></td>
                            <td><bean:write name="curruser" property="oname"/></td>
                            <td><bean:write name="curruser" property="cname"/></td>
                            <td><bean:write name="curruser" property="pname"/></td>
                            <td><bean:write name="curruser" property="ctname"/></td>
                            <td><bean:write name="curruser" property="dday"/></td>
                            <td><bean:write name="curruser" property="ddaybeg" format="yyyy-MM-dd"/></td>
                            <td><bean:write name="curruser" property="ddayover" format="yyyy-MM-dd"/></td>
                            <logic:equal value="Y" name="curruser" property="verifystatus">
                                <td>
                                    <a href="javascript:downloadCer(<bean:write name="curruser" property="userid"/>)"><bean:message key="label.cer.download"/></a>
                                </td>
                            </logic:equal>
                        </tr>
                </tbody>
            </table>

            <iframe id="downloadFrame" width="1" height="1" style="width:1px;height:1px;" src="about:blank"></iframe>
    </body>

   </html:html>