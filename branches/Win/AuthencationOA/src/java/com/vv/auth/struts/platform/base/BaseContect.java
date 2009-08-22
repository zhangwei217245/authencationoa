package com.vv.auth.struts.platform.base;

import java.util.HashMap;
import java.util.Map;

public class BaseContect {

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm";
    public static final String ACCOUNTMAP = "ACCOUNTMAP";
    public static final String RIGHT_TYPE_MENU = "menu";
    public static final String RIGHT_TYPE_PATH = "path";
    //session创建时间
    public static final String SESSIONCREATETIME = "SESSIONCREATETIME";
    //session结束时间
    public static final String SESSIONENDTIME = "SESSIONENDTIME";
    public static final String FORWARD_SUCCESS = "success";
    public static final String FORWARD_FAILURE = "failure";
    public final static String UACASE = "UACASE";    //sessionId
    public final static String SESSIONID = "SESSIONID";
    public final static String FORWARD = "forward";
    public static Map securitypermissons = new HashMap();    //V6后台管理--所属模块(积分模块)
    public static final String music = "AHS";    //音乐模块
    public static final String video = "VDO";    //视频模块
    public static final String news = "NEWS";     //资讯模块
    public static final String im = "IMS";       //IM模块
    public static final String space = "SPACE";    //空间模块
    public static final String bbs = "BBS";      //论坛模块
    public static final String user = "USR";     //用户模块
    public static final String search = "SCH";   //搜索模块
    public static final String hall = "HAL";       //大厅
    public static final String reader = "RDR";       //阅读器
    //资源类型
    public static final String res_txt = "DATUU_TXT_RES";      //纯文本类型  
    public static final String res_pic = "DATUU_PIC_RES";      //图片
    public static final String res_txtpic = "DATUU_TXTPIC_RES";    //文本+图片
    public static final String res_music = "DATUU_MUSIC_SINGLE";    //音乐
    public static final String res_annex = "DATUU_ATTACH_RES";     //附件
    public static final String res_datuu = "DATUU_LOC_UNKOWN";     //本地未知类型资源
    public static final String res_big_txt = "DATUU_BIGTXT_RES";   //大文本资源
    /*//modified by zhangwei
    public static final String resource_1 = "04";   //文本
    public static final String resource_2 = "03";   //图片
    public static final String resource_3 = "03";   //文本+图片
    public static final String resource_4 = "06";   //下载
    public static final String resource_5 = "06";   //文本+下载
    public static final String resource_6 = "05";   //图片+下载
    public static final String resource_7 = "05";   //文本+图片+下载
    public static final String resource_8 = "07";   //音乐*/
    public static final String resource_1 = "1";   //文本
    public static final String resource_2 = "2";   //图片
    public static final String resource_3 = "3";   //文本+图片
    public static final String resource_4 = "4";   //下载
    public static final String resource_5 = "5";   //文本+下载
    public static final String resource_6 = "6";   //图片+下载
    public static final String resource_7 = "7";   //文本+图片+下载
    public static final String resource_8 = "8";   //音乐
    public static final String icon_1 = "01";   //积分/经验值
    public static final String icon_2 = "02";   //外调WAP浏览器
    public static final String icon_3 = "03";   //图文（资讯）
    public static final String icon_4 = "04";   //文本（资讯）
    public static final String icon_5 = "05";   //图文+附件（资讯）
    public static final String icon_6 = "06";   //文本+附件（资讯）
    public static final String icon_7 = "07";    //音乐
    public static final String icon_8 = "08";   //空间 
    public static final String icon_9 = "09";   //相册//图片  
    public static final String icon_10 = "10";   //直播类
    public static final String icon_11 = "11";   //帖子类/论坛tab类
    public static final String icon_12 = "12";   //图文+附件（帖子）//默认
    public static final String icon_13 = "13";    //文本+附件（帖子）//公告板
    public static final String icon_14 = "14";    //相册//升级
    public static final String GAME_STATE_PRE = "DATUU_LIVEROOM_PRE";  //直播厅预告
    public static final String GAME_STATE_ING = "DATUU_LIVEROOM_ING";  //直播厅直播内容
    public static final String GAME_STATE_END = "DATUU_LIVEROOM_END";   //直播结束
    public static final String DIRECTSEED_TYPE_CONTECT = "TXT";   //类型
    public static final String DIRECTSEED_TYPE_PIC = "PIC";     //图片
    public static final String DIRECTSEED_TYPE_ATCH = "ATCH";    //附件
    public static final String DIRECTSEED_TYPE_SCORE = "SCORE";  //积分
    public static final int DATUUBOOK_PAGE_COUNT = 10;
}
