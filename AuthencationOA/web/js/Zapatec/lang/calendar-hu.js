// $Id: calendar-hu.js 8295 2007-09-26 08:42:04Z nmaxim $
// ** I18N

// Calendar HU language
// Author: ???
// Modifier: KARASZI Istvan, <jscalendar@spam.raszi.hu>
// Encoding: any
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "hu"], {
// full day names
"_DN" : new Array
("Vas�rnap",
 "H�tf�",
 "Kedd",
 "Szerda",
 "Cs�t�rt�k",
 "P�ntek",
 "Szombat",
 "Vas�rnap"),

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary.  We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
//   Zapatec.Calendar._SDN_len = N; // short day name length
//   Zapatec.Calendar._SMN_len = N; // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
"_SDN" :  new Array
("v",
 "h",
 "k",
 "sze",
 "cs",
 "p",
 "szo",
 "v"),
  "_FD"  : 0,
// full month names
"_MN" : new Array
("janu�r",
 "febru�r",
 "m�rcius",
 "�prilis",
 "m�jus",
 "j�nius",
 "j�lius",
 "augusztus",
 "szeptember",
 "okt�ber",
 "november",
 "december"),

// short month names
"_SMN" : new Array
("jan",
 "feb",
 "m�r",
 "�pr",
 "m�j",
 "j�n",
 "j�l",
 "aug",
 "sze",
 "okt",
 "nov",
 "dec"),

// tooltips
"INFO": "A kalend�riumr�l",

"ABOUT":
"DHTML d�tum/id� kiv�laszt�\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ,-)
"a legfrissebb verzi� megtal�lhat�: http://www.zapatec.com\n" +
"This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"D�tum v�laszt�s:\n" +
"- haszn�lja a \xab, \xbb gombokat az �v kiv�laszt�s�hoz\n" +
"- haszn�lja a " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " gombokat a h�nap kiv�laszt�s�hoz\n" +
"- tartsa lenyomva az eg�rgombot a gyors v�laszt�shoz.",
"ABOUT_TIME": "\n\n" +
"Id� v�laszt�s:\n" +
"- kattintva n�velheti az id�t\n" +
"- shift-tel kattintva cs�kkentheti\n" +
"- lenyomva tartva �s h�zva gyorsabban kiv�laszthatja.",

"PREV_YEAR": "El�z� �v (tartsa nyomva a men�h�z)",
"PREV_MONTH": "El�z� h�nap (tartsa nyomva a men�h�z)",
"GO_TODAY": "Mai napra ugr�s",
"NEXT_MONTH": "K�v. h�nap (tartsa nyomva a men�h�z)",
"NEXT_YEAR": "K�v. �v (tartsa nyomva a men�h�z)",
"SEL_DATE": "V�lasszon d�tumot",
"DRAG_TO_MOVE": "H�zza a mozgat�shoz",
"PART_TODAY": " (ma)",

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
"DAY_FIRST": "%s legyen a h�t els� napja",

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
"WEEKEND": "0,6",

"CLOSE": "Bez�r",
"TODAY": "Ma",
"TIME_PART": "(Shift-)Klikk vagy h�z�s az �rt�k v�ltoztat�s�hoz",

// date formats
"DEF_DATE_FORMAT": "%Y-%m-%d",
"TT_DATE_FORMAT": "%b %e, %a",

"WK": "h�t",
"TIME": "id�:",
   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});


