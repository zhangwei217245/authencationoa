<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,com.vv.auth.struts.util.Utility,org.apache.struts.util.LabelValueBean"%>
<%-- 
/**
* by X-Spirit
* 本JS代码实现的是列表控件中列表项的上移和下移以及两个列表项之间的列表项交换
* 各个函数的参数均为字符串型，传入的是要操作的列表控件的ID,此版本需要在FF下兼容
* sortid要排序的列表框id
* src源列表框
* aim目标文本框
* move是否移动(true/false)
*/
--%>

function SortUtil(sortId,Src,Aim,Move){
    this.sortid = sortId;
    this.src = Src;
    this.aim = Aim;
    this.move = Move;
}

SortUtil.prototype.setMove= function(Move){
    this.move = Move;
}
SortUtil.prototype.setSortid= function(sortId){
    this.sortid = sortId;
}
SortUtil.prototype.setSrc= function(Src){
    this.src = Src;
}
SortUtil.prototype.setAim= function(Aim){
    this.aim = Aim;
}
SortUtil.prototype.getMove= function(){
    return this.move;
}
SortUtil.prototype.getSortid= function(){
    return this.sortid;
}
SortUtil.prototype.getSrc= function(){
    return this.src;
}
SortUtil.prototype.getAim= function(){
    return this.aim;
}
<%-- //排序：向上移动  --%>

SortUtil.prototype.optionUp= function(){
    var sel=document.getElementById(this.sortid); <%-- //获取select --%>
    var nIndex = sel.selectedIndex; <%-- //需要进行操作的select 项的索引 --%>
    var nLen = sel.length;  <%-- //select 总共项目数 --%>
    if ((nLen<1)||(nIndex==0)) return; 
    if (nIndex<0) 
    { 
        alert('<%=Utility.getMessage("select.sort.one.aim")%>');
        return; 
    } 
    var sValue=sel.options[nIndex].value; 
    var sHTML=sel.options[nIndex].text;
    sel.options[nIndex].value=sel.options[nIndex-1].value; 
    sel.options[nIndex].text=sel.options[nIndex-1].text;
    sel.options[nIndex-1].value=sValue; 
    sel.options[nIndex-1].text=sHTML;
    sel.selectedIndex=nIndex-1;
}

