package org.zerock.b1.sample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.b1.sample.service.SampleService;

@Controller
@RequestMapping("/sample/")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("hello")
    public void hello(Model model) {
        model.addAttribute("msg", sampleService.hello());
    }
}
