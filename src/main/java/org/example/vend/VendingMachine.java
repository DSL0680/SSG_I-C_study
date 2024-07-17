package org.example.vend;

public class VendingMachine {

    private Msg msg;

    public VendingMachine(Msg msg) {
        this.msg = msg;
    }

    public void start() {

        System.out.println(msg.insertCoin());
        System.out.println(msg.choice());
        System.out.println(msg.thanks());

    }
}
