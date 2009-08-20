/***********************************************
*************  DYNAMIC CALENDAR  **************
************************************************/

/*  This is a modular approach to create and use dynamic calendar in HTML pages.
*   This application is supported by Netscape navigator 4.0 and above as well as IE4.0 and above.
*/

/*  One can use this application in HTML pages by calling a function "makeCal(arguments)"
*   with at least three mandatory arguments, first argument is the reference to the positioned
*   block on the screen where the calendar should appear(use <div>...</div>tags for creating positioned blocks)
*   and the second argument is the reference to the text box object where the selected date should appear.
*   The third argument is for language support for months

*   Other than these three mandatory arguments, one can specify three more arguments out of
*   which first two are numbers indicate the relative left and top position for the calendar in the positioned block,
*   and the third one is the date-format string in which you expect the date should be populated in the text box.
*   The sequence " left-position > top-position > date-format " must be followed.
*   You must either ignore both  left-position and top-position parameters or specify values for both.
*   All these three non-mandatory parameters could be specified in the above mentioned
*   order only after the mandatory parameters.
*
*   Important :  YOU MUST INCLUDE THIS FILE (calendar.js) IN YOUR HTML APPLICATION PRIOR TO CALL THE FUNCTION  "
*   makeCal(arguments) "
*/

/*
***********************************************
******   Example ( how to use in your application) : *******
***********************************************
 Note : assumed that the file "calendar.js" is copied to the same directory where the HTML page resides.

<html>
<style type="text/css">
#divblock {
position:absolute;
visibility:hidden;
top:0;
left:0;
}
</style>

<head>
<title>DYNAMIC CALENDAR</title>
<script src="calendar.js"> </script>
</head>

<body bgcolor="#ffffff">
<div id="divblock"> </div>
<form name="frmm1">
  <p>Date&nbsp; : &nbsp;<input type="text" name="enterdate" value="">
<input type="button" value="Calendar" name="btn" onclick="javascript: if(document.all) makeCal(document.all.divblock, window.document.frmm1.enterdate,Month_Array,10,10,'dd-mm-yyyy'); else makeCal(document.layers.divblock, window.document.frmm1.entereddate,Month_array,10,10,'dd-mm-yyyy') "></p>
</form>
</body>
</html>

*/


/******************************
   *****       START    ********
 ******************************/
var Month_Array = new Array("\u4e00\u6708","\u4e8c\u6708","\u4e09\u6708","\u56db\u6708","\u4e94\u6708","\u516d\u6708","\u4e03\u6708","\u516b\u6708","\u4e5d\u6708","\u5341\u6708","\u5341\u4e00\u6708","\u5341\u4e8c\u6708");

//if(!document.layers)
//tcal_monthArray = new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//else
//tcal_monthArray = new Array(" &nbsp;January"," February","&nbsp;&nbsp;&nbsp; March","&nbsp;&nbsp;&nbsp;&nbsp; April","&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;May","&nbsp;&nbsp;&nbsp;&nbsp; June","&nbsp;&nbsp;&nbsp;&nbsp; July","&nbsp;&nbsp;&nbsp; August","September","  October"," November"," December");
function longest()
{
	var max = tcal_monthArray[0].length;

	for (i=0; i < tcal_monthArray.length; i++)
	{
		if (tcal_monthArray[i].length > max)
			max = tcal_monthArray[i].length;
	}
	return max;
}

var img1 = new Image();
img1.src = "scrollleftarrow.gif";
var img2 = new Image();
img2.src = "scrollrightarrow.gif";
var img3 = new Image();
img3.src = "close.gif";

tcal_monthArray = new Array();
tcal_todayDate=new Date();
tcal_date=tcal_todayDate.getDate();
tcal_month=tcal_todayDate.getMonth();
tcal_year=tcal_todayDate.getYear();
tcal_dd=tcal_date;
tcal_mm=tcal_month;
tcal_yy=tcal_year;
tcal_mm1=tcal_month;
tcal_boolean="false";
function getCalValues(tcal_day,tcal_month,tcal_year,tcal_dateVar)
{

	tcal_day.selectedIndex=Number(tcal_dateVar.value.substr(0,2));
	tcal_month.selectedIndex=Number(tcal_dateVar.value.substr(2,2));
	tcal_year.selectedIndex=Number(tcal_dateVar.value.substr(6))+1;
	return;
}

