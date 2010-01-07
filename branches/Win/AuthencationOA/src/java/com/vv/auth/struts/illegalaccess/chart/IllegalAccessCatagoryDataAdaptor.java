/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.entity.IllegalAccessData;
import com.vv.auth.struts.util.Utility;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.AbstractDataset;

/**
 * 专门为以下6种情况进行条状图数据适配
 * 1.既没有选择用户，也没有选择权限的：分别取出访问量最高前5名用户和访问量最高的前五个权限，然后利用它们生成3D条状图，按照先权限后用户的原则进行排序
 * 2.选择了用户，没有选择权限，并且没有指定具体的用户：列出访问量最高前5名用户，按访问量排序
 * 3.选择了用户，没有选择权限，并且指定了具体的某几个用户：列出指定的用户的访问量，按访问量排序
 * 4.选择了权限，没有选择用户，并且没有指定具体的权限：列出访问量最高的前5名用户，按访问量排序
 * 5.选择了权限，没有选择用户，并且指定了具体的某几个权限：列出指定的权限的访问量，按访问量排序
 * 6.既指定了某几个用户，又指定了某几个权限：列出各个权限下各个用户的访问量统计图，按照先权限，后用户的方式排序。
 * @author x-spirit
 */
public class IllegalAccessCatagoryDataAdaptor implements DataSetAdaptor{
    public AbstractDataset getDataset(List list,String criteria){
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        if(Utility.isNotEmpty(list)){
            for(Object o:list){
                IllegalAccessData iad = (IllegalAccessData)o;
                String username = "0.匿名用户";
                if(iad.getUser()!=null){
                    username=iad.getUser().getUserid()+"."+iad.getUser().getName();
                }
                String rightname = "";
                if(iad.getRight()!=null){
                    rightname=iad.getRight().getTrId()+"."+iad.getRight().getRightName()+"-"+iad.getRight().getRightDesc();
                }
                if(Utility.isNotEmpty(criteria)&&criteria.equalsIgnoreCase("userid")){
                    rightname="";
                }
                if(Utility.isNotEmpty(criteria)&&criteria.equalsIgnoreCase("trId")){
                    username="";
                }

                data.addValue(iad.getScount(), username, rightname);
            }
        }
        return data;
    }
}
