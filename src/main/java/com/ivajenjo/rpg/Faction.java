package com.ivajenjo.rpg;

import java.util.HashSet;
import java.util.Set;

public class Faction {
    private Set<Character> characters = new HashSet<>();

    public boolean areAllies(Character character, Character otherCharacter2) {
        return characters.contains(character) && characters.contains(otherCharacter2);
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public boolean hasMember(Character character) {
        return characters.contains(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }
}
