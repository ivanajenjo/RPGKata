package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.AttackController;
import com.ivajenjo.rpg.Character;

import java.util.HashSet;

public class Attack {
    private final Character attacker;
    private AttackController attackController;

    public Attack(Character attacker, AttackController attackController) {
        this.attacker = attacker;
        this.attackController = attackController;
    }

    public Attack(Character attacker) {
        this.attacker = attacker;
        this.attackController = new AttackController(new HashSet<>());
    }

    public AttackController getAttackController() {
        return attackController;
    }

    public void setAttackController(AttackController attackController) {
        this.attackController = attackController;
    }

    public Character getAttacker() {
        return attacker;
    }

    public void attack(Character target, int damage) {
        int computedDamage = computeDamage(attacker, target, damage);
        target.receiveDamage(computedDamage);
    }

    public int computeDamage(Character attacker, Character target, int damage) {
        if (attacker.equals(target)) {
            return 0;
        } else if (attackController.areAllies(attacker, target)) {
            return 0;
        } else if (attacker.getRange() < target.getRange()) {
            return 0;
        } else if (shouldDealIncreasedDamage(target)) {
            return damage * 2;
        } else if (shouldDealReducedDamage(target)) {
            return damage / 2;
        } else {
            return damage;
        }
    }

    private boolean shouldDealReducedDamage(Character target) {
        return attacker.getLevel() <= target.getLevel() - 5;
    }

    private boolean shouldDealIncreasedDamage(Character target) {
        return attacker.getLevel() >= target.getLevel() + 5;
    }
}
