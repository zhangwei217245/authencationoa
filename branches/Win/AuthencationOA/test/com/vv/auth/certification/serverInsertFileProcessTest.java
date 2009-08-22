/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.certification;

import com.vv.auth.persist.entity.Certificatereg;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class serverInsertFileProcessTest {

    public serverInsertFileProcessTest() {
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
     * Test of delFolder method, of class serverInsertFileProcess.
     */
    //@Test
    public void testDelFolder() {
        System.out.println("delFolder");
        String folderPath = "";
        serverInsertFileProcess instance = new serverInsertFileProcess();
        instance.delFolder(folderPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delAllFile method, of class serverInsertFileProcess.
     */
    //@Test
    public void testDelAllFile() {
        System.out.println("delAllFile");
        String path = "";
        serverInsertFileProcess instance = new serverInsertFileProcess();
        boolean expResult = false;
        boolean result = instance.delAllFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serverInsertCer method, of class serverInsertFileProcess.
     */
    //@Test
    public void testServerInsertCer_Certificatereg() throws Exception {
        System.out.println("serverInsertCer");
        Certificatereg cereg = new Certificatereg();
        cereg.setAlbyte(512L);
        cereg.setName("niuniu");
        serverInsertFileProcess instance = new serverInsertFileProcess();
        instance.serverInsertCer(cereg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serverInsertCer method, of class serverInsertFileProcess.
     */
    //@Test
    public void testServerInsertCer_11args() throws Exception {
        System.out.println("serverInsertCer");
        String name = "";
        String albyte = "";
        String location = "";
        String departname = "";
        String oname = "";
        String cname = "";
        String pname = "";
        String ctfname = "";
        String cpass = "";
        String ppass = "";
        String dday = "";
        serverInsertFileProcess instance = new serverInsertFileProcess();
        instance.serverInsertCer(name, albyte, location, departname, oname, cname, pname, ctfname, cpass, ppass, dday);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shutDown method, of class serverInsertFileProcess.
     */
    //@Test
    public void testShutDown() throws Exception {
        System.out.println("shutDown");
        serverInsertFileProcess instance = new serverInsertFileProcess();
        instance.shutDown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}