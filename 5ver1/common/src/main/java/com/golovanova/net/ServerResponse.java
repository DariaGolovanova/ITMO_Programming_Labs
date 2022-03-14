package com.golovanova.net;

import java.net.InetAddress;

public class ServerResponse {
    private InetAddress inetAddress;
    private int port;
    private Object object;

    public ServerResponse(InetAddress inetAddress, int port, Object object) {
        this.inetAddress = inetAddress;
        this.port = port;
        this.object = object;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public int getPort() {
        return port;
    }

    public Object getObject() {
        return object;
    }
}
