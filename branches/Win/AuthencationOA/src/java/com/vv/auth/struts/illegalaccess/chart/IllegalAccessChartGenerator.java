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
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

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
    private boolean showChartIn3D;

    public void generatePieChartForAny(HttpServletRequest request, String username, String rightname,
            String begs, String overs) throws Exception {
        Date beg = Utility.isNotEmpty(begs) ? Utility.convertStringToDate(begs, FORMATE_DATE) : null;
        Date over = Utility.isNotEmpty(overs) ? Utility.convertStringToDate(overs, FORMATE_DATE) : null;

        String queryUrl = "/IllegalAccess/illegalAccessShowDetail.do";
        String dateQuery = "?datbeg=" + begs + "&datover=" + overs;
        String title = "非法访问量分布";
        String cateName = "piecate",indexName="pieindex";

        String[] uarr = Utility.isNotEmpty(username)?username.split("\\."):null;
        String[] rarr = Utility.isNotEmpty(rightname)?rightname.split("\\."):null;

        String userid = null;
        String trId = null;
        if(Utility.isNotEmpty(uarr)&&uarr.length>1){
            userid = uarr[0];
            title = "用户["+username+"]"+title;
            cateName = "rightname";
            dateQuery = dateQuery + "&username=" + username;
        }

        if(Utility.isNotEmpty(rarr)&&rarr.length>1){
            trId = rarr[0];
            title = "权限["+rightname+"]"+title;
            cateName = "username";
            dateQuery = dateQuery + "&rightname=" + rightname;
        }

        String criteria = Utility.isNotEmpty(userid) ? "trId" : (Utility.isNotEmpty(trId) ? "userid" : null);
        String conditionid = Utility.isNotEmpty(userid) ? userid : (Utility.isNotEmpty(trId) ? trId : null);
        List rstlst = getCountByUser_RightCondition(conditionid, criteria, beg, over);

        DefaultPieDataset data = (DefaultPieDataset) pieDataAdaptor.getDataset(rstlst, new String[]{criteria});
        JFreeChart chart = getPieChart(title, data, request.getContextPath() + queryUrl+dateQuery, cateName, indexName);
        saveChartImageInRequest(request, chart);
    }

    /**
     * 根据指定的参数生成3D饼状图
     * @param title
     * @param data
     * @return
     */
    private JFreeChart getPieChart(String title, PieDataset data, String queryUrl,String cateName,String indexName) {
        JFreeChart chart = showChartIn3D ? ChartFactory.createPieChart3D(title, data, true, true, true)
                : ChartFactory.createPieChart(title, data, true, true, true);
        PiePlot plot = (PiePlot) chart.getPlot();
        //图形边框颜色
        plot.setBaseSectionOutlinePaint(Color.black);
        //设置饼状图的绘制方向，可以按顺时针方向绘制，也可以按逆时针方向绘制
        plot.setDirection(Rotation.CLOCKWISE);
        //设置背景色透明度
        plot.setBackgroundAlpha(0.7F);
        // 设置前景色透明度
        plot.setForegroundAlpha(0.8F);
        // 扇区分离显示,对3D图不起效
        plot.setExplodePercent(data.getKey(0), 0.3d);
        // 图例显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}:访问{1}次\r\n(占{2})", NumberFormat.getNumberInstance(),
                new DecimalFormat("0.00%")));

        // 没有数据的时候显示的内容
        plot.setNoDataMessage("找不到可用数据...");
        plot.setNoDataMessagePaint(Color.red);
        plot.setNoDataMessageFont(new Font("宋体", Font.BOLD, 36));

        //设置鼠标悬停提示
        plot.setToolTipGenerator(new StandardPieToolTipGenerator("{0}:访问{1}次\r\n(占{2})", NumberFormat.getNumberInstance(),
                new DecimalFormat("0.00%")));
        //设置热点链接
        if (showDetailRecord) {
            plot.setURLGenerator(new StandardPieURLGenerator(queryUrl, cateName, indexName));
        }
        return chart;
    }

    /**
     * 用于饼状图数据的生成，根据指定的用户ID或者权限ID查询该用户对各个权限的访问情况或者该权限被各个用户访问的情况
     * @param conditionid
     * @param criteria
     * @param beg
     * @param over
     * @return
     * @throws Exception
     */
    private List getCountByUser_RightCondition(String conditionid, String criteria, Date beg, Date over) throws Exception {
        Map param = new HashMap();
        jpqlGenerator.init();
        String userid = "i.userid";
        String trId = "i.trId";
        jpqlGenerator.setSelect_clause("COUNT(i)");
        jpqlGenerator.setFrom_clause("Illegalaccess i");

        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        if ("userid".equalsIgnoreCase(criteria)) {
            jpqlGenerator.setWhere_clause(null, trId + ".trId=" + conditionid);
            jpqlGenerator.setSelect_clause(userid).setGroupby_clause(userid);
        } else if ("trId".equalsIgnoreCase(criteria)) {
            jpqlGenerator.setWhere_clause(null, userid + ".userid=" + conditionid);
            if (Utility.isEmpty(conditionid) || conditionid.equals("0")) {
                jpqlGenerator.setWhere_clause(null, jpqlGenerator.WHERE).setWhere_clause(null, userid + " IS NULL");
            }
            jpqlGenerator.setSelect_clause(trId).setGroupby_clause(trId);
        } else {
            return null;
        }
        if (beg != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if (over != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }
        jpqlGenerator.setWhere_clause(null, "i.trId.rightType='path'");

        String jpql = jpqlGenerator.toString();
        

        return jpaDaoService.findEntities(jpql, param, true, -1, -1);
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
    public void generateCataChartForAny(HttpServletRequest request, String[] userids, String[] rightids,
            String begs, String overs, String[] criterias) throws Exception {
        Date beg = Utility.isNotEmpty(begs) ? Utility.convertStringToDate(begs, FORMATE_DATE) : null;
        Date over = Utility.isNotEmpty(overs) ? Utility.convertStringToDate(overs, FORMATE_DATE) : null;

        String dateQuery = "?datbeg=" + begs + "&datover=" + overs;

        List rstlst = null;
        String[] userIDs = userids;
        String[] rightIDs = rightids;

        if (Utility.hasElement(criterias, "userid")) {
            rstlst = getCountBySelectedUser(userids, beg, over);
            userIDs = getUseridsByTop5List(rstlst);
        }
        if (Utility.hasElement(criterias, "trId")) {
            rstlst = getCountBySelectedRight(rightids, beg, over);
            rightIDs = getRightidsByTop5List(rstlst);
        }
        String queryUrl = "/IllegalAccess/illegalAccessShowPie.do" + dateQuery;
        if (Utility.hasElement(criterias, "userid") && Utility.hasElement(criterias, "trId")) {
            queryUrl = "/IllegalAccess/illegalAccessShowDetail.do" + dateQuery;
            rstlst = getCountBySelectedUser_Right(userIDs, rightIDs, beg, over);
        }

        DefaultCategoryDataset data = (DefaultCategoryDataset) catagoryDataAdaptor.getDataset(rstlst, criterias);
        JFreeChart chart = getBarChar("非法访问量统计", "分类", "访问量", data, request.getContextPath() + queryUrl);
        saveChartImageInRequest(request, chart);
    }

    /**
     * 将生成的CHART变成BufferedImage存入Session，将相应的MAP存入Request
     * @param request
     * @param chart
     */
    private void saveChartImageInRequest(HttpServletRequest request, JFreeChart chart) {
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        BufferedImage bi = chart.createBufferedImage(800, 600, info);
        request.getSession().setAttribute(ChartUtility.ChartImageKey, bi);
        String imageMap0 = ImageMapUtilities.getImageMap(ChartUtility.ImageMapKey, info);
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
    private List getCountBySelectedUser_Right(String[] userids, String[] rightids, Date beg, Date over) throws Exception {
        Map param = new HashMap();
        jpqlGenerator.init();

        String userid = null;
        String trId = null;
        if (Utility.isEmpty(rightids) || Utility.isEmpty(userids)) {
            jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        }
        if (Utility.isNotEmpty(rightids)) {
            trId = "i.trId";
            jpqlGenerator.setGroupby_clause(trId);
            jpqlGenerator.setHaving_clause(null, jpqlGenerator.getIn_clause(trId + ".trId", rightids));
            jpqlGenerator.setOrderby_clause(trId + ".trId", "ASC");
        }
        if (Utility.isNotEmpty(userids)) {
            userid = "i.userid";
            jpqlGenerator.setGroupby_clause(userid);
            String part = hasNullString(userids) ? "(" + jpqlGenerator.getIn_clause(userid + ".userid", userids) + " OR i.userid IS NULL)" : jpqlGenerator.getIn_clause(userid + ".userid", userids);
            jpqlGenerator.setHaving_clause(null, part);
            jpqlGenerator.setOrderby_clause(userid + ".userid", "ASC");
        }

        jpqlGenerator.setSelect_clause("COUNT(i)").setSelect_clause(userid).setSelect_clause(trId);

        jpqlGenerator.setFrom_clause("Illegalaccess i");


        if (beg != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if (over != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }
        jpqlGenerator.setWhere_clause(null, "i.trId.rightType='path'");
        String jpql = jpqlGenerator.toString();
        
        return jpaDaoService.findEntities(jpql, param, true, -1, -1);
    }

    /**
     * 根据指定的用户查询访问量
     * @param userids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedUser(String[] userids, Date beg, Date over) throws Exception {
        Map param = new HashMap();
        jpqlGenerator.init();
        boolean all = false;
        int firstIndex = 0;
        int maxCount = 5;

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("COUNT(i)").setSelect_clause("i.userid");
        if (beg != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if (over != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        jpqlGenerator.setGroupby_clause("i.userid");
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        if (Utility.isNotEmpty(userids)) {
            String part = hasNullString(userids) ? "(i.userid.userid IS NULL OR " + jpqlGenerator.getIn_clause("i.userid.userid", userids) + ")" : jpqlGenerator.getIn_clause("i.userid.userid", userids);
            jpqlGenerator.setHaving_clause(null, part);
            jpqlGenerator.setOrderby_clause("i.userid.userid", "ASC");
            all = true;
            firstIndex = -1;
            maxCount = -1;
        }
        jpqlGenerator.setWhere_clause(null, "i.trId.rightType='path'");
        String jpql = jpqlGenerator.toString();
        
        return jpaDaoService.findEntities(jpql, param, all, firstIndex, maxCount);
    }

    /**
     * 根据指定的权限查询访问量
     * @param rightids
     * @param beg
     * @param over
     * @return
     */
    private List getCountBySelectedRight(String[] rightids, Date beg, Date over) throws Exception {
        Map param = new HashMap();
        jpqlGenerator.init();

        boolean all = false;
        int firstIndex = 0;
        int maxCount = 5;

        jpqlGenerator.setFrom_clause("Illegalaccess i");
        jpqlGenerator.setSelect_clause("COUNT(i)").setSelect_clause("i.trId");
        if (beg != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime>=:beg");
            param.put("beg", beg);
        }
        if (over != null) {
            jpqlGenerator.setWhere_clause(null, "i.dataccesstime<=:over");
            param.put("over", over);
        }

        jpqlGenerator.setGroupby_clause("i.trId");
        jpqlGenerator.setOrderby_clause("COUNT(i)", "DESC");
        if (Utility.isNotEmpty(rightids)) {
            jpqlGenerator.setHaving_clause(null, jpqlGenerator.getIn_clause("i.trId.trId", rightids));
            jpqlGenerator.setOrderby_clause("i.trId.trId", "ASC");

            all = true;
            firstIndex = -1;
            maxCount = -1;
        }
        jpqlGenerator.setWhere_clause(null, "i.trId.rightType='path'");
        String jpql = jpqlGenerator.toString();
        
        return jpaDaoService.findEntities(jpql, param, all, firstIndex, maxCount);
    }

    private boolean hasNullString(String[] strs) {
        if (Utility.isNotEmpty(strs)) {
            for (String s : strs) {
                if (Utility.isEmpty(s) || s.equalsIgnoreCase("null")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * 根据指定的参数生成条状图
     * @param title
     * @param catalable
     * @param valuelabel
     * @param data
     * @param baseUrl
     * @return
     */
    private JFreeChart getBarChar(String title, String catalable, String valuelabel, DefaultCategoryDataset data, String baseUrl) throws Exception {
        JFreeChart chart = ChartFactory.createBarChart3D(title, catalable, valuelabel, data,
                PlotOrientation.VERTICAL, true,
                true, true);
        CategoryPlot plot = chart.getCategoryPlot();
        //根据3D视觉开关来得到不同的条状图渲染器
        BarRenderer render = showChartIn3D ? new BarRenderer3D() : new BarRenderer();
        render.setDrawBarOutline(true);
        render.setBaseOutlinePaint(new ChartColor(0, 0, 0));
        //设定柱状图的数据标签，做完整显示。
        //render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("访问 {2} 次", new DecimalFormat("###,###")));
        //设定柱状图的数据标签，只显示计数。
        render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("###,###")));

        render.setBaseItemLabelsVisible(true);
        if (showDetailRecord) {
            render.setBaseItemURLGenerator(new StandardCategoryURLGenerator(baseUrl, "username", "rightname"));
        }
        if(Utility.isNotEmpty(baseUrl)&&baseUrl.contains("illegalAccessShowPie.do")){
            render.setBaseItemURLGenerator(new StandardCategoryURLGenerator(baseUrl, "username", "rightname"));
        }
        
        render.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}<-->{1}: 访问{2}次", new DecimalFormat("###,###")));

        plot.setRenderer(render);
        plot.setForegroundAlpha(0.8f);
        plot.setNoDataMessage("没有可用的数据");
        plot.setNoDataMessagePaint(Color.red);
        plot.setNoDataMessageFont(new Font("宋体", Font.BOLD, 36));
        return chart;
    }

    /**
     * 通过访问量前5名的用户记录得到含有这5个用户ID的字符串数组
     * @param list
     * @return
     */
    private String[] getUseridsByTop5List(List list) {
        String[] userids = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Object[] arr = (Object[]) list.get(i);
            if (arr[1] != null && ((Vcustomer) arr[1]).getName() != null) {
                userids[i] = ((Vcustomer) arr[1]).getUserid().toString();
            } else {
                userids[i] = "null";
            }
            if (i >= 5) {
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
    private String[] getRightidsByTop5List(List list) {
        String[] rightids = new String[list.size()];
        for (int j = 0; j < list.size(); j++) {
            Object[] arr = (Object[]) list.get(j);
            rightids[j] = ((TRight) arr[1]).getTrId().toString();
            if (j >= 5) {
                return rightids;
            }
        }
        return rightids;
    }

    public boolean isShowDetailRecord() {
        return showDetailRecord;
    }

    public void setShowDetailRecord(boolean showDetailRecord) {
        this.showDetailRecord = showDetailRecord;
    }

    public boolean isShowChartIn3D() {
        return showChartIn3D;
    }

    public void setShowChartIn3D(boolean showChartIn3D) {
        this.showChartIn3D = showChartIn3D;
    }
}
