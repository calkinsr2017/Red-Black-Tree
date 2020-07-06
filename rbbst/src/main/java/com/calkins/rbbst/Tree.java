package com.calkins.rbbst;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/** <p>{@link Tree} interface represents a generic treeMap class. All the relevent public methods that can be generalized to all types of trees are included within this 
 * interface.</p>
 * @author Robert Calkins
 *
 * @see RBbst
 * @see Tests
 */

public interface Tree<K extends Comparable<K>, V> {


    /**
     * If the key does not exist within the tree, put will insert the key-value pair. Otherwise, it will update the value for the associated key given. 
     * If key or value is null this function will throw an InvalidParameterException.
     * @param key
     * @param value
     * @throws InvalidParameterException
     */
    public void put(K key, V value) throws InvalidParameterException;

    /**
     * Retrieves the value associated with the given key. Throws InvalidParameterException if key is null.
     * @param key
     * @return the value associated with key or null if the key is not in the tree
     * @throws InvalidParameterException
     */
    public V get(K key) throws InvalidParameterException;

    /**
     * Will remove the node associated with the given key and return the associated value.
     * 
     * @param key
     * @return the value or null if key is not in the tree
     * @throws InvalidParameterException
     */
    public V remove(K key) throws InvalidParameterException;

    /**
     * 
     * @param key
     * @return true if key exists in the tree, false otherwise
     * @throws InvalidParameterException
     */
    public boolean containsKey(K key) throws InvalidParameterException;

    /**
     * 
     * @param value
     * @return true if value exists in the tree, false otherwise
     * @throws InvalidParameterException
     */
    public boolean containsValue(V value) throws InvalidParameterException;


    /**
     * @return An inorder representation of the key/value pair
     */
    @Override
    public String toString();

    /**
     * @return An ArrayList of keys in sorted order
     */
    public ArrayList<K> getKeys();

    /**
     * 
     * @return An ArrayList of values retrieved from an in-order traversal
     */
    public ArrayList<V> getValues();

    /**
     * 
     * @return the size of the current true
     */
    public int getSize();

  
    
    




}