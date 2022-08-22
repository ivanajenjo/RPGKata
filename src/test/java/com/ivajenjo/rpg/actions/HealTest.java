package com.ivajenjo.rpg.actions;

import com.ivajenjo.rpg.Character;
import org.junit.jupiter.api.BeforeEach;

public class HealTest {

    Heal heal;

    @BeforeEach
    void setUp() {
        heal = new Heal(new Character());
    }
}
