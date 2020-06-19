import shuffle.SingleLinkedList.Node;

public class LinkedList<E> {
	
	
	// class node starts
	private static class Node<E> { 
		private E element;
		private Node<E> next;
		
		public Node() {
			
		}
		
		public Node(E e , Node<E> n)
		{
			element=e;
			next= n;
		}
		
		public E getelement ()
		{
			return element;
		}
		public Node getnext() {
			return next;	
		}
		
		public void setnext(Node<E> n)
		{
			next=n;
		}
		
		
		
	}
// end of nested class node
	
	private Node<E> head = null;
	public Node<E> tail = null;
	private int size=0;
	 
	public LinkedList() {
		
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getelement();
	}
	public E last() {
		if(isEmpty()) {
			return null;
						}
		return tail.getelement();
		}
	public void insert(E element) {
		Node<E> node= new Node<E>();
		node.element=element;
		node.next=null;
		if(head==null)
		{
			head=node;
		}
		else {
			Node<E> n =head;
			while(n.next !=null)
			{
				n=n.next;
			}
			n.next=node;
		}
		
	}
	public void show()
	{
		Node<E> node= head;
		while(node.next !=null)
		{
			System.out.println(node.element);
			node=node.next;
		}
		System.out.println(node.element);
	}
	
	
	
	public static void printList( Node head)
	{
		//System.out.print(msg);

		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

	
	
	public static void main (String[] args) {
		
		LinkedList<Integer> list1 =  new LinkedList<Integer>();
		list1.insert(2);
		list1.insert(5);
		list1.insert(21);
		list1.insert(15);
		list1.show();
		System.out.println( " last  value : \n" + list1.last() );
		System.out.println( " first  value : \n" + list1.first() + " indirect way   " + list1.head.getelement());
		
		}
}
