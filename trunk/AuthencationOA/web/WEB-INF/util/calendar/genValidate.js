
/**
*   genvalidate.js is a JavaScript library for form field validation
*   File Name:     genvalidate.js
*
*   @version        1.0
*   @author         TCS
*   @see
*   Author          Date                   Change Description
*/



var whitespace = " \t\n\r";

var defaultEmptyOK = false

var dateMask = "MM/dd/yyyy";
var lengthOfDouble = 12;
var DecimalSeparator = ".";

function makeArray(n) {
   for (var i = 1; i <= n; i++) {
      this[i] = 0
   }
   return this
}



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

function fnCalendar(boxName, months, xPos, yPos, datemask)
{

    var pass_array = new Array();
    if(fnCalendar.arguments.length != 3 && fnCalendar.arguments.length != 5)
    {
        alert("Argument mismatch !");
        return;
    }
    else if(fnCalendar.arguments.length == 3)
    {
        pass_array[0] = fnCalendar.arguments[1];
        pass_array[1] = fnCalendar.arguments[0];
        pass_array[2] = fnCalendar.arguments[2];
    }
    else
    {
        pass_array[0] = fnCalendar.arguments[1];
        pass_array[1] = fnCalendar.arguments[0];
        pass_array[2] = fnCalendar.arguments[4];
        pass_array[3] = fnCalendar.arguments[2];
        pass_array[4] = fnCalendar.arguments[3];
    }

    var h = document.body.clientHeight;
    var w = document.body.clientWidth;

    var x = window.event.screenX;
    var y = window.event.screenY;

    var x1 = window.screenLeft;
    var y1 = window.screenTop;

    if ( (h-(y-y1)) <= 180 )
        y = y - (180-(h-(y-y1))) ;


    window.showModalDialog('Calendar.html',pass_array,'dialogHeight="182px";dialogWidth="152px";dialogTop='+y+';dialogLeft='+x+';status="no";help="no"');
}

function openThisWindow(theURL,winName,winOpenedArr,category)
{
  var features ;
  var winOpened;

  //To ensure tht incase no flag is passed yet, then include a ?, else use a &
  //Also dont append anything if the URL is blank !
  if (theURL != "")
  {
    if (theURL.indexOf('?') != -1)
      theURL = theURL + "&hdPopUpWindow=True" ;
    else
      theURL = theURL + "?hdPopUpWindow=True" ;
  }


  var left = window.screenLeft ;
  var top = window.screenTop ;

  if (category == '1a')
  {
    features = 'resizable=yes,width=560,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '1b')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=yes'
  }
  else if (category == '1c')  //for advanced analysis
  {
    features = 'resizable=yes,width=750,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2a')
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2b')
  {
    features = 'resizable=yes,width=400,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2c')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2d')
  {
    features = 'resizable=yes,width=400,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3a')  //For comment windows
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3b')
  {
    features = 'resizable=yes,width=400,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3c')
  {
    features = 'resizable=yes,width=500,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3d')
  {
    features = 'resizable=yes,width=600,height=500,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '4a')
  {
    features = 'resizable=yes,width=700,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }

  for (var i=0; i < winOpenedArr.length ; i++)
  {
    if (winOpenedArr[i] && winOpenedArr[i].open && !winOpenedArr[i].closed)
    {
      if (winOpenedArr[i].name == winName)
      {
        winOpenedArr[i].focus();
        return winOpenedArr[i];
      }
    }
  }
  closeTheseWindows(winOpenedArr)
  winOpened = window.open(theURL,winName,features);
  return winOpened ;
}

function openTheseWindow(theURL,winName,winOpenedArr,category,closeFlag)
{
  var features ;
  var winOpened;

  //To ensure tht incase no flag is passed yet, then include a ?, else use a &
  //Also dont append anything if the URL is blank !
  if (theURL != "")
  {
    if (theURL.indexOf('?') != -1)
      theURL = theURL + "&hdPopUpWindow=True" ;
    else
      theURL = theURL + "?hdPopUpWindow=True" ;
  }

  var left = window.screenLeft ;
  var top = window.screenTop ;

  if (category == '1a')
  {
    features = 'resizable=yes,width=560,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '1b')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=yes'
  }
  else if (category == '1c')  //for advanced analysis
  {
    features = 'resizable=yes,width=750,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2a')
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2b')
  {
    features = 'resizable=yes,width=400,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2c')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2d')
  {
    features = 'resizable=yes,width=400,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3a')  //For comment windows
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3b')
  {
    features = 'resizable=yes,width=400,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3c')
  {
    features = 'resizable=yes,width=500,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3d')
  {
    features = 'resizable=yes,width=600,height=500,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '4a')
  {
    features = 'resizable=yes,width=700,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }

  for (var i=0; i < winOpenedArr.length ; i++)
  {
    if (winOpenedArr[i] && winOpenedArr[i].open && !winOpenedArr[i].closed)
    {
      if (winOpenedArr[i].name == winName)
      {
        winOpenedArr[i].focus();
        return winOpenedArr[i]
      }
    }
  }
  if(closeFlag)
      closeTheseWindows(winOpenedArr);
  winOpened = window.open(theURL,winName,features);
  return winOpened ;
}

function closeTheseWindows(winOpenedArr)
{
  for (var i=0; i < winOpenedArr.length ; i++)
  {
    if (winOpenedArr[i] && winOpenedArr[i].open && !winOpenedArr[i].closed)
    {
      winOpenedArr[i].close();
    }
  }
}

function focusField(field)
{
  if ( (field != null) && (field.disabled == false) && ((field.type == "text") || (field.type == "textarea")) )
  {
    field.focus();
  }
}

function placeFocus()
{
  if (document.forms.length > 0)
  {
    var field = document.forms[0];
    for (i = 0; i < field.length; i++)
    {
      if ( (field.elements[i] != null) && ((field.elements[i].type == "text") || (field.elements[i].type == "textarea") || (field.elements[i].type == "password")) )
      {
        if (field.elements[i].disabled == false)
        {
          field.elements[i].focus();
          break;
        }
      }
    }
  }
}

function isEmpty(s)
{
    if ((s == null) || ((stripInitialEndingWhitespace(s)).length == 0))
    {
        return true
    }
    else
        return false
}

function isEmptyValue(s)
{
    if ((s == null) || ((stripInitialEndingWhitespace(s)).length == 0))
    {
        return true
    }
    else
        return false
}

function isWhitespace (s)

{   var i;

    if (isEmpty(s)) return true;

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);

        if (whitespace.indexOf(c) == -1) return false;
    }

    return true;
}

function isWhitespaceStr(s)

{
    var i;
    var count=0;

  if (isEmpty(s)) return true;

  for (i = 0; i < s.length; i++)
  {
    var c = s.charAt(i);

    if (whitespace.indexOf(c) != -1)
    count++;

  }
  if(count > 0)
  return false;
  else
  return true;
}

function stripCharsInBag (s, bag)

{   var i;
    var returnString = "";

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }

    return returnString;
}

function stripCharsNotInBag (s, bag)

{   var i;
    var returnString = "";
    s += "" ; // convert number to string;
    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
        if (bag.indexOf(c) != -1) returnString += c;
    }

    return returnString;
}



