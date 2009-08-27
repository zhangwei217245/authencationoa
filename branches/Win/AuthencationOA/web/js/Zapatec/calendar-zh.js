// $Id: calendar-zh.js 8295 2007-09-26 08:42:04Z nmaxim $
// ** Translated by ATang ** I18N

Zapatec.Utils.createNestedHash(Zapatec, ["Langs", "Zapatec.Calendar", "zh"], {
  // full day names
  "_DN"  : new Array
("星期日",
 "星期一",
 "星期二",
 "星期三",
 "星期四",
 "星期五",
 "星期六",
 "星期日"),
  // short day names
  "_SDN" : new Array
("日",
 "一",
 "二",
 "三",
 "四",
 "五",
 "六",
 "日"),
  // First day of the week. "0" means display Sunday first, "1" means display
  // Monday first, etc.
  "_FD"  : 0,
  // full month names
  "_MN"  : new Array
("一月",
 "二月",
 "三月",
 "四月",
 "五月",
 "六月",
 "七月",
 "八月",
 "九月",
 "十月",
 "十一月",
 "十二月"),
  // short month names
  "_SMN" : new Array
("一月",
 "二月",
 "三月",
 "四月",
 "五月",
 "六月",
 "七月",
 "八月",
 "九月",
 "十月",
 "十一月",
 "十二月"),
   // tooltips
   "INFO" : "关于日历",
   "ABOUT": "DHTML 日期/时间 选择器\n" +
            "(c) zapatec.com 2002-2007\n" + // don't translate this this ;-)
            "欲寻最新版请访问: http://www.zapatec.com/\n" +
            "\n\n" +
            "日期选择:\n" +
            "- 使用 \xab, \xbb 按钮来选择年份\n" +
            "- 使用 " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " 按钮来选择月份\n" +
            "- 按住上面的按钮可以快速选取",
   "关于时间" : "\n\n" +
                  "时间选择:\n" +
                  "- 单击任何时间部分可以使其增加\n" +
                  "- 或者 按住Shift并单击可以使其减少\n" +
                  "- 或者 点击并拖拽可以加快选择速度",

   "PREV_YEAR"    : "上一年(按住出菜单)",
   "PREV_MONTH"   : "上一月(按住出菜单)",
   "GO_TODAY"     : "到今天",
   "NEXT_MONTH"   : "下一月(按住出菜单)",
   "NEXT_YEAR"    : "下一年(按住出菜单)",
   "SEL_DATE"     : "选择日期",
   "DRAG_TO_MOVE" : "拖拽并移动",
   "PART_TODAY"   : " (今天)",
   "MON_FIRST" : "以周一开始",
   "SUN_FIRST" : "以周日开始",

   // the following is to inform that "%s" is to be the first day of week
   // %s will be replaced with the day name.
   "DAY_FIRST"    : "将 %s 显示在前",

   // This may be locale-dependent.  It specifies the week-end days, as an array
   // of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
   // means Monday, etc.
   "WEEKEND"      : "0,6",

   "CLOSE"        : "关闭",
   "TODAY"        : "今天",
   "TIME_PART"    : "(Shift-)点击并水平拖拽以改变值",

   // date formats
   "DEF_DATE_FORMAT"  : "%Y-%m-%d",
   "TT_DATE_FORMAT"   : "%a, %b %e",

   "WK"           : "周",
   "TIME"         : "时间:",
   "E_RANGE"      : "超出范围",
   "_AMPM"        : {am : "上午",
                     pm : "下午"}
});
