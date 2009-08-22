/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.annotation.Resource;

/**
 *
 * @author hp
 */
public class customerDelFileProcess {
    @Resource
    private CerPath cerPathBean;
    public void execute(String name, String location, String cpass, String delfolder) {
        String cmd_0 = "keytool -delete -alias " + name + " -keystore " + location + " -storepass " + cpass + "";
        String cmd_1 = "exit";
        try {
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

            delFolder(delfolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delFolder(String folderPath) //删除函数1
    {
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

    public boolean delAllFile(String path) //删除函数2
    {
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
    public void delFromServer(String name, String location, String cpass) throws Exception //删除文件 并从库中抽取
    {
        String s = "keytool -delete -alias " + name + " -keystore " + location + " -storepass " + cpass + "";
        s = s + "\r\nexit\r\n";
        String separator = File.separator;
        String directory = "c:" + separator + "customercer" + separator + name;
        String fileName = "dmyFiled.bat";

        File f = new File(directory, fileName);

        if (f.exists()) {

            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
            System.out.println(f.length());
        } else {

            f.getParentFile().mkdirs();
            try {

                f.createNewFile();

            } catch (IOException e) {
                System.out.println("创建新文件时出现了错误。。。");
                e.printStackTrace();
            }
        }

        byte[] bytes = s.getBytes();//一定由string得到bytes才能写入到文件里

        String c = directory + separator + fileName;
        //String c="c:\\hh\\myFiled.bat";

        //String cc="c:\\hh\\myFilee.bat";
        OutputStream os = new FileOutputStream(c);

        os.write(bytes);

        os.close();


        Runtime r = Runtime.getRuntime();
        Process p = r.exec("cmd.exe /c " + "start /min " + c + "");



        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        delFolder(directory);
    }
}
