/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author X-Spirit
 */
public class CmdReader implements Runnable {

    BufferedReader inputStream;
    String line;

    public CmdReader() {
    }

    public CmdReader(BufferedReader inputStream) {
        this.inputStream = inputStream;
    }

    public BufferedReader getInputStream() {
        return inputStream;
    }

    public void setInputStream(BufferedReader inputStream) {
        this.inputStream = inputStream;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void run() {
        System.out.println("listener started");

        try {
            while ((line = inputStream.readLine())!=null) {
                //if(line!=null)
                    System.out.println(line);
                    System.out.flush();
                //else
                //    return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
