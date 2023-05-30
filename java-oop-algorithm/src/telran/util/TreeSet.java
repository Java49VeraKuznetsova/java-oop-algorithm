package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet<T> implements Set<T> {
	private static class Node<T> {
		T obj;
		Node<T> parent;
		Node<T> left;
		Node<T> right;
		Node(T obj) {
			this.obj = obj;
		}
		
	}
	private Node<T> root;
	private Comparator<T> comp;
	private int size;
	private class TreeSetIterator implements Iterator<T> {
		Node<T> current;
		Node<T> prev;
		boolean flNext = false;
		
		TreeSetIterator() {
			current = root == null ? null : getLeast(root);
		}
		@Override
		public boolean hasNext() {
			
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T res = current.obj;
			prev = current;
			current = getCurrent(current);
			flNext = true;
			return res;
		}
		@Override
		public void remove() {
			if(!flNext) {
				throw new IllegalStateException();
			}
			removeNode(prev);
			flNext = false;
		}
	}
	public TreeSet (Comparator <T> comp) {
		this.comp = comp;
	}
	@SuppressWarnings("unchecked")
	public TreeSet () {
		this((Comparator<T>)Comparator.naturalOrder());
	}
	
	@Override
	public boolean add(T obj) {
		Node<T> node = new Node<>(obj);
		boolean res = false;
		if (size == 0) {
			root = node;
			res = true;
		} else {
			Node<T> parent = getParent(obj);
			if (parent != null) {
				res = true;
				node.parent = parent;
				if(comp.compare(obj, parent.obj) > 0) {
					parent.right = node;
				} else {
					parent.left = node;
				}
			}
		}
		if (res) {
			size++;
		}
		return res;
	}
	private Node<T> getCurrent(Node<T> current) {
		
		return current.right != null ? getLeast(current.right) :
			getGreaterParent(current);
	}
	private Node<T> getGreaterParent(Node<T> current) {
		while(current.parent != null && current == current.parent.right) {
			current = current.parent;
		}
		return current.parent;
	}
	private Node<T> getLeast(Node<T> node) {
		Node<T> current = node;
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	private Node<T> getNodeParent(T obj) {
		Node<T> current = root;
		Node<T> parent = null;
		int compRes;
		//!!!!
		while(current != null && (compRes = comp.compare(obj, current.obj)) != 0) {
			parent = current;
			current = compRes > 0 ? current.right : current.left;
		}
		return current == null ? parent : current;
	}
	private Node<T> getNode(T obj) {
		Node<T> node = getNodeParent(obj);
		Node<T> res = null;
		if (node != null && comp.compare(obj, node.obj) == 0) {
			res = node;
		}
		return res;
		
	}
	private Node<T> getParent(T obj) {
		Node<T> node = getNodeParent(obj);
		Node<T> res = null;
		if (node != null && comp.compare(obj, node.obj) != 0) {
			res = node;
		}
		return res;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		Node<T> node = getNode(pattern);
		if (node != null) {
			removeNode(node);
			//!!!
			res=true;
		}
		
		return res;
	}

	private void removeNode(Node<T> node) {
		// TODO Auto-generated method stub
		
		if (node.left != null && node.right != null) {
			removeJunction(node);		
			} else if (node.parent == null){
				removeRoot(node);
			} else {
				
			removeNonJuction(node);	
			}
	
		size--;
	
		
	}
	
	private void removeNonJuction(Node<T> node) {
		// TODO Auto-generated method stub
		
		Node<T> child = node.left == null ? node.right : node.left;
		Node<T> parent = node.parent;
		if (child != null) {
			child.parent = node.parent;
		}
		if (parent.right == node) {
			parent.right = child;
		} else {
			parent.left = child;
		}
	
	}
	
	private void removeRoot(Node<T> node) {
		// TODO Auto-generated method stub

		root = root.right == null ? root.left : root.right;
		if (root != null) {
			if (root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
	}
	
	private void removeJunction(Node<T> node) {
		// TODO Auto-generated method stub
		Node<T> subNode = getSubNode(node.left);
		
		node.obj = subNode.obj;
	
		removeNonJuction(subNode);
		
	}
	private Node<T> getSubNode(Node<T> node) {
		// TODO Auto-generated method stub
		Node<T> current = node;
		while(current.right != null) {
			current = current.right;
		}
		return current;
	}
	
	@Override
	public boolean contains(T pattern) {
		
		return getNode(pattern) != null;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new TreeSetIterator();
	}

}
