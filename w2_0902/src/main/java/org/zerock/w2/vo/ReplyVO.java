package org.zerock.w2.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyVO {

    private Long rno;
    private Long bno;
    private String reply;
    private String replyer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
