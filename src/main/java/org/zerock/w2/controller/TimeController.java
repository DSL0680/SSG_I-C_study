package org.zerock.w2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.w2.service.TimeService;

@Controller
@Log4j2
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/time")
    public void time() {
        log.info(timeService.getClass().getName());
        log.info(timeService.getTime());
        log.info("time");
    }

}