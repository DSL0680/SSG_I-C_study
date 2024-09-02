package org.example;

public class Monster {

    //현재 객체의 상태
    int hp;
    int level;

    public Monster(int level) {
        this.hp = level * 10;
        this.level = level;
    }

    //makeFire() // level * 10 이내의 공격
    public int attack() {
        return level * (int)(Math.random() * 10);
    }

    //eatMan()
    //반환되는 값은 괴물의 남은 체력
    public int damage(int amount) {
        this.hp = this.hp - amount;
        return this.hp;
    }



}
