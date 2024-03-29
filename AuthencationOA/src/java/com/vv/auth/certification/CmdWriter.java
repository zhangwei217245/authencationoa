/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author X-Spirit
 */
public class CmdWriter implements Runnable {

    public CmdWriter() {
    }

    public CmdWriter(BufferedWriter outputStream, String line, int seq, CmdStatus cs) {
        this.outputStream = outputStream;
        this.line = line;
        this.seq = seq;
        this.cs = cs;
    }
    BufferedWriter outputStream;
    String line;
    int seq;
    CmdStatus cs;

    public CmdStatus getCs() {
        return cs;
    }

    public void setCs(CmdStatus cs) {
        this.cs = cs;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public BufferedWriter getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(BufferedWriter outputStream) {
        this.outputStream = outputStream;
    }

    public void run() {
        System.out.println("writer " + seq + " started");
        try {
            while (cs.getCode() == seq) {
                System.out.println("before write");
                outputStream.write(line + "\r\n");
                System.out.println("before flush");
                outputStream.flush();
                System.out.println("command " + seq + " executed");
                break;
            }
            cs.setCode(cs.getCode() + 1);
            System.out.println("cs Code: " + cs.getCode());
            Thread.yield();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