var tcal_first=1;

if(tcal_year < 1900) tcal_year+= 1900;
tcal_yyyy1=tcal_year;
var tcal_noofcal=0;
var tcal_objj;
var tcal_prevobjj;
var tcal_rg1=3;
var tcal_rg2=0;
var tcal_highlight;
var tcal_targetlayer;
var tcal_targetobj;
var tcal_header = tcal_monthArray[tcal_month] + "<br>" + tcal_year;
tcal_dayarr = new Array(45);
var tcal_previndd = 0;

//start of function


function setDate(tcal_indd) {

	var tcal_dt = "";
	if(tcal_dayarr[tcal_indd] == " ") return false;
		if(document.layers)
		{
			if((tcal_highlight-10)%7 == 0)
			{
				tcal_targetlayer.document.layers.lay1.document.layers[tcal_highlight].bgColor="#9FB3CC";
			}
			else
			{
					tcal_targetlayer.document.layers.lay1.document.layers[tcal_highlight].bgColor="#DDEEFF";
			}

			if (tcal_isToday(tcal_previndd) == 1)
				tcal_targetlayer.document.layers.lay1.document.layers[tcal_highlight].bgColor="#CAD2D2";

			tcal_targetlayer.document.layers.lay1.document.layers[tcal_indd+10].bgColor="5478AA";
			tcal_highlight=tcal_indd+10;
		}

	else {
		if(tcal_rg1 != 3)
		{
			if(tcal_rg1==1)
				tcal_prevobjj.bgColor="#9FB3CC";
			else
				tcal_prevobjj.bgColor="#DDEEFF";

			if (tcal_isToday(tcal_previndd) == 1)
				tcal_prevobjj.bgColor="#CAD2D2";
		}
			tcal_objj.bgColor="5478AA";
			tcal_prevobjj=tcal_objj;
			tcal_rg1=tcal_rg2;
		 }


	//tcal_dt += tcal_monthArray[tcal_month] + " " + tcal_dayarr[tcal_indd] + ", " + tcal_year;
  tcal_dt =  setFormat(tcal_dayarr[tcal_indd], tcal_month, tcal_year);
	tcal_targetobj.value= tcal_dt;
 	//closecal();
 	tcal_previndd = tcal_indd;
	return;
}

function tcal_isToday(tcal_indd)
{
	var isToday = 0;
	if (tcal_dayarr[tcal_indd] == tcal_dd && tcal_month ==  tcal_mm && tcal_year == tcal_yy)
		isToday = 1;
	return isToday;
}

//end of function


function setcal(tcal_value) {

	if(tcal_value == 0) {
		if(tcal_month == 0) {
			tcal_year = tcal_year - 1; tcal_month = 11; }
		 else {
			  tcal_month = (tcal_month - 1); }
		 }
	else if(tcal_value==1) {
		  if(tcal_month == 11) {
 			tcal_year = tcal_year + 1; tcal_month = 0; }
		else {
			  tcal_month = (tcal_month + 1); }
		}
	else if(tcal_value==2) {
		tcal_year = tcal_year - 1; }
	else {
		tcal_year = tcal_year+1; }

	tcal_header = tcal_monthArray[tcal_month] + "<br>" + tcal_year;

	tcal_noofcal = tcal_noofcal - 1;
	tcal_boolean="true";
	makeCal(tcal_targetlayer,tcal_targetobj,tcal_monthArray);
	return true;
}



