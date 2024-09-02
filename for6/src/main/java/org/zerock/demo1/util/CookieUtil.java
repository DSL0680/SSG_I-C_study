package org.zerock.demo1.util;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CookieUtil {

    public static Map<Integer, String> parseStr(HttpServletRequest req) {

        Map<Integer,String> answerMap = Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("answer"))
                .findFirst()
                .map(cookie -> cookie.getValue())
                .map(value -> Arrays.stream(value.split("&"))
                        .map(str -> str.split(":"))
                        .collect(java.util.stream.Collectors.toMap(str -> Integer.parseInt(str[0]), str -> str[1])))
                .orElse(null);

        return answerMap;
    }

}
