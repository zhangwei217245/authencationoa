/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TRight;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 *
 * @author X-Spirit
 */
public class TrightServiceTest {
    ApplicationContext ctx;
    public TrightServiceTest() {
        String[] path=new String[]{"classpath:applicationContext.xml"};
        ctx=new ClassPathXmlApplicationContext(path);
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
    /**
     * Test of saveRight method, of class TrightService.
     */
    @Test
    public void testSaveRight() throws Exception {
        System.out.println("saveRight");
        TRight right = new TRight(null, "用户组管理", "menu", "/GroupMana/showGroups.do");
        //TRight right = new TRight(null, "用户组管理--用户组列表", "path", "/GroupMana/showGroups.do");

        IRightService instance = (IRightService)ctx.getBean("trightService");
        if(instance.findRightByTypeAndPath(right.getRightType(), right.getRightPath()).size()<=0){
            instance.saveRight(right);
        }
        
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of deleteRight method, of class TrightService.
     */
    //@Test
    public void testDeleteRight() {
        System.out.println("deleteRight");
        Integer rightid = null;
        IRightService instance = (IRightService)ctx.getBean("trightService");
        instance.deleteRight(rightid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of queryRightList method, of class TrightService.
     */
    @Test
    public void testQueryRightList() {
        System.out.println("queryRightList");
        IRightService instance = (IRightService)ctx.getBean("trightService");
        
        List<TRight> result = instance.queryRightList();
        for (TRight right:result){
            System.out.println("############# "+right.getRightType()+"############ "+right.getRightPath());
        }
        
    }

    /**
     * Test of findRightById method, of class TrightService.
     */
    //@Test
    public void testFindRightById() {
        System.out.println("findRightById");
        Integer id = null;
        IRightService instance = (IRightService)ctx.getBean("trightService");
        TRight expResult = null;
        TRight result = instance.findRightById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRightByName method, of class TrightService.
     */
    //@Test
    public void testFindRightByName() {
        System.out.println("findRightByName");
        String rightName = "";
        IRightService instance = (IRightService)ctx.getBean("trightService");
        List<TRight> expResult = null;
        List<TRight> result = instance.findRightByName(rightName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRightByType method, of class TrightService.
     */
    //@Test
    public void testFindRightByType() {
        System.out.println("findRightByType");
        String rightType = "";
        IRightService instance = (IRightService)ctx.getBean("trightService");
        List<TRight> expResult = null;
        List<TRight> result = instance.findRightByType(rightType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRightByTypeAndPath method, of class TrightService.
     */
    //@Test
    public void testFindRightByTypeAndPath() {
        System.out.println("findRightByTypeAndPath");
        String rightType = "";
        String rightPath = "";
        IRightService instance = (IRightService)ctx.getBean("trightService");
        List<TRight> expResult = null;
        List<TRight> result = instance.findRightByTypeAndPath(rightType, rightPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of updateRight method, of class TrightService.
     */
    //@Test
    public void testUpdateRight() {
        System.out.println("updateRight");
        TRight right = null;
        IRightService instance = (IRightService)ctx.getBean("trightService");
        TRight expResult = null;
        TRight result = instance.updateRight(right);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

}
