var nCalendarState = 0;//是否是操作日历，如果=1说明是，否则不是

/**
 * 设置为操作日历的动作 onkeydown激活
 */
function setCalendarState()
{
  nCalendarState = 1;
}

/**
 * 处理keydown事件
 */
function keyDown(DnEvents)
{
  if(nCalendarState == 1)//
  {
	  nCalendarState = 0;
	  return true;
  }
}

document.onkeydown = keyDown; // work together to analyze keystrokes

/**
 * 页面定制输出等待提示框
 * @param waitmsg 等待提示信息
 * @author felix
 */
function showhtml(waitmsg)
{
	document.write("<div id='sending' style='position:absolute; top:320; left:20; z-index:10; visibility:hidden'><TABLE WIDTH=100% BORDER=0 CELLSPACING=0 CELLPADDING=0><TR><td width=30%></td><TD bgcolor=#ff9900><TABLE WIDTH=100% height=70 BORDER=0 CELLSPACING=2 CELLPADDING=0><TR><td bgcolor=#eeeeee align=center>"+waitmsg+"</td></tr></table></td><td width=30%></td></tr></table></div>\n" );

	document.write("<div id='cover' style='position:absolute; top:0; left:0; z-index:9; visibility:hidden'><TABLE WIDTH=100% height=900 BORDER=0 CELLSPACING=0 CELLPADDING=0><TR><TD align=center><br></td></tr></table></div>\n" );

}
/**
 * 页面输出等待提示框
 * @author felix
 */
function showSending()
{
	gnIsShowSending=1;
	sending.style.visibility="visible";
	cover.style.visibility="visible";
}


function formatDate(control)
{
  k =  window.event.keyCode;
  if(k!=8 && k!=13 && k!=37 && k!=46 && k!=39)
  {
	  var nLength = control.value.length;
	  switch(nLength)
	  {
	    case 4:
	    case 7:
	      control.value=control.value + "-";
	      break;
	  }
  }}


function formatDateTime(control)
{
  k =  window.event.keyCode;
  if(k!=8 && k!=13 && k!=37 && k!=46)
  {
	  var nLength = control.value.length;
	  switch(nLength)
	  {
	    case 4:
	    case 7:
	      control.value=control.value + "-";
	      break;
	    case 10:
	      control.value=control.value + " ";
	      break;
	    case 13:
	      control.value=control.value + ":";
	      break;
	    case 16:
	      control.value=control.value + ":00";
	      break;
	  }
  }
}


function focusIn(DnEvents)
{
  if(document.activeElement!=null)
  {
    if(document.activeElement.type == "text" || document.activeElement.type == "select-one" || document.activeElement.type == "checkbox" || document.activeElement.type == "radio" || document.activeElement.type == "file" || document.activeElement.type == "button" || document.activeElement.type == "reset")
    {
     document.activeElement.style.background='#99ccff';
    }
  }
}
function beforeDeactivate(DnEvents)
{
  if(window.event.srcElement!=null)
  {
 if(window.event.srcElement.type == "text" || window.event.srcElement.type == "select-one" || window.event.srcElement.type == "checkbox" || window.event.srcElement.type == "radio" )
 {
    window.event.srcElement.style.background="#ffffff";
 }
  }
}
 
//document.onfocusin = focusIn;
//document.onbeforedeactivate = beforeDeactivate;

//渐隐渐现函数
nereidFadeObjects = new Object();
nereidFadeTimers = new Object();

function nereidFade(object, destOp, rate, delta) {
	if (!document.all) {return;}
	if (object != "[object]"){
	  setTimeout("nereidFade("+object+","+destOp+","+rate+","+delta+")",0);
	  return;
	}
	clearTimeout(nereidFadeTimers[object.sourceIndex]);
	diff = destOp-object.filters.alpha.opacity;
	direction = 1;
	if (object.filters.alpha.opacity > destOp){
	  direction = -1;
	}
	delta=Math.min(direction*diff,delta);
	object.filters.alpha.opacity+=direction*delta;
	if (object.filters.alpha.opacity != destOp){
	  nereidFadeObjects[object.sourceIndex]=object;
	  nereidFadeTimers[object.sourceIndex]=setTimeout("nereidFade(nereidFadeObjects["+object.sourceIndex+"],"+destOp+","+rate+","+delta+")",rate);
	}
}