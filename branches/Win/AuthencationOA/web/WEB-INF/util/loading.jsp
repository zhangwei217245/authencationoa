
<center>
<table width="50%" cellspacing="0" cellpadding="0" style="position:absolute;z-index:999;height:50px;
top:200px;left:300px;display:none" id="loading_notice" onclick = "Loading.hidden();" >
  <tr>
    <td class="loading" align="center">
      <table width="100%" border="0" cellspacing="1" style="border:1px outset #fff" cellpadding="2">
        <tr>
          <td align="center">
            <div id="loadingmessagenew" class="loadingmessagenew" style="background:#e8edf4;width:100%;text-align:center;color:#5a7089;padding-top:15px;height:70px;"></div>
          </td>
        </tr>
      </table>
     
    </td>
  </tr>
</table>
 <div id="loading_notice_bg" style="display:none;width:50%;background:#f6f8fa;position:absolute;border:1px solid #e2e2e2;height:70px;
top:205px;left:305px;z-index:998;"></div>
<div id="loading_bg" style="display:none;position:absolute; left:-1000px;top:-1000px;width:2500px;height:4000px;background:#e6f4fd;z-index:997;filter: alpha(opacity=50);-moz-opacity:0.8;opacity: 0.8;"></div>
</center>
<script>
	var Loading = {
		show : function (){
			document.body.scrollTop = 0;
			document.body.style.overflow = "hidden";
			var count = 0;
			var str = "";
			for(i = 0 ;i<arguments.length; i++){
				str += "<div>";
				str += arguments[i];
				str += "</div>";
				count++
			}
			if(str == ""){
				str = "<div><bean:message key="loading.send"/></div><div><bean:message key="loading.revolution"/></div>";
				count = 3;
			}
			str += "<div><img src=\"<%=request.getContextPath()%>/images/loading_xp.gif\"/><div>";
			$("loadingmessagenew").innerHTML = str;
			$("loading_notice_bg").style.height = (count+1)*20+"px";
			$("loading_notice_bg").style.display = "block";
			$("loading_bg").style.display = "block";
			$("loading_notice").style.display = "block";
			var x = document.body.clientWidth*0.2 ;
			var y = document.body.clientHeight*0.3 ;
			$("loading_notice").style.top = y+"px";
			$("loading_notice").style.left = x+"px";
			$("loading_notice_bg").style.top = (y+2)+"px";
			$("loading_notice_bg").style.left = (x+5)+"px";
		},
		hidden : function (){
			$("loading_notice_bg").style.display = "none";
			$("loading_bg").style.display = "none";
			$("loading_notice").style.display = "none";
			document.body.style.overflow = "";
		}
	};
</script>
<br>