function handleHtmlTag(s)
{

    if ((s==null) || (s==""))
       return false;
    var tempStr=s.toUpperCase() ;
    var i=0;
        var tempArray = new Array("<ABBR>","<ABBR","</ABBR>","<ABOVE>","<ACRONYM>","<ACRONYM","</ACRONYM>","<ADDRESS>","<ADDRESS","</ADDRESS>","<APPLET","</APPLET>","<ARRAY>","<AREA","</AREA>","<B>","<B","</B>","<BASE","<BASEFONT","<BDO>","<BDO","</BDO>","<BGSOUND","<BIG>","<BIG","</BIG>","<BLINK>","</BLINK>","<BLOCKQUOTE>","<BLOCKQUOTE","</BLOCKQUOTE>","<BODY","<BODY>","</BODY>","<BOX>","<BR","<BR>","<BIG","<BLINK","<BUTTON>","</BUTTON>","<CAPTION>","<CAPTION","</CAPTION>","<CENTER>","<CENTER","</CENTER>","<CITE>","<CITE","</CITE>","<CODE>","<CODE","</CODE>","<COL>","</COL>","<COLGROUP>","</COLGROUP>","<COMMENT>","</COMMENT>","<DD>","<DD","</DD>","<DEL>","<DEL","</DEL>","<DFN>","<DFN","</DFN>","<DIR>","<DIR","</DIR>","<DIV>","<DIV","</DIV>","<DL>","<DL","</DL>","<DT>","<DT","</DT>","<EM>","<EM","</EM>","<EMBED","<FIELDSET>","<FIELDSET","</FIELDSET>","<FIG>","<FONT","</FONT>","<FORM>","<FORM","</FORM>","<FRAME","<FRAMESET","</FRAMESET>","<H1>","<H1","</H1>","<H2>","<H2","</H2>","<H3>","<H3","</H3>","<H4>","<H4","</H4>","<H5>","<H5","</H5>","<H6>","<H6","</H6>","<HEAD>","<HEAD","</HEAD>","<HR>","<HR","<HTML>","<HTML","</HTML>","<I>","<I","</I>","<IFRAME>","</IFRAME>","<ILAYER>","</ILAYER>","<IMG","<INPUT>","<INPUT","<INS>","<INS","</INS>","<ISINDEX>","<ISINDEX","<KBD>","<KBD","</KBD>","<LABEL>","<LABEL","</LABEL>","<LAYER>","<LEGEND>","<LEGEND","</LEGEND>","<LI>","<LI","</LI>","<LINK","<LISTING>","</LISTING>","<MAP","</MAP>","<MARQUEE","</MARQUEE>","<MENU>","<MENU","</MENU>","<META","<MULTICOL>","</MULTICOL>","<NEXTID","<NOBR>","</NOBR>","<NOFRAMES>","</NOFRAMES>","<NOLAYER>","</NOLAYER>","<NOTE>","</NOTE>","<NOSCRIPT>","</NOSCRIPT>","<OBJECT>","<OBJECT","<OL>","<OL","</OL>","<OPTION>","<OPTION","</OPTION>","<OPTGROUP>","<OPTGROUP","</OPTGROUP>","<P","<P>","</P>","<PARAM","<PRE>","<PRE","</PRE>","<Q>","<Q","</Q>","<QUOTE>","<RANGE>","<ROOT>","<S>","<S","</S>","<SAMP>","<SAMP","</SAMP>","<SCRIPT","<SCRIPT>","</SCRIPT>","<SELECT","</SELECT>","<SMALL>","<SMALL","</SMALL>","<SOUND","<SPACER>","<SPAN>","<SPAN","</SPAN>","<SQRT>","<STRIKE>","<STRIKE","</STRIKE>","<STRONG>","<STRONG","</STRONG>","<STYLE>","<STYLE","</STYLE>","<SUB>","<SUB","</SUB>","<SUP>","<SUP","</SUP>","<TABLE>","<TABLE","</TABLE>","<TBODY>","<TBODY","</TBODY>","<TD","<TD>","</TD>","<TEXT>","<TEXTAREA","<TEXTAREA>","</TEXTAREA>","<TFOOT>","<TFOOT","</TFOOT>","<TH","<TH>","</TH>","<THEAD>","<THEAD","</THEAD>","<TITLE>","</TITLE>","<TR","<TR>","</TR>","<TT>","</TT>","<TT","<U>","<U","</U>","<UL>","<UL","</UL>","<VAR>","</VAR>","<VAR","<WBR>","<XMP>","</XMP>","&QUOT;","&NBSP;","<%=","%>","<%@","<!--","-->","XXXX") ;
    while (tempArray[i]!="XXXX")
    {
        if (tempStr.indexOf(tempArray[i]) != -1)
        {
                return true;
        }
        i++;
        }
        return false;
}

function stripWhitespace (s)

{   return stripCharsInBag (s, whitespace)
}



function replace_quot(target)
{
  var work = target;
  var ind = 0;
  var next = 0;
  var oldTerm="&quot;";
  var newTerm="\"";
  if(replace_quot.arguments.length == 2 && replace_quot.arguments[1]=="rev")
  {
    oldTerm="\"";
    newTerm="&quot;";
  }

  while ((ind = work.indexOf(oldTerm,next)) >= 0)
  {
        target = target.substring(0,ind) + newTerm + target.substring(ind+oldTerm.length,target.length);
        work = work.substring(0,ind) + newTerm + work.substring(ind+oldTerm.length,work.length);
        next = ind + newTerm.length;
        if (next >= work.length)
        {
            break;
        }
  }
  return target;

}

function replaceInString(target,aoldTerm,anewTrem)
{
  var work = target;
  var ind = 0;
  var next = 0;
  var oldTerm= aoldTerm;
  var newTerm= anewTrem;

  while ((ind = work.indexOf(oldTerm,next)) >= 0)
  {
        target = target.substring(0,ind) + newTerm + target.substring(ind+oldTerm.length,target.length);
        work = work.substring(0,ind) + newTerm + work.substring(ind+oldTerm.length,work.length);
        next = ind + newTerm.length;
        if (next >= work.length)
        {
            break;
        }
  }
  return target;

}


function charInString (c, s)
{   for (i = 0; i < s.length; i++)
    {   if (s.charAt(i) == c) return true;
    }
    return false
}

function isValidId (s)
{
        if (isEmpty(s)) return defaultEmptyOK;
    s +=""; // convert numbet to string
    var singleQuote=s.indexOf('\'');
    var doubleQuote=s.indexOf('\"');
    if(singleQuote==-1 && doubleQuote==-1)
        return true;
    else
        return false;
}


