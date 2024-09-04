package org.zerock.w2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatTime(LocalDateTime date) {

        String formattedDate = date.format(formatter);

        return formattedDate;
    }

}