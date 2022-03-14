package com.golovanova;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class DatagramClient {
    private String hostName = "localhost";
    private int port = 5252;

    public void remoteCall(Object obj) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(hostName);

        byte[] objectBytes = objToByteArray(obj);
        int objectSize = objectBytes.length;
        ByteBuffer byteBuffer = ByteBuffer.allocate(4)
                .putInt(objectSize);
        byte[] sizeBytes = byteBuffer.array();

        DatagramPacket sizePacket = new DatagramPacket(sizeBytes, 4, address, port);
        socket.send(sizePacket);

        DatagramPacket packet = new DatagramPacket(objectBytes, objectSize, address, port);
        socket.send(packet);

        socket.close();
   }

    private byte[] objToByteArray(Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.flush();
            byte[] bytes = bos.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];

        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}
