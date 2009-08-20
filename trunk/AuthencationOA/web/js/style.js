function overIt(){
   var the_obj = event.srcElement;
   if(the_obj.tagName.toLowerCase() == "td"){
       the_obj=the_obj.parentElement;
       the_obj.oBgc=the_obj.currentStyle.backgroundColor;            
	   the_obj.oFc=the_obj.currentStyle.color;
       the_obj.style.backgroundColor='#B0D8FF';
       the_obj.style.color='blue';
       the_obj.style.textDecoration='underline';
       the_obj.style.cursor='hand';
   }
}

function outIt(){
   var the_obj = event.srcElement;
   if(the_obj.tagName.toLowerCase() == "td"){
       the_obj=the_obj.parentElement;
       the_obj.style.backgroundColor=the_obj.oBgc;
       the_obj.style.color=the_obj.oFc;
       the_obj.style.textDecoration='';
   }
}