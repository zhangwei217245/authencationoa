String.prototype.trim = function()
{
return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.lTrim = function()
{
return this.replace(/(^\s*)/g, "");
}
String.prototype.rTrim = function()
{
return this.replace(/(\s*$)/g, "");
}


var whitespace = " \t\n\r";
var daysInMonth = makeArray(12);
daysInMonth[1] = 31;
daysInMonth[2] = 29;
daysInMonth[3] = 31;
daysInMonth[4] = 30;
daysInMonth[5] = 31;
daysInMonth[6] = 30;
daysInMonth[7] = 31;
daysInMonth[8] = 31;
daysInMonth[9] = 30;
daysInMonth[10] = 31;
daysInMonth[11] = 30;
daysInMonth[12] = 31;

function makeArray(n) {
   for (var i = 1; i <= n; i++) {
      this[i] = 0;
   }
   return this;
}


function printLine(contextUrl) {
	var resultStr;
	resultStr = '<table width="96%" height="1" border="0" align="center" cellpadding="0" cellspacing="5">';
		resultStr = resultStr + '<tr background="' + contextUrl + '/images/listbj.jpg">';
			resultStr = resultStr + '<td background="' + contextUrl + '/images/listbj.jpg"><img src="' + contextUrl + '/images/baibei.jpg" width="1" height="1"></td>';
		resultStr = resultStr + '</tr>';
	resultStr = resultStr + '</table>';
	document.write(resultStr);
}

function showHideObject(obj, isVisible) {
	obj.style.visibility = isVisible ? "visible" : "hidden";
}

function reloadObjectSrc(obj, newSrc) {
	obj.src = newSrc;
}

function globalWinInit(contextUrl) {
	window.contextUrl = contextUrl;
	window.activeTabID = "";
	window.containerID = "Container";
	window.isInited = true;
	window.isValid = true;
}

function checkAllByID(checkID, inputObj) {
	var checkList;
	if (inputObj.form)
		checkList = inputObj.form.all[checkID];
	if (checkList == null)
		checkList = document.all[checkID];

	if (checkList.length) {
		for (var i=0;i<checkList.length;i++) {
			if (checkList[i].tagName == "INPUT" && checkList[i].type == "CHECKBOX")
				checkList.checked = true;
		}
	} else {
			if (checkList.tagName == "INPUT" && checkList.type == "CHECKBOX")
				checkList.checked = true;
	}

}

function openHelperWindow(helperURL,actionURL,aFeatures)
{
    var lheight = screen.availHeight/1.5;
    var lwidth = screen.availWidth/1.5;
    var newFeatures = "height=" + lheight + ",innerHeight=" + lheight;
    newFeatures += ",width=" + lwidth + ",innerWidth=" + lwidth;
    if (window.screen)
    {
      var xc = (( screen.availHeight - lheight ) / 2);
      var yc = (( screen.availWidth - lwidth ) / 3);
      newFeatures += ",left=" + xc + ",screenX=" + xc;
      newFeatures += ",top=" + yc + ",screenY=" + yc;
      newFeatures += ",resizable=yes," + aFeatures;
    }

    actionURL=actionURL.replace("?","^");
    while (actionURL.indexOf('&')>=0)
    {
      actionURL=actionURL.replace("&","^");
    }
    var lsSplit="?";
    if (helperURL.indexOf('?') >=0)
    {
      lsSplit="&";
    }

	var lwName=window.name;
	lwName=lwName+"helper";

    var newWin = open(helperURL+lsSplit+"parentUrl="+actionURL, lwName, newFeatures);
    if (newWin.opener == null) newWin.opener = window;
    newWin.opener = this;
    newWin.focus();
    return newWin;
}

function openSubWindow(url,aFeatures)
{
    var lheight = screen.availHeight/1.5;
    var lwidth = screen.availWidth/1.5;
    var newFeatures = "height=" + lheight + ",innerHeight=" + lheight;
    newFeatures += ",width=" + lwidth + ",innerWidth=" + lwidth;
    if (window.screen)
    {
      var xc = (( screen.availHeight - lheight ) / 2);
      var yc = (( screen.availWidth - lwidth ) / 3);
      newFeatures += ",left=" + xc + ",screenX=" + xc;
      newFeatures += ",top=" + yc + ",screenY=" + yc;
      newFeatures += ",resizable=yes," + aFeatures;
    }

	var lwName=window.name;
	lwName=lwName+"sub";
    var newWin = open(url, lwName, newFeatures);
    if (newWin.opener == null) newWin.opener = window;
    newWin.focus();
    return newWin;
}

function closeHelperWindow()
{
    window.document.forms[0].parentActionUrl.value=window.document.forms[0].parentActionUrl.value.replace("^","?");

    while (window.document.forms[0].parentActionUrl.value.indexOf('^')>=0)
    {
      window.document.forms[0].parentActionUrl.value=window.document.forms[0].parentActionUrl.value.replace("^","&");
    }
    var lsSplit="?";
    if (window.document.forms[0].parentActionUrl.value.indexOf('?') >=0)
    {
      lsSplit="&";
    }
    window.document.forms[0].parentActionUrl.value=window.document.forms[0].parentActionUrl.value+lsSplit+"helper_selectItems="+window.document.forms[0].returnValue.value;
    window.opener.document.forms[0].action=window.document.forms[0].parentActionUrl.value;
    window.opener.document.forms[0].submit();
    window.opener = null;
    window.close();
}
//end add by super 2003-04
//felix start
/**
 * 回车换行
 * @param evt 事件
 * @param currFieldName 控件对应的名�?

 * @param form from对象
 * @author felix
 */
function nextField(evt, currFieldName,form){    
	var keyCode = evt.keyCode;
	var firstText = 0;
	if ( keyCode == 13 )
	{
		for( j = 0; j < form.elements.length; j++ )
		{
			if(form.elements[j].type == "text" || form.elements[j].type == "select-one" || form.elements[j].type == "checkbox" || form.elements[j].type == "radio" || form.elements[j].type == "password" || form.elements[j].type == "file" || form.elements[j].type == "button" || form.elements[j].type == "reset")
			{
				firstText = j;
				break;
			}
		}
		for(j = 0; j < form.elements.length; j++)
		{
			if(form.elements[j].type == "text" || form.elements[j].type == "select-one" || form.elements[j].type == "checkbox" || form.elements[j].type == "radio" || form.elements[j].type == "password" || form.elements[j].type == "file" || form.elements[j].type == "button"  || form.elements[j].type == "reset" )
			{
				lastText = j;
			}
		}
		for(j = 0; j < form.elements.length; ++j)
		{     
			if(form.elements[j].name == currFieldName && (form.elements[j].type == "text" || form.elements[j].type == "select-one" || form.elements[j].type == "checkbox" || form.elements[j].type == "radio" || form.elements[j].type == "password" || form.elements[j].type == "file" || form.elements[j].type == "button" || form.elements[j].type == "reset"))
			{
				if( j == lastText )
				{
					form.B1.focus();
					if(!isNaN(form.B1.maxLength))
					{
						form.B1.select();
					}
					break;
				}
				else if( j == form.elements.length-1 )
				{
					form.elements[firstText].focus();
					if(!isNaN(form.elements[firstText].maxLength))
					{
						form.elements[firstText].select();
					}
					break;
				}
				else if( form.elements[j+1].name == 'check')
				{
					form.elements[j+1].focus();
					if(!isNaN(form.elements[j+1].maxLength))
					{
						form.elements[j+1].select();
					}
					break;
				}
				else if( form.elements[j+1].name == 'BControl')
				{
					form.elements[j+2].focus();
					if(!isNaN(form.elements[j+2].maxLength))
					{
						form.elements[j+2].select();
					}
					break;
				}
				else if( form.elements[j+1].name == 'B2')
				{
					form.elements[firstText].focus();
					if(!isNaN(form.elements[firstText].maxLength))
					{
						form.elements[firstText].select();
					}
					break;
				}
				else if( form.elements[j+1].type == 'hidden')
				{
					form.elements[firstText].focus();
					if(!isNaN(form.elements[firstText].maxLength))
					{
						form.elements[firstText].select();
					}
					break;
				}
				else
				{
					form.elements[j+1].focus();        
					if(!isNaN(form.elements[j+1].maxLength))
					{
						form.elements[j+1].select();
					}
				}
			}
		}
	}
}


//felix add 2003-10-16 end
function maxVal(aix,aiy,aiz)
{
    var val1;
    var maxVal;
    if(aix > aiy)
    {
        val1=aix;
    }
    else
    {
        val1=aiy;
    }

    if(val1 > aiz)
    {
        maxVal=val1;
    }
    else
    {
        maxVal=aiz;
    }
    return maxVal;

}

// Returns the Medium of the parameters
function medVal(aix,aiy,aiz)
{
    var medVal;
    if(aix  > aiy && aix > aiz)
    {
        if(aiy > aiz)
            medVal = aiy;
        else
            medVal = aiz;
    }

    else if(aix  > aiy && aix < aiz)
    {
            medVal = aix;
    }
    else if(aix  < aiy && aix < aiz)
    {
        if(aiy > aiz)
            medVal = aiz;
        else
            medVal = aiy;
    }
    else if(aix  < aiy && aix > aiz)
    {
            medVal = aix;
    }
    return medVal;
}

// If the date is in short form then pad it
function padDateStr(asDate,asSep,aiYearIndex)
{
    var lsVal = new Array(3);
    var liPos = asDate.indexOf(asSep,0)
    lsVal[0]	= asDate.substring(0,liPos);
    lsVal[1]	= asDate.substring(liPos+1,asDate.indexOf(asSep,liPos+1));
    liPos		= asDate.indexOf(asSep,liPos+1);
    lsVal[2]	= asDate.substring(liPos+1,asDate.length);

    for(i=0;i<3;i++)
    {
        if(i==aiYearIndex)
        {
            if(lsVal[i].length < 2 || lsVal[i].length ==3 || lsVal[i].length >4) return null;
            else if (lsVal[i].length ==2)
            {
                 if (lsVal[i] > 69  && lsVal[i] < 100) lsVal[i]="19"+lsVal[i];
                 else  lsVal[i]="20"+lsVal[i];
            }
            else
            {
                lsVal[i]=lsVal[i];
            }
        }
        else
        {
            if(lsVal[i].length > 2 || lsVal[i].length <1 )  return null;
            else if (lsVal[i].length==1) lsVal[i]="0"+lsVal[i];
            else lsVal[i]=lsVal[i];
        }
    }
    return (lsVal[0]+asSep+lsVal[1]+asSep+lsVal[2]);
}

function ShowControl(filedname,url,query,formname)
{
	var tmpstr = "";
	var tmpcstr = "";
	var inum = 0; //返回查询结果个数           
	for( var i = 0;i < ARRAYNUM;i++ )
	{
		if ( HCtrlName[i] != null && CCtrlName[i] != null )
		{
			var tempfiled = "filed" + i;
			var ctempfiled = "cfiled" + i;
			tmpstr = tmpstr + "&" + tempfiled + "=" + HCtrlName[i];
			tmpcstr = tmpcstr + "&" + ctempfiled + "=" + CCtrlName[i];
			inum++;
		}
		else
		{
			break;
		}
	}      

	var strParameter= url + "?filedname=" + filedname + "&formname=" + formname + "&"+ filedname +"='+" + formname + "." + filedname + "." + "value+'" + "&query=1&queryflag=1&enabled=E&inum=" + inum;
	if( tmpstr.length != 0 )
	{
		strParameter = strParameter + tmpstr + tmpcstr;
	}
	if ( ControlValue == "")
	{
		if (ControlOpen == "")
		{
			document.write( "<td class=DetailValue-TdCN><input type=text  name=" + filedname + " size=10  maxlength=20 onkeypress=nextField(event,'"+ filedname +"',"+ formname +") onblur=ListOpen('" + strParameter + "')>" );
		}
		else
		{
			document.write( "<td class=DetailValue-TdCN><input type=text  name=" + filedname + " size=10  maxlength=20 onkeypress=nextField(event,'"+ filedname +"',"+ formname +") >" );
		}
	}
	else
	{
		if (ControlOpen == "")
		{
			document.write( "<td class=DetailValue-TdCN><input type=text value=" + ControlValue + " name=" + filedname + " size=10  maxlength=20 onkeypress=nextField(event,'"+ filedname +"',"+ formname +") onblur=ListOpen('" + strParameter + "')>" );
		}
		else
		{
			document.write( "<td class=DetailValue-TdCN><input type=text value=" + ControlValue + " name=" + filedname + " size=10  maxlength=20 onkeypress=nextField(event,'"+ filedname +"',"+ formname +") >" );
		}
	}
	document.write( "<input type=button class=buttons name=BControl value=... onclick=ListOpen('" + strParameter + "')>" );
	document.write( "</td>" );
	HCtrlName = new Array( ARRAYNUM );
	CCtrlName = new Array( ARRAYNUM );
}

var ARRAYNUM = 100; //控件数组长度     
HCtrlName = new Array(ARRAYNUM); //主form控件名称数组
CCtrlName = new Array(ARRAYNUM); //控件form中的控件名称数组
var ControlValue="";
function setCtrlValue(astrValue)
{
	ControlValue=astrValue;
}

var ControlOpen="";
function setControlOpen(OpenValue)
{
	ControlOpen=OpenValue;
}
/**
 * 设置�?要输出的控件名称和司机控件中的信息名�?

 * @param HstrCtrlName 主form控件名称
 * @param CstrCtrlName 司机控件中的信息名称
 * @author felix
 */
function setCtrlName(HstrCtrlName,CstrCtrlName)
{
	for( var i = 0; i < ARRAYNUM; i++ )
	{
		if ( HCtrlName[i] == null && CCtrlName[i] == null )
		{
			HCtrlName[i] = HstrCtrlName;
			CCtrlName[i] = CstrCtrlName;
			break;
		}
	}      
}
/**
 * 弹出新窗�?

 * @param url 路径
 * @author felix
 */
function ListOpen(url) 
{
	window.open(url,"new","resizable=yes,scrollbars=yes,width=600,height=320");
}
/**
 * 排序控件
 * @param Impath 图片路径
 * @param url 刷新路径
 * @param TxIndex 升降序标�? 0--升序  1--降序
 * @param orderbyname 排序字段�?

 * @param formname �?在form名称，类型object
 * @author felix
 */

function orderby(Impath,url,TxIndex,orderbyname,formname,otherparam)
{		
//	form = document.forms[formname]; 

	var temp='';
	if(TxIndex==null || TxIndex=='null' || TxIndex=='')
	{
		temp='0';		
	}
	else
	{
		temp=TxIndex;
	}
	var tmporderby=temp;	
    if(tmporderby=='0')
	{
		var lstr=url+"?TxIndex=1&orderbyname=-"+orderbyname;	
		if(otherparam != null)
		{
			lstr = lstr + "&" + otherparam;
		}
		orderbyname = "-"+orderbyname;
	//	document.write( "<img src="+Impath+"/images/up.gif class=Title-Img hspace=0 vspace=0 onclick=sbmit('"+ lstr +"',"+formname+",'"+orderbyname+"')>" );			
		document.write("<a href=javascript:sbmit('"+ lstr +"',"+formname+",'"+orderbyname+"')><img src="+Impath+"/images/up.gif border=0></a>");		
	}
	else if(tmporderby=='1')
	{
		var lstr=url+"?TxIndex=0&orderbyname="+orderbyname;	
		if(otherparam != null)
		{
			lstr = lstr + "&" + otherparam;
		}
		//document.write( "<img src="+Impath+"/images/down.gif class=Title-Img hspace=0 vspace=0 onclick=sbmit('"+ lstr +"',"+formname+",'"+orderbyname+"')>" );
		document.write( "<a href=javascript:sbmit('"+ lstr +"',"+formname+",'"+orderbyname+"')><img src="+Impath+"/images/down.gif border=0></a>" );		
	}	

}

/**
 * 无分页列表也仍需要排序，可掉用此函数
 * @author felix
 */
function GenerateOrderbyHidden(TxIndex,orderbyname)
{	
	document.write( "<input type='hidden' name='orderbyname' value='"+orderbyname+"'>" );
	document.write( "<input type='hidden' name='TxIndex' value="+TxIndex+">" );
}
/**
 * 完成提交功能
 * @param TxIndex 刷新路径+升降序标�?+排序字段�?

 * @param formname �?在form名称，类型object
 * @author felix
 */
		
function sbmit(TxIndex,formname,Horderbyname)
{	  

   formname.orderbyname.value=Horderbyname;
   formname.action=TxIndex;
   formname.submit();
}
 //felix end



// James.Fu.2003.04.23.begin.helper window
// . utility.jsp

function doCloseHelper(checkClose) {
  if (checkClose) {
    //window.opener.location.reload();
    window.opener.document.forms[0].strutsAction.value = 12;
    window.opener.document.forms[0].submit();
    window.opener = null;
    window.close();
  }
}

function openWin(newURL, newName, newFeatures, orgWindow) {
    var newWin = open(newURL, newName, newFeatures);
    if (newWin.opener == null) newWin.opener = window;
    //newWin.opener.name = orgName;
    newWin.opener = orgWindow;
    newWin.focus();
    return newWin
}

function doOpenHelperBase(aURL, newName, aHEIGHT, aWIDTH, aFeatures, orgWindow,
                          aCacheId, aMultiple, aValues, aDataAccessRight,
                          aParameters){
    if (aURL.indexOf('?') >=0) {
      if (aURL.indexOf('=') >=0) {
        aURL = aURL + "&strutsAction=12&helper.cacheId=" + aCacheId;
      } else {
        aURL = aURL + "strutsAction=12&helper.cacheId=" + aCacheId;
      }
    } else {
      aURL = aURL + "?strutsAction=12&helper.cacheId=" + aCacheId;
    }
    aURL = aURL + "&helper.multiple=" + aMultiple;
    aURL = aURL + "&helper.value=" + escape(aValues);
    if (aDataAccessRight != 'undefined') {
      aURL = aURL + "&model.dataAccessRight=" + escape(aDataAccessRight);
    } else {
      aURL = aURL + "&model.dataAccessRight=GEN";
    }
    if (aParameters != null && aParameters != 'undefined') {
      aURL = aURL + "&" + aParameters;
    }
    //alert(aURL);
    if (aHEIGHT == "*"){ aHEIGHT = (screen.availHeight - 80) };
    if (aWIDTH == "*"){ aWIDTH = (screen.availWidth - 30) };
    var newFeatures = "height=" + aHEIGHT + ",innerHeight=" + aHEIGHT;
    newFeatures += ",width=" + aWIDTH + ",innerWidth=" + aWIDTH;
    if (window.screen){ var ah = (screen.availHeight - 30);
    var aw = (screen.availWidth - 10);
    var xc = (( aw - aWIDTH ) / 2);
    var yc = (( ah - aHEIGHT ) / 2);
    newFeatures += ",left=" + xc + ",screenX=" + xc;
    newFeatures += ",top=" + yc + ",screenY=" + yc;
    newFeatures += "," + aFeatures };
    var newWin = openWin(aURL, newName, newFeatures, orgWindow);
    newWin.focus();
    return newWin;
}

function doOpenHelper(aUrl, aSessionId, aValues, aDataAccessRight, aParameters) {
  return doOpenHelperBase(aUrl,'help','*','600','scrollbars', this, aSessionId, true, aValues, aDataAccessRight,aParameters);
}

function doOpenHelperSingle(aUrl, aSessionId, aValues, aDataAccessRight, aParameters) {
  return doOpenHelperBase(aUrl,'help','*','600','scrollbars', this, aSessionId, false, aValues, aDataAccessRight,aParameters);
}

function doOpenParameterBase(aURL, newName, aHEIGHT, aWIDTH, aFeatures, orgWindow,
                          aSessionId, aIndex, aJobType, aValues){
    if (aURL.indexOf('?') >=0) {
      if (aURL.indexOf('=') >=0) {
        aURL = aURL + "&strutsAction=100&model.orgSessionId=" + aSessionId;
      } else {
        aURL = aURL + "strutsAction=100&model.orgSessionId=" + aSessionId;
      }
    } else {
      aURL = aURL + "?strutsAction=100&model.orgSessionId=" + aSessionId;
    }
    aURL = aURL + "&model.index=" + escape(aIndex);
    aURL = aURL + "&model.type=" + escape(aJobType);
    if (aValues != null && aValues != 'undefined') {
      aURL = aURL + "&model.values=" + escape(aValues);
    }
    // alert(aURL);
    if (aHEIGHT == "*"){ aHEIGHT = (screen.availHeight - 80) };
    if (aWIDTH == "*"){ aWIDTH = (screen.availWidth - 30) };
    var newFeatures = "height=" + aHEIGHT + ",innerHeight=" + aHEIGHT;
    newFeatures += ",width=" + aWIDTH + ",innerWidth=" + aWIDTH;
    if (window.screen){ var ah = (screen.availHeight - 30);
    var aw = (screen.availWidth - 10);
    var xc = (( aw - aWIDTH ) / 2);
    var yc = (( ah - aHEIGHT ) / 2);
    newFeatures += ",left=" + xc + ",screenX=" + xc;
    newFeatures += ",top=" + yc + ",screenY=" + yc;
    newFeatures += "," + aFeatures };
    var newWin = openWin(aURL, newName, newFeatures, orgWindow);
    newWin.focus();
    return newWin;
}

function doOpenParameter(aUrl, aSessionId, aIndex, aJobType, aValues) {
  doOpenParameterBase(aUrl,'parameter','*','600','scrollbars', this, aSessionId, aIndex, aJobType, aValues);
}
// James.Fu.2003.04.23.end.helper window

// James.Fu.2003.04.23.begin check checkbox or chekboxs is checked
/*function selectChecked(name) {
  var fieldA = eval("document.forms[0].all.item('" + name + "')");

  if (fieldA == null || fieldA == 'undefined') {
    return false;
  } else {
    var field = eval("document.forms[0].all.item('" + name + "')[0]");
    if (field == null || field == 'undefined') {
      return fieldA.checked;
    } else {
      for (i = 0; i < fieldA.length; i++) {
        if (fieldA[i].checked) {
          return true;
        }
      }
    }
    return false;
  }
}*/

function selectChecked(form, property) {
  var fieldA = eval("document.forms['" + form + "'].all.item('" + property + "')");

  if (fieldA == null || fieldA == 'undefined') {
    return false;
  } else {
    var field = eval("document.forms['" + form + "'].all.item('" + property + "')[0]");
    if (field == null || field == 'undefined') {
      return fieldA.checked;
    } else {
      for (i = 0; i < fieldA.length; i++) {
        if (fieldA[i].checked) {
          return true;
        }
      }
    }
    return false;
  }
}

//function joinValue(value1, value2, deli) {
//  deli = ";";
//  if (value1 == "") return value2;
//  if (value2 == "" ) return value1;
//
//  var rtn = "";
//  rtn = deli + value1;
//  rtn = rtn + deli + value2;
//  if (rtn.length > 0) {
//    rtn = rtn.substr(deli.length, rtn.length + 1);
//  }
//  return rtn;
//}

function selectValue(form, property, other) {
  var fieldB = eval("document.forms['" + form + "'].all.item('" + other + "')");
  var rtn = selectSingleValue(form, property);

  if (fieldB == null || fieldB == 'undefined' || fieldB.value == "") {
    return rtn;
  } else {
    if (rtn == "") {
      return fieldB.value
    } else {
      return rtn + ";" + fieldB.value;
    }
  }
}

function selectSingleValue(form, property) {
  var fieldA = eval("document.forms['" + form + "'].all.item('" + property + "')");
  var rtn = "";

  if (fieldA == null || fieldA == 'undefined') {
    rtn = "";
  } else {
    var field = eval("document.forms['" + form + "'].all.item('" + property + "')[0]");
    if (field == null || field == 'undefined') {
      rtn = fieldA.value;
    } else {
      for (i = 0; i < fieldA.length; i++) {
        if (fieldA[i].checked) {
          rtn = rtn + ";" + fieldA[i].value;
        }
      }
      if (rtn.length > 0) {
        rtn = rtn.substr(";".length, rtn.length + 1);
      }
    }
  }
  return rtn;
}
// James 2003.04.23.end check checkbox or chekboxs is checked
// Jiamu 2003.05.12 start return hidden value
function selectSingleHiddenValue(form, property, pro) {
  var fieldA = eval("document.forms['" + form + "'].all.item('" + property + "')");
  var field1A = eval("document.forms['" + form + "'].all.item('" + pro + "')");
  var rtn = "";

  if (fieldA == null || fieldA == 'undefined') {
    rtn = "";
  } else {
    var field = eval("document.forms['" + form + "'].all.item('" + property + "')[0]");
	var field1 = eval("document.forms['" + form + "'].all.item('" + pro + "')[0]");
    if (field == null || field == 'undefined') {
      rtn = field1A.value;
    } else {
      for (i = 0; i < fieldA.length; i++) {
        if (fieldA[i].checked) {
          rtn = rtn + ";" + field1A[i].value;
        }
      }
      if (rtn.length > 0) {
        rtn = rtn.substr(";".length, rtn.length + 1);
      }
    }
  }
  return rtn;
}
// Jiamu 2003.05.12 end return hidden value
// James 2003.04.23.check all checkbox
function setChecked(name)
	{
  var fieldA = eval("document.forms[0].all.item('" + name + "')");

  if (fieldA == null || fieldA == 'undefined') {
    return true;
  } else {
    var field = eval("document.forms[0].all.item('" + name + "')[0]");
    if (field == null || field == 'undefined') {
      if (fieldA.checked) {
        fieldA.checked =  false;
      } else {
        fieldA.checked =  true;
      }
    } else {
      var nextValue = fieldA[0].checked;
      for (i = 0; i < fieldA.length; i++) {
        if (nextValue) {
          fieldA[i].checked = false;
        } else {
          fieldA[i].checked = true;
        }
      }
    }
    return false;
  }
}
// James 2003.04.23.end check all checkbox

//add by super begin
function nextFieldEx(evt, currObj,form){
	var keyCode = evt.keyCode;
	var firstText = 0;
	if ( keyCode == 13 )
	{
		for( j = 0; j < form.elements.length; j++ )
		{
			if(form.elements[j].type == "text" || form.elements[j].type == "select-one" || form.elements[j].type == "checkbox" || form.elements[j].type == "radio" || form.elements[j].type == "file" || form.elements[j].type == "button" || form.elements[j].type == "reset")
			{
				firstText = j;
				break;
			}
		}
		for(j = 0; j < form.elements.length; j++)
		{
			if(form.elements[j].type == "text" || form.elements[j].type == "select-one" || form.elements[j].type == "checkbox" || form.elements[j].type == "radio" || form.elements[j].type == "file" || form.elements[j].type == "button" || form.elements[j].type == "reset" )
			{
				lastText = j;
			}
		}
		for(j = 0; j < form.elements.length; ++j)
		{
			if(form.elements[j] == currObj && (form.elements[j].type == "text" || form.elements[j].type == "select-one" || form.elements[j].type == "checkbox" || form.elements[j].type == "radio" || form.elements[j].type == "file" || form.elements[j].type == "button" || form.elements[j].type == "reset"))
			{
				if( j == lastText )
				{
					form.B1.focus();
					break;
				}
				else if( j == form.elements.length-1 )
				{
					form.elements[firstText].focus();
					break;
				}
				else if( form.elements[j+1].name == 'check')
				{
					form.elements[j+1].focus();
					break;
				}
				else if( form.elements[j+1].name == 'B1')
				{
					form.elements[j+1].focus();
					break;
				}
				else if( form.elements[j+1].name == 'B2')
				{
					form.elements[firstText].focus();
					break;
				}
				else if( form.elements[j+1].type == 'hidden')
				{
					form.elements[firstText].focus();
					break;
				}
				else
				{
					form.elements[j+1].focus();
				}
			}
		}
	}
}

/*
*利用正则表达式来�?查文本框的字节长�?

*正则表达式来把中文字�?(\x00 - \xff)转化为两�?*，这样来实现中文字当两个字符计算
*/
function checkLength(currObj,msg)
{
	var lValue=currObj.value
	if (lValue.length>0)
	{
		lValue=lValue.replace(/[^\x00-\xff]/g,"**");
		if (lValue.length>currObj.maxLength)
		{
			alert(msg);
			currObj.focus();
			return false;
		}
	}
	return true;
}

function checkAllLength(form,msg)
{
	for(i = 0; i < form.elements.length; i++)
	{
		if(form.elements[i].type == "text" )
		{
			var lValue=form.elements[i].value;
			if (lValue.length>0)
			{
				lValue=lValue.replace(/[^\x00-\xff]/g,"**");
				if (lValue.length>form.elements[i].maxLength)
				{
					alert(msg);					
					form.elements[i].focus();
					return false;
				}
			}
		}
	}
	return true;

}

function checkKeyPress()
{
	var keyCode=window.event.keyCode;
	if(keyCode != 13 && keyCode !=39 && keyCode!=37 ) 
		return false;

	var srcElement=window.event.srcElement;
	var form=srcElement.form;

	if (srcElement.type=="text" || srcElement.type=="select-one" || srcElement.type=="checkbox" || srcElement.type=="radio" || srcElement.type=="button" || srcElement.type=="reset" || srcElement.type=="file") 
	{
		var elementsLength=form.length;
		var i = 0;
		while (i<elementsLength && srcElement!=form.elements[i])
		{
			i++;
		}
		if (keyCode == 13  || (keyCode==39 && (srcElement.type=="button" || srcElement.type=="reset" || srcElement.type=="file") ) )
		{
			i++;
			while (i<elementsLength)
			{
				if(form.elements[i].type == "text" || form.elements[i].type == "select-one" || form.elements[i].type == "checkbox" || form.elements[i].type == "radio" || form.elements[i].type == "file" || form.elements[i].type == "button" || form.elements[i].type == "reset")
				{
					form.elements[i].focus();
					if(!isNaN(form.elements[i].maxLength))
					{
						form.elements[i].select();
					}
					return false;
				}
				i++;
			}
			
			i=0;
			while (i<elementsLength)
			{
				if(form.elements[i].type == "text" || form.elements[i].type == "select-one" || form.elements[i].type == "checkbox" || form.elements[i].type == "radio" || form.elements[i].type == "file" || form.elements[i].type == "button" || form.elements[i].type == "reset")
				{
					form.elements[i].focus();
					if(!isNaN(form.elements[i].maxLength))
					{
						form.elements[i].select();
					}
					return false;
				}
				i++;
			}
		}
		else if (keyCode==37 && (srcElement.type=="button" || srcElement.type=="reset" || srcElement.type=="file")  )
		{
			i--;
			while (i>=0)
			{
				if(form.elements[i].type == "text" || form.elements[i].type == "select-one" || form.elements[i].type == "checkbox" || form.elements[i].type == "radio" || form.elements[i].type == "file" || form.elements[i].type == "button" || form.elements[i].type == "reset")
				{
					form.elements[i].focus();
					if(!isNaN(form.elements[i].maxLength))
					{
						form.elements[i].select();
					}
					return false;
				}
				i--;
			}
			
			i=elementsLength;
			while (i>=0)
			{
				if(form.elements[i].type == "text" || form.elements[i].type == "select-one" || form.elements[i].type == "checkbox" || form.elements[i].type == "radio" || form.elements[i].type == "file" || form.elements[i].type == "button" || form.elements[i].type == "reset")
				{
					form.elements[i].focus();
					if(!isNaN(form.elements[i].maxLength))
					{
						form.elements[i].select();
					}
					return false;
				}
				i--;
			}
		}

	}
	return false;
}

//add by super end

function isRadioCheck(inputName)
{
    var chosed = 0;
    with( document.all.tags("INPUT") )
    {
        for( i = 0; i < length; i++ )
        {
            if( item(i).checked == true && item(i).type == 'radio' && item(i).name == inputName)
            {
                chosed++;
            }
        }
    }
    if( chosed == 0 )
    {
        return false;
    }
    else
    {
        return true;
    }
}
function formatPrice(value, ifRounding){ 
	var text = "" + value;
	var integerStr = "";
	var decimalStr = "";
	var toRound = 0;
	var index = text.indexOf(".");
	if (index != -1) {
		integerStr = text.substring(0, index);
		decimalStr = text.substring(index + 1);
	} else {
		integerStr = text;
		decimalStr = "";
	}
	var maxlength = text.length;
	var decimal = decimalStr.length;
	for (i = 0; i < decimal + 1; i++) decimalStr += "0";
	decimalStr = decimalStr.slice(0, decimal + 1);
	var decimalValue = parseInt(decimalStr);
	var lastDecimal = decimalValue % 10;

	if (ifRounding && lastDecimal >= 5) {
		var floatValue = parseFloat(integerStr + "." + decimalStr);
		floatValue = floatValue + Math.pow(10, -1 * decimal);
		return formatPrice(floatValue, maxlength, decimal, false);
	} else {
		integerStr = integerStr.slice(integerStr.length - maxlength + decimal, integerStr.length);
		decimalStr = decimalStr.slice(0, decimal);
		return integerStr + "." + decimalStr;
	}
}
function formatPrice(value, maxlength, decimal, ifRounding){ 
	var text = "" + value;
	var integerStr = "";
	var decimalStr = "";
	var toRound = 0;
	var index = text.indexOf(".");
	if (index != -1) {
		integerStr = text.substring(0, index);
		decimalStr = text.substring(index + 1);
	} else {
		integerStr = text;
		decimalStr = "";
	}
	for (i = 0; i < decimal + 1; i++) decimalStr += "0";
	decimalStr = decimalStr.slice(0, decimal + 1);
	var decimalValue = parseInt(decimalStr);
	var lastDecimal = decimalValue % 10;
	if (ifRounding && lastDecimal >= 5) {
		var floatValue = parseFloat(integerStr + "." + decimalStr);
		alert(floatValue);
		floatValue = floatValue + Math.pow(10, -1 * decimal);
		return formatPrice(floatValue, maxlength, decimal, false);
	} else {
		if (integerStr.length > maxlength){
			integerStr = integerStr.slice(integerStr.length - maxlength + decimal, integerStr.length);
		}else{
			integerStr = integerStr.slice(0, integerStr.length);
		}
		decimalStr = decimalStr.slice(0, decimal);
		return integerStr + "." + decimalStr;
	}
}
function getStringLength(strTemp)
{
	var i,sum;
 	sum=0;
 	for(i=0;i<strTemp.length;i++)
 	{
  		if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255))
   			sum=sum+1;
  		else
   			sum=sum+2;
 	}
 	return sum;
}

