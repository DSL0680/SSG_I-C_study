package org.example.vend;

public class ItalianMsg implements Msg{

    @Override
    public String insertCoin() {
        return "Fai una moneta.";
    }

    @Override
    public String choice() {
        return "Si prega di specificare un menu.";
    }

    @Override
    public String thanks() {
        return "Grazie per il suo uso.";
    }
}