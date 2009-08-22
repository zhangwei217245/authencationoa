<%@ page language="java" contentType="text/html; charset=utf-8" %>
var _rp="/dtws/";
var _cp="<%=request.getContextPath() %>/";
var _st = window.setTimeout;
Array.prototype.without = function (obj){
	var oarr = this;
	var arrTmp = new Array();
	for(var i = 0 ;i < oarr.length ; i++){
		if(oarr[i] != obj)
			arrTmp.push(oarr[i])
	}
	return arrTmp;
};
window.setTimeout = function(fRef, mDelay) {
	if(typeof fRef == 'function'){
	  var argu = Array.prototype.slice.call(arguments,2);
	  var f = (function(){ fRef.apply(null, argu); });
	  return _st(f, mDelay);
 	}
 	return _st(fRef,mDelay);
}
function importJsFile(fileName){
		document.write("<script language=\"javascript\" src=\""+fileName+"\"></script>");
	
	}

function importCssFile(fileName){
		document.write("<link rel=\"stylesheet\" type=\"text/css\" href=\""+fileName+"\"></script>");
	}
String.prototype.replaceAll  = function(s1,s2){
	return this.replace(new RegExp(s1,"gm"),s2);    
} 
function doSort(a,s,e)  
    {  
        if(s<e)  
        {  
            var pos=partition(a,s,e);  
            doSort(a,s,pos-1);  
            doSort(a,pos+1,e);  
        }  
    }  
 function partition(a,st,en)  
    {  
        var s=st;  
        var e=en+1;  
        var temp=a[s];  
        while(1)  
        {  
            while(a[++s]<temp);  
            while(a[--e]>temp);  
            if(s>e)break;  
            var tem=a[s];  
            a[s]=a[e];  
            a[e]=tem;  
        }  
        a[st]=a[e];  
        a[e]=temp;  
        return e;  
    }  

Array.prototype.quickSort=function(){ 
   doSort(this,0,this.length-1);  
} 
function createXml(str){ 
	if(document.all){ 
		var xmlDom=new ActiveXObject("Microsoft.XMLDOM") ;
		xmlDom.loadXML(str) ;
		return xmlDom ;
	}
	else 
		return new DOMParser().parseFromString(str, "text/xml") ;
}
function getQueryString(key){
         var value = ""; 
         var sURL = window.document.URL;
         if (sURL.indexOf("?") > 0){
         	var arrayParams = sURL.split("?");
            var arrayURLParams = arrayParams[1].split("&");
			for (var i = 0; i < arrayURLParams.length; i++){
				var sParam =  arrayURLParams[i].split("=");
				if ((sParam[0] == key) && (sParam[1] != "")){
					value = sParam[1];
					break;
				}
			}        
		}
		return value;
}
function getContextPath(){
	var path="/";
	var sURL = window.document.URL;
	var address=sURL.substring(0,sURL.indexOf("?"));
	var arr=address.split("/");
	for(var i=3;i<arr.length-1;i++){
		path+=arr[i];
		path+="/";
	}
	return path;
}
function isLocation(){
	var req=document.referrer;
	var thispath=getContextPath();
	var path="/";
	var address=req.substring(0,req.indexOf("?"));
	var arr=address.split("/");
	if(thispath.indexOf(arr[3]) && req!="")
		return false;
	else
		return true;
	
	
}
var _arr_onloading_event = [];
function seq_onload(fun){
	if(typeof(fun) == "function")
		_arr_onloading_event.push(fun);
} 
window.onload = function() { 
	for(i = 0 ;i< _arr_onloading_event.length;i++){
		_arr_onloading_event[i]();
	}
} 
function getElement(xml,tagname,i){
	if(xml.getElementsByTagName(tagname) != null && xml.getElementsByTagName(tagname).length >= i+1){
		if(xml.getElementsByTagName(tagname).item(i).firstChild  && xml.getElementsByTagName(tagname).item(i).firstChild.nodeValue)
			return xml.getElementsByTagName(tagname).item(i).firstChild.nodeValue;
		else
			return "";
	}else{
		return "";
	}
}
function getElements(xml,tagname){
	if(xml.getElementsByTagName(tagname) != null){
		return xml.getElementsByTagName(tagname);
	}else{
		return [];
	}
}
Array.prototype.fit = function (){
	var col =this;
	for(var i = 0 ;i<arguments.length;i++){
		for(var j = 0 ;j<arguments[i].length;j++){
			col.push(arguments[i][j]);
		}		
	}
	return col;
}
Array.prototype.uniqe = function (obj){
	var col = this;
	for(var i=0 ;i<col.length;i++){
		if(obj == col[i])
			return false;
	}
	return true;
}
function getEvent(){    
       if(document.all)    return window.event;           
       func=getEvent.caller;               
       while(func!=null){       
           var arg0=func.arguments[0];   
           if(arg0){   
               if((arg0.constructor==Event || arg0.constructor ==MouseEvent)   
                   || (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)){       
                   return arg0;   
               }   
           }   
           func=func.caller;   
       }   
      return window.event;   
} 
function $B(name){
	return document.getElementsByName(name) != null ? document.getElementsByName(name) :new Array();
}
//var _arr_Ajax_request = [];
//var _arr_Ajax_request_lab = true;
//function Class_Ajax_Request(url,params,onComplete){
//	this.url = url;
//	this.params = params;
//	this.onComplete = onComplete;
//}
//Ajax.prototype.seq_Request(url,params,onComplete){
//	_arr_Ajax_request.push(new Class_Ajax_Request(url,params,onComplete));
//	if(_arr_Ajax_request_lab){
//		if(_arr_Ajax_request.length > 0){
//			_arr_Ajax_request_lab = false;
//			new Ajax.Request(_arr_Ajax_request[0].url,{
//				method: 'POST',
//				parameters:_arr_Ajax_request[0].params,
//				asynchronous:true,
//				onComplete:function (response){
//					_arr_Ajax_request[0].onComplete(response);
//					_arr_Ajax_request_lab = true;
//				}
//			});
//		}
//	}
//}


var Client = {
    Engine: {'name': 'unknown', 'version': ''},
    Features: {}
};

Client.Features.xhr = !!(window.XMLHttpRequest);
Client.Features.xpath = !!(document.evaluate);
if (window.opera) Client.Engine.name = 'opera';
else if (window.ActiveXObject) Client.Engine = {'name': 'ie', 'version': (Client.Features.xhr) ? 7 : 6};
else if (!navigator.taintEnabled) Client.Engine = {'name': 'webkit', 'version': (Client.Features.xpath) ? 420 : 419};
else if (document.getBoxObjectFor != null) Client.Engine.name = 'gecko';
Client.Engine[Client.Engine.name] = Client.Engine[Client.Engine.name + Client.Engine.version] = true;
//Client.Engine.ie是否IE浏览器，版本不限
//Client.Engine.ie6是否IE 6
//Client.Engine.ie7是否IE 7
//Client.Engine.opera是否opera
//Client.Engine.gecko是否Mozilla/Gecko(包括firefox)
//Client.Engine.webkit是否Safari
//Client.Engine.webkit419是否Safari2
//Client.Engine.webkit420是否Safari3