<%-- //排序：向下移动  --%>
SortUtil.prototype.optionDown = function() 
{ 
    var sel=document.getElementById(this.sortid); 
    var nIndex = sel.selectedIndex; 
    var nLen = sel.length; 
    if ((nLen<1)||(nIndex==nLen-1)) return; 
    if (nIndex<0) 
    { 
        alert('<%=Utility.getMessage("select.sort.one.aim")%>');
        return; 
    } 
    var sValue=sel.options[nIndex].value; 
    var sHTML=sel.options[nIndex].text;
    sel.options[nIndex].value=sel.options[nIndex+1].value; 
    sel.options[nIndex].text=sel.options[nIndex+1].text;
    sel.options[nIndex+1].value=sValue; 
    sel.options[nIndex+1].text=sHTML;
    sel.selectedIndex=nIndex+1; 
} 
<%-- //移动到最上 --%>
SortUtil.prototype.optionUpFirst=function() 
{ 
    var sel=document.getElementById(this.sortid); 
    
    var nIndex = sel.selectedIndex; 
    
    var nLen = sel.options.length; 
    
    if ((nLen<1)||(nIndex==0)) return; 
    
    if(nIndex<0) 
    { 
        alert('<%=Utility.getMessage("select.sort.one.aim")%>');
        return; 
    } 
    //var tempValue = document.getElementById("tempValue");<%--//用于临时存放option的值 --%>
    //var tempLabel = document.getElementById("tempLabel");<%--//用于临时存放option的文本 --%>
    var tempValue ="";<%--//用于临时存放option的值 --%>
    var tempLabel ="";<%--//用于临时存放option的文本 --%>
    //tempValue.value = ""; 
    //tempLabel.value = ""; 
    
    for(var k=0;k<nIndex;k++) 
    { 
        //tempValue.value += sel.options[k].value+";"; 
        //tempLabel.value += sel.options[k].text+";"; 
        tempValue += sel.options[k].value+";"; 
        tempLabel += sel.options[k].text+";"; 
    } 
    //var arrValue = tempValue.value.split(';'); 
    //var arrLabel = tempLabel.value.split(';');
    var arrValue = tempValue.split(';'); 
    var arrLabel = tempLabel.split(';');
    var sValue=sel.options[nIndex].value; 
    var sHTML=sel.options[nIndex].text;
    sel.options[0].value = sValue; 
    sel.options[0].text = sHTML;
    for(var j=1;j<=nIndex;j++) 
    { 
        sel.options[j].value = arrValue[j-1]; 
        sel.options[j].text = arrLabel[j-1];
    } 
    sel.selectedIndex = 0; 
} 
<%-- //移动到最后 --%>
SortUtil.prototype.optionDownLast=function() 
{ 
    var sel=document.getElementById(this.sortid); 
    var nIndex = sel.selectedIndex; 
    var nLen = sel.options.length; 
    if ((nLen<1)||(nIndex==nLen)) return; 
    if(nIndex<0) 
    { 
        alert('<%=Utility.getMessage("select.sort.one.aim")%>');
        return; 
    } 
    //var tempValue = document.getElementById("tempValue");<%--//用于临时存放option的值 --%>
    //var tempLabel = document.getElementById("tempLabel");<%--//用于临时存放option的文本 --%>
    var tempValue ="";<%--//用于临时存放option的值 --%>
    var tempLabel ="";<%--//用于临时存放option的文本 --%>
    //tempValue.value = ""; 
    //tempLabel.value = ""; 
    for(var k=nIndex+1;k<nLen;k++) 
    { 
        //tempValue.value += sel.options[k].value+";";
        //tempLabel.value += sel.options[k].text+";"; 
        tempValue += sel.options[k].value+";";
        tempLabel += sel.options[k].text+";"; 
    } 
    //var arrValue = tempValue.value.split(';'); 
    //var arrLabel = tempLabel.value.split(';'); 
    var arrValue = tempValue.split(';'); 
    var arrLabel = tempLabel.split(';');
    var sValue=sel.options[nIndex].value; 
    var sHTML=sel.options[nIndex].text;

    for(var j=nIndex;j<nLen;j++) 
    { 
        sel.options[j].value = arrValue[j-nIndex ]; 
        sel.options[j].text = arrLabel[j-nIndex];
    } 
    sel.options[nLen-1].value = sValue; 
    sel.options[nLen-1].text = sHTML;
    sel.selectedIndex = nLen-1; 
}
<%-- 
/**
*lablarg文本前置参数
*vallarg值前置参数
*labrarg文本后置参数
*valrarg值后置参数
*/
--%>

SortUtil.prototype.addoption=function(lablarg,vallarg,labrarg,valrarg)
{
        //var index = document.all.select1.selectedIndex;
        var select1=document.getElementById(this.src);
        var select2=document.getElementById(this.aim);
        var index = select1.selectedIndex;
        if(index!=-1)
        {
                var value = select1.options[index].value;
                var item = select1.options[index].text;

                <%--//如果仅是复制项目，则检查是否有重复的--%>
                var bool = 0;
                if(!this.move){
                    for(var i=0;i<select2.length;i++)
                    {
                        if(select2.options[i].value==value)
                        {
                                bool = 1;
                                break;
                        }
                    }
                }
                <%--//添加--%>
                if(bool==0)
                {
                        var oOption = document.createElement("option");
                        oOption.text = lablarg+item+labrarg;
                        oOption.value = vallarg+value+valrarg;
                        <%-- 如果目标列表框被选中，则新添加的选项位于选中项之前，否则位于整个列表末尾 --%>
                        if(select2.selectedIndex!=-1){
                            try{
                              select2.add(oOption,select2.options[select2.selectedIndex]); // standards compliant
                            }
                            catch(ex){
                              select2.add(oOption,select2.selectedIndex); // IE only
                            }
                        }else{
                            try{
                              select2.add(oOption,null); // standards compliant
                            }
                            catch(ex){
                              select2.add(oOption); // IE only
                            }
                        }
                        //select2.options.add(oOption);
                        
                }else{
                    alert('<%=Utility.getMessage("option.duplicate")%>')
                    return;
                }
                if(this.move){
                    select1.remove(index);
                }
        }
}
<%-- 
/**
*lablarg文本前置参数
*vallarg值前置参数
*labrarg文本后置参数
*valrarg值后置参数
*/
--%>

