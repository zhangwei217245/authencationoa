/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.certification;

/**
 *
 * @author hp
 */
public class CerPath {
    private String terminalCommand;
    private String terminalRtStr;
    private String serverCerPath;
    private String clientCerPath;



    public String getTerminalRtStr() {
        return terminalRtStr;
    }

    public void setTerminalRtStr(String terminalRtStr) {
        this.terminalRtStr = terminalRtStr;
    }

    public String getTerminalCommand() {
        return terminalCommand;
    }

    public void setTerminalCommand(String terminalCommand) {
        this.terminalCommand = terminalCommand;
    }

    

    public String getClientCerPath() {
        return clientCerPath;
    }

    public void setClientCerPath(String clientCerPath) {
        this.clientCerPath = clientCerPath;
    }

    public String getServerCerPath() {
        return serverCerPath;
    }

    public void setServerCerPath(String serverCerPath) {
        this.serverCerPath = serverCerPath;
    }
}
