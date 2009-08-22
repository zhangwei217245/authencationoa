<logic:messagesPresent>
<center>
    <div id="errorMsgBoxMask" style="background-color:#ffcccc;position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;vertical-align:middle;z-index:1000;filter:alpha(opacity=50);-moz-opacity:0.8;opacity: 0.8;">
        
    </div>
    <div id="errorMsgBox" style="position:absolute;border:solid 1px red;z-index:1001;background:#ffaaaa;vertical-align:text-bottom;text-align:center;">
        <table height="100%" align="center" style="color:#ff0000;">
            <tr>
                <td style="font-weight:bolder">
                    <html:errors/>
                </td>
            </tr>
        </table>
    </div>
</center>
<script>
    var x = document.body.clientWidth*0.2 ;
	var y = document.body.clientHeight*0.3 ;
	if (typeof(_error_y) != "undefined"){
		y = document.body.clientHeight*0.4;
	}
    document.getElementById("errorMsgBox").style.top = (y+2)+"px";
	document.getElementById("errorMsgBox").style.left = (x+5)+"px";
	document.getElementById("errorMsgBox").style.width = document.body.clientWidth*0.6;
	document.getElementById("errorMsgBox").style.height = document.body.clientHeight*0.4;
    document.body.onclick =display_error;
    function display_error(){
        //document.getElementById("errorMsgBox").style.display="none";
        //document.getElementById("errorMsgBoxMask").style.display="none";
        $("errorMsgBox").style.display="none";
        $("errorMsgBoxMask").style.display="none";
    }
	//document.getElementById("errorMsgBoxMask").style.top = (y+2)+"px";
	//document.getElementById("errorMsgBoxMask").style.left = (x+5)+"px";
</script>

</logic:messagesPresent>