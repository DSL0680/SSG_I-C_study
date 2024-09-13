package org.zerock.b1.sample.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SampleService {

    @Value("${sample.msg}")
    private String msg;

    public String hello() {
        return msg;
    }
}
