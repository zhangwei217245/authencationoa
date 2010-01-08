/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.IJpaDaoService;
import com.vv.auth.persist.service.qlgenerator.QLGenerator;
import com.vv.auth.struts.util.ChartUtility;
import com.vv.auth.struts.util.Utility;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
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

    public void generatePieChartForAny(HttpServletRequest request,Integer userid,Integer trId,
            String begs,String overs) throws Exception{
        Date beg = Utility.isNotEmpty(begs)?Utility.convertStringToDate(begs, FORMATE_DATE):null;
        Date over = Utility.isNotEmpty(overs)?Utility.convertStringToDate(overs, FORMATE_DATE):null;
    }

    /**
     * 通过判断两个数组的情况和checkBox勾选的情况来自动适配数据，并生成相应的图表。
     * @param request
     * @param userids
     * @param rightids
     * @param begs
     * @param overs
     * @param criteria
     */
    public void generateCataChartForAny(HttpServletRequest request,String[] userids,String[] rightids,
            String begs,String overs,String[] criterias) throws Exception{
        Date beg = Utility.isNotEmpty(begs)?Utility.convertStringToDate(begs, FORMATE_DATE):null;
        Date over = Utility.isNotEmpty(overs)?Utility.convertStringToDate(overs, FORMATE_DATE):null;

        String dateQuery = "?datbeg="+begs+"&datover="+overs;
        List rstlst = null;
        String[] userIDs = userids;String[] rightIDs = rightids;
        String queryUrl = "/IllegalAccess/illegalAccessShowPie.do"+dateQuery;
        
        if(Utility.hasElement(criterias, "userid")){
            rstlst = getCountBySelectedUser(userids, beg, over);
            userIDs = getUseridsByTop5List(rstlst);
        }
        if(Utility.hasElement(criterias, "trId")){
            rstlst = getCountBySelectedRight(rightids, beg, over);
            rightIDs = getRightidsByTop5List(rstlst);
        }
        if(Utility.hasElement(criterias, "userid")&&Utility.hasElement(criterias, "trId")){
            queryUrl =  "/IllegalAccess/illegalAccessShowDetail.do"+dateQuery;
            rstlst = getCountBySelectedUser_Right(userIDs, rightIDs, beg, over);
        }
        
        DefaultCategoryDataset data = (DefaultCategoryDataset)catagoryDataAdaptor.getDataset(rstlst, criterias);
        JFreeChart chart = getBarChar3D("访问量统计", "分类", "访问量", data, request.getContextPath()+queryUrl);
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        BufferedImage bi = chart.createBufferedImage(800, 600, info);
        request.getSession().setAttribute(ChartUtility.ChartImageKey, bi);
        String imageMap0 = this.showDetailRecord?ImageMapUtilities.getImageMap(ChartUtility.ImageMapKey, info):"";
        request.setAttribute(ChartUtility.ImageMapKey, imageMap0);
    }
    
    /**
     * 根据指定的用户和权限查询访问量分布
     * @param userids
     * @param rightids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedUser_Right(String[] userids,String[] rightids,Date beg,Date over) throws Exception{
        Map param = new HashMap();
        jpqlGenerator.init();

        String userid = null;
        String trId = null;
        if(Utility.isEmpty(rightids)||Utility.isEmpty(userids)){
            jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        }
        if(Utility.isNotEmpty(rightids)){
            trId = "i.trId";
            jpqlGenerator.setGroupby_clause(trId);
            jpqlGenerator.setWhere_clause(null, jpqlGenerator.getIn_clause(trId+".trId",rightids));
            jpqlGenerator.setOrderby_clause(trId+".trId", "ASC");
        }
        if(Utility.isNotEmpty(userids)){
            userid = "i.userid";
            jpqlGenerator.setGroupby_clause(userid);
            String part = hasNullString(userids)?"("+jpqlGenerator.getIn_clause(userid+".userid",userids)+" OR i.userid IS NULL)":jpqlGenerator.getIn_clause(userid+".userid",userids);
            jpqlGenerator.setWhere_clause(null, part);
            jpqlGenerator.setOrderby_clause(userid, "ASC");
        }
        
        jpqlGenerator.setSelect_clause("COUNT(i)").setSelect_clause(userid).setSelect_clause(trId);

        jpqlGenerator.setFrom_clause("Illegalaccess i");


        if(beg!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if(over!=null){
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, true, -1, -1);
    }

    /**
     * 根据指定的用户查询访问量
     * @param userids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedUser(String[] userids,Date beg,Date over) throws Exception{
        Map param = new HashMap();
        jpqlGenerator.init();
        boolean all = false;
        int firstIndex = 0;
        int maxCount = 5;

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("COUNT(i)").setSelect_clause("i.userid");
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
        if(Utility.isNotEmpty(userids)){
            String part = hasNullString(userids)?"(i.userid.userid IS NULL OR "+jpqlGenerator.getIn_clause("i.userid.userid",userids)+")":jpqlGenerator.getIn_clause("i.userid.userid",userids);
            jpqlGenerator.setWhere_clause(null, part);
            jpqlGenerator.setOrderby_clause(jpqlGenerator.ORDER_BY,null);
            all = true;
            firstIndex = -1;
            maxCount = -1;
        }
        
        String jpql =  jpqlGenerator.toString();
        return jpaDaoService.findEntities(jpql, param, all, firstIndex, maxCount);
    }
    /**
     * 根据指定的权限查询访问量
     * @param rightids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedRight(String[] rightids,Date beg,Date over) throws Exception{
        Map param = new HashMap();
        jpqlGenerator.init();

        boolean all = false;
        int firstIndex = 0;
        int maxCount = 5;

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("COUNT(i)").setSelect_clause("i.trId");
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
        if(Utility.isNotEmpty(rightids)){
            jpqlGenerator.setWhere_clause(null, jpqlGenerator.getIn_clause("i.trId.trId",rightids));
            jpqlGenerator.setOrderby_clause(jpqlGenerator.ORDER_BY,null);
            all = true;
            firstIndex = -1;
            maxCount = -1;
        }
        
        String jpql =  jpqlGenerator.toString();

        return jpaDaoService.findEntities(jpql, param, all, firstIndex, maxCount);
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

    /**
     * 根据指定的参数生成3D条状图
     * @param title
     * @param catalable
     * @param valuelabel
     * @param data
     * @param baseUrl
     * @return
     */
    private JFreeChart getBarChar3D(String title,String catalable,String valuelabel,DefaultCategoryDataset data,String baseUrl) throws Exception{
        JFreeChart chart = ChartFactory.createBarChart3D(title, catalable, valuelabel, data,
                PlotOrientation.VERTICAL, true,
                true,true);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer3D render = new BarRenderer3D();
        render.setDrawBarOutline(true);
        render.setBaseOutlinePaint(new ChartColor(0, 0, 0));
        render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        render.setBaseItemLabelsVisible(true);
        render.setBaseItemURLGenerator(new StandardCategoryURLGenerator(baseUrl, "username", "rightname"));
        render.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}<-->{1}: 被访问{2}次", new DecimalFormat("###,###")));

        plot.setRenderer(render);
        plot.setForegroundAlpha(0.8f);
        plot.setNoDataMessage("没有可用的数据");
        plot.setNoDataMessagePaint(Color.red);
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
            Object[] arr = (Object[])list.get(i);
            if(arr[1]!=null&&((Vcustomer)arr[1]).getName()!=null){
                userids[i]=((Vcustomer)arr[1]).getUserid().toString();
            }else{
                userids[i]="null";
            }
            if(i>=5){
                return userids;
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
            Object[] arr = (Object[])list.get(j);
            rightids[j]=((TRight)arr[1]).getTrId().toString();
            if(j>=5){
                return rightids;
            }
        }
        return rightids;
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
