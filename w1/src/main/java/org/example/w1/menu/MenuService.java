package org.example.w1.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public enum MenuService {

    INSTANCE;

    private List<MenuVO> menus;

    MenuService() {
        //dummy
        menus = new ArrayList<MenuVO>();
        IntStream.rangeClosed(0,7).forEach(i -> {
            menus.add(new MenuVO(i, "Menu"+i,1000 * i, "img/img"+i));
        });
    }

    public List<MenuVO> getMenus() {
        return menus;
    }
    //특정한 번호의 상품을 반환해 주는 기능
    public MenuVO getMenuById(Integer id) {

        for (MenuVO menu : menus) {
            if (menu.getNo() == id) {
                return menu;
            }
        }

        return null;
    }
}
