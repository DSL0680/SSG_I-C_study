package org.example.file;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws Exception{

//연결
        Socket socket = new Socket("127.0.0.1", 5555);

//빨대
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("copy.jpg");

//파일 저장
        while(true){
            int data = is.read();
            if(data == -1){break;}
            fos.write(data);
        }
    }
}