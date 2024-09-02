package org.example.vend;

public class GermanMsg implements Msg{
    @Override
    public String insertCoin() {
        return "Bitte verwenden Sie Münzen";
    }

    @Override
    public String choice() {
        return "Bitte wählen Sie ein Menü aus";
    }

    @Override
    public String thanks() {
        return "Danke für das benutzen";
    }
}
