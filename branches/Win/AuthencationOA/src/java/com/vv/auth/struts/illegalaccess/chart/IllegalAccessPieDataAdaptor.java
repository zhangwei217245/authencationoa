/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.entity.IllegalAccessData;
import com.vv.auth.struts.util.Utility;
import java.util.List;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 为饼状图进行数据准备
 * @author x-spirit
 */
public class IllegalAccessPieDataAdaptor implements DataSetAdaptor {
    public AbstractDataset getDataset(List list,String criteria){
        DefaultPieDataset dataset = new DefaultPieDataset();

        if(!list.isEmpty()){
            int i=0;
            for(Object o:list){
                i++;
                IllegalAccessData iad = (IllegalAccessData)o;
                String username = "匿名用户";
                if(iad.getUser()!=null){
                    username=iad.getUser().getName();
                }
                String cri = i+"";
                String rightname = iad.getRight().getRightName()+"-"+iad.getRight().getRightDesc();
                if(Utility.isNotEmpty(criteria)&&criteria.equalsIgnoreCase("USER")){
                    cri = username;
                }
                if(Utility.isNotEmpty(criteria)&&criteria.equalsIgnoreCase("RIGHT")){
                    cri = rightname;
                }
                dataset.setValue(cri, iad.getScount());
            }
        }
        return dataset;
    }
}
