package com.ivajenjo.rpg;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MeleCharacterTest {

    @Test
    void character_has_range_of_2() {
        MeleCharacter meleCharacter = new MeleCharacter(100);
        assertThat(meleCharacter.getRange()).isEqualTo(2);
    }
}
