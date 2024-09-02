package org.example.mf.movie;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MoviePurchaseVO {

    private int purchase_id;
    private int user_id;
    private int movie_id;


}
