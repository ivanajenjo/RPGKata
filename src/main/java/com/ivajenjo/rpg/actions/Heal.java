package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.Character;

public class Heal {

    private final Character healer;

    public Heal(Character healer) {
        this.healer = healer;
    }

    public Character getHealer() {
        return healer;
    }

    public void heal(Character target, int healing) {
        if (healer.equals(target)) {
            target.heal(healing);
        }
    }
}
