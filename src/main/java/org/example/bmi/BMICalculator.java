package org.example.bmi;


/**
 * 비만지수 계산기
 */
public class BMICalculator {

    /**
     * 키와 몸무게가 필요하다
     * @param height
     * @param weight
     * @return
     */

    //calc    인자 - 키(double height), 몸무게 (double weight), 리턴 (double)
    public static double calc(double height, double weight) {
        double result = 0.0;

        result = weight / (height * height);

        return result;
    }//end calc

}
