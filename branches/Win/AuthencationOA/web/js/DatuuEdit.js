var datuuEditor;
var editer;
var _transer ;
var _default_src = "about:blank";
var hex = ["FF","CC","99","66","33","00"];
var _faces = ["a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t","u","v","w","x","z"];
function DatuuEdit(containerName){
	this.height = "200px";
	this.width = "100%";
	this.setSrc = function(src){
		_default_src = src;
	}
	this.write = function(){
		document.write("<table style='margin-top:10px;margin-bottom:5px;width:100%;'>");
		document.write("<tr>");
		document.write("<td style='position:relative '><img class='edit_btn' src='"+_cp+"images/editer/bb_separator.gif'/>");
		document.write("<img  class='edit_btn' title='加粗' src='"+_cp+"images/editer/bb_bold.gif' onclick='editer.set(\"bold\");'/>");
		document.write("<img  class='edit_btn' title='斜体' src='"+_cp+"images/editer/bb_italic.gif' onclick='editer.set(\"Italic\");'/>");
		document.write("<img  class='edit_btn' title='下划线' src='"+_cp+"images/editer/bb_underline.gif' onclick='editer.set(\"Underline\");'/>");
		document.write("<img  class='edit_btn' src='"+_cp+"images/editer/bb_separator.gif'/>");
		document.write("<img  class='edit_btn' title='字体' src='"+_cp+"images/editer/font_style.png' onclick='editer.callStyle(this);'/>");
		document.write("<img  class='edit_btn' title='字体大小' src='"+_cp+"images/editer/font-size.png'  onclick='editer.callSize(this);'/>");
		document.write("<img class='edit_btn'  title='字体颜色' src='"+_cp+"images/editer/font-color.png'  onclick='editer.callColor(this);'/>");
		document.write("<img class='edit_btn'  src='"+_cp+"images/editer/bb_separator.gif'/>");
		document.write("<img  class='edit_btn' title='左对齐' src='"+_cp+"images/editer/bb_left.gif'  onclick='editer.set(\"JustifyLeft\");'/>");
		document.write("<img  class='edit_btn' title='居中' src='"+_cp+"images/editer/bb_center.gif'  onclick='editer.set(\"JustifyCenter\");'/>");
		document.write("<img  class='edit_btn' title='右对齐' src='"+_cp+"images/editer/bb_right.gif'  onclick='editer.set(\"JustifyRight\");'/>");
		document.write("<img  class='edit_btn' src='"+_cp+"images/editer/bb_separator.gif' />");
		document.write("<img  class='edit_btn' title='插入超链接' src='"+_cp+"images/editer/bb_url.gif'  onclick='editer.callUrl(this);'/>");/**/
		/*document.write("<img  class='edit_btn' title='插入超链接' src='"+_cp+"images/editer/bb_url.gif'  onclick='inputUrl();'/>");*/
		/*document.write("<img  class='edit_btn' src='"+_cp+"images/editer/bb_image.gif'  onclick='editer.callImg(this);'/>");*/
		document.write("<img  class='edit_btn' title='插入图片' src='"+_cp+"images/editer/bb_image.gif'  onclick='openNewResource(500,500);'/>");
		/*document.write("<img  class='edit_btn' src='"+_cp+"images/editer/bb_media.gif'  onclick='editer.callObjt(this);'/>");*/
		document.write("<div id='edit_style' class='edit_tag' style='position:absolute;display:none;text-align:center;width:110px;height:140px;border:1px solid #e2e2e2'>");
		document.write("<div class='font_selecter' onclick='editer.setStyle(\"宋体\")' onmouseover='this.className=\"font_selected\";editer.setStyle(\"宋体\")' onmouseout='this.className=\"font_selecter\"' style='font-family : 宋体;'>宋体</div>");
		document.write("<div class='font_selecter' onclick='editer.setStyle(\"Arial\")' onmouseover='this.className=\"font_selected\";editer.setStyle(\"Arial\")' onmouseout='this.className=\"font_selecter\"'  style='font-family : Arial;'>Arial</div>");
		document.write("<div class='font_selecter' onclick='editer.setStyle(\"黑体\")' onmouseover='this.className=\"font_selected\";editer.setStyle(\"黑体\")' onmouseout='this.className=\"font_selecter\"'  style='font-family : 黑体;'>黑体</div>");
		document.write("<div class='font_selecter' onclick='editer.setStyle(\"Tahoma\")' onmouseover='this.className=\"font_selected\";editer.setStyle(\"Tahoma\")' onmouseout='this.className=\"font_selecter\"'  style='font-family : Tahoma;'>Tahoma</div>");
		document.write("<div class='font_selecter' onclick='editer.setStyle(\"Verdana\")' onmouseover='this.className=\"font_selected\";editer.setStyle(\"Verdana\")' onmouseout='this.className=\"font_selecter\"'  style='font-family : Verdana;'>Verdana</div>");
		document.write("<div class='font_selecter' onclick='editer.setStyle(\"serif\")' onmouseover='this.className=\"font_selected\";editer.setStyle(\"serif\")' onmouseout='this.className=\"font_selecter\"'  style='font-family : serif;'>serif</div>");
		document.write("</div>");
		document.write("<div id='edit_size' class='edit_tag'  style='position:absolute;display:none;text-align:center;width:110px;height:140px;border:1px solid #e2e2e2'>");
		document.write("<div class='font_selecter' onclick='editer.setSize(1)' onmouseover='this.className=\"font_selected\";editer.setSize(1)' onmouseout='this.className=\"font_selecter\"' style='font-size:8px'>8px</div>");
		document.write("<div class='font_selecter' onclick='editer.setSize(2)' onmouseover='this.className=\"font_selected\";editer.setSize(2)' onmouseout='this.className=\"font_selecter\"'  style='font-size:10px'>10px</div>");
		document.write("<div class='font_selecter' onclick='editer.setSize(3)' onmouseover='this.className=\"font_selected\";editer.setSize(3)' onmouseout='this.className=\"font_selecter\"'  style='font-size:12px'>12px</div>");
		document.write("<div class='font_selecter' onclick='editer.setSize(4)' onmouseover='this.className=\"font_selected\";editer.setSize(4)' onmouseout='this.className=\"font_selecter\"'  style='font-size:16px'>16px</div>");
		document.write("<div class='font_selecter' onclick='editer.setSize(5)' onmouseover='this.className=\"font_selected\";editer.setSize(5)' onmouseout='this.className=\"font_selecter\"'  style='font-size:20px'>20px</div>");
		document.write("<div class='font_selecter' onclick='editer.setSize(6)' onmouseover='this.className=\"font_selected\";editer.setSize(6)' onmouseout='this.className=\"font_selecter\"'  style='font-size:24px'>24px</div>");
		document.write("</div>");
		document.write("<div id='edit_color' class='edit_tag'  style='position:absolute;display:none;text-align:center;width:440px;height:77px;border:1px solid #e2e2e2'>");
		document.write('<TABLE CELLPADDING=5 CELLSPACING=0 BORDER=1><TR>')
		for (var i = 0; i < 6; ++i) {
			document.write('<TD BGCOLOR="#FFFFFF">')
			this.drawTable(hex[i])
			document.write('</TD>')
		}
		document.write('</TR></TABLE>')
		document.write("</div>");
		document.write("<div id='edit_url' class='edit_tag'  style='font-size:12px;position:absolute;display:none;text-align:left;width:250px;height:80px;border:1px solid #e2e2e2'>");
		document.write('超链接类型： <select id="editer_linktype" onchange="editer.setUrlType()"><option value="http://">http://</option><option value="https://">https://</option><option value="ftp://">ftp://</option><option value="mailto:">mailto:</option><option value="mms://">mms://</option><option value="rtsp://">rtsp://</option></select><br/>请输入URL： <input type="text" onkeydown="editer.pressenter(event)" id="editer_link"/ value="http://"><br/>请输入文本： <input type="text" onkeydown="editer.pressenter(event)" id="editer_linktxt" /><br/><input type="checkbox" id="editer_linktar"/>是否在新窗口中打开 <a class="editer_a" href="javascript:editer.setUrl();"/>√</a><a class="editer_a" href="javascript:editer.disUrl();"/>X</a>')
		document.write("</div>");
		document.write("<div id='edit_img'  class='edit_tag' style='font-size:12px;position:absolute;display:none;text-align:center;width:260px;height:20px;border:1px solid #e2e2e2'>");
		document.write('请输入图片URL: <input type="text" id="editer_Img" /> <a class="editer_a" href="javascript:editer.setImg();"/>√</a><a class="editer_a" href="javascript:editer.disImg();"/>X</a>')
		document.write("</div>");
		document.write("<div id='edit_Obj'  class='edit_tag' style='font-size:12px;position:absolute;display:none;text-align:center;width:150px;height:90px;border:1px solid #e2e2e2'>");
		document.write('请输入影片代码:<br/> <textarea  id="editer_obj" ></textarea> <br/><a class="editer_a" href="javascript:editer.setObj();"/>√</a><a class="editer_a" href="javascript:editer.disObj();"/>X</a>')
		document.write("</div>");
		document.write("");
		document.write("<img  class='edit_btn' src='"+_cp+"images/editer/bb_separator.gif' />");
		document.write("<img  class='edit_btn' title='撤销' src='"+_cp+"images/editer/bb_undo.gif' onclick='editer.set(\"Undo\");'/>");
		document.write("<img  class='edit_btn' title='重做' src='"+_cp+"images/editer/bb_redo.gif' onclick='editer.set(\"Redo\");'/>");
		document.write("<img  class='edit_btn' src='"+_cp+"images/editer/bb_separator.gif'/>");
		document.write("<img  class='edit_btn' title='编号' src='"+_cp+"images/editer/bb_orderedlist.gif' onclick='editer.set(\"InsertOrderedList\");'/>");
		document.write("<img  class='edit_btn' title='项目符号' src='"+_cp+"images/editer/bb_unorderedlist.gif' onclick='editer.set(\"InsertUnorderedList\");'/>");
		document.write("<img  class='edit_btn' title='减少缩进' src='"+_cp+"images/editer/bb_outdent.gif' onclick='editer.set(\"Outdent\");'/>");
		document.write("<img  class='edit_btn' title='增加缩进' src='"+_cp+"images/editer/bb_indent.gif' onclick='editer.set(\"Indent\");'/>");
		document.write("<img  class='edit_btn' title='左浮动' src='"+_cp+"images/editer/bb_floatleft.gif'  onclick='editer.set(\"JustifyLeft\");'/>");
		document.write("<img  class='edit_btn' title='右浮动' src='"+_cp+"images/editer/bb_floatright.gif'  onclick='editer.set(\"JustifyRight\");'/>");
		document.write("</td></tr>");
		document.write("</table>");
		//this.printFaces();
		document.write("<textarea style='display:none;' id='"+containerName+"' name='"+containerName+"'></textarea>");
		document.write("<IFRAME style='width:"+this.width+"; height:"+this.height+";border:1px solid #333333;' marginWidth='0' marginHeight='0' frameborder='1' id='DTEditer' name='DTEditer' src='"+_default_src+"'></IFRAME>");
		
		//使iframe进入编辑状态。
		 datuuEditor = document.getElementById("DTEditer").contentWindow; 
		//window.frames["MsgFrame"].document.designMode="On"
		 datuuEditor.document.open();
		 datuuEditor.document.write('<html><head>');
		 datuuEditor.document.write("</head><body></body></html>");
		 datuuEditor.document.close();
		 datuuEditor.document.designMode = 'On';
		 datuuEditor.document.contentEditable = true;
		 datuuEditor.document.charset="utf-8";
		 editer = new Editer();
		 _transer = $(containerName);
	};
	this.drawTable = function (blue) {
		document.write('<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0>')
		for (var i = 0; i < 6; ++i) {
			this.drawRow(hex[i], blue)
		}
		document.write('</TABLE>')	
	}
	this.drawRow = function (red, blue) {
		document.write('<TR>')
		for (var i = 0; i < 6; ++i) {
			this.drawCell(red, hex[i], blue)
		}
		document.write('</TR>')
	};
	this.drawCell = function (red, green, blue) {
		document.write('<TD BGCOLOR="#' + red + green + blue + '" >')
		document.write('<A HREF="javascript:editer.setColor(\'' + (red + green + blue) + '\')">')
		document.write('<div onmouseover="editer.setColor(\'' + (red + green + blue) + '\');" onclick="editer.setColor(\'' + (red + green + blue) + '\');" style="width:12px;height:12px;"><div>')
		document.write('</A>')
		document.write('</TD>')
	};
	this.printFaces = function (){
		var sb = new Array();
		sb.push("<table><tr>");
		for(i = 0 ; i < _faces.length ; i++){
			if(i == 13)
				sb.push("<tr>");
			sb.push("<td><img onclick='editer.face(\""+_faces[i]+"\");' class='editer_faces' src = '"+_cp+"images/im/im_face/" + _faces[i] + ".png' /></td>");
			if(i == 12)
				sb.push("</tr>");
		}
		sb.push("</tr></table>");
		document.write(sb.join(''));
	}
}
function Editer(){
	this.set = function(cmd){
		datuuEditor.document.execCommand(cmd,false,null);
	}
	this.callStyle = function(obj){
		this.callObj(obj,"style");
	}
	this.hiddenDrop = function(type){
		document.body.onclick = function (){$(type).style.display = "none";document.body.onclick = null;};
	}
	this.callSize = function (obj){
		this.callObj(obj,"size");
	}
	this.callColor= function (obj){
		this.callObj(obj,"color");
	}
	this.setStyle = function(cmd){
		//alert(cmd);
		datuuEditor.document.execCommand('FontName',true,cmd);
	}
	this.setSize = function(size){
		datuuEditor.document.execCommand('FontSize',false,size);
	}
	this.setColor = function(color){
		datuuEditor.document.execCommand('ForeColor','',color);
	}
	this.setFloat = function(cmd){
		datuuEditor.document.execCommand(cmd);
	}
	this.callUrl = function (obj){
		this.callObjII(obj,"url");
	}
	this.setUrlType = function(){
		var urltype=$("editer_linktype").value;
		$("editer_link").value=urltype;
	}
	this.pressenter = function(event){
		if (event.keyCode==13){
			editer.setUrl();
		}
	}
	this.setUrl = function(){
		var url = $("editer_link").value;
		var txt = $("editer_linktxt").value;
		var target="";
		if (txt==null||txt==""){
			txt=url;
		}
		if($("editer_linktar").checked=true){
			target="target=\"_blank\"";
		}
		var sb = "<a href='"+url+"' "+target+">"+txt+"</a>";
		datuuEditor.document.body.innerHTML += sb;
		this.disUrl();
		
	}
	this.callObj = function (obj,type){
		this.disappear();
		var style = $("edit_" + type);
		var y = obj.offsetTop + obj.offsetHeight ;
		var x = obj.offsetLeft ;
		style.style.left = x + "px";
		style.style.top = y + "px" ; 
		style.style.display = "block";
		setTimeout(editer.hiddenDrop , 500 , "edit_" + type);
	}
	this.callObjII = function(obj,type){
		this.disappear();
		var style = $("edit_" + type);
		var y = obj.offsetTop - obj.offsetHeight-70 ;
		var x = obj.offsetLeft;
		style.style.left = x + "px";
		style.style.top = y + "px" ; 
		style.style.display = "block";
	}
	this.disUrl = function (){
		var style = $("edit_url");
		style.style.display = "none";
	}
	this.callImg = function(obj){
		this.callObjII(obj,'img');
	}
	this.disImg = function (){
		var style = $("edit_img");
		style.style.display = "none";
	}
	this.setImg = function(){
		var url = $("editer_Img").value;
		var sb = "<img src='"+url+"'/>";
		datuuEditor.document.body.innerHTML += sb;
		this.disImg();
	}
	this.callObjt = function(obj){
		this.callObjII(obj,'Obj');
	}
	this.disObj = function (){
		var style = $("edit_Obj");
		style.style.display = "none";
	}
	this.setObj = function(){
		var cont = $("editer_obj").value;
		datuuEditor.document.body.innerHTML += cont;
		this.disObj();
	}
	this.clearFormat = function(){
		var cont = this.getSelection(datuuEditor.document);
		this.setSelection(datuuEditor.document,cont.stripTags());
	}
	this.getSelection = function(doc){
		if(document.all){
			return doc.selection.createRange().text;;
		}else{
			return doc.getSelection();
		}
	}
	this.setSelection = function(doc,cont){
		if(document.all){
			return doc.selection.createRange().pasteHTML(cont);
		}else{
			return  "";
		}
	}
	this.get = function(){
		return datuuEditor.document.body.innerHTML;
	}
	this.trans = function(){
		_transer.value = datuuEditor.document.body.innerHTML;
		return _transer.value;
	}
	this.clear = function(){
		datuuEditor.document.body.innerHTML = "";
	}
	this.inner = function(cont){
		datuuEditor.document.body.innerHTML = cont;
	}
	this.face = function(code){
		datuuEditor.document.body.innerHTML += "<img src='"+_cp+"images/im/im_face/"+code+".png'/>";
	}
	this.disappear = function(){
		var arr = document.getElementsByClassName("edit_tag");
		for(var i = 0 ;i < arr.length ;i++){
			arr[i].style.display = "none";
		}
	}
	this.init = function(cont){
		window.setTimeout(editer.inner , 500 ,unescape(cont));
	}
	
}