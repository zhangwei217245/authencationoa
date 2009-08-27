// $Id: calendar-sv.js 8274 2007-09-25 12:42:06Z nmaxim $
// ** I18N

// Calendar SV language (Swedish, svenska)
// Author: Mihai Bazon, <mihai_bazon@yahoo.com>
// Translation team: <sv@li.org>
// Translator: Leonard Norrg�rd <leonard.norrgard@refactor.fi>
// Last translator: Leonard Norrg�rd <leonard.norrgard@refactor.fi>
// Encoding: iso-latin-1
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "sv"], {
  // full day names
  "_DN"  : new Array
           ("s�ndag",
 "m�ndag",
 "tisdag",
 "onsdag",
 "torsdag",
 "fredag",
 "l�rdag",
 "s�ndag"),
  // short day names
  "_SDN" : new Array
           ("San",
            "Mon",
            "Tue",
            "Wed",
            "Thu",
            "Fri",
            "Sat",
            "Sun"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 0,
  // full month names
  "_MN"  : new Array
            ("januari",
 "februari",
 "mars",
 "april",
 "maj",
 "juni",
 "juli",
 "augusti",
 "september",
 "oktober",
 "november",
 "december"),
  // short month names
  "_SMN" : new Array
           ("Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"),

	"_SDN_len" : 2;
	"_SMN_len" : 3;
// tooltips
"INFO": "Om kalendern",

"ABOUT":
"DHTML Datum/tid-v�ljare\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ,-)
"F�r senaste version g� till: http://www.zapatec.com\n" +
"This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"Val av datum:\n" +
"- Anv�nd knapparna \xab, \xbb f�r att v�lja �r\n" +
"- Anv�nd knapparna " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " f�r att v�lja m�nad\n" +
"- H�ll musknappen nedtryckt p� n�gon av ovanst�ende knappar f�r snabbare val.",
"ABOUT_TIME": "\n\n" +
"Val av tid:\n" +
"- Klicka p� en del av tiden f�r att �ka den delen\n" +
"- eller skift-klicka f�r att minska den\n" +
"- eller klicka och drag f�r snabbare val.",

"PREV_YEAR": "F�reg�ende �r (h�ll f�r menu)",
"PREV_MONTH": "F�reg�ende m�nad (h�ll f�r menu)",
"GO_TODAY": "G� till dagens datum",
"NEXT_MONTH": "F�ljande m�nad (h�ll f�r menu)",
"NEXT_YEAR": "F�ljande �r (h�ll f�r menu)",
"SEL_DATE": "V�lj datum",
"DRAG_TO_MOVE": "Drag f�r att flytta",
"PART_TODAY": " (idag)",
"MON_FIRST": "Visa m�ndag f�rst",
"SUN_FIRST": "Visa s�ndag f�rst",
"CLOSE": "St�ng",
"TODAY": "Idag",
"TIME_PART": "(Skift-)klicka eller drag f�r att �ndra tid",

// date formats
"DEF_DATE_FORMAT": "%Y-%m-%d",
"TT_DATE_FORMAT": "%A %d %b %Y",

"WK": "vecka",

   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});