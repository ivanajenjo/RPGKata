package com.ivajenjo.rpg;

public class RangedCharacter extends Character {
    public RangedCharacter(int health) {
        super(health);
    }

    public RangedCharacter() {
        super();
    }

    public RangedCharacter(int health, int level) {
        super(health, level);
    }

    public int getRange() {
        return 20;
    }
}
