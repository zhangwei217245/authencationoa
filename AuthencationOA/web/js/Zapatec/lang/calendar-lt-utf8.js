// $Id: calendar-lt-utf8.js 8274 2007-09-25 12:42:06Z nmaxim $
// ** I18N

// Calendar LT language
// Author: Martynas Majeris, <martynas@solmetra.lt>
// Encoding: UTF-8
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "lt-utf8"], {
  // full day names
  "_DN"  : new Array
           ("Sekmadienis",
 "Pirmadienis",
 "Antradienis",
 "Tre�_iadienis",
 "Ketvirtadienis",
 "Pentadienis",
 "Šeštadienis",
 "Sekmadienis"),
  // short day names
  "_SDN" : new Array
           ("Sek",
 "Pir",
 "Ant",
 "Tre",
 "Ket",
 "Pen",
 "Šeš",
 "Sek"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 0,
  // full month names
  "_MN"  : new Array
            ("Sausis",
 "Vasaris",
 "Kovas",
 "Balandis",
 "Gegu�_�-",
 "Bir�_elis",
 "Liepa",
 "Rugpj�<tis",
 "Rugs�-jis",
 "Spalis",
 "Lapkritis",
 "Gruodis"),
  // short month names
  "_SMN" : new Array
           ("Sau",
 "Vas",
 "Kov",
 "Bal",
 "Geg",
 "Bir",
 "Lie",
 "Rgp",
 "Rgs",
 "Spa",
 "Lap",
 "Gru"),
   // tooltips
   "INFO" : "Apie kalendori�_",
   "ABOUT": "DHTML Date/Time Selector\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ;-)
"Naujausi�: versij�: rasite: http://www.zapatec.com\n" +
"This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"Datos pasirinkimas:\n" +
"- Met�_ pasirinkimas: \xab, \xbb\n" +
"- M�-nesio pasirinkimas: " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + "\n" +
"- Nuspauskite ir laikykite pel�-s klaviš�: greitesniam pasirinkimui.",
   "ABOUT_TIME" : "\n\n" +
"Laiko pasirinkimas:\n" +
"- Spustelkite ant valand�_ arba minu�_i�_ - skai�_ius padid�-s vienetu.\n" +
"- Jei spausite kartu su Shift, skai�_ius suma�_�-s.\n" +
"- Greitam pasirinkimui spustelkite ir pajudinkite pel�T.",

   "PREV_YEAR"    : "Ankstesni metai (laikykite, jei norite meniu)",
   "PREV_MONTH"   : "Ankstesnis m�-nuo (laikykite, jei norite meniu)",
   "GO_TODAY"     : "Pasirinkti šiandien�:",
   "NEXT_MONTH"   : "Kitas m�-nuo (laikykite, jei norite meniu)",
   "NEXT_YEAR"    : "Kiti metai (laikykite, jei norite meniu)",
   "SEL_DATE"     : "Pasirinkite dat�:",
   "DRAG_TO_MOVE" : "Tempkite",
   "PART_TODAY"   : " (šiandien)",
   "MON_FIRST": "Pirma savait�-s diena �_" pirmadienis",
   "SUN_FIRST"  : "Pirma savait�-s diena �_" sekmadienis",

   // the following is to inform that "%s" is to be the first day of week
   // %s will be replaced with the day name.
   "DAY_FIRST"    : "Display %s first",

   // This may be locale-dependent.  It specifies the week-end days, as an array
   // of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
   // means Monday, etc.
   "WEEKEND"      : "0,6",

   "CLOSE"        : "U�_daryti",
   "TODAY"        : "Šiandien",
   "TIME_PART"    : Spustelkite arba tempkite jei norite pakeisti",

   // date formats
   "DEF_DATE_FORMAT"  : "%Y-%m-%d",
   "TT_DATE_FORMAT"   : "%A, %Y-%m-%d",

   "WK"           : "sav",
   "TIME"         : "Time:",
   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});
