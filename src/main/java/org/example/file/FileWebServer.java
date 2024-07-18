package org.example.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class FileWebServer {
    public static void main(String[] args) throws Exception {
// 서버 소켓
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready");

        while (true) {
// 클라이언트 연결 대기
            try (
                    Socket socket = serverSocket.accept();
                    OutputStream out = socket.getOutputStream();
            ) {

// C:\\zzz\\ 폴더 내의 파일 목록 가져오기
                FileWebService file = FileWebService.INSTANCE;
                file.addFile(file.file);
                File[] files = file.files;

// 임의의 파일 선택
                Random random = new Random();
                File fileToSend = files[random.nextInt(files.length)];
                System.out.println("Sending file: " + fileToSend.getName());

// 파일 전송
                try (FileInputStream fis = new FileInputStream(fileToSend)) {

                    out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

                    out.write(new String("Cache-Control: private\r\n").getBytes());

                    out.write(new String("Content-Type: image/jpg\r\n\r\n").getBytes());
                    byte[] buffer = new byte[1024 * 8];
                    int count;
                    while ((count = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, count);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//end while
    }
}