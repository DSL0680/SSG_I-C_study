package org.zerock.w2.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardRegisterDTO {

    private String title;
    private String content;
    private String writer;

    private MultipartFile[] files;

}
