package NewPackage;

public class LinkedList {

	Node head; 
	static class Node {

		int data;
		Node link;

		Node(int data)
		{
			this.data = data;
			link = null;
		}
	}

	public static LinkedList add(LinkedList list, int data)
	{
		Node nn1 = new Node(data);
		nn1.link = null;

		//in case LL is empty
		if (list.head == null) {
			list.head = nn1;
		}
		else {  //append
			Node last = list.head;
			while (last.link != null) {
				last = last.link;
			}
			last.link = nn1;
		}
		return list;
	}

	public static void printt(LinkedList list)
	{
		Node n = list.head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.link;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList lst = new LinkedList();

		lst = add(lst, 10);
		lst = add(lst, 20);
		lst = add(lst, 5);
		lst = add(lst, 40);
		lst = add(lst, 15);
		lst = add(lst, 60);

		System.out.print("Elements in Linked list: ");
		printt(lst);
	}
}
