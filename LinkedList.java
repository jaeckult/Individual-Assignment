package assignment;

public class LinkedList {
	public static void main(String[] args) {
		// Test Linked List
		LL linkedList = new LL();

		linkedList.insertAtPos(10, 1);
		linkedList.insertAtPos(20, 2);
		linkedList.insertAtPos(30, 3);

		System.out.println("Linked List after insertions:");
		printLinkedList(linkedList.head);

		linkedList.deleteAtPosition(2);

		System.out.println("Linked List after deletion at position 2:");
		printLinkedList(linkedList.head);

		// Test Stack
		Stack stack = new Stack();

		stack.push(50);
		stack.push(60);

		System.out.println("Top element of stack: " + stack.peek());

		stack.pop();

		System.out.println("Top element of stack after pop: " + stack.peek());
	}

	public static void printLinkedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LL {
	Node head;

	public void insertAtPos(int data, int position) {
		Node new_node = new Node(data);

		if (position == 1) {
			new_node.next = head;
			head = new_node;
			return;
		}

		Node current = head;
		for (int i = 1; i < position - 1 && current != null; i++) {
			current = current.next;
		}

		if (current == null) {
			System.out.println("Position out of range");
			return;
		}

		new_node.next = current.next;
		current.next = new_node;
	}

	public void deleteAtPosition(int position) {
		if (head == null) {
			return;
		}

		Node temp = head;

		if (position == 1) {
			head = temp.next;
			temp = null;
			return;
		}

		for (int i = 1; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}

		if (temp == null || temp.next == null) {
			return;
		}

		Node next_node = temp.next.next;
		temp.next = null;
		temp.next = next_node;
	}

	public void deleteAfterNode(Node node) {
		if (node == null || node.next == null) {
			return;
		}

		Node node_to_delete = node.next;
		node.next = node_to_delete.next;
		node_to_delete = null;
	}

	public int searchNode(int value) {
		Node current = head;
		int position = 1;

		while (current != null) {
			if (current.data == value) {
				return position;
			}
			position++;
			current = current.next;
		}

		return -1;
	}
}

class Stack {
	Node head;

	public void push(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	public int pop() {
		if (head == null) {
			return -1;
		}

		int data = head.data;
		head = head.next;
		return data;
	}

	public int peek() {
		if (head == null) {
			return -1;
		}

		return head.data;
	}
}