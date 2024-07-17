package org.example.vend;

public class CongoMsg implements Msg {

    @Override
    public String insertCoin() {
        return "s'il vous plaît";
    }

    @Override
    public String choice() {
        return "Vous pouvez choisir un menu";
    }

    @Override
    public String thanks() {
        return "Merci d'avoir utilisé ça";
    }
}