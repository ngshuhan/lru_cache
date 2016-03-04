
import java.util.*;

class Node<T,U> {
	Node<T,U> prev;
	Node<T,U> next;
	T key;
	U value;

	public Node(T key, U value) {
		this.key = key;
		this.value = value;
	}

}

public class LRUCache<K,V> {
	private int limit;
	private HashMap<K,Node<K,V>> cache;
	private Node<K,V> lru;
	private Node<K,V> mru;

	public LRUCache(int limit) {
		this.limit = limit;
		cache = new HashMap<T,Node<K,V>>();
	}

	public void put(T key, V value) {

		if (cache.size == limit) { //if the cache is full
			cache.remove(lru.key);
			lru = lru.next;
			lru.prev = null;
		}

		Node<K,V> newNode = new Node<K,V>(key,value);
		newNode.prev = mru;
		mru.next = newNode;
		cache.put(key,newNode);
	}

	public V get(K key) {
		Node nodeToMove = cache.get(key);
		if (nodeToMove == null) {
			return null;
		} 
		if (nodeToMove == mru) {
			return mru.value;
		}

		Node nextNode = nodeToMove.next;
		nodeToMove.prev.next = nextNode;
		nextNode.prev = nodeToMove.prev;
		nodeToMove.prev = mru;
		mru.next = nodeToMove;
		mru = nextToMove;
		mru.next = null;
		return nodeToMove.value;
	}

	public void remove(T key) {
		Node nodeToRemove = cache.get(key);
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