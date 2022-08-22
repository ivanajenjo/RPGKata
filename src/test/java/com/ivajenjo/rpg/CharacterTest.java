package com.ivajenjo.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CharacterTest {

    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character();
    }

    @Test
    void it_should_not_fail() {
        assertThat(42)
                .isEqualTo(42);
    }

    @Test
    void character_setup_max_health_and_lvl() {
        assertThat(character.getHealth()).isEqualTo(Character.MAX_HEALTH);
        assertThat(character.getLevel()).isEqualTo(1);
    }

    @Test
    void character_alive_when_health_above_zero() {
        assertThat(character.isAlive()).isTrue();
    }

    @Test
    void character_dead_when_health_below_zero() {
        character.receiveDamage(Character.MAX_HEALTH + 1);
        assertThat(character.isAlive()).isFalse();
    }

    @Test
    void character_receive_damage_reduces_health() {
        character.receiveDamage(100);
        assertThat(character.getHealth()).isEqualTo(900);
    }

    @Test
    void character_heal_increases_health() {
        character.receiveDamage(100);
        character.heal(100);
        assertThat(character.getHealth()).isEqualTo(1000);
    }

    @Test
    void character_damage_does_not_exceed_0_health() {
        character.receiveDamage(1100);
        assertThat(character.getHealth()).isZero();
        assertThat(character.isAlive()).isFalse();
    }

    @Test
    void character_heal_does_not_exceed_max_health() {
        character.receiveDamage(100);
        character.heal(Character.MAX_HEALTH + 1);
        assertThat(character.getHealth()).isEqualTo(Character.MAX_HEALTH);
    }

    @Test
    void character_cannot_heal_if_dead() {
        character.receiveDamage(Character.MAX_HEALTH + 1);
        character.heal(100);
        assertThat(character.getHealth()).isZero();
    }
}
