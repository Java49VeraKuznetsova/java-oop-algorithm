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
	private Node<T> getGreatest(Node<T> node) {
		Node <T> current = node;
		while (current.right!= null) {
			current = current.right;
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
		}
		
		return res;
	}

	private void removeNode(Node<T> node) {
		// TODO Auto-generated method stub
		int res = comp.compare(node.obj, node.parent.obj);
		if (node.left != null && node.right != null) {
			removeJunction(node, res);		
			} else if (node.right != null) {
				removeRight(node, res);
			} else if (node.left != null) {
				removeLeft(node, res);
			} else {
				removeEnd(node, res);
			}
		size--;
		node = null;
		
	}
	private void removeJunction(Node<T> node, int res) {
		// TODO Auto-generated method stub
		Node <T> newJunction = getGreates(node.left);
		Node <T> toRemove = newJunction;
		newJunction.parent = node.parent;
		newJunction.left = node.left;
		newJunction.right = node.right;
		removeNode(toRemove);
			}
	
	private Node<T> getGreates (Node<T> node) {
		Node<T> current = node;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}
	
	
	
	
	private void removeLeft(Node<T> node, int res) {
		// TODO Auto-generated method stub
         if (res < 0) {
			node.parent.left = node.left;
		} else {
			//TODO
			node.parent.right = node.left;
		}
        
	}
	private void removeRight(Node<T> node, int res) {
		// TODO Auto-generated method stub
		if (res < 0) {
			//TODO
			node.parent.left = node.right;
		} else {
			node.parent.right = node.right;
		}
		
		
	}
	private void removeEnd(Node<T> node, int res) {
		// TODO Auto-generated method stub
		if (res < 0) {
			node.parent.left = null;
		} else {
			node.parent.right = null;
		}
		
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
