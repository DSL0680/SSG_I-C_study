package org.zerock.w2.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.w2.vo.ReplyVO;

@RestController
@RequestMapping("/reply")
@Log4j2
public class ReplyController {

    @PostMapping(value = "")
    public ResponseEntity<ReplyVO> register(
            @RequestBody ReplyVO replyVO) {

        log.info("reply vo: " + replyVO);
        // 200 OK
        return ResponseEntity.ok(replyVO);
    }

}
