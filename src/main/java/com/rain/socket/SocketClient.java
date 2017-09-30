package com.rain.socket;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws Exception {
        Socket socketClient = new Socket("127.0.0.1", 8080);
        OutputStream os = socketClient.getOutputStream();
        os.write("Hello world".getBytes());
        os.close();
        socketClient.close();
    }
}