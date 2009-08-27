// $Id: calendar-ru_win_.js 8201 2007-09-21 08:28:40Z nmaxim $
// ** I18N

// Calendar RU language
// Translation: Sly Golovanov, http://golovanov.net, <sly@golovanov.net>
// Encoding: any
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.


Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "ru_win_"], {
  // full day names
  "_DN"  : new Array
      ("�����������","�����������", "�������", "�����", "�������", "�������", "�������", "�����������"),
  // short day names
  "_SDN" : new Array
      ("���", "���", "���", "���", "���", "���", "���", "���"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 0,
  // full month names
  "_MN"  : new Array
       ("������",
       "�������",
       "����",
       "������",
       "���",
       "����",
       "����",
       "������",
       "��������",
       "�������",
       "������",
       "�������"),
  // short month names
  "_SMN" : new Array
      ("���",
       "���",
       "���",
       "���",
       "���",
       "���",
       "���",
       "���",
       "���",
       "���",
       "���",
       "���"),
   // tooltips
   "INFO" : "� ���������...",
   "ABOUT": "DHTML Date/Time Selector\n" +
      "(c) zapatec.com 2002-2007\n" + // don't translate this this ;-)
      "For latest version visit: http://www.zapatec.com\n" +
      "This translation distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
      "\n\n" +
      "��� ������� ����:\n" +
      "- ��� ������ ������ \xab, \xbb ����� ������� ���\n" +
      "- ��� ������ ������ " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " ����� ������� �����\n" +
      "- ��������� ��� ������ ��������, ����� ��������� ���� �������� ������.",
   "ABOUT_TIME" : "\n\n" +
          "��� ������� �����:\n" +
          "- ��� ����� �� ����� ��� ������� ��� �������������\n" +
          "- ��� ����� � ������� �������� Shift ��� �����������\n" +
          "- ���� ������ � ������� ������ �����/������, ��� ����� �������� �������.",

   "PREV_YEAR"    : "�� ��� ����� (���������� ��� ����)",
   "PREV_MONTH"   : "�� ����� ����� (���������� ��� ����)",
   "GO_TODAY"     : "�������",
   "NEXT_MONTH"   : "�� ����� ������ (���������� ��� ����)",
   "NEXT_YEAR"    : "�� ��� ������ (���������� ��� ����)",
   "SEL_DATE"     : "�������� ����",
   "DRAG_TO_MOVE" : "�������������� ������",
   "PART_TODAY"   : " (�������)",

   // the following is to inform that "%s" is to be the first day of week
   // %s will be replaced with the day name.
   "DAY_FIRST"    : "������ ���� ������ ����� %s",

   // This may be locale-dependent.  It specifies the week-end days, as an array
   // of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
   // means Monday, etc.
   "WEEKEND"      : "0,6",

   "CLOSE"        : "�������",
   "TODAY"        : "�������",
   "TIME_PART"    : "(Shift-)���� ��� ������ � �������",

   // date formats
   "DEF_DATE_FORMAT"  : "%Y-%m-%d",
   "TT_DATE_FORMAT"   : "%e %b, %a",

   "WK"           : "���",
   "TIME"         : "�����:",
   "E_RANGE"      : "Outside the range",
   "_AMPM"        : {am : "am",
                     pm : "pm"}
});
