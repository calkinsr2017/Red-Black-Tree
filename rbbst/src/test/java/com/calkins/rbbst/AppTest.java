package com.calkins.rbbst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
  

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
        String result = "55:BLACK\n66:RED\n70:BLACK\n80:BLACK\n85:RED\n90:BLACK\n";
        assertEquals(tree.toString(), result);
    }

    //Test flipColors
    @Test
    void type1Insert(){
        RBbst<Integer, Integer> tree = new RBbst<>();
        tree.put(66,66);
        tree.put(55,55);
        tree.put(70,70);
        
        String result = "55:BLACK\n66:BLACK\n70:BLACK\n";

        assertEquals(tree.getRootKey(), 66);
        assertEquals(tree.toString(), result);
    }
    
    //test rotateRight then flipColors
    @Test
    void type2Insert() {
        RBbst<Integer, Integer> tree = new RBbst<>();
        tree.put(66,66);
        tree.put(55,55);
        tree.put(40,40);
        
        String result = "40:BLACK\n55:BLACK\n66:BLACK\n";

        assertEquals(tree.getRootKey(), 55);
        assertEquals(tree.toString(), result);
    }

    //test rotateLeft, rotateRight then flipColors
    @Test
    void type3Insert(){
        RBbst<Integer, Integer> tree = new RBbst<>();
        tree.put(66,66);
        tree.put(55,55);
        tree.put(60,60);
        
        String result = "55:BLACK\n60:BLACK\n66:BLACK\n";

        assertEquals(tree.getRootKey(), 60);
        assertEquals(tree.toString(), result);
    }

    
}
