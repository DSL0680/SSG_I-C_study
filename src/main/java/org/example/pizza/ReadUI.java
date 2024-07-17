package org.example.pizza;

import java.util.Scanner;

public class ReadUI extends CommonUI{


    public ReadUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute() {
        print("Pizza Read UI");
    }
}