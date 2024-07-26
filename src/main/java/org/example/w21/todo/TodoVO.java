package org.example.w21.todo;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.sql.Timestamp;

@Log4j2
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TodoVO {

    private int tno;
    private String title;
    private String writer;
    private Timestamp reqdate;
    private Timestamp moddate;
    private boolean delflag;

}
