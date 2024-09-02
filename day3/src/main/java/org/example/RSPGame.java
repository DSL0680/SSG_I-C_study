package org.example;

import java.util.Random;
import java.util.Scanner;

public class RSPGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userWins = 0;
        int comWins = 0;

        while (userWins < 3 && comWins < 3) {
            System.out.println("0, 1, 2 중에 하나를 입력: (가위(0), 바위(1), 보(2))");
            int user = scanner.nextInt();
            System.out.println("USER: " + user);

            int com = random.nextInt(3);
            System.out.println("COM: " + com);

            if (com == user) {
                System.out.println("DRAW");
                continue;
            }

            // 만일 컴의 값이 사용자의 값보다 작다면 컴값에 3을 더한다.
            com = com < user ? com + 3 : com;

            // 결과차이
            int result = com - user;

            // 2이면 user 승, 1이면 user 패, 0이면 비김
            if (result == 2) {
                System.out.println("USER WIN!");
                userWins++;
            } else if (result == 1) {
                System.out.println("USER DEFEAT");
                comWins++;
            }

            System.out.println("현재 스코어 - USER: " + userWins + ", COM: " + comWins);
        }

        if (userWins == 3) {
            System.out.println("사용자가 승리했습니다!");
        } else {
            System.out.println("컴퓨터가 승리했습니다!");
        }
    }
}




