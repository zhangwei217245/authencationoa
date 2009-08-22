/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Certificatereg;
import java.util.List;
import java.util.Map;
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
public class CertificateregServiceTest {

    ApplicationContext ctx;
    public CertificateregServiceTest() {
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
     * Test of findCertificateregByNameAndLocation method, of class CertificateregService.
     */
    //@Test
    public void testFindCertificateregByNameAndLocation() {
        System.out.println("findCertificateregByNameAndLocation");
        String name = "";
        String location = "";
        CertificateregService instance = new CertificateregService();
        List<Certificatereg> expResult = null;
        List<Certificatereg> result = instance.findCertificateregByNameAndLocation(name, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCertificate method, of class CertificateregService.
     */
    //@Test
    public void testDeleteCertificate() {
        System.out.println("deleteCertificate");
        Integer id = null;
        CertificateregService instance = new CertificateregService();
        instance.deleteCertificate(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCertificateRegExpire method, of class CertificateregService.
     */
    //@Test
    public void testFindCertificateRegExpire() {
        System.out.println("findCertificateRegExpire");
        CertificateregService instance = new CertificateregService();
        List<Certificatereg> expResult = null;
        List<Certificatereg> result = instance.findCertificateRegExpire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCertificateRegNotExpire method, of class CertificateregService.
     */
    //@Test
    public void testFindCertificateRegNotExpire() {
        System.out.println("findCertificateRegNotExpire");
        CertificateregService instance = new CertificateregService();
        List<Certificatereg> expResult = null;
        List<Certificatereg> result = instance.findCertificateRegNotExpire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCertificateregByName method, of class CertificateregService.
     */
    //@Test
    public void testFindCertificateregByName() {
        System.out.println("findCertificateregByName");
        String name = "";
        CertificateregService instance = new CertificateregService();
        List<Certificatereg> expResult = null;
        List<Certificatereg> result = instance.findCertificateregByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCertificateregs method, of class CertificateregService.
     */
    @Test
    public void testSearchCertificateregs() {
        System.out.println("searchCertificateregs");
        String jpql = "select distinct object(o) from Certificatereg as o where 1=1";
        Map params = null;
        ICertificateregService instance = (ICertificateregService)ctx.getBean("certificateregService");
        List<Certificatereg> result = instance.searchCertificateregs(jpql, params);
        for(Certificatereg cer:result){
            System.out.println(cer.getKsdid());
        }
        
    }

    /**
     * Test of findByCertificateregId method, of class CertificateregService.
     */
    //@Test
    public void testFindByCertificateregId() {
        System.out.println("findByCertificateregId");
        Integer id = null;
        CertificateregService instance = new CertificateregService();
        Certificatereg expResult = null;
        Certificatereg result = instance.findByCertificateregId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCertificateregs method, of class CertificateregService.
     */
    //@Test
    public void testFindCertificateregs() {
        System.out.println("findCertificateregs");
        CertificateregService instance = new CertificateregService();
        List<Certificatereg> expResult = null;
        List<Certificatereg> result = instance.findCertificateregs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCertificatereg method, of class CertificateregService.
     */
    //@Test
    public void testSaveCertificatereg() throws Exception {
        System.out.println("saveCertificatereg");
        Certificatereg cr = null;
        CertificateregService instance = new CertificateregService();
        instance.saveCertificatereg(cr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}