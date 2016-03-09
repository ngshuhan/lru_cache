/**
 * Created by susanna on 3/8/16.
 */
import  java.util.*;

public class LRUCache<K,V> {
    private int limit;
    private HashMap<K,Node<K,V>> cache;
    private Node<K,V> lru;
    private Node<K,V> mru;

    class Node<K,V> {
        Node<K,V> prev;
        Node<K,V> next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int limit) {
        this.limit = limit;
        cache = new HashMap<K,Node<K,V>>();
        mru = new Node(null,null);
        lru = new Node(null,null);
        lru.next = mru;
        mru.prev = lru;
    }

    public int currentSize() {
        return cache.size();
    }


    public void put(K key, V value) {

        if (cache.size() == limit) { //if the cache is full
            cache.remove(lru.key);
            lru = lru.next;
            lru.prev = null;
        }

        Node<K,V> newNode = new Node<K,V>(key,value);
        newNode.prev = mru;
        mru.next = newNode;
        cache.put(key,newNode);
        mru = newNode;
    }

    public V get(K key) {
        Node<K,V> nodeToMove = cache.get(key);
        if (nodeToMove == null) {
            return null;
        }

        if (nodeToMove == mru) {
            return mru.value;
        }

        Node<K,V> nextNode = nodeToMove.next;
        nodeToMove.prev.next = nextNode;
        nextNode.prev = nodeToMove.prev;
        nodeToMove.prev = mru;
        mru.next = nodeToMove;
        mru = nodeToMove;
        mru.next = null;
        return nodeToMove.value;
    }

    public V remove(K key) {
        Node<K,V> nodeToRemove = cache.get(key);
        if (nodeToRemove == null) {
            return null;
        }
        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev.next = nodeToRemove.next;
        return nodeToRemove.value;
    }

    public void removeAll() {
        cache.clear();
        lru = null;
        mru = null;
    }




}
