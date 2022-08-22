package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.Character;

public class Attack {
    private final Character attacker;

    public Attack(Character attacker) {
        this.attacker = attacker;
    }

    public void attack(Character target, int damage) {
        target.receiveDamage(damage);
    }
}
