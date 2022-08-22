package com.ivajenjo.rpg;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AttackControllerTest {

    @Test
    void characters_can_be_allies() {
        Character character = new Character();
        Character otherCharacter = new Character();
        Faction mercadoners = new Faction();
        mercadoners.addCharacter(character);
        mercadoners.addCharacter(otherCharacter);
        Faction providers = new Faction();
        Set<Faction> factions = new HashSet<>();
        factions.add(mercadoners);
        factions.add(providers);
        AttackController attackController = new AttackController(factions);
        assertThat(attackController.areAllies(character, otherCharacter)).isTrue();
    }

    @Test
    void characters_can_not_be_allies() {
        Character character = new Character();
        Character otherCharacter = new Character();
        Faction mercadoners = new Faction();
        mercadoners.addCharacter(character);
        Faction providers = new Faction();
        providers.addCharacter(otherCharacter);
        Set<Faction> factions = new HashSet<>();
        factions.add(mercadoners);
        factions.add(providers);
        AttackController attackController = new AttackController(factions);
        assertThat(attackController.areAllies(character, otherCharacter)).isFalse();
    }

}
