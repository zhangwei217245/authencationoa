// $Id: calendar-es-ISO-8859-1.js 16936 2009-04-09 08:23:45Z vasyl $
// ** I18N

// Calendar ES (spanish) language
// Author: Mihai Bazon, <mihai_bazon@yahoo.com>
// Updater: Servilio Afre Puentes <servilios@yahoo.com>
// Updated: 2004-06-03
// Encoding: ISO-8859-1
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "es"], {
  // full day names
  "_DN"  : new Array
           ("Domingo",
 "Lunes",
 "Martes",
 "Mi�rcoles",
 "Jueves",
 "Viernes",
 "S�bado",
 "Domingo"),
  // short day names
  "_SDN" : new Array
           ("Dom",
 "Lun",
 "Mar",
 "Mi�",
 "Jue",
 "Vie",
 "S�b",
 "Dom"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 1,
  // full month names
  "_MN"  : new Array
            ("Enero",
 "Febrero",
 "Marzo",
 "Abril",
 "Mayo",
 "Junio",
 "Julio",
 "Agosto",
 "Septiembre",
 "Octubre",
 "Noviembre",
 "Diciembre"),
  // short month names
  "_SMN" : new Array
           ("Ene",
 "Feb",
 "Mar",
 "Abr",
 "May",
 "Jun",
 "Jul",
 "Ago",
 "Sep",
 "Oct",
 "Nov",
 "Dic"),
   // tooltips
   "INFO" : "Acerca del calendario",
   "ABOUT": "Selector DHTML de Fecha/Hora\n" +
"(c) zapatec.com 2002-2007\n" + // don't translate this this ;-)
"Para conseguir la �ltima versi�n visite: http://www.zapatec.com\n" +
"This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"Selecci�n de fecha:\n" +
"- Use los botones \xab, \xbb para seleccionar el a�o\n" +
"- Use los botones " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " para seleccionar el mes\n" +
"- Mantenga pulsado el rat�n en cualquiera de estos botones para una selecci�n r�pida.",
   "ABOUT_TIME" : "\n\n" +
"Selecci�n de hora:\n" +
"- Pulse en cualquiera de las partes de la hora para incrementarla\n" +
"- o pulse las may�sculas mientras hace clic para decrementarla\n" +
"- o haga clic y arrastre el rat�n para una selecci�n m�s r�pida.",

   "PREV_YEAR"    : "A�o anterior (mantener para men�)",
   "PREV_MONTH"   : "Mes anterior (mantener para men�)",
   "GO_TODAY"     : "Ir a hoy",
   "NEXT_MONTH"   : "Mes siguiente (mantener para men�)",
   "NEXT_YEAR"    : "A�o siguiente (mantener para men�)",
   "SEL_DATE"     : "Seleccionar fecha",
   "DRAG_TO_MOVE" : "Arrastrar para mover",
   "PART_TODAY"   : " (hoy)",

   // the following is to inform that "%s" is to be the first day of week
   // %s will be replaced with the day name.
   "DAY_FIRST"    : "Hacer %s primer d�a de la semana",

   // This may be locale-dependent.  It specifies the week-end days, as an array
   // of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
   // means Monday, etc.
   "WEEKEND"      : "0,6",

   "CLOSE"        : "Cerrar",
   "TODAY"        : "Hoy",
   "TIME_PART"    : "(May�scula-)Clic o arrastre para cambiar valor",

   // date formats
   "DEF_DATE_FORMAT"  : "%d/%m/%Y",
   "TT_DATE_FORMAT"   : "%A, %e de %B de %Y",

   "WK"           : "sem",
   "TIME"         : "Hora:",
   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});


