package org.example.pizza;

import java.util.Scanner;

public class CreateUI extends CommonUI{

    public CreateUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute() {
        print("Welcome to Pizza Creation UI");
    }
}