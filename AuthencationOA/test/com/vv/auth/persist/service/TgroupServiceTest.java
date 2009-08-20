/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.entity.Vcustomer;
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
import static org.junit.Assert.*;

/**
 *
 * @author X-Spirit
 */
public class TgroupServiceTest {
    ApplicationContext ctx;
    public TgroupServiceTest() {
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
     * Test of findGroupById method, of class TGroupService.
     */
    //@Test
    public void testFindGroupById() {
        System.out.println("findGroupById");
        Integer id = null;
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        TGroup expResult = null;
        TGroup result = instance.findGroupById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findGroupByName method, of class TGroupService.
     */
    //@Test
    public void testFindGroupByName() {
        System.out.println("findGroupByName");
        String groupName = "";
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        List<TGroup> expResult = null;
        List<TGroup> result = instance.findGroupByName(groupName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findGroupByDesc method, of class TGroupService.
     */
    //@Test
    public void testFindGroupByDesc() {
        System.out.println("findGroupByDesc");
        String tgDesc = "";
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        List<TGroup> expResult = null;
        List<TGroup> result = instance.findGroupByDesc(tgDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveGroup method, of class TGroupService.
     */
    @Test
    public void testSaveGroup() throws Exception {
        System.out.println("saveGroup");
       // TGroup group = new TGroup(null, "SuperAdmin", new Date(),"超级管理�?);
        TGroup group = new TGroup(null, "Innocent", new Date(),"�?��权限用户");
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        if (instance.findGroupByName(group.getGroupName()).size()<=0){
            instance.saveGroup(group);
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of queryGroupList method, of class TGroupService.
     */
    @Test
    public void testQueryGroupList() {
        System.out.println("queryGroupList");
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        List<TGroup> result = instance.queryGroupList();
        for (TGroup group: result){
            System.out.println("#################"+group.getGroupName());
            Collection<TRight> rightlist = group.getTRightCollection();
            for(TRight right:rightlist){
                System.out.println("@@ Group: "+group.getGroupName()+" @@ RightType: "+right.getRightType()+" @@ RightPath: "+right.getRightPath());
            }
            for(Vcustomer customer:group.getVcustomerCollection()){
                System.out.println("@@ Group: "+group.getGroupName()+" @@ UserName: "+customer.getName());
            }
        }
    }
    /**
     * Test of updateGroup method, of class TGroupService.
     */
    //@Test
    public void testUpdateGroup() {
        System.out.println("updateGroup");
        TGroup group = null;
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        TGroup expResult = null;
        TGroup result = instance.updateGroup(group);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGroup method, of class TGroupService.
     */
    //@Test
    public void testDeleteGroup() {
        System.out.println("deleteGroup");
        Integer groupid = null;
        IGroupService instance=(IGroupService)ctx.getBean("tgroupService");
        instance.deleteGroup(groupid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
