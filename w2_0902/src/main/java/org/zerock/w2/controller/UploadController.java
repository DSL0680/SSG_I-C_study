package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.util.ThumbnailatorUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.w2.util.UploadUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
@Log4j2
public class UploadController {

    @PostMapping("")
    public ResponseEntity<List<String>> upload(MultipartFile[] files) {

        log.info("------------------------");
        log.info(Arrays.toString(files));

        List<String> uploadNames = UploadUtil.upload(files);

        return ResponseEntity.ok(uploadNames);
    }
}