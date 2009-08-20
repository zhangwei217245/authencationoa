
	function addoption()
	{
		var index = document.all.select1.selectedIndex;
		if(index!=-1)
		{
			var value = document.all.select1.options[index].value;
			var item = document.all.select1.options[index].text;
			
			//检查是否有重复的
			var bool = 0;
			for(var i=0;i<document.all.select2.length;i++)
			{
				if(document.all.select2.options[i].value==value)
				{
					bool = 1;
					break;
				}
			}

			//添加
			if(bool==0)
			{
				var oOption = document.createElement("OPTION");
				document.all.select2.options.add(oOption);
				oOption.innerText = item;
				oOption.value = value;
			}
			document.all.select1.options.remove(index);
		}
	}

	function del()
	{
		var index = document.all.select2.selectedIndex;
		
		if(index!=-1)
		{
			var value = document.all.select2.options[index].value;
			var item = document.all.select2.options[index].text;
			
			//检查是否有重复的
			var bool = 0;
			for(var i=0;i<document.all.select1.length;i++)
			{
				if(document.all.select1.options[i].value==value)
				{
					bool = 1;
					break;
				}
			}

			//添加
			if(bool==0)
			{
				var oOption = document.createElement("OPTION");
				document.all.select1.options.add(oOption);
				oOption.innerText = item;
				oOption.value = value;
			}
			document.all.select2.options.remove(index);
		}
	}
	
	function addall()
	{
		//添加全部列表
		for(var i=0;i<document.all.select1.length;i++)
		{
			//alert(i);
			var item = document.all.select1.options[i].text;
			var value = document.all.select1.options[i].value;
			var oOption = document.createElement("OPTION");
			document.all.select2.options.add(oOption);
			oOption.innerText = item;
			oOption.value = value;
			//document.all.select1.options.remove(i);
		}
		var length = document.all.select1.length;
		for(var i=0;i<length;i++)
		{
			document.all.select1.options.remove(0);
		}
	}

	function delall()
	{
		var length = document.all.select2.length;
		//添加全部列表
		for(var i=0;i<document.all.select2.length;i++)
		{
			var item = document.all.select2.options[i].text;
			var value = document.all.select2.options[i].value;
			var oOption = document.createElement("OPTION");
			document.all.select1.options.add(oOption);
			oOption.innerText = item;
			oOption.value = value;
			
		}
		
		for(var i=0;i<length;i++)
		{
			document.all.select2.options.remove(0);
		}
	}