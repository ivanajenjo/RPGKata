package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.AttackController;
import com.ivajenjo.rpg.Character;
import com.ivajenjo.rpg.Faction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HealTest {

    Heal heal;

    @BeforeEach
    void setUp() {
        heal = new Heal(new Character(900));
    }

    @Test
    void character_heals_target_with_healing() {
        Character target = new Character(900);
        heal.heal(target, 100);
        assertThat(target.getHealth()).isEqualTo(900);
    }

    @Test
    void character_only_heals_himself(){
        heal.heal(heal.getHealer(), 100);
        assertThat(heal.getHealer().getHealth()).isEqualTo(1000);
    }

    @Test
    void character_can_heal_allies(){
        Character target = new Character(900);
        Faction mercadoners = new Faction();
        mercadoners.addCharacter(heal.getHealer());
        mercadoners.addCharacter(target);
        Set<Faction> factions = new HashSet<>();
        factions.add(mercadoners);
        AttackController attackController = new AttackController(factions);
        heal.setAttackController(attackController);
        heal.heal(target, 100);
        assertThat(target.getHealth()).isEqualTo(1000);
    }

    @Test
    void character_can_not_heal_enemies(){
        Character target = new Character(900);
        Faction mercadoners = new Faction();
        Faction enemies = new Faction();
        mercadoners.addCharacter(heal.getHealer());
        enemies.addCharacter(target);
        Set<Faction> factions = new HashSet<>();
        factions.add(mercadoners);
        factions.add(enemies);
        AttackController attackController = new AttackController(factions);
        heal.setAttackController(attackController);
        heal.heal(target, 100);
        assertThat(target.getHealth()).isEqualTo(900);
    }
}
