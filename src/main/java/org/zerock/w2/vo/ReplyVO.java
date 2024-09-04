package org.zerock.w2.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.w2.util.TimeUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyVO {

    private Long rno;
    private Long bno;
    private String reply;
    private String replyer;

    @JsonIgnore
    private LocalDateTime regDate;
    @JsonIgnore
    private LocalDateTime modDate;

    public String getReg() {
        return TimeUtil.formatTime(regDate);
    }

    public String getMod() {
        return TimeUtil.formatTime(modDate);
    }

}
