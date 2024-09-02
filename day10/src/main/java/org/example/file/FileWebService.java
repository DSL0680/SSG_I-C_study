package org.example.file;

import java.io.File;

public enum FileWebService {
    INSTANCE;
    File file;
    File[] files;
    FileWebService() {
        file = new File("C:\\zzz\\");
    }
    //파일추가
    public void addFile(File file) {
        files = file.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".jpeg") || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
// Convert array to List and return
        if (files == null || files.length == 0) {
            System.out.println("No files found in the folder: " + "C:\\zzz\\");
        }
    }
}