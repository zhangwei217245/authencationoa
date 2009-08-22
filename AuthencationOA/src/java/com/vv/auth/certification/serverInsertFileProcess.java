/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import com.vv.auth.persist.entity.Certificatereg;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.annotation.Resource;

/**
 *
 * @author hp
 */
public class serverInsertFileProcess {

    @Resource
    private CerPath cerPathBean;

    public void execute(Certificatereg cereg) throws Exception {
        try {
            File f = new File(cereg.getLocation());
            f.getParentFile().mkdirs();
            //f.createNewFile();
            String cmd_0 = "keytool -genkey -v -alias " + cereg.getName() + " -keyalg RSA -keysize " + cereg.getAlbyte() + " -keystore " + cereg.getLocation() + " -dname \"CN=" + cereg.getName() + ",OU=" + cereg.getDepartname() + "，O=" + cereg.getOname() + ",L=" + cereg.getCname() + ",ST=" + cereg.getPname() + ",C=" + cereg.getCtfname() + "\" -storepass " + cereg.getCpass() + " -keypass " + cereg.getPpass() + " -validity " + cereg.getDday().intValue() + "";
            String cmd_1 = "exit";

            Process process = Runtime.getRuntime().exec(cerPathBean.getTerminalCommand());
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            CmdStatus cs = CmdStatus.getInstance();
            Thread tr = new Thread(new CmdReader(inputStream));
            tr.setDaemon(true);
            tr.start();
            Thread tw0 = new Thread(new CmdWriter(outputStream, cmd_0, 0, cs));
            Thread tw1 = new Thread(new CmdWriter(outputStream, cmd_1, 1, cs));
            tw0.start();
            Thread.sleep(5000);
            tw1.start();
            int i = process.waitFor();
            System.out.println("i=" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Deprecated
    public void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Deprecated
    public boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }
    @Deprecated
    public void serverInsertCer(Certificatereg cereg) throws Exception {
        this.serverInsertCer(cereg.getName(), cereg.getAlbyte().toString(), cereg.getLocation(), cereg.getDepartname(),
                cereg.getOname(), cereg.getCname(), cereg.getPname(),
                cereg.getCtfname(), cereg.getCpass(), cereg.getPpass(), cereg.getDday().toString());
    }
    @Deprecated
    /**
     *
     * @param name
     * @param albyte
     * @param location
     * @param departname
     * @param oname
     * @param cname
     * @param pname
     * @param ctfname
     * @param cpass
     * @param ppass
     * @param dday
     * @throws java.lang.Exception
     */
    public void serverInsertCer(String name, String albyte, String location, String departname, String oname, String cname, String pname, String ctfname, String cpass, String ppass, String dday) throws Exception {
        String s = "keytool -genkey -v -alias " + name + " -keyalg RSA -keysize " + albyte + " -keystore " + location + " -dname \"CN=" + name + ",OU=" + departname + "，O=" + oname + ",L=" + cname + ",ST=" + pname + ",C=" + ctfname + "\" -storepass " + cpass + " -keypass " + ppass + " -validity " + dday + "";
        s = s + "\r\nexit\r\n";
        String separator = File.separator;
        String directory = "c:" + separator + "hh";
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
            try {
                // 创建新文件
                f.createNewFile();

            } catch (Exception e) {
                System.out.println("创建新文件时出现了错误。。。");
                e.printStackTrace();
            }
        }

        byte[] bytes = s.getBytes();//一定由string得到bytes才能写入到文件里		
        String c = "c:\\hh\\myFile.bat";
        OutputStream os = new FileOutputStream(c);
        os.write(bytes);
        //将字节一个个写入文件
        os.close();
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("cmd.exe /c " + "start /min c:\\hh\\myFile.bat");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        delFolder("c:/hh");
    }
    @Deprecated
    public void shutDown() throws Exception {
        String ss = "taskkill /IM cmd.exe";
        String separator = File.separator;
        String directory = "c:" + separator + "hh";
        String fileN = "myFilee.bat";
        File ff = new File(directory, fileN);
        ff.createNewFile();
        byte[] bbytes = ss.getBytes();
        String cc = "c:\\hh\\myFilee.bat";
        OutputStream oos = new FileOutputStream(cc);
        oos.write(bbytes);
        oos.close();
        Runtime r = Runtime.getRuntime();
        Process pl = r.exec("cmd.exe /c " + "start /min c:\\hh\\myFilee.bat");
    }
}
