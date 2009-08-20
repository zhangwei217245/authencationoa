/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Rcustomer;
import java.util.Date;
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
 * @author hp
 */
public class RcustomerServiceTest {

    ApplicationContext ctx;


    public RcustomerServiceTest() {
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
     * Test of saveRegCustomer method, of class RcustomerService.
     */
    //@Test
    public void testSaveRegCustomer() {
        System.out.println("saveRegCustomer");
        Rcustomer rc = new Rcustomer(null, "liuyuan", "kule", "kule", "beijing", "beijing", "China", "20", new Date(), new Date(2009, 5, 1), "liuyuan");
        IRcustomerService instance = (IRcustomerService)ctx.getBean("rcustomerService");
        instance.saveRegCustomer(rc);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteRegCustomer method, of class RcustomerService.
     */
    //@Test
    public void testDeleteRegCustomer() {
        System.out.println("deleteRegCustomer");
        Integer id = null;
        RcustomerService instance = new RcustomerService();
        instance.deleteRegCustomer(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRcustomers method, of class RcustomerService.
     */
    @Test
    public void testFindRcustomers() {
        System.out.println("findRcustomers");
        IRcustomerService instance = (IRcustomerService)ctx.getBean("rcustomerService");
        List<Rcustomer> result = instance.findRcustomers();
        for(Rcustomer user:result){
            System.out.println("name: "+user.getName()+" id: "+user.getUserid());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findRcustomerById method, of class RcustomerService.
     */
    //@Test
    public void testFindRcustomerById() {
        System.out.println("findRcustomerById");
        Integer id = null;
        RcustomerService instance = new RcustomerService();
        Rcustomer expResult = null;
        Rcustomer result = instance.findRcustomerById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}