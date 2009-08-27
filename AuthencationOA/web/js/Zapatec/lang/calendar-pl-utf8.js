// $Id: calendar-pl-utf8.js 9653 2008-01-21 08:57:54Z mike $
// ** I18N

// Calendar PL language
// Author: Dariusz Pietrzak, <eyck@ghost.anime.pl>
// Author: Janusz Piwowarski, <jpiw@go2.pl>
// Encoding: utf-8
// Distributed under the same terms as the calendar itself.

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "pl-utf8"], {
  // full day names
  "_DN"  : new Array
           ("Niedziela",
 "Poniedzia�'ek",
 "Wtorek",
 "�_roda",
 "Czwartek",
 "Pi�:tek",
 "Sobota",
 "Niedziela"),
  // short day names
  "_SDN" : new Array
           ("Nie",
 "Pn",
 "Wt",
 "�_r",
 "Cz",
 "Pt",
 "So",
 "Nie"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 0,
  // full month names
  "_MN"  : new Array
            ("Stycze�",
 "Luty",
 "Marzec",
 "Kwiecie�",
 "Maj",
 "Czerwiec",
 "Lipiec",
 "Sierpie�",
 "Wrzesie�",
 "Październik",
 "Listopad",
 "Grudzie�"),
  // short month names
  "_SMN" : new Array
 ("Sty",
 "Lut",
 "Mar",
 "Kwi",
 "Maj",
 "Cze",
 "Lip",
 "Sie",
 "Wrz",
 "Paź",
 "Lis",
 "Gru"),
   // tooltips
   "INFO" : "About the calendar",
   "ABOUT": "DHTML Date/Time Selector\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ;-)
"Aby pobra�+ najnowsz�: wersj�T, odwiedź: http://www.zapatec.com\n" +
"This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"Wyb�_r daty:\n" +
"- U�_yj przycisk�_w \xab, \xbb by wybra�+ rok\n" +
"- U�_yj przycisk�_w " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " by wybra�+ miesi�:c\n" +
"- Przytrzymaj klawisz myszy nad jednym z powy�_szych przycisk�_w dla szybszego wyboru.",
   "ABOUT_TIME" : "\n\n" +
"Wyb�_r czasu:\n" +
"- Kliknij na jednym z p�_l czasu by zwi�Tkszy�+ jego warto�>�+\n" +
"- lub kliknij trzymaj�:c Shift by zmiejszy�+ jego warto�>�+\n" +
"- lub kliknij i przeci�:gnij dla szybszego wyboru.",

   //"TOGGLE" : "Zmie�" pierwszy dzie�" tygodnia",
   "PREV_YEAR"    : "Poprzedni rok (przytrzymaj dla menu)",
   "PREV_MONTH"   : "Poprzedni miesi�:c (przytrzymaj dla menu)",
   "GO_TODAY"     : "Idź do dzisiaj",
   "NEXT_MONTH"   : "Nast�Tpny miesi�:c (przytrzymaj dla menu)",
   "NEXT_YEAR"    : "Nast�Tpny rok (przytrzymaj dla menu)",
   "SEL_DATE"     : "Wybierz dat�T",
   "DRAG_TO_MOVE" : "Przeci�:gnij by przesun�:�+",
   "PART_TODAY"   : " (dzisiaj)",
   "MON_FIRST" : "Wy�>wietl poniedzia�'ek jako pierwszy",
   "SUN_FIRST" : "Wy�>wietl niedziel�T jako pierwsz�:",

   // the following is to inform that "%s" is to be the first day of week
   // %s will be replaced with the day name.
   "DAY_FIRST"    : "Display %s first",

   // This may be locale-dependent.  It specifies the week-end days, as an array
   // of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
   // means Monday, etc.
   "WEEKEND"      : "0,6",

   "CLOSE"        : "Zamknij",
   "TODAY"        : "Dzisiaj",
   "TIME_PART"    : "(Shift-)Kliknij lub przeci�:gnij by zmieni�+ warto�>�+",

   // date formats
   "DEF_DATE_FORMAT"  : "%Y-%m-%d",
   "TT_DATE_FORMAT"   : "%e %B, %A",

   "WK"           : "ty",
   "TIME"         : "Time:",
   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});
