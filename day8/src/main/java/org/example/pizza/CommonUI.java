package org.example.pizza;

import java.util.Scanner;

public abstract class CommonUI {

    private Scanner scanner;

    public CommonUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void execute();


    public void print(String msg){
        System.out.println(msg);
    }

    protected String inputStr(String msg){
        this.print(msg);
        return scanner.nextLine();
    }

    protected int inputInt(String msg){
        return Integer.parseInt(inputStr(msg));
    }


}

