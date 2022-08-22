package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.AttackController;
import com.ivajenjo.rpg.Character;

import java.util.HashSet;

public class Heal {

    private final Character healer;

    private AttackController attackController;

    public Heal(Character healer, AttackController attackController) {
        this.healer = healer;
        this.attackController = attackController;
    }

    public Heal(Character healer) {
        this.healer = healer;
        this.attackController = new AttackController(new HashSet<>());
    }

    public AttackController getAttackController() {
        return attackController;
    }

    public void setAttackController(AttackController attackController) {
        this.attackController = attackController;
    }

    public Character getHealer() {
        return healer;
    }

    public void heal(Character target, int healing) {
        if (isHealingHimself(target) || attackController.areAllies(healer, target)) {
            target.heal(healing);
        }
    }

    private boolean isHealingHimself(Character target) {
        return healer.equals(target);
    }
}
