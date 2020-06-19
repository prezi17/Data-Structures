
//// A linked list node
//class Node
//{
//	int data;
//	Node next;
//
//	Node(int data, Node next) {
//		this.data = data;
//		this.next = next;
//	}
//};

class Main {

	// class node starts
	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node() {

		}

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getelement() {
			return element;
		}

		public Node getnext() {
			return next;
		}

		public void setnext(Node<E> n) {
			next = n;
		}

	}
	// end of nested class node

	/*
	 * Split the nodes of the given list into two halves, and return the two lists
	 * using an array. If the length is odd, the extra node should go in the front
	 * list. It uses the fast/slow reference strategy
	 */
	public static Node[] FrontBackSplit(Node L) {
		Node frontL1, backL2;

		// if length is less than 2, handle separately
		if (L == null || L.next == null) {
			frontL1 = L;
			backL2 = null;
			return new Node[] { frontL1, backL2 };
		}
		Node slow = L;
		Node fast = L.next;
		// Fast moves two nodes, and 'slow' moves by one node
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		// 'slow' is before the midpoint in the list, so split it in two
		// at that point.
		frontL1 = L; // it point to the beginning of the original 2n list
		backL2 = slow.next; // pointer at the element next to mid point. as such in case the lenght is odd								
		slow.next = null;    // extra element goes o the first list.
		return new Node[] { frontL1, backL2 };
	}

	// Helper function to print given linked list
	public static void printList(String msg, Node head) {
		System.out.print(msg);

		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.element + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

	public static void main(String[] args) {
		// input keys
		int[] keys = { 6, 3, 4, 8, 2, 9 };

		// points to the head node of the linked list
		Node head = null;

		// construct linked list
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		Node[] nodes = FrontBackSplit(head);

		// print linked list
		printList("Front List : ", nodes[0]);
		printList("Back List : ", nodes[1]);
	}
}