/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.persist.service.qlgenerator.QLGenerator;
import com.vv.auth.struts.util.Utility;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

/**
 * 生成条状图或者饼状图。
 * @author x-spirit
 */
public class IllegalAccessChartGenerator {
    public static final String FORMATE_DATE = "yyyy-MM-dd HH:mm:ss";
    @Resource
    private IJpaDaoService jpaDaoService;
    @Resource
    private QLGenerator jpqlGenerator;
    /**
     * 是否展示给出用于展示详细记录的MAP链接
     */
    private boolean showDetailRecord;


    private String showDetailForms;

    
    public void generateCataChartForNone(String begs,String overs){
        Date beg = Utility.convertStringToDate(begs, FORMATE_DATE);
        Date over = Utility.convertStringToDate(overs, FORMATE_DATE);

        List top5user = getTop5ByUser(beg, over);
        List top5right = getTop5ByRight(beg, over);

        

        
    }

    private List getCountBySelectedUser_Right(String[] userids,String[] rightids,Date beg,Date over){
        Map param = new HashMap();
        jpqlGenerator.init();

        String userid = "NULL";
        String trId = "NULL";
        if(Utility.isNotEmpty(rightids)){
            trId = "i.trId";
            jpqlGenerator.setGroupby_clause("i.trId");
            jpqlGenerator.setHaving_clause(null, jpqlGenerator.getIn_clause("i.trId.trId",rightids));
            jpqlGenerator.setOrderby_clause(trId, "ASC");
        }
        if(Utility.isNotEmpty(userids)){
            userid = "i.userid";
            jpqlGenerator.setGroupby_clause("i.userid");
            jpqlGenerator.setHaving_clause(null, jpqlGenerator.getIn_clause("i.userid.userid",userids));
            jpqlGenerator.setOrderby_clause(userid, "ASC");
        }
        

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("new com.vv.auth.persist.entity.IllegalAccessData(COUNT(i),"+userid+","+trId+")");
        if(beg!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if(over!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, false, 1, 5);
    }

    /**
     * 根据指定的用户查询访问量
     * @param userids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedUser(String[] userids,Date beg,Date over){
        Map param = new HashMap();
        jpqlGenerator.init();

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("new com.vv.auth.persist.entity.IllegalAccessData(COUNT(i),i.userid,NULL)");
        if(beg!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if(over!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        jpqlGenerator.setGroupby_clause("i.userid");
        jpqlGenerator.setHaving_clause(null, jpqlGenerator.getIn_clause("i.userid.userid",userids));
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, false, 1, 5);
    }
    /**
     * 根据指定的权限查询访问量
     * @param rightids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedRight(String[] rightids,Date beg,Date over){
        Map param = new HashMap();
        jpqlGenerator.init();

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("new com.vv.auth.persist.entity.IllegalAccessData(COUNT(i),NULL,i.trId)");
        if(beg!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if(over!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        jpqlGenerator.setGroupby_clause("i.trId");
        jpqlGenerator.setHaving_clause(null, jpqlGenerator.getIn_clause("i.trId.trId",rightids));
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, false, 1, 5);
    }

    /**
     * 取出指定时间段内权限访问量的排名前5名
     * @param beg
     * @param over
     * @return
     */
    private List getTop5ByRight(Date beg,Date over){
        Map param = new HashMap();
        jpqlGenerator.init();

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("new com.vv.auth.persist.entity.IllegalAccessData(COUNT(i),NULL,i.trId)");
        if(beg!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if(over!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        jpqlGenerator.setGroupby_clause("i.trId");
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, false, 1, 5);
    }
    /**
     * 取出指定时间段内用户访问量的排名前5名
     * @param beg
     * @param over
     * @return
     */
    private List getTop5ByUser(Date beg,Date over){
        Map param = new HashMap();
        jpqlGenerator.init();

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("new com.vv.auth.persist.entity.IllegalAccessData(COUNT(i),i.userid,NULL)");
        if(beg!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if(over!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        jpqlGenerator.setGroupby_clause("i.userid");
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, false, 1, 5);
    }

    public String getShowDetailForms() {
        return showDetailForms;
    }

    public void setShowDetailForms(String showDetailForms) {
        this.showDetailForms = showDetailForms;
    }

    public boolean isShowDetailRecord() {
        return showDetailRecord;
    }

    public void setShowDetailRecord(boolean showDetailRecord) {
        this.showDetailRecord = showDetailRecord;
    }

    
    
}