function stripInitialZero (s)
{   var i = 0;
    s +=""; // convert numbet to string

    while ((i < s.length) && charInString (s.charAt(i), '0'))
       i++;

    return s.substring(i, s.length);
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
function isLetter (c)
{   return ( ((c >= "a") && (c <= "z")) || ((c >= "A") && (c <= "Z")) || (c==" "))
}

function isLetter1 (c)
{   return ( ((c >= "a") && (c <= "z")) || ((c >= "A") && (c <= "Z")))
}

function isDigit (c)
{   return ((c >= "0") && (c <= "9"))
}

function isLetterOrDigit (c)
{   return (isLetter(c) || isDigit(c))
}

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


function isSignedInteger (s)
{   if (isEmpty(s))
       if (isSignedInteger.arguments.length == 1) return defaultEmptyOK;
       else return (isSignedInteger.arguments[1] == true);

    else {
        var startPos = 0;
        var secondArg = defaultEmptyOK;

        if (isSignedInteger.arguments.length > 1)
            secondArg = isSignedInteger.arguments[1];

        if ( (s.charAt(0) == "-") || (s.charAt(0) == "+") )
           startPos = 1;
        return (isInteger(s.substring(startPos, s.length), secondArg))
    }
}


function isPositiveInteger (s)
{   var secondArg = defaultEmptyOK;
    var lsFirstData = s.substr(0,1);
    if(lsFirstData=="+" || lsFirstData=="-")
       return false;
    if (isPositiveInteger.arguments.length > 1)
        secondArg = isPositiveInteger.arguments[1];

    return (isSignedInteger(s, secondArg)
         && ( (isEmpty(s) && secondArg)  || (parseInt (s,10) > 0) ) );
}


function isNonnegativeInteger (s)
{   var secondArg = defaultEmptyOK;

    if (isNonnegativeInteger.arguments.length > 1)
        secondArg = isNonnegativeInteger.arguments[1];

    return (isSignedInteger(s, secondArg)
         && ( (isEmpty(s) && secondArg)  || (parseInt (s,10) >= 0) ) );
}


function isNegativeInteger (s)
{   var secondArg = defaultEmptyOK;

    if (isNegativeInteger.arguments.length > 1)
        secondArg = isNegativeInteger.arguments[1];

    return (isSignedInteger(s, secondArg)
         && ( (isEmpty(s) && secondArg)  || (parseInt (s,10) < 0) ) );
}


function isNonpositiveInteger (s)
{   var secondArg = defaultEmptyOK;

    if (isNonpositiveInteger.arguments.length > 1)
        secondArg = isNonpositiveInteger.arguments[1];

    return (isSignedInteger(s, secondArg)
         && ( (isEmpty(s) && secondArg)  || (parseInt (s,10) <= 0) ) );
}


function isFloat (s)
{   var i;
    var seenDecimalPoint = false;

    if (isEmpty(s))
       if (isFloat.arguments.length == 1) return defaultEmptyOK;
       else return (isFloat.arguments[1] == true);

    if (s == ".") return false;

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
        if ((c == ".") && !seenDecimalPoint) seenDecimalPoint = true;
        else if (!isDigit(c)) return false;
    }

    return true;
}

function isFloat(s,ds)
{   var i;
    var seenDecimalPoint = false;
    if(s == ds) return false;
    if (isEmpty(s))
       if (isFloat.arguments.length == 1) return defaultEmptyOK;
       else return (isFloat.arguments[1] == true);

    if (s == ".") return false;

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
        if ((c == ds) && !seenDecimalPoint) seenDecimalPoint = true;
        else if (!isDigit(c)) return false;
    }

    return true;
}

function formatQty(s,ds,gs,gsize,prcn)
{
    var s1 = s+"";
    var i;
    var lsint=""
    var lsdec=""
    var lreturn=""
    prcn=4;
    var ind = s1.indexOf('.');
  if(ind != -1)
  {
    lsint=s1.substring(0,ind)
    lsdec=s1.substring(ind + 1,s1.length)
    if(lsdec.length < prcn)
        {
            var range=prcn -lsdec.length;
            for(var k=0;k<range;k++)
            {
                lsdec=lsdec + "0";
            }
        }
        else if(lsdec.length > prcn)
        {
            s1=Math.round(s1 * (Math.pow(10,prcn)))
            s1=s1/(Math.pow(10,prcn));
            s1=s1+"";
            ind = s1.indexOf('.');
            if(ind != -1)
            {
                lsint=s1.substring(0,ind);
            lsdec=s1.substring(ind + 1,s1.length)
            if(lsdec.length < prcn)
                {
                    var range=prcn -lsdec.length;
                    for(var k=0;k<range;k++)
                    {
                        lsdec=lsdec + "0";
                    }
                }
        }
        else
        {
            lsint=s1;
        }
        }
  }
  else
  {
    lsint=s1;
  }

  var resultOfDiv=parseInt(lsint.length/gsize);
  var resultOfMod=lsint.length % gsize;

  if(resultOfMod!=0 )
  {
    var temp=lsint.substring(0,resultOfMod,lsint.length);
    lreturn=lreturn + temp;
  }
  for(var i=1;i<=resultOfDiv;i++)
  {
    var lstemp= lsint.substring((i-1)*gsize+resultOfMod,i*gsize+resultOfMod,lsint.length);
    lreturn=lreturn + lstemp;
    /*
    if(resultOfMod==0 && i==1)
    {
        lreturn=lreturn + lstemp;
    }
    else
    {
        lreturn=lreturn + gs + lstemp;
    }
    */
  }
    if(ind != -1)
    {
        lreturn=lreturn + ds + lsdec;
    }
    else
    {
        if(prcn !=0)
        {
            lreturn=lreturn + ds;
            for(var k=0;k<prcn;k++)
            {
                lreturn=lreturn + "0";
            }
        }
  }
  return lreturn;
}

function formatNumber(s,ds,gs,gsize,prcn)
{
    var s1 = s+"";
    var i;
    var lsint=""
    var lsdec=""
    var lreturn=""
    var ind = s1.indexOf('.');
  if(ind != -1)
  {
    lsint=s1.substring(0,ind)
    lsdec=s1.substring(ind + 1,s1.length)
    if(lsdec.length < prcn)
        {
            var range=prcn -lsdec.length;
            for(var k=0;k<range;k++)
            {
                lsdec=lsdec + "0";
            }
        }
        else if(lsdec.length > prcn)
        {
            s1=Math.round(s1 * (Math.pow(10,prcn)))
            s1=s1/(Math.pow(10,prcn));
            s1=s1+"";
            ind = s1.indexOf('.');
            if(ind != -1)
            {
                lsint=s1.substring(0,ind);
            lsdec=s1.substring(ind + 1,s1.length)
            if(lsdec.length < prcn)
                {
                    var range=prcn -lsdec.length;
                    for(var k=0;k<range;k++)
                    {
                        lsdec=lsdec + "0";
                    }
                }
        }
        else
        {
            lsint=s1;
        }
        }
  }
  else
  {
    lsint=s1;
  }

  var resultOfDiv=parseInt(lsint.length/gsize);
  var resultOfMod=lsint.length % gsize;

  if(resultOfMod!=0 )
  {
    var temp=lsint.substring(0,resultOfMod,lsint.length);
    lreturn=lreturn + temp;
  }
  for(var i=1;i<=resultOfDiv;i++)
  {
    var lstemp= lsint.substring((i-1)*gsize+resultOfMod,i*gsize+resultOfMod,lsint.length);
    if(resultOfMod==0 && i==1)
    {
        lreturn=lreturn + lstemp;
    }
    else
    {
        lreturn=lreturn + gs + lstemp;
    }
  }
    if(ind != -1)
    {
        lreturn=lreturn + ds + lsdec;
    }
    else
    {
        if(prcn !=0)
        {
            lreturn=lreturn + ds;
            for(var k=0;k<prcn;k++)
            {
                lreturn=lreturn + "0";
            }
        }
  }
  return lreturn;
}

