package org.example.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class FileServer {
    public static void main(String[] args) throws Exception {
// 서버 소켓
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready............");

// 전송할 파일이 있는 디렉토리 경로
        String directoryPath = "C:\\zzz";
        File directory = new File(directoryPath);

        while (true) {
// 클라이언트 접속 대기
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

// 디렉토리에서 파일 목록 가져오기
                File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
                if (files == null || files.length == 0) {
                    System.out.println("No image files found in the directory.");
                    return;
                }

// 랜덤 파일 선택
                Random random = new Random();
                File randomFile = files[random.nextInt(files.length)];

                System.out.println("Sending file: " + randomFile.getName());

// 파일 전송
                try (FileInputStream fis = new FileInputStream(randomFile);
                     OutputStream os = socket.getOutputStream()) {
                    byte[] buffer = new byte[1024 * 8];

                    while (true) {
                        int count = fis.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        os.write(buffer, 0, count);
                    }
                    System.out.println("File sent successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}