package org.zerock.b1.board.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Value("${board.key}")
    private String key;

    public String findKey() {
        return key;
    }

}
