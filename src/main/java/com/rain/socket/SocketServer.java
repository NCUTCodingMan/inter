package com.rain.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        byte[] content = new byte[1024];
        while (is.read(content) != -1) {
            System.out.println(new String(content));
        }
        is.close();
        serverSocket.close();
    }
}