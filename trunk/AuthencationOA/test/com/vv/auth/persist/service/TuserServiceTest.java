/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author X-Spirit
 */
public class TuserServiceTest{
    ApplicationContext ctx;
    public TuserServiceTest() {
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
     * Test of saveUser method, of class TuserService.
     */
    @Test
    public void testSaveUser() throws PreexistingEntityException {
        
        System.out.println("saveUser");
        Date now = new Date();
        long overmill=1000*60*60*24*1000;
        Date over = new Date(overmill);
        //Vcustomer user = new Vcustomer(null, "x-spirit", "datuu", "x-spirit", "China", "Hebei", "Zhang Jiakou", "1000", now, over, new MD5Text().MD5Encode("123"));
        Vcustomer user = new Vcustomer(null, "NewSkin", "HBUST", "NewSkin", "China", "Hebei", "Shi Jiazhuang", "1000", now, over, "12345678","N");
        //user.setName("x-spirit");
        //user.setPassword(new MD5Text().MD5Encode("123"));
        
        
        //Object obj=ctx.getBean("tuserJpaControl");
        Object obj=ctx.getBean("tuserService");
        
        //TuserJpaController instance=(TuserJpaController)obj;
        //instance.create(user);
        IUserService instance=(IUserService)obj;
        
        instance.saveUser(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of queryUserList method, of class TuserService.
     */
    @Test
    public void testQueryUserList() {
        
        //System.out.println("queryUserList");
        IUserService instance=(IUserService)ctx.getBean("tuserService");
        //List<Vcustomer> expResult = null;
        List<Vcustomer> result = instance.queryUserList();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        for(Vcustomer user:result){
            Collection<TGroup> glist=user.getTGroupCollection();
            System.out.println(user.getName());
            for(TGroup group:glist){
                System.out.println("---"+group.getTgDesc());
            }
            
        }
    }

   

}