/**
 * 第一个文本控件被选中
 */
function firstFocus()
{
	if(document.forms.length>0)
	{
		var objElements = document.forms[0].elements;
		var i = 0;
		for(i = 0;i < objElements.length; i++)
		{
		  if(objElements[i].type == "text")
		  {
		    if(!objElements[i].disabled)
		    {
		    	objElements[i].focus();
		    	break;
		    }
		  }
		}
	}
}
function stripInitialWhitespace (s)

{   var i = 0;
    s +=""; // convert numbet to string
    while ((i < s.length) && charInString (s.charAt(i), whitespace))
       i++;

    return s.substring(i, s.length);
}

function stripEndingWhitespace (s)
{
    var i = s.length;

    while ((i > 0) && charInString (s.charAt(i-1), whitespace))
       i--;

    return s.substring(0,i);
}

function stripInitialEndingWhitespace (s)
{
    var returnString = stripInitialWhitespace (s);
    returnString = stripEndingWhitespace (returnString);
    return returnString
}
/**
 * 确定某一操作是否继续，传入不同的提示信息
 * @param form_prompt alert提示信息
 * @return true--确定�? false--取消
 * @author felix
 */
function checkform(form_prompt)
{
	var pass=confirm(form_prompt);
	if( pass )
	{
		return true;
	}
	else
	{
		return false;
	}
}



	//checkbox的全选
	
	
	function ChkSelectAll(chknameStr,chkallnameStr){
		var arrInput = document.getElementsByTagName('input');
		var arrCheckbox = [];
		var chkname = [];
		var chkallname = [];
		for(var j=0;j<arrInput.length;j++){
		    if(arrInput[j].type.toLowerCase()=='checkbox') arrCheckbox[arrCheckbox.length] = arrInput[j];
		}
		for(j=0;j<arrCheckbox.length;j++){
		    if(arrCheckbox[j].name==chknameStr) chkname[chkname.length] = arrCheckbox[j];
			else if(arrCheckbox[j].name==chkallnameStr) chkallname[chkallname.length] = arrCheckbox[j];
		}
		
		var length = chkname.length;   
	    if(chkallname.length==1) chkallname[0].checked = chkallname[0].checked|0;
		else if(chkallname.length>1 && ChkSelectAll.arguments[2]) for(j=0;j<chkallname.length;j++) chkallname[j].checked =  ChkSelectAll.arguments[2].checked|0;
	
	    for (var i = 0; i < length; i++) if(!chkname[i].disabled) chkname[i].checked=chkallname[0].checked;            
	}
	
	function unChkSelectAll(chkallnameStr){
		var arrInput = document.getElementsByTagName('input');
		var arrCheckbox = [];
		var chkallname = [];
		for(var j=0;j<arrInput.length;j++){
		    if(arrInput[j].type.toLowerCase()=='checkbox') arrCheckbox[arrCheckbox.length] = arrInput[j];
		}
		for(j=0;j<arrCheckbox.length;j++){
			if(arrCheckbox[j].name==chkallnameStr) chkallname[chkallname.length] = arrCheckbox[j];
		}
		
		for(j=0;j<chkallname.length;j++) if(chkallname[j].checked) chkallname[j].checked = chkallname[j].checked&0;
	}
	
	function checknumber(String) 
    { 
        var Letters = "1234567890."; 
        var i; 
        var c; 
        for( i = 0; i < String.length; i ++ ){ 
            c = String.charAt( i ); 
            if (Letters.indexOf( c ) <0){    
            	return false; 
       		} 
        } 
        return true; 
    } 
	
	function getStrLength(str){
		var str_tmp_1 = str.replace(/(^\s*)/g, "");
		var str_tmp_2 = str_tmp_1.replace(/(\s*$)/g, "");
		var len = str_tmp_2.match(/[^ -~]/g) == null ? str_tmp_2.length : str_tmp_2.length + str_tmp_2.match(/[^ -~]/g).length ; 
		return len;
	}

	function getElementPos(elementId) {   
	  var ua = navigator.userAgent.toLowerCase();   
	  var isOpera = (ua.indexOf('opera') != -1);   
	  var isIE = (ua.indexOf('msie') != -1 && !isOpera); // not opera spoof   
	  var el = document.getElementById(elementId);   
	  if(el.parentNode === null || el.style.display == 'none')   
	  {   
	    return false;   
	  }   
	  var parent = null;   
	  var pos = [];   
	  var box;   
	  if(el.getBoundingClientRect) //IE   
	  {   
	    box = el.getBoundingClientRect();   
	    var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);   
	    var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);return {x:box.left + scrollLeft, y:box.top + scrollTop};   
	  }   
	  else if(document.getBoxObjectFor) // gecko   
	  {   
	    box = document.getBoxObjectFor(el);   
	  
	    var borderLeft = (el.style.borderLeftWidth)?parseInt(el.style.borderLeftWidth):0;   
	    var borderTop = (el.style.borderTopWidth)?parseInt(el.style.borderTopWidth):0;   
	    pos = [box.x - borderLeft, box.y - borderTop];   
	  }   
	  else // safari & opera   
	  {   
	    pos = [el.offsetLeft, el.offsetTop];   
	    parent = el.offsetParent;   
	    if (parent != el) {   
	      while (parent) {   
	        pos[0] += parent.offsetLeft;   
	        pos[1] += parent.offsetTop;   
	        parent = parent.offsetParent;   
	      }   
	    }   
	    if (ua.indexOf('opera') != -1|| ( ua.indexOf('safari') != -1 && el.style.position == 'absolute' ))   
	    {   
	      pos[0] -= document.body.offsetLeft;   
	      pos[1] -= document.body.offsetTop;   
	    }   
	  }   
	  
	  if (el.parentNode) {   
	    parent = el.parentNode;    
	  }else {    
	    parent = null;    
	  }   
	  while (parent && parent.tagName != 'BODY' && parent.tagName != 'HTML')   
	  { // account for any scrolled ancestors   
	    pos[0] -= parent.scrollLeft;   
	    pos[1] -= parent.scrollTop;   
	  
	    if (parent.parentNode){    
	      parent = parent.parentNode;    
	    }   
	    else{    
	      parent = null;    
	    }   
	  }   
	  return {x:pos[0], y:pos[1]};   
	}  
	

	function  checkEmail(email)   
	  {   
	       var   reEmail   =   /^([A-Za-z0-9])(\w)+@(\w)+(\.)(com|com\.cn|net|cn|net\.cn|org|biz|info|gov|gov\.cn|edu|edu\.cn)/;   
	       if   (!email.match(reEmail)&&email!=""){   
	             alert('Email必须符合要求!');   
	             return   false;   
	        } else  
	         return   true;   
	  }   
	  
	function isChn(str){
      var reg =  /^w+$/;
      if(!reg.test(str)){
       return false;
      }
      return true;
	}
        
/**//*
    功能：修改 window.setTimeout，使之可以传递参数和对象参数
    使用方法： setTimeout(回调函数,时间,参数1,,参数n)
*/
var __sto = setTimeout;
window.setTimeout = function(callback,timeout,param)
{
    var args = Array.prototype.slice.call(arguments,2);
    var _cb = function()
    {
        callback.apply(null,args);
    }
    
    __sto(_cb,timeout);
}
	
	