function isSignedFloat (s)
{   if (isEmpty(s))
       if (isSignedFloat.arguments.length == 1) return defaultEmptyOK;
       else return (isSignedFloat.arguments[1] == true);

    else {
        var startPos = 0;
        var secondArg = defaultEmptyOK;

        if (isSignedFloat.arguments.length > 1)
            secondArg = isSignedFloat.arguments[1];

        if ( (s.charAt(0) == "-") || (s.charAt(0) == "+") )
           startPos = 1;
        return (isFloat(s.substring(startPos, s.length), secondArg))
    }
}


function isAlphabetic (s) {
    var i;
    if (isEmpty(s))
       if (isAlphabetic.arguments.length == 1)
           return defaultEmptyOK;
       else
           return (isAlphabetic.arguments[1] == true);

   return true;
}

function isAlphanumeric (s) {
    var i;
    if (isEmpty(s))
       if (isAlphanumeric.arguments.length == 1) return defaultEmptyOK;
       else return (isAlphanumeric.arguments[1] == true);

    return true;
}

function isZipCode (s)
{
    var i;
  if (isEmpty(s))
  if (isZipCode.arguments.length == 1) return defaultEmptyOK;
    else return (isZipCode.arguments[1] == true);

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
      //if (! (isDigit(c) || isLetter1(c) || (c=='-') || isWhitespace(c)))
      /*Code modified by Rishi. This is to allow the entering of chinese characters
      while preventing the entering of the special characters at the same time. */
      if ( (!(isDigit(c) || isValidSeparator(c) || (c=='-') || isWhitespace(c)))
      || (c=='~') || (c=='`') || (c=='?') || (c=='$') || (c=='^') || (c=='_')
      || (c=='=') || (c==':') || (c==';') || (c=='<') || (c==',') || (c=='>')
      || (c=='.'))
      return false;
    }

    return true;
}

function isTelNo (s)
{
//	var i;
//  if (isEmpty(s))
//  	if (isTelNo.arguments.length == 1) return defaultEmptyOK;
//  	else return (isTelNo.arguments[1] == true);

//    for (i = 0; i < s.length; i++)
//    {
//    	var c = s.charAt(i);

//      if (! (isDigit(c)  || (c=='-') || (c=='+') || (c=='(') || (c==')')))
//      return false;
//    }

    return true;
}

function remDbQ1 (s) {

               var strTemp="" ;

               if (s!=null)
               {
                    if (!s == "")
                    {


                        for (var i=0;i<s.length;i++)
                        {
                            if (s.charAt(i)=='/'  || s.charAt(i)=='-' || s.charAt(i)=='(' || s.charAt(i)==')'|| s.charAt(i)=='\\' || isAlphanumeric(s.charAt(i)))
                            {
                                strTemp = strTemp + s.charAt(i);
                            }
                            else
                            {

                                   strTemp = strTemp + " ";

                            }
                        }

                    }
                }
                return strTemp;
    }

function remDbQ2(s)
{
    var strTemp="" ;
    if (s!=null)
    {
        if (!s == "")
        {
            for (var i=0;i<s.length;i++)
            {
                if (s.charAt(i)=='.' || isAlphanumeric(s.charAt(i)))
                {
                    strTemp = strTemp + s.charAt(i);
                }
                else
                {
                    strTemp = strTemp + " ";
                }
            }// end of for
        } // end of if
     }// end of outer if
     return strTemp;
}

function remDbQFin (s) {

               var strTemp="" ;

               if (s!=null)
               {
                    if (!s == "")
                    {


                        for (var i=0;i<s.length;i++)
                        {
                            if (s.charAt(i)=='/'  || s.charAt(i)=='-' || isAlphanumeric(s.charAt(i)))
                            {
                                strTemp = strTemp + s.charAt(i);
                            }
                            else
                            {

                                   strTemp = strTemp + " ";

                            }
                        }// end of for

                    } // end of if
                }// end of outer if
                return strTemp;
    }


function reformat (s) {
    var arg;
    var sPos = 0;
    var resultString = "";

    for (var i = 1; i < reformat.arguments.length; i++) {
       arg = reformat.arguments[i];
       if (i % 2 == 1) resultString += arg;
       else {
           resultString += s.substring(sPos, sPos + arg);
           sPos += arg;
       }
    }
    return resultString;
}

function isvalidEmailChar (s)
{   var i;

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);

        if (! (isLetter1(c) || isDigit(c) || (c=='@') || (c=='.') || (c=='_') || (c=='-') || (c=='+')) ) {
        return false;
        }
    }

    return true;
}


function isEmail (s)
{
        if (isEmpty(s))
       if (isEmail.arguments.length == 1) return defaultEmptyOK;
       else return (isEmail.arguments[1] == true);

    if (isWhitespace(s)) return false;
    if (!isvalidEmailChar(s)) return false;

    atOffset = s.lastIndexOf('@');

    if ( atOffset < 1 )
        return false;
    else {
    dotOffset = s.indexOf('.', atOffset);

      if ( dotOffset < atOffset + 2 ||
         dotOffset > s.length - 2 ) {
         return false;
      }
   }
   return true;
}


function isValidIPAddress(s)
{
    var dots = 0;
    var validflg=true;
    if (isEmpty(s))
        return false;
    else
    {
        if(s.charAt(0)=='.')
        {
            validflg=false;
        }
        else
        {
            for(i=0; i< s.length;i++)
            {
                if(s.charAt(i)=='.')
                    dots++;
                else if(s.charAt(i)<'0' || s.charAt(i)>'9')
                {
                    validflg=false;
                    break;
                }
            }
            if(dots!=3)
                validflg=false;
        }

        if(validflg)
        {
            lvIP 	= new Array(4);
            lvIP=s.split('.');
            for(k=0;k<4;k++)
            {
                if( ( lvIP[k].length > 1  && lvIP[k].charAt(0)=='0' ) || parseInt(lvIP[k]) > 255 )
                {
                    validflg = false;
                    break;
                }
            }
        }
        if(validflg)
        {
            if(s=="255.255.255.255" || s=="0.0.0.0" || s=="127.0.0.1")
                validflg = false;
        }
        if(validflg) return true;
        else return false;
    }
}



function isIntegerInRange (s, a, b)
{   if (isEmpty(s))
       if (isIntegerInRange.arguments.length == 1) return defaultEmptyOK;
       else return (isIntegerInRange.arguments[1] == true);

    if (!isInteger(s, false)) return false;

    var num = parseInt (s,10);
    return ((num >= a) && (num <= b));
}

function isYear (s)
{   if (isEmpty(s))
       if (isYear.arguments.length == 1) return defaultEmptyOK;
       else return (isYear.arguments[1] == true);
    if (!isNonnegativeInteger(s)) return false;
    return ((s.length == 2) || (s.length == 4));
}

