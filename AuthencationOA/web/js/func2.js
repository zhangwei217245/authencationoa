//是否为数字
function isNum(s) 
{ 
	//alert(s);
	//alert(s.length);
	var Number = "0123456789"; 
	for(i = 0; i < s.length;i++) 
	{ 
		var c = s.charAt(i); 
		if (Number.indexOf(c) == -1) return false; 
	} 
	return true;
} 

function IsNum2(s) 
{ 
	var Number = "0123456789."; 
	for(i = 0; i < s.length;i++) 
	{ 
		var c = s.charAt(i); 
		if (Number.indexOf(c) == -1) return false; 
	} 
	return true;
}

function IsNum3(s) 
{ 
	var Number = "0123456789-"; 
	for(i = 0; i < s.length;i++) 
	{ 
		var c = s.charAt(i); 
		if (Number.indexOf(c) == -1) return false; 
	} 
	return true;
}

function isInt(s){
	//alert(s);
	var patrn=/^[+,-]{0,1}\d+$/; 
	if (!patrn.exec(s))
		return false;
	return true;
}
/**
 * 检测所输入字符是否为空白字符（包括空格、回车、制表符等）
 */
function isBlank(str){
    var regexp=/^\s*$/g;
    return regexp.test(str);
}
/**
 * 检查日期
 * @param dateObj 源日期
 * @param dateMask 格式日期
 * @return CkDate  格式化后的日期

 * @author felix
 */
var dateObj;
function check_date(dateObj,dateMask)
{
	var CkDate = true;
	var myobj = dateObj.value;
	if ( dateObj.value != "" )
	{
		var re = /\D/;//set variable re equal non-digital;
		if ( myobj.length > 10 )
		{
			dateObj.value = '';
			dateObj.focus();
	    }
		else
		{
			
			var yplace = dateMask.indexOf("y");				
			var mplace = dateMask.indexOf("m");
			var dplace = dateMask.indexOf("d");		

			var year = dateObj.value.substring(yplace,yplace*1+4);	  
			var month = dateObj.value.substring(mplace,mplace*1+2);
			var day = dateObj.value.substring(dplace,dplace*1+2);

			var one_str=dateObj.value.substring(yplace*1+4,yplace*1+5);
            var two_str=dateObj.value.substring(mplace*1+2,mplace*1+3);
			if(one_str != '-')
			{
				CkDate = false; 
				dateObj.value = '';
				dateObj.focus();	
			}
			if(two_str != '-')
			{
				CkDate = false; 
				dateObj.value = '';
				dateObj.focus();	
			}
			if( re.test(year) )
			{
				CkDate = false;
				dateObj.value = '';
				dateObj.focus();				
			}
			if( re.test(month) )
			{
				CkDate = false;
				dateObj.value = '';
				dateObj.focus();				
			}

			if( re.test(day) )
			{
				CkDate = false; 
				dateObj.value = '';
				dateObj.focus();				
			}
			if( year > 9999 || year < 0000 )
			{
				CkDate = false; 
				dateObj.value = "";
				dateObj.focus();
			}
			if( month > 12 || month < 1 )
			{
				CkDate = false; 
				dateObj.value = "";
				dateObj.focus();
			}
			if( day > 31 || day < 1 )
			{
				CkDate = false; 
				dateObj.value = "";
				dateObj.focus();
			}
			if( year%4 == 0 && ( year%100 != 0 || year%400 == 0 ) )
			{       
				if( month == 2 )
				{
					if( day > 29 )
					{
						CkDate = false; 
						dateObj.value = "";
						dateObj.focus();
					}	
				}
			}
			else
			{
				if( month == 2 )
				{
					if( day > 28 )
					{     
						CkDate = false;   
						dateObj.value = "";
						dateObj.focus();
					}
				}
			}
		}      
	}
    return CkDate;
}


/**
*	比较哪个日期靠前或相等
**/
function isFirstDateGreaterOrEqual(aDate1, aDate2)
{
    if(aDate1==null || aDate2 == null)
    {
        return false;
    }

    if(aDate1 >= aDate2) return true;
    else return false;
}
//比较哪个日期靠前或相等
function isFirstDateGreater(aDate1, aDate2)
{
    if(aDate1==null || aDate2 == null)
    {
        return false;
    }

    if(aDate1 > aDate2) return true;
    else return false;
}