SortUtil.prototype.deloption=function(lablarg,vallarg,labrarg,valrarg)
{
      //var index = document.all.select2.selectedIndex;
      var select1=document.getElementById(this.src);
      var select2=document.getElementById(this.aim);
      var index = select2.selectedIndex;

      if(index!=-1)
      {
              var value = select2.options[index].value;
              var item = select2.options[index].text;

              <%--//如果是移动式添加，则还原时检查是否有重复的，否则也不用还原项目，检查就是无必要的--%>
              var bool = 0;
              if(this.move){
                  for(var i=0;i<select1.length;i++)
                  {
                          if(select1.options[i].value==value)
                          {
                                  bool = 1;
                                  break;
                          }
                  }
              }
              <%--//如果是移动式添加，需要把列表项还原到源列表框，否则只需要删除目标列表框中的项即可。--%>
              if(this.move){
                  if(bool==0)
                  {
                          var oOption = document.createElement("option");
                          oOption.text = lablarg+item+labrarg;
                          oOption.value = vallarg+value+valrarg;
                          if(select1.selectedIndex!=-1){
                            try{
                              select1.add(oOption,select1.options[select1.selectedIndex]); // standards compliant
                            }
                            catch(ex){
                              select1.add(oOption,select1.selectedIndex); // IE only
                            }
                        }else{
                            try{
                              select1.add(oOption,null); // standards compliant
                            }
                            catch(ex){
                              select1.add(oOption); // IE only
                            }
                        }
                        //select1.options.add(oOption);
                          
                  }else{
                    alert('<%=Utility.getMessage("option.duplicate")%>')
                    return;
                  }
              }
              select2.remove(index);
      }
}
<%-- 
/**
*lablarg文本前置参数
*vallarg值前置参数
*labrarg文本后置参数
*valrarg值后置参数
*/
--%>

SortUtil.prototype.addallopts = function(lablarg,vallarg,labrarg,valrarg)
{
        var select1=document.getElementById(this.src);
        var select2=document.getElementById(this.aim);
        <%--//添加全部列表--%>
        for(var i=0;i<select1.length;i++)
        {
                var item = select1.options[i].text;
                var value = select1.options[i].value;
                <%--//如果是复制式添加，则在添加是需要剃重--%>
                var bool = 0;
                if(!this.move){
                    for(var j=0;j<select2.length;j++){
                        if(select2.options[j].value==value){
                            bool=1;
                            break;
                        }
                    }
                }
                if(bool==0){
                    var oOption = document.createElement("option");
                    oOption.text = lablarg+item+labrarg;
                    oOption.value = vallarg+value+valrarg;
                    if(select2.selectedIndex!=-1){
                        try{
                          select2.add(oOption,select2.options[select2.selectedIndex]); // standards compliant
                        }
                        catch(ex){
                          select2.add(oOption,select2.selectedIndex); // IE only
                        }
                    }else{
                        try{
                          select2.add(oOption,null); // standards compliant
                        }
                        catch(ex){
                          select2.add(oOption); // IE only
                        }
                    }
                    //select2.options.add(oOption);
                }
        }
        <%--//如果是移动式添加，则有必要把源列表框清空--%>
        if(this.move){
            var length = select1.length;
            for(var k=0;k<length;k++)
            {
                    select1.remove(0);
            }
        }
}
<%-- 
/**
*lablarg文本前置参数
*vallarg值前置参数
*labrarg文本后置参数
*valrarg值后置参数
*/
--%>

 SortUtil.prototype.delallopts = function(lablarg,vallarg,labrarg,valrarg)
{
        var select1=document.getElementById(this.src);
        var select2=document.getElementById(this.aim);
        
        <%--//如果是移动式添加，在删除目标框的同时要先把原框的恢复，否则不需要此过程--%>
        if(this.move){
           <%-- //添加全部列表--%>
            for(var i=0;i<select2.length;i++)
            {
                    var item = select2.options[i].text;
                    var value = select2.options[i].value;
                    var oOption = document.createElement("option");
                    oOption.innerText = lablarg+item+labrarg;
                    oOption.value = vallarg+value+valrarg;
                    /*if(select1.selectedIndex!=-1){
                        try{
                          select1.add(oOption,select1.options[select1.selectedIndex]); // standards compliant
                        }
                        catch(ex){
                          select1.add(oOption,select1.selectedIndex); // IE only
                        }
                    }else{*/
                        try{
                          select1.add(oOption,null); // standards compliant
                        }
                        catch(ex){
                          select1.add(oOption); // IE only
                        }
                    //}
                    //select1.options.add(oOption);

            }
        }

        var length = select2.length;
        for(var k=0;k<length;k++)
        {
                select2.remove(0);
        }
}