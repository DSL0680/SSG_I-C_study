package org.example.vend;

public class ThaiMsg implements Msg{
    @Override
    public String insertCoin() {
        return "กรุณาหยอดเหรียญ";
    }

    @Override
    public String choice() {
        return "กรุณาเลือกเมนู";
    }

    @Override
    public String thanks() {
        return "ขอบคุณครับ";
    }
}