/**
*	验证日期
**/
function validateDate(asDate, asMask)
{
    var liMonthPos;
    var liDayPos;
    var liYearPos;
    var liMonth;
    var liDay;
    var liYear;
    var lsSep;
    var liMaxVal;
    var liMedVal;
    var liYearIndex;
    // if not enough characters in date return immediately!
    if(asDate.length < 6 ) return false;
 
    // get the positions of the Date components
    liDayPos		=	asMask.indexOf("dd",0);
    liMonthPos	=	asMask.indexOf("MM",0);
    liYearPos		=	asMask.indexOf("yyyy",0);

    liMaxVal=maxVal(liDayPos,liMonthPos,liYearPos);
    liMedVal=medVal(liDayPos,liMonthPos,liYearPos);

    lsSep = asMask.substring(liMaxVal-1,liMaxVal);

    if(liYearPos ==liMaxVal)
    {
        liYearIndex=2;
    }
    else if(liYearPos==liMedVal)
    {
        liYearIndex = 1;
    }
    else
    {
        liYearIndex=0;
    }

    if(asDate.length < 10 )
    {
        asDate = padDateStr(asDate,lsSep,liYearIndex);
        if(asDate == null) return false;
    }

    //check all separators are Ok
    if(asDate.substring(liMaxVal-1,liMaxVal)!=lsSep) return false;
    if(asDate.substring(liMedVal-1,liMedVal)!=lsSep) return false;

    // check all are numbers
    if(!isInteger(asDate.substring(liDayPos,liDayPos+2))) 		return false;
    if(!isInteger(asDate.substring(liMonthPos,liMonthPos+2))) return false;
    if(!isInteger(asDate.substring(liYearPos,liYearPos+4))) 	return false;

    liDay		= parseInt(asDate.substring(liDayPos,liDayPos+2),10);
    liMonth	= parseInt(asDate.substring(liMonthPos,liMonthPos+2),10);
    liYear	= parseInt(asDate.substring(liYearPos,liYearPos+4),10);

    // Validate all entries
    if(!validateMonth(liMonth)) 			return false;
    if(!validateYear(liYear)) 				return false;
    if(!validateDay(liDay,liMonth,liYear))	return false;

    return true;
}
//验证日期
function validateDateEx(asDate, asMask)
{
    var liMonthPos;
    var liDayPos;
    var liYearPos;
    var liMonth;
    var liDay;
    var liYear;
    var lsSep;
    var liMaxVal;
    var liMedVal;
    var liYearIndex;
    // if not enough characters in date return immediately!
    if(asDate.length < 6 ) return false;
 
    // get the positions of the Date components
    liDayPos		=	asMask.indexOf("dd",0);
    liMonthPos	=	asMask.indexOf("MM",0);
    liYearPos		=	asMask.indexOf("yyyy",0);

    liMaxVal=maxVal(liDayPos,liMonthPos,liYearPos);
    liMedVal=medVal(liDayPos,liMonthPos,liYearPos);

    lsSep = asMask.substring(liMaxVal-1,liMaxVal);

    if(liYearPos ==liMaxVal)
    {
        liYearIndex=2;
    }
    else if(liYearPos==liMedVal)
    {
        liYearIndex = 1;
    }
    else
    {
        liYearIndex=0;
    }

    if(asDate.length < 10 )
    {
        asDate = padDateStr(asDate,lsSep,liYearIndex);
        if(asDate == null) return false;
    }

    //check all separators are Ok
    if(asDate.substring(liMaxVal-1,liMaxVal)!=lsSep) return false;
    if(asDate.substring(liMedVal-1,liMedVal)!=lsSep) return false;

    // check all are numbers
    if(!isInteger(asDate.substring(liDayPos,liDayPos+2))) 		return false;
    if(!isInteger(asDate.substring(liMonthPos,liMonthPos+2))) return false;
    if(!isInteger(asDate.substring(liYearPos,liYearPos+4))) 	return false;

    liDay		= parseInt(asDate.substring(liDayPos,liDayPos+2),10);
    liMonth	= parseInt(asDate.substring(liMonthPos,liMonthPos+2),10);
    liYear	= parseInt(asDate.substring(liYearPos,liYearPos+4),10);

    // Validate all entries
    if(!validateMonth(liMonth)) 			return false;
    if(!validateYear(liYear)) 				return false;
    if(!validateDay(liDay,liMonth,liYear))	return false;

    return true;
}