function isMonth (s)
{   if (isEmpty(s))
       if (isMonth.arguments.length == 1) return defaultEmptyOK;
       else return (isMonth.arguments[1] == true);
    return isIntegerInRange (s, 1, 12);
}


function isDay (s)
{   if (isEmpty(s))
       if (isDay.arguments.length == 1) return defaultEmptyOK;
       else return (isDay.arguments[1] == true);
    return isIntegerInRange (s, 1, 31);
}


function daysInFebruary (year)
{
    return ( ((year % 4 == 0) && (!(year % 100 == 0) || (year % 400 == 0) ) ) ? 29 : 28 );
}

function prompt (s)
{   window.status = s
}


function promptEntry (s)
{   window.status = pEntryPrompt + s
}


function warnEmpty (theField, s)
{   theField.focus()
    alert(mPrefix + s + mSuffix)
    return false
}

function warnEmpty2 (theField, s)
{   theField.focus()
    alert(pPrefix2 + s )
    return false
}

function warnEmpty1 (theField, s)
{   theField.focus()
    theField.select()
    alert(mPrefix + s + mSuffix)
    return false
}

function warnInvalid (theField, s)
{   theField.focus()
    theField.select()
    alert(s)
    return false
}

function checkNumber (theField, emptyOK)
{   if (checkNumber.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    else if (!isSignedFloat(theField.value, false))
       return warnInvalid (theField, iNumber);
    else return true;
}


function checkInteger (theField, emptyOK)
{   if (checkInteger.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    else if (!isSignedInteger(theField.value, false))
       return warnInvalid (theField, iInteger);
    else return true;
}


function checkPositiveInteger (theField, emptyOK)
{   if (checkPositiveInteger.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    if (theField.value.substring(0,1)=="+")
       sNum = theField.value.substring(1);
    else
       sNum = theField.value;

    if (!isInteger(sNum, false))
       return warnInvalid (theField, iPositiveInteger);
    else return true;
}


function checkAlphabetic (theField, emptyOK)
{   if (checkAlphabetic.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    else if (!isAlphabetic(theField.value, false))
       return warnInvalid (theField, iAlphabetic);
    else return true;
}



function checkEmail (theField, emptyOK)
{   if (checkEmail.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    else if (!isEmail(theField.value, false))
       return warnInvalid (theField, iEmail);
    else return true;
}



function checkYear (theField, emptyOK)
{   if (checkYear.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    if (!isYear(theField.value, false))
       return warnInvalid (theField, iYear);
    else return true;
}


function checkMonth (theField, emptyOK)
{   if (checkMonth.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    if (!isMonth(theField.value, false))
       return warnInvalid (theField, iMonth);
    else return true;
}


function checkDay (theField, emptyOK)
{   if (checkDay.arguments.length == 1) emptyOK = defaultEmptyOK;
    if ((emptyOK == true) && (isEmpty(theField.value))) return true;
    if (!isDay(theField.value, false))
       return warnInvalid (theField, iDay);
    else return true;
}

function isCarteBlanche(cc)
{
  return isDinersClub(cc);
}

function toFloatValue(field, x)
{
    if ((x!=null) && (x!=""))
    {
        x=stripInitialEndingWhitespace(x)

        if(ValidAmount(x) == true)
        {

        if(x.length!=0 && isFloat(x))
        {
          var ind = x.indexOf(".")
          if(ind==0)
          {
            x="0"+ x
                ind = x.indexOf(".")
          }
          if((x.length - ind) > 3)
          {
            var decVal = Math.round(x*100)/100
            x = decVal.toString()
            ind = x.indexOf(".")
          }
          ind = x.indexOf(".")
          if(ind < 0)
          {
            x= x +".00"

          }
          else if( (x.length - ind) == 1)
          {
            x= x +"00"

          }
          else if( (x.length - ind) == 2)
          {
            x= x +"0"

          }
        }

        }
    }
        return x
}

function ValidAmount(s)
{
  var l = s.length
  var i = s.indexOf(".")
  var str1 = "";
  var str2 = "";
  if(i != -1)
  {
    str1 = s.substring(0,i)
    str2 = s.substring(i+1,l)
  }
  else
  {
    str1 = s;
    str2 = "";
  }

  if(str1.length>12||str2.length>4) return false;

  return true;

}

function ValidAmount(s,ds)
{
  var l = s.length
  var i = s.indexOf(ds)
  var str1 = "";
  var str2 = "";
  if(i != -1)
  {
    str1 = s.substring(0,i)
    str2 = s.substring(i+1,l)
  }
  else
  {
    str1 = s;
    str2 = "";
  }

  if(str1.length>12||str2.length>4) return false;

  return true;

}

function isValidAmount(s)
{
    if (isNaN(parseInt(s))) return false;
  if (parseInt(s)< 0 ) return false;
  for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);
        if (!isDigit(c)) return false;
    }
  return true;

}



function checkFields(theForm) {
  clientOK = false;
  returnValue = true;

  if ( (navigator.appName.indexOf("Microsoft")!=-1) && (navigator.appVersion.indexOf("4.")!=-1) ) {
    undef = void 0;
    clientOK = true;
  } else if ( (navigator.appName.indexOf("Netscape")!=-1) && ( (navigator.appVersion.indexOf("4.")!=-1) || (navigator.appVersion.indexOf("3.")!=-1) )) {
    undef = "undefined";
    clientOK = true;
  }

  if (clientOK) {

    for (i=0; i<theForm.elements.length; i++) {
      e = theForm.elements[i]
      if ( ((e.type=="text") || (e.type=="textarea") || (e.type=="password")) && e.required && (e.value=="")) {
        returnValue = false
        break;
      }
    }

    if (!returnValue) {
      alert("Form not submitted - please enter a value for this field")
      e.focus()

    } else {
      for (i=0; i<theForm.elements.length; i++) {
        e = theForm.elements[i]
        if ( (e.type=="text") || (e.type=="textarea") || (e.type=="password")) {
          if ( undef != e.onchange ) {
        returnValue = e.onchange();
        if (!returnValue)
              break;
      }
        }
      }
    }
  }
  return returnValue;
}

//function openAttachWindow(mode,fileid,dockey)
//{
//			theURL  = '/AttachFileServlet?mode='+mode+'&AttachEncStr='
//											+fileid+'&AttachDocKey='+dockey;
//			winName = 'Attach';
//			features='toolbar = no ,scrollbars = yes ,personalbar=no, location=no,resizable=yes,width=400,height=400';
//			window.open(theURL,winName,features);
//}


function isInvalidDirChar(s)
{
    if(s==":"||s=="*"||s=="?"||s=="\""||s=="<"||s==">"||s=="|") return true;
}

function isInvalidDirNameSeq(s)
{
    if(s=="//" || s=="\\\\" ||  s==".."  || s=="\\/"|| s=="/\\") return true;
}

function isInvalidFileChar(s)
{
    if(s==":"||s=="*"||s=="?"||s=="\""||s=="<"||s==">"||s=="|" ||s=="\\"||s=="/" ) return true;
}



function isValidDirName (s) {
    var i;
    if (isEmpty(s))
       if (isAlphanumeric.arguments.length == 1) return defaultEmptyOK;
       else return (isAlphanumeric.arguments[1] == true);

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);

        if(isInvalidDirChar(c)) return false;
        if(i < s.length-1)
        {
            if(isInvalidDirNameSeq(s.substring(i,i+2)))
            {
                return false;
            }
        }

    }
    return true;
}

function isValidFileName (s) {
    var i;
    if (isEmpty(s))
       if (isAlphanumeric.arguments.length == 1) return defaultEmptyOK;
       else return (isAlphanumeric.arguments[1] == true);

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);

        if(isInvalidFileChar(c)) return false;
    }
    return true;
}

//This function is used to set the maxlength of  textarea fields.
function textCounter(field,maxlimit) {

if(field.value.length > maxlimit) // if too long...trim it!
{
field.value = field.value.substring(0, maxlimit);
}
// otherwise, update 'characters left' counter
else
{}
}


// Validates a Date String against Mask.
// Return Date if valid else return null
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
  if(asDate.length < 6 ) return null;

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
        if(asDate == null) return null;
    }

    //check all separators are Ok
    if(asDate.substring(liMaxVal-1,liMaxVal)!=lsSep) return null;
    if(asDate.substring(liMedVal-1,liMedVal)!=lsSep) return null;

    // check all are numbers
    if(!isInteger(asDate.substring(liDayPos,liDayPos+2))) 		return null;
    if(!isInteger(asDate.substring(liMonthPos,liMonthPos+2))) return null;
    if(!isInteger(asDate.substring(liYearPos,liYearPos+4))) 	return null;

    liDay		= parseInt(asDate.substring(liDayPos,liDayPos+2),10);
    liMonth	= parseInt(asDate.substring(liMonthPos,liMonthPos+2),10);
    liYear	= parseInt(asDate.substring(liYearPos,liYearPos+4),10);

    // Validate all entries
    if(!validateMonth(liMonth)) 						return null;
    if(!validateYear(liYear)) 							return null;
    if(!validateDay(liDay,liMonth,liYear))	return null;

    return new Date(liYear,liMonth-1,liDay);
}

