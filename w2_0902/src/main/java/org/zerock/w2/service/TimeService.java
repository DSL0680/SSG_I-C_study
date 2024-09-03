package org.zerock.w2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.w2.mapper.TimeMapper;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeService {

    private final TimeMapper timeMapper;

    public String getTime() {
        return timeMapper.getTime();
    }

    public void insertAll(String str) {

        timeMapper.insert1(str);
        timeMapper.insert2(str);

    }

}