/**
*	验证时间
**/
function validateTime(asTime)
{
	//æ¶é´å¿é¡»æ¯hh:mm:ssæ ¼å¼
    // if not enough characters in date return immediately!
    if(asTime.length != 8 ) return false;

    // check all are numbers
	var liHour=asTime.substring(0,2);
	var liMinute=asTime.substring(3,5);
	var liSecond=asTime.substring(6,8);
    if(!isInteger(liHour)) 	return false;
    if(!isInteger(liMinute))   return false;
    if(!isInteger(liSecond)) 	return false;

	if (asTime.substring(2,3)!=":")
		return false;

	if (asTime.substring(5,6)!=":")
		return false;

    if (parseInt(liHour,10)>23 || parseInt(liHour,10)<0)
		return false;
    if (parseInt(liMinute,10)>59 || parseInt(liHour,10)<0)
		return false;
    if (parseInt(liSecond,10)>59 || parseInt(liHour,10)<0)
		return false;
    return true;
}
//验证日期时间
function validateDateTime(asDateTime,asDateMask)
{
	//æ¥ææ¶é´æ ¼å¼ Date hh:mm:ss
    var i = asDateTime.length;

    while ((i > 0) && (!charInString (asDateTime.charAt(i-1), whitespace)))
       i--;

	if (i==0) return false;

    var lDate=asDateTime.substring(0,i-1);
	var lTime=asDateTime.substring(i,asDateTime.length);
	if (validateDate(lDate,asDateMask) && validateTime(lTime))
		return true;
	else
		return false;
}
//验证时间
function validateDateTimeEx(asDateTime,asDateMask)
{
	//æ¥ææ¶é´æ ¼å¼ Date hh:mm:ss
    var i = asDateTime.length;

    while ((i > 0) && (!charInString (asDateTime.charAt(i-1), whitespace)))
       i--;

	if (i==0) return false;

    var lDate=asDateTime.substring(0,i-1);
	var lTime=asDateTime.substring(i,asDateTime.length);
	if (validateDateEx(lDate,asDateMask) && validateTime(lTime))
		return true;
	else
		return false;
}

/**
*	是否是整数
**/
function isInteger (s)
{
    var i;
    if (isEmpty(s))
       if (isInteger.arguments.length == 1) return defaultEmptyOK;
       else return (isInteger.arguments[1] == true);

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
        if (!isDigit(c)) return false;
    }

    return true;
}
//验证字符是否是数字
function isDigit (c)
{   return ((c >= "0") && (c <= "9"))
}

//验证唯空
function isEmpty(s)
{
    if ((s == null) || ((stripInitialEndingWhitespace(s)).length == 0))
    {
        return true
    }
    else
        return false
}
//验证字符串中是否包含制定字符
function charInString (c, s)
{   for (i = 0; i < s.length; i++)
    {   if (s.charAt(i) == c) return true;
    }
    return false
}


//验证日
function validateDay(aiDay,aiMonth,aiYear)
{
    if(isNaN(aiDay))	return false;
    if(aiDay > daysInMonth[aiMonth] || aiDay<1) return false;
    //if ((aiMonth == 2) && (aiDay > daysInFebruary(aiYear))) return false;
    return true;
}
//验证年
function validateMonth(aiMonth)
{
    if(isNaN(aiMonth))return false;
    if(aiMonth <1 || aiMonth >12 ) return false;
    else return true;
}
//验证月
function validateYear(aiYear)
{
    if(isNaN(aiYear))return false;
    if(aiYear <1970) return false;
    else return true;
}
/**
 * 多选是否选择
 * @param sub_nobody alertæç¤ºä¿¡æ¯
 * @return true--å·²ï¿½éæ© false--ä¸ºéæ©
 * @author felix
 */
function checkChose( sub_nobody , i )
{
	var checks=document.getElementsByName(sub_nobody);
	var count = 0;
	for(var j=0;j<checks.length;j++){
		if(checks[j].checked)
			count++;
	}
	if(count == i)
		return true;
	else
		return false;
	
}
/**
 * 单选是否选择
 * @param sub_nobody alertæç¤ºä¿¡æ¯
 * @return true--å·²ï¿½éæ© false--ä¸ºéæ©
 * @author felix
 */
