package org.example;

public class Player {

    int hp;
    String name;

    public Player(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }

    public int attack() {
        return 100 - hp;
    }

    public String defense(int damage) {
        this.hp -= damage;
        return "WoW.. I left " + hp;
    }
}
