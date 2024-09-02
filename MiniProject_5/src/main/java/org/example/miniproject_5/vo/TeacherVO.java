package org.example.miniproject_5.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherVO {

    private Integer tno;
    private String tid;
    private String tpw;
}
