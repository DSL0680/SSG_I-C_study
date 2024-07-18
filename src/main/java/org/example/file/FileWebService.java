package org.example.file;

import java.io.File;

public class FileWebService {

    public static File[] FileList(String path) {
        File file = new File(path);

        File[] files = file.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpeg")
                || name.toLowerCase().endsWith(".jpg")
                || name.toLowerCase().endsWith(".png"));

        return files;
    }
}
