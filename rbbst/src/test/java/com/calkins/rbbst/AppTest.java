package com.calkins.rbbst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testBasicTree() {
        RBbst<Integer, Integer> tree = new RBbst<>();
        tree.put(55,55);
        tree.put(80,80); //should rotate left
        assertEquals(tree.getRootKey(), 80);
        tree.put(90,90);
        tree.put(85,85);
        tree.put(66,66); //should cause a rotation at 55
        tree.put(70,70); //flipColors at 66

        //do a toString equals
    }

    @Test
    void type1Insert(){

    }

    @Test
    void type2Insert() {

    }


    @Test
    void type3Insert(){

    }
}