function closecal() {
	if(tcal_noofcal != 1) return;
	if(!document.layers){
		tcal_targetlayer.innerHTML = "";
		tcal_targetlayer.style.visibility = "hidden"
		}
	else {
		tcal_targetlayer.document.write("");
		tcal_targetlayer.document.close();
		tcal_targetlayer.visibility= "hidden"
		}
	tcal_noofcal -= 1;

	tcal_date=tcal_todayDate.getDate();
	tcal_month=tcal_todayDate.getMonth();
	tcal_year=tcal_todayDate.getYear();
	if(tcal_year < 1900) tcal_year+= 1900;
	tcal_header = tcal_monthArray[tcal_month] + "<br>" + tcal_year;
	tcal_first=1;
	tcal_lftval = 0;
	tcal_topval = 0;
	tcal_formatdate = "";
	tcal_boolean="false";
	self.close();
}

//start of function datecal()

function datecal(tcal_mon, tcal_yr) {
	var tcal_totdays;
	var tcal_p = 0;
	var tcal_len = 0;
	var tcal_cumdays = new Array("0","31","59","90","120","151","181","212","243","273","304","334","365");

		if(tcal_yr*10 + tcal_mon > 20001) {
			tcal_totdays = (tcal_yr - 2000)*365 + parseInt(tcal_cumdays[tcal_mon]) - parseInt(tcal_cumdays[2]);
			var tcal_ppp= Math.floor((tcal_yr*10+tcal_mon - 20002)/40);
			tcal_totdays += tcal_ppp;
			tcal_p = tcal_totdays%7;
			tcal_p = (tcal_p + 3)%7;

			tcal_len = tcal_cumdays[tcal_mon+1] - tcal_cumdays[tcal_mon];
				if(tcal_yr%4==0 && tcal_mon==1) tcal_len += 1; }

		else {
			  tcal_totdays = (2000 - tcal_yr)*365 + parseInt(tcal_cumdays[2]) - parseInt(tcal_cumdays[tcal_mon]);
			var tcal_ppp= Math.floor((20001 - (tcal_yr*10+tcal_mon) )/40);
			tcal_totdays += tcal_ppp;
			tcal_p = tcal_totdays%7;
			tcal_p =(9 - tcal_p)%7;
			tcal_len = tcal_cumdays[tcal_mon+1] - tcal_cumdays[tcal_mon];
				if(tcal_mon == 1 && tcal_yr%4 == 0) tcal_len += 1;}

					for(var tcal_i=0; tcal_i<45; tcal_i++) {
						if(tcal_i >= tcal_p && tcal_i < tcal_p+tcal_len) tcal_dayarr[tcal_i] =  (tcal_i - tcal_p + 1);
						else tcal_dayarr[tcal_i] = " ";
					  }
				if(tcal_first==1) {
					if(document.layers)
						tcal_highlight = tcal_p+tcal_date+9;
					else {
						tcal_highlight= tcal_p+tcal_date-1;
						  }
			}
}



//end of function datecal()



var tcal_lftval = 10;
var tcal_topval = 10;
var tcal_formatdate = "";

//Start of function makeCal


