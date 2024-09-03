package org.zerock.w2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.w2.service.TimeService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Log4j2
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/time2")
    @ResponseBody
    public java.util.Map<String, String> getTime2() {

        Map<String, String> map = new HashMap<>();
        map.put("time", timeService.getTime());
        return map;
    }


    @GetMapping("/time")
    public void time() {
        log.info(timeService.getClass().getName());
        log.info(timeService.getTime());
        log.info("time");

        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        log.info(str);

        timeService.insertAll(str);

    }

}