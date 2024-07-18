package org.example.fortune;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FotuneWebServer {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready............");

        while (true) {
            try (Socket socket = serverSocket.accept();
                 OutputStream outputStream = socket.getOutputStream();){

                String msg = FortuneTeller.INSTANCE.getOne();



            }
        }

    }
}
