package com.ivajenjo.rpg;

public abstract class Thing {
    protected int health;

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public Status status() {
        if (health == 0) {
            return Status.DESTROYED;
        }
        return Status.ALIVE;
    }
}
