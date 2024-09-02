package org.example.lotto;

public class LottoBall {

    int num;
    boolean marked;

    public LottoBall(int num) {
        this.num = num;
        this.marked = false;
    }

    @Override
    public String toString() {
        return "LottoBall{" +
                "num=" + num +
                ", marked=" + marked +
                '}';
    }
}//end class
