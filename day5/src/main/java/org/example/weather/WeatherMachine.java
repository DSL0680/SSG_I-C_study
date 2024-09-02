package org.example.weather;

import org.example.lotto.LottoBall;

import java.util.ArrayList;

public class WeatherMachine {
    ArrayList<Weather> pastWeather;
    public WeatherMachine(ArrayList<Weather> pastWeather) {
        this.pastWeather = pastWeather;
    }
    public String[] select_Weather() {
        String[] result = new String[pastWeather.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pastWeather.get(i).toString();
            System.out.println(result[i]);
        }
        return result;
    }


}
