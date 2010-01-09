// $Id: calendar-bg.js 15736 2009-02-06 15:29:25Z nikolai $
// ** I18N

// Calendar BG language
// Contac: <support@zapatec.com>
// Encoding: any
// Copyright Zapatec 2004-2009

// For translators: please use UTF-8 if possible.  
Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "bg"], {

// full day names
"_DN" : new Array
("\u041d\u0435\u0434\u0435\u043b\u044f",
 "\u041f\u043e\u043d\u0435\u0434\u0435\u043b\u043d\u0438\u043a",
 "\u0412\u0442\u043e\u0440\u043d\u0438\u043a",
 "\u0421\u0440\u044f\u0434\u0430",
 "\u0427\u0435\u0442\u0432\u044a\u0440\u0442\u044a\u043a",
 "\u041f\u0435\u0442\u044a\u043a",
 "\u0421\u044a\u0431\u043e\u0442\u0430",
 "\u041d\u0435\u0434\u0435\u043b\u044f"),

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary.  We give it here
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
("\u041d\u0435\u0434",
 "\u041f\u043e\u043d",
 "\u0412\u0442\u043e",
 "\u0421\u0440\u044f",
 "\u0427\u0435\u0442",
 "\u041f\u0435\u0442",
 "\u0421\u044a\u0431",
 "\u041d\u0435\u0434"),

// First day of the week. "0" means display Sunday first, "1" means display
// Monday first, etc.
"_FD" : 0,

// full month names
"_MN" : new Array
("\u042f\u043d\u0443\u0430\u0440\u0438",
 "\u0424\u0435\u0432\u0440\u0443\u0430\u0440\u0438",
 "\u041c\u0430\u0440\u0442",
 "\u0410\u043f\u0440\u0438\u043b",
 "\u041c\u0430\u0439",
 "\u042e\u043d\u0438",
 "\u042e\u043b\u0438",
 "\u0410\u0432\u0433\u0443\u0441\u0442",
 "\u0421\u0435\u043f\u0442\u0435\u043c\u0432\u0440\u0438",
 "\u041e\u043a\u0442\u043e\u043c\u0432\u0440\u0438",
 "\u041d\u043e\u0435\u043c\u0432\u0440\u0438",
 "\u0414\u0435\u043a\u0435\u043c\u0432\u0440\u0438"),

// short month names
"_SMN" : new Array
("\u042f\u043d\u0443",
 "\u0424\u0435\u0432",
 "\u041c\u0430\u0440",
 "\u0410\u043f\u0440",
 "\u041c\u0430\u0439",
 "\u042e\u043d\u0438",
 "\u042e\u043b\u0438",
 "\u0410\u0432\u0433",
 "\u0421\u0435\u043f",
 "\u041e\u043a\u0442",
 "\u041d\u043e\u0435",
 "\u0414\u0435\u043a"),

// tooltips
"INFO" : "\u0417\u0430 \u043a\u0430\u043b\u0435\u043d\u0434\u0430\u0440\u0430",

"ABOUT" : 
"DHTML Date/Time Selector\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ,-)
"\u0417\u0430 \u043d\u0430\u0439-\u043d\u043e\u0432\u0430\u0442\u0430 \u0432\u0435\u0440\u0441\u0438\u044f \u043f\u043e\u0441\u0435\u0442\u0435\u0442\u0435 \u0441\u043b\u0435\u0434\u043d\u0438\u044f \u0441\u0430\u0439\u0442: http://www.zapatec.com/\n" +
"\n\n" +
"\u0418\u0437\u0431\u043e\u0440 \u043d\u0430 \u0434\u0430\u0442\u0430:\n" +
"- \u0418\u0437\u043f\u043e\u043b\u0437\u0432\u0430\u0439\u0442\u0435 \u0431\u0443\u0442\u043e\u043d\u0438\u0442\u0435 \xab, \xbb, \u0437\u0430 \u0434\u0430 \u0438\u0437\u0431\u0435\u0440\u0435\u0442\u0435 \u0433\u043e\u0434\u0438\u043d\u0430.\n" +
"- \u0418\u0437\u043f\u043e\u043b\u0437\u0432\u0430\u0439\u0442\u0435 \u0431\u0443\u0442\u043e\u043d\u0438\u0442\u0435 " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + ", \u0437\u0430 \u0434\u0430 \u0438\u0437\u0431\u0435\u0440\u0435\u0442\u0435 \u043c\u0435\u0441\u0435\u0446.\n" +
"- \u0417\u0430\u0434\u0440\u044a\u0436\u0442\u0435 \u0431\u0443\u0442\u043e\u043d\u0430 \u043d\u0430 \u043c\u0438\u0448\u043a\u0430\u0442\u0430 \u0432\u044a\u0440\u0445\u0443 \u043a\u043e\u0439\u0442\u043e \u0438 \u0434\u0430 \u0435 \u043e\u0442 \u043f\u043e-\u0433\u043e\u0440\u043d\u0438\u0442\u0435 \u0431\u0443\u0442\u043e\u043d\u0438 \u0437\u0430 \u043f\u043e-\u0431\u044a\u0440\u0437 \u0438\u0437\u0431\u043e\u0440.",
"ABOUT_TIME" : "\n\n" +
"\u0418\u0437\u0431\u043e\u0440 \u043d\u0430 \u0447\u0430\u0441:\n" +
"- \u0429\u0440\u0430\u043a\u043d\u0435\u0442\u0435 \u0432\u044a\u0440\u0445\u0443 \u0436\u0435\u043b\u0430\u043d\u0430\u0442\u0430 \u0432\u0440\u0435\u043c\u0435\u0432\u0430 \u0447\u0430\u0441\u0442, \u0437\u0430 \u0434\u0430 \u044f \u0443\u0432\u0435\u043b\u0438\u0447\u0438\u0442\u0435\n" +
"- \u0438\u043b\u0438 \u0449\u0440\u0430\u043a\u043d\u0435\u0442\u0435 \u0432\u044a\u0440\u0445\u0443 \u043d\u0435\u044f \u0441 \u043d\u0430\u0442\u0438\u0441\u043d\u0430\u0442 \u043a\u043b\u0430\u0432\u0438\u0448\u0430 Shift, \u0437\u0430 \u0434\u0430 \u044f \u043d\u0430\u043c\u0430\u043b\u0438\u0442\u0435,\n" +
"- \u0438\u043b\u0438 \u0449\u0440\u0430\u043a\u043d\u0435\u0442\u0435 \u0438 \u043f\u043b\u044a\u0437\u043d\u0435\u0442\u0435 \u0437\u0430 \u043f\u043e-\u0431\u044a\u0440\u0437 \u0438\u0437\u0431\u043e\u0440.",

"PREV_YEAR" : "\u041f\u0440\u0435\u0434\u0438\u0448\u043d\u0430 \u0433\u043e\u0434\u0438\u043d\u0430 (\u0437\u0430\u0434\u0440\u044a\u0436\u0442\u0435 \u0437\u0430 \u043c\u0435\u043d\u044e)",
"PREV_MONTH" :  "\u041f\u0440\u0435\u0434\u0438\u0448\u0435\u043d \u043c\u0435\u0441\u0435\u0446 (\u0437\u0430\u0434\u0440\u044a\u0436\u0442\u0435 \u0437\u0430 \u043c\u0435\u043d\u044e)",
"GO_TODAY" :  "\u0414\u043d\u0435\u0441 (\u0437\u0430\u0434\u0440\u044a\u0436\u0442\u0435 \u0437\u0430 \u0445\u0440\u043e\u043d\u043e\u043b\u043e\u0433\u0438\u044f)",
"NEXT_MONTH" :  "\u0421\u043b\u0435\u0434\u0432\u0430\u0449 \u043c\u0435\u0441\u0435\u0446 (\u0437\u0430\u0434\u0440\u044a\u0436\u0442\u0435 \u0437\u0430 \u043c\u0435\u043d\u044e)",
"NEXT_YEAR" :  "\u0421\u043b\u0435\u0434\u0432\u0430\u0449\u0430 \u0433\u043e\u0434\u0438\u043d\u0430 (\u0437\u0430\u0434\u0440\u044a\u0436\u0442\u0435 \u0437\u0430 \u043c\u0435\u043d\u044e)",
"SEL_DATE" :  "\u0418\u0437\u0431\u043e\u0440 \u043d\u0430 \u0434\u0430\u0442\u0430",
"DRAG_TO_MOVE" :  "\u041f\u043b\u044a\u0437\u043d\u0435\u0442\u0435 \u0437\u0430 \u043f\u0440\u0435\u043c\u0435\u0441\u0442\u0432\u0430\u043d\u0435",
"PART_TODAY" :  " (\u0434\u043d\u0435\u0441)",

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
"DAY_FIRST" :  "\u041f\u044a\u0440\u0432\u0438 \u0434\u0435\u043d \u043e\u0442 \u0441\u0435\u0434\u043c\u0438\u0446\u0430\u0442\u0430: %s",

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
"WEEKEND" :  "0,6",

"CLOSE" :  "\u0417\u0430\u0442\u0432\u043e\u0440\u0438",
"TODAY" :  "\u0414\u043d\u0435\u0441",
"TIME_PART" :  "\u0429\u0440\u0430\u043a\u043d\u0435\u0442\u0435 \u0441 \u0438\u043b\u0438 \u0431\u0435\u0437 \u043d\u0430\u0442\u0438\u0441\u043d\u0430\u0442 \u043a\u043b\u0430\u0432\u0438\u0448\u0430 Shift \u0438\u043b\u0438 \u043f\u043b\u044a\u0437\u043d\u0435\u0442\u0435, \u0437\u0430 \u0434\u0430 \u043f\u0440\u043e\u043c\u0435\u043d\u0438\u0442\u0435 \u0441\u044a\u043e\u0442\u0432\u0435\u0442\u043d\u0430\u0442\u0430 \u0441\u0442\u043e\u0439\u043d\u043e\u0441\u0442.",

// date formats
"DEF_DATE_FORMAT" :  "%d.%m.%Y",
"TT_DATE_FORMAT" :  "%a, %b %e",

"WK" :  "\u0441\u0435\u0434\u043c\u0438\u0446\u0430",
"TIME" :  "\u0427\u0430\u0441:",

"E_RANGE" :  "\u0418\u0437\u0432\u044a\u043d \u043e\u0431\u0445\u0432\u0430\u0442\u0430",
	
"_AMPM" : {am : "\u043f\u0440\u0435\u0434\u0438 \u043e\u0431\u044f\u0434", pm : "\u0441\u043b\u0435\u0434 \u043e\u0431\u044f\u0434"}


})