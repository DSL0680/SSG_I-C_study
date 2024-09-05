package org.zerock.w2.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardReadDTO {

    private Long bno;
    private String title;
    private String content;
    private String writer;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private List<String> fileNames;
}
