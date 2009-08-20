<%@ page import="java.util.*"%>
<html>
<head>
	<%@ include file="/WEB-INF/util/includeTitle.jsp"%>
	<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/dtree.js"></script>
</head>
<script language="javascript">
 var selnodeid;//the id of the Selected Node
function setValue(cn,nodeid)
{
	//parent.document.all.siteId.value = cn.id;
	//parentNode = getParentnode(cn);
        selnodeid=nodeid;
}
var d = new dTree('d');
d.add('90','-1','<bean:message key="document.center"/>','','<bean:message key="document.center"/>','','','','','<bean:message key="document.center"/>','<bean:message key="document.center"/>','');
d.add('91','90','<bean:message key="document.create"/>','<%=request.getContextPath()%>/Document/createDocument.do','<bean:message key="document.create"/>','site','images/folder.gif','','','<bean:message key="document.create"/>','N','');
d.add('92','90','<bean:message key="document.created"/>','<%=request.getContextPath()%>/Document/showCreatedDocument.do','<bean:message key="document.created"/>','site','images/folder.gif','','','<bean:message key="document.created"/>','N','');
d.add('93','90','<bean:message key="document.pending"/>','<%=request.getContextPath()%>/Document/showPendingDocument.do','<bean:message key="document.pending"/>','site','images/folder.gif','','','<bean:message key="document.pending"/>','N','');
d.add('94','90','<bean:message key="document.audited"/>','<%=request.getContextPath()%>/Document/showAuditedDocument.do','<bean:message key="document.audited"/>','site','images/folder.gif','','','<bean:message key="document.audited"/>','N','');




function fnSearchTreeNode(lstrParam,level,displayname){
    fnOutPrint();
    /*var clevel=getChildLevel(level);
	//alert('parentId:'+displayname+"  itemId:"+lstrParam + "level:"+clevel);
	if(level == 'N'){
		parent.document.forms[0].btnadd.style.display = "none";
		parent.document.forms[0].btndel.style.display = "none";
	}else if(level=='P'){
		parent.document.forms[0].btnadd.style.display = "";
		parent.document.forms[0].btndel.style.display = "none";
	}else if(level=='B'){
        parent.document.forms[0].btnadd.style.display = "none";
		parent.document.forms[0].btndel.style.display = "";
    }else{
        parent.document.forms[0].btnadd.style.display = "";
		parent.document.forms[0].btndel.style.display = "";
    }
        //alert((lstrParam+'').substring(1))
	parent.document.forms[0].areaid.value = (lstrParam+'').substring(1);
	parent.document.forms[0].arealevel.value = level;
	parent.document.forms[0].areaname.value = displayname;
	if(lstrParam!=''){
		var param = "itemId="+(lstrParam+'').substring(1)+"&level="+clevel;
		var urlStr = "<%=request.getContextPath()%>/mana/livemanager/area/searchareanode.do";
        //alert(urlStr+"&"+param)
		//alert(urlStr)
		var myAjax = new Ajax.Request(urlStr,{method: 'post', parameters:param, onComplete: fnResultSearchTree});
        if(level!='P'||level!='C'){
    		parent.document.frames['site'].Loading.show();
        }

	}*/
}
function fnResultSearchTree(xmlRequest){
    /*var restxt=xmlRequest.responseText;
	var lstXml = createXml(restxt);
	var items = lstXml.documentElement.getElementsByTagName("TreeNode");
	if(items!=null){
		for(var i=0;i<items.length;i++){
			var node = items[i];
			var strname = unescape(node.getElementsByTagName("name").item(0).firstChild.nodeValue);
			var numclientId = node.getElementsByTagName("currId").item(0).firstChild.nodeValue;
			var numparentId = node.getElementsByTagName("parentId").item(0).firstChild.nodeValue;
			var strdisplay = node.getElementsByTagName("display").item(0).firstChild.nodeValue;
			var vc2status = node.getElementsByTagName("vc2status").item(0).firstChild.nodeValue;
			var urls = "<%=request.getContextPath()%>/mana/livemanager/area/nodeinfoinit.do?operate=view&areaid="+numclientId+"&arealevel="+strdisplay;
			var icon = 'images/imgfolder.gif';
			var icon2 = 'images/folderopen.gif';
            if(strdisplay=='B'){
                var icon2='';
            }
			if(vc2status == 'N'){
				icon = 'images/delsite.gif';
				icon2 = 'images/delsite.gif';
			}
			d.add('9'+numclientId,'9'+numparentId,strname,urls,strname,'site',icon,icon2,'',strname,strdisplay,'');
		}
		fnOutPrint();
	}*/
}
function getChildLevel(plevel){
    if(plevel=='N'){
        return "P";
    }else if(plevel=='P'){
        return "C";
    }else if(plevel=='C'){
        return "D";
    }else if(plevel=='D'){
        return "B";
    }else{
        return "N";
    }
}
function fnOutPrint(){
	$('tempTee').innerHTML = d.toWrite();
        setSelNode(selnodeid);//Set the selected node id.
}
addOnload(fnOutPrint);
</script>
<body>
	<html:form action="/documentTree.do">
        <div id = "tempTee"></div>
	</html:form>
</body>
</body>
</html>