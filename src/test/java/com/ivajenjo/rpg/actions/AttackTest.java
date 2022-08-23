package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.*;
import com.ivajenjo.rpg.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackTest {

    //Difference between assertThat and assertEquals, when to use ...
    Attack attack;

    @BeforeEach
    void setUp() {
        attack = new Attack(new Character(1000, 10));
    }

    @Test
    void character_attacks_target_with_damage() {
        Character target = new Character(1000, 10);
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(900);
    }

    @Test
    void character_attacks_itself_with_damage() {
        attack.attack(attack.getAttacker(), 100);
        assertThat(attack.getAttacker().getHealth()).isEqualTo(Character.MAX_HEALTH);
    }

    @Test
    void character_attacks_target_5_levels_above_itself_with_dmg_reduced() {
        Character target = new Character(Character.MAX_HEALTH, 15);
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(950);
    }

    @Test
    void character_attacks_target_5_levels_below_itself_with_dmg_increased() {
        Character target = new Character(Character.MAX_HEALTH, 5);
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(800);
    }

    @Test
    void character_cannot_attack_target_with_higher_range() {
        Character target = new RangedCharacter(1000, 10);
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(1000);
    }

    @Test
    void character_can_not_attack_allied_target() {
        Character target = new Character(1000, 10);
        Faction mercadoners = new Faction();
        mercadoners.addCharacter(attack.getAttacker());
        mercadoners.addCharacter(target);
        Set<Faction> factions = new HashSet<>();
        factions.add(mercadoners);
        AttackController attackController = new AttackController(factions);
        attack.setAttackController(attackController);
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(1000);
    }

    @Test
    void character_can_attack_enemy_faction_target() {
        Character target = new Character(1000, 10);
        Faction mercadoners = new Faction();
        mercadoners.addCharacter(attack.getAttacker());
        Faction providers = new Faction();
        providers.addCharacter(target);
        Set<Faction> factions = new HashSet<>();
        factions.add(mercadoners);
        factions.add(providers);
        AttackController attackController = new AttackController(factions);
        attack.setAttackController(attackController);
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(900);
    }

    @Test
    void character_can_attack_thing(){
        Thing tree = new Tree();
        attack.attack(tree, 200);
        assertEquals(tree.getHealth(), 1800);
    }

}
