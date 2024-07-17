package org.example.weather;

public class Weather {
//색인번호

    //날짜
    String date;
    //최고온도
    int maxTemp;
    int minTemp;
    String weatherInfo;

    public Weather(String date,int maxTemp, int minTemp,String weatherInfo) {

        this.date = date;
        this.weatherInfo = weatherInfo;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", weatherInfo='" + weatherInfo + '\'' +
                '}'+'\n';
    }
}
