package linkedlist;

// heavily adapted from http://www.crunchify.com/a-simple-singly-linked-list-implementation-in-java/
public class SinglyLinkedList<T> {
	protected Node<T> head, tail;
	protected long size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(T element) {
		Node<T> node = new Node<T>(element);
		addFirst(node);
	}

	public void addFirst(Node<T> node) {
		if (tail == null)
			tail = node;
		node.setNext(head);
		head = node;
		size++;
	}

	public void add(T element) {
		Node<T> node = new Node<T>(element);
		if (tail == null)
			addFirst(node);
		else
			add(node);
	}

	public void add(Node<T> nodeToAdd) {
		nodeToAdd.setNext(null);
		if (tail == null) {
			tail = nodeToAdd;
			head = nodeToAdd;
		} else
			tail.setNext(nodeToAdd);
		tail = nodeToAdd;
		size++;
	}
	
	public void removeFirst() {
		if (head == null)
			return;
		Node<T> temp = head;

		head = head.getNext();
		temp.setNext(null);
		size--;
	}
	
	public void removeLast() {
		Node<T> nodeBefore;

		if (size == 0)
			return;
		nodeBefore = head;

		for (int count = 0; count < size - 2; count++)
			nodeBefore = nodeBefore.getNext();
		nodeBefore.setNext(null);
		tail = nodeBefore;
		size--;
	}
	

	
	public void remove(T element) {
		if (size == 0)
			return;
		Node<T> currNode = head;
		do {
			if (currNode.getElement().equals(element)) {

				if (currNode == head) {
					removeFirst();
					currNode = head;
				} else if (currNode == tail) {
					removeLast();
					currNode = tail;
				} else {
					Node<T> next = currNode.getNext();
					remove(currNode);
					currNode = next;
				}
			} else
				currNode = currNode.getNext();
		} while (currNode != null);

	}

	public void remove(Node<T> nodeToRemove) {
		Node<T> nodeBefore, currentNode;
		if (size == 0)
			return;

		currentNode = head;
		if (currentNode == nodeToRemove)
			removeFirst();
		currentNode = tail;
		if (currentNode == nodeToRemove)
			removeLast();

		if (size - 2 > 0) {
			nodeBefore = head;
			currentNode = head.getNext();
			for (int count = 0; count < size - 2; count++) {
				if (currentNode == nodeToRemove) {
					nodeBefore.setNext(currentNode.getNext());
					size--;
					break;
				}

				nodeBefore = currentNode;
				currentNode = currentNode.getNext();
			}
		}
	}

	public T get(int index) {
		Node<T> currNode = head;
		if (index >= size)
			return null;
		for (int counter = 0; counter < index; counter++)
			currNode = currNode.getNext();
		return currNode.getElement();
	}

	public Node<T> getNode(int index) {
		Node<T> currNode = head;
		if (index >= size)
			return null;
		for (int counter = 0; counter < index; counter++) {
			
			currNode = currNode.getNext();
		}
		return currNode;
	}

	public long size() {
		return size;
	}

	public Node<T> getTail() {
		return tail;
	}
	
	public boolean contains(T element) {
		if (head == null)
			return false;
		Node<T> currNode = head;
		while (currNode.getNext() != null) {
			if (currNode.getElement().equals(element))
				return true;
			currNode = currNode.getNext();
		}
		if (currNode.getElement().equals(element))
			return true;
		return false;
	}
	
	/*Add a method public void addToCreateCycle(Node<T> nodeToAdd) 
	that allows the user to add a Node in a way that will create a cycle.
	*/
	
	public void addToCreateCycle(Node<T> nodeToAdd) {
		nodeToAdd.setNext(head);
		//
		nodeToAdd = head;
	}
	
	/* Write a boolean method in the list code that determines whether a 
	cycle exits in the list. You do not need to determine where a cycle 
	starts, only whether one is present.
	*/
	
	boolean hasCycle () {
		Node<T> slow = head;
		Node <T> fast = head;
		while (fast != null && fast.getNext() != null && slow != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			//if fast and slow pointers are meeting LinkedList is cycle
			if(fast == slow) 
				return true;
		}
		return false;
	}
}