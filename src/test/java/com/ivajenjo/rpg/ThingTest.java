package com.ivajenjo.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThingTest {
    Thing tree;

    @BeforeEach
    void setup() {
        tree = new Tree();
    }

    @Test
    void thing_should_receive_dmg() {
        tree.receiveDamage(100);
        assertEquals(tree.getHealth(), 1900);
    }

    @Test
    void thing_status_should_be_ALIVE_when_created() {
        assertEquals(tree.status(), Status.ALIVE);
    }

    @Test
    void thing_health_should_not_be_negative() {
        tree.receiveDamage(3000);
        assertThat(tree.getHealth()).isZero();
    }

    @Test
    void thing_should_be_DESTROYED_when_health_is_zero() {
        tree.receiveDamage(2000);
        assertEquals(tree.status(), Status.DESTROYED);
    }
}
