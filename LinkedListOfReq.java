
public class LinkedListOfReq {
	private Node head;
	private Node current;

	public LinkedListOfReq() {
		head = current = null;
	}

	public void findFirst() {
		current = head;
	}
	
	// check this
	
	public void setCurrent(Node s) {
		current = s;
	}
	
	public Node getCuurent() {
		return current;
	}

	public void findNext() {
		current = current.next;
	}

	public String[] retrieve() {
		return current.data;
	}

	public void update(String[] e) {
		current.data = e;
	}

	public void insert(String[] e) {
		Node tmp;

		if (empty()) {
			head = current = new Node(e);
		} else {
			tmp = current.next;
			current.next = new Node(e);
			current = current.next;
			current.next = tmp;
		}

	}

	public void remove() {
		if (head == current) {
			head = head.next;
		} else {
			Node tmp = head;

			while (tmp.next != current) {
				tmp = tmp.next;
			}
			tmp.next = current.next;
		}
		if (current.next == null) {
			current = head;
		} else {
			current = current.next;
		}

	}

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null ? true : false;
	}

	public boolean last() {
		return current.next == null ? true : false;
	}

//	public void print() {
//		current = head;
//		while (current != null) {
//
//			for (int i = 0; i < current.data.length; i++) {
//				System.out.print(current.data[i]);
//			}
//			current = current.next;
//		}
//		current = head;
//
//	}

	public int findSize() {
		current = head;
		int max = Integer.parseInt(current.data[0].substring(1));
		while (current != null) {
			for (int i = 0; i < current.data.length; i++) {
				if (Integer.parseInt(current.data[i].substring(1)) > max) {
					max = Integer.parseInt(current.data[i].substring(1));
				}
			}
			current = current.next;
		}
		current = head;
		return max;
	}
}
