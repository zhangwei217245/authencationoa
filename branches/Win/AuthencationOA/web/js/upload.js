
	var maxFileNum = 5; 
	var currentFileNum = 0; 
	var fileInputTypename = 'testFile';
	var excFileNum = 0;
	var nowMostBig = 6;
	var arrFileHasBeanSelected = new Array(1); 
	arrFileHasBeanSelected[0] = 'true'; 

	var post = function(){
		if(validate() == true){
			$('fullContent').action = requestPath + "GETDAO/addPost.datuu?froum=" + location.search.split("=")[1];
			/*$('fullContent').formUpdate({
				handler:'result', loadingmsg:'...'
			});*/
			$('fullContent').submit();
		}
	
	}
	
	function deleteDuplicateFile(i){
		if ($("div" + i) != null){
			$("div" + i).innerHTML='';
			$("div" + i).style.display = "none";
		}
		
		
		$("inputFileDiv" + i).innerHTML='';
		$("inputFileDiv" + i).style.display = "none";
		
		
		if ($(fileInputTypename + '(' + nowMostBig + ')') && excFileNum < 5){
			$(fileInputTypename + '(' + nowMostBig + ')').disabled = "";
		}
		
	}
	
	function deletefile(i){
		
		if ($(fileInputTypename + '('  + i+ ')') != null){
			arrFileHasBeanSelected = arrFileHasBeanSelected.without($F(fileInputTypename +  '('  + i+ ')'));
		}
		
		excFileNum--;
		deleteDuplicateFile(i);
		
//alert('now the filenum is:' + excFileNum);
//alert('the nowMostBig value is:' + nowMostBig);
	}
	
	function createNewFormElement(type, id){
		'<input type="'+ type +'" name="' + id +  
			'" id="' + id + '" onkeydown="return false"  onclick="largeThan5()" onchange="newFileUpload()"/>';
	}
	
	function validate(){
		var noTitle = document.createElement("div");
		var noContent = document.createElement("div");
		
		noTitle.id="noTitleDiv";
		noTitle.name="noTitleDiv";
		noTitle.innerHTML='<font color="red">' +'no title!' + '</font>';
		
		noContent.id="noContentDiv";
		noContent.name="noContentDiv";
		noContent.innerHTML='<font color="red">' +'no content!' + '</font>';
		
		if ($F('title').replace(/(^\s*)|(\s*$)/g, "").length == 0){
			if ($('noTitleDiv') == null){
				$('titleTd').appendChild (noTitle);
			}
			return false;
		}if ($F('content').replace(/(^\s*)|(\s*$)/g, "").length == 0){
			if ($('noContentDiv') == null){
				$('contentTd').appendChild (noContent);
			}
			return false;
		}if ($('noTitleDiv') != null){
			$('titleTd').removeChild (noTitleDiv);
		}if ($('noContentDiv') != null){
			$('contentTd').removeChild (noContentDiv);
		}
		return true;
	}
	
	function largeThan5(i){
		if(excFileNum >= 5){
			alert('no more than 5 files');
			$(fileInputTypename + '(' +nowMostBig + ')').disabled = "true";
		}
	}
	
	function fileHasBeenSelected(i){
		var f=function(x){
			return x === $F(fileInputTypename + '(' + i + ')');
		};
		
		//var arr=[false,"go_rush",$F(fileInputTypename + i),"usher"];
		if (arrFileHasBeanSelected.find(f) === $F(fileInputTypename + '(' + i + ')')) {
			alert("needn't upload the same file");
			return false;
		}
		return true;
		
	}
	
	function newFileUpload(){
		if((excFileNum < 5)){
			currentFileNum++;

			//create new form
			var hiddenInputFile = '<input type="file"'+ ' name="' + fileInputTypename + '(' + (currentFileNum+1) + ')' + 
				'"'+ ' id="' + fileInputTypename + '(' + (currentFileNum+1) + ')' + '" onkeydown="return false"  onclick="largeThan5('+ currentFileNum +')" onchange="newFileUpload()"/>';
		
			var tdd = document.createElement("div");
			tdd.id="inputFileDiv" + (currentFileNum+1);
			tdd.innerHTML=hiddenInputFile;
			$('hiddenFileOpload').appendChild (tdd);
//alert('the type file is a: ' + (currentFileNum+1));
			
			$(fileInputTypename + '(' + currentFileNum + ')').style.display = "none";

			if (fileHasBeenSelected(currentFileNum) == true){
				var filelpathfull = $F(fileInputTypename + '(' + currentFileNum + ')');
				var filepathStart = filelpathfull.lastIndexOf("\\")+1; 
				var filename = filelpathfull.substring(filepathStart, filelpathfull.length);
				var deleteInfo = '<a href="#" onclick="deletefile('+ currentFileNum +')"><font color="red">delete</font></a>';
				$('fileUploadInfo').innerHTML += ('<div id="'+ "div" + currentFileNum + '">' + filename + '&nbsp;&nbsp;&nbsp;' + deleteInfo +'</div>');
		
				arrFileHasBeanSelected[currentFileNum] = filelpathfull;
				excFileNum++;
			}else{
				deleteDuplicateFile(currentFileNum);
			}
			
			if(currentFileNum > 5){
				nowMostBig++;
			}
		
		}
	}
	
	function cancel(){
		history.go(-1);
	}
	
