/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service.qlgenerator;

import com.vv.auth.struts.util.Utility;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author x-spirit
 */
public class JPQLGeneratorTest {

    ApplicationContext ctx;
    public JPQLGeneratorTest() {
        //String[] path=new String[]{"classpath:applicationContext.xml"};
        //ctx=new ClassPathXmlApplicationContext(path);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testJPQLGenerate(){
        QLGenerator jpqlGenerator = new JPQLGenerator();
        Map param = new HashMap();
        jpqlGenerator.init();

        String userid = "NULL";
        String trId = "NULL";
        String[] rightids = {"1","2","3"};
        String[] userids =  {"1","2","3"};
        Date beg = new Date();
        Date over = new Date();
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
        System.out.println(jpql);
    }

}