//动态表格，支持排序和添加删除行
function SortTable(){
    this.table=null;
    this.selrow=null;
    this.rowcount=0;
    this.targetIdx=null;
}
SortTable.prototype.initTable=function(tab){
    this.table=document.getElementById(tab);
    this.selrow=null;
    this.rowcount=0;
    if(this.table!=undefined&&this.table!=null){
        //alert(this.table.rows.length);
        this.rowcount=this.table.rows.length;
    }
    this.targetIdx=null;
}
//设定选定行，变换颜色，同时设定目标索引值
SortTable.prototype.setSelRow = function (rowobj){
    if(this.selrow!=null){
        //alert(this.selrow);
        this.selrow.className="normalrow";
    }
    rowobj.className="selrow";
    //alert(rowobj.id)
    this.selrow=rowobj;
    this.targetIdx=rowobj.rowIndex;
}
//取消对选定行的选定，消除颜色
SortTable.prototype.cancelSelRow = function (){
    if(this.selrow!=null){
        //alert(this.selrow);
        this.selrow.className="normalrow";
    }
    this.selrow=null;
    this.targetIdx=null;
}
//添加一行，根据参数中的数组填充单元格。如果参数为null则填充空白单元格
//如果之前选定了某行，新行出现在选定行之上，否则出现在所有行末尾
SortTable.prototype.addRow=function (arr){
    var addidx=this.targetIdx==null?(this.rowcount==0?0:this.rowcount):this.targetIdx;
    var newrow=this.table.insertRow(addidx);
    this.rowcount++;
    if(arr!=null&&arr.length>0){
        while(arr.length>0){
            var innertxt=arr.pop();
            var cell=newrow.insertCell(0);
            cell.innerHTML=innertxt;
        }
    }else{
        var colcount=this.table.rows[0].cells.length;
        for (var i=0;i<colcount;i++){
            var empcell=newrow.insertCell(0);
            empcell.innerHTML="null";
        }
    }
    newrow.className="normalrow";
    return newrow;
}
//删除选定行
SortTable.prototype.delRow=function (){
    if(this.selrow!=null){
        var delidx=this.selrow.rowIndex;
        this.selrow=null;
        this.targetIdx=null;
        this.table.deleteRow(delidx);
        this.rowcount--;
    }
}
//将选定行上移一行
SortTable.prototype.upOneRow=function(){
    if(this.selrow!=null){
        var index = this.selrow.rowIndex
        if(index!=0)
        {
            this.table.moveRow(index,index-1);
        }else{
            //alert("已经是最上面了")
        }
    }
}
//将选定行下移一行
SortTable.prototype.downOneRow=function(){
    if(this.selrow!=null){
        var index = this.selrow.rowIndex
        if(index!=this.rowcount-1)
        {
            this.table.moveRow(index,index+1);
        }else{
            //alert("已经是最下面了")
        }
    }
}
//将选定行上移到最上
SortTable.prototype.upRowFirst=function(){
    if(this.selrow!=null){
        var index = this.selrow.rowIndex
        if(index!=0)
        {
            this.table.moveRow(index,0);
        }else{
            //alert("已经是最上面了")
        }
    }
}
//将选定行下移到最后
SortTable.prototype.downRowLast=function(){
    if(this.selrow!=null){
        var index = this.selrow.rowIndex
        if(index!=this.rowcount-1)
        {
            this.table.moveRow(index,this.rowcount-1);
        }else{
            //alert("已经是最下面了")
        }
    }
}