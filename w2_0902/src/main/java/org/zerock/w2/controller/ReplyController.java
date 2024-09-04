package org.zerock.w2.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.w2.service.ReplyService;
import org.zerock.w2.vo.PageRequest;
import org.zerock.w2.vo.PageResponse;
import org.zerock.w2.vo.ReplyVO;


@RestController
@RequestMapping("/reply")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/list/{bno}")
    public ResponseEntity<PageResponse<ReplyVO>> list(
            @PathVariable("bno") Long bno, PageRequest pageRequest) {

        return ResponseEntity.ok(replyService.getList(bno, pageRequest));

    }

    @PostMapping(value = "")
    public ResponseEntity<ReplyVO> register(
            @RequestBody ReplyVO replyVO) {

        log.info("reply vo: " + replyVO);
        // 200 OK
        return ResponseEntity.ok(replyVO);
    }

}
