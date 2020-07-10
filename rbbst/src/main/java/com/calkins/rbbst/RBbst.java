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
    

    /********************************************************/
    /********************Private Classes*********************/
    /********************************************************/

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
    
    /********************************************************/
    /******************Instance Variables********************/
    /********************************************************/

    private int size;
    private Node root;
    private int markedNodes;


    /*******************************************************/
    /********************Constructors***********************/
    /*******************************************************/

    public RBbst(){
        this.size = 0;
        this.markedNodes = 0;
        this.root = null;
    }

    public RBbst(RBbst<K,V> other){
        //make copy constructor
    }


    /*******************************************************/
    /*******************Public Methods**********************/
    /*******************************************************/

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
        if(key == null) {
            throw new InvalidParameterException();
        }
        Node curr = root;
        while(curr != null){
            if(curr.key.compareTo(key) > 0) {
                curr = curr.left;
            } else if(curr.key.compareTo(key) < 0){
                curr = curr.right;
            } else if(!curr.marked){
                return curr.value;
            }
        }

         return null;
    }

    /*Remove is implemented using mark and sweep*/
    @Override
    public V remove(K key) throws InvalidParameterException {
        if(key == null) {
            throw new InvalidParameterException();
        }

        V result = markPhase(key);
        
        if((double)markedNodes/(double)(size + markedNodes) > .5){
            sweepPhase();
        }
        
        return result;
        
    }

    @Override
    public boolean containsKey(K key) throws InvalidParameterException {
        if(key == null) {
            throw new InvalidParameterException();
        }

        Node curr = root;
        while(curr != null){
            if(curr.key.compareTo(key) > 0){
                curr = curr.left;
            } else if(curr.key.compareTo(key) < 0) {
                curr = curr.right;
            } else {
                if(!curr.marked){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) throws InvalidParameterException {
        if(value == null) {
            throw new InvalidParameterException();
        } 

        return containsValueHelper(value, root);
    }


    @Override
    public ArrayList<K> getKeys() {
        ArrayList<K> keys = new ArrayList<>();

        getKeysHelper(keys, root);

        return keys;
    }

    

    @Override
    public ArrayList<V> getValues() {
        ArrayList<V> values = new ArrayList<>();

        getValuesHelper(values, root);

        return values;
    }

    @Override
    public int getSize() {
       return this.size;
    }


    //for testing purposes. Key can be marked and therefore not a valid node.
    public K getRootKey(){
        if(this.root == null) {
            return null;
        }
        return this.root.key;
        
    }

    
    public String toString(){
        return toStringHelper(root);
    }

    private String toStringHelper(Node curr){
        String result = "";
        if(curr != null){
            result += toStringHelper(curr.left);
            result += curr.key.toString() + ":" + curr.color.toString() + "\n";
            result += toStringHelper(curr.right);
        }

        return result;
    }


    /*******************************************************/
    /*******************Private Methods*********************/
    /*******************************************************/

    /*********************Put helpers***********************/ 
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
            curr.marked = false;
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
        node.color = Color.RED;
     }


    /************Contains and Get helpers*******************/
    
     private boolean containsValueHelper(V value, Node curr){
        if(curr == null) {
            return false;
        }
        if (curr.value.equals(value)) {
            if(!curr.marked) {
                return true;
            }
        }

        return containsValueHelper(value, curr.right) || containsValueHelper(value, curr.left);
    }

     private void getKeysHelper(ArrayList<K> list, Node curr) {
        if(curr == null) {
            return;
        }
        getKeysHelper(list, curr.left);
        if(!curr.marked){
            list.add(curr.key);
        }
       
        getKeysHelper(list, curr.right);
    }

    private void getValuesHelper(ArrayList<V> list, Node curr){
        if(curr == null) {
            return;
        }
        getValuesHelper(list, curr.left);
        if(!curr.marked){
            list.add(curr.value);
        }
        
        getValuesHelper(list, curr.right);
    }


    /****************Mark and Sweep*****************/
    private V markPhase(K key) {
        Node curr = root;
        while(curr != null){
            if(curr.key.compareTo(key) > 0) {
                curr = curr.left;
            } else if(curr.key.compareTo(key) < 0){
                curr = curr.right;
            } else if(!curr.marked){
                curr.marked = true;
                this.size--;
                this.markedNodes++;
                return curr.value;
            }
        }

        return null;
    }

    private void sweepPhase(){
        RBbst<K,V> other = new RBbst<>();
        ArrayList<K> keys = this.getKeys();
        ArrayList<V> values = this.getValues();
        for(int i = 0; i < keys.size(); i++){
            other.put(keys.get(i), values.get(i));
        }

        this.root = other.root;
    }

     

}