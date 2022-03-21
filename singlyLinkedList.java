

public class SinglyLinkedList {
	//node pointer to the front and tail of the list
	private static class myList {
		private int data;
		private myList next;
		
		public myList(int data) {
			this.data = data;
			this.next = null;  
		}
	}
	
//Copy Constructor
	//creates a copy of MyString
	public static myList myList(myList head) {
		if (head == null) {
			return null;
		}
		myList newer = head;  //O(1)
		return newer;
	}
	
//Remove first element
	public static myList pop_front(myList head) {
		if (head == null) {
			return null;
		}
		myList newer = head.next;
		return (newer);              //O(1)
	}
	
//Access to first element 
	public static myList front(myList head) {
		if (head == null) {
			return null;
		}
		myList first;
		first = head.next;
		head = first;
		first.next = head;    //O(1)
		return head;
	}
	

//Access to last element
	public static myList back(myList head) {
		if(head == null) {
			return head;
		}
		int lengthy = size(head);
		if (lengthy == 1) {
			myList temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		}                            //O(n*n)
		else {
			myList previous = head;
			int count = 1;
			while (count < lengthy -1) {
				previous = previous.next;
				count++;
			}
			myList current = previous.next;
			previous.next = current.next;
			current.next = null;
			return current;
		}
	}
	
	//Removes last element
		public static myList backPop(myList head) {
			if(head == null) {
				return head;
			}
			int lengthy = size(head);
			if (lengthy == 1) {
				myList temp = head;
				head = head.next;
				temp.next = null;
				return temp;
			}
			else {             //O(n*n)
				myList previous = head;
				int count = 1;
				while (count < lengthy -1) {
					previous = previous.next;
					count++;
				}
				myList current = previous.next;
				previous.next = current.next;
				current.next = null;
				return current;
			}
		}
	


//Determine if empty 
	public static void empty(myList head) {
		if (head == null) {
			//Prints Empty if no elements in myList
			System.out.println("Empty");
		}
		else 
			System.out.println("Not Empty");
	}
	
	
	
//Find out size of linked list
	public static int size(myList head) {
		if (head == null) {
			return 0;
		}
		//create variable to hold size
		int lengthy = 0;
		//loop every element and increases lengthy until the list ends
		myList current = head;
		while(current != null) {
			lengthy++;
			//next node
			current = current.next;
		}
		return lengthy;
	}

	
	
//Adds node to front of list
	public static myList addToFront(myList head, int data) {
		myList newNode = new myList(data);
		if(head == null) {
			return newNode;
		}
		newNode.next = head;
		head = newNode;
		return head; //New head (puts a new node at beginning) 
	}
	
	
	
//Adds node to end of list
	public static myList addToEnd(myList head, int data) {
		myList newNode = new myList(data);
		if(head == null) {
			return newNode;
		}
		myList current = head;
		while (null != current.next) {  //O(n)
			current = current.next;
		}
		current.next = newNode;
		return head;
	}
	
//Adds a node to given position
	public static myList insert(myList head, int data, int position) {
		//boundary checks
		int size = size(head);
		if(position > size + 1 || position < 1) {
			System.out.println("invalid position");
			return head;
		}
		
		myList newNode = new myList(data);
		if(position == 1) {
			newNode.next = head;
			return newNode;
		}
		else {
			myList previous = head;
			int count = 1;
			while(count < position - 1) {
				previous = previous.next; //O(n*n)
				count++;
			}
			myList current = previous.next;
			newNode.next = current;
			previous.next = newNode;
			return head;
		}
	}
	

	
//Given a myList, print the elements it holds
	public static void disp(myList head) {
		if (head == null) {
			return;
		}
		myList current = head;
		//loop each element till end of the list
		//last node points to null
		while (current != null) {
			System.out.print(current.data + "-->"); //print current element's data
			// moves to the next element                //O(n)
			current = current.next;
		}
		System.out.print(current); //here current will be null
	}
	
	
	
//Reverse Reverse
	public static myList reverse(myList head) {
		if (head == null) {
			return head;
		}
		myList current = head;
		myList previous = null;
		myList next = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;         //O(n)
			previous = current;
			current = next;
		}
		return previous; 
	}
	
	
	
//MAIN
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		myList head = new myList(10);
		myList second = new myList(8);
		myList third = new myList(1);
		myList fourth = new myList(5);
		
		head.next = second; // 10 --> 8 --> null
		second.next = third; // 10 --> 8 --> 1 --> null
		third.next = fourth; // 10 --> 8 --> 1 --> 5 --> null
		
		System.out.println("Created A linked List: ");
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		SinglyLinkedList.disp(head);
		
		System.out.println();
		System.out.println();
		
		
		//New node at head of linked list
		System.out.println("Created a new node at front of linked list: ");
		myList newHead = SinglyLinkedList.addToFront(head, 15);
		SinglyLinkedList.disp(newHead);
		
		System.out.println();
		
		
		//Remove value at tail
		System.out.println("Value at tail removed!!!");
		SinglyLinkedList.back(newHead);
		SinglyLinkedList.disp(newHead);
		
		System.out.println();
		
		//Access to last item
		System.out.println("Access to the last item granted :) It is: ");
		myList last = SinglyLinkedList.back(newHead);
		System.out.println(last.data);
		
		//New node at end of linked list
		System.out.println("Created a new node at end of linked list: ");
		myList newItem = SinglyLinkedList.addToEnd(newHead, 3);
		SinglyLinkedList.disp(newHead);
		
		System.out.println();
		
		//Add to given position
		System.out.println("Inserted new node to given position of linked list: ");
		head = SinglyLinkedList.insert(newItem, 16, 2);
		SinglyLinkedList.disp(head);
		
		//System.out.pring("Length of Linked List is - " + singlyLinkedList.length(head));
		
		System.out.println();
		
		//Reverse List
		System.out.println("Reversed the linked list: ");
		myList reverseListHead = SinglyLinkedList.reverse(head);
		SinglyLinkedList.disp(reverseListHead);
		
		System.out.println();
		
		//System.out.println("front: ");
		//SinglyLinkedList.disp(reverseListHead);
		//System.out.println();
		//myList fronter = SinglyLinkedList.front(reverseListHead);
		//SinglyLinkedList.disp(fronter);
		
	}
//END OF MAIN


	
	
	
}
