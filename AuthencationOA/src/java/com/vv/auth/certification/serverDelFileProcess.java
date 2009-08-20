/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author hp
 */
public class serverDelFileProcess {

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

    public void delServerCer(String name, String uloc, String upassa) throws Exception {
        String s = "keytool -delete -alias " + name + " -keystore " + uloc + " -storepass " + upassa + "";//从密钥库删除记录
        String separator = File.separator;
        String directory = "c:" + separator + "hh";
        String fileName = "myFiled.bat";
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
        String c = "c:\\hh\\myFiled.bat";
        OutputStream os = new FileOutputStream(c);
        os.write(bytes);
        os.close();
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("cmd.exe /c " + "start /min c:\\hh\\myFiled.bat");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        delFolder("c:/hh");
    }

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
        oos.write(bbytes);//将字节一个个写入文件
        oos.close();
        Runtime r = Runtime.getRuntime();
        Process pl = r.exec("cmd.exe /c " + "start /min c:\\hh\\myFilee.bat");
    }
}
