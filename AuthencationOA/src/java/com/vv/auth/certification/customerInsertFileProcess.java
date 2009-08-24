/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import com.vv.auth.persist.entity.Certificatereg;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.struts.util.FileUtility;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.annotation.Resource;

/**
 *
 * @author hp
 */
public class customerInsertFileProcess {

    @Resource
    private CerPath cerPathBean;
    private Connection conn;
    private ResultSet rss;

    public void execute(Vcustomer user, Certificatereg cereg) throws Exception {
        String separator = File.separator;
        String directory = cerPathBean.getClientCerPath() + separator + user.getName();
        new File(directory).mkdirs();
        String cmd_0 = "keytool -genkey -v -alias " + user.getName() + " -keyalg RSA -keysize 1024 -storetype PKCS12 -keystore " + directory + separator + user.getName() + ".p12 -dname \"CN=" + user.getName() + ",OU=" + user.getDepartname() + "，O=" + user.getOname() + ",L=" + user.getCname() + ",ST=" + user.getPname() + ",C=" + user.getCtname() + "\" -storepass " + user.getPassword() + " -keypass " + user.getPassword() + " -validity " + user.getDday() + "";
        String cmd_1 = "keytool -export -alias " + user.getName() + " -keystore " + directory + separator + user.getName() + ".p12 -storetype PKCS12 -storepass " + user.getPassword() + " -rfc -file " + directory + separator + user.getName() + ".cer";
        String cmd_2 = "keytool -import -v -alias " + user.getName() + " -file " + directory + separator + user.getName() + ".cer -keystore " + cereg.getLocation() + " -storepass " + cereg.getCpass() + "";
        String cmd_3 = "y";
        String cmd_4 = "exit";
        try {
            Process process = Runtime.getRuntime().exec(cerPathBean.getTerminalCommand());
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errInputStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            CmdStatus cs = CmdStatus.getInstance();
            Thread tr = new Thread(new CmdReader(inputStream));
            Thread errtr = new Thread(new CmdReader(errInputStream));
            errtr.setDaemon(true);
            tr.setDaemon(true);
            errtr.start();
            tr.start();
            Thread tw0 = new Thread(new CmdWriter(outputStream, cmd_0,cerPathBean.getTerminalRtStr(), 0, cs));
            Thread tw1 = new Thread(new CmdWriter(outputStream, cmd_1,cerPathBean.getTerminalRtStr(), 1, cs));
            Thread tw2 = new Thread(new CmdWriter(outputStream, cmd_2,cerPathBean.getTerminalRtStr(), 2, cs));
            Thread tw3 = new Thread(new CmdWriter(outputStream, cmd_3,cerPathBean.getTerminalRtStr(), 3, cs));
            Thread tw4 = new Thread(new CmdWriter(outputStream, cmd_4,cerPathBean.getTerminalRtStr(), 4, cs));
            tw0.start();
            Thread.sleep(5000);
            tw1.start();
            Thread.sleep(5000);
            tw2.start();
            Thread.sleep(5000);
            tw3.start();
            Thread.sleep(5000);
            tw4.start();
            //process.destroy();
            int i = process.waitFor();

            System.out.println("i=" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Deprecated
    public void genCerImportCer(Vcustomer user) throws Exception {
        this.genCerImportCer(user.getName(), user.getDepartname(), user.getOname(), user.getCname(), user.getPname(), user.getCtname(), user.getPassword(), user.getDday());
    }
    @Deprecated
    public void genCerImportCer(String name, String departname, String oname, String cname, String pname, String ctname, String password, String dday) throws Exception {

        String separator = File.separator;
//			        String directory = "c:" + separator + "customercer"+separator+name;
        String directory = cerPathBean.getClientCerPath() + separator + name;
        String s = "keytool -genkey -v -alias " + name + " -keyalg RSA -keysize 1024 -storetype PKCS12 -keystore " + directory + separator + name + ".p12 -dname \"CN=" + name + ",OU=" + departname + "，O=" + oname + ",L=" + cname + ",ST=" + pname + ",C=" + ctname + "\" -storepass " + password + " -keypass " + password + " -validity " + dday + "";
        s = s + "\r\nexit\r\n";
        String fileName = "myFile.bat";

        File f = new File(directory, fileName);
        if (f.exists()) {
            // 文件已经存在，输出文件的相关信息
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
            System.out.println(f.length());
        } else {
            //  先创建文件所在的目录
            f.getParentFile().mkdirs();

            // 创建新文件
            f.createNewFile();


        }
        byte[] bytes = s.getBytes();//一定由string得到bytes才能写入到文件里
        String c = directory + separator + fileName;

        OutputStream os = new FileOutputStream(c);
        os.write(bytes);
        os.close();

        Runtime r = Runtime.getRuntime();

        Process p = r.exec("cmd.exe /c " + "start /min " + c + "");
        p.waitFor();

//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    @Deprecated
    public void exportCer(Vcustomer user) throws Exception {
        this.exportCer(user.getName(), user.getPassword());
    }
    @Deprecated
    public void exportCer(String name, String password) throws Exception {
        String separator = File.separator;
//			        String directory = "c:" + separator + "customercer"+separator+name;
        String directory = cerPathBean.getClientCerPath() + separator + name;
        String export = "keytool -export -alias " + name + " -keystore " + directory + separator + name + ".p12 -storetype PKCS12 -storepass " + password + " -rfc -file " + directory + separator + name + ".cer";
        export = export + "\r\nexit\r\n";
        String efile = "efile.bat";
        File ef = new File(directory, efile);
        try {
            // 创建新文件
            ef.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] ebytes = export.getBytes();//一定由string得到bytes才能写入到文件里
        String ec = directory + separator + efile;
        OutputStream eos = new FileOutputStream(ec);
        eos.write(ebytes);
        eos.close();

        Runtime er = Runtime.getRuntime();
        Process ep = er.exec("cmd.exe /c " + "start /min " + ec + "");
        ep.waitFor();
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    @Deprecated
    public void importServer(String name, String serverlocation, String servercpass) throws Exception {

        String separator = File.separator;
//			        String directory = "c:" + separator + "customercer"+separator+name;
        String directory = cerPathBean.getClientCerPath() + separator + name;
        String imkeytool = "keytool -import -v -alias " + name + " -file " + directory + separator + name + ".cer -keystore " + serverlocation + " -storepass " + servercpass + "";
        imkeytool = imkeytool + "\r\nexit\r\n";
        String ifile = "ifile.bat";
        File ifcer = new File(cerPathBean.getClientCerPath(), ifile);
        ifcer.createNewFile();
        byte[] ibytes = imkeytool.getBytes();//一定由string得到bytes才能写入到文件里
        String ic = directory + separator + ifile;
        OutputStream ios = new FileOutputStream(ic);
        ios.write(ibytes);
        ios.close();

        Runtime ir = Runtime.getRuntime();
        Process iip = ir.exec("cmd.exe /c " + "start /max " + ic + "");
        iip.waitFor();

        //Process iip = ir.exec("cmd.exe /c " + ic + "");

//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_Y);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_Y);
    }
}
