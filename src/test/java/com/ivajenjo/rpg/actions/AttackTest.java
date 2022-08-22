package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AttackTest {

    Attack attack;

    @BeforeEach
    void setUp() {
        attack = new Attack(new Character());
    }

    @Test
    void character_attacks_target_with_damage() {
        Character target = new Character();
        attack.attack(target, 100);
        assertThat(target.getHealth()).isEqualTo(900);
    }

}
