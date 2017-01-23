package Lintcode.LinkList;

//Class LinkedList - IMPLEMENT the 4 methods
//Your list should be consistent at the return of every call.
//Add any member variables or methods you need
//NOTE: any method defined can call any other method defined
public class PlayStation_My_LinkedList {
	// Class Node - DO NOT MODIFY
	// NOTE: you can compare nodes using the == operator
	// DO NOT worry about a .equals() method
	public static class Node {
		public Node next;
		public Node prev;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node head;// points to first node
	Node tail; // points to the last node

	PlayStation_My_LinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		head.prev = tail;
		tail.next = head;
	}

	// addNodeToList() - add the inputted node to the end of the list
	// - if the node is already in the list, move it to the end
	// - HINT moving a node to the end is the same as removing and adding to the
	// end
	public void addNodeToList(Node toAdd) {
		if (toAdd == null)
			return;

		if (head.next != tail) {
			Node curr = head;
			Node next = head.next;
			while (next != tail) {
				if (next == toAdd) {
					// remove the node
					curr.next = next.next;
					next.next.prev = curr;
					break;
				}
				curr = next;
				next = next.next;
			}
			// add to the end
			tail.prev.next = next;
			next.prev = tail.prev;
			next.next = tail;
			tail.prev = next;

		} else {
			// if list is empty, add node
			head.next = toAdd;
			toAdd.prev = head;
			toAdd.next = tail;
			tail.prev = toAdd;
		}
	}

	// removeNode() - remove the inputted node
	// - if the node is not in the list do nothing
	public void removeNode(Node toRemove) {
		if (toRemove == null)
			return;
		if (head.next == tail)
			return;
		Node curr = head;
		Node next = head.next;
		while (next != tail) {
			if (next == toRemove) {
				// remove the node
				curr.next = next.next;
				next.next.prev = curr;
				break;
			}
			curr = next;
			next = next.next;
		}
		return;
	}

	// popNodeFromStart() - remove the node at the start of the list and return
	// it
	public Node popNodeFromStart() {
		if (head.next == tail)
			return null;
		Node node = head.next;
		head.next = node.next;
		head.next.prev = head;
		return node;

	}

	// popNodeFromEnd() - remove the node at the end of the list and return it
	public Node popNodeFromEnd() {
		if (head.next == tail)
			return null;
		Node node = tail.prev;
		node.prev.next = tail;
		tail.prev = node.prev;
		return node;
	}

}