function validateDay(aiDay,aiMonth,aiYear)
{
    if(isNaN(aiDay))	return false;
    if(aiDay > daysInMonth[aiMonth] || aiDay<1) return false;
    if ((aiMonth == 2) && (aiDay > daysInFebruary(aiYear))) return false;
    return true;
}

function validateMonth(aiMonth)
{
    if(isNaN(aiMonth))return false;
    if(aiMonth <1 || aiMonth >12 ) return false;
    else return true;
}
function validateYear(aiYear)
{
    if(isNaN(aiYear))return false;
    if(aiYear <1970) return false;
    else return true;
}

// Returns the Maximum of the parameters
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
    liPos			= asDate.indexOf(asSep,liPos+1);
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


function isDateDiff(aDate1,aDate2)
{
    if(aDate1==null && aDate2 != null) return true;
    if(aDate1!=null && aDate2 == null) return true;
    if(aDate1==null && aDate2 == null) return false;

    var liDay1 		= aDate1.getDate();
    var liMonth1 	= aDate1.getMonth();
    var liYear1		= aDate1.getYear();
    var liDay2		= aDate2.getDate();
    var liMonth2  = aDate2.getMonth()
    var liYear2   = aDate2.getYear();


    var liYearDiff	= liYear1 	- liYear2;
    var liMonDiff		= liMonth1	- liMonth2;
    var liDayDiff		= liDay1 		- liDay2;

    if(liYearDiff!=0 || liMonDiff != 0 || liDayDiff != 0) return true;
    else
        return false;
}

function getDateDiffInDays(aDate1,aDate2)
{
    if(aDate1==null || aDate2 == null)
    {
        return 0;
    }


    var liMs1 = aDate1.getTime();
    var liMs2 = aDate2.getTime();
    var liDays;

    liDays = (Math.abs(liMs1-liMs2))/(60*60*24*1000);
    return Math.round(liDays);
}

function addDays(aDate1,aiDays)
{
    if(aDate1==null) return null;
    lDate = new Date();
    lDate.setTime(aDate1.getTime()+aiDays*60*60*24*1000);
    return lDate;
}

function isFirstDateGreater(aDate1, aDate2)
{
    if(aDate1==null || aDate2 == null)
    {
        return false;
    }


    var liMs1 = aDate1.getTime();
    var liMs2 = aDate2.getTime();
    if(liMs1 > liMs2) return true;
    else return false;
}

function isFirstDateGreaterOrEqual(aDate1, aDate2)
{
    if(aDate1==null || aDate2 == null)
    {
        return false;
    }

    var liMs1 = aDate1.getTime();
    var liMs2 = aDate2.getTime();
    if(liMs1 >= liMs2) return true;
    else return false;
}

function isFirstDateLesser(aDate1, aDate2)
{
    if(aDate1==null || aDate2 == null)
    {
        return false;
    }

    var liMs1 = aDate1.getTime();
    var liMs2 = aDate2.getTime();
    if(liMs1 < liMs2) return true;
    else return false;
}

function getDateStr(aDate,asMask)
{
  liDayPos		=	asMask.indexOf("dd",0);
  liMonthPos	=	asMask.indexOf("MM",0);
  liYearPos		=	asMask.indexOf("yyyy",0);

    liMaxVal=maxVal(liDayPos,liMonthPos,liYearPos);
    liMedVal=medVal(liDayPos,liMonthPos,liYearPos);
    lsSep = asMask.substring(liMaxVal-1,liMaxVal);
    lsDay		=	aDate.getDate();
    lsMonth	=	aDate.getMonth()+1;
    lsYear	=	aDate.getYear();

    if (lsYear > 69  && lsYear < 100) lsYear="19"+lsYear;
    else if(lsYear.length==2)  lsYear="20"+lsYear;

    if(lsDay<10) lsDay="0"+lsDay;
    if(lsMonth<10) lsMonth="0"+lsMonth;

    lsDate = "";
    if(liYearPos !=liMaxVal && liYearPos !=liMedVal)
        lsDate = lsDate+lsYear;
    if(liMonthPos !=liMaxVal && liMonthPos !=liMedVal)
        lsDate = lsDate+lsMonth;
    if(liDayPos !=liMaxVal && liDayPos !=liMedVal)
        lsDate = lsDate+lsDay;

    lsDate = lsDate+lsSep;
    if(liYearPos ==liMedVal)
        lsDate = lsDate+lsYear;
    if(liMonthPos ==liMedVal)
        lsDate = lsDate+lsMonth;
    if(liDayPos ==liMedVal)
        lsDate = lsDate+lsDay;

    lsDate = lsDate+lsSep;
    if(liYearPos ==liMaxVal)
        lsDate = lsDate+lsYear;
    if(liMonthPos ==liMaxVal)
        lsDate = lsDate+lsMonth;
    if(liDayPos ==liMaxVal)
        lsDate = lsDate+lsDay;

    return lsDate;
}

