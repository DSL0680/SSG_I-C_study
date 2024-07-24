package org.example;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SampleServer {

    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);

        System.out.println("---------------------");
        while(true) {


            try(Socket socket = serverSocket.accept();
                OutputStream out = socket.getOutputStream()) {

                new Thread(() -> {
                    try {
                        Thread.sleep(10000);
                        String msg = "<h1>Hello World</h1>";
                        out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

                        out.write(new String("Cache-Control: private\r\n").getBytes());
                        out.write(new String("Content-Length: " + msg.getBytes("UTF-8").length + "\r\n").getBytes());
                        out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

                        out.write(msg.getBytes(StandardCharsets.UTF_8));
                    }catch(Exception e) {
                        e.printStackTrace();
                    }

                }).start();

            }

        }//end while

    }
}