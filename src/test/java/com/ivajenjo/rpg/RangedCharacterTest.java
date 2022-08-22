package com.ivajenjo.rpg;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RangedCharacterTest {

    @Test
    void character_has_range_of_20() {
        RangedCharacter rangedCharacter = new RangedCharacter(100);
        assertThat(rangedCharacter.getRange()).isEqualTo(20);
    }
}
