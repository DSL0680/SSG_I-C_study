package org.example.lotto;

import java.util.ArrayList;

public class LottoMachine {

    ArrayList<LottoBall> balls;

    public LottoMachine(ArrayList<LottoBall> balls) {
        this.balls = balls;
    }

    public int[] selectBalls() {
        int[] result = new int[6];

        //6번
        for (int i = 0; i < 6; i++) {

            //0부터 44까지
            int idx = (int)(Math.random() * 45);
            LottoBall temp = balls.get(idx);

            if(temp.marked == true) {
                //뽑힌적이 있따면
                i--;
                continue;
            }

            result[i] = temp.num;

            temp.marked = true;

        }//end for

        clearBalls();

        return result;
    }

    public void clearBalls() {

        int size = this.balls.size();

        for (int i = 0; i < size; i++) {

            balls.get(i).marked = false;

        }

    }

}
