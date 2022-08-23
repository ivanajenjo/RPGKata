package com.ivajenjo.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {

    Tree tree;

    @BeforeEach
    void setup() {
        tree = new Tree();
    }

    @Test
    void tree_should_have_full_health_when_created() {
        assertEquals(tree.getHealth(), 2000);
    }

}
