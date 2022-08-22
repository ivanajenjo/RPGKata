package com.ivajenjo.rpg;

import java.util.Set;

public class AttackController {
    private final Set<Faction> factions;

    public AttackController(Set<Faction> factions) {
        this.factions = factions;
    }

    public boolean areAllies(Character character, Character otherCharacter) {
        for (Faction faction : factions) {
            if (faction.areAllies(character, otherCharacter)) {
                return true;
            }
        }
        return false;
    }
}
