/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.struts.util.Utility;
import java.util.List;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 为饼状图进行数据准备
 * @author x-spirit
 */
public class IllegalAccessPieDataAdaptor implements DataSetAdaptor {
    public AbstractDataset getDataset(List list,String[] criterias){
        DefaultPieDataset dataset = new DefaultPieDataset();

        if(Utility.isNotEmpty(list)){
            int i=0;
            for(Object o:list){
                String cri = (++i)+"";
                Object[] arr = (Object[])o;
                String username = "0.匿名用户";
                String rightname = "";
                if(Utility.hasElement(criterias, "userid")){
                    if(arr[1]!=null&&((Vcustomer)arr[1]).getName()!=null){
                        username=((Vcustomer)arr[1]).getUserid()+"."+((Vcustomer)arr[1]).getName();
                        if(Utility.isNotEmpty(((Vcustomer)arr[1]).getTGroupCollection())){
                            for(TGroup group:((Vcustomer)arr[1]).getTGroupCollection()){
                                if(username.contains("@")){
                                    username = username + " & " + group.getTgDesc();
                                }else{
                                    username = username + " @ " + group.getTgDesc();
                                }
                            }
                        }
                    }
                    cri = username;
                }else if(Utility.hasElement(criterias, "trId")){
                    if(arr[1]!=null&&((TRight)arr[1]).getRightName()!=null){
                        rightname=((TRight)arr[1]).getTrId()+"."+((TRight)arr[1]).getRightName()+"-"+((TRight)arr[1]).getRightDesc();
                    }
                    cri = rightname;
                }
                dataset.setValue(cri, ((Long)arr[0]));
                
            }
        }
        return dataset;
    }
}
