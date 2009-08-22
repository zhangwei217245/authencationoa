/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import com.vv.auth.struts.util.FileUtility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author X-Spirit
 */
public class TestCmd {

    public TestCmd() {
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

    //@Test
    public void createFolder(){
        try {
            FileUtility.createFile("f:/a/b/c");
        } catch (IOException ex) {
            Logger.getLogger(TestCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        String cmd = "keytool -list -keystore d:\\tomcat.keystore -storepass aaaabbbb";
        try {
//            Process process = Runtime.getRuntime().exec(cmd);
            Process process = Runtime.getRuntime().exec("cmd");
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            CmdStatus cs = CmdStatus.getInstance();
            new Thread(new CmdReader(inputStream)).start();
            Thread tw0 = new Thread(new CmdWriter(outputStream, cmd, 0, cs));
            Thread tw1 = new Thread(new CmdWriter(outputStream, cmd, 1, cs));
            Thread tw2 = new Thread(new CmdWriter(outputStream, cmd, 2, cs));
            Thread tw3 = new Thread(new CmdWriter(outputStream, "exit", 3, cs));
            tw0.start();
            Thread.sleep(5000);
            tw1.start();
            Thread.sleep(5000);
            tw2.start();
            Thread.sleep(5000);
            tw3.start();
            int i = process.waitFor();
            System.out.println("i=" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}