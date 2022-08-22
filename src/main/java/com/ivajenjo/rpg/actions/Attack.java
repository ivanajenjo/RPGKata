package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.Character;

public class Attack {
    private final Character attacker;

    public Attack(Character attacker) {
        this.attacker = attacker;
    }

    public Character getAttacker() {
        return attacker;
    }

    public void attack(Character target, int damage) {
        if (!attacker.equals(target)) {
            if (attacker.getLevel() >= target.getLevel() + 5) {
                target.receiveDamage(damage * 2);
            } else if (attacker.getLevel() <= target.getLevel() - 5) {
                target.receiveDamage(damage / 2);
            } else {
                target.receiveDamage(damage);
            }
        }
    }
}