function fnMakeDialog(lsMessage,liOption, liLocale)
{
    if (window.showModalDialog)
    {

        var lsMsg = fnMakeDialog.arguments[0];
        var lsConfirm = 0;
        laArray = new Array(3);
        laArray[0] = lsMsg;
        laArray[1] = lsConfirm;
        laArray[2] = fnMakeDialog.arguments[1];

        if (fnMakeDialog.arguments.length == 4)
            laArray[3] = fnMakeDialog.arguments[3];

        if (fnMakeDialog.arguments[2] == "zh_TW")
            window.showModalDialog('/forecast/docroot/utl/DialogBox_zh_TW.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')
        else
        if (fnMakeDialog.arguments[2] == "zh_CN")
            window.showModalDialog('/forecast/docroot/utl/DialogBox_zh_CN.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')
        else
        if (fnMakeDialog.arguments[2] == "en")
            window.showModalDialog('/forecast/docroot/utl/DialogBox_en.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')
        else
            window.showModalDialog('/forecast/docroot/utl/DialogBox.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')

        return (laArray[1]);
    }
    else
    return (confirm(lsMessage));
}

function fnMakeAlert(liLocale,lsMessage)
{
    if (window.showModalDialog)
    {

        var lsMsg = fnMakeAlert.arguments[1];
        var lsConfirm = 0;
        laArray = new Array(3);
        laArray[0] = lsMsg;
        laArray[1] = lsConfirm;

        if (fnMakeAlert.arguments.length == 3)
            laArray[2] = fnMakeAlert.arguments[2];

        if (fnMakeAlert.arguments[0] == "zh_TW")
            window.showModalDialog('/forecast/docroot/utl/AlertBox_zh_TW.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')
        else
        if (fnMakeAlert.arguments[0] == "zh_CN")
            window.showModalDialog('/forecast/docroot/utl/AlertBox_zh_CN.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')
        else
        if (fnMakeAlert.arguments[0] == "en")
            window.showModalDialog('/forecast/docroot/utl/AlertBox_en.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')
        else
            window.showModalDialog('/forecast/docroot/utl/AlertBox.html',laArray,'dialogHeight="150px";dialogWidth="300px";status="no";help="no";')

        return (laArray[1]);
    }
    else
    return (confirm(lsMessage));
}

// validates the grouping separator and decimal separator
// returns true if the separator is OK

function isValidSeparator(lsSeparator)
{
    var validated = true;
    if(lsSeparator=="-"  || lsSeparator=="+" || lsSeparator=="*" || lsSeparator=="\'" || lsSeparator=="\"" || lsSeparator=="\\"
    || lsSeparator=="/"  || lsSeparator=="%" || lsSeparator=="!" || lsSeparator=="@"  || lsSeparator=="#"  || lsSeparator=="&"
    || lsSeparator=="("  || lsSeparator==")" || lsSeparator==";" || lsSeparator=="["  || lsSeparator=="]"  || lsSeparator=="|"
    || lsSeparator=="{"  || lsSeparator=="}"  )
    {
        validated = false;
    }
    else
    {
        validated = true;
    }
    return validated;
}

// Validates Date Mask
// returns true if mask is ok

function getActualFloat(displayedFloat,ds)
{
    var lFloatLen,lFloatInd,lFloatStr1,lFloatStr2,lFloatStr;
    var lDisplayedFloat = displayedFloat+"";
    eval("lFloatInd = lDisplayedFloat.indexOf(ds)");
    if(lFloatInd != -1)
    {
        lFloatLen = lDisplayedFloat.length;
        eval("lFloatStr1 = lDisplayedFloat.substring(0,lFloatInd)");
        eval("lFloatStr2 = lDisplayedFloat.substring(lFloatInd+1,lFloatLen)");
        lFloatStr = lFloatStr1+'.'+lFloatStr2;
    }
    else
    {
        lFloatStr = lDisplayedFloat;
        lFloatStr1 = " ";
        lFloatStr2 = " ";
    }
    return lFloatStr;
}

function getActualFloat(displayedFloat,ds,gs)
{
    var lFloatLen,lFloatInd,lFloatStr1,lFloatStr2,lFloatStr;
    var lDisplayedFloat = displayedFloat+"";
    eval("lFloatInd = lDisplayedFloat.indexOf(ds)");
    if(lFloatInd != -1)
    {
        lFloatLen = lDisplayedFloat.length;
        eval("lFloatStr1 = lDisplayedFloat.substring(0,lFloatInd)");
        eval("lFloatStr2 = lDisplayedFloat.substring(lFloatInd+1,lFloatLen)");
        lFloatStr = lFloatStr1+'.'+lFloatStr2;
    }
    else
    {
        lFloatStr = lDisplayedFloat;
        lFloatStr1 = " ";
        lFloatStr2 = " ";
    }
  //Now replace the grouping seperator if any.
  var work = lFloatStr;
  var ind = 0;
  var next = 0;
  while ((ind = work.indexOf(gs,next)) >= 0)
  {
        lFloatStr = lFloatStr.substring(0,ind) + lFloatStr.substring(ind+gs.length,lFloatStr.length);
        work = work.substring(0,ind) + work.substring(ind+gs.length,work.length);
        next = ind;
        if (next >= work.length)
        {
            break;
        }
  }
    return lFloatStr;
}

function fnValidateDateMask(asMask)
{
    if(asMask.length !=10)
    {
        return false;
    }

    // first find year
    var liYearIndex = asMask.indexOf("yyyy");

    if(liYearIndex < 0 ||
        (liYearIndex !=0 && liYearIndex !=3 && liYearIndex !=6))
    {
        return false;
    }

    // ok found proper year store position
    var liYearPos = liYearIndex/3;
    var liPos1; // possible position of Month/Day
    var liPos2;// possible position of Month/Day
    var liSepPos1; // possible position of separator
    var liSepPos2; // possible position of separator

    // determine possible positions of Month and Day
    if(liYearPos==0)
    {
        liPos1=5;liPos2=8;liSepPos1=4;liSepPos2=7;
    }
    else if (liYearPos==1)
    {
        liPos1=0;liPos2=8;liSepPos1=2;liSepPos2=7;
    }
    else if (liYearPos==2)
    {
        liPos1=0;liPos2=3;liSepPos1=2;liSepPos2=5;
    }

    // now find month
    var liMonthIndex = asMask.indexOf("MM");
    if(liMonthIndex < 0 ||
        (liMonthIndex !=liPos1 && liMonthIndex !=liPos2))
    {
        return false;
    }
    // now find day
    var liDayIndex = asMask.indexOf("dd");
    if(liDayIndex < 0 ||
        (liDayIndex !=liPos1 && liDayIndex !=liPos2))
    {
        return false;
    }

    // now check for separators!
    var asSep1= asMask.substring(liSepPos1,liSepPos1+1);
    var asSep2= asMask.substring(liSepPos2,liSepPos2+1);

    if(!(asSep1=="/" || asSep1=="-")||
         !(asSep2=="/" || asSep2=="-") || (asSep2!=asSep1))
    {
        return false;
    }
    return true;
}


