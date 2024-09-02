package org.example;

import java.util.Scanner;

public class PiggySaveUI {

    //공유
    //협업자, 조력자

    //생성자의 의미 - 로직을 수행하기 전에 준비하는 작업
    //생성자의 파라미터 - 협업자, 조력자의 리모컨을 전달
    PiggySave piggySave = new PiggySave();
    Scanner scanner = new Scanner(System.in);


    //입금 UI 이름 depositInput 입력() 출력-void
    public void depositInputUI() {
        System.out.println("입금할 금액을 입력해주세요.");

        int amount = scanner.nextInt();
        piggySave.deposit(amount);

    }


    //출금 UI 이름 widthdrawOut 입력() 출력-void
    public void widthdrawOutUI() {

        System.out.println("출금액: " + piggySave.withdraw() + ", 잔액: " + piggySave.balance);

    }


    //메뉴 종료 기능 showMenus() 입력 () 출력-void
    public void showMenus() {
        while (true) {
            System.out.println("(1)입금 (2)출금 (3)종료");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositInputUI();
                    break;

                case 2:
                    widthdrawOutUI();
                    break;

                case 3:
                    System.out.println("종료합니다.");
                    return;

            }//end switch

        }//end while

    }//end showMenus

}//end class
