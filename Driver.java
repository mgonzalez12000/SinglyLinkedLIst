package linkedlist;

// 0, false, true, true

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A) Create a list with no nodes
		System.out.println("Part A: ");
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		//Display that there is no index in the list that was created
		System.out.println(list.size());

		// B) A list with nodes but no cycles
		System.out.println("Part B: ");
		SinglyLinkedList<String>list2 = new SinglyLinkedList<String>();
		list2.add("Hello");
		list2.add("My");
		list2.add("name");
		list2.add("is");
		list2.add("Slim");
		list2.add("Shady");
		System.out.println(list2.hasCycle());

		// C) A list with only one node with its next reference set to itself
		System.out.println("Part C: ");
		SinglyLinkedList<String>list3 = new SinglyLinkedList<String>();
		list3.add("Computers");
		list3.addToCreateCycle(list3.getNode(0));
		System.out.println("Since the node's next reference is set to itself, " + list3.hasCycle());

		/* D) A list with a cycle whose length (number of nodes involved in
			   the cycle) is odd
		 */
		System.out.println("Part D: ");
		SinglyLinkedList<String>list4 = new SinglyLinkedList<String>();
		list4.add("Phone");
		list4.add("Laptop");
		list4.add("Tablet");
		list4.add("Playstation 5");
		list4.add("Stereo");
		//This makes the list a cycle
		list4.addToCreateCycle(list4.getNode(0));
		System.out.println(list4.hasCycle());

		// E) A list with a cycle whose length is even
		System.out.println("Part E: ");
		SinglyLinkedList<String>list5 = new SinglyLinkedList<String>();
		list5.add("Phone");
		list5.add("Laptop");
		list5.add("Tablet");
		list5.add("Stereo");
		list4.addToCreateCycle(list5.getNode(0));
		System.out.println(list5.hasCycle());
	}
}
