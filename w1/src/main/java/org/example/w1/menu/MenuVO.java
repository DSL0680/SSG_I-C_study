package org.example.w1.menu;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class MenuVO {

    private Integer no;
    private String name;
    private int price;
    private String imgPath;

}
