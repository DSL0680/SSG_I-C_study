package org.zerock.w2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.w2.mapper.TimeMapper;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeMapper timeMapper;

    public String getTime() {
        return timeMapper.getTime();
    }

}