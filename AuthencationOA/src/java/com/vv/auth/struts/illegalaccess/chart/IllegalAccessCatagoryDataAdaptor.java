package com.vv.auth.struts.illegalaccess.chart;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
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
    public AbstractDataset getDataset(List list,String[] criterias){
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        if(Utility.isNotEmpty(list)){
            for(Object o:list){
                Object[] arr = (Object[])o;
                String username = "0.匿名用户";
                String rightname = "";

                String rowName="";
                String columnName="";
                if(Utility.hasElement(criterias, "userid")&&Utility.hasElement(criterias, "trId")){
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
                    
                    if(arr[2]!=null&&((TRight)arr[2]).getRightName()!=null){
                        rightname=((TRight)arr[2]).getTrId()+"."+((TRight)arr[2]).getRightName()+"-"+((TRight)arr[2]).getRightDesc();
                    }
                    rowName = username;
                    columnName = rightname;
                }else if(Utility.hasElement(criterias, "userid")){
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
                    rightname="所有权限";

                    rowName = username;
                    columnName = rightname;
                }else if(Utility.hasElement(criterias, "trId")){
                    if(arr[1]!=null&&((TRight)arr[1]).getRightName()!=null){
                        rightname=((TRight)arr[1]).getTrId()+"."+((TRight)arr[1]).getRightName()+"-"+((TRight)arr[1]).getRightDesc();
                    }
                    username="全部用户";

                    rowName = rightname;
                    columnName = username;
                }

                data.addValue(((Long)arr[0]), rowName, columnName);
            }
        }
        return data;
    }
}
