package org.example.mf.movie;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieInfoVO {

    private Integer mid;
    private String title;
    private String path;

}
