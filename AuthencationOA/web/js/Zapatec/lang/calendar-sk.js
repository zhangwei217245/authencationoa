// $Id: calendar-sk.js 8274 2007-09-25 12:42:06Z nmaxim $
// ** I18N

// Calendar SK language
// Author: Peter Valach (pvalach@gmx.net)
// Encoding: utf-8
// Last update: 2003/10/29
// Distributed under the same terms as the calendar itself.

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "sk"], {
  // full day names
  "_DN"  : new Array
           ("Nede�"�_a",
 "Pondelok",
 "Utorok",
 "Streda",
 "Ĺ tvrtok",
 "Piatok",
 "Sobota",
 "Nede�"�_a"),
  // short day names
  "_SDN" : new Array
           ("Ned",
 "Pon",
 "Uto",
 "Str",
 "Ĺ tv",
 "Pia",
 "Sob",
 "Ned"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 0,
  // full month names
  "_MN"  : new Array
            ("Janu�'�+r",
 "Febru�'�+r",
 "Marec",
 "Apr�'�-l",
 "M�'�+j",
 "J�'�_n",
 "J�'�_l",
 "August",
 "September",
 "Okt�'�'ber",
 "November",
 "December"),
  // short month names
  "_SMN" : new Array
           ("Jan",
 "Feb",
 "Mar",
 "Apr",
 "M�'�+j",
 "J�'�_n",
 "J�'�_l",
 "Aug",
 "Sep",
 "Okt",
 "Nov",
 "Dec"),
   // tooltips
   "INFO" : "O kalend�'�+ri",
   "ABOUT": "DHTML Date/Time Selector\n" +
"(c) zapatec.com 2002-2007\n" +
"Posledn�'�_ verziu n�'�+jdete na: http://www.zapatec.com\n" +
"This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"V�'�_ber d�'�+tumu:\n" +
"- PouĹ�_ite tla�"Ťidl�'�+ \xab, \xbb pre v�'�_ber roku\n" +
"- PouĹ�_ite tla�"Ťidl�'�+ " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " pre v�'�_ber mesiaca\n" +
"- Ak ktor�'�cko�"�_vek z t�'�_chto tla�"Ťidiel podrĹ�_�'�-te dlhĹ�+ie, zobraz�'�- sa r�'�_chly v�'�_ber.",
   "ABOUT_TIME" : "\n\n" +
"V�'�_ber �"Ťasu:\n" +
"- Kliknutie na niektor�'�_ poloĹ�_ku �"Ťasu ju zv�'�_Ĺ�+i\n" +
"- Shift-klik ju zn�'�-Ĺ�_i\n" +
"- Ak podrĹ�_�'�-te tla�"Ť�'�-tko stla�"Ťen�'�c, pos�'�_van�'�-m men�'�-te hodnotu.",

   "PREV_YEAR"    : "PredoĹ�+l�'�_ rok (podrĹ�_te pre menu)",
   "PREV_MONTH"   : "PredoĹ�+l�'�_ mesiac (podrĹ�_te pre menu)",
   "GO_TODAY"     : "PrejsĹ�" na dneĹ�+ok",
   "NEXT_MONTH"   : "Nasl. mesiac (podrĹ�_te pre menu)",
   "NEXT_YEAR"    : "Nasl. rok (podrĹ�_te pre menu)",
   "SEL_DATE"     : "Zvo�"�_te d�'�+tum",
   "DRAG_TO_MOVE" : "PodrĹ�_an�'�-m tla�"Ť�'�-tka zmen�'�-te polohu",
   "PART_TODAY"   : " (dnes)",
   "MON_FIRST" : "ZobraziĹ�" pondelok ako prv�'�_",
   "SUN_FIRST" : "ZobraziĹ�" nede�"�_u ako prv�'�_",

   // the following is to inform that "%s" is to be the first day of week
   // %s will be replaced with the day name.
   "DAY_FIRST"    : "Display %s first",

   // This may be locale-dependent.  It specifies the week-end days, as an array
   // of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
   // means Monday, etc.
   "WEEKEND"      : "0,6",

   "CLOSE"        : "ZavrieĹ�"",
   "TODAY"        : "Dnes",
   "TIME_PART"    : "(Shift-)klik/Ĺ�"ahanie zmen�'�- hodnotu",

   // date formats
   "DEF_DATE_FORMAT"  : $d. %m. %Y",
   "TT_DATE_FORMAT"   : "%a, %e. %b",

   "WK"           : "t�'�_Ĺ�_",
   "TIME"         : "Time:",
   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});