function radiokchose( sub_nobody )
{
	var chosed = 0; 
	with( document.all.tags("INPUT") )
	{
		for( i = 0; i < length; i++ )
		{
			if( item(i).checked == true && item(i).type == 'radio' )
			{
				chosed++;
			}
		}
	}
	if( chosed == 0 )
	{
		alert( sub_nobody );
		return false;
	}
	else
	{
		return true;
	}
}

//验证是否为手机号
function isTel(s)   
{   
//var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?(\d){1,12})+$/;   
var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;   
if (!patrn.exec(s)) return false  
return true  
}
function isMobile(s)
{
	var pattern=/^(013|015|13|15)\d{9}$/;
	if(!pattern.exec(s))return false
	return true
}
//验证是否是url
function isUrl(s) {
            var regexp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/gi;
            return regexp.test(s);
        }

//验证是否是email
function isEmail(s)   
{   
  
var patrn=/^([A-Za-z0-9])(\w)+@(\w)+(\.)(com|com\.cn|net|cn|net\.cn|org|biz|info|gov|gov\.cn|edu|edu\.cn)/;   
if (!patrn.exec(s))return false  
return true  
}   
//验证是否是密码6~20位   
function isPasswd(s)   
{   
var patrn=/^(\w){6,20}$/;   
if (!patrn.exec(s)) return false  
return true  
}   

//验证用户名
function isRegisterUserName(s)   
{   
var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;   
if (!patrn.exec(s)) return false  
return true  
} 
//验证yy-mm-dd hh:mi:ss
function isDateTime(str){  
		var patrn=/^[0-9]{2,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$/;   
			if (!patrn.exec(str)) return false  
			return true   
}
//是否是数字
function isDigit(s)   
{   
var patrn=/^[0-9]{1,20}$/;   
if (!patrn.exec(s)) return false  
return true  
} 
//是否含有字符
function isCharsInBag(s,bag){     
	  var  i,c,r;   
	  for (i   =   0;   i   <   s.length;   i++){     
		  c =s.charAt(i); 
		 // alert('c:'+c+'       '+bag.indexOf(c));
		  if (bag.indexOf(c)<0) {
		  	r = c; 
		  	break; 
		  }   
		  	 
	  }   
	  return   "";   
  }   
    
function isChn(s){   
	  var   errorChar;   
	  var   badChar="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789><,.[]{}?/+=|\\'\":;~!#$&%()`/";   
	  errorChar   =   isCharsInBag(   s,   badChar)   
		  if   (errorChar != ""){   
		  return   true;   
		  }    
	  return   false;   
  }
  
  /**Validate a URL with defined protocol schema
   * @param schema ：URL protocol schema, separated by |, e.g. :  http|ftp|https|rtsp|mms
   * @param s the URL string which is going to be validated
   */
  function IsURL(schema,s){
  	var regstr="("+schema+")://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
  	var regexp=new RegExp(regstr,"g");
  	return regexp.test(s);
  }
  /**
   * 验证是否含有中文等双字节字符（即一般意义上的全角字符）
   */
function hasChn(s){
	var regexp= /[^\x00-\xff]/g
	return regexp.test(s);
}
      /**
       *Author：X-Spirit
      *校验字符串是否全部为中文及中文符号
      *返回值：
      *如果为空，定义校验通过，           返回true
      *如果字串为中文，校验通过，         返回true
      *如果字串为非中文，             返回false    参考提示信息：必须为中文！
      */
      function checkIsChinese(str)
      {
          //如果值为空，通过校验
          if (str == "")
          return true;
          var pattern = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0])*$/gi;
          if (pattern.test(str))
          return true;
          else
          return false;
      }
      /**
       * Author：X-Spirit
       * 校验是否为大头号
       * 如果是返回True
       * 不是返回False
       * 匹配标准：一个中文字符开头，后跟三个大写英文字母，并以四个阿拉伯数字结尾
       */
      function IsDID(str){
          var pattern = /^[\u4E00-\u9FA5]{1}[A-Z]{3}[0-9]{4}$/g;
          if (pattern.test(str))
          return true;
          else
          return false;
      }
      function clearCalendarInput(obj){
          obj.value="";
      }
