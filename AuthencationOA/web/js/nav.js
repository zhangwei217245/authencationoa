function menuFix() { 
	if(document.getElementById("nav") != null){
		var sfEls = document.getElementById("nav").getElementsByTagName("li"); 
		for (var i=0; i<sfEls.length; i++) { 
			sfEls[i].onmouseover=function() { 
				this.className+=(this.className.length>0? " ": "") + "sfhover"; 
			} 
			sfEls[i].onMouseDown=function() { 
				this.className+=(this.className.length>0? " ": "") + "sfhover"; 
			} 
			sfEls[i].onMouseUp=function() { 
				this.className+=(this.className.length>0? " ": "") + "sfhover"; 
			} 
			sfEls[i].onmouseout=function() { 
				this.className=this.className.replace(new RegExp("( ?|^)sfhover\\b"), ""); 
			} 
		}
	}
}
var arrOnload = [];
var addOnload = function (fun){
	if(typeof(fun) == "function")
			arrOnload.push(fun);
}
addOnload(menuFix);
window.onload=function (){
		for(var i = 0 ;i<arrOnload.length;i++){
			arrOnload[i]();
		}
};

