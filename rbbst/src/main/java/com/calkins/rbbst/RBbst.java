package com.calkins.rbbst;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * <p>
 * {@link RBbst}
 * </p>
 *
 * @author Robert Calkins
 *
 * @see Tests
 */

public class RBbst<K extends Comparable<K>, V> implements Tree<K, V> {
    
    private enum Color {
        RED, BLACK;
    }
    
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        private Color color;
        private boolean marked;

        public Node(K key, V value){
            this.key = key;
            this.value = value;

            this.left = this.right = null;
            this.color = Color.RED;
            this.marked = false;
        }

    }
    /**
     * instance Variables
     */

    private int size;
    private Node root;

    public RBbst(){

    }

    @Override
    public boolean put(K key, V value) throws InvalidParameterException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public V get(K key) throws InvalidParameterException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V remove(K key) throws InvalidParameterException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean containsKey(K key) throws InvalidParameterException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsValue(V value) throws InvalidParameterException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<K> getKeys() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<V> getValues() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }


}