package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class LinkedHashSet<T> implements Set<T> {
    private int size;
    private static class Node<T> {
    	T obj;
    	Node<T> prev;
    	Node<T> next;
    	Node(T obj) {
    		this.obj = obj;
    	}
    	
    }
    Node<T> head;
	Node<T> tail;
	HashMap<T, Node<T>> map = new HashMap<>();
	
    private class LinkedHashSetIterator implements Iterator<T> {
    	Node<T> current = head;
    	boolean flNext = false;
        
		@Override
		public boolean hasNext() {
			//  Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			//  Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T res = current.obj;
			current = current.next;
			flNext = true;
			return res;
		}
    	@Override
    	public  void remove() {
    		//
    		if (!flNext) {
    			throw new IllegalStateException();
    		}
    	
    		Node<T> removedNode = current != null ? current.prev : tail;
    		removeNode(removedNode);
    		map.remove(removedNode.obj);
    		flNext = false;
    		size--;
    	}
    	
    }
	@Override
	public boolean add(T obj) {
		boolean res = false;
		if(!map.containsKey(obj)) {
			res = true;
			Node<T> node = new Node<>(obj);
			map.put(obj, node);
			addNode(node);
			size++;
		}
		return res;
	}

	private void addNode(Node<T> node) {
		//  Auto-generated method stub
		if (head == null) {
			head = tail = node;
		} else {
		node.prev = tail;
		tail.next = node;
		tail = node;
		}
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		Node<T> node = map.get(pattern);
		if (node != null) {
			res = true;
			removeNode(node);
			map.remove(pattern);
			size--;
		}
		return res;
	}

	private void removeNode(Node<T> node) {
		//  Auto-generated method stub
		if (node == head) {
			removeHead();
		} else if (node == tail) {
			removeTail();
		} else {
			removeMiddle(node);
		}
		//size--;
	}

	private void removeMiddle(Node<T> node) {
		//  Auto-generated method stub
		Node<T> nodeBefore = node.prev;
		Node<T> nodeAfter = node.next;
		nodeBefore.next = nodeAfter;
		nodeAfter.prev = nodeBefore;
		node.next = node.prev = null;
		
	}

	private void removeTail() {
		//  Auto-generated method stub
		Node<T> newTail = tail.prev;
		if (newTail != null) {
			newTail.next = null;
		}
		tail.prev = null;
		tail = newTail;
	}

	private void removeHead() {
		//  Auto-generated method stub
		Node<T> newHead = head.next;
		if (newHead != null) {
			newHead.prev = null;
		}
		head.next = null;
		head = newHead;
	}

	@Override
	public boolean contains(T pattern) {
		
		return map.containsKey(pattern);
	}

	@Override
	public Iterator<T> iterator() {
		
		return new LinkedHashSetIterator();
	}

	@Override
	public T get(T pattern) {
		Node<T> resNode = map.get(pattern);
		return resNode != null ? resNode.obj : null;
			}

}
