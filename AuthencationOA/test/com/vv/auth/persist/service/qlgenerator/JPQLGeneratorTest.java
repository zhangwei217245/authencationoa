/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service.qlgenerator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        JPQLGenerator jpqlGenerator= new JPQLGenerator();
        jpqlGenerator.setSelect_clause("count(o)").setSelect_clause("o.userid")
                .setFrom_clause("Student o");
        jpqlGenerator
                .setWhere_clause(null, "o.userid=1").setWhere_clause("OR", "o.username='abc'").setWhere_clause(null, "o.usersex=0")
                .setGroupby_clause("o.userid").setGroupby_clause("o.usergroupid")
                .setHaving_clause(null, "o.userid in (1,2,3)").setHaving_clause("OR", "o.usergroupid in (1,2)")
                .setOrderby_clause("o.username", null);
        System.out.println(jpqlGenerator.toString());
    }

}