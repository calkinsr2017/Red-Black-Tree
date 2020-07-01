package RBbst;

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
    private class node{
        private K key;
        private V value;
        private node left,right;

        

    }
    /**
     * instance Variables
     */

    private int size;
    

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