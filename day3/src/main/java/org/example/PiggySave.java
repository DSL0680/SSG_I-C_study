package org.example;

public class PiggySave {

    // 상태 - 잔액을 저장하는 변수
    int balance;

    // 입금 - 금액(int)을 입력받아 잔액에 추가, 반환 값 없음
    public void deposit(int amount) {
        this.balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + this.balance + "원");
    }

    // 출금 - 반환 값: 출금된 금액(int)
    public int withdraw() {
        int withdrawnAmount = this.balance;
        this.balance = 0;
        return withdrawnAmount;
    }
}
