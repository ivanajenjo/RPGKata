package com.ivajenjo.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FactionTest {
    private Character character;
    private Faction mercadoners;
    private Faction providers;

    @BeforeEach
    public void setUp() {
        character = new Character();
        mercadoners = new Faction();
        providers = new Faction();
    }

    @Test
    void character_can_join_a_faction() {
        mercadoners.addCharacter(character);
        assertThat(mercadoners.hasMember(character)).isTrue();
    }

    @Test
    void character_can_join_multiple_factions() {
        mercadoners.addCharacter(character);
        providers.addCharacter(character);
        assertThat(mercadoners.hasMember(character)).isTrue();
        assertThat(providers.hasMember(character)).isTrue();
    }

    @Test
    void character_can_leave_a_faction() {
        mercadoners.addCharacter(character);
        mercadoners.removeCharacter(character);
        assertThat(mercadoners.hasMember(character)).isFalse();
    }

    @Test
    void character_can_leave_multiple_factions() {
        mercadoners.addCharacter(character);
        providers.addCharacter(character);
        mercadoners.removeCharacter(character);
        providers.removeCharacter(character);
        assertThat(mercadoners.hasMember(character)).isFalse();
        assertThat(providers.hasMember(character)).isFalse();
    }

    @Test
    void characters_in_same_faction_are_allies() {
        Character otherCharacter = new Character();
        mercadoners.addCharacter(character);
        mercadoners.addCharacter(otherCharacter);
        assertThat(mercadoners.areAllies(character, otherCharacter)).isTrue();
    }

    @Test
    void characters_in_different_faction_are_not_allies() {
        Character otherCharacter = new Character();
        mercadoners.addCharacter(character);
        providers.addCharacter(otherCharacter);
        assertThat(mercadoners.areAllies(character, otherCharacter)).isFalse();
    }
}
