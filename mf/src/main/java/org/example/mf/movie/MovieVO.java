package org.example.mf.movie;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class MovieVO {

    private Integer mno;
    private String uid;
    private String upw;
    private String name;
    private boolean delFlag;


}
