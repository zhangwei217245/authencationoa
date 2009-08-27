// $Id: calendar-sq.js 15736 2009-02-06 15:29:25Z nikolai $
// ** I18N

// Calendar EN language
// Contac: <support@zapatec.com>
// Encoding: any
// Copyright Zapatec 2004-2009

// For translators: please use UTF-8 if possible. 

// full day names
Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "sq"], {

"_DN" : new Array
("E diel",
 "E h�n�",
 "E mart�",
 "E m�rkur�",
 "E enjte",
 "E premte",
 "E shtun�",
 "E diel"),

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary. We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
//   Zapatec.Calendar._SDN_len = N, // short day name length
//   Zapatec.Calendar._SMN_len = N, // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
"_SDN" : new Array
("Die",
 "H�n",
 "Mar",
 "M�r",
 "Enj",
 "Pre",
 "Sht",
 "Die"),

// First day of the week. "0" means display Sunday first, "1" means display
// Monday first, etc.
"_FD" : 0,

// full month names
"_MN" : new Array
("Janar",
 "Shkurt",
 "Mars",
 "Prill",
 "Maj",
 "Qershor",
 "Korrik",
 "Gusht",
 "Shtator",
 "Tetor",
 "N�ntor",
 "Dhjetor"),

// short month names
"_SMN" : new Array
("Jan",
 "Shk",
 "Mar",
 "Pri",
 "Maj",
 "Qer",
 "Kor",
 "Gus",
 "Sht",
 "Tet",
 "N�n",
 "Dhj"),

// tooltips

"INFO" :  "Rreth kalendarit",

"ABOUT" : 
"DHTML Date/Time Selector\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ,-)
"P�r versionin e fundit vizitoni: http://www.zapatec.com/\n" +
"\n\n" +
"Selektimi i dat�s:\n" +
"- P�rdorni butonat \xab, \xbb p�r t� selektuar vitin\n" +
"- P�rdorni butonat  " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " p�r t� selektuar muajin\n" +
"- Mbani butonin e mous-it n� �donj�rin nga butonat e m�sip�rm p�r nj� selektim m� t� shpejt�.",
"ABOUT_TIME" :  "\n\n" +
"Selektimi i or�s:\n" +
"- Klikoni n� �far�do pjes� t� koh�s p�r ta rritur at�\n" +
"- ose Shift-klik p�r ta zvog�luar at�\n" +
"- ose klikoni dhe t�rhiqni p�r nj� selektim m� t� shpejt�.",

"PREV_YEAR" :  "Viti  paraardh�s (mbani p�r meny)",
"PREV_YEAR" :  "Muaji  paraardh�s (mbani p�r meny)",
"GO_TODAY" :  "Shkoni Sot (mbani p�r historin�)",
"NEXT_MONTH" :  "Muaji tjet�r (mbani p�r meny)",
"NEXT_YEAR" :  "Viti tjet�r (mbani p�r meny)",
"SEL_DATE" :  "Selektoni dat�n",
"DRAG_TO_MOVE" :  "T�rhiq p�r t� l�vizur",
"PART_TODAY" :  " (sot)",

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
"DAY_FIRST" :  "Shfaq %s p�rpara",

// This may be locale-dependent. It specifies the week-end days, as an array
// of comma-separated numbers. The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
"WEEKEND" :  "0,6",

"CLOSE" :  "Mbyll",
"TODAY" :  "Sot",
"TIME_PART" :  "(Shift-)Klikoni ose t�rhiqni p�r t� ndryshuar vler�n",

// date formats
"DEF_DATE_FORMAT" :  "%Y-%m-%d",
"TT_DATE_FORMAT" :  "%a, %b %e",

"WK" :  "jav",
"TIME" :  "Ora:",

"E_RANGE" :  "Jasht� gam�s",
	
"_AMPM" : {am : "am", pm : "pm"}

})
