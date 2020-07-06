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
        this.size = 0;
        this.root = null;
    }

    public RBbst(RBbst<K,V> other){
        //make copy constructor
    }

    @Override
    public void put(K key, V value) throws InvalidParameterException {
        if(key == null || value == null){
            throw new InvalidParameterException();
        }
        root = insert(root, key, value);
        root.color = Color.BLACK;
        this.size++;
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
       return this.size;
    }

    public K getRootKey(){
        if(this.root == null) {
            return null;
        }
        return this.root.key;
        
    }


    /****************************
     * Private helper functions *
     * **************************/

     private Node insert(Node curr, K key, V value){
        if(curr == null) {
            return new Node(key, value);
        }
        if(key.compareTo(curr.key) < 0) {
            curr.left = insert(curr.left, key, value);
        } else if(key.compareTo(curr.key) > 0){
            curr.right = insert(curr.right, key, value);
        } else {
            curr.key = key;
            curr.value = value;
            return curr;
        }
        if(isRed(curr.right) && !isRed(curr.left)){
            curr = rotateLeft(curr);
        }
        if(isRed(curr.left) && isRed(curr.left.left)){
            curr = rotateRight(curr);
        }
        if(isRed(curr.left) && isRed(curr.right)) {
            switchColors(curr);
        }
        
        return curr;
     }
     
     private boolean isRed(Node node){
         if(node == null){
             return false;
         } else if(node.color == Color.BLACK){
             return false;
         } else {
             return true;
         }
     }

     //Called when we have two red nodes in a row on the left side
     private Node rotateRight(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.color = node.color;
        temp.right = node;
        temp.right.color = Color.RED;
        return temp;
     }

     //called when we insert a node on the right
     private Node rotateLeft(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.color = node.color;
        temp.left = node;
        temp.left.color = Color.RED;
        return temp;
     }

     

     //When a node has two children with the color RED
     private void switchColors(Node node){
        node.right.color = node.left.color = Color.BLACK;
        node.color = Color.BLACK;
     }

     

}