//Added by Charles -----for remove status ---Begin
function getSelectedItems(theForm,separator){
    //var theForm = eventObj.form;
    //alert(theForm.type);
    var selectedItem="";
    for (var i=0;i<theForm.elements.length; i++){
        if((theForm.elements[i].type == "checkbox")&&(theForm.elements[i].checked)){
                selectedItem += theForm.elements[i].value + separator;
        }
    }
    //alert("Selected item is :" + selectedItem);
    return selectedItem;
}

function getSelectedCounts(theForm){
    var count = 0;
    for (var i=0;i<theForm.elements.length; i++){
        if((theForm.elements[i].type == "checkbox")&&(theForm.elements[i].checked)){
                count = count + 1;
        }
    }
    return count;
}

function getSelectedIndex(theForm){
    var index = -1;
    for (var i=0;i<theForm.elements.length; i++){
        if((theForm.elements[i].type == "checkbox")&&(theForm.elements[i].checked)){
                index = theForm.elements[i].checkedValue ;
        }
    }
    return index;
}

function isDate(asDate)
{
    if (isEmpty(asDate)) return defaultEmptyOK;
        var asMask = dateMask;
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
    if(!validateMonth(liMonth)) 						return false;
    if(!validateYear(liYear)) 							return false;
    if(!validateDay(liDay,liMonth,liYear))	return false;

    //return new Date(liYear,liMonth-1,liDay);
    return true;
}
var maxPeriodValue = 53;
function isPeriod(s)
{
    if (!isNonnegativeInteger(s)) return false;
    return isIntegerInRange (s, 1, maxPeriodValue);
}
function isPastYear(s)
{
    if (s.length != 4) return false;
    if (!isNonnegativeInteger(s)) return false;
    var ldate = new Date();
    var lyear = ldate.getYear();
    return (lyear >=s);
}
function isPositiveDouble(s)
{
    s +=""; // convert numbet to string
    if (s.charAt(0) == "-") return false;
    if((s.split(DecimalSeparator))[0].length > lengthOfDouble) return false;
    if (isInteger(s)) return true;
    if (isFloat(s,DecimalSeparator)) return true;
    return false;
}

function isDecimal(s)
{
    if(!isPositiveDouble(s)||parseFloat(s)>1)
        return false;
    return true;
}

//var checkFunctions = new Array();
//checkFunctions["Email"] = "isEmail";
//checkFunctions["Integer"] = "isInteger";
//checkFunctions["Date"] = "isDate";
//checkFunctions["Id"] = "isValidId";
//checkFunctions["Float"] = "isFloat";

function fn_checkForm(formObj){

    var checkFunc = "";
    for (var i=0;i<formObj.elements.length; i++)
    {

        if(formObj.elements[i].type == "text")
        {

            var lvalue = stripInitialEndingWhitespace(formObj.elements[i].value);
            //lvalue = replaceInString(lvalue,"'","\'");
            //lvalue = replaceInString(lvalue,"\"","\"");

            var lvalueType = formObj.elements[i].valueType;
            var laltMsg = formObj.elements[i].altMsg;
            var isEmpty = formObj.elements[i].isEmpty;
                        if(typeof(isEmpty) == 'undefined' && typeof(lvalueType) == 'undefined')
                        {
                            defaultEmptyOK = false;
                        }
                        else
                        {
                            if(typeof(isEmpty) != 'undefined' && isEmpty == "Y") // set default empty
                                            defaultEmptyOK = true;
                            else{
                                            defaultEmptyOK = false;
                                            if(isEmptyValue(lvalue))
                                            {
                                                alert(eval(laltMsg));
                                                formObj.elements[i].focus();
                                                return false;
                                            }
                            }
                            var isValid = false;
                            if(typeof(lvalueType) != 'undefined' && lvalueType != "")
                            {
                                            //checkFunc = checkFunctions[lvalueType];
                                            //if(typeof(checkFunc)=='undefined')
                                            //{
                                            //		alert("Can't fonud the check function for \"" + lvalueType + "\" value type! ");
                                            //		return false;
                                            //}
                                            //checkFunc = checkFunc + "(\"" + lvalue + "\")";
                                            if(lvalueType == "Email")
                                            {
                                                     isValid = isEmail(lvalue);
                                            }else if(lvalueType == "Integer")
                                            {
                                                isValid = isInteger(lvalue);
                                            }else if(lvalueType == "PInteger")
                                            {
                                                isValid = isPositiveInteger(lvalue);
                                            }else if(lvalueType == "Date")
                                            {
                                                isValid = isDate(lvalue);
                                            }else if(lvalueType == "Id")
                                            {
                                                isValid = isValidId(lvalue);
                                            }else if(lvalueType == "Float")
                                            {
                                                isValid = isFloat(lvalue);
                                            }else if(lvalueType == "Period")
                                            {
                                                isValid = isPeriod(lvalue);
                                            }else if(lvalueType == "PastYear")
                                            {
                                                isValid = isPastYear(lvalue);
                                            }else if(lvalueType == "PositiveDouble")
                                            {
                                                isValid = isPositiveDouble(lvalue);
                                            }

                                            //isValid = eval(checkFunc);

                                            if(!isValid){
                                                    alert(eval(laltMsg));
                                                    formObj.elements[i].focus();
                                                    return false;
                                            }
                            }
                        }
        }
    defaultEmptyOK = false;
    }
    return true;
}


function fncallCalendar(eventObj)
{
    var HostId = eventObj.HostId;
    fnCalendar( document.all[HostId],Month_Array,dateMask);
}

function fnButtonHelp(eventObj)
{
    var HostId = eventObj.HostId;
    alert(HostId + ":" + eventObj.HelpType);
    if (eventObj.HelpType == "ITEM")
    {
            alert("type:" + eventObj.HelpType);
            var lsUrl = "/forecast/ControlServlet?ScreenId=UTL003&ActionId=DISPATCH";
            winOpenedArr = new Array();
            winName='childjsp';
            winOpenedArr[0] = openThisWindow(lsUrl,winName,winOpenedArr,'1b') ;

    }
/*
    var lsUrl = "/forecast/ControlServlet?HdContent=BUY&Actions=ADD&ActiveOnly=Y&ActionId=DISPATCH&ScreenId=SEC009";
    winName='childjsp';
    winOpenedArr[0] = openThisWindow(lsUrl,winName,winOpenedArr,'1b') ;
*/
}

function getCommonUrl(parameters)
{
    var lsUrl= "/forecast/ControlServlet?" + parameters;
    return lsUrl;
}

function clearFormText(formObj)
{
    for (var i=0;i<formObj.elements.length; i++)
    {
        if(formObj.elements[i].type == "text")
        {
            formObj.elements[i].value ="";
        }else if(formObj.elements[i].type == "select-one")
        {
            formObj.elements[i].selectedIndex = 0;
        }
    }
}

function stripFormTextWhitespace(formObj)
{
    for (var i=0;i<formObj.elements.length; i++)
    {
        if(formObj.elements[i].type == "text")
        {
            formObj.elements[i].value = stripInitialEndingWhitespace (formObj.elements[i].value);
        }
    }
}

//Added by Charles -----for remove status ---End