function makeCal(tcal_lay,tcal_targ,Month_Array) {

if(tcal_noofcal != 0) return false;
	 if(makeCal.arguments.length <3 || makeCal.arguments.length > 6) {
 		  alert("Argument mismatch !"); return; }
	else if(makeCal.arguments.length == 4) {
		     tcal_formatdate = makeCal.arguments[3]; }
	else if(makeCal.arguments.length == 5) {
		   tcal_lftval = parseInt( makeCal.arguments[3]);
		 tcal_topval = parseInt( makeCal.arguments[4]);
                        				}
	else if(makeCal.arguments.length == 6) {
		   tcal_lftval = parseInt( makeCal.arguments[3]);
		 tcal_topval = parseInt( makeCal.arguments[4]);
		  tcal_formatdate = makeCal.arguments[5]; }
  tcal_monthArray = Month_Array;
	tcal_header = tcal_monthArray[tcal_month] + "<br>" + tcal_year;
	if(tcal_mm1==tcal_month && tcal_yyyy1==tcal_year) tcal_first=1;
	tcal_noofcal += 1;

	tcal_targetlayer = tcal_lay;
		if(document.all){
			tcal_targetlayer.style.visibility = "visible" }
		else {
			tcal_targetlayer.visibility = "visible"
		}
	tcal_targetobj = tcal_targ;

	var tcal_day=0;
  var   tcal_calcon = "";

	datecal(tcal_month, parseInt(tcal_year));

	if(!document.layers) {
		tcal_calcon = "<table border=1 id='table1' cellpadding=0   bgcolor='C7D1E2' bordercolor='#0000FF' bordercolorlight='#7788AA' bordercolordark='#7788AA' width=" + ((longest()*8)+10) + " style='position:relative; top:"
		tcal_calcon += tcal_topval;
		tcal_calcon += "; left:"
		tcal_calcon += tcal_lftval;
		tcal_calcon += ";'><tr ><td style=' font-size:8pt;'  bgColor='#CAD2D2'><img name='left1' src='' height=13 width=17 onclick='setcal(0);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'></td>"
		tcal_calcon += "<td style=' font-size:8pt; '   align='center' bgcolor='#CAD2D2' colspan='5' onMousedown='startDrag()' ><font  color='DARKBLUE' ><b>"
		tcal_calcon += tcal_header;
		tcal_calcon += "</B></font></td><td style=' font-size:8pt;' bgColor='#CAD2D2'><img name='right1' src='' height=13 width=17 onclick='setcal(1);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'></td></tr>";


		tcal_calcon +="<tr><td style=' font-size:7pt;' align='center' bgcolor='#4466AA'><font  color='#ffffff'><strong>S</strong></font></td>";
		tcal_calcon +="<td style=' font-size:7pt;' align='center' bgcolor='#9FB3CC'><font  color='#444488'><strong>M</strong></font></td>";
		tcal_calcon +="<td style=' font-size:7pt;'  align='center' bgcolor='#9FB3CC'>&nbsp;<font  color='#444488'><strong>T</strong></font>&nbsp;</td>";
		tcal_calcon +="<td style=' font-size:7pt;'  align='center' bgcolor='#9FB3CC'><font color='#444488'><strong>W</strong></font></td>";
		tcal_calcon +="<td style=' font-size:7pt;' align='center' bgcolor='#9FB3CC' ><font  color='#444488'><strong>T</strong></font></td>";
		tcal_calcon +="<td style=' font-size:7pt;' align='center' bgcolor='#9FB3CC'><font  color='#444488'>&nbsp;<strong>F</strong>&nbsp;</font></td>";
		tcal_calcon +="<td style=' font-size:7pt;' align='center' bgcolor='#9FB3CC'><font  color='#444488'><strong>S</strong></font></td></tr>";


	for(var i=0; i<6; i++) {
		tcal_calcon +="<tr><td style=' font-size:8pt; font-weight:bold;' id='tab"
		tcal_calcon += tcal_day;
	if(tcal_day == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2' onclick='tcal_rg2=1; tcal_objj=this; setDate(";
	else
		tcal_calcon +="' align='center' bgcolor='#9FB3CC' onclick='tcal_rg2=1; tcal_objj=this; setDate(";
		tcal_calcon += tcal_day;
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day];
		tcal_calcon += "&nbsp;</td>";
		tcal_calcon +="<td style=' font-size:8pt;  font-weight:bold;' id='tab"
		tcal_calcon += (tcal_day+1);
	if((tcal_day+1) == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
	else
		tcal_calcon +="'  align='center' bgcolor='#DDEEFF' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
		tcal_calcon += (tcal_day + 1);
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day+1];
		tcal_calcon += "&nbsp;</td>";

		tcal_calcon +="<td style=' font-size:8pt;  font-weight:bold;' id='tab"
		tcal_calcon += (tcal_day+2);
	if((tcal_day+2) == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
	else
		tcal_calcon +="' align='center' bgcolor='#DDEEFF' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
		tcal_calcon += (tcal_day+2);
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day + 2];
		tcal_calcon += "&nbsp;</td>";
		tcal_calcon += "<td style=' font-size:8pt;  font-weight:bold;' id='tab"
		tcal_calcon += (tcal_day+3);
	if((tcal_day+3) == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
	else
		tcal_calcon +="'  align='center' bgcolor='#DDEEFF' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
		tcal_calcon += (tcal_day+3);
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day + 3];
		tcal_calcon += "&nbsp;</td>";
		tcal_calcon +="<td style=' font-size:8pt;  font-weight:bold;' id='tab"
		tcal_calcon += (tcal_day+4);
	if((tcal_day+4) == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2' tcal_prevobjj=this onclick='tcal_rg2=0; tcal_objj=this; setDate(";
	else
		tcal_calcon +="' align='center' bgcolor='#DDEEFF' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
		tcal_calcon += (tcal_day + 4);
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day + 4];
		tcal_calcon +="&nbsp;</td>";
		tcal_calcon +="<td style=' font-size:8pt;  font-weight:bold;' id='tab"
		tcal_calcon += (tcal_day+5);
	if((tcal_day+5) == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2'  onclick='tcal_rg2=0; tcal_objj=this; setDate(";
	else
		tcal_calcon +="'   align='center'  bgcolor='#DDEEFF'  onclick='tcal_rg2=0; tcal_objj=this; setDate(";
		tcal_calcon += (tcal_day+5);
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day + 5];
		tcal_calcon +="&nbsp;</td>";
		tcal_calcon +="<td style=' font-size:8pt;  font-weight:bold;' id='tab"
		tcal_calcon += (tcal_day+6);
	if((tcal_day+6) == tcal_highlight && tcal_first==1)
		tcal_calcon +="' align='center' bgcolor='CAD2D2' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
	else
		tcal_calcon +="'  align='center' bgcolor='#DDEEFF' onclick='tcal_rg2=0; tcal_objj=this; setDate(";
		tcal_calcon += (tcal_day+6);
		tcal_calcon += ")'>"
		tcal_calcon += tcal_dayarr[tcal_day + 6];
		tcal_calcon += "&nbsp;</td></tr>";

	tcal_day += 7;
	}

		tcal_calcon += "<tr><td style=' font-size:8pt;' bgColor='#CAD2D2'><img name='left2' src='' height=13 width=19 onclick='setcal(2);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'></td><td style=' font-size:8pt;' align='center' bgcolor='#CAD2D2' colspan='5'>"
		tcal_calcon += "<img name='close' src='' height=13 width=15 onclick='closecal()'></td><td style=' font-size:8pt;' bgColor='#CAD2D2'><img name='right2' src='' height=13 width=19 onclick='setcal(3);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'></td></tr></table>";
	}

else
	{
    tcal_calcon = "";
	  tcal_calcon = "<layer   name='lay1' bgColor='#ffffff' position='relative' top='"
		tcal_calcon += tcal_topval;
		tcal_calcon += "' left='"
		tcal_calcon += tcal_lftval;
		tcal_calcon += "'  height='162'  >";
		tcal_calcon += "<layer name='leftlay1' bgColor='#CAD2D2' position=relative height=17px width=17px top=3px left=3px onfocus='setcal(0);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'><img name='left1' src='' height=17 width=17></layer>"
		tcal_calcon += "<layer name='headerlay' position=relative height=17px width=93px top=3px left=22px"
		tcal_calcon += " align='center' bgcolor='#DDEEFF' onFocus='startDrag()'><font color='#cc0000'  POINT-SIZE=9>&nbsp;"
		tcal_calcon += tcal_header;

		tcal_calcon += "</font></layer>"
		tcal_calcon += "<layer name='rightlay1' position=relative bgColor='#CAD2D2' height=17px width=17px top=3px left=117px onfocus='setcal(1);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'><img name='right1' src='' height=17 width=17></layer>"

		tcal_calcon += "<layer   position=relative height=8px width=17px top=22px left=3px"
		tcal_calcon += " bgcolor='#4466AA'><font  POINT-SIZE=9 color='#eeee00'><b>&nbsp;S</b></font></layer>"
		tcal_calcon += "<layer   position=relative height=8px width=17px top=22px left=22px"
		tcal_calcon += " bgcolor='#9FB3CC'><font  POINT-SIZE=9 color='#444488'><b>&nbsp;M</b></font></layer>"
		tcal_calcon += "<layer   position=relative height=8px width=17px top=22px left=41px"
		tcal_calcon += " bgcolor='#9FB3CC'><font  POINT-SIZE=9 color='#444488'><b>&nbsp;T</b></font></layer>"
		tcal_calcon += "<layer   position=relative height=8px width=17px top=22px left=60px"
		tcal_calcon += " bgcolor='#9FB3CC'><font  POINT-SIZE=9 color='#444488'><b>&nbsp;W</b></font></layer>"
		tcal_calcon += "<layer   position=relative height=8px width=17px top=22px left=79px"
		tcal_calcon += " bgcolor='#9FB3CC'><font  POINT-SIZE=9 color='#444488'><b>&nbsp;T</b></font></layer>"
		tcal_calcon += "<layer  position=relative height=8px width=17px top=22px left=98px"
		tcal_calcon += " bgcolor='#9FB3CC'><font  POINT-SIZE=9 color='#444488'><b>&nbsp;&nbsp;F</b></font></layer>"
		tcal_calcon += "<layer   position=relative height=8px width=17px top=22px left=117px"
		tcal_calcon += " bgcolor='#9FB3CC'><font  POINT-SIZE=9 color='#444488'><b>&nbsp;S</b></font></layer>"

	for(var i=0; i<6; i++) {

		tcal_calcon += "<layer   position=relative height=8px width=17px bgcolor='#9FB3CC' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon += 3;
		tcal_calcon += " onfocus=' setDate(";
		tcal_calcon += tcal_day;
		tcal_calcon += "); return false;'><font  POINT-SIZE=9><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day];
		tcal_calcon += "</b></font></layer>";

		tcal_calcon +="<layer   position=relative height=8px width=17px bgcolor='#DDEEFF' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon += 22;
		tcal_calcon += " onfocus=' setDate(";
		tcal_calcon += (tcal_day+1);
		tcal_calcon += "); return false;'><font  POINT-SIZE=9><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day+1];
		tcal_calcon += "</b></font></layer>";

		tcal_calcon +="<layer   position=relative height=8px width=17px bgcolor='#DDEEFF' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon += 41;
		tcal_calcon += " onfocus=' setDate(";
		tcal_calcon += (tcal_day+2);
		tcal_calcon += "); return false;'><font  POINT-SIZE=9><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day + 2];
		tcal_calcon += "</b></font></layer>";
		tcal_calcon +="<layer   position=relative height=8px width=17px bgcolor='#DDEEFFC' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon += 60;
		tcal_calcon += " onfocus=' setDate(";
		tcal_calcon += (tcal_day+3);
		tcal_calcon += "); return false;'><font  POINT-SIZE=9><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day + 3];
		tcal_calcon +="</b></font></layer>";
		tcal_calcon +="<layer   position=relative height=8px width=17px bgcolor='#DDEEFF' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon +=79;
		tcal_calcon += " onfocus=' setDate(";
		tcal_calcon += (tcal_day+4);
		tcal_calcon += "); return false;'><font  POINT-SIZE=9><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day + 4];
		tcal_calcon +="</b></font></layer>";

		tcal_calcon +="<layer   position=relative height=8px width=17px bgcolor='#DDEEFF' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon += 98;
		tcal_calcon += " onfocus=' setDate(";
		tcal_calcon += (tcal_day+5);
		tcal_calcon += "); return false;'><font  POINT-SIZE=9><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day + 5];
		tcal_calcon +="</b></font></layer>";

		tcal_calcon +="<layer   position=relative height=8px width=17px bgcolor='#DDEEFF' top="
		tcal_calcon += (i+2)*17 +5;
		tcal_calcon += " left ="
		tcal_calcon += 117;
		tcal_calcon += " onfocus='setDate(";
		tcal_calcon += (tcal_day+6);
		tcal_calcon += "); return false;'><font  POINT-SIZE=9 ><b>&nbsp;"
		tcal_calcon += tcal_dayarr[tcal_day + 6];
		tcal_calcon += "</b></font></layer>";

	tcal_day += 7;
	}


		tcal_calcon += "<layer   position=relative height=17px width=134px top=138px left=3px >"
		tcal_calcon += "<layer name='leftlay2'  position=relative bgColor='#CAD2D2' height=17px width=17px top=3px left=0px onfocus='setcal(2);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'><img name='left2' src='' height=17 width=17></layer>"
		tcal_calcon += "<layer name='closelay' position=relative  bgcolor='#CAD2D2' width=93 left=19 height=17 top=3 onfocus='closecal()'><font POINT-SIZE=9>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><img name='close' src='' height=15 width=15 ></layer>"
		tcal_calcon += "<layer name='rightlay2'  position=relative bgColor='#CAD2D2' height=17px width=17px top=3px left=114px onfocus='setcal(3);self.dialogWidth=table1.scrollWidth+8+\"px\";self.dialogHeight = table1.scrollHeight+27+\"px\";'><img name='right2' src='' height=17 width=17></layer>"
		tcal_calcon += "</layer></layer>";

	}




	if(!document.layers){

		tcal_targetlayer.innerHTML = tcal_calcon;
		if(tcal_boolean=="false")
		{
			//tcal_targetlayer.style.pixelTop = event.clientY+document.body.scrollTop+tcal_topval;
			//tcal_targetlayer.style.pixelLeft = event.clientX+document.body.scrollLeft+tcal_lftval;
			//alert(table1.scrollHeight) ;
			self.dialogWidth = table1.scrollWidth+8+"px" ;
			self.dialogHeight = table1.scrollHeight+27+"px" ;
		}
		if(tcal_first==1)
			tcal_first=0;

		tcal_targetlayer.document['left1'].src = img1.src;
    tcal_targetlayer.document['right1'].src = img2.src;
    tcal_targetlayer.document['left2'].src = img1.src;
    tcal_targetlayer.document['right2'].src = img2.src;
    tcal_targetlayer.document['close'].src = img3.src;
	}
	else {
      //  tcal_targetlayer.document.write("");


    if(1) {
			tcal_targetlayer.document.write(tcal_calcon);
    }
		tcal_targetlayer.document.close();
		if(tcal_boolean=="false")
		{
	    tcal_targetlayer.left=e.pageX+tcal_lftval;
  	  tcal_targetlayer.top=e.pageY+tcal_topval;
  	}
		//alert(tcal_targetlayer.document.layers.lay1.document.headerlay.name);

		tcal_targetlayer.document.layers.lay1.document.headerlay.document.captureEvents(Event.MOUSEDOWN);
		tcal_targetlayer.document.layers.lay1.document.headerlay.document.onmousedown=startDrag;
		if(tcal_first==1){
			tcal_targetlayer.document.layers.lay1.document.layers[tcal_highlight].bgColor="#FFEEDD"
			tcal_first=0;
		}
		tcal_targetlayer.document.layers.lay1.document.leftlay1.document['left1'].src = img1.src;
    tcal_targetlayer.document.layers.lay1.document.rightlay1.document['right1'].src = img2.src;
    tcal_targetlayer.document.layers.lay1.document.leftlay2.document['left2'].src = img1.src;
    tcal_targetlayer.document.layers.lay1.document.rightlay2.document['right2'].src = img2.src;
    tcal_targetlayer.document.layers.lay1.document.closelay.document['close'].src = img3.src;
		}
	}


//End of function makeCal

function setFormat(tcal_day,tcal_mon,tcal_yer) {
	if(tcal_formatdate == null || tcal_formatdate=="")  {
		if(tcal_day <10) tcal_day = "0" + tcal_day;
			return( tcal_monthArray[tcal_mon] + " " + tcal_day + ", " + tcal_yer);
	}
	else {
		var tcal_monarr = new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
		var tcal_formated_date = tcal_formatdate;
		if(tcal_day <10) tcal_day = "0" + tcal_day;
			var mmm = ((tcal_mon+ 1) <10)?"0"+(tcal_mon+1):(tcal_mon+1);

			tcal_formated_date= tcal_formated_date.replace(/[dD][dD]/,tcal_day);
			tcal_formated_date= tcal_formated_date.replace(/[mM][mM]/,mmm);
			tcal_formated_date= tcal_formated_date.replace(/[yY][yY]+/,tcal_yer);
			tcal_formated_date= tcal_formated_date.replace(/[mM][oO][nN]/,tcal_monarr[tcal_mon]);

	return(tcal_formated_date);
	}
}


//---------------------------

if(document.layers) document.captureEvents(Event.MOUSEMOVE |Event.MOUSEUP);


//document.onmousemove = dragCal;
//document.onmouseup = stopDrag;

tcal_drgindic=1;


function stopDrag(e) {
tcal_drgindic=1;
return true;
}



function startDrag(e) {
	tcal_drgindic=0;
return false;
}


function dragCal(e) {
if(tcal_drgindic == 1) return false;
var tcal_x, tcal_y;
if(document.layers) {
tcal_x = e.pageX;
tcal_y = e.pageY;

tcal_targetlayer.top = tcal_y - 10 - tcal_topval;
tcal_targetlayer.left = tcal_x - 60 - tcal_lftval;

}
else if(document.all) {
calLocBod = document.body;

tcal_x = event.clientX;
tcal_y = event.clientY;

tcal_targetlayer.style.top = tcal_y + calLocBod.scrollTop - 10 - tcal_topval;
tcal_targetlayer.style.left = tcal_x + calLocBod.scrollLeft  - 70 - tcal_lftval;

}
}

function donothingfalse() {
return false;
}

function donothingtrue() {
return true;
}
function fnCalendar(boxName, months, xPos, yPos, datemask,timeValue,contextUrl)
{

    var pass_array = new Array();
    if(fnCalendar.arguments.length != 3 && fnCalendar.arguments.length != 5 && fnCalendar.arguments.length != 6 && fnCalendar.arguments.length != 7)
    {
        alert("Argument mismatch !");
        return;
    }
    else if(fnCalendar.arguments.length == 3)
    {
		//boxName/months/datemask
        pass_array[0] = fnCalendar.arguments[1];
        pass_array[1] = fnCalendar.arguments[0];
        pass_array[2] = fnCalendar.arguments[2];
    }
    else if(fnCalendar.arguments.length == 5)
    {
        pass_array[0] = fnCalendar.arguments[1];
        pass_array[1] = fnCalendar.arguments[0];
        pass_array[2] = fnCalendar.arguments[4];
        pass_array[3] = fnCalendar.arguments[2];
        pass_array[4] = fnCalendar.arguments[3];
    }
    else if(fnCalendar.arguments.length >= 6)
    {
        pass_array[0] = fnCalendar.arguments[1];
        pass_array[1] = fnCalendar.arguments[0];
        pass_array[2] = fnCalendar.arguments[4];
        pass_array[3] = fnCalendar.arguments[2];
        pass_array[4] = fnCalendar.arguments[3];
        pass_array[5] = fnCalendar.arguments[5];
    }
	var preUrl="../..";
	if(fnCalendar.arguments.length == 7)
		preUrl=fnCalendar.arguments[6];

    var h = document.body.clientHeight;
    var w = document.body.clientWidth;

    var x = window.event.screenX;
    var y = window.event.screenY;

    var x1 = window.screenLeft;
    var y1 = window.screenTop;

    if ( (h-(y-y1)) <= 180 )
        y = y - (180-(h-(y-y1))) ;
    window.showModalDialog(preUrl+'/util/calendar/Calendar.html',pass_array,'dialogHeight="200px";dialogWidth="170px";dialogTop='+y+';dialogLeft='+x+';status="no";help="no"');
}


/********************
****** END **********
*********************/
