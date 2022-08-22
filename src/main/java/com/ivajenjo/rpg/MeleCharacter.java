package com.ivajenjo.rpg;

public class MeleCharacter extends Character{
    public MeleCharacter(int health) {
        super(health);
    }

    public MeleCharacter() {
        super();
    }

    public MeleCharacter(int health, int level) {
        super(health, level);
    }

    public int getRange() {
        return 2;
    }
}
