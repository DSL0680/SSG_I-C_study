package org.example.pizza;

import java.util.Scanner;

public class TotalUI extends CommonUI{

    private CommonUI[] uiArr;

    public TotalUI(Scanner scanner, CommonUI[] uiArr) {
        super(scanner);
        this.uiArr = uiArr;
    }

    @Override
    public void execute() {

        int oper = inputInt("0:create \t 1:read \t 2:update \t 3:delete \t -1:EXIT");

        if(oper == -1){
            return;
        }

        uiArr[oper].execute();

        execute();//recursive
    }
}