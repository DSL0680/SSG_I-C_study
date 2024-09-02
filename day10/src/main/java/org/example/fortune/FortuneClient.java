package org.example.fortune;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class FortuneClient {
    public static void main(String[] args) {

        try {

            Socket socket = new Socket("127.0.0.1", 5555);
            System.out.println("서버에 연결되었습니다: " + socket.getRemoteSocketAddress());


            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);


            String fortune = dataInputStream.readUTF();
            System.out.println("운세 메시지: " + fortune);


            dataInputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
