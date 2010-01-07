/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.entity.IllegalAccessData;
import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.persist.service.qlgenerator.QLGenerator;
import com.vv.auth.struts.util.ChartUtility;
import com.vv.auth.struts.util.Utility;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;

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
    @Resource
    private DataSetAdaptor catagoryDataAdaptor;
    @Resource
    private DataSetAdaptor pieDataAdaptor;
    /**
     * 是否展示给出用于展示详细记录的MAP链接
     */
    private boolean showDetailRecord;


    private String showDetailForms;

    
    public void generateCataChartForNone(HttpServletRequest request,String begs,String overs){
        Date beg = Utility.convertStringToDate(begs, FORMATE_DATE);
        Date over = Utility.convertStringToDate(overs, FORMATE_DATE);

        List top5user = getTop5ByUser(beg, over);
        List top5right = getTop5ByRight(beg, over);
        String[] userids = getUseridsByTop5List(top5user);
        String[] rightids = getRightidsByTop5List(top5right);

        List rstlst = getCountBySelectedUser_Right(userids, rightids, beg, over);
        DefaultCategoryDataset data = (DefaultCategoryDataset)catagoryDataAdaptor.getDataset(rstlst, null);
        JFreeChart chart = getBarChar3D("访问量统计", "分类", "访问量", data, showDetailRecord, request.getContextPath()+"/IllegalAccess/illegalAccessShowDetail.do");
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        BufferedImage bi = chart.createBufferedImage(800, 600, info);
        request.getSession().setAttribute(ChartUtility.ChartImageKey, bi);
        String imageMap0 = ImageMapUtilities.getImageMap(ChartUtility.ImageMapKey, info);
        request.setAttribute(ChartUtility.ImageMapKey, imageMap0);
    }

    private JFreeChart getBarChar3D(String title,String catalable,String valuelabel,DefaultCategoryDataset data,boolean showDetailRecord,String baseUrl){
        JFreeChart chart = ChartFactory.createBarChart3D(title, catalable, valuelabel, data,
                PlotOrientation.VERTICAL, true,
                true, showDetailRecord);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer3D render = new BarRenderer3D();
        render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        render.setBaseItemLabelsVisible(true);
        if(showDetailRecord){
            render.setBaseItemURLGenerator(new StandardCategoryURLGenerator(baseUrl, "username", "rightname"));
        }
        plot.setRenderer(render);
        plot.setForegroundAlpha(0.7f);

        return chart;
    }
    /**
     * 通过访问量前5名的用户记录得到含有这5个用户ID的字符串数组
     * @param list
     * @return
     */
    private String[] getUseridsByTop5List(List list){
        String[] userids = new String[list.size()];
        for(int i=0;i<list.size();i++){
            IllegalAccessData iad = (IllegalAccessData)list.get(i);
            if(iad.getUser()!=null){
                userids[i]=iad.getUser().getUserid().toString();
            }else{
                userids[i]="null";
            }
        }
        return userids;
    }
    /**
     * 通过访问量前5名的权限记录得到含有这5个权限ID的字符串数组
     * @param list
     * @return
     */
    private String[] getRightidsByTop5List(List list){
        String[] rightids = new String[list.size()];
        for(int j=0;j<list.size();j++){
            IllegalAccessData iad = (IllegalAccessData)list.get(j);
            rightids[j]=iad.getRight().getTrId().toString();
        }
        return rightids;
    }

    /**
     * 根据指定的用户和权限查询访问量分布
     * @param userids
     * @param rightids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedUser_Right(String[] userids,String[] rightids,Date beg,Date over){
        Map param = new HashMap();
        jpqlGenerator.init();

        String userid = "NULL";
        String trId = "NULL";
        if(Utility.isEmpty(rightids)||Utility.isEmpty(userids)){
            jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        }
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
            if(this.hasNullString(userids)){
                jpqlGenerator.setHaving_clause("OR", "i.userid IS NULL");
            }
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
        if(this.hasNullString(userids)){
            jpqlGenerator.setHaving_clause("OR", "i.userid IS NULL");
        }
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

    private boolean hasNullString(String[] strs){
        if(Utility.isNotEmpty(strs)){
            for(String s:strs){
                if(Utility.isEmpty(s)||s.equalsIgnoreCase("null")){
                    return true;
                }
            }
            return false;
        }
        return false;
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
