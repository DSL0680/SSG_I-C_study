package org.example;

import org.example.weather.Weather;
import org.example.weather.WeatherMachine;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Weather> list = new ArrayList<Weather>();

        list.add(new Weather("1",1,1,""));
        list.add(new Weather("2",1,1,""));
        list.add(new Weather("3",1,1,""));
        list.add(new Weather("4",1,1,""));
        list.add(new Weather("5",1,1,""));
        list.add(new Weather("6",1,1,""));
        list.add(new Weather("7",1,1,""));
        list.add(new Weather("8",1,1,""));
        list.add(new Weather("9",1,1,""));
        list.add(new Weather("10",1,1,""));
        WeatherMachine weatherMachine = new WeatherMachine(list);
        System.out.println(Arrays.toString(weatherMachine.select_Weather()));













//        ArrayList<LottoBall> list = new ArrayList<>();
//
//        for (int i = 1; i <= 45; i++) {
//            LottoBall ball = new LottoBall(i);
//            list.add(ball);
//        }//end for
//
//        LottoMachine lottoMachine = new LottoMachine(list);
//
//        LottoUI lottoUI = new LottoUI(lottoMachine);
//
//        lottoUI.run();




        //        int[] nums = lottoMachine.selectBalls();
//        System.out.println(Arrays.toString(nums));









        //        BMIUI ui = new BMIUI();
//
//        ui.run();

    }//end main

}//end class