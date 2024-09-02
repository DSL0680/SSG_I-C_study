package org.example;

public class LeapYearChecker {
    public static void main(String[] args) {

    //4로 나눈 나머지가 0이면 윤년
    //100으로 나눈 나머지가 0이면 평년
    //400으로 나눈 나머지가 0이면 윤년
    int year = 2000; //윤년

    boolean isLeapYear = false;

    if(year % 400 == 0){
        isLeapYear = true;
    }else if (year % 100 == 0){
        isLeapYear = false;  //평년
    }else if (year % 4 == 0){
        isLeapYear = true;
    }
    }

}
