package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
