package com.golovanova.net;

import com.golovanova.dto.CommandMessage;

import java.net.InetAddress;

public class ClientRequest {
    private InetAddress inetAddress;
    private int port;
    private CommandMessage commandMessage;

    public ClientRequest(InetAddress inetAddress, int port, CommandMessage commandMessage) {
        this.inetAddress = inetAddress;
        this.port = port;
        this.commandMessage = commandMessage;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public int getPort() {
        return port;
    }

    public CommandMessage getCommandMessage() {
        return commandMessage;
    }
}
