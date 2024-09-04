package org.zerock.w2.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.w2.dto.BoardRegisterDTO;
import org.zerock.w2.service.BoardService;
import org.zerock.w2.vo.PageRequest;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("register")
    public void register() {

    }

    @PostMapping("register")
    public String register(BoardRegisterDTO dto, RedirectAttributes rttr) {
        log.info(dto);

        boardService.register(dto);

        return "redirect:/board/list";
    }

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
