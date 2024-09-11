package org.zerock.b2.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardRegisterDTO {

    private Long bno;
    private String title;
    private String content;
    private String writer;

    private MultipartFile[] images;


    private java.util.List<String> fileName;

    private String tag;


}
