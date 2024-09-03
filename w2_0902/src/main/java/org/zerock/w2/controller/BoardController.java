package org.zerock.w2.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.w2.service.BoardService;
import org.zerock.w2.vo.PageRequest;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list")
    public void list(PageRequest pageRequest, Model model) {

        log.info("list");
        model.addAttribute("result", boardService.getList(pageRequest));
    }

    @GetMapping("read/{bno}")
    public String read(@PathVariable("bno") Long bno, Model model) {

        model.addAttribute("board", boardService.getOne(bno));

        return "board/read";
    }

}
