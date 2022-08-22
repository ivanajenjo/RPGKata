package com.ivajenjo.rpg;

public class Character {
    public static final int MAX_HEALTH = 1000;

    private int health;
    private int level;

    public Character(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public Character() {
        this.health = MAX_HEALTH;
        this.level = 1;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int healing) {
        if (isAlive()) {
            health += healing;
            if (health > MAX_HEALTH) {
                health = MAX_HEALTH;
            }
        }

    }
}
