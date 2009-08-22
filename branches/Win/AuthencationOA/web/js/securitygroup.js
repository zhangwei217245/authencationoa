
	function addoption()
	{
		var index = document.all.select1.selectedIndex;
		if(index!=-1)
		{
			var value = document.all.select1.options[index].value;
			var item = document.all.select1.options[index].text;
			
			var pname = "";
			var tmparea = document.all.scity.value;
			for(var j =0 ; j < document.all.scity.options.length; j ++ ){
				var tmpobj = document.all.scity.options[j];
				if(tmparea == tmpobj.value){
					pname = tmpobj.text;
					break;
				}
			}
			
			var bool = 0;
			for(var i=0;i<document.all.select2.length;i++)
			{
				if(document.all.select2.options[i].value==value)
				{
					bool = 1;
					break;
				}
			}
			if(bool==0)
			{
				var oOption = document.createElement("OPTION");
				document.all.select2.options.add(oOption);
				oOption.innerText = pname + "-" + item;
				oOption.value = value;
			}
			document.all.select1.options.remove(index);
		}
	}

	function addoption2()
	{
		var index = document.all.select3.selectedIndex;
		if(index!=-1)
		{
			var value = document.all.select3.options[index].value;
			var item = document.all.select3.options[index].text;
			
			var pname = "";
			var tmparea = document.all.sua.value;
			for(var j =0 ; j < document.all.sua.options.length; j ++ ){
				var tmpobj = document.all.sua.options[j];
				if(tmparea == tmpobj.value){
					pname = tmpobj.text;
					break;
				}
			}
			
			var bool = 0;
			for(var i=0;i<document.all.select4.length;i++)
			{
				if(document.all.select4.options[i].value==value)
				{
					bool = 1;
					break;
				}
			}
			if(bool==0)
			{
				var oOption = document.createElement("OPTION");
				document.all.select4.options.add(oOption);
				oOption.innerText = pname + "-" + item;
				oOption.value = value;
			}
			document.all.select3.options.remove(index);
		}
	}
	
	function del()
	{
		var index = document.all.select2.selectedIndex;
		
		if(index!=-1)
		{
			var value = document.all.select2.options[index].value;
			var item = document.all.select2.options[index].text;
			var bool = 0;
			for(var i=0;i<document.all.select1.length;i++)
			{
				if(document.all.select1.options[i].value==value)
				{
					bool = 1;
					break;
				}
			}
			if(bool==0)
			{
				var oOption = document.createElement("OPTION");
				document.all.select1.options.add(oOption);
				oOption.innerText = item.substring(item.indexOf("-")+1);
				oOption.value = value;
			}
			document.all.select2.options.remove(index);
		}
	}
	
	
	function del2()
	{
		var index = document.all.select4.selectedIndex;
		
		if(index!=-1)
		{
			var value = document.all.select4.options[index].value;
			var item = document.all.select4.options[index].text;
			var bool = 0;
			for(var i=0;i<document.all.select3.length;i++)
			{
				if(document.all.select3.options[i].value==value)
				{
					bool = 1;
					break;
				}
			}
			if(bool==0)
			{
				var oOption = document.createElement("OPTION");
				document.all.select3.options.add(oOption);
				oOption.innerText = item.substring(item.indexOf("-")+1);
				oOption.value = value;
			}
			document.all.select4.options.remove(index);
		}
	}
	
	
	function addall()
	{
		var pname = "";
		var tmparea = document.all.scity.value;
		for(var j =0 ; j < document.all.scity.options.length; j ++ ){
			var tmpobj = document.all.scity.options[j];
			if(tmparea == tmpobj.value){
				pname = tmpobj.text;
				break;
			}
		}
		//alert(pname);
		for(var i=0;i<document.all.select1.length;i++)
		{
			//alert(i);
			var item = document.all.select1.options[i].text;
			var value = document.all.select1.options[i].value;
			var oOption = document.createElement("OPTION");
			document.all.select2.options.add(oOption);
			oOption.innerText = pname + "-" + item;
			oOption.value = value;
			//document.all.select1.options.remove(i);
		}
		var length = document.all.select1.length;
		for(var i=0;i<length;i++)
		{
			document.all.select1.options.remove(0);
		}
	}

	function addall2()
	{
		var pname = "";
		var tmparea = document.all.sua.value;
		for(var j =0 ; j < document.all.sua.options.length; j ++ ){
			var tmpobj = document.all.sua.options[j];
			if(tmparea == tmpobj.value){
				pname = tmpobj.text;
				break;
			}
		}
		//alert(pname);
		for(var i=0;i<document.all.select3.length;i++)
		{
			//alert(i);
			var item = document.all.select3.options[i].text;
			var value = document.all.select3.options[i].value;
			var oOption = document.createElement("OPTION");
			document.all.select4.options.add(oOption);
			oOption.innerText = pname + "-" + item;
			oOption.value = value;
			//document.all.select1.options.remove(i);
		}
		var length = document.all.select3.length;
		for(var i=0;i<length;i++)
		{
			document.all.select3.options.remove(0);
		}
	}
	
	
	function delall()
	{
		var length = document.all.select2.length;
		for(var i=0;i<document.all.select2.length;i++)
		{
			var item = document.all.select2.options[i].text;
			var value = document.all.select2.options[i].value;
			var oOption = document.createElement("OPTION");
			document.all.select1.options.add(oOption);
			oOption.innerText = item.substring(item.indexOf("-")+1);
			oOption.value = value;
			
		}
		
		for(var i=0;i<length;i++)
		{
			document.all.select2.options.remove(0);
		}
	}
	
	function delall2()
	{
		var length = document.all.select4.length;
		for(var i=0;i<document.all.select4.length;i++)
		{
			var item = document.all.select4.options[i].text;
			var value = document.all.select4.options[i].value;
			var oOption = document.createElement("OPTION");
			document.all.select3.options.add(oOption);
			oOption.innerText = item.substring(item.indexOf("-")+1);
			oOption.value = value;
			
		}
		
		for(var i=0;i<length;i++)
		{
			document.all.select4.options.remove(0);
		}
	}