package org.example.bmi;

import java.util.Scanner;

public class BMIUI {

    Scanner sc;

    public BMIUI() {
        sc = new Scanner(System.in);
    }

    public void run() {


        while (true) {
            //1번 계산 2번 종료
            System.out.println("1.계산 2.종료");
            int choice = sc.nextInt();

            if(choice == 2) {
                System.out.println("END");
                break;
            }else if(choice == 1) {
                inputInfo();
            }


        }//end while

    }//end run()

    private void inputInfo() {

        System.out.println("키를 입력하세요 ex) 180cm = 1.8 입력");

        double height = sc.nextDouble();

        System.out.println("몸무게를 입력하세요.");
        double weight = sc.nextDouble();

        double bmi = BMICalculator.calc(height, weight);

        System.out.println(bmi);

    }//end inputInfo()